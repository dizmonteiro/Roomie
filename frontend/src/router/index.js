import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      component: () => import('@/views/Home'),
      children: [
        {
          path: '',
          name: 'Home',
          component: () => import('@/views/Home')
        }
      ]
    },
    {
      name: 'Login',
      path: '/login',
      component: () => import('@/views/Login')
    },
    {
      name: 'Register',
      path: '/register',
      component: () => import('@/views/Register')
    },
    {
      name: 'LandlordProfile',
      path: '/llprofile',
      component: () => import('@/views/LandlordProfile')
    },
    {
      name: 'TenantProfile',
      path: '/tprofile',
      component:()=>import('@/views/TenantProfile')
    },
    {
      path: '/404',
      component: () => import('@/views/NotFound')
    },
    {
      path: '*',
      redirect: '/404'
    }
  ]
})
