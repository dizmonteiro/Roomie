<template>
  <div>
    <DefaultNavbar />
      <div class="columns is-centered is-vcentered">
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
      <div class="modal" id="modal">
        <div class="modal-background"></div>
          <div class="modal-content">
            <div class="card">
              <div class="card-content is-vcentered">
                <div class="content has-text-centered">
                  <br>
                  <h1>Registration Complete!</h1>  
                  <br>
                  <br>
                  <button type="submit" class="button is-green" v-on:click="goToHome()">Return to Home</button>
                </div>
              </div>
            </div>
          </div>
          <button class="modal-close is-large" aria-label="close" v-on:click="closeModal()"></button>
      </div>
    </div>
</template>

<script>

import DefaultNavbar from '@/components/DefaultNavbar'
import axios from 'axios'
import countries from '@/assets/scripts/countries'

function validateEmail(email) {
  /* eslint-disable-next-line */
  const re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
  return re.test(email);
}

function getUserType() {
    var radios = document.getElementsByName('user');

    var countrySelector1 = `
      <div class="select">
        <select id="nationality" required>
          <option>Select a Country</option>
    `

    for (var i = 0; i < countries.length; i++) {
      countrySelector1 += "<option value=" + countries[i].name  + ">" + countries[i].name + "</option>"
    }

    var countrySelector2 =`
        </select>
      </div>
    `

    var countrySelector = countrySelector1 + countrySelector2

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
              <p class="help is-danger" id="email-message"></p>
            </div>
            <div class="field">
              <label class="label">Phone Number</label>
              <p class="control">
                <input class="input" type="number" placeholder="Phone Number" id="phone" minlength="9" maxlength="9" size="9" required>
              </p>
              <p class="help is-danger" id="phone-message"></p>
            </div>
            <div class="field">
              <label class="label">Nationality</label>
                ` + countrySelector + `
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
                <input class="input" type="number" placeholder="NIF" id="nif" minlength="9" maxlength="9" size="9" required>
              </div>
              <p class="help is-danger" id="nif-message"></p>
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
              <br>
              <p class="help is-danger" id="fill-message"></p>
            </div>
            <div class="field is-grouped is-grouped-centered">
              <p class="control">
                <a class="button is-light" href="/">
                  Cancel
                </a>
              </p>
              <button type="submit" class="button is-green" id="regist">Register</button>
            </div>
          </div>
        </div>
      `;

      document.getElementById('register-form').appendChild(div);

      const submit = document.getElementById('regist');
      submit.onclick = function(){
        document.getElementById('nif-message').innerHTML = '';
        document.getElementById('fill-message').innerHTML = '';
        document.getElementById('phone-message').innerHTML = '';
        document.getElementById('email-message').innerHTML = '';

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
          var error = 0
          if(nif.value.length != 9){
            document.getElementById('nif-message').innerHTML = 'Invalid NIF!';
            error++
          } 
          
          if(phone.value.length != 9) {
            document.getElementById('phone-message').innerHTML = 'Invalid Phone Number!';
            error++
          }

          if(!validateEmail(email.value)) {
            document.getElementById('email-message').innerHTML = 'Invalid Email!';
            error++
          }
          
          if(error == 0){
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
                document.getElementById("modal").classList.add("is-active");
                //window.location.replace("/");
              })
              .catch(function (response) {
                alert(response)
                window.location.replace("/");
              });
          }
        } else {
            document.getElementById('fill-message').innerHTML = 'Please fill all the fields!';
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
              <p class="help is-danger" id="email-message"></p>
            </div>
            <div class="field">
              <label class="label">Phone Number</label>
              <p class="control">
                <input class="input" type="number" placeholder="Phone Number" id="phone" maxlength="9" size="9" required>
              </p>
              <p class="help is-danger" id="phone-message"></p>
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
                <input class="input" type="number" placeholder="NIF" id="nif" minlength="9" maxlength="9" size="9" required>
              </div>
              <p class="help is-danger" id="nif-message"></p>
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
              <br>
              <p class="help is-danger" id="fill-message"></p>
            </div>
            <div class="field is-grouped is-grouped-centered">
              <p class="control">
                <a class="button is-light" href="/">
                  Cancel
                </a>
              </p>
              <button type="submit" class="button is-green" id="regist">Register</button>
            </div>
          </div>
        </div>
      `;

      document.getElementById('register-form').appendChild(div);

      const submit = document.getElementById('regist');
      submit.onclick = function(){
        document.getElementById('nif-message').innerHTML = '';
        document.getElementById('fill-message').innerHTML = '';
        document.getElementById('phone-message').innerHTML = '';
        document.getElementById('email-message').innerHTML = '';

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
          var error = 0
          if(nif.value.length != 9){
            document.getElementById('nif-message').innerHTML = 'Invalid NIF!';
            error++
          } 
          
          if(phone.value.length != 9) {
            document.getElementById('phone-message').innerHTML = 'Invalid Phone Number!';
            error++
          }

          if(!validateEmail(email.value)) {
            document.getElementById('email-message').innerHTML = 'Invalid Email!';
            error++
          }

          if(error == 0){
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
              document.getElementById("modal").classList.add("is-active");
              //window.location.replace("/");
            })
            .catch(function (response) {
              alert(response)
              window.location.replace("/");
            });
          }
        } else {
          document.getElementById('fill-message').innerHTML = 'Please fill all the fields!';
        }
      };
    }


    const fileInput = document.querySelector('#profilepic input[type=file]');
    fileInput.onchange = () => {
      if (fileInput.files.length > 0) {
        var output = document.getElementById('output');
        output.src = URL.createObjectURL(fileInput.files[0]);
        output.onload = function() {
          URL.revokeObjectURL(output.src)
        }
      }
    }
}

function goToHome() {
  window.location.replace("/");
}

function closeModal() {
  document.getElementById("modal").classList.remove("is-active");
}


export default {
  name: 'Register',
  components: {
    DefaultNavbar
  },
  methods: {
    getUserType,
    closeModal,
    goToHome
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
    margin: 3% auto;
    min-height: 80vh;
    margin-bottom: 50px;
  } 

  .login {
    margin: 0px 50px;
  }

  label { display:block }

</style>