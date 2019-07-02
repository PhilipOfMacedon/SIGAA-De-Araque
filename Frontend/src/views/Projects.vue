<template>
  <div class="projects">
    <v-container fluid >
          <h1 class="display-1 font-weight-light text--darken-4 ml-3">Projetos</h1>
          <v-card >
            <v-layout row >
              <v-flex  sm6 offset-xs6 class="pt-4">
                <v-text-field class="search-bar"
                  label="Projetos"
                  placeholder="Pesquise por nome"
                  append-icon="search"
                  v-model="search"
                ></v-text-field>
              </v-flex>
            </v-layout>
            <v-layout wrap justify-center class="grey lighten-1">
              <v-expansion-panel expand=true>
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
                <v-icon left>library_add</v-icon> Adicionar projeto
              </v-btn>
              <CreateProject v-if="addNewProject" v-model="addNewProject"/>
            </v-layout>
          </v-card>
    </v-container>
  </div>
</template>

<script>
import CreateProject from "@/components/project/CreateProject";
export default {
  components: {
    CreateProject: CreateProject
  },
  data() {
    return {
      search: "",
      addNewProject: false,
      //COLOQUEI AQUI O DATA PROJECTS -------
      projects: [ //],
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
        },
        {
          name: "Projeto3",
          author: "Professor3",
          category: "Iniciação científica",
          alunos: ["Aluno1, Aluno2, Aluno3"]
        },
        {
          name: "Projeto4",
          author: "Professor3",
          category: "Iniciação científica",
          alunos: ["Aluno1, Aluno2, Aluno3"]
        }
        
      ],
    };
  },
  computed: {
    /**
     *  Método que filtra os projetos pelo nome, com a informação
     *  sendo determinada pelo pelo usuário através da barra de pesquisa
     *  @returns{projects[]} array de projetos que possui o nome pesquisado
    */
    filteredProjects: function() {
      return this.projects.filter(project => {
        let projectName = project.name.toUpperCase();
        return projectName.match(this.search.toUpperCase());
      });
    }
  },
  /**
   * Função para listar os projetos -> pega o projeto no back
  */
  created:function(){
    this.$http.get ("http://localhost:8090/project/projects").then(function (response){
      this.projects=response.body;
    }, function (response){
        console.log("Nenhum projeto!")
    })
  },
  methods: {
    // Método utilizado para controle do diálogo de cadastro de projetos
    openDialog() {
      this.addNewProject = true;
    }
  }
};
</script>
  
<style>
.search-bar {
  margin-right: 63px;
}
</style>
