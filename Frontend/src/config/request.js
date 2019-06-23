import axios from 'axios'

export default axios.create({
    baseURL: '192.168.1.6:8090/api/'
})