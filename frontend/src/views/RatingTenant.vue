<template>
  <div>
    <div v-if="type === 'tenant'">
      <TenantNavbar />
    </div>
    <div v-else-if="type === 'landlord'">
      <landlord-navbar />
    </div>
    <div class="ratetenantcard">
      <div
        class="columns is-centered is-vcentered is-mobile is-tablet is-desktop"
      >
        <div
          class="column is-3-desktop is-3-mobile is-3-tablet"
        >
          <div class="box">
            <div class="block">
              <figure class="image avatar">
                <img id="profile-pic" class="is-rounded" :src="profilePic" />
              </figure>
            </div>
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
        </div>
        <div
          class="column is-7-desktop is-7-mobile is-7-tablet"
        >
            <rate
              :usert="type"
            >
            </rate>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import TenantNavbar from "@/components/TenantNavbar";
import { mapGetters, mapState } from "vuex";
import Rate from "../components/Rate.vue";
import LandlordNavbar from "../components/LandlordNavbar.vue";
import axios from "axios";
import { url as api_url } from "@/assets/scripts/api";

export default {
  name: "RatingTenant",
  components: {
    TenantNavbar,
    Rate,
    LandlordNavbar,
  },
  created() {
    axios
      .get(api_url + "/api/tenants/" + this.id)
      .then((response) => {
        this.formData = response.data;
        this.profilePic = `${api_url}/api/tenants/${this.id}/avatar`;
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
      profilePic: undefined,
      formData: undefined,
      id: this.$route.params.id,
      checkr: "tenant",
    };
  },
};
</script>


<style scoped>
#ratetenantcard {
  min-height: 80vh;
  margin-top: 6%;
  margin-bottom: 6%;
}

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