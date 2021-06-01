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
            :toSubmit="true"
            id="tidiness"
            :tid="this.ttenantid"
            :initialValue="0"
            :editable="true"
            feature="tidiness"
          />
        </div>
        <div class="block">
          <figure class="image feature">
            <img src="@/assets/svg/cleanliness.png" />
            <label class="label">Cleanliness</label>
          </figure>
          <StarRating
            class="stars"
            :toSubmit="true"
            id="cleanliness"
            :tid="this.ttenantid"
            :initialValue="0"
            :editable="true"
            feature="cleanliness"
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
            :toSubmit="true"
            id="privacy"
            :tid="this.ttenantid"
            :initialValue="0"
            :editable="true"
            feature="privacy"
          />
        </div>
        <div class="block">
          <figure class="image feature">
            <img src="@/assets/svg/friendliness.png" />
            <label class="label">Friendliness</label>
          </figure>
          <StarRating
            class="stars"
            :toSubmit="true"
            id="friendliness"
            :tid="this.ttenantid"
            :initialValue="0"
            :editable="true"
            feature="friendliness"
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
            :toSubmit="true"
            id="payment"
            :tid="this.ttenantid"
            :initialValue="0"
            :editable="true"
            feature="payment"
          />
        </div>
        <div class="block">
          <figure class="image feature">
            <img src="@/assets/svg/cleanliness.png" />
            <label class="label">Cleanliness</label>
          </figure>
          <StarRating
            class="stars"
            :toSubmit="true"
            id="cleanliness"
            :tid="this.ttenantid"
            :initialValue="0"
            :editable="true"
            feature="cleanliness"
          />
        </div>
      </div>
      <div
        class="column has-text-centered is-half-desktop is-half-mobile is-half-tablet form"
      >
        <div class="block">
          <figure class="image feature">
            <img src="@/assets/svg/care.png" />
            <label class="label">Care</label>
          </figure>
          <StarRating
            class="stars"
            :toSubmit="true"
            id="care"
            :tid="this.ttenantid"
            :initialValue="0"
            :editable="true"
            feature="care"
          />
        </div>
      </div>
    </div>

    <div class="block">
      <div class="buttons is-centered">
        <a
          class="button is-medium is-green is-rounded vm"
          @click="submitRL"
          v-if="checkr === 'landlord'"
        >
          {{ this.tbuttonText }}
        </a>
        <a
          class="button is-medium is-green is-rounded vm"
          @click="submitRT"
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
  props: ["usert", "rbuttonText", "tenantid", "houseid"],
  data() {
    return {
      checkr: this.usert,
      tbuttonText: this.rbuttonText,
      ttenantid: this.tenantid,
      thouseid: this.houseid,
      dec: false,
    };
  },
  methods: {
    async submitRT() {
      if (this.tbuttonText !== "Already Submited") {
        var vti = document
          .getElementById("tidiness")
          .outerHTML.split("value=")[1]
          .split('"')[1];
        var vcl = document
          .getElementById("cleanliness")
          .outerHTML.split("value=")[1]
          .split('"')[1];
        var vpr = document
          .getElementById("privacy")
          .outerHTML.split("value=")[1]
          .split('"')[1];
        var vfr = document
          .getElementById("friendliness")
          .outerHTML.split("value=")[1]
          .split('"')[1];
        var rateInfoT = {
          houseId: parseInt(this.thouseid),
          tidiness: parseInt(vti),
          cleanliness: parseInt(vcl),
          privacy: parseInt(vpr),
          friendliness: parseInt(vfr),
        };
        console.log(rateInfoT);

        await axios
          .post(
            api_url + "/api/evaluations/tenant/" + this.ttenantid,
            rateInfoT
          )
          .then(() => {
            console.log("sucess!");
          })
          .catch((e) => {
            alert(e);
          });
        this.tbuttonText = "Already Submited";
      }
    },
    async submitRL() {
      if (this.tbuttonText !== "Already Submited") {
        var vclan = document
          .getElementById("cleanliness")
          .outerHTML.split("value=")[1]
          .split('"')[1];
        var vpay = document
          .getElementById("payment")
          .outerHTML.split("value=")[1]
          .split('"')[1];
        var vcar = document
          .getElementById("care")
          .outerHTML.split("value=")[1]
          .split('"')[1];
        var rateInfoL = {
          houseId: parseInt(this.thouseid),
          cleanliness: parseInt(vclan),
          payment: parseInt(vpay),
          care: parseInt(vcar),
        };
        console.log(rateInfoL);

        await axios
          .post(
            api_url + "/api/evaluations/landlord/" + this.ttenantid,
            rateInfoL
          )
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