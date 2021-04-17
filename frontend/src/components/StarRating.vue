<template>
  <div class="columns is-gapless">
    <div class="column is-one-fifth">
      <img :key="aux" @click="fillStar(0)" :src="src[0]" />
    </div>
     <div class="column is-one-fifth">
      <img :key="aux" @click="fillStar(1)" :src="src[1]" />
    </div>
     <div class="column is-one-fifth">
      <img :key="aux" @click="fillStar(2)" :src="src[2]" />
    </div>
     <div class="column is-one-fifth">
      <img :key="aux" @click="fillStar(3)" :src="src[3]" />
    </div>
     <div class="column is-one-fifth">
      <img :key="aux" @click="fillStar(4)" :src="src[4]" />
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      aux: 0,
      src: [
        "https://i.ibb.co/VxnZx4f/blank-star.png",
        "https://i.ibb.co/VxnZx4f/blank-star.png",
        "https://i.ibb.co/VxnZx4f/blank-star.png",
        "https://i.ibb.co/VxnZx4f/blank-star.png",
        "https://i.ibb.co/VxnZx4f/blank-star.png"
      ],
      starState: [false, false, false, false,false],
    };
  },
  methods: {
    fillStar(x) {
      if (!this.starState[x]) {
        for (let i = 0; i < x; i++) {
          if (!this.starState[i]) {
            this.src[i] = "https://i.ibb.co/Dz4RB8x/imageedit-1-6482434810.png";
            this.starState[i] = true;
          }
        }
        this.aux++;
        console.log(this.src[x] + " " + this.starState[x]);
        this.src[x] = "https://i.ibb.co/Dz4RB8x/imageedit-1-6482434810.png";
        this.starState[x] = true;
      }
      else{
          if (!this.starState[1] && x==0)
        {
            this.src[0]="https://i.ibb.co/VxnZx4f/blank-star.png";
            this.starState[0] = false;
        }
        else
          for (let i = x+1; i < 5; i++) {
          if (this.starState[i]) {
            this.src[i] = "https://i.ibb.co/VxnZx4f/blank-star.png";
            this.starState[i] = false;
          }
        }
        

        this.aux++;
      }
    },
  },
};
</script>

<style>
</style>