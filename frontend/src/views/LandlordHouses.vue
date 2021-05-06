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
        <scroll-content>
          <div v-for="h in formData" :key="h.id">
            <houses-entry
              :houseSlides="h.housePhotos"
              :houseLocation="h.address"
              :houseName="h.title"
              :link="h.houseLink"
              :update="h.updateLink"
              :tenants="tenantsHouse1"
            />
          </div>
        </scroll-content>
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
        this.formData = response.data.splice(0, 3);
        for (var j = 0; j < this.formData.length; j++)
        {
          var slides = []
          for (var i in this.formData[j].photos)
            slides.push(
              `${api_url}/api/houses/photos/${this.formData[j].photos[i]}`
            );
            this.formData[j].housePhotos=slides;
            this.formData[j].houseLink='/landlord/house/'+this.formData[j].id;
            this.formData[j].updateLink='/landlord/house/'+this.formData[j].id+'/update';
        }
        for (var x = 0; x < this.formData.length; x++)
        {
          console.log(this.formData[x])
        }


      })
      .catch((e) => {
        console.log(e);
      });
  },
  data() {
    return {
      teste: [1, 2, 3],
      formData: undefined,
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