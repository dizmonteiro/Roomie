<template>
  <div>
    <DefaultNavbar />
    <section class="hero is-fullheight-with-navbar">
      <div class="columns is-centered is-vcentered is-flex-grow-1">
        <div class="column is-three-quarters">
          <div class="card" id="registercard">
            <div class="card-content">
              <p class="title has-text-centered">Welcome</p>
              <div class="control has-text-centered">
                <label class="radio">
                  <input type="radio" name="user" value="tenant" v-on:click="getUserType()">
                  I'm a Tenant
                </label>
                <label class="radio">
                  <input type="radio" name="user" value="landlord" v-on:click="getUserType()">
                  I'm a Landlord
                </label>
              </div>
              <br>
              <div class="" id="register-form">
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
  </div>
</template>

<script>

import DefaultNavbar from '@/components/DefaultNavbar'
import axios from 'axios';

function getUserType() {
    var radios = document.getElementsByName('user');

    if(radios[0].checked){
      document.getElementById('register-form').innerHTML = '';

      const div = document.createElement('div');
      div.className = 'control';
      div.innerHTML = `
        <div class="columns">
          <div class="column is-two-thirds">
            <div class="field">
              <label class="label">Name</label>
              <div class="control is-expanded">
                <input class="input" type="text" placeholder="Full Name" id="name" required>
              </div>
            </div>
            <div class="columns">
          <div class="column">
            <div class="field">
              <label class="label">Password</label>
              <div class="control is-expanded">
                <input class="input" type="password" placeholder="Password" id="password" required>
              </div>
            </div>
            <div class="field">
              <label class="label">Email</label>
              <div class="control is-expanded">
                <input class="input" type="email" placeholder="Email" id="email" required>
              </div>
            </div>
            <div class="field">
              <label class="label">Phone Number</label>
              <p class="control">
                <input class="input" type="tel" placeholder="(+351) XXX XXX XXX" id="phone" maxlength="9" size="9" equired>
              </p>
            </div>
            <div class="field">
              <label class="label">Nationality</label>
              <div class="control is-expanded">
                <input class="input" type="text" placeholder="Nationality" id="nationality" required>
              </div>
            </div>
          </div>
          <div class="column">
            <div class="field">
              <label class="label">Username</label>
              <div class="control is-expanded">
                <input class="input" type="text" placeholder="Username" id="username" required>
              </div>
            </div>
            <div class="field">
              <label class="label">NIF</label>
              <div class="control is-expanded">
                <input class="input" type="text" placeholder="NIF" id="nif" maxlength="9" size="9" required>
              </div>
            </div>
            <div class="field">
              <label class="label">Birth Date</label>
              <div class="control is-expanded">
                <input class="input" type="date" placeholder="yyyy-mm-dd" id="dob" required>
              </div>
            </div>
            <div class="field">
              <label class="label">Occupation</label>
              <div class="control is-expanded">
                <input class="input" type="text" placeholder="Occupation" id="occupation" required>
              </div>
            </div>
          </div>
        </div>
      </div>
          <div class="column">
            <div class="field has-text-centered" id="profilepic">
              <label class="label">Profile Picture</label>
              <div id="preview">
                <img id="output" style="height: 20vh; width: 50%"/>
              </div>
              <br>
              <div class="file is-centered">
                <label class="file-label">
                  <input class="file-input" type="file" id="photo" accept="image/*" required>
                  <span class="file-cta">
                    <span class="file-label">
                      Choose a picture
                    </span>
                  </span>
                </label>
              </div>
            </div>
            <br>
            <div class="field has-text-centered">
              <label class="label">Gender</label>
              <div class="control is-expanded">
                <label class="radio">
                  <input type="radio" id="gender" value="female" required>
                  Female
                </label>
                <label class="radio">
                  <input type="radio" id="gender" value="male">
                  Male
                </label>
                <label class="radio">
                  <input type="radio" id="gender" value="other">
                  Other
                </label>
              </div>
            </div>
            <br>
            <div class="field is-grouped is-grouped-centered">
              <p class="control">
                <a class="button is-light" href="/">
                  Cancel
                </a>
              </p>
              <button type="submit" class="button is-primary" id="regist">Register</button>
            </div>
          </div>
        </div>
      `;
      
      document.getElementById('register-form').appendChild(div);

      const submit = document.getElementById('regist');
      submit.onclick = function(){

        var name = document.getElementById('name');
        var email = document.getElementById('email');
        var username = document.getElementById('username');
        var phone = document.getElementById('phone');
        var birthdate = document.getElementById('dob');
        var sex = document.querySelector('input[id="gender"]:checked');
        var nif = document.getElementById('nif');
        var nationality = document.getElementById('nationality');
        var occupation = document.getElementById('occupation');
        var password = document.getElementById('password');
        var file = document.getElementById('photo');

        if(name.value && email.value && username.value && phone.value && birthdate.value && sex && nif.value && nationality.value && occupation.value && password.value && file.files[0]) {
          var bodyFormData = new FormData();
          bodyFormData.append('name', name.value);
          bodyFormData.append('email', email.value);
          bodyFormData.append('username', username.value);
          bodyFormData.append('phone', phone.value);
          bodyFormData.append('birthDate', birthdate.value);
          bodyFormData.append('sex', sex.value);
          bodyFormData.append('nif', nif.value);
          bodyFormData.append('nationality', nationality.value);
          bodyFormData.append('occupation', occupation.value);
          bodyFormData.append('password', password.value);
          bodyFormData.append('file', file.files[0], file.files[0].name);

          axios({
            method: "post",
            url: "http://localhost:8083/api/tenants",
            data: bodyFormData,
            headers: { 
              "Authorization": null,
              "Content-Type": "multipart/form-data" 
            },
          })
          .then(function () {
            window.location.replace("/");
          })
          .catch(function (response) {
            alert(response)
            window.location.replace("/");
          });
        } else {
          alert('Please fill all the information')
        }
      };

    } else if(radios[1].checked){
      document.getElementById('register-form').innerHTML = '';

      const div = document.createElement('div');
      div.className = 'control';
      div.innerHTML = `
        <div class="columns">
          <div class="column is-one-third">
            <div class="field">
              <label class="label">Name</label>
              <div class="control is-expanded">
                <input class="input" type="text" placeholder="Full Name" id="name" required>
              </div>
            </div>
             <div class="field">
              <label class="label">Password</label>
              <div class="control is-expanded">
                <input class="input" type="password" placeholder="Password" id="password" required>
              </div>
            </div>
            <div class="field">
              <label class="label">Email</label>
              <div class="control is-expanded">
                <input class="input" type="email" placeholder="Email" id="email" required>
              </div>
            </div>
            <div class="field">
              <label class="label">Phone Number</label>
              <p class="control">
                <input class="input" type="tel" placeholder="(+351) XXX XXX XXX" id="phone" maxlength="9" size="9" required>
              </p>
            </div>
          </div>
          <div class="column is-one-third">
            <div class="field">
              <label class="label">Username</label>
              <div class="control is-expanded">
                <input class="input" type="text" placeholder="Username" id="username" required>
              </div>
            </div>
            <div class="field">
              <label class="label">NIF</label>
              <div class="control is-expanded">
                <input class="input" type="text" placeholder="NIF" id="nif" maxlength="9" size="9" required>
              </div>
            </div>
            <div class="field">
              <label class="label">Address</label>
              <div class="control is-expanded">
                <input class="input" type="text" placeholder="Address" id="address" required>
              </div>
            </div>
            <div class="field">
              <label class="label">Birth Date</label>
              <div class="control is-expanded">
                <input class="input" type="date" placeholder="yyyy-mm-dd" id="dob" required>
              </div>
            </div>
          </div>
          <div class="column is-one-third">
            <div class="field has-text-centered" id="profilepic">
              <label class="label">Profile Picture</label>
              <div id="preview">
                <img id="output" style="height: 20vh; width: 50%"/>
              </div>
              <br>
              <div class="file is-centered">
                <label class="file-label">
                  <input class="file-input" type="file" id="photo" accept="image/*" required>
                  <span class="file-cta">
                    <span class="file-label">
                      Choose a picture
                    </span>
                  </span>
                </label>
              </div>
            </div>
            <br>
            <div class="field has-text-centered">
              <label class="label">Gender</label>
              <div class="control is-expanded">
                <label class="radio">
                  <input type="radio" id="gender" value="female" required>
                  Female
                </label>
                <label class="radio">
                  <input type="radio" id="gender" value="male">
                  Male
                </label>
                <label class="radio">
                  <input type="radio" id="gender" value="other">
                  Other
                </label>
              </div>
            </div>
            <br>
            <div class="field is-grouped is-grouped-centered">
              <p class="control">
                <a class="button is-light" href="/">
                  Cancel
                </a>
              </p>
              <button type="submit" class="button is-primary" id="regist">Register</button>
            </div>
          </div>
        </div>
      `;

      document.getElementById('register-form').appendChild(div);

      const submit = document.getElementById('regist');
      submit.onclick = function(){

        var name = document.getElementById('name');
        var email = document.getElementById('email');
        var username = document.getElementById('username');
        var phone = document.getElementById('phone');
        var birthdate = document.getElementById('dob');
        var sex = document.querySelector('input[id="gender"]:checked');
        var nif = document.getElementById('nif');
        var address = document.getElementById('address');
        var password = document.getElementById('password');
        var file = document.getElementById('photo');

        if(name.value && email.value && username.value && phone.value && birthdate.value && sex && nif.value && address.value && password.value && file.files[0]){
          var bodyFormData = new FormData();
          bodyFormData.append('name', name.value);
          bodyFormData.append('email', email.value);
          bodyFormData.append('username', username.value);
          bodyFormData.append('phone', phone.value);
          bodyFormData.append('birthDate', birthdate.value);
          bodyFormData.append('sex', sex.value);
          bodyFormData.append('nif', nif.value);
          bodyFormData.append('address', address.value);
          bodyFormData.append('password', password.value);
          bodyFormData.append('file', file.files[0], file.files[0].name);

          axios({
            method: "post",
            url: "http://localhost:8083/api/landlords",
            data: bodyFormData,
            headers: { 
              "Authorization": null,
              "Content-Type": "multipart/form-data" 
            },
          })
          .then(function () {
            window.location.replace("/");
          })
          .catch(function (response) {
            alert(response)
            window.location.replace("/");
          });
        } else {
          alert('Please fill all the information')
        }
      };
    }


    const fileInput = document.querySelector('#profilepic input[type=file]');
    fileInput.onchange = () => {
      if (fileInput.files.length > 0) {
        var output = document.getElementById('output');
        output.src = URL.createObjectURL(fileInput.files[0]);
        output.onload = function() {
          URL.revokeObjectURL(output.src) // free memory
        }
      }
    }
}


export default {
  name: 'Register',
  components: {
    DefaultNavbar
  },
  methods: {
    getUserType
  }
}
</script>

<style scoped>
  #preview {
    min-height: 200px;
    max-height: 200px;
  }

  #filler {
    min-height: 90vh;
  }

  #registercard{
    min-height: 80vh;
  } 

  .login {
    margin: 0px 50px;
  }

  label { display:block }

  @media (max-width: 770px) {
    #registercard{
      margin: 20px 50px 0px 50px;
    }
  }
</style>