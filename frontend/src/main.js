import Vue from 'vue'
import App from './App.vue'
import router from './router'
import VueFormulate from '@braid/vue-formulate'

Vue.config.productionTip = false

Vue.use(VueFormulate)

new Vue({
  router,
  render: h => h(App),
}).$mount('#app')
