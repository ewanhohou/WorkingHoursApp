import Vue from 'vue'
import App from './App.vue'
import router from './router/router'
import store from './store'
import axios from 'axios'
import VueAxios from 'vue-axios'
import requestHelper from '@/helpers/requestHelper';
import VueSweetalert2 from 'vue-sweetalert2';
 
import 'sweetalert2/dist/sweetalert2.min.css';
 
Vue.use(VueAxios, axios)
Vue.use(VueSweetalert2);

Vue.config.productionTip = false
Vue.prototype.$handleError = requestHelper.handleError;
new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
