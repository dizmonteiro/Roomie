<template>
  <div>
    <div v-if="type === 'tenant'">
      <TenantNavbar />
    </div>
    <div v-else-if="type === 'landlord'">
      <LandlordNavbar />
    </div>
    <div id="llcard" class="card pad">
      <div class="columns is-desktop">
        <div class="column is-one-third-desktop is-full-mobile is-full-tablet">
          <figure class="image avatar">
            <img
              class="is-rounded"
              src="https://thisrentaldoesnotexist.com/img-new/face.jpg"
            />
          </figure>
          <div class="control">
            <div class="box adjust-gender">
              <label class="label gender-label">Gender</label>
              <label class="radio gender">
                <input type="radio" name="gender" value="female" disabled />
                Female
              </label>
              <label class="radio gender">
                <input type="radio" name="gender" value="male" disabled />
                Male
              </label>
              <label class="radio gender">
                <input type="radio" name="gender" value="other" disabled />
                Other
              </label>
            </div>
          </div>
        </div>
        <div
          class="column is-two-thirds-desktop is-full-mobile is-full-tablet form"
        >
          <div class="field">
            <label class="label">Name</label>
            <div class="control">
              <input
                class="input"
                type="text"
                placeholder="Full Name"
                name="name"
                readonly
              />
            </div>
          </div>
          <div class="columns">
            <div class="column is-half">
              <div class="field">
                <label class="label">Email</label>
                <div class="control is-expanded">
                  <input
                    class="input"
                    type="email"
                    placeholder="Email"
                    name="email"
                    readonly
                  />
                </div>
              </div>
              <div class="field">
                <label class="label">Phone Number</label>
                <p class="control">
                  <input
                    class="input"
                    type="tel"
                    placeholder="(+351) XXX XXX XXX"
                    name="phone"
                    readonly
                  />
                </p>
              </div>
              <div class="field">
                <label class="label">Nationality</label>
                <div class="control">
                  <input
                    class="input"
                    type="text"
                    placeholder="Portuguese"
                    name="ocupation"
                    readonly
                  />
                </div>
              </div>
            </div>
            <div class="column is-half">
              <div class="field">
                <label class="label">Username</label>
                <div class="control">
                  <input
                    class="input"
                    type="text"
                    placeholder="Username"
                    name="username"
                    readonly
                  />
                </div>
              </div>
              <div class="field">
                <label class="label">Birth Date</label>
                <div class="control is-expanded">
                  <input
                    class="input"
                    type="date"
                    placeholder="yyyy-mm-dd"
                    name="dob"
                    readonly
                  />
                </div>
              </div>
              <div class="field">
                <label class="label">Occupation</label>
                <div class="control">
                  <input
                    class="input"
                    type="text"
                    placeholder="Student"
                    name="ocupation"
                    readonly
                  />
                </div>
              </div>
            </div>
          </div>
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
                    src="https://www.flaticon.com/svg/vstatic/svg/1077/1077976.svg?token=exp=1619452267~hmac=4c0d73bd889ea71b90090bab54052470"
                  />
                  <label class="label">Payment</label>
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
                    src="https://www.flaticon.com/svg/vstatic/svg/2797/2797659.svg?token=exp=1619452340~hmac=ee7fc2d860e4e94947777d8428792449"
                  />
                  <label class="label">House Care</label>
                </figure>
                <StarRating
                  class="stars"
                  id="stars3"
                  :initialValue="2"
                  :editable="false"
                />
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import TenantNavbar from "@/components/TenantNavbar";
import StarRating from "@/components/StarRating";
import { mapGetters, mapState } from "vuex";

export default {
  name: "TenantProfile",
  components: {
    TenantNavbar,
    StarRating,
  },
  methods: {
    changeRatings() {
      var radios = document.getElementsByName("rates");
      if (radios[0].checked) this.checkRates = "tenant";
      else if (radios[1].checked) this.checkRates = "landlord";
    },
  },
  computed: {
    ...mapGetters(["getType"]),
    ...mapState({
      type: (state) => `${state.user.type}`,
    }),
  },
  data() {
    return {
      checkRates: "tenant",
    };
  },
};
</script>


<style scoped>
.center {
  font-size: 1vmax;
}
strong {
  color: white;
}
.avatar {
  width: 80%;
  margin: 5% auto 8% auto;
}
.gender {
  margin: auto 22%;
}
.adjust-gender {
  width: 50%;
  margin: 0 auto;
}
.gender-label {
  text-align: center;
  margin: 0 auto 10% auto;
}

.pad {
  background-color: white;
  width: 90%;
  margin: 6% auto;
}
.bs {
  background-color: #2d6a4f;
}

.form {
  margin: 1% auto;
}

.rates {
  padding: 1% 5% 1% 5%;
  margin: 0 5%;
}
.stars {
  margin: 3% auto;
}
.feature {
  width: 80%;
  height: 80%;
  margin: 0 auto;
}
.toMargin {
  margin: 4% auto;
}

.llr{
  margin: 0 5% 0 auto;
}
</style>