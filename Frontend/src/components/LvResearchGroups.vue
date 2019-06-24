<template>
  <div id="lv-researchGroups">
    <v-layout wrap justify-center class="grey lighten-1">
      <v-expansion-panel expand="true">
        <v-expansion-panel-content expand>
          <template v-slot:header>
            <div class="font-weight-bold">
              <h3>{{title}}</h3>
            </div>
          </template>
          <v-card>
            <v-layout row>
              <v-flex>
                <v-card-text class="font-weight-regular px-2 text-md-left">
                  <v-text v-if="members.length == 0">Nenhum membro cadastrado</v-text>
                  <v-list v-else two-lines>
                    <template v-for="(member,index) in members">
                      <v-list-tile :key="index">
                        <v-list-tile-content>
                          <v-list-tile-title v-html="member.name" @click="profile(index)"></v-list-tile-title>
                          <v-list-tile-sub-title v-html="member.ocupation"></v-list-tile-sub-title>
                        </v-list-tile-content>
                        <v-list-tile-action @click="remove(index, member.name)">
                          <v-icon color="grey">delete</v-icon>
                        </v-list-tile-action>
                      </v-list-tile>
                    </template>
                  </v-list>
                  <v-list>
                    <v-btn round outline small color="info" @click="addNewMember">
                      <v-icon center style="height:auto;">person_add</v-icon>Novo membro
                    </v-btn>
                  </v-list>
                </v-card-text>
              </v-flex>
            </v-layout>
            <v-dialog v-model="newMember" max-width="600px">
              <v-card
                class="mx-auto px-3 pt-4 pb-1 black--tex card-register"
                color="white lighten-1"
                elevation="12"
              >
              <v-form class="pa-4">
                <v-layout row>
                  <v-flex text-xs-center xs12 md12>
                    <v-toolbar-title>
                      <h3 class="display-1 pb-3 font-weight-light grey--text  text--darken-2 text-sm-center mb-2">Adicionar Membro</h3>
                    </v-toolbar-title>
                  </v-flex>
                </v-layout>
                <v-layout row>
                  <v-flex text-xs-center xs12 md12></v-flex>
                </v-layout>
                <v-layout row>
                  <v-flex xs12>
                    <v-text-field label="CPF do Membro" v-model="name" :mask="mask"></v-text-field>
                  </v-flex>
                </v-layout>
                <v-layout row class="mt-2">
                  <v-flex text-xs-center xs6 md6>
                    <v-btn large color="info" @click="add_confirm">Adicionar</v-btn>
                  </v-flex>
                  <v-flex text-xs-center xs6 md6>
                    <v-btn large color="warning" @click="add_cancel">Cancelar</v-btn>
                  </v-flex>
                </v-layout>
                </v-form>
              </v-card>
            </v-dialog>
            <v-dialog v-model="removeMember" max-width="600px">
              <v-card
                class="mx-auto px-3 pt-4 pb-3 black--tex card-register"
                color="white lighten-1"
                elevation="12"
              >
                <v-layout row class="pb-4">
                  <v-flex text-xs-center xs12 md12>
                    <v-toolbar-title class="display-1 font-weight-light grey--text text-sm-center">
                      <v-icon large center style="height:auto;">error_outline</v-icon>
                      Remover {{name_selected}}?
                    </v-toolbar-title>
                  </v-flex>
                </v-layout>
                <v-layout row>
                  <v-flex text-xs-center xs6 md6>
                    <v-btn large color="info" @click="remove_confirm">Confirmar</v-btn>
                  </v-flex>
                  <v-flex text-xs-center xs6 md6>
                    <v-btn large color="warning" @click="remove_cancel">Cancelar</v-btn>
                  </v-flex>
                </v-layout>
              </v-card>
            </v-dialog>
          </v-card>
        </v-expansion-panel-content>
      </v-expansion-panel>
    </v-layout>
  </div>
</template>

<script>
export default {
  name: "lv-researchGroups",
  data() {
    return {
      name_selected: "",
      id_selected: Number,
      member: {
        name: "",
        ocupation: ""
      },
      newMember: false,
      removeMember: false,
      mask: "###.###.###-##"
    };
  },
  props: {
    title: String,
    members: Array
  },
  methods: {
    addNewMember() {
      this.newMember = true;
    },
    add_confirm() {
      this.member.name = "Novo membro";
      this.member.ocupation = "Indefinida";
      if (this.member.name !== "") {
        this.members.push(this.member);
        this.name = "";
        this.newMember = false;
      }
    },
    add_cancel() {
      this.newMember = false;
    },
    remove(index, name) {
      this.name_selected = name;
      this.id_selected = index;
      this.removeMember = true;
    },
    remove_confirm() {
      this.members.splice(this.id, 1);
      this.removeMember = false;
    },
    remove_cancel() {
      this.removeMember = false;
    },
    profile(index) {
      alert("Aqui irá aparecer o profile do pesquisador de indice: " + index);
    }
  }
};
</script>

<style>
</style>