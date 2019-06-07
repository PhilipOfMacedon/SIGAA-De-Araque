<template>
  <div class="home">
    <v-container fluid class align-center>
      <h1 class="display-1 font-weight-light blue-grey--text text--darken-4 ml-3">Home</h1>
      <v-container class="mb-3">
        <v-layout row wrap justify-space-between>
          <v-flex sx12 sm6 md3>
            <DisplaySystemInfo
              :info="'pesquisadores cadastrados'"
              :number="210"
              :icon_type="'person'"
            />
          </v-flex> 
          <v-flex sx12 sm6 md3>
            <DisplaySystemInfo
              :info="'grupos de pesquisa cadastrados'"
              :number="30"
              :icon_type="'group'"
            />
          </v-flex>
          <v-flex sx12 sm6 md3>
            <DisplaySystemInfo
              :info="'projetos de pesquisa cadastrados'"
              :number="130"
              :icon_type="'find_in_page'"
            />
          </v-flex>
        </v-layout>
      </v-container>
      <v-divider ></v-divider>

      <!-- <v-layout justify-center>
        <v-flex md6>
          <v-card class="mx-4 black--text text--darken-4" color="#F2F5F8" elevation="12">
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
              <v-layout row class="pt-4 pl-4">
                <div class="font-weight-medium subheading">Ir para:</div>
              </v-layout>
              <v-layout row class="pt-3 pl-3" justify-center wrap>
                <v-flex md4 class="text-xs-center" v-for="button in buttons" :key="button.name">
                  <v-btn
                    flat
                    round
                    class="indigo darken-2 white--text"
                    :to="button.route"
                  >{{button.name}}</v-btn>
                </v-flex>
              </v-layout>
            </v-container>
          </v-card>
        </v-flex>
      </v-layout>-->
    </v-container>
  </div>
</template>

<script>
import DisplaySystemInfo from "../components/home/DisplaySystemInfo";
import moment from "moment";

export default {
  components: {
    DisplaySystemInfo
  },
  data() {
    return {
      //Last login in milliseconds
      user: { username: "Filipe Rodrigues", lastLogin: 1558037257662 },
      buttons: [{name: "Projetos", route: "/projects"},
                {name: "Grupos de Pesquisa", route: "/research-groups"},
                {name: "Pesquisadores", route: "/researches"},
                {name: "Disciplinas", route: "/disciplines"},
                {name: "Publicações", route: "/publications"},
                {name: "Perfil", route: "/profile/edit"}]
    };
  },
  methods: {
    /** Método utilizado para formatar millisegundos, do último tempo de 
     *  login do usuário armazenado, para a string dia/mes/ano
     *   @returns{string} string que apresenta a data do último login em DD/MM/YYYY
     */ 
    getLoginDate() {
      return moment(this.user.lastLogin).format("DD/MM/YYYY");
    }
  }
};
</script>

<style>
</style>
