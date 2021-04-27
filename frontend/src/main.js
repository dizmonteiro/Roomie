import Vue from 'vue'
import App from './App.vue'
import router from './router'
import VueFormulate from '@braid/vue-formulate'
import axios from 'axios'
import store from './store'
import VueAgile from 'vue-agile'
import '@fortawesome/fontawesome-free/css/all.css'
import '@fortawesome/fontawesome-free/js/all.js'
import SmoothScrollbar from 'vue-smooth-scrollbar'

Vue.use(SmoothScrollbar)
Vue.use(VueAgile)

Vue.config.productionTip = false

Vue.use(VueFormulate)

const token = localStorage.getItem('user-token')
Vue.prototype.$backendurl = 'http://backend:8083'

if (token) {
  axios.defaults.headers.common['Authorization'] = "Bearer " + token
}

new Vue({
  router,
  store,
  render: h => h(App),
}).$mount('#app')
