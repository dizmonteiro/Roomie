<template>
  <div class="bg">
    <label class="label">
      {{ title }}
    </label>
    <div class="mtop">
      <div class="columns is-gapless oline">
        <div class="column is-half">
          <figure class="image placer is-128x128">
            <img src="https://bulma.io/images/placeholders/256x256.png" />
          </figure>
        </div>
        <div class="column auto has-text-center">
          <label name="house_name">Name</label>
          <label name="house_location">Location</label>
          <label name="house_slots">Available Slots</label>
          <button class="button is-success is-rounded mtop" value="view-more">
            View More
          </button>
        </div>
      </div>
      <div class="columns is-gapless oline">
        <div class="column is-half">
          <figure class="image placer is-128x128">
            <img src="https://bulma.io/images/placeholders/256x256.png" />
          </figure>
        </div>
        <div class="column auto has-text-center">
          <label name="house_name">Name</label>
          <label name="house_location">Location</label>
          <label name="house_slots">Available Slots</label>
          <button class="button is-success is-rounded mtop" value="view-more">
            View More
          </button>
        </div>
      </div>
      <div class="columns is-gapless oline">
        <div class="column is-half">
          <figure class="image placer is-128x128">
            <img src="https://bulma.io/images/placeholders/256x256.png" />
          </figure>
        </div>
        <div class="column auto has-text-center">
          <label name="house_name">Name</label>
          <label name="house_location">Location</label>
          <label name="house_slots">Available Slots</label>
          <button class="button is-success is-rounded mtop" value="view-more">
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
  margin: 5% auto;
}

.mtop {
  margin-top: 5%;
}

.pad {
  padding: 0 10%;
  margin-bottom: 5%;
}

.oline {
  border-style: solid;
    border-width: 1px;
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