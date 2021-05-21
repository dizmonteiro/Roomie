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
        <a
          class="button is-medium is-green is-rounded vm"
          @click="submitRL(4, 4, 4)"
          v-if="checkr === 'landlord'"
        >
          {{ this.tbuttonText }}
        </a>
        <a
          class="button is-medium is-green is-rounded vm"
          @click="submitRT(4, 4, 4, 4)"
          v-if="checkr === 'tenant'"
        >
          {{ this.tbuttonText }}
        </a>
      </div>
    </div>
  </div>
</template>

<script>
import StarRating from "@/components/StarRating";
import axios from "axios";
import { url as api_url } from "@/assets/scripts/api";

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
    "rbuttonText",
    "tenantid",
    "houseid",
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
      tbuttonText: this.rbuttonText,
      ttenantid: this.tenantid,
      thouseid: this.houseid,
    };
  },
  methods: {
    async submitRL(r1, r2, r3) {
      if (this.tbuttonText !== "Already Submited") {
        var rateInfoL = {
          houseId: this.thouseid,
          cleanliness: r1,
          payment: r2,
          care: r3,
        };

        await axios
          .put(api_url + "/api/evaluations/1" + this.ttenantid, rateInfoL)
          .then(() => {
            console.log("sucess!");
          })
          .catch((e) => {
            alert(e);
          });
        this.tbuttonText = "Already Submited";
      }
    },
    async submitRT(r4, r5, r6, r7) {
      if (this.tbuttonText !== "Already Submited") {
        var rateInfoT = {
          houseId: this.thouseid,
          tidiness: r4,
          cleanliness: r5,
          privacy: r6,
          friendliness: r7
          
        };

        await axios
          .put(api_url + "/api/evaluations/1" + this.ttenantid, rateInfoT)
          .then(() => {
            console.log("sucess!");
          })
          .catch((e) => {
            alert(e);
          });
        this.tbuttonText = "Already Submited";
      }
    },
  },
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