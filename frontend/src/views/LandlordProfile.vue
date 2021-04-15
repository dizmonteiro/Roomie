<template>
  <div>
    <LandlordNavbar />
    <div class="card pad">
      <div class="columns">
        <div class="column adjust-hero-s is-one-quarter">
          <figure class="image avatar">
            <img
              class="is-rounded"
              src="https://bulma.io/images/placeholders/128x128.png"
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
        <div class="column adjust-hero-s is-half form">
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
            </div>
            <div class="column auto">
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
                <label class="label">Address</label>
                <div class="control is-expanded">
                  <input
                    class="input"
                    type="text"
                    placeholder="Address"
                    name="address"
                    :readonly="editable"
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
        </div>
        <div class="column adjust-hero is-one-quarter has-text-centered">
          <SideMenu title="Houses" />
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
import LandlordNavbar from "@/components/LandlordNavbar";
import SideMenu from "@/components/SideMenu";

export default {
  name: "LandlordProfile",
  components: {
    LandlordNavbar,
    SideMenu,
  },
  data() {
    return {
      editable: true,
      edit_text: "Edit",
      modal_active: "modal",
    };
  },
  methods: {
    edit() {
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
  margin: 0 auto;
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
  width: 80%;
  margin: 7% auto;
}

.adjust-hero-s {
  margin-top: 5%;
}
</style>