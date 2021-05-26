<template>
  <div>
    <landlord-navbar />
    <div class="columns">
      <div class="column is-full has-text-centered">
        <h1 class="title is-1">My Houses</h1>
      </div>
    </div>
    <div id="scroll-area">
      <smooth-scrollbar>
        <div>
          <div v-for="h in formData" :key="h.id">
            <houses-entry
              v-if="toPrint[h.id]"
              :campo="teste"
              :houseSlides="h.housePhotos"
              :houseLocation="h.address"
              :houseName="h.title"
              :houseId="h.id"
              :link="h.houseLink"
              :update="h.updateLink"
              :tenants="tenantInfo[h.tiId]"
              @removeHouse="removeHouse"
            />
          </div>
        </div>
      </smooth-scrollbar>
    </div>
  </div>
</template>

<script>
import HousesEntry from "../components/HousesEntry.vue";
import LandlordNavbar from "../components/LandlordNavbar.vue";
import axios from "axios";
import { url as api_url } from "@/assets/scripts/api";
import store from "@/store";

export default {
  components: { HousesEntry, LandlordNavbar },
  created() {
    axios
      .get(api_url + "/api/landlords/" + store.getters.getId + "/houses")
      .then((response) => {
        this.formData = response.data;
        for (var j = 0; j < this.formData.length; j++) {
          var slides = [];
          for (var i in this.formData[j].photos)
            slides.push(
              `${api_url}/api/houses/photos/${this.formData[j].photos[i]}`
            );
          this.formData[j].housePhotos = slides;
          this.formData[j].houseLink = "/landlord/house/" + this.formData[j].id;
          this.formData[j].updateLink =
            "/landlord/house/" + this.formData[j].id + "/update";
          this.formData[j].tiId = j;
          this.toPrint[this.formData[j].id] = true;
          this.getTenantsInHouse(this.formData[j].id, j);
        }
      })
      .catch((e) => {
        console.log(e);
      });
  },
  data() {
    return {
      toPrint: [],
      teste: 0,
      formData: undefined,
      tenantInfo: [],
      wh: window.innerHeight,
    };
  },
  methods: {
    async removeHouse(h) {
      this.toPrint[h] = false;
      this.teste--;
    },
    async getTenantsInHouse(hid, j) {
      await axios
        //TODO por intervalo de tempo
        .get(api_url + "/api/houses/" + hid + "/tenants")
        .then((res) => {
          this.tenantInfo[j] = [];
          for (var t = 0; t < res.data.length; t++)
            this.tenantInfo[j].push({
              photo: `${api_url}/api/tenants/${res.data[t].id}/avatar`,
              name: res.data[t].name,
              id: res.data[t].id,
            });
          this.teste++;
          console.log(
            "J=" + j + " Tenant Info " + JSON.stringify(this.tenantInfo)
          );
        })
        .catch((ex) => {
          console.log(ex);
        });
    },
  },
  computed: {
    userStyle() {
      return {
        "--scroll-height": window.innerHeight,
      };
    },
  },
};
</script>

<style scoped>
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