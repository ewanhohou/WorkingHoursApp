import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      component: () => import('@/views/layout'),
      children: [{
        path: '/customer',
        name: 'customer',
        component: () => import('@/views/customer/index'),
      },{
        path: '/customer_add',
        name: 'customer_add',
        component: () => import('@/views/customer/create'),
      },{
        path: '/employee',
        name: 'employee',
        component: () => import('@/views/employee/index'),
      },{
        path: '/employee_add',
        name: 'employee_add',
        component: () => import('@/views/employee/create'),
      },{
        path: '/wage',
        name: 'wage',
        component: () => import('@/views/wage/index'),
      },,{
        path: '/wage_add',
        name: 'wage_add',
        component: () => import('@/views/wage/create'),
      }]
    }
  ]
})
