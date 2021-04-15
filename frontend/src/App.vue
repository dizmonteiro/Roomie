<template>
  <div id="app">
    <router-view/>
    <Footer />
  </div>
</template>

<script>
import Footer from '@/components/Footer'

export default {
  name: 'App',
  components: {
    Footer
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
