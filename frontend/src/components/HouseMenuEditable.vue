<template>
  <div class="bg">
    <div class="mtop">
        <div class = "columns is-one-third-desktop">
            
            <div class = "column is-one-third-desktop">
                <br>
                <slot name="firstEntry"></slot>
                <br>
                <slot name="fourthEntry"></slot>
                <br>
                <slot name="seventhEntry"></slot>
                <br>
            </div>
            <div class = "column is-one-third-desktop">
                <br>
                <slot name="secondEntry"></slot>
                <br>
                <slot name="fifthEntry"></slot>
                <br>
                <slot name="eigthEntry"></slot>
                <br>
            </div>
            <div class = "column is-one-third-desktop">
                <br>
                <slot name="thirdEntry"></slot>
                <br>
                <slot name="sixthEntry"></slot>
                <br>
                <slot name="ninthEntry"></slot>
                <br>
            </div>
        </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {};
  },
};
</script>

<style scoped>

.mtop {
  margin: 0 auto;
}

.pad {
  padding: 0 10%;
  margin-bottom: 5%;
}

.bg {
  width: 90%;
  padding-top: 2%;
  padding-left: 2%;
  padding-right: 2%;
  background-color: white;
  border-color: lightslategray;
  margin: 0 auto;
}

button{
  background-color: #2D6A4f;
}

</style>