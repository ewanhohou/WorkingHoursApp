import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

let pages = {
  '/customers': () =>
    import('@/views/customer/index'),
  '/customers/modify/:id': () =>
    import('@/views/customer/modify'),
  '/customers/modify': () =>
    import('@/views/customer/modify'),
  '/employees': () =>
    import('@/views/employee/index'),
  '/employees/modify': () =>
    import('@/views/employee/modify'),
  '/employees/modify/:id': () =>
    import('@/views/employee/modify'),
  '/events': () =>
    import('@/views/event/index'),
  '/events/modify': () =>
    import('@/views/event/modify'),
  '/events/modify/:id': () =>
    import('@/views/event/modify'),
};

let routes = [{
  path: '/',
  component: () =>
    import('@/views/layout'),
  children: [
    ...Object.keys(pages).map(m => {
      return {
        name: m,
        path: m,
        component: pages[m]
      };
    })
  ]
}];

export default new Router({
  routes: [
    ...routes, {
      path: '',
      component: () =>
        import('@/views/layout'),
      children: [{
        name: '404',
        path: '*',
        component: () =>
          import('@/views/404')
      }]
    }
  ]
})