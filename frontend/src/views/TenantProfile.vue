<template>
  <div>
    <TenantNavbar />

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
                v-bind:src="url + '/api/tenants/' + id + '/avatar'"
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
            <div class="columns">
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
                    type="date"
                    name="birthDate"
                    label="Birth Date"
                    placeholder="dd/mm/yyyy"
                    min="1910-01-01"
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
                    name="occupation"
                    label="Occupation"
                    placeholder="Occupation"
                    validation="required"
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
                <div class="field">
                  <FormulateInput
                    name="nationality"
                    :options="countries"
                    type="select"
                    placeholder="'data.nationality'"
                    label="Nationality"
                    validation="required"
                    disabled
                  />
                </div>
              </div>
            </div>
            <div class="field is-grouped is-grouped-right">
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
            <check-rates :tid="id" />
          </div>
          <div
            class="column is-one-quarter-desktop is-full-mobile is-full-tablet has-text-centered"
          >
            <SideMenuEditable
              link="/tenant/rhistory"
              class="toMargin"
              title="My Rent History"
              :showMore="true"
            >
              <div v-for="rh in rentHistory" :key="rh.id">
                <br />
                <SideMenuEntry
                  :imgSource="rh.photo"
                  :link="'/tenant/house/'+rh.id"
                  :args="[
                    {
                      k1: 'house_name',
                      v1: rh.name,
                      k2: 'house_location',
                      v2: rh.bdate,
                      k3: 'house_slot',
                      v3: rh.edate,
                    },
                  ]"
                />
              </div>
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
import TenantNavbar from "@/components/TenantNavbar";
import SideMenuEditable from "@/components/SideMenuEditable";
import SideMenuEntry from "@/components/SideMenuEntry";
import CheckRates from "../components/CheckRates.vue";
import { mapGetters, mapState } from "vuex";
import axios from "axios";
import store from "@/store";
import countries from "@/assets/scripts/countries";
import { url as api_url } from "@/assets/scripts/api.js";

export default {
  name: "TenantProfile",
  components: {
    TenantNavbar,
    SideMenuEditable,
    SideMenuEntry,
    CheckRates,
  },
  data() {
    return {
      teste: 0,
      id: store.getters.getId,
      rentHistory: [],
      checkRates: "tenant",
      url: api_url,
      editable: false,
      ss: 24,
      edit_text: "Edit",
      modal_active: "modal",
      countries: countries,
      formData: {
        username: "",
        name: "",
        sex: "",
        password: "",
        birthDate: "",
        nationality: "",
        occupation: "",
      },
    };
  },
  created() {
    axios
      .get(api_url + "/api/tenants/" + store.getters.getId)
      .then((response) => {
        this.formData = response.data;
      })
      .catch((e) => {
        console.log(e);
      });
    axios
      .get(api_url + "/api/tenants/" + store.getters.getId + "/rentHistory")
      .then((res) => {
        for (var i = 0; i < res.data.length && i < 3; i++) {
          var rhentry = {
            photo: `${api_url}/api/houses/photos/${res.data[i].house.photos[0]}`,
            name: res.data[i].house.title,
            bdate: 'from: '+res.data[i].bDate,
            edate: (res.data[i].eDate==undefined)?"to: Present":"to: "+res.data[i].eDate,
            id: res.data[i].house.id,
            landlord: res.data[i].house.landlord.name,
          };
          console.log(res.data[i]);
          this.rentHistory.push(rhentry);
        }
        this.teste++;
        console.log("renthistory "+JSON.stringify(this.rentHistory));
      })
      .catch((ex) => {
        console.log(ex);
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
      var inputs, select;
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

        select = document.getElementById("formulate--tenant-profile-12");
        select.disabled = false;
      } else {
        this.edit_text = "Edit";
        f.style.display = "none";
        inputs = document.getElementsByTagName("input");
        for (var j = 0; j < inputs.length; j++) inputs[j].disabled = true;

        select = document.getElementById("formulate--tenant-profile-12");
        select.disabled = true;
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
          api_url + "/api/tenants/" + store.getters.getId + "/password",
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
      bodyFormData.append("phone", data.phone);
      bodyFormData.append("sex", data.sex);
      bodyFormData.append("nationality", data.nationality);
      bodyFormData.append("occupation", data.occupation);
      bodyFormData.append("file", this.formData.file);

      let options = {
        headers: {
          "Content-Type": "multipart/form-data",
        },
      };

      await axios
        .put(
          api_url + "/api/tenants/" + store.getters.getId,
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

.pad {
  background-color: white;
  width: 90%;
  margin: 3% auto;
}

.bs {
  background-color: #2d6a4f;
}

star-rating {
  background-color: red;
}

.toMargin {
  margin: 4% auto;
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