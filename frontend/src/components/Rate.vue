<template>
  <div class="card rates">

    <div class="columns is-desktop" v-if="checkRates === 'tenant'">
      <div class="column has-text-centered is-half-desktop is-half-mobile is-half-tablet form">
        <div class="block">
          <figure class="image feature">
          <img
            src="@/assets/svg/sweeping.svg"
          />
          <label class="label">Tidiness</label>
          </figure>
          <StarRating
            class="stars"
            id="stars0"
            :initialValue="4"
            :editable="true"
          />
        </div>
        <div class="block">
          <figure class="image feature">
            <img
              src="@/assets/svg/washing-hands.png"
            />
            <label class="label">Cleanliness</label>
          </figure>
          <StarRating
            class="stars"
            id="stars1"
            :initialValue="1"
            :editable="true"
          />
        </div>
      </div>
      <div class="column has-text-centered is-half-desktop is-half-mobile is-half-tablet form">
        <div class="block">
          <figure class="image feature">
            <img
              src="@/assets/svg/padlock.png"
            />
            <label class="label">Privacy</label>
          </figure>
          <StarRating
            class="stars"
            id="stars2"
            :initialValue="3"
            :editable="true"
          />
        </div>
        <div class="block">
          <figure class="image feature">
            <img
              src="@/assets/svg/support.png"
            />
            <label class="label">Friendly</label>
          </figure>
          <StarRating
            class="stars"
            id="stars3"
            :initialValue="2"
            :editable="true"
          />
        </div>
      </div>
    </div>

    <div class="columns is-desktop" v-if="checkRates === 'landlord'">
      <div class="column has-text-centered is-one-quarter-desktop is-full-mobile is-full-tablet form">
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
          :editable="true"
        />
      </div>
      <div class="column has-text-centered is-one-quarter-desktop is-full-mobile is-full-tablet form">
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
          :editable="true"
        />
      </div>
      <div class="column has-text-centered is-one-quarter-desktop is-full-mobile is-full-tablet form">
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
          :editable="true"
        />
      </div>
    </div>

    <div class="buttons is-centered">
      <a class="button is-medium is-green is-rounded vm">
        Submit Ratings
      </a>
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
  width: 35%;
  height: 35%;
  margin: 0 auto;
}
.form {
  margin: 3% auto;
}
</style>