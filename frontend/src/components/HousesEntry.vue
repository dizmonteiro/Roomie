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
            <label class="label">{{ houseName.substring(0,25)+"..." }}</label>
            <label class="label">{{ houseLocation }}</label>
          </div>
        </div>
        <div
          class="column adjust-hero-s is-three-fifths-desktop is-full-mobile is-full-tablet form has-text-centered"
        >
          <label class="label">Tenants living in this house:</label>
          <div class="otherTenants">
            <div class="sTenant" v-for="tenant in tenants" :key="tenant.id">
              <figure class="image avatar">
                <img
                  class="is-rounded"
                  id="profile-pic"
                  v-bind:src="tenant.photo"
                />
              </figure>
              <label class="label center">{{ tenant.name }}</label>
              <div class="buttons is-centered">
                <a class="button is-green" :href="`/landlord/rate/${tenant.id}/${houseId}`">
                  Rate Tenant
                </a>
              </div>
              <button
                :id="tenant.id"
                class="button is-green"
                @click="noLonger(tenant.id)"
              >
                Remove Tenant
              </button>
            </div>
          </div>
        </div>
        <div
          class="column adjust-hero is-one-fifth-desktop is-full-mobile is-full-tablet has-text-centered"
        >
          <div class="sButtons">
            <a class="button is-green rightButtons" :href="link">View House</a>
            <a class="button is-green rightButtons" :href="update"
              >Update House</a
            >
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { VueAgile } from "vue-agile";

import axios from "axios";
import { url as api_url } from "@/assets/scripts/api";
export default {
  props: [
    "houseSlides",
    "houseName",
    "houseLocation",
    "tenants",
    "since",
    "link",
    "update",
    "houseId",
  ],
  components: { agile: VueAgile },
  data() {
    return {};
  },

  methods: {
    async noLonger(id) {
      if (document.getElementById(id).innerHTML !== "Already Left!") {
        var tenantInfo = {
          tenantId: id,
        };

        await axios
          .put(api_url + "/api/rentHistory/" + this.houseId, tenantInfo)
          .then(() => {
            console.log("sucess!");
          })
          .catch((e) => {
            alert(e);
          });
        document.getElementById(id).innerHTML = "Already Left!";
      }
    },
  },
};
</script>

<style scoped>
.avatar {
  width: 8vmax;
  height: 8vmax;
  position: relative;
  display: block;
  margin: 15% auto 8% auto;
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
.rightButtons {
  width: 90%;
}

.sButtons {
  margin: 30% auto;
}

.button {
  display: block;
  margin: 2.5% auto 2.5% auto;
}
.sBox {
  margin: 11% auto;
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
.sCard {
  margin: 0 auto 1% auto;
  width: 80%;
}
</style>