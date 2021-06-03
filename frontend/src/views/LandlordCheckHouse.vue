<template>
  <div>
    <LandlordNavbar />
    <slider-navigation class="cp">
      <swiper-slide v-for="slide in slides" :key="slide">
        <div class="column has-text-centered fillSpace">
          <img class="imgSlide" object-fit="cover" :src="slide" :alt="slide" />
        </div>
      </swiper-slide>
    </slider-navigation>
    <div
      class="columns is-centered is-vcentered is-mobile is-tablet is-desktop is-multiline"
    >
      <div class="column is-11-mobile is-11-tablet is-11-desktop">
        <div id="checkhouse-card">
          <div class="block">
            <div class="columns is-centered is-mobile is-tablet is-desktop">
              <div
                class="column is-one-quarter-mobile is-one-quarter-tablet is-one-quarter-desktop"
              >
                <div class="box custom-height-info">
                  <p class="title has-text-centered is-one-third">Main Info</p>
                  <div
                    class="columns has-text-centered is-centered is-vcentered is-mobile is-tablet is-desktop"
                  >
                    <div
                      class="column is-half-mobile is-half-tablet is-half-desktop"
                    >
                      <button class="button inf is-green is-static is-rounded">
                        T{{ formData.rooms }}
                      </button>

                      <button class="button inf is-green is-static is-rounded">
                        From {{ formData.minPrice }}€ To
                        {{ formData.maxPrice }}€
                      </button>
                    </div>
                    <div
                      class="column is-half-mobile is-half-tablet is-half-desktop"
                    >
                      <button class="button inf is-green is-static is-rounded">
                        {{ formData.bathRooms }} WC's
                      </button>

                      <button class="button inf is-green is-static is-rounded">
                        Available Rooms: {{ formData.availableRooms }}
                      </button>
                    </div>
                  </div>
                  <p class="title has-text-centered is-one-third">Features</p>
                  <div id="scroll-area">
                    <smooth-scrollbar>
                      <div
                        class="columns has-text-centered is-centered is-vcentered is-mobile is-tablet is-desktop"
                      >
                        <div
                          class="column is-half-mobile is-half-tablet is-half-desktop"
                        >
                          <button
                            v-for="feature in featuresLeft"
                            :key="feature"
                            class="button inf is-green is-static is-rounded"
                          >
                            {{ feature }}
                          </button>
                        </div>
                        <div
                          class="column is-half-mobile is-half-tablet is-half-desktop"
                        >
                          <button
                            v-for="feature in featuresRight"
                            :key="feature"
                            class="button inf is-green is-static is-rounded"
                          >
                            {{ feature }}
                          </button>
                        </div>
                      </div>
                    </smooth-scrollbar>
                  </div>
                </div>
              </div>

              <div class="column is-half-mobile is-half-tablet is-half-desktop">
                <div class="box">
                  <div class="content has-text-centered">
                    <h3 class="title">
                      {{formData.title}}
                    </h3>
                  </div>
                </div>
                <div class="box">
                  <p class="title has-text-centered is-one-third">
                    Description
                  </p>
                  <div class="content has-text-justified">
                    <p>
                      {{formData.description}}
                    </p>
                  </div>
                </div>
              </div>

              <div
                class="column is-one-quarter-mobile is-one-quarter-tablet is-one-quarter-desktop"
              >
                <div class="box mb custom-height-info has-text-centered">
                  <div class="card llcard has-text-centered">
                    <div class="title is-4 ll">Landlord</div>
                    <div
                      class="columns is-centered is-mobile is-tablet is-desktop"
                    >
                      <div class="column is-one-quarter">
                        <figure class="image avatar">
                          <img
                            id="profile-pic"
                            class="is-rounded"
                            :src="llPic"
                          />
                        </figure>
                      </div>
                      <div class="column is-three-quarters has-text-centered">
                        <div class="label lname">
                          {{ llName }}
                        </div>
                        <a
                          class="button is-green"
                          :href="(myId==llId)?'/landlord/profile':'/landlord/llprofile/'+llId"
                          >View Profile</a
                        >
                      </div>
                    </div>
                  </div>
                  <div v-if="tenantInfo.length!==0" class="title is-4 ll">Tenants:</div>
                  <ZDMCarousel :id="teste" :cards="tenantInfo" />
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { SwiperSlide } from "vue-awesome-swiper";
import LandlordNavbar from "@/components/LandlordNavbar.vue";
import SliderNavigation from "@/components/SliderNavigation.vue";
import ZDMCarousel from "@/components/ZDMCarousel.vue";
import axios from "axios";
import store from "@/store";
import { url as api_url } from "@/assets/scripts/api";

export default {
  methods: {
    async getTenantsInHouse(hid) {
      await axios
        //TODO por intervalo de tempo
        .get(api_url + "/api/houses/" + hid + "/tenants")
        .then((res) => {
          this.tenantInfo = [];
          for (var t = 0; t < res.data.length; t++)
            this.tenantInfo.push({
              ppic: `${api_url}/api/tenants/${res.data[t].id}/avatar`,
              name: res.data[t].name,
              id: res.data[t].id,
              link: "/landlord/tprofile/"+res.data[t].id
            });
          this.teste++;
        })
        .catch((ex) => {
          console.log(ex);
        });
    },
    async apply() {
      if (this.buttonText !== "Already Applied") {
        var sendApplication = {
          houseId: this.$route.params.id,
        };
        console.log(JSON.stringify(sendApplication));

        await axios
          .post(api_url + "/api/applications/", sendApplication)
          .then(() => {
            console.log("done");
          })
          .catch((e) => {
            alert(e);
          });
      }
      this.buttonText = "Already Applied";
    },
  },
  created() {
    axios
      .get(api_url + "/api/houses/" + this.id)
      .then((response) => {
        this.formData = response.data;
        var features = this.formData.features.split(",");
        const half = Math.ceil(features.length / 2);
        this.featuresLeft = features.splice(0, half);
        this.featuresRight = features.splice(-half);
        (this.llPic = `${api_url}/api/landlords/${this.formData.landlord.id}/avatar`),
          (this.llName = this.formData.landlord.name),
          (this.llId = this.formData.landlord.id),
          this.getTenantsInHouse(this.id);
        this.slides = [];
        for (var i in this.formData.photos)
          this.slides.push(
            `${api_url}/api/houses/photos/${this.formData.photos[i]}`
          );
      })
      .catch((e) => {
        console.log(e);
      });
  },
  data() {
    return {
      llPic: "",
      myId: store.getters.getId,
      llName: undefined,
      llId: undefined,
      featuresLeft: [],
      featuresRight: [],
      formData: {},
      id: this.$route.params.id,
      buttonText: "Apply for House",
      slides: [],

      tenantInfo: [],
    };
  },

  name: "Lanlord Check House",

  components: {
    SwiperSlide,
    LandlordNavbar,
    SliderNavigation,
    ZDMCarousel,
  },
};
</script>

<style scoped>

.cp {
  width: 70%;
}
.fillSpace {
  margin: 0;
  padding: 0;
}
.llcard {
  width: 90%;
  margin: 1% auto;
}
.mb {
  padding: 1px;
}
.ll {
  margin: 5% auto 0% auto;
}
.inf {
  margin: 1% auto 1% auto;
  width: 100%;
}
.lname {
  margin: 5% auto;
}
#content {
  margin: 3% auto 2% auto;
  width: 100%;
}
.imgSlide {
  margin: 0 auto;
  width: auto;
  height: 33vh;
}
.avatar {
  width: 5vmax;
  height: 5vmax;
  position: relative;
  display: block;
  margin: 15% auto 8% auto;
}
#scroll-area-1 {
  height: 34vh;
}

#scroll-area-2 {
  height: 58vh;
  margin-bottom: 10px;
}

.price-range {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
}

.spacer {
  width: 5px;
}

.vm {
  width: 25%;
  min-width: 70px;
}

.bordera {
  background-color: lightseagreen;
}

.borderb {
  background-color: pink;
}

.borderc {
  background-color: orange;
}

.custom-height {
  min-height: 40vh;
}

.custom-height-info {
  min-height: 50vh;
}
#profile-pic {
  position: absolute;
  object-fit: cover;
  object-position: center;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  margin: 0% 40%;
  width: 100%;
  height: 100%;
}

#scroll-area {
  margin: 2% auto;
  width: 100%;
  height: 20vh;
}
</style>