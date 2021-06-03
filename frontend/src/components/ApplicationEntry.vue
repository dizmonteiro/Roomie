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
          <div class="columns" v-if="nDecision === 'toDecide'">
            <div class="column is-half has-text-centerd">
              <button class="button is-green ap" @click="accepted">
                Accept Application
              </button>
            </div>
            <div class="column is-half has-text-centerd">
              <button class="button is-green ap" @click="rejected">
                Reject Application
              </button>
            </div>
          </div>
          <button v-if="nDecision === 'accepted'" class="button is-green ap">
            Application Accepted
          </button>
          <button v-if="nDecision === 'rejected'" class="button is-green ap">
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
    <div :id="'confirmA_' + tenant.id + '_' + houseId" class="modal">
      <div class="modal-background"></div>
      <div class="modal-content">
        <div class="box has-text-centered">
          <h1 class="title">Are you sure you want to accept?</h1>
          <button class="button d is-green" @click="accepted">
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
    <div :id="'confirmR_' + tenant.id + '_' + houseId" class="modal">
      <div class="modal-background"></div>
      <div class="modal-content">
        <div class="box has-text-centered">
          <h1 class="title">Are you sure you want to reject?</h1>
          <button class="button d is-green" @click="rejected">Confirm</button>
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
  </div>
</template>

<script>
import { VueAgile } from "vue-agile";
import CheckRates from "./CheckRates.vue";

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
      nDecision: this.decision,
      dec: false,
    };
  },
  methods: {
    checkProfile() {
      this.$router.push("/landlord/tprofile");
    },
    decide() {
      console.log(this.dec);
      console.log(this.decision);
      if (this.dec) this.accepted();
      else this.rejected();
      document.getElementById("confirmation").classList.remove("is-active");
      if (this.dec) alert("Application has been accepted!");
      else alert("Application has been rejected!");
    },
    closeModal() {
      var s = "confirmA_" + this.tenant.id + "_" + this.houseId;
      var sr = "confirmR_" + this.tenant.id + "_" + this.houseId;
      if (!document.getElementById(s).classList.remove("is-active"))
        document.getElementById(sr).classList.remove("is-active");
    },
    async doAccept() {
      this.dec = true;
      var s = "confirmA_" + this.tenant.id + "_" + this.houseId;
      console.log("first something");
      document.getElementById(s).classList.add("is-active");
    },
    doReject() {
      var s = "confirmR_" + this.tenant.id + "_" + this.houseId;
      this.dec = false;
      document.getElementById(s).classList.add("is-active");
    },
    accepted() {
      this.$emit("accepted",this.tenant.id,this.houseId)
      
    },
    rejected() {
     this.$emit("rejected",this.tenant.id,this.houseId)
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
  margin: 4% auto auto 4%;
}
#profile-pic {
  position: absolute;
  object-fit: cover;
  object-position: center;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  width: 90%;
  height: 90%;
}
.d {
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