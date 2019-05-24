<template>
  <div class="Researches">
    <v-container fluid class="secondary lighten-3">
      <h1 class="font-weight-regular blue-grey--text text--darken-4 ml-3">Pesquisadores</h1>
      <v-card flat>
        <v-layout row wrap justify-space-around class="grey lighten-3 secondary pt-4">
          <v-flex xs12 sm6>
            <v-text-field
              label="Publicações"
              :placeholder="'Pesquise por ' + search.optionSelected.option.toLowerCase()"
              append-icon="search"
              outline
              v-model="search.elem"
            ></v-text-field>
          </v-flex>
          <v-flex xm6 md4>
            <v-select
              v-model="search.optionSelected"
              :items="search.options"
              item-text="option"
              item-value="filter"
              label="Selecione uma categoria"
              persistent-hint
              return-object
              single-line
            ></v-select>
          </v-flex>
        </v-layout>
        <v-layout wrap justify-center class="grey lighten-1">
          <v-expansion-panel expand="true">
            <v-expansion-panel-content v-for="research in filteredResearches" :key="research.name">
              <template v-slot:header>
                <div class="font-weight-bold text-md-center">{{research.name}}</div>
              </template>
              <v-card>
                <v-layout row justify-center>
                  <v-avatar :tile="tile" :size="100" color="grey lighten-1">
                    <img
                      src="https://genslerzudansdentistry.com/wp-content/uploads/2015/11/anonymous-user.png"
                      alt="avatar"
                    >
                  </v-avatar>
                </v-layout>
                <v-card-text class="font-weight-regular px-2 text-md-center"></v-card-text>
              </v-card>
            </v-expansion-panel-content>
          </v-expansion-panel>
        </v-layout>
      </v-card>
    </v-container>
  </div>
</template>

<script>
export default {
  data() {
    return {
      search: {
        elem: "",
        options: [
          { option: "Nome", filter: "name" },
          { option: "Categoria", filter: "category" },
          { option: "Projetos", filter: "project" }
        ],
        optionSelected: { option: "nome", filter: "name" }
      },
      researches: [
        {
          name: "Professor1",
          projects: [
            { name: "Projeto1", category: "Mestrado" },
            { name: "Projeto2", category: "Iniciação científica" }
          ]
        },
        {
          name: "Professor2",
          projects: [{ name: "Projeto3", category: "Doutorado" }]
        },
        {
          name: "Aluno1",
          projects: [{ name: "Projeto1", category: "Mestrado" }]
        }
      ]
    };
  },
  computed: {
    filteredResearches: function() {
      return this.researches.filter(research => {
        let value = [];

        if (this.search.optionSelected.filter === "project") {
          for (let project of research.projects) {
            value.push(project.name.toLowerCase.trim());
          }
        } else if (this.search.optionSelected.filter === "category") {
          for (let project of research.projects) {
            value.push(project.category.toLowerCase.trim());
          }
        } else value = research.name;
        if (!Array.isArray(value)) {
          value = value.toLowerCase().trim();
          return value.match(this.search.elem.toLowerCase().trim());
        } else return value.indexOf(this.search.elem.toLowerCase().trim()) > -1;
      });
    }
  }
};
</script>
  
<style>
</style>
