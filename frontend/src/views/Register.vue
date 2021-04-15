<template>
  <div id="filler" class="is-flex is-flex-direction-column">
    <DefaultNavbar />
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
  </div>
</template>

<script>

import DefaultNavbar from '@/components/DefaultNavbar'

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
                <input class="input" type="text" placeholder="Full Name" name="name">
              </div>
            </div>
            <div class="columns">
          <div class="column">
            <div class="field">
              <label class="label">Password</label>
              <div class="control is-expanded">
                <input class="input" type="password" placeholder="Password" name="password">
              </div>
            </div>
            <div class="field">
              <label class="label">Email</label>
              <div class="control is-expanded">
                <input class="input" type="email" placeholder="Email" name="email">
              </div>
            </div>
            <div class="field">
              <label class="label">Phone Number</label>
              <p class="control">
                <input class="input" type="tel" placeholder="(+351) XXX XXX XXX" name="phone">
              </p>
            </div>
            <div class="field">
              <label class="label">Nationality</label>
              <div class="control is-expanded">
                <input class="input" type="text" placeholder="Nationality" name="nationality">
              </div>
            </div>
          </div>
          <div class="column">
            <div class="field">
              <label class="label">Username</label>
              <div class="control is-expanded">
                <input class="input" type="text" placeholder="Username" name="username">
              </div>
            </div>
            <div class="field">
              <label class="label">NIF</label>
              <div class="control is-expanded">
                <input class="input" type="text" placeholder="NIF" name="nif">
              </div>
            </div>
            <div class="field">
              <label class="label">Birth Date</label>
              <div class="control is-expanded">
                <input class="input" type="date" placeholder="yyyy-mm-dd" name="dob">
              </div>
            </div>
            <div class="field">
              <label class="label">Occupation</label>
              <div class="control is-expanded">
                <input class="input" type="text" placeholder="Occupation" name="occupation">
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
                  <input class="file-input" type="file" name="photo" accept="image/*">
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
                  <input type="radio" name="gender" value="female">
                  Female
                </label>
                <label class="radio">
                  <input type="radio" name="gender" value="male">
                  Male
                </label>
                <label class="radio">
                  <input type="radio" name="gender" value="other">
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
              <p class="control">
                <a class="button is-primary">
                  Register
                </a>
              </p>
            </div>
          </div>
        </div>
      `;
      
      document.getElementById('register-form').appendChild(div);
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
                <input class="input" type="text" placeholder="Full Name" name="name">
              </div>
            </div>
             <div class="field">
              <label class="label">Password</label>
              <div class="control is-expanded">
                <input class="input" type="password" placeholder="Password" name="password">
              </div>
            </div>
            <div class="field">
              <label class="label">Email</label>
              <div class="control is-expanded">
                <input class="input" type="email" placeholder="Email" name="email">
              </div>
            </div>
            <div class="field">
              <label class="label">Phone Number</label>
              <p class="control">
                <input class="input" type="tel" placeholder="(+351) XXX XXX XXX" name="phone">
              </p>
            </div>
          </div>
          <div class="column is-one-third">
            <div class="field">
              <label class="label">Username</label>
              <div class="control is-expanded">
                <input class="input" type="text" placeholder="Username" name="username">
              </div>
            </div>
            <div class="field">
              <label class="label">NIF</label>
              <div class="control is-expanded">
                <input class="input" type="text" placeholder="NIF" name="nif">
              </div>
            </div>
            <div class="field">
              <label class="label">Address</label>
              <div class="control is-expanded">
                <input class="input" type="text" placeholder="Address" name="address">
              </div>
            </div>
            <div class="field">
              <label class="label">Birth Date</label>
              <div class="control is-expanded">
                <input class="input" type="date" placeholder="yyyy-mm-dd" name="dob">
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
                  <input class="file-input" type="file" name="photo" accept="image/*">
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
                  <input type="radio" name="gender" value="female">
                  Female
                </label>
                <label class="radio">
                  <input type="radio" name="gender" value="male">
                  Male
                </label>
                <label class="radio">
                  <input type="radio" name="gender" value="other">
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
              <p class="control">
                <a class="button is-primary">
                  Register
                </a>
              </p>
            </div>
          </div>
        </div>
      `;

      document.getElementById('register-form').appendChild(div);
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