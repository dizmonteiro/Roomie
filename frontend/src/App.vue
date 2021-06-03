<template>
  <div id="app">
    <router-view class="something"/>
    <Footer />
  </div>
</template>

<script>
import Footer from '@/components/Footer'
import axios from 'axios'
import { AUTH_LOGOUT } from "@/store/actions/auth";

export default {
  name: 'App',
  components: {
    Footer
  },
  created: function () {
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
  .something{
    margin-bottom: 5%;
  }
  #app {
    min-height: 93vh;
  }
</style>
