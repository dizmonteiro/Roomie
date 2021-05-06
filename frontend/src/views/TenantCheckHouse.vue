<template>
  <div>
    <TenantNavbar />
    <slider-navigation>
      <swiper-slide v-for="slide in slides" :key="slide">
        <img class="imgSlide" object-fit="cover" :src="slide" :alt="slide" />
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
                class="column is-one-fourth-mobile is-one-fourth-tablet is-one-fourth-desktop"
              >
                <div class="box custom-height">
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
                <div class="box custom-height">
                  <p class="title has-text-centered is-one-third">
                    Description
                  </p>
                  <div class="content has-text-justified">
                    <p>
                      {{ formData.description }}
                    </p>
                  </div>
                </div>
              </div>

              <div
                class="column is-one-fourth-mobile is-one-fourth-tablet is-one-fourth-desktop"
              >
                <div class="box custom-height">
                  <ZDMCarousel :cards="cards" />
                </div>
              </div>
            </div>
          </div>

          <div class="block">
            <div class="buttons is-centered">
              <a class="button is-large is-green is-rounded vm" @click="apply">
                {{ buttonText }}
              </a>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { SwiperSlide } from "vue-awesome-swiper";
import TenantNavbar from "@/components/TenantNavbar.vue";
import SliderNavigation from "@/components/SliderNavigation.vue";
import ZDMCarousel from "@/components/ZDMCarousel.vue";
import axios from "axios";
import store from "@/store";
import { url as api_url } from "@/assets/scripts/api";

export default {
  methods: {
    async apply() {
      if (this.buttonText !== "Already Applied") {
        var sendApplication = {
          tenantId: store.getters.getId,
          accept: false,
        };

        await axios
          .put(
            api_url + "/api/applications/" + this.$route.params.id,
            sendApplication
          )
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
        this.cards = [
          {
            headline: this.formData.landlord.name,
            text: "962956721",
            link: "/tenant/llprofile/" + this.formData.landlord.id,
            imgName1: `${api_url}/api/landlords/${this.formData.landlord.id}/avatar`,
            imgName2: "landlord.svg",
          },
        ];
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
      featuresLeft: [],
      featuresRight: [],
      formData: {},
      id: this.$route.params.id,
      buttonText: "Apply for House",
      slides: [],

      cards: [],
    };
  },

  name: "Tenant Check House",

  components: {
    SwiperSlide,
    TenantNavbar,
    SliderNavigation,
    ZDMCarousel,
  },
};
</script>

<style scoped>
.inf {
  margin: 1% auto 1% auto;
  width: 100%;
}
#content {
  margin: 3% auto 2% auto;
  width: 100%;
}
.imgSlide {
  width: 100%;
  height: 40vh;
}
#checkhouse-card {
  min-height: 80vh;
  margin-top: 2%;
  margin-bottom: 5%;
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

#scroll-area {
  margin: 2% auto;
  width: 100%;
  height: 10vh;
}
</style>