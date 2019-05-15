import Vue from 'vue'
import Vuetify from 'vuetify'
import './plugins/vuetify'
import App from './App.vue'
import store from './store'
import BootstrapVue from 'bootstrap-vue'
import 'roboto-fontface/css/roboto/roboto-fontface.css'
import 'material-design-icons-iconfont/dist/material-design-icons.css'
import router from './router'


Vue.config.productionTip = false;


Vue.use(BootstrapVue);
Vue.use(Vuetify);

new Vue({
  store,
  router,
  render: h => h(App)
}).$mount('#app')
