<template>
  <div class="bg">
    <label class="label">
      {{ title }}
    </label>
    <div class="mtop">
      <div class="columns is-vcentered is-gapless is-desktop oline">
        <div class="column is-half-desktop is-full-mobile is-full-tablet">
          <figure class="image placer">
            <img src="https://bulma.io/images/placeholders/256x256.png" />
          </figure>
        </div>
        <div
          class="column is-half-desktop is-full-mobile is-full-tablet has-text-center"
        >
          <label name="house_name">Name</label>
          <label name="house_location">Location</label>
          <label name="house_slots">Available Slots</label>
          <button class="button is-success vm" style="" value="view-more">
            View More
          </button>
        </div>
      </div>
      <div class="columns is-vcentered is-gapless is-desktop oline">
        <div class="column is-half-desktop is-full-mobile is-full-tablet">
          <figure class="image placer">
            <img src="https://bulma.io/images/placeholders/256x256.png" />
          </figure>
        </div>
        <div
          class="column is-half-desktop is-full-mobile is-full-tablet has-text-center"
        >
          <label name="house_name">Name</label>
          <label name="house_location">Location</label>
          <label name="house_slots">Available Slots</label>
          <button class="button is-success vm" style="" value="view-more">
            View More
          </button>
        </div>
      </div>
      <div class="columns is-vcentered is-gapless is-desktop oline">
        <div class="column is-half-desktop is-full-mobile is-full-tablet">
          <figure class="image placer">
            <img src="https://bulma.io/images/placeholders/256x256.png" />
          </figure>
        </div>
        <div
          class="column is-half-desktop is-full-mobile is-full-tablet has-text-center"
        >
          <label name="house_name">Name</label>
          <label name="house_location">Location</label>
          <label name="house_slots">Available Slots</label>
          <button class="button is-success vm" style="" value="view-more">
            View More
          </button>
        </div>
      </div>
      <button class="button is-primary is-rounded pad" value="more">
        More
      </button>
    </div>
  </div>
</template>

<script>
export default {
  props: ["title"],
  data() {
    return {};
  },
};
</script>

<style scoped>
label {
  display: block;
}
.placer {
  padding: 0 5%;
  margin: 5% auto;
}

.mtop {
  margin: 0 auto;
}

.pad {
  padding: 0 10%;
  margin-bottom: 5%;
}

.oline {
  border-style: solid;
  border-width: 1px;
}
.vm {
  width: 80%;
  min-width: 80px;
  margin: 3% auto;
}
.teste {
  width: 100%;
}
.bg {
  width: 90%;
  padding-top: 2%;
  padding-left: 2%;
  padding-right: 2%;
  border-color: lightslategray;
  margin: 0 auto;
  border-style: solid;
  border-width: 2px;
  border-radius: 1%;
}
</style>