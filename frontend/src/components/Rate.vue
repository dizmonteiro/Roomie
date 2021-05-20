<template>
  <div class="card rates">
    <div
      class="columns is-desktop is-mobile is-tablet"
      v-if="checkr === 'tenant'"
    >
      <div
        class="column has-text-centered is-half-desktop is-half-mobile is-half-tablet form"
      >
        <div class="block">
          <figure class="image feature">
            <img src="@/assets/svg/tidiness.png" />
            <label class="label">Tidiness</label>
          </figure>
          <StarRating
            class="stars"
            id="stars0"
            :initialValue="ttidiness"
            :editable="true"
          />
        </div>
        <div class="block">
          <figure class="image feature">
            <img src="@/assets/svg/cleanliness.png" />
            <label class="label">Cleanliness</label>
          </figure>
          <StarRating
            class="stars"
            id="stars1"
            :initialValue="tcleanliness"
            :editable="true"
          />
        </div>
      </div>
      <div
        class="column has-text-centered is-half-desktop is-half-mobile is-half-tablet form"
      >
        <div class="block">
          <figure class="image feature">
            <img src="@/assets/svg/privacy.png" />
            <label class="label">Privacy</label>
          </figure>
          <StarRating
            class="stars"
            id="stars2"
            :initialValue="tprivacy"
            :editable="true"
          />
        </div>
        <div class="block">
          <figure class="image feature">
            <img src="@/assets/svg/friendliness.png" />
            <label class="label">Friendliness</label>
          </figure>
          <StarRating
            class="stars"
            id="stars3"
            :initialValue="tfriendliness"
            :editable="true"
          />
        </div>
      </div>
    </div>

    <div class="columns is-desktop" v-if="checkr === 'landlord'">
      <div
        class="column has-text-centered is-half-desktop is-half-mobile is-half-tablet form"
      >
        <div class="block">
          <figure class="image feature">
            <img src="@/assets/svg/payment.png" />
            <label class="label">Payment</label>
          </figure>
          <StarRating
            class="stars"
            id="stars0"
            :initialValue="tpayment"
            :editable="true"
          />
        </div>
        <div class="block">
          <figure class="image feature">
            <img src="@/assets/svg/cleanliness.png" />
            <label class="label">Cleanliness</label>
          </figure>
          <StarRating
            class="stars"
            id="stars1"
            :initialValue="tcleanliness"
            :editable="true"
          />
        </div>
      </div>
      <div
        class="column has-text-centered is-half-desktop is-half-mobile is-half-tablet form"
      >
        <div class="block">
          <figure class="image feature">
            <img src="@/assets/svg/tidiness.png" />
            <label class="label">Care</label>
          </figure>
          <StarRating
            class="stars"
            id="stars2"
            :initialValue="tcare"
            :editable="true"
          />
        </div>
      </div>
    </div>

    <div class="block">
      <div class="buttons is-centered">
        <a class="button is-medium is-green is-rounded vm"> {{this.tbuttonText}} </a>
      </div>
    </div>
  </div>
</template>

<script>
import StarRating from "@/components/StarRating";

export default {
  name: "rate",
  components: {
    StarRating,
  },
  props: [
    "usert",
    "rcleanliness",
    "rpayment",
    "rcare",
    "rtidiness",
    "rprivacy",
    "rfriendliness",
    "rbuttonText"
  ],
  data() {
    return {
      checkr: this.usert,
      tcleanliness: this.rcleanliness,
      tpayment: this.rpayment,
      tcare: this.rcare,
      ttidiness: this.rtidiness,
      tprivacy: this.rprivacy,
      tfriendliness: this.rfriendliness,
      tbuttonText: this.rbuttonText
    };
  },
  methods: {},
};
</script>

<style scoped>
.rates {
  padding: 2% 2% 4% 2%;
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