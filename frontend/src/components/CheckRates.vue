<template>
  <div class="card rates">
    <div class="control">
      <div class="columns">
        <div class="column is-half has-text-centered">
          <label class="label radio">
            <input
              type="radio"
              :name="'rates' + tid + '_' + hid"
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
              :name="'rates' + tid + '_' + hid"
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
          <img src="@/assets/svg/tidiness.png" />
          <label class="label">Tidiness</label>
        </figure>
        <StarRating
          class="stars"
          :toSubmit="false"
          :tid="this.tid"
          :initialValue="0"
          :editable="false"
          feature="tidiness"
        />
      </div>
      <div
        class="column has-text-centered is-one-quarter-desktop is-full-mobile is-full-tablet form"
      >
        <figure class="image feature">
          <img src="@/assets/svg/cleanliness.png" />
          <label class="label">Cleanliness</label>
        </figure>
        <StarRating
          class="stars"
          :toSubmit="false"
          :tid="this.tid"
          :initialValue="0"
          :editable="false"
          feature="cleanliness"
        />
      </div>
      <div
        class="column has-text-centered is-one-quarter-desktop is-full-mobile is-full-tablet form"
      >
        <figure class="image feature">
          <img src="@/assets/svg/privacy.png" />
          <label class="label">Privacy</label>
        </figure>
        <StarRating
          class="stars"
          :toSubmit="false"
          :tid="this.tid"
          :initialValue="0"
          :editable="false"
          feature="privacy"
        />
      </div>
      <div
        class="column has-text-centered is-one-quarter-desktop is-full-mobile is-full-tablet form"
      >
        <figure class="image feature">
          <img src="@/assets/svg/friendliness.png" />
          <label class="label">Friendliness</label>
        </figure>
        <StarRating
          class="stars"
          :toSubmit="false"
          :tid="this.tid"
          :initialValue="0"
          :editable="false"
          feature="friendliness"
        />
      </div>
    </div>
    <div class="columns is-desktop" v-if="checkRates === 'landlord'">
      <div
        class="column has-text-centered is-one-quarter-desktop is-full-mobile is-full-tablet form"
      >
        <figure class="image feature">
          <img src="@/assets/svg/cleanliness.png" />
          <label class="label">Cleanliness</label>
        </figure>
        <StarRating
          class="stars"
          :toSubmit="false"
          :tid="this.tid"
          :initialValue="0"
          :editable="false"
          feature="cleanliness"
        />
      </div>
      <div
        class="column has-text-centered is-one-quarter-desktop is-full-mobile is-full-tablet form"
      >
        <figure class="image feature">
          <img src="@/assets/svg/payment.png" />
          <label class="label">Payment</label>
        </figure>
        <StarRating
          class="stars"
          :toSubmit="false"
          :tid="this.tid"
          :initialValue="0"
          :editable="false"
          feature="payment"
        />
      </div>
      <div
        class="column has-text-centered is-one-quarter-desktop is-full-mobile is-full-tablet form"
      >
        <figure class="image feature">
          <img src="@/assets/svg/care.png" />
          <label class="label">Care</label>
        </figure>
        <StarRating
          class="stars"
          :toSubmit="false"
          :tid="this.tid"
          :initialValue="0"
          :editable="false"
          feature="care"
        />
      </div>
    </div>
  </div>
</template>

<script>
import StarRating from "@/components/StarRating";
export default {
  components: {
    StarRating,
  },
  props: ["tid", "hid"],
  data() {
    return {
      checkRates: "tenant",
    };
  },
  methods: {
    changeRatings() {
      var radios = document.getElementsByName(
        "rates" + this.tid + "_" + this.hid
      );
      if (radios[0].checked) this.checkRates = "tenant";
      else if (radios[1].checked) this.checkRates = "landlord";
    },
  },
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