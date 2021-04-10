<template>
    <div class="grid-container">
      <h1>Welcome!</h1>
      <FillInfo definicao="Username" :tipo="'text'"/>
      <FillInfo definicao="Password" :tipo="'password'"/>
      <button class="button">Login</button>
    </div>
</template>

<script>
import FillInfo from './FillInfo.vue'
export default {
  components: {FillInfo},
  data(){
    return {
    }
  }
};
</script>

<style>
body{
  background-color: #dfdfdf;
}
.grid-container {
  background-color: rgb(204, 204, 204);
  border-radius: 2%;
  display: grid;
  margin: 15vh auto;
  width: 60%;
  height: 60vh;
  min-height: 400px;
  row-gap: 10%;
  align-content: center;
  grid-template-columns: auto;
  text-align:center;
}
.button{
  text-align: center;
  width: 30%;
  padding: 0%;
  font-size: 150%;
  margin: 0 auto;
}

</style>