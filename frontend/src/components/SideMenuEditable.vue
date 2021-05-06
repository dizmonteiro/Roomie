<template>
  <div class="bg">
    <label class="label">
      {{ title }}
    </label>
    <div class="mtop">
      <slot></slot>
      <button class="button pad" value="more">
        <strong>More</strong>
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
strong{
  color: white;
}

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
  background-color: white;
  border-color: lightslategray;
  margin: 0 auto;
  border-style: solid;
  border-width: 2px;
  border-radius: 1%;
}
button{
  background-color: #2D6A4f;
}
</style>