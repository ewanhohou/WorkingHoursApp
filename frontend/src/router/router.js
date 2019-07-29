import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

let pages = {
  "/customer": () =>
    import("@/views/customer/index"),
  "/customer/modify/:id": () =>
    import("@/views/customer/modify"),
  "/customer/modify": () =>
    import("@/views/customer/modify"),
  "/employee": () =>
    import("@/views/employee/index"),
  "/employee/modify": () =>
    import("@/views/employee/modify"),
  "/employee/modify/:id": () =>
    import("@/views/employee/modify"),
  "/event": () =>
    import("@/views/event/index"),
  "/event/modify": () =>
    import("@/views/event/modify"),
  "/event/modify/:id": () =>
    import("@/views/event/modify"),
};

let routes = [{
  path: "/",
  component: () =>
    import("@/views/layout"),
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
      path: "",
      component: () =>
        import("@/views/layout"),
      children: [{
        name: '404',
        path: "*",
        component: () =>
          import("@/views/404")
      }]
    }
  ]
})