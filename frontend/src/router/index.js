import Vue from 'vue'
import Router from 'vue-router'
import store from '@/store'

const ifNotAuthenticated = (to, from, next) => {
  if (!store.getters.isAuthenticated) {
    next()
    return
  }
  next('/')
}

const ifAuthenticated = (to, from, next) => {
  if (store.getters.isAuthenticated) {
    next()
    return
  }
  next('/login')
}

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
      component: () => import('@/views/Login'),
      beforeEnter: ifNotAuthenticated
    },
    {
      name: 'Register',
      path: '/register',
      component: () => import('@/views/Register')
    },
    {
      name: 'LandlordProfile',
      path: '/llprofile',
      component: () => import('@/views/LandlordProfile'),
      beforeEnter: ifAuthenticated
    },
    {
      name: 'LoggedLandlord',
      path: '/loggedll',
      component: () => import('@/views/LoggedLandlord'),
      //beforeEnter: ifAuthenticated
    },
    {
      name: 'LoggedTenant',
      path: '/loggedtt',
      component: () => import('@/views/LoggedTenant'),
      //beforeEnter: ifAuthenticated
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
