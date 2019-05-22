<template>
  <div class="projects">
    <h1 class="font-weight-regular grey--text text-md-center">Projetos</h1>
    <!-- <v-container class="grey -ligthen-4" fill-height fluid>
      <v-layout row wrap justify-center>
        <v-flex xs12 sm12 md6 class="my-3 text-md-center">
          <v-card color="grey lighten-4" flat height="200px">
            <v-toolbar dark class="primary">
              <v-text-field  label="Regular" placeholder="Placeholder" class="pl-1 mt-1" append-icon="search"></v-text-field>
              <v-spacer></v-spacer>
           
            </v-toolbar>
          </v-card>
        </v-flex>
      </v-layout>
    </v-container>-->

    <v-container fluid>
      <v-layout justify-center>
        <v-flex sm6>
          <v-card>
            <v-layout wrap justify-center class="grey lighten-3 secondary">
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
              <v-expansion-panel>
                <v-expansion-panel-content v-for="project in filteredBlogs" :key="project.name">
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
                      <v-chip color="grey darken-1 white--text">Alunos</v-chip>
                      <div v-for="aluno in project.alunos" :key="aluno">{{aluno}}</div>
                    </v-card-text>
                    <v-flex sm12 class="text-md-center">
                      <v-btn color="success">Vincular Aluno</v-btn>
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
        </v-flex>
      </v-layout>
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
    filteredBlogs: function() {
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
