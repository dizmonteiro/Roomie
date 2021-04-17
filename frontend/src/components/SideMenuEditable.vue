<template>
  <div class="bg">
    <label class="label">
      {{ title }}
    </label>
    <div class="mtop">
      <br>
     <slot name="firstEntry"></slot>
     <br>
     <slot  name="secondEntry"></slot>
     <br>
     <slot  name="thirdEntry"></slot>
     <br>
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
  background-color: white;
  border-color: lightslategray;
  margin: 0 auto;
  border-style: solid;
  border-width: 2px;
  border-radius: 1%;
}
</style>