import Vue from 'vue'
import Vuetify from 'vuetify'
import App from './App.vue'
import store from './store'
import router from './router'
import axios from 'axios'
import BootstrapVue from 'bootstrap-vue'
import './plugins/vuetify'
import 'roboto-fontface/css/roboto/roboto-fontface.css'
import 'material-design-icons-iconfont/dist/material-design-icons.css'


Vue.config.productionTip = false;


Vue.use(BootstrapVue);
Vue.use(Vuetify);
Vue.use(instance);

const instance = axios.create({
  baseURL: 'https://myapi.com'
});

// const instanceUserApi = axios.create({
//   baseURL: 'https://userapi.com'
// });
// instanceUserApi.defaults.headers.common["Authorization"] =
//   "Token" + localStorage.getItem("authToken");


Vue.prototype.$http = instance;

new Vue({
  store,
  router,
  render: h => h(App)
}).$mount('#app')
