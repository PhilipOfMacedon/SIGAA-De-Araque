<template>
  <v-app id="theme">
    <v-content class="mx-4 mt-2">
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
  background-image: linear-gradient(45deg,#96b9ff,#ff96f7);
}
</style>
