<template>
  <v-app id="theme">
    <Navbar/>
    <v-content class="mx-4 mt-4">
      <router-view></router-view>
    </v-content>

  </v-app>
</template>

<script>
import Navbar from '@/components/Navbar'
export default {
  name: 'App',
  components: {Navbar},
  data () {
    return {
      //
    }
  }
}
</script>

<style>
#theme {
  background-image: linear-gradient(45deg,#DAE7F0,#FADAE7);
}
</style>
