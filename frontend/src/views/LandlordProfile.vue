<template>
  <div>
    <LandlordNavbar />
    <FormulateForm v-model="formData" @submit="submitProfile">
      <div id="llcard" class="card pad">
        <div class="columns is-desktop">
          <div class="column is-one-quarter-desktop is-full-mobile is-full-tablet">
            <figure class="image avatar">
              <img
                class="is-rounded"
                id="profile-pic"
                v-bind:src="'http://localhost:8083/api/tenants/'+ id + '/avatar'"
              />
            </figure>
            <div class="control">
              <div class="box adjust-gender">
                <FormulateInput
                  id="gender"
                  name="sex"
                  :options="{female: 'Female', male: 'Male', other: 'Other'}"
                  type="radio"
                  label="Gender"
                  disabled
                />
              </div>
            </div>
          </div>
          <div class="column is-half-desktop is-full-mobile is-full-tablet form">
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
                    type="password"
                    name="password"
                    label="Password"
                    placeholder="**********"
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
              <!--
              <p class="control">
                <a
                  class="button bs"
                  value="edit-password"
                  @click="editPassword()"
                >
                <strong> Edit Password</strong>
                </a>
              </p>
              <p class="control">
                <a class="button bs" value="edit" @click="edit()">
                  <strong>{{ edit_text }}</strong>
                </a>
              </p>
              -->
            </div>
          </div>
          <div class="column adjust-hero is-one-quarter-desktop is-full-mobile is-full-tablet has-text-centered">
          <SideMenuEditable title="My Houses">
              <template v-slot:firstEntry>
                <SideMenuEntry
                  imgSource="https://thisrentaldoesnotexist.com/img-new/hero.jpg"
                  :args="[
                    {
                      k1: 'house_name',
                      v1: 'House1',
                      k2: 'house_location',
                      v2: 'Location1',
                      k3: 'house_slot',
                      v3: 'Slots: 2/4'
                    },
                  ]"
                />
              </template>
              <template v-slot:secondEntry>
                <SideMenuEntry
                  imgSource="https://thisrentaldoesnotexist.com/img-new/hero.jpg"
                  :args="[
                    {
                    k1: 'house_name',
                      v1: 'House2',
                      k2: 'house_location',
                      v2: 'Location2',
                      k3: 'house_slot',
                      v3: 'Slots: 1/4'
                    },
                  ]"
                />
              </template>
              <template v-slot:thirdEntry>
                <SideMenuEntry
                  imgSource="https://thisrentaldoesnotexist.com/img-new/hero.jpg"
                  :args="[
                    {
                      k1: 'house_name',
                      v1: 'House3',
                      k2: 'house_location',
                      v2: 'Location3',
                      k3: 'house_slot',
                      v3: 'Slots: 3/4'
                    },
                  ]"
                />
              </template>
            </SideMenuEditable>
          </div>
        </div>
      </div>
    </FormulateForm>
    <div id="change-password" class="modal">
      <div class="modal-background"></div>
      <FormulateForm 
        @submit="submitPassword"
        #default="{ isLoading }"
      >
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
import { mapGetters, mapState } from 'vuex';
import axios from 'axios';
import store from '@/store';

export default {
  name: "LandlordProfile",
  components: {
    LandlordNavbar,
    SideMenuEditable,
    SideMenuEntry
  },
  data: function() {
    return {
      editable: false,
      edit_text: "Edit",
      modal_active: "modal",
      formData: {
        username: "",
        name: "",
        sex: "",
        password: "",
        birthDate: "",
      }
    };
  },
  created() {
    axios.get('http://localhost:8083/api/landlords/'+store.getters.getId).then(response => {
      this.formData = response.data;
    }).catch(e => {
      console.log(e)
    });  
  },
  computed: {
    ...mapGetters(["getType","getId"]),
    ...mapState({
      type: (state) => `${state.user.type}`,
      id: (state) => `${state.user.id}`,
    }),
  },
  methods: {
    edit() {
      this.editable = !this.editable;
      var inputs;

      if (this.editable){
        this.edit_text = "Apply Changes";
        inputs = document.getElementsByTagName('input');
        for(var i = 0; i < inputs.length; i++) {
          if(inputs[i].type.toLowerCase() != 'password' && inputs[i].type.toLowerCase() != 'email' && inputs[i].type.toLowerCase() != 'number' && inputs[i].type.toLowerCase() != 'date')
            inputs[i].disabled = false
        }
      } else {
        this.edit_text = "Edit";
        inputs = document.getElementsByTagName('input');
        for(var j = 0; j < inputs.length; j++)
          inputs[j].disabled = true
      }
    },
    editPassword() {
      document.getElementById("change-password").classList.add("is-active");

      var inputs = document.getElementsByTagName('input');
      for(var i = 0; i < inputs.length; i++) {
          if(inputs[i].type.toLowerCase() == 'password')
            inputs[i].disabled = false
      }
    },
    closeModal() {
      document.getElementById("change-password").classList.remove("is-active");
      var inputs = document.getElementsByTagName('input');
      for(var i = 0; i < inputs.length; i++) {
          if(inputs[i].type.toLowerCase() == 'password')
            inputs[i].disabled = true
      }
    },
    async submitPassword (data) {
      await axios.put('http://localhost:8083/api/landlords/'+store.getters.getId+'/password', data).then(() => {
        this.closeModal()
      }).catch(e => {
        alert(e)
      })
    },
    async submitProfile (data) {
      let payload = {
        name: data.name,
        username: data.username,
        sex: data.sex,
        address: data.address,
        phone: data.phone
      }
      await axios.put('http://localhost:8083/api/landlords/'+store.getters.getId, payload).then(() => {
        alert("Profile Updated!")
      }).catch(e => {
        alert(e)
      })
    }
  },
};
</script>


<style scoped>

.modal-content {
  width: 25vw;
}

strong{
  color: white;
}

.avatar {
  width: 200px;
  height: 200px;
  position: relative;
  display: block;
  margin: 25% auto 8% auto;
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

.bs{
  background-color:  #2D6A4f;
}

.pad {
  width: 90%;
  margin: 3% auto;
}

.form{
  margin: 8% auto;
}

@media screen and (max-width: 1030px) {
  .form{
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

</style>