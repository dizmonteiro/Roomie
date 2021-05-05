<template>
  <div class="card rates">
    <div class="control">
      <div class="columns">
        <div class="column is-half has-text-centered">
          <label class="label radio">
            <input
              type="radio"
              name="rates"
              value="tenant"
              @click="changeRatings"
              checked
            />
            Tenant Ratings
          </label>
        </div>
        <div class="column is-half has-text-centered">
          <label class="label radio">
            <input
              type="radio"
              name="rates"
              value="landlord"
              @click="changeRatings"
            />
            Landlord Ratings
          </label>
        </div>
      </div>
    </div>
    <div class="columns is-desktop" v-if="checkRates === 'tenant'">
      <div
        class="column has-text-centered is-one-quarter-desktop is-full-mobile is-full-tablet form"
      >
        <figure class="image feature">
          <img
            src="https://www.flaticon.com/svg/vstatic/svg/3553/3553705.svg?token=exp=1619449916~hmac=0bdb944ac4edb8e37aadec0091021a17"
          />
          <label class="label">Tidiness</label>
        </figure>

        <StarRating
          class="stars"
          id="stars0"
          :initialValue="4"
          :editable="false"
        />
      </div>
      <div
        class="column has-text-centered is-one-quarter-desktop is-full-mobile is-full-tablet form"
      >
        <figure class="image feature">
          <img
            src="https://www.flaticon.com/svg/vstatic/svg/995/995053.svg?token=exp=1619450061~hmac=322835d6cba382d1123a60fa8eac3f00"
          />
          <label class="label">Cleanliness</label>
        </figure>
        <StarRating
          class="stars"
          id="stars1"
          :initialValue="1"
          :editable="false"
        />
      </div>
      <div
        class="column has-text-centered is-one-quarter-desktop is-full-mobile is-full-tablet form"
      >
        <figure class="image feature">
          <img
            src="https://www.flaticon.com/svg/vstatic/svg/3064/3064197.svg?token=exp=1619450142~hmac=2f52134711944337feb847ece08a69d6"
          />
          <label class="label">Privacy</label>
        </figure>
        <StarRating
          class="stars"
          id="stars2"
          :initialValue="3"
          :editable="false"
        />
      </div>
      <div
        class="column has-text-centered is-one-quarter-desktop is-full-mobile is-full-tablet form"
      >
        <figure class="image feature">
          <img
            src="https://www.flaticon.com/svg/vstatic/svg/1441/1441180.svg?token=exp=1619450220~hmac=c5265f738f2134dc4ed81bf596519587"
          />
          <label class="label">Friendly</label>
        </figure>
        <StarRating
          class="stars"
          id="stars3"
          :initialValue="2"
          :editable="false"
        />
      </div>
    </div>
    <div class="columns is-desktop" v-if="checkRates === 'landlord'">
      <div
        class="column has-text-centered is-one-quarter-desktop is-full-mobile is-full-tablet form"
      >
        <figure class="image feature">
          <img
            src="https://www.flaticon.com/svg/vstatic/svg/995/995053.svg?token=exp=1619450061~hmac=322835d6cba382d1123a60fa8eac3f00"
          />
          <label class="label">Cleanliness</label>
        </figure>
        <StarRating
          class="stars"
          id="sl1"
          :initialValue="1"
          :editable="false"
        />
      </div>
      <div
        class="column has-text-centered is-one-quarter-desktop is-full-mobile is-full-tablet form"
      >
        <figure class="image feature">
          <img
            src="https://www.flaticon.com/svg/vstatic/svg/1077/1077976.svg?token=exp=1619452267~hmac=4c0d73bd889ea71b90090bab54052470"
          />
          <label class="label">Payment</label>
        </figure>
        <StarRating
          class="stars"
          id="sl2"
          :initialValue="3"
          :editable="false"
        />
      </div>
      <div
        class="column has-text-centered is-one-quarter-desktop is-full-mobile is-full-tablet form"
      >
        <figure class="image feature">
          <img
            src="https://www.flaticon.com/svg/vstatic/svg/2797/2797659.svg?token=exp=1619452340~hmac=ee7fc2d860e4e94947777d8428792449"
          />
          <label class="label">Care</label>
        </figure>
        <StarRating
          class="stars"
          id="sl3"
          :initialValue="2"
          :editable="false"
        />
      </div>
    </div>
  </div>
</template>

<script>
import StarRating from "@/components/StarRating";
export default {
    components:{
        StarRating
    },
    data(){
        return{
            checkRates:"tenant"
        }
    },
    methods:{
        changeRatings() {
      var radios = document.getElementsByName("rates");
      if (radios[0].checked) this.checkRates = "tenant";
      else if (radios[1].checked) this.checkRates = "landlord";
    },
    }
};
</script>

<style scoped>
.rates {
  padding: 1% 5% 1% 5%;
}
.stars {
  margin: 3% auto;
}
.feature {
  width: 80%;
  height: 80%;
  margin: 0 auto;
}
.form {
  margin: 3% auto;
}
</style>