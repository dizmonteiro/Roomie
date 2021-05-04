<template>
  <div>
    <div class="box sCard">
      <div class="columns is-desktop">
        <div
          class="column adjust-hero-s has-text-centered is-one-fifth-desktop is-full-mobile is-full-tablet"
        >
          <div class="box sBox">
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
            <label class="label">{{ houseName }}</label>
            <label class="label">{{ houseLocation }}</label>
          </div>
        </div>
        <div
          class="column adjust-hero-s is-one-fifth-desktop is-full-mobile is-full-tablet form has-text-centered"
        >
          <div class="sTenant">
            <figure class="image center">
              <img
                class="is-rounded"
                :src="tenant.photo"
                @click="checkProfile"
              />
            </figure>
            <label class="label center">{{ tenant.name }}</label>
          </div>
        </div>
        <div
          class="column adjust-hero is-two-fifths-desktop is-full-mobile is-full-tablet has-text-centered"
        >
          <check-rates class="sCheck" />
          <div class="columns" v-if="decision === 'toDecide'">
            <div class="column is-half has-text-centerd">
              <button class="button is-green ap" @click="accepted">
                Accept Application
              </button>
            </div>
            <div class="column is-half has-text-centerd">
              <button class="button is-green ap" @click="rejected">Reject Application</button>
            </div>
          </div>
          <button v-if="decision === 'accepted'" class="button is-green ap" @click="accepted">
            Application Accepted
          </button>
          <button v-if="decision === 'rejected'" class="button is-green ap" @click="rejected">
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
            <label class="label tInfo"
              >{{ tenant.avgRating }}/5 <i class="far fa-star"></i
            ></label>
            <a class="button is-green rez" href="/landlord/tprofile">View Candidate Profile</a>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { VueAgile } from "vue-agile";
import CheckRates from "./CheckRates.vue";
export default {
  props: ["houseSlides", "houseName", "houseLocation", "tenant"],
  components: { agile: VueAgile, CheckRates },
  data() {
    return { decision: "toDecide" };
  },
  methods: {
    checkProfile() {
      this.$router.push("/landlord/tprofile");
    },
    accepted() {
      if (this.decision === "accepted") this.decision = "toDecide";
      else this.decision = "accepted";
    },
    rejected() {
      if (this.decision === "rejected") this.decision = "toDecide";
      else this.decision = "rejected";
    },
  },
};
</script>

<style scoped>
.ap {
  width: 100%;
}
.teste {
  max-width: 150%;
  width: 150%;
  margin: 0 auto;
}
.sInfo {
  margin: 23% auto;
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
.sTenant {
  display: inline-block;
  margin: 20% auto;
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