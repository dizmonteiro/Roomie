<template>
  <div>
    <tenant-navbar />
    <div class="columns">
      <div class="column is-full has-text-centered">
        <h1 class="title is-1">Applications</h1>
      </div>
    </div>
    <div id="scroll-area" v-if="applications.length !== 0">
      <smooth-scrollbar>
        <tenant-application
          v-for="ap in applications"
          :key="ap.id"
          :application="ap"
          @cancel="takeOut(ap)"
        />
      </smooth-scrollbar>
    </div>
    <div v-else>
      <img
        class="empty"
        src="https://www.pngrepo.com/png/157995/180/empty-white-box.png"
      />
    </div>
  </div>
</template>

<script>
import TenantApplication from "../components/TenantApplication.vue";
import TenantNavbar from "../components/TenantNavbar.vue";
import axios from "axios";
import store from "@/store";
import { url as api_url } from "@/assets/scripts/api.js";

export default {
  components: { TenantNavbar, TenantApplication },
  methods: {
    takeOut(x) {
      for (var i = 0; i < this.applications.length; i++) {
        if (this.applications[i] === x) {
          this.applications.splice(i, 1);
        }
      }
    },
  },
  created() {
    axios
      .get(api_url + "/api/tenants/" + store.getters.getId + "/applications")
      .then((res) => {
        for (var i = 0; i < res.data.length; i++) {
          var photos = [];
          for (var j = 0; j < res.data[i].house.photos.length; j++)
            photos.push(
              `${api_url}/api/houses/photos/${res.data[i].house.photos[j]}`
            );
          var status = undefined;
          if (!res.data[i].toBeAssessed)
            status = "Waiting for landlord response";
          else if (res.data[i].accepted) status = "Landlord already accepted!";
          else status = "Landlord rejected your application";
          var application = {
            tenantId: store.getters.getId,
            housePhotos: photos,
            houseName: res.data[i].house.title,
            houseLocation: res.data[i].house.address,
            id: res.data[i].house.id,
            status: status,
          };
          console.log(res.data[i]);
          this.applications.push(application);
        }
        this.applications.sort(function (a, b) {
          let x = a.status.toUpperCase(),
            y = b.status.toUpperCase();
          return x == y ? 0 : x > y ? 1 : -1;
        });
        this.teste++;
        console.log("renthistory " + JSON.stringify(this.rentHistory));
      })
      .catch((ex) => {
        console.log(ex);
      });
  },
  data() {
    return {
      formData: undefined,
      ww: window.innerWidth,
      wh: Window.innerHeight,
      applicationsx: [],
      applications: [],
    };
  },
};
</script>

<style scoped>
.empty {
  margin: 0 auto;
  width: 35%;
}
.title {
  margin: 3% auto 0 auto;
}
.sCard {
  margin: 1% auto;
}
#scroll-area {
  margin: 2% auto;
  width: 100%;
  height: 650px;
}
</style>