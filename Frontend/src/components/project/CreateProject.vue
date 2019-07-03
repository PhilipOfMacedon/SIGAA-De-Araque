<template>
  <v-dialog persistent v-model="showDialog" max-width="800">
    <v-card>
      <v-card-title class="justify-center">
        <span class="display-1 grey--text text--darken-2 font-weight-light">Criar novo projeto</span>
      </v-card-title>
      <v-card-text>
        <v-container grid-list-md>
          <v-form ref="form">
            <v-layout row>
              <v-text-field v-model="project.name" label="Nome do projeto" required :rules="rules.projectName"></v-text-field>
            </v-layout>
            <v-spacer></v-spacer>
            <v-layout row>
              <v-menu offset-y>
                <v-text-field slot="activator" :value="selectedCategory" label="Categoria" required></v-text-field>
                <v-list>
                  <v-list-tile v-for="category in categories" :key="category" @click="selectedCategory = category">
                    <v-list-tile-title>{{ category }}</v-list-tile-title>
                  </v-list-tile>
                </v-list>
              </v-menu>
            </v-layout>
          </v-form>
        </v-container>
      </v-card-text>
      <v-layout justify-space-around>
        <v-btn large color="info darken-1">Adicionar</v-btn>
        <v-btn large color="warning white--text" @click="$emit('input', false)">Cancelar</v-btn>
      </v-layout>
    </v-card>
  </v-dialog>
</template>

<script>
export default {
  props: ["value"],
  data() {
    return {
      showDialog: this.value,
      categories: ["Iniciação científica", "Mestrado", "Doutorado", "Pós-doutorado" ],
      selectedCategory: "",
      project: { name: "", knowledgeField: "", students: "" },
      rules: {
        projectName: [
          name => name.length > 3 || "Mínimo de 4 caracteres",
          name =>  name.match('^[a-zA-Z]') || "Nomes devem começar por letras"
        ]
      }
    };
  },

  methods: {
    //Método para inserção do projeto
    inserir: function(){
      this.$http.post ("http://localhost:8090/project/addProject", this.project).then(function (response){
        this.projects.push(response.body);
      }, function (response){
        console.log("Nenhum projeto!")
      })
    }
  }
};
</script>

<style>
</style>
