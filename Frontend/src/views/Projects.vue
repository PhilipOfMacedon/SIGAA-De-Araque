<template>
  <div class="projects">
    <v-container fluid class="lighten-3 secondary">
          <h1 class="font-weight-regular blue-grey--text text--darken-4 ml-3">Projetos</h1>
          <v-card flat>
            <v-layout wrap justify-center class="lighten-3 secondary">
              <v-flex xs6 sm6 class="pt-4">
                <v-text-field
                  label="Projetos"
                  placeholder="nome do projeto"
                  append-icon="search"
                  outline
                  v-model="search"
                ></v-text-field>
              </v-flex>
            </v-layout>
            <v-layout wrap justify-center class="grey lighten-1">
              <v-expansion-panel expand="true">
                <v-expansion-panel-content expand v-for="project in filteredProjects" :key="project.name">
                  <template v-slot:header>
                    <div class="font-weight-bold">{{project.name}}</div>
                  </template>
                  <v-card>
                    <v-card-text class="font-weight-regular px-2 text-md-center">
                      <div style="justi">
                        <v-chip color="primary" text-color="white">Autor</v-chip>
                        <div>{{project.author}}</div>
                      </div>
                      <div>
                        <v-chip color="orange" text-color="white">Categoria</v-chip>
                        <div>{{project.category}}</div>
                      </div>
                      <v-chip color="grey darken-1" text-color="white">Alunos</v-chip>
                      <div v-for="aluno in project.alunos" :key="aluno">{{aluno}}</div>
                    </v-card-text>
                    <v-flex sm12 class="text-md-center">
                      <v-btn large color="success my-3">Vincular Aluno</v-btn>
                    </v-flex>
                  </v-card>
                </v-expansion-panel-content>
              </v-expansion-panel>
            </v-layout>
            <v-layout row justify-center>
              <v-btn large color="info" @click.stop="openDialog">
                <v-icon left>add_circle</v-icon> Adicionar projeto
              </v-btn>
              <CreateProject v-if="addNewProject" v-model="addNewProject"/>
            </v-layout>
          </v-card>
    </v-container>
  </div>
</template>

<script>
import CreateProject from "@/components/projects/CreateProject";
export default {
  components: {
    CreateProject: CreateProject
  },
  data() {
    return {
      search: "",
      addNewProject: false,
      projects: [
        {
          name: "Projeto1",
          author: "Professor1",
          category: "Iniciação científica",
          alunos: ["Aluno1, Aluno2, Aluno3"]
        },
        {
          name: "Projeto2",
          author: "Professor2",
          category: "Iniciação científica",
          alunos: ["Aluno1, Aluno2, Aluno3"]
        }
      ]
    };
  },
  computed: {
    filteredProjects: function() {
      return this.projects.filter(project => {
        let projectName = project.name.toUpperCase();
        return projectName.match(this.search.toUpperCase());
      });
    }
  },
  methods: {
    openDialog() {
      this.addNewProject = true;
    }
  }
};
</script>
  
<style>
</style>
