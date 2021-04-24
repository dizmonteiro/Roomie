<template>
  <div class="navbar-item pph">
    <div id="ppid" class="dropdown is-right">
      <div class="dropdown-trigger">
        <img
          class="pp"
          object-fit="cover"
          aria-haspopup="true"
          aria-controls="dropdown-menu3"
          @click="activateDropdown"
          :src="profilePic"
          :width="w"
          :height="h"
        />
      </div>
      <div class="dropdown-menu" id="dropdown-menu3" role="menu">
        <div class="dropdown-content">
          <a :href="toProfile" class="dropdown-item"> My Profile </a>
          <hr class="dropdown-divider" />
          <a class="dropdown-item" @click="logout"> Logout </a>
        </div>
      </div>
    </div>
  </div>
</template>

<script>

import { AUTH_LOGOUT } from "@/store/actions/auth";
export default {
  props: ["profilePic", "w", "h","profile"],
  data() {
    return {
      dd: false,
      toProfile: "/".concat(this.profile.concat("/profile"))
    };
  },
  methods: {
      logout: function () {
      this.$store.dispatch(AUTH_LOGOUT).then(() => {
        this.$router.push("/");
      });
    },
    activateDropdown() {
      if (!this.dd) {
        this.dd = true;
        document.getElementById("ppid").classList.add("is-active");
      } else {
          this.dd = false;
        document.getElementById("ppid").classList.remove("is-active");
      }
    },
  },
};
</script>

<style scoped>
.dropdown-trigger{
  width: 40px; 
  height: 40px;
}

.pph {
  padding: 0;
  padding-right: 1%;
}

.pp {
  cursor: pointer;
  min-height: 100%;
  border-radius: 50%;
}
</style>