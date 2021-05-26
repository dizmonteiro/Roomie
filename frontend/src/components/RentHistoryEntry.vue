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
            <div class="sTenant" v-for="tenant in tenants" :key="tenant.id">
              <figure class="image avatar2">
            <img
            id="profile-pic"
              class="hoverable is-rounded"
              :src="tenant.photo"
              @click="checkProfile(tenant.id)"
            />
          </figure>
              <label class="label center">{{ tenant.name }}</label>
              <div class="buttons is-centered">
                <a class="button is-green" :href="`/tenant/rate/${tenant.id}/${houseId}`">
                  Rate Roomate
                </a>
              </div>
            </div>
          </div>
          <label class="label date">From:{{ from }}</label>
          <label class="label date">To:{{ to }}</label>
        </div>
        <div
          class="column adjust-hero is-one-fifth-desktop is-full-mobile is-full-tablet has-text-centered"
        >
          <label class="label">Landlord</label>
           <figure class="image avatar">
            <img
            id="profile-pic"
              class="is-rounded hoverable"
              :src="landlord.photo"
              @click="checkLandlord(landlord.id)"
            />
          </figure>
          <label class="label">{{ landlord.name }}</label>
          <a class="button is-green" :href="'/tenant/house/'+houseId">Check House</a>
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
    "houseId",
    "to",
    "landlord",
  ],
  components: { agile: VueAgile },
  data() {
    return {};
  },
  methods:{
    checkProfile(id){
      this.$router.push("/tenant/tprofile/"+id)
    },
    checkLandlord(id){
      this.$router.push("/tenant/llprofile/"+id)
    }
  }
};
</script>

<style scoped>
.hoverable:hover{
  cursor:pointer;
}
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
.avatar {
  width: 10vmax;
  height: 10vmax;
  position: relative;
  display: block;
  margin: 5% auto 8% auto;
}
.avatar2{
  width: 8vmax;
  height: 8vmax;
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
.sCard {
  margin: 0 auto 1% auto;
  width: 80%;
}
</style>