<template>
  <div>
    <div class="box sCard">
      <div class="columns is-desktop">
        <div
          class="
            column
            adjust-hero-s
            has-text-centered
            is-one-fifth-desktop is-full-mobile is-full-tablet
          "
        >
          <div class="box sBox">
            <agile class="sCarousel" :dots="false" :slidesToShow="1">
              <div
                class="slide"
                v-for="slide in application.housePhotos"
                :key="slide"
              >
                <img :src="slide" :alt="slide" />
              </div>
              <template slot="prevButton">
                <i class="fas fa-arrow-left"></i>
              </template>
              <template slot="nextButton">
                <i class="fas fa-arrow-right"></i>
              </template>
            </agile>
            <label class="label">{{
              application.houseName.substring(0, 20) + "..."
            }}</label>
            <label class="label">{{ application.houseLocation }}</label>
          </div>
        </div>
        <div
          class="
            column
            adjust-hero-s
            is-four-fifths-desktop is-full-mobile is-full-tablet
            form
            has-text-centered
          "
        >
          <div class="middle">
            <h1 class="title is-2 status">Status: {{ application.status }}</h1>
            <a
              class="button is-green ap"
              :href="'/tenant/house/' + application.id"
            >
              Check House
            </a>
            <a class="button is-green ap" @click="openModal">
              Remove Application
            </a>
          </div>
        </div>
      </div>
    </div>
    <div
      :id="'remove' + application.tenantId + '_' + application.id"
      class="modal"
    >
      <div class="modal-background"></div>
      <div class="modal-content">
        <div class="box has-text-centered">
          <h1 class="title">Are you sure you want to remove?</h1>
          <button class="button d is-green" @click="cancel">Confirm</button>
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
import axios from "axios";
import { url as api_url } from "@/assets/scripts/api";
export default {
  props: ["application"],
  components: { agile: VueAgile },
  data() {
    return {};
  },
  methods: {
    openModal() {
      var s = "remove" + this.application.tenantId + "_" + this.application.id;
      document.getElementById(s).classList.add("is-active");
    },
    closeModal() {
      var s = "remove" + this.application.tenantId + "_" + this.application.id;
      document.getElementById(s).classList.remove("is-active");
    },
    cancel() {
      console.log(this);
      axios
        .delete(api_url + "/api/applications/" + this.application.id)
        .then((response) => {
          var s =
            "remove" + this.application.tenantId + "_" + this.application.id;
          document.getElementById(s).classList.remove("is-active");
          console.log(response);
          location.reload();
        })
        .catch((e) => console.log(e));
    },
  },
};
</script>

<style scoped>
.middle {
  margin: 8% auto;
}
.applied {
  margin: 10% auto 5% auto;
}
.status {
  border-color: #2d6a4f;
  border-style: solid;
}
.d{
  margin: 0 3%;
}
.ap {
  width: 40%;
  margin: 0 1%;
}
.buttons {
  margin: 4% auto 0 auto;
}
.sBox {
  margin: 6% auto;
}
.date {
  margin-right: 5%;
  margin-left: 5%;
  display: inline-block;
}

.sCard {
  margin: 0 auto 1% auto;
  width: 80%;
}
</style>