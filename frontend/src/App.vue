<template>
  <div id="app" class="is-flex is-flex-direction-column">
    <div class="is-flex-grow-1">
      <router-view/>
    </div>
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

  #app {
    min-height: 93vh;
  }
</style>
