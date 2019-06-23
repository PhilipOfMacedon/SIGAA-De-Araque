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


const instanceApi = axios.create({
  baseURL: 'localhost:3000/api/'
}); 

// Se tiver token, carrega e evita mandar usuário para o login
const token = localStorage.getItem('token')
if (token) 
  instanceApi.defaults.headers.common['Authorization'] = token

// const instanceUserApi = axios.create({
//   baseURL: 'https://userapi.com'
// });  
// instanceUserApi.defaults.headers.common["Authorization"] =
//   "Token" + localStorage.getItem("authToken");


Vue.prototype.$http = instanceApi;

new Vue({
  store,
  router,
  render: h => h(App)
}).$mount('#app')
