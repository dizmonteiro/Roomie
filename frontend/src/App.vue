<template>
  <div id="app">
    <router-view/>
    <Footer />
  </div>
</template>

<script>
import Footer from '@/components/Footer'
import axios from 'axios'
import { AUTH_LOGOUT } from "@/store/actions/auth";
import { USER_REQUEST } from "@/store/actions/user";

export default {
  name: 'App',
  components: {
    Footer
  },
  created: function () {
    if(this.$store.getters.isAuthenticated){
      this.$store.dispatch(USER_REQUEST)
    }

    axios.interceptors.response.use(undefined, function (err) {
      // eslint-disable-next-line no-unused-vars
      return new Promise(function (resolve, reject) {
        if (err.status === 401 && err.config && !err.config.__isRetryRequest) {
          this.$store.dispatch(AUTH_LOGOUT)
        }
        throw err;
      });
    });
  }
}
</script>

<style>
  @import './assets/styles/bulma.css';
  @import './assets/styles/custom.css';
  @import './assets/styles/snow.min.css';

  #app {
    min-height: 93vh;
  }
</style>
