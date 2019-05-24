<template>
  <v-app id="theme">
    <v-content>
      <Navbar v-if='this.$route.path !== "/"'></Navbar>
      <router-view></router-view>
    </v-content>
  </v-app>
</template>

<script>
import Navbar from '@/components/Navbar.vue'

export default {
  name: 'App',
  data () {
    return {
      //
    }
  },
  components: {Navbar},
}
</script>

<style>
.loginPage {
  background-color: linear-gradient(45deg,#96b9ff,#ff96f7);
}
#theme {
  background-color: #F1F5F8
}

</style>
