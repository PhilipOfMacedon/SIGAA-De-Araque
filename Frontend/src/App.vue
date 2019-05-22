<template>
  <v-app id="theme">
    <v-content class="mx-4 mt-4">
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
#theme {
  background-image: linear-gradient(45deg,#DAE7F0,#FADAE7);
}
</style>
