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

    <div
      class="columns is-desktop is-mobile is-tablet"
      v-if="checkr === 'landlord'"
    >
      <div
        class="column has-text-centered is-one-third-desktop is-one-third-mobile is-one-third-tablet form"
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
      </div>
      <div
        class="column has-text-centered is-one-third-desktop is-one-third-mobile is-one-third-tablet form"
      >
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
        class="column has-text-centered is-one-third-desktop is-one-third-mobile is-one-third-tablet form"
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
        <a class="button is-medium is-green is-rounded vm" @click="doSubmit">
          Submit Rating
        </a>
      </div>
    </div>
    <div id="confirmation" class="modal">
      <div class="modal-background"></div>
      <div class="modal-content">
        <div class="box is-centered has-text-centered">
          <h1 class="title">Are you sure?</h1>
          <button class="button d is-green" @click="decide()">
            Confirm
          </button>
          <button class="button d is-green" @click="closeModal()">
            Close
          </button>
        </div>
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
  props: ["usert", "tenantid", "houseid"],
  data() {
    return {
      checkr: this.usert,
      ttenantid: this.tenantid,
      thouseid: this.houseid,
      dec: false,
    };
  },
  methods: {
    async submitRT() {
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
        .post(api_url + "/api/evaluations/tenant/" + this.ttenantid, rateInfoT)
        .then(() => {
          console.log("sucess!");
          this.$router.push("/tenant/rhistory");
        })
        .catch((e) => {
          alert(e);
        });
    },
    async submitRL() {
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
          this.$router.push("/landlord/houses");
        })
        .catch((e) => {
          alert(e);
        });
    },
    async decide() {
      if (this.dec) {
        if (this.checkr === "landlord") {
          this.submitRL();
        } else {
          this.submitRT();
        }
      }
      document.getElementById("confirmation").classList.remove("is-active");
      if (this.dec) alert("Rating has been accepted!");
    },
    async closeModal() {
      document.getElementById("confirmation").classList.remove("is-active");
    },
    async doSubmit() {
      this.dec = true;
      document.getElementById("confirmation").classList.add("is-active");
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
  width: 45%;
  height: 45%;
  margin: 0 auto;
}
.form {
  margin: 3% auto;
}

.avatar {
  width: 15vmax;
  height: 15vmax;
  position: relative;
  display: block;
  margin: 11% auto 8% auto;
}
#profile-pic {
  position: absolute;
  object-fit: cover;
  object-position: center;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  width: 100%;
  height: 100%;
}
.d {
  margin: 0 3%;
}
.ap {
  width: 100%;
}
.teste {
  max-width: 150%;
  width: 150%;
  margin: 0 auto;
}
.sInfo {
  margin: 40% auto;
}
.sCheck {
  margin: 4% auto 1% auto;
}
.rez {
  width: 100%;
}
.tInfo {
  margin: 12% auto;
  padding: auto 40%;
  border-style: solid;
  border-color: #2d6a4f;
}
.sBox {
  margin: 6% auto;
}
.date {
  margin-right: 5%;
  margin-left: 5%;
  display: inline-block;
}

.colContent {
  margin: 0 auto;
}
.llp {
  width: 60%;
  margin-bottom: 5%;
  margin-top: 5%;
}
.sCard {
  margin: 0 auto 1% auto;
  width: 80%;
}
</style>

