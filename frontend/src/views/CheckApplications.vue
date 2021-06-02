<template>
  <div>
    <landlord-navbar />
    <div class="columns">
      <div class="column is-full has-text-centered">
        <h1 class="title is-1">Applications</h1>
      </div>
    </div>
    <div v-for="h in formData" :key="h.tenant.id + '-' + h.house.id">
      <application-entry
        :id="aux"
        :decision="h.decision"
        :houseId="h.house.id"
        :houseSlides="h.housePhotos"
        :houseLocation="h.house.address"
        :houseName="h.house.title"
        :tenant="h.tenantInfo"
        @accepted="accepted"
        @rejected="rejected"
      />
    </div>
    <div id="accept" class="modal">
      <div class="modal-background"></div>
      <div class="modal-content">
        <div class="box has-text-centered">
          <h1 class="title">Are you sure you want to accept?</h1>
          <button class="button d is-green" @click="acceptAxios">
            Confirm
          </button>
          <button class="button d is-green" @click="closeModal">Close</button>
        </div>
      </div>
      <button
        class="modal-close is-large"
        aria-label="close"
        value="close-modal"
        @click="closeModal"
      ></button>
    </div>
    <div id="reject" class="modal">
      <div class="modal-background"></div>
      <div class="modal-content">
        <div class="box has-text-centered">
          <h1 class="title">Are you sure you want to reject?</h1>
          <button class="button d is-green" @click="rejectAxios">
            Confirm
          </button>
          <button class="button d is-green" @click="closeModalR">Close</button>
        </div>
      </div>
      <button
        class="modal-close is-large"
        aria-label="close"
        value="close-modal"
        @click="closeModal"
      ></button>
    </div>
  </div>
</template>

<script>
import LandlordNavbar from "../components/LandlordNavbar.vue";
import ApplicationEntry from "../components/ApplicationEntry.vue";
import axios from "axios";
import { url as api_url } from "@/assets/scripts/api";
import store from "@/store";

export default {
  methods: {
    accepted(tid, hid) {
      this.currentTid = tid;
      this.currentHid = hid;
      console.log(tid + "-" + hid);
      document.getElementById("accept").classList.add("is-active");
    },
    rejected(tid, hid) {
      this.currentTid = tid;
      this.currentHid = hid;
      console.log(tid + "-" + hid);
      document.getElementById("reject").classList.add("is-active");
    },
    closeModal() {
      document.getElementById("accept").classList.remove("is-active");
    },
    acceptAxios() {
      document.getElementById("accept").classList.remove("is-active");
      var tenantInfo = {
        tenantId: this.currentTid,
        accept: true,
      };
      axios
        .put(api_url + "/api/applications/" + this.currentHid, tenantInfo)
        .then(() => {this.aux++;alert("sucessfully accepted!")})
        .catch((e) => {
          alert(e);
        });
    },
    closeModalR() {
      document.getElementById("reject").classList.remove("is-active");
    },
    rejectAxios() {
      document.getElementById("reject").classList.remove("is-active");
      var tenantInfo = {
        tenantId: this.currentTid,
        accept: false,
      };
      axios
        .put(api_url + "/api/applications/" + this.currentHid, tenantInfo)
        .then(() => {this.aux--;alert("sucessfully rejected!")})
        .catch((e) => {
          alert(e);
        });
    },
  },
  components: { LandlordNavbar, ApplicationEntry },
  created() {
    axios
      .get(api_url + "/api/landlords/" + store.getters.getId + "/applications")
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
            phone: this.formData[j].tenant.phone,
            photo: `${api_url}/api/tenants/${this.formData[j].tenant.id}/avatar`,
          };
          if (!this.formData[j].toBeAssessed)
            this.formData[j].decision = "toDecide";
          else if (this.formData[j].accepted)
            this.formData[j].decision = "accepted";
          else this.formData[j].decision = "rejected";
          console.log(this.formData[j].decision);
        }
        for (var x = 0; x < this.formData.length; x++) {
          console.log(this.formData[x]);
        }
      })
      .catch((e) => {
        console.log(e);
      });
  },
  data() {
    return {
      aux:0,
      currentTid: undefined,
      currentHid: undefined,
      formData: undefined,
      wh: window.innerHeight,
      landlordHouse1: {
        photo: "https://randomuser.me/api/portraits/men/54.jpg",
        name: "Hugo Manuel",
      },
      tenantsHouse1: [
        {
          name: "Jose Filipe",
          phone: "123456789",
          avgRating: 3.7,
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
.d {
  margin: 3% 3%;
  box-sizing: border-box;
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