<template>
  <form>
    <div class="campo">
      <div class="input_name">
        <label class="p">{{ definicao }}</label>
      </div>
      <input class="l" :type=tipo required />
    </div>
  </form>
</template>

<script>
export default {
  props: ['definicao', 'tipo'],
};
</script>

<style>
.campo {
  text-align: center;
  font-size: 2vw;
}
.input_name {
  text-align: left;
  margin-left: 4%;
}
.p {
  display: block;
}
.l {
  border-radius: 0%;
  width: 90%;
  height: 0%;
  font-size:100%;
}
</style>