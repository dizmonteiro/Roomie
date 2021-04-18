import Vue from 'vue'
import App from './App.vue'
import router from './router'
import VueFormulate from '@braid/vue-formulate'
import axios from 'axios'
import store from './store'

Vue.config.productionTip = false

Vue.use(VueFormulate)

const token = localStorage.getItem('user-token')

if (token) {
  axios.defaults.headers.common['Authorization'] = token
}

new Vue({
  router,
  store,
  render: h => h(App),
}).$mount('#app')
