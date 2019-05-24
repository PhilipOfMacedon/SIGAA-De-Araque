<template>
  <div class="publications">
    <v-container fluid class="lighten-3 secondary">
          <h1 class="font-weight-regular blue-grey--text text--darken-4 ml-3">Publicações</h1>
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
                <v-expansion-panel-content
                  v-for="publication in filteredPublications"
                  :key="publication.name"
                >
                  <template v-slot:header>
                    <div class="font-weight-bold">{{publication.name}}</div>
                  </template>
                  <v-card>
                    <v-card-text class="font-weight-regular px-2 text-md-center">
                      <div>
                        <v-chip color="primary" text-color="white">Autor</v-chip>
                        <div>{{publication.author}}</div>
                      </div>
                      <div>
                        <v-chip
                          color="amber"
                          class="darken-3"
                          text-color="white"
                        >Área de conhecimento</v-chip>
                        <div>{{publication.area}}</div>
                      </div>
                      <div>
                        <v-chip color="green" class="darken-4" text-color="white">Data de publicação</v-chip>
                        <div>{{publication.release_date}}</div>
                      </div>
                    </v-card-text>
                    <v-flex sm12 class="text-md-center">
                      <v-btn color="error">Excluir publicação</v-btn>
                    </v-flex>
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
          { option: "Área de conhecimento", filter: "area" },
          { option: "Autor", filter: "author" },
          { option: "Data", filter: "date" }
        ],
        optionSelected: { option: "nome", filter: "name" }
      },
      publications: [
        {
          name: "Publicação1",
          area: "Banco de dados",
          author: "Professor1",
          release_date: "01/01/2019"
        },
        {
          name: "Publicação2",
          area: "Arquitetura de computadores",
          author: "Professor2",
          release_date: "03/05/2019"
        }
      ]
    };
  },
  computed: {
    filteredPublications: function() {
      return this.publications.filter(publication => {
        let projectValue = "";

        if (this.search.optionSelected.filter === "area") projectValue = publication.area;
        else if(this.search.optionSelected.filter === "author") projectValue = publication.author;
        else if(this.search.optionSelected.filter === "date") projectValue = publication.release_date;
        else projectValue = publication.name;

        projectValue = projectValue.toLowerCase().trim();
        return projectValue.match(this.search.elem.toLowerCase().trim());
      });
    }
  }
};
</script>
  
<style>
</style>
