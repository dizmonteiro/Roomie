<template>
  <div>
    <div class="box sCard">
      <div class="columns is-desktop">
        <div
          class="column adjust-hero-s has-text-centered is-one-fifth-desktop is-full-mobile is-full-tablet"
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
          class="column adjust-hero-s is-four-fifths-desktop is-full-mobile is-full-tablet form has-text-centered"
        >
          <div class="middle">
            <h1 class="title is-2 status">Status: {{ application.status }}</h1>
            <a
              class="button is-green ap"
              :href="'/tenant/house/' + application.id"
            >
              Check House
            </a>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { VueAgile } from "vue-agile";
export default {
  props: ["application"],
  components: { agile: VueAgile },
  data() {
    return {};
  },
  methods: {
    cancel() {
      console.log(this);
      this.$emit("cancel", this);
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
.ap {
  width: 50%;
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