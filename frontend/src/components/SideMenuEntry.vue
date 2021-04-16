<template>
  <div class="holder">
    <div class="columns is-vcentered is-gapless is-desktop oline">
      <div class="column is-half-desktop is-full-mobile is-full-tablet">
        <figure class="image placer">
          <img :src="imgSource" />
        </figure>
      </div>
      <div
        class="column is-half-desktop is-full-mobile is-full-tablet has-text-center"
      >
        <label :name="args[0].k1">{{ args[0].v1 }}</label>
        <label :name="args[0].k2">{{ args[0].v2 }}</label>
        <label :name="args[0].k3">{{ args[0].v3 }}</label>
        <button class="button is-success vm" value="view-more">
          View More
        </button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  props: ["args", "imgSource"],
  data() {
    return {};
  },
};
</script>

<style>

label{
    display: block;
}
.oline {
  background-color: #baffad;
  border-style: solid;
  border-width: 1px;
}
.placer {
  padding: 0 5%;
  margin: 5% auto;
}
.vm {
  width: 80%;
  min-width: 80px;
  margin: 3% auto;
}
</style>