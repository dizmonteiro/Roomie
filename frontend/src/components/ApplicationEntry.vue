<template>
  <div>
    <div class="box sCard">
      <div class="columns is-desktop">
        <div
          class="column adjust-hero-s has-text-centered is-one-fifth-desktop is-full-mobile is-full-tablet"
        >
          <a class="box sBox">
            <agile class="sCarousel" :dots="false" :slidesToShow="1">
              <div class="slide" v-for="slide in houseSlides" :key="slide">
                <img :src="slide" :alt="slide" />
              </div>
              <template slot="prevButton">
                <i class="fas fa-arrow-left"></i>
              </template>
              <template slot="nextButton">
                <i class="fas fa-arrow-right"></i>
              </template>
            </agile>
            <a :href="'/landlord/house/' + houseId">
              <label class="label">{{
                houseName.substring(0, 25) + "..."
              }}</label>
              <label class="label">{{ houseLocation }}</label>
            </a>
          </a>
        </div>
        <div
          class="column adjust-hero-s is-one-fifth-desktop is-full-mobile is-full-tablet form has-text-centered"
        >
          <div class="sTenant">
            <figure class="image avatar">
              <img id="profile-pic" class="is-rounded" :src="tenant.photo" />
            </figure>
            <label class="label center">{{ tenant.name }}</label>
          </div>
        </div>
        <div
          class="column adjust-hero is-two-fifths-desktop is-full-mobile is-full-tablet has-text-centered"
        >
          <check-rates :hid="houseId" :tid="tenant.id" class="sCheck" />
          <div class="columns" v-if="decision === 'toDecide'">
            <div class="column is-half has-text-centerd">
              <button class="button is-green ap" @click="doAccept">
                Accept Application
              </button>
            </div>
            <div class="column is-half has-text-centerd">
              <button class="button is-green ap" @click="doReject">
                Reject Application
              </button>
            </div>
          </div>
          <button
            v-if="decision === 'accepted'"
            class="button is-green ap"
          >
            Application Accepted
          </button>
          <button
            v-if="decision === 'rejected'"
            class="button is-green ap"
          >
            Application Rejected
          </button>
        </div>
        <div
          class="column adjust-hero-s is-one-fifth-desktop is-full-mobile is-full-tablet form has-text-centered"
        >
          <div class="sInfo">
            <label class="label tInfo"
              >{{ tenant.phone }} <i class="fas fa-phone"></i
            ></label>
            <a
              class="button is-green rez"
              :href="'/landlord/tprofile/' + tenant.id"
              >View Candidate Profile</a
            >
          </div>
        </div>
      </div>
    </div>
    <div id="confirmation" class="modal">
      <div class="modal-background"></div>
      <div class="modal-content">
        <div class="box has-text-centered">
          <h1 class="title">Are you sure?</h1>
          <button class="button d is-green" @click="decide()">
            Confirm
          </button>
          <button class="button d is-green" @click="closeModal()">
            Close
          </button>
        </div>
      </div>
      <button
        class="modal-close is-large"
        aria-label="close"
        value="close-modal"
        @click="closeModal()"
      ></button>
    </div>
  </div>
</template>

<script>
import { VueAgile } from "vue-agile";
import CheckRates from "./CheckRates.vue";
import axios from "axios";
import { url as api_url } from "@/assets/scripts/api";

export default {
  props: [
    "houseSlides",
    "houseName",
    "houseLocation",
    "tenant",
    "houseId",
    "decision",
  ],
  components: { agile: VueAgile, CheckRates },
  data() {
    return {
      dec:false,
    };
  },
  methods: {
    checkProfile() {
      this.$router.push("/landlord/tprofile");
    },
    async decide(){
      if (this.dec)
      this.accepted()
      else this.rejected()
      document.getElementById("confirmation").classList.remove("is-active");
      if (this.dec)
      alert("Application has been accepted!")
      else alert("Application has been rejected!")
    },
    async closeModal(){
      document.getElementById("confirmation").classList.remove("is-active");
    },
    async doAccept(){
      this.dec = true
      document.getElementById("confirmation").classList.add("is-active");
    },
    async doReject(){
      this.dec=false
      document.getElementById("confirmation").classList.add("is-active");
    },
    async accepted() {
      if (this.decision === "toDecide") {
        var tenantInfo = {
          tenantId: this.tenant.id,
          accept: true,
        };
        await axios
          .put(api_url + "/api/applications/" + this.houseId, tenantInfo)
          .then(() => {
            this.decision = "accepted";
          })
          .catch((e) => {
            alert(e);
          });
      }
    },
    async rejected() {
      if (this.decision === "toDecide") {
        var tenantInfo = {
          tenantId: this.tenant.id,
          accept: false,
        };
        await axios
          .put(api_url + "/api/applications/" + this.houseId, tenantInfo)
          .then(() => {
            this.decision = "rejected";
          })
          .catch((e) => {
            alert(e);
          });
      }
    },
  },
};
</script>

<style scoped>
.avatar {
  width: 15vmax;
  height: 15vmax;
  position: relative;
  display: block;
  margin: 11% auto 8% auto;
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
.d{
  margin: 0 3%;
}
.ap {
  width: 100%;
}
.teste {
  max-width: 150%;
  width: 150%;
  margin: 0 auto;
}
.sInfo {
  margin: 40% auto;
}
.sCheck {
  margin: 4% auto 1% auto;
}
.rez {
  width: 100%;
}
.tInfo {
  margin: 12% auto;
  padding: auto 40%;
  border-style: solid;
  border-color: #2d6a4f;
}
.sBox {
  margin: 6% auto;
}
.date {
  margin-right: 5%;
  margin-left: 5%;
  display: inline-block;
}

.colContent {
  margin: 0 auto;
}
.llp {
  width: 60%;
  margin-bottom: 5%;
  margin-top: 5%;
}
.sCard {
  margin: 0 auto 1% auto;
  width: 80%;
}
</style>