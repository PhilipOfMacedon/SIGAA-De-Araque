<template>
  <div class="projetos">
    <h1 class="font-weight-regular grey--text">Projetos</h1>
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
    </v-container> -->

  <v-container fluid >
       <v-layout wrap justify-center class="grey lighten-3">
           <v-flex xs6 sm6 class="pt-4" >
          <v-text-field
            label="Projetos"
            placeholder="nome do projeto"
            append-icon="search"
            outline
            v-model="search"
          ></v-text-field>
        </v-flex>
       </v-layout>
       <p>{{teste}}</p>
     
  </v-container>

  </div>
</template>

<script>
export default {
  data() {
    return {
      search:'',
      projects: [
        {name: 'Projeto1', author:'Professor1', category:'Iniciação científica', alunos:['Aluno1, Aluno2, Aluno3']},
        {name: 'Projeto2', author:'Professor2',  category: 'Iniciação científica', alunos:['Aluno1, Aluno2, Aluno3']}
        ]
    }
  },
  computed: {
    filteredBlogs: function() {
      return  this.projects.filter( project => {
        return 
      })
    }
  }
};
</script>
  
<style>
</style>
