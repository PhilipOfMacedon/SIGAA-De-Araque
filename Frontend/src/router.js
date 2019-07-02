import Vue from 'vue'
import Router from 'vue-router'
import Home from './views/Home.vue'
import Projects from './views/Projects'
import Researches from './views/Researches'
import Publications from './views/Publications'
import ProfileEdit from './views/ProfileEdit'
import Login from './views/Login'
import Disciplines from './views/Disciplines.vue'
import ResearchGroups from './views/ResearchGroups.vue'
import Configurations from './views/Configurations.vue'
import DisciplineDetails from './components/discipline/DisplayDiscipline'
import store from './store';

Vue.use(Router)


/**
 *  Função auxiliar para determinar se o usuário possue permissão para entrar
 *  em determinada porção do site
 * @param {*} to Váriavel que determina a página a ser navegada pelo usuário 
 * @param {*} from  Váriavel que determina a posição de origem do usuário
 * @param {*} next Callback do router que determina ações a serem executadas a seguir 
 */
const ifAuthenticated = (to, from, next) => {
  if (store.getters.isLoggedIn) {
    next()
    return
  }
  next('/')
}

const ifNotAuthenticated = (to, from, next) => {
  if (!store.getters.isLoggedIn) {
    next()
    return
  }
  next('/home')
}



export default new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'login',
      component: Login,
      // beforeEnter: ifNotAuthenticated
    },
    {
      path: '/home',
      name: 'home',
      component: Home,
      // beforeEnter: ifAuthenticated
    },
    {
      path: '/projects',
      name: 'projects',
      component: Projects
    },
   {
      path: '/researches',
      name: 'researches',
      component: Researches
    },
    {
      path: '/publications',
      name: 'publications',
      component: Publications
    },
    {
      path: '/profile/edit',
      name: 'profileEdit',
      component: ProfileEdit
    },
    {
      path: '/disciplines',
      name: 'disciplines',
      component: Disciplines
    },
    {
      path: '/research-groups',
      name: 'researchGroups',
      component: ResearchGroups
    },
    {
      path: '/configurations',
      name: 'configurations',
      component: Configurations

    },
    {
      path: '/disciplines/details/:id',
      name: 'disciplineDetails',
      component: DisciplineDetails,
      props: true
    }
  ]
})
