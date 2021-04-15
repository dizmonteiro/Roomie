<template>
  <div id="filler" class="is-flex is-flex-direction-column">
    <LandlordNavbar />
    <div class="columns">
      <div class="column is-one-quarter">
        <figure class="image avatar">
          <img
            class="is-rounded"
            src="https://bulma.io/images/placeholders/128x128.png"
          />
        </figure>
        <div class="control">
          <div class="box">
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
      <div class="column is-half form">
        <div class="columns">
          <div class="column is-half">
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
            <div class="field">
              <label class="label">NIF</label>
              <div class="control is-expanded">
                <input class="input" type="text" placeholder="NIF" name="nif" :readonly="editable"/>
              </div>
            </div>
            <div class="field">
              <label class="label">Email</label>
              <div class="control is-expanded">
                <input
                  class="input"
                  type="email"
                  placeholder="Email"
                  name="email" :readonly="editable"
                />
              </div>
            </div>
            <div class="field">
              <label class="label">Phone Number</label>
              <p class="control">
                <input class="input" type="tel" placeholder="(+351) XXX XXX XXX" name="phone" :readonly="editable">
              </p>
            </div>
          </div>
          <div class="column auto">
            <div class="field">
              <label class="label">Username</label>
              <div class="control">
                <input
                  class="input"
                  type="text"
                  placeholder="Username"
                  name="username" :readonly="editable"
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
              <label class="label">Address</label>
              <div class="control is-expanded">
                <input class="input" type="text" placeholder="Address" name="address" :readonly="editable">
              </div>
            </div>
            <div class="field">
              <label class="label">Birth Date</label>
              <div class="control is-expanded">
                <input class="input" type="date" placeholder="yyyy-mm-dd" name="dob" :readonly="editable">
              </div>
            </div>
          </div>
        </div>
              <div class="control to-bottom">
                <button class="button is-primary" value="edit-pass" @click="edit()">
                  Edit password
                </button>
                <button class="button is-primary edit-button" value="edit" @click="edit()">
                  Edit
                </button>
              </div>
      </div>
      <div class="column is-one-quarter has-text-centered">
          <div>
            <label class="label">
                Houses
            </label>
          </div>
      </div>
    </div>
  </div>
</template>

<script>
import LandlordNavbar from "@/components/LandlordNavbar";

export default {
  name: "LandlordProfile",
  components: {
    LandlordNavbar,
  },
  data() {
    return {
      editable: true,
    };
  },
  methods: {
    edit() {
      this.editable = !this.editable;
    },
  },
};
</script>


<style scoped>
#filler {
  min-height: 67vh;
}
.avatar {
  width: 80%;
  box-sizing: border-box;
  margin: 28% auto 10% auto;
}
label {
  display: block;
}
.center {
    margin: 0 0;
}
.gender {
  margin: auto 24%;
}

.gender-label {
  text-align: center;
  margin: 0 auto 10% auto;
}
.column{
    outline-style: solid;
}
.box {
  padding-top: 3%;
  margin: 0 auto;
  width: 40%;
}
.form{
    margin-top:7%;
}
.edit-button{
    margin-left: 10%;
}
.to-bottom{
    box-sizing: border-box;
    margin: 5% 0 0 75%;
}
.container{
    width: 80%;
    height: 80%;
    border-radius: 5%;
    margin:15% auto;
    box-sizing: border-box;
    background-color: rgb(216, 250, 200);
}
</style>