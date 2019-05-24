<template>
  <div class="home">
    <v-container fluid class="" align-center>
       <h1 class="display-1 font-weight-light blue-grey--text text--darken-4  ml-3">Home</h1>
      <!-- <v-layout row wrap>
        <v-flex xs12 md6>
          <v-btn outline block class="primary">1</v-btn>
        </v-flex>
        <v-flex xs4 md2>
          <v-btn outline block class="primary">2</v-btn>
        </v-flex>
        <v-flex xs4 md2>
          <v-btn outline block class="primary">3</v-btn>
        </v-flex>
        <v-flex xs4 md2>
          <v-btn outline block class="primary">4</v-btn>
        </v-flex>
      </v-layout>-->
      <v-layout justify-center>
        <v-flex md6>
          <v-card class="mx-4 black--text text--darken-4" color="#F2F5F8" elevation=12>
            <v-container>
              <v-layout row class="pb-4 pt-1" justify-center wrap>
                <v-flex sx12 md6 text-xs-center>
                  <div class="display-1 font-weight-regular text-capitalize">
                    Olá professor,
                    <div>{{user.username}}</div>
                  </div>
                </v-flex>
              </v-layout>
              <v-layout row class="pt-3 pl-4">
                <div class="font-weight-medium font-italic">Última vez logado: {{getLoginDate()}}</div>
              </v-layout>
              <v-layout row class="pt-4 pl-4 ">
                <div class="font-weight-medium subheading">Ir para:</div>
              </v-layout>
              <v-layout row class="pt-3 pl-3" justify-center wrap >
                <v-flex md4 class="text-xs-center" v-for="button in buttons" :key="button.name">
                  <v-btn flat round class="indigo darken-2 white--text " :to="button.route">{{button.name}}</v-btn>
                </v-flex>
              </v-layout>
            </v-container>
          </v-card>
        </v-flex>
      </v-layout>
    </v-container>
  </div>
</template>

<script>
const moment = require("moment");
export default {
  data() {
    return {
      //Last login in milliseconds
      user: { username: "Filipe Rodrigues", lastLogin: 1558037257662 },
      buttons: [{name: "Projetos", route: "/projects"},
                {name: "Grupos de Pesquisa", route: ""},
                {name: "Pesquisadores", route: "/researches"},
                {name: "Disciplinas", route: ""},
                {name: "Publicações", route: "/publications"},
                {name: "Perfil", route: "/profile/edit"}]
    };
  },
  methods: {
    getLoginDate() {
      return moment(this.user.lastLogin).format("DD/MM/YYYY");
    }
  }
};
</script>

<style>
</style>
