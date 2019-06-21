<template>
  <div class="disciplines">
    <v-container>
      <h1 class="display-1 font-weight-light text--darken-4 ml-3">Disciplinas</h1>
      <v-layout row v-for="discipline in disciplines" :key="discipline.id">
        <v-flex sx12>
          <v-card :to="'/disciplines/details/' + discipline.id">
            <v-card-title>
              <h1
                class="display-1 blue--text text--darken-1 font-weight-bold"
              >{{discipline.name}}</h1>
            </v-card-title>
            <v-card-text class>
              <div>
                <span
                  class="subheading grey--text text--darken-3 font-weight-light"
                >{{discipline.description}}</span>
              </div>
            </v-card-text>
          </v-card>
          <v-divider></v-divider>
        </v-flex>
      </v-layout>

      <v-layout justify-center>
           <v-btn  large class="info">
          <v-icon>
            add
          </v-icon>
          Adicionar disciplina
          </v-btn>
      </v-layout>
    </v-container>
  </div>
</template>

<script>
export default {
  data() {
    return {
      //Apenas para propósitos de simulação, futuramente, as disciplinas serão lidas do
      //banco de dados
      disciplines: [
        {
          id: 150,
          name: "Banco de dados",
          description: "Essa é uma disciplina legal"
        },
        {
          id: 278,
          name: "Programação Web",
          description: "Essa é uma disciplina legal 2"
        },
        {
          id: 179,
          name: "Inteligência Artificial",
          description: "Essa não é uma disciplina legal"
        },
        {
          id: 188,
          name: "Estrutura de dados",
          description: "Essa não é uma disciplina legal 2"
        }
      ],

      searchStr: ""
    };
  },

  computed: {
    /**
     *  Método que filtra as disciplinas pelo nome, com a informação
     *  sendo determinada pelo pelo usuário através da barra de pesquisa
     *  @returns{disciplines[]} array de disciplinas que possui o nome pesquisado
     */
    filteredDisciplines() {
      return this.disciplines.filter(discipline => {
        let disciplineName = discipline.name.toUpperCase();
        return disciplineName.match(this.searchStr.toUpperCase());
      });
    }
  }
};
</script>

<style>

.disciplines a:hover {
  text-decoration: underline;
  color: white;
}

</style>
