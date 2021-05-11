<template>
  <div>
    <div v-if="type === 'tenant'">
      <TenantNavbar />
    </div>
    <div v-else>
      <landlord-navbar />
    </div>

    <div id="llcard" class="card pad">
      <div class="columns is-desktop">
        <div
          class="column adjust-hero-s is-one-quarter-desktop is-full-mobile is-full-tablet"
        >
          <figure class="image avatar">
            <img
            id="profile-pic"
              class="is-rounded"
              :src="`${url}/api/landlords/${id}/avatar`"
            />
          </figure>
          <div class="control">
            <div class="box adjust-gender">
              <label class="label gender-label">Gender</label>
              <label class="radio gender">
                <input
                  type="radio"
                  name="gender"
                  value="female"
                  disabled
                  :checked="isFemale"
                />
                Female
              </label>
              <label class="radio gender">
                <input
                  type="radio"
                  name="gender"
                  value="male"
                  disabled
                  :checked="isMale"
                />
                Male
              </label>
              <label class="radio gender">
                <input
                  type="radio"
                  name="gender"
                  value="other"
                  disabled
                  :checked="isOther"
                />
                Other
              </label>
            </div>
          </div>
        </div>
        <div
          class="column adjust-hero-s is-half-desktop is-full-mobile is-full-tablet form"
        >
          <div class="field">
            <label class="label">Name</label>
            <div class="control">
              <input
                class="input"
                type="text"
                :value="formData.name"
                name="name"
                readonly
              />
            </div>
          </div>
          <div class="columns">
            <div class="column is-half">
              <div class="field">
                <label class="label">Email</label>
                <div class="control is-expanded">
                  <input
                    class="input"
                    type="email"
                    :value="formData.email"
                    name="email"
                    readonly
                  />
                </div>
              </div>
              <div class="field">
                <label class="label">Phone Number</label>
                <p class="control">
                  <input
                    class="input"
                    type="tel"
                    :value="formData.phone"
                    name="phone"
                    readonly
                  />
                </p>
              </div>
            </div>
            <div class="column is-half">
              <div class="field">
                <label class="label">Username</label>
                <div class="control">
                  <input
                    class="input"
                    type="text"
                    :value="formData.username"
                    name="username"
                    readonly
                  />
                </div>
              </div>
              <div class="field">
                <label class="label">Birth Date</label>
                <div class="control is-expanded">
                  <input
                    class="input"
                    type="date"
                    :value="formData.birthDate"
                    name="dob"
                    readonly
                  />
                </div>
              </div>
            </div>
          </div>
        </div>
        <div
          class="column adjust-hero is-one-quarter-desktop is-full-mobile is-full-tablet has-text-centered"
        >
          <SideMenuEditable title="Houses">
            <div v-for="house in houseData" :key="house.i">
              <br />
              <SideMenuEntry
                :imgSource="house.img"
                :args="[
                  {
                    k1: 'house_name',
                    v1: house.title,
                    k2: 'house_location',
                    v2: house.address,
                    k3: 'house_slot',
                    v3: house.slots,
                  },
                ]"
              />
            </div>
            <br />
          </SideMenuEditable>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import TenantNavbar from "@/components/TenantNavbar";
import SideMenuEditable from "@/components/SideMenuEditable";
import SideMenuEntry from "@/components/SideMenuEntry";
import { mapGetters, mapState } from "vuex";
import LandlordNavbar from "@/components/LandlordNavbar.vue";
import axios from "axios";
import { url as api_url } from "@/assets/scripts/api";

export default {
  name: "LandlordProfileCheck",
  components: {
    TenantNavbar,
    SideMenuEditable,
    SideMenuEntry,
    LandlordNavbar,
  },
  data() {
    return {
      isMale: false,
      isFemale: false,
      isOther: false,
      id: this.$route.params.id,
      editable: true,
      edit_text: "Edit",
      modal_active: "modal",
      url: api_url,
      formData: {},
      houseData: {},
    };
  },
  created() {
    axios
      .get(api_url + "/api/landlords/" + this.id)
      .then((response) => {
        this.formData = response.data;
        switch (this.formData.sex) {
          case "male":
            this.isMale = true;
            break;
          case "female":
            this.isFemale = true;
            break;
          case "other":
            this.isOther = true;
            break;
          default:
            console.log(this.formData.sex);
            break;
        }
        axios
          .get(api_url + "/api/landlords/" + this.id + "/houses")
          .then((res) => {
            this.houseData = res.data.splice(0, 3);
            for (var i = 1; i <= this.houseData.length; i++) {
              this.houseData[i - 1].i = i;
              this.houseData[i - 1].img = `${api_url}/api/houses/photos/${
                this.houseData[i - 1].photos[0]
              }`;
              this.houseData[i - 1].slots =
                "Slots: " +
                this.houseData[i - 1].availableRooms +
                "/" +
                this.houseData[i - 1].rooms;
            }
          })
          .catch((e) => {
            console.log(e);
          });
      })
      .catch((e) => {
        console.log(e);
      });
  },
  computed: {
    ...mapGetters(["getType"]),
    ...mapState({
      type: (state) => `${state.user.type}`,
    }),
  },
};
</script>


<style scoped>
strong {
  color: white;
}
.avatar {
  width: 20vw;
  height: 20vw;
  position: relative;
  display: block;
  margin: 5% auto 8% auto;
}
#profile-pic {
  position: absolute; 
  object-fit: cover;
  object-position: center;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  width: 100%;
  height: 100%;
}
label {
  display: block;
}
.gender {
  margin: auto 22%;
}
.adjust-gender {
  width: 50%;
  margin: 0 auto;
}
.gender-label {
  text-align: center;
  margin: 0 auto 10% auto;
}
.bs {
  background-color: #2d6a4f;
}

.pad {
  width: 90%;
  margin: 5% auto;
}

.form {
  margin: 10% auto;
}
</style>