<template>
  <div>
    <div class="box sCard">
      <div class="columns is-desktop">
        <div
          style="background-color: white"
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
          class="column adjust-hero-s is-three-fifths-desktop is-full-mobile is-full-tablet form has-text-centered"
        >
          <label class="label">You were here with:</label>
          <div class="otherTenants">
            <div class="sTenant" v-for="tenant in tenants" :key="tenant">
              <figure class="image center is-128x128">
                <img class="is-rounded" :src="tenant.photo" />
              </figure>
              <label class="label center">{{ tenant.name }}</label>
              <button class="button is-green">Rate Roommate</button>
            </div>
          </div>
          <label class="label date">From:{{ from }}</label>
          <label class="label date">To:{{ to }}</label>
        </div>
        <div
          class="column adjust-hero is-one-fifth-desktop is-full-mobile is-full-tablet has-text-centered"
        >
          <label class="label">Landlord</label>
          <figure class="image center">
            <img class="is-rounded center llp" :src="landlord.photo" />
          </figure>
          <label class="label">{{ landlord.name }}</label>
          <button class="button is-green">Check House</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { VueAgile } from "vue-agile";
export default {
  props: [
    "houseSlides",
    "houseName",
    "houseLocation",
    "tenants",
    "from",
    "to",
    "landlord",
  ],
  components: { agile: VueAgile },
  data() {
    return {};
  },
};
</script>

<style scoped>
.sBox {
  margin: 6% auto;
}
.date {
  margin-right: 5%;
  margin-left: 5%;
  display: inline-block;
}
.center {
  margin: 0 auto;
}
.sTenant {
  display: inline-block;
  margin: 2%;
}
.colContent {
  margin: 0 auto;
}
.llp{
  width: 60%;
  margin-bottom: 5%;
  margin-top: 5%;
}
.sCard {
  margin: 0 auto 1% auto;
  width: 80%;
}
</style>