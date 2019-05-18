import Vue from 'vue'
import Router from 'vue-router'
import Home from './views/Home.vue'
import Projetos from './views/Projetos'
import Login from './views/Login'

Vue.use(Router)

export default new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'login',
      component: Login
    },
    {
      path: '/home',
      name: 'home',
      component: Home
    },
    {
      path: '/projetos',
      name: 'projectos',
      component: Projetos,
    }
  ]
})
