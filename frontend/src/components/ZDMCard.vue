<template>
  <div class="card">
    <div class="columns">
      <div class="column">
        <img
        class="card-icon-left"
        :src="require(`@/assets/svg/${imgName1}`)"
        alt="card icon"
        />
      </div>
      <div class="column">
        <img
        class="card-icon-right"
        :src="require(`@/assets/svg/${imgName2}`)"
        alt="card icon"
        />
      </div>
    </div>
    <div class='card-content'>
      <div class="buttons is-centered">
        <a class="button is-green is-rounded">
           {{text}}
        </a>
        <a class="button is-green is-rounded" href="/">
           View More
        </a>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "ZDMCard",
  props: {
    headline: String,
    imgName1: String,
    imgName2: String,
    text: String
  }
};
</script>

<style src="../assets/styles/Card.css" scoped>