<template>
  <div>
    <TenantNavbar />
    <div id="llcard" class="card pad">
      <div class="columns is-desktop">
        <div
          class="column is-one-quarter-desktop is-full-mobile is-full-tablet"
        >
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
          class="column is-half-desktop is-full-mobile is-full-tablet form"
        >
          <div class="field">
            <label class="label">Name</label>
            <div class="control">
              <input
                class="input"
                type="text"
                placeholder="Full Name"
                name="name"
                :readonly="editable"
              />
            </div>
          </div>
          <div class="columns">
            <div class="column is-half">
              <div class="field">
                <label class="label">NIF</label>
                <div class="control is-expanded">
                  <input
                    class="input"
                    type="text"
                    placeholder="NIF"
                    name="nif"
                    :readonly="editable"
                  />
                </div>
              </div>
              <div class="field">
                <label class="label">Email</label>
                <div class="control is-expanded">
                  <input
                    class="input"
                    type="email"
                    placeholder="Email"
                    name="email"
                    :readonly="editable"
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
                    :readonly="editable"
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
                    :readonly="editable"
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
                    :readonly="editable"
                  />
                </div>
              </div>
              <div class="field">
                <label class="label">Password</label>
                <div class="control is-expanded">
                  <input
                    class="input"
                    type="password"
                    placeholder="Password"
                    name="password"
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
                    :readonly="editable"
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
                    :readonly="editable"
                  />
                </div>
              </div>
            </div>
          </div>
          <div class="field is-grouped is-grouped-right">
            <p class="control">
              <a
                class="button is-primary"
                value="edit-password"
                @click="editPassword()"
              >
                Edit Password
              </a>
            </p>
            <p class="control">
              <a class="button is-light" value="edit" @click="edit()">
                {{ edit_text }}
              </a>
            </p>
          </div>
          <div class="card rates">
            <div class="columns is-desktop">
              <div
                class="column is-one-quarter-desktop is-full-mobile is-full-tablet form"
              >
                <figure class="image feature">
                  <img
                    class="is-rounded"
                    src="https://picsum.photos/200"
                  />
                </figure>
                <StarRating class="stars" id="stars0" :initialValue="4" :editable="false"/>
              </div>
              <div
                class="column is-one-quarter-desktop is-full-mobile is-full-tablet form"
              >
                <figure class="image feature">
                  <img
                    class="is-rounded"
                    src="https://picsum.photos/200"
                  />
                </figure>
                <StarRating class="stars" id="stars1" :initialValue="1" :editable="false"/>
              </div>
              <div
                class="column is-one-quarter-desktop is-full-mobile is-full-tablet form"
              >
                <figure class="image feature">
                  <img
                    class="is-rounded"
                    src="https://picsum.photos/200"
                  />
                </figure>
                <StarRating class="stars" id="stars2" :initialValue="3" :editable="false"/>
              </div>
              <div
                class="column is-one-quarter-desktop is-full-mobile is-full-tablet form"
              >
                <figure class="image feature">
                  <img
                    class="is-rounded"
                    src="https://picsum.photos/200"
                  />
                </figure>
                  <StarRating class="stars" id="stars3" :initialValue="2" :editable="false"/>
                
              </div>
            </div>
          </div>
        </div>
        <div
          class="column is-one-quarter-desktop is-full-mobile is-full-tablet has-text-centered"
        >
          <SideMenuEditable class="toMargin" title="My Rent History">
            <template v-slot:firstEntry>
              <SideMenuEntry
                imgSource="https://thisrentaldoesnotexist.com/img-new/hero.jpg"
                :args="[
                  {
                    k1: 'from_date',
                    v1: 'From:01/01/2021',
                    k2: 'to_date',
                    v2: 'To:01/02/2021',
                    k3: 'landlord',
                    v3: 'Landord1',
                  },
                ]"
              />
            </template>
            <template v-slot:secondEntry>
              <SideMenuEntry
                imgSource="https://thisrentaldoesnotexist.com/img-new/hero.jpg"
                :args="[
                  {
                    k1: 'from_date',
                    v1: 'From:01/03/2021',
                    k2: 'to_date',
                    v2: 'To:01/04/2021',
                    k3: 'landlord',
                    v3: 'Landord2',
                  },
                ]"
              />
            </template>
            <template v-slot:thirdEntry>
              <SideMenuEntry
                imgSource="https://thisrentaldoesnotexist.com/img-new/hero.jpg"
                :args="[
                  {
                    k1: 'from_date',
                    v1: 'From:01/05/2021',
                    k2: 'to_date',
                    v2: 'To:01/06/2021',
                    k3: 'landlord',
                    v3: 'Landord3',
                  },
                ]"
              />
            </template>
          </SideMenuEditable>
        </div>
      </div>
    </div>
    <div id="change-password" class="modal">
      <div class="modal-background"></div>
      <div class="modal-content">
        <div class="box has-text-centered">
          <div class="field">
            <label class="label is-left">Old Password</label>
            <div class="control">
              <input
                class="input"
                type="password"
                placeholder="Old password"
                id="old-password"
                required
              />
            </div>
          </div>
          <div class="field">
            <label class="label">New Password</label>
            <div class="control">
              <input
                class="input"
                type="password"
                placeholder="New password"
                id="new-password"
                required
              />
            </div>
          </div>
          <a
            class="button is-primary is-centered"
            value="pwd-change"
            @click="closeModal()"
          >
            Change Password
          </a>
        </div>
      </div>

      <button
        class="modal-close is-large"
        aria-label="close"
        value="close-modal"
        @click="closeModal()"
      ></button>
    </div>
  </div>
</template>

<script>
import TenantNavbar from "@/components/TenantNavbar";
import SideMenuEditable from "@/components/SideMenuEditable";
import SideMenuEntry from "@/components/SideMenuEntry";
import StarRating from "@/components/StarRating";

export default {
  name: "TenantProfile",
  components: {
    TenantNavbar,
    SideMenuEditable,
    SideMenuEntry,
    StarRating,
  },
  data() {
    return {
      editable: true,
      ss:24,
      edit_text: "Edit",
      modal_active: "modal",
      ratings: [{ rate: 3.25 }, { rate: 2.75 }, { rate: 4.75 }, { rate: 2.75 }],
    };
  },
  methods: {
    setRating0: function (rating) {
      this.ratings[0].rate = rating;
    },
    setRating1: function (rating) {
      this.ratings[1].rate = rating;
    },
    setRating2: function (rating) {
      this.ratings[2].rate = rating;
    },
    setRating3: function (rating) {
      this.ratings[3].rate = rating;
    },
    edit() {
      console.log(document.getElementById("stars3").getAttribute("value"));
      if (this.editable) this.edit_text = "Apply Changes";
      else this.edit_text = "Edit";
      this.editable = !this.editable;
    },
    editPassword() {
      document.getElementById("change-password").classList.add("is-active");
    },
    closeModal() {
      document.getElementById("change-password").classList.remove("is-active");
    },
  },
};
</script>


<style scoped>
.avatar {
  width: 80%;
  margin: 25% auto 8% auto;
}
label {
  display: block;
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
  margin: 3% auto;
}

star-rating {
  background-color: red;
}

.form {
  margin: 1% auto;
}

.rates{
  padding: 1% 5% 1% 5%;
}
.stars {
  margin: 3% auto;
}
.feature{
  border-style: solid;
  border-width: 5%;
  border-color: black;
  border-radius: 50%;
}

.toMargin{
  margin:4% auto;
}

</style>