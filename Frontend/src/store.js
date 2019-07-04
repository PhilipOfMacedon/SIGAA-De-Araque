import axios from 'axios'
import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

axios.defaults.baseURL = 'localhost:8090/api/'
axios.defaults.headers.common['Access-Control-Allow-Origin'] = true

export default new Vuex.Store({
  state: {
    status: '',
    token: localStorage.getItem('token') || '',
    user: {}
  },
  mutations: {
    login_request(state) {
      state.status = 'loading'
    },
    login_success(state, token, user) {
      state.status = 'success'
      state.token = token
      state.user = user
    },
    login_error(state) {
      state.status = 'error'
    },
    logout(state) {
      state.status = ''
      state.token = ''
    }
  },
  actions: {
    login: ({ commit }, user) => {
      return new Promise((resolve, reject) => {
        commit('login_request')
        axios.post('login/submit', user).then(resp => {
          console.log('dados da requisição de login: ', resp)
          const token = resp.data.token
          const user = resp.data.user
          localStorage.setItem('token', token)
          axios.defaults.headers.common['Authorization'] = token
          commit('login_success', token, user)
          resolve(resp)
        })
          .catch(err => {
              console.log('There was an error  when trying to log')
            commit('login_error')
            localStorage.removeItem('token')
            reject(err)
          })
      })
    },
    logout: ({ commit }) => {
      return new Promise((resolve) => {
        commit('logout')
        localStorage.removeItem('token')
        delete axios.defaults.headers.common['Authorization']
        resolve()
      })
    }
  },
  getters: {
    isLoggedIn: state => !!state.token,
    authStatus: state => state.status,
  }
})
