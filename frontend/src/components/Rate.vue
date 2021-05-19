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
            :initialValue="1"
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
            :initialValue="1"
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
            :initialValue="1"
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
            :initialValue="1"
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
            :initialValue="1"
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
            :initialValue="1"
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
            :initialValue="1"
            :editable="true"
          />
        </div>
      </div>
    </div>

    <div class="block">
      <div class="buttons is-centered">
        <a class="button is-medium is-green is-rounded vm"> Submit Rating </a>
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
  props: ["usert"],
  data() {
    return {
      checkr: this.usert,
    };
  },
  methods: {},
};
</script>

<style scoped>
.rates {
  padding: 3% 5% 3% 5%;
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