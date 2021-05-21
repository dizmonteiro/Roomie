<template>
  <div>
    <div v-if="type === 'tenant'">
      <TenantNavbar />
    </div>
    <div v-else-if="type === 'landlord'">
      <landlord-navbar />
    </div>
    <div id="ratetenantcard">
      <div class="columns is-centered is-mobile is-tablet is-desktop">
        <div
          class="column has-text-centered is-3-desktop is-3-mobile is-3-tablet"
        >
          <div class="box">
            <div v-if="type === 'tenant'">
              <div class="title is-1">Roomate</div>
            </div>

            <div v-else-if="type === 'landlord'">
              <div class="title is-1">Tenant</div>
            </div>

            <div class="block">
              <figure class="image avatar">
                <img id="profile-pic" class="is-rounded" :src="profilePic" />
              </figure>
            </div>

            <div class="title is-3">{{ formData.name }}</div>
          </div>
        </div>
        <div class="column is-7-desktop is-7-mobile is-7-tablet">
          <rate
            :usert="type"
            :rcleanliness="rateData.cleanliness"
            :rpayment="rateData.payment"
            :rcare="rateData.care"
            :rtidiness="rateData.tidiness"
            :rprivacy="rateData.privacy"
            :rfriendliness="rateData.friendliness"
            :rbuttonText="this.newbuttonText"
            :tenantid="this.iduser"
            :houseid="this.idhouse"
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
  methods: {},
  created() {
    axios
      .get(api_url + "/api/tenants/" + this.iduser)
      .then((response) => {
        this.formData = response.data;
        this.profilePic = `${api_url}/api/tenants/${this.iduser}/avatar`;
        this.rateData = `${api_url}/api/tenants/${this.iduser}/rating`;
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
      rateDate: undefined,
      iduser: this.$route.params.id,
      idhouse: this.$route.params.id2,
      checkr: "tenant",
      newbuttonText: "Submit Rating",
    };
  },
};
</script>


<style scoped>
#ratetenantcard {
  min-height: 80vh;
  margin-top: 3%;
  margin-bottom: 6%;
}

.center {
  font-size: 1vmax;
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

.bs {
  background-color: #2d6a4f;
}
</style>