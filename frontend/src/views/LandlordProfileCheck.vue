<template>
  <div>
    <TenantNavbar />

    <div id="llcard" class="card pad">
      <div class="columns is-desktop">
        <div
          class="column adjust-hero-s is-one-quarter-desktop is-full-mobile is-full-tablet"
        >
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
        <div
          class="column adjust-hero-s is-half-desktop is-full-mobile is-full-tablet form"
        >
          <div class="columns">
            <div class="column is-half">
              <div class="field">
                <label class="label" v-on:click="getUserType">Name</label>
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
              <div class="field">
                <label class="label">NIF</label>
                <div class="control is-expanded">
                  <input
                    class="input"
                    type="text"
                    placeholder="NIF"
                    name="nif"
                    readonly
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
            </div>
          </div>
        </div>
        <div
          class="column adjust-hero is-one-quarter-desktop is-full-mobile is-full-tablet has-text-centered"
        >
          <SideMenuEditable title="Houses">
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
                    v3: 'Slots: 2/4',
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
                    v3: 'Slots: 1/4',
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
                    v3: 'Slots: 3/4',
                  },
                ]"
              />
            </template>
          </SideMenuEditable>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import TenantNavbar from "@/components/TenantNavbar";
import SideMenuEditable from "@/components/SideMenuEditable";
import SideMenuEntry from "@/components/SideMenuEntry";
import store from '@/store'

export default {
  name: "LandlordProfileTenant",
  components: {
    TenantNavbar,
    SideMenuEditable,
    SideMenuEntry,
  },
  data() {
    return {
      editable: true,
      edit_text: "Edit",
      modal_active: "modal",
    };
  },
  methods: {
    getUserType() {
      // eslint-disable-next-line
      alert("--- " + store.getters.getType);
    }
  },
};
</script>


<style scoped>
strong {
  color: white;
}
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
.bs {
  background-color: #2d6a4f;
}

.pad {
  width: 90%;
  margin: 5% auto;
}

.form {
  margin: 8% auto;
}
</style>