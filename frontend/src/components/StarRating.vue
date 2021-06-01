<template>
  <div :value="total">
    <img class="star" @click="fillStar(0)" :src="src[0]" />
    <img class="star" @click="fillStar(1)" :src="src[1]" />
    <img class="star" @click="fillStar(2)" :src="src[2]" />
    <img class="star" @click="fillStar(3)" :src="src[3]" />
    <img class="star" @click="fillStar(4)" :src="src[4]" />
  </div>
</template>

<script>
import { url as api_url } from "@/assets/scripts/api";
import axios from "axios";
export default {
  props: ["initialValue", "editable", "feature", "tid", "toSubmit"],
  created() {
    if (!this.toSubmit) {
      var i = 0;
      axios
        .get(api_url + "/api/tenants/" + this.tid + "/rating")
        .then((res) => {
          switch (this.feature) {
            case "cleanliness":
              this.iv = res.data.cleanliness;
              break;
            case "friendliness":
              this.iv = res.data.friendliness;
              break;
            case "payment":
              this.iv = res.data.payment;
              break;
            case "care":
              this.iv = res.data.care;
              break;
            case "tidiness":
              this.iv = res.data.tidiness;
              break;
            case "privacy":
              this.iv = res.data.privacy;
              break;
          }
          for (; i < this.iv; i++) {
            this.src[i] = "https://i.ibb.co/Dz4RB8x/imageedit-1-6482434810.png";
            this.starState[i] = true;
          }
          this.total = i;
        })
        .catch((ex) => {
          console.log(ex);
        });
    }
  },
  data() {
    return {
      aux: 0,
      total: 0,
      iv: this.initialValue,
      src: [
        "https://i.ibb.co/VxnZx4f/blank-star.png",
        "https://i.ibb.co/VxnZx4f/blank-star.png",
        "https://i.ibb.co/VxnZx4f/blank-star.png",
        "https://i.ibb.co/VxnZx4f/blank-star.png",
        "https://i.ibb.co/VxnZx4f/blank-star.png",
      ],
      starState: [false, false, false, false, false],
    };
  },
  methods: {
    fillStar(x) {
      if (this.editable) {
        this.total = x + 1;
        if (!this.starState[x]) {
          for (let i = 0; i < x; i++) {
            if (!this.starState[i]) {
              this.src[i] =
                "https://i.ibb.co/Dz4RB8x/imageedit-1-6482434810.png";
              this.starState[i] = true;
            }
          }
          this.aux++;
          this.src[x] = "https://i.ibb.co/Dz4RB8x/imageedit-1-6482434810.png";
          this.starState[x] = true;
        } else {
          if (!this.starState[1] && x == 0) {
            this.src[0] = "https://i.ibb.co/VxnZx4f/blank-star.png";
            this.starState[0] = false;
          } else
            for (let i = x + 1; i < 5; i++) {
              if (this.starState[i]) {
                this.src[i] = "https://i.ibb.co/VxnZx4f/blank-star.png";
                this.starState[i] = false;
              }
            }

          this.aux++;
        }
      }
    },
  },
};
</script>

<style scoped>
.star {
  width: 10%;
}
.aux {
  display: inline;
  background-color: red;
  white-space: nowrap;
}
</style>