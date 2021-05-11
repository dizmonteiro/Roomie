<template>
  <div>
    <tenant-navbar />
    <div class="columns">
      <div class="column is-full has-text-centered">
        <h1 class="title is-1">My Rent History</h1>
      </div>
    </div>
    <div id="scroll-area">
      <smooth-scrollbar>
        <div>
          <div v-for="h in formData" :key="h.house.id">
            <rent-history-entry
              :campo="teste"
              :houseSlides="h.housePhotos"
              :houseLocation="h.house.address"
              :houseName="h.house.title"
              :houseId="h.house.id"
              :tenants="tenantInfo[h.tiId]"
              :from="' ' + h.bDate.split('T')[0]"
              :to="
                h.eDate == undefined
                  ? ' Still living here'
                  : h.eDate.split('T')[0]
              "
              :landlord="h.ll"
            />
          </div>
        </div>
      </smooth-scrollbar>
    </div>
  </div>
</template>

<script>
import RentHistoryEntry from "../components/RentHistoryEntry.vue";
import TenantNavbar from "../components/TenantNavbar.vue";
import axios from "axios";
import { url as api_url } from "@/assets/scripts/api";
import store from "@/store";

export default {
  components: { TenantNavbar, RentHistoryEntry },
  async created() {
    axios
      .get(api_url + "/api/tenants/" + store.getters.getId + "/rentHistory")
      .then((response) => {
        this.formData = response.data;
        for (var j = 0; j < this.formData.length; j++) {
          var slides = [];
          for (var i in this.formData[j].house.photos)
            slides.push(
              `${api_url}/api/houses/photos/${this.formData[j].house.photos[i]}`
            );
          this.formData[j].housePhotos = slides;
          this.formData[j].tenantInfo = {
            id: this.formData[j].tenant.id,
            name: this.formData[j].tenant.name,
            photo: `${api_url}/api/tenants/${this.formData[j].tenant.id}/avatar`,
          };
          (this.formData[j].tenants = []),
            (this.formData[j].ll = {
              photo: `${api_url}/api/landlords/${this.formData[j].house.landlord.id}/avatar`,
              name: this.formData[j].house.landlord.name,
              id: this.formData[j].house.landlord.id,
            });
          this.formData[j].tiId = j;
          this.getTenantsInHouse(this.formData[j].house.id, j);
          console.log(this.formData[j]);
        }
      })
      .catch((e) => {
        console.log(e);
      });
  },
  methods: {
    async getTenantsInHouse(hid, j) {
      axios
      //TODO por intervalo de tempo
        .get(api_url + "/api/houses/" + hid + "/tenants")
        .then((res) => {
          this.tenantInfo[j] = [];
          for (var t = 0; t < res.data.length; t++)
          if (res.data[t].id !== store.getters.getId)
            this.tenantInfo[j].push({
              photo: `${api_url}/api/tenants/${res.data[t].id}/avatar`,
              name: res.data[t].name,
              id: res.data[t].id,
            });
          this.teste++;
          console.log(this.tenantInfo);
        })
        .catch((ex) => {
          console.log(ex);
        });
    },
  },
  data() {
    return {
      teste: 0,
      formData: undefined,
      tenantInfo: [],
      wh: window.innerHeight,
      landlordHouse1: {
        photo: "https://randomuser.me/api/portraits/men/54.jpg",
        name: "Hugo Manuel",
      },
      tenantsHouse1: [
        {
          name: "Jose Filipe",
          photo: "https://randomuser.me/api/portraits/men/52.jpg",
        },
        {
          name: "Antonio Ramalho",
          photo: "https://randomuser.me/api/portraits/men/51.jpg",
        },
        {
          name: "Marco Antunes",
          photo: "https://randomuser.me/api/portraits/men/53.jpg",
        },
      ],
      house1Slides: [
        "https://picsum.photos/id/164/1080/720",
        "https://picsum.photos/id/163/1080/720",
        "https://picsum.photos/id/308/1080/720",
        "https://picsum.photos/id/322/1080/720",
        "https://picsum.photos/id/351/1080/720",
        "https://picsum.photos/id/369/1080/720",
        "https://picsum.photos/id/398/1080/720",
      ],
    };
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