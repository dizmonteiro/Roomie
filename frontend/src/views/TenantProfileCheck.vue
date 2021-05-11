<template>
  <div>
    <div v-if="type === 'tenant'">
      <TenantNavbar />
    </div>
    <div v-else-if="type === 'landlord'">
      <landlord-navbar />
    </div>
    <div id="llcard" class="card pad">
      <div class="columns is-desktop">
        <div class="column is-one-third-desktop is-full-mobile is-full-tablet">
          <figure class="image avatar">
            <img
            id="profile-pic"
              class="is-rounded"
              :src="profilePic"
            />
          </figure>
          <div class="control">
            <div class="box adjust-gender">
              <label class="label gender-label">Gender</label>
              <label class="radio gender">
                <input type="radio" name="gender" value="female" :checked="isFemale" disabled />
                Female
              </label>
              <label class="radio gender">
                <input type="radio" name="gender" value="male" :checked="isMale" disabled />
                Male
              </label>
              <label class="radio gender">
                <input type="radio" name="gender" value="other" :checked="isOther" disabled />
                Other
              </label>
            </div>
          </div>
        </div>
        <div
          class="column is-two-thirds-desktop is-full-mobile is-full-tablet form"
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
              <div class="field">
                <label class="label">Nationality</label>
                <div class="control">
                  <input
                    class="input"
                    type="text"
                    :value="formData.nationality"
                    name="ocupation"
                    readonly
                  />
                </div>
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
              <div class="field">
                <label class="label">Occupation</label>
                <div class="control">
                  <input
                    class="input"
                    type="text"
                    :value="formData.occupation"
                    name="ocupation"
                    readonly
                  />
                </div>
              </div>
            </div>
          </div>
          <check-rates />
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import TenantNavbar from "@/components/TenantNavbar";
import { mapGetters, mapState } from "vuex";
import CheckRates from "../components/CheckRates.vue";
import LandlordNavbar from "../components/LandlordNavbar.vue";
import axios from "axios";
import { url as api_url } from "@/assets/scripts/api";

export default {
  name: "TenantProfile",
  components: {
    TenantNavbar,
    CheckRates,
    LandlordNavbar,
  },
  created() {
    axios
      .get(api_url + "/api/tenants/" + this.id)
      .then((response) => {
        this.formData = response.data;
        this.profilePic=`${api_url}/api/tenants/${this.id}/avatar`
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
  data() {
    return {
      profilePic:undefined,
      isMale:false,
      isFemale:false,
      isOther:false,
      formData:undefined,
      id: this.$route.params.id,
      checkRates: "tenant",
    };
  },
};
</script>


<style scoped>
.center {
  font-size: 1vmax;
}
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

.pad {
  background-color: white;
  width: 90%;
  margin: 6% auto;
}
.bs {
  background-color: #2d6a4f;
}

.toMargin {
  margin: 4% auto;
}

.llr {
  margin: 0 5% 0 auto;
}
</style>