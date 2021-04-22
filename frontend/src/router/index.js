import Vue from 'vue'
import Router from 'vue-router'
import store from '@/store'

const ifNotAuthenticated = (to, from, next) => {
  if (!store.getters.isAuthenticated) {
    next()
    return
  } else {
    next('/')
  }
}

const ifAuthenticated = (to, from, next) => {
  if (store.getters.isAuthenticated) {
    next()
    return
  } else {
    next('/login')
  }
}

const redirectAuthenticated = (to, from, next) => {
  if (store.getters.isAuthenticated) {
    if (store.getters.isLandlord) {
      next('/landlord')
    } else if (store.getters.isTenant) {
      next('/tenant')
    }
    return
  } else {
    next()
  }
}

const ifAuthenticatedLandlord = (to, from, next) => {
  if (store.getters.isAuthenticated) {
    if (store.getters.isLandlord) {
      next()
      return
    } else {
      next('/tenant')
    }
  } else {
    next('/login')
  }
}

const ifAuthenticatedTenant = (to, from, next) => {
  if (store.getters.isAuthenticated) {
    if (store.getters.isTenant) {
      next()
      return
    } else {
      next('/landlord')
    }
  } else {
    next('/login')
  }
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
      ],
      beforeEnter: redirectAuthenticated
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
      name: 'Landlord',
      path: '/landlord',
      component: () => import('@/views/LoggedLandlord'),
      beforeEnter: ifAuthenticatedLandlord
    },
    {
      name: 'Landlord Profile',
      path: '/landlord/profile',
      component: () => import('@/views/LandlordProfile'),
      beforeEnter: ifAuthenticatedLandlord
    },
    {
      name: 'LoggedTenant',
      path: '/tenant',
      component: () => import('@/views/LoggedTenant'),
      beforeEnter: ifAuthenticatedTenant
    },
    {
      name: 'Tenant Profile',
      path: '/tenant/profile',
      component: () => import('@/views/TenantProfile'),
      beforeEnter: ifAuthenticatedTenant
    },
    {
      name: 'Tenant Landlord Profile',
      path: '/tenant/llprofile',
      component: () => import('@/views/LandlordProfileCheck'),
      beforeEnter: ifAuthenticated
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
