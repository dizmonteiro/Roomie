<template>
  <div>
    <LandlordNavbar />
    <FormulateForm v-model="formData" @submit="submitProfile">
      <div id="llcard" class="card pad">
        <div class="columns is-desktop">
          <div
            class="column is-one-quarter-desktop is-full-mobile is-full-tablet"
          >
            <figure class="image avatar">
              <img
                class="is-rounded"
                id="profile-pic"
                v-bind:src="url + '/api/landlords/' + id + '/avatar'"
              />
              <div id="profile-pic-field">
                <FormulateInput
                  type="image"
                  name="file"
                  label="Profile Picture"
                  help="Select a png, jpg or gif to upload."
                  validation="mime:image/jpeg,image/png,image/gif"
                  upload-behavior="delayed"
                  :uploader="uploadFile"
                />
              </div>
            </figure>
            <div class="control">
              <div class="box adjust-gender">
                <FormulateInput
                  id="gender"
                  name="sex"
                  :options="{ female: 'Female', male: 'Male', other: 'Other' }"
                  type="radio"
                  label="Gender"
                  disabled
                />
              </div>
            </div>
          </div>
          <div
            class="column is-half-desktop is-full-mobile is-full-tablet form"
          >
            <div class="columns is-full-mobile is-full-tablet is-full-desktop">
              <div class="column is-half">
                <div class="field">
                  <FormulateInput
                    type="text"
                    name="name"
                    label="Name"
                    placeholder="Full Name"
                    validation="required"
                    disabled
                  />
                </div>
                <div class="field">
                  <FormulateInput
                    type="number"
                    name="nif"
                    label="NIF"
                    placeholder="NIF"
                    validation="number|min:9,length|max:9,length"
                    min="0"
                    max="999999999"
                    disabled
                  />
                </div>
                <div class="field">
                  <FormulateInput
                    type="email"
                    name="email"
                    label="Email"
                    placeholder="email"
                    validation="email"
                    disabled
                  />
                </div>
                <div class="field">
                  <FormulateInput
                    type="tel"
                    name="phone"
                    label="Phone Number"
                    placeholder="Phone Number"
                    validation="required"
                    disabled
                  />
                </div>
              </div>
              <div class="column is-half">
                <div class="field">
                  <FormulateInput
                    type="text"
                    name="username"
                    label="Username"
                    placeholder="Username"
                    validation="required"
                    disabled
                  />
                </div>
                <div class="field">
                  <FormulateInput
                    type="text"
                    name="address"
                    label="Address"
                    placeholder="Address"
                    validation="required"
                    disabled
                  />
                </div>
                <div class="field">
                  <FormulateInput
                    type="date"
                    name="birthDate"
                    label="Birth Date"
                    placeholder="dd/mm/yyyy"
                    min="1910-01-01"
                    disabled
                  />
                </div>
              </div>
            </div>
            <div class="field is-grouped is-grouped-right">
              <FormulateInput
                type="button"
                label="Edit Password"
                @click="editPassword()"
              />
              <FormulateInput
                type="submit"
                v-if="editable === false"
                v-bind:label="edit_text"
                @click="edit()"
              />
              <FormulateInput
                v-if="editable === true"
                type="button"
                label="Apply Changes"
                @click="edit()"
              />
            </div>
          </div>
          <div
            class="column adjust-hero is-one-quarter-desktop is-full-mobile is-full-tablet has-text-centered"
          >
            <SideMenuEditable link="/landlord/houses" title="Houses" :showMore="true">
              <div v-for="house in houseData" :key="house.i">
                <br />
                <SideMenuEntry
                  :imgSource="house.img"
                  :link="'/landlord/house/' + house.id"
                  :args="[
                    {
                      k1: 'house_name',
                      v1: house.title,
                      k2: 'house_location',
                      v2: house.address,
                      k3: 'house_slot',
                      v3: house.slots,
                    },
                  ]"
                />
              </div>
              <br />
            </SideMenuEditable>
          </div>
        </div>
      </div>
    </FormulateForm>
    <div id="change-password" class="modal">
      <div class="modal-background"></div>
      <FormulateForm @submit="submitPassword" #default="{ isLoading }">
        <div class="modal-content">
          <div class="box has-text-centered">
            <FormulateInput
              type="password"
              name="oldPassword"
              label="Old Password"
              placeholder="**********"
              validation="required"
            />
            <FormulateInput
              type="password"
              name="newPassword"
              label="New Password"
              placeholder="**********"
              validation="required|min:4,length"
            />
            <FormulateInput
              type="submit"
              :disabled="isLoading"
              :label="isLoading ? 'Updating...' : 'Change Password'"
            />
          </div>
        </div>
      </FormulateForm>

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
import SideMenuEditable from "@/components/SideMenuEditable";
import SideMenuEntry from "@/components/SideMenuEntry";
import { mapGetters, mapState } from "vuex";
import axios from "axios";
import store from "@/store";
import { url as api_url } from "@/assets/scripts/api";

export default {
  name: "LandlordProfile",
  components: {
    LandlordNavbar,
    SideMenuEditable,
    SideMenuEntry,
  },
  data: function () {
    return {
      houseData: undefined,
      editable: false,
      edit_text: "Edit",
      modal_active: "modal",
      url: api_url,
      formData: {
        username: "",
        name: "",
        sex: "",
        password: "",
        birthDate: "",
        file: "",
      },
    };
  },
  created() {
    axios
      .get(api_url + "/api/landlords/" + store.getters.getId)
      .then((response) => {
        this.formData = response.data;
        switch (this.formData.sex) {
          case "male":
            this.isMale = true;
            break;
          case "female":
            this.isFemale = true;
            break;
          case "other":
            this.isOther = true;
            break;
          default:
            console.log(this.formData.sex);
            break;
        }
        axios
          .get(api_url + "/api/landlords/" + store.getters.getId + "/houses")
          .then((res) => {
            this.houseData = res.data.splice(0, 3);
            for (var i = 1; i <= this.houseData.length; i++) {
              this.houseData[i - 1].i = i;
              this.houseData[i - 1].img = `${api_url}/api/houses/photos/${
                this.houseData[i - 1].photos[0]
              }`;
              this.houseData[i - 1].slots =
                "Slots: " +
                this.houseData[i - 1].availableRooms +
                "/" +
                this.houseData[i - 1].rooms;
            }
          })
          .catch((e) => {
            console.log(e);
          });
      })
      .catch((e) => {
        console.log(e);
      });
  },
  computed: {
    ...mapGetters(["getType", "getId"]),
    ...mapState({
      type: (state) => `${state.user.type}`,
      id: (state) => `${state.user.id}`,
    }),
  },
  methods: {
    /* eslint-disable-next-line */
    async uploadFile(file, progress, error, option) {
      console.log(file);
      this.formData.file = file;
    },
    edit() {
      this.editable = !this.editable;
      var inputs;
      var f = document.getElementById("profile-pic-field");

      if (this.editable) {
        this.edit_text = "Apply Changes";
        f.style.display = "block";
        inputs = document.getElementsByTagName("input");
        for (var i = 0; i < inputs.length; i++) {
          if (
            inputs[i].type.toLowerCase() != "password" &&
            inputs[i].type.toLowerCase() != "email" &&
            inputs[i].type.toLowerCase() != "number" &&
            inputs[i].type.toLowerCase() != "date"
          )
            inputs[i].disabled = false;
        }
      } else {
        this.edit_text = "Edit";
        f.style.display = "none";
        inputs = document.getElementsByTagName("input");
        for (var j = 0; j < inputs.length; j++) inputs[j].disabled = true;
      }

      var x = document.getElementById("profile-pic");
      if (x.style.display === "none") {
        x.style.display = "block";
      } else {
        x.style.display = "none";
      }
    },
    editPassword() {
      document.getElementById("change-password").classList.add("is-active");

      var inputs = document.getElementsByTagName("input");
      for (var i = 0; i < inputs.length; i++) {
        if (inputs[i].type.toLowerCase() == "password")
          inputs[i].disabled = false;
      }
    },
    closeModal() {
      document.getElementById("change-password").classList.remove("is-active");
      var inputs = document.getElementsByTagName("input");
      for (var i = 0; i < inputs.length; i++) {
        if (inputs[i].type.toLowerCase() == "password")
          inputs[i].disabled = true;
      }
    },
    async submitPassword(data) {
      await axios
        .put(
          api_url + "/api/landlords/" + store.getters.getId + "/password",
          data
        )
        .then(() => {
          this.closeModal();
        })
        .catch((e) => {
          alert(e);
        });
    },
    async submitProfile(data) {
      var bodyFormData = new FormData();
      bodyFormData.append("name", data.name);
      bodyFormData.append("username", data.username);
      bodyFormData.append("sex", data.sex);
      bodyFormData.append("address", data.address);
      bodyFormData.append("phone", data.phone);
      bodyFormData.append("file", this.formData.file);

      let options = {
        headers: {
          "Content-Type": "multipart/form-data",
        },
      };

      await axios
        .put(
          api_url + "/api/landlords/" + store.getters.getId,
          bodyFormData,
          options
        )
        .then(() => {
          alert("Profile Updated!");
        })
        .catch((e) => {
          alert(e);
        });
    },
  },
};
</script>


<style scoped>
.modal-content {
  width: 22vw;
}

strong {
  color: white;
}

.avatar {
  width: 20vw;
  height: 20vw;
  position: relative;
  display: block;
  margin: 15% auto 8% auto;
}

label {
  display: block;
}

.gender {
  margin: auto 22%;
}

.adjust-gender {
  width: 55%;
  margin: 0 auto;
}

.gender-label {
  text-align: center;
  margin: 0 auto 10% auto;
}

.bs {
  background-color: #2d6a4f;
}

.pad {
  width: 90%;
  margin: 3% auto;
}

.form {
  margin: 8% auto;
}

@media screen and (max-width: 1030px) {
  .form {
    margin: 8% auto;
    padding: 0 20%;
  }
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

#profile-pic-field {
  display: none;
}
</style>