import Vue from 'vue';
import Router from 'vue-router';
import Home from './views/Home.vue';
import Projects from './views/Projects';
import Publications from './views/Publications';
import ProfileEdit from './views/ProfileEdit';
import Login from './views/Login'
import Disciplines from './views/Disciplines.vue'

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
      path: '/projects',
      name: 'projects',
      component: Projects,
    }, 
    {
      path: '/publications',
      name: 'publications',
      component: Publications,
    },
    {
      path: '/profile/edit',
      name: 'profileEdit',
      component: ProfileEdit,
    },
    {
      path: '/disciplines',
      name: 'disciplines',
      component: Disciplines,
    }
  ]
})
