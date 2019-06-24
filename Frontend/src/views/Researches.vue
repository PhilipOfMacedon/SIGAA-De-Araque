<template>
  <div class="Researches">
    <v-container fluid>
      <h1 class="display-1 font-weight-light  text--darken-4 ml-3">Pesquisadores</h1>
      <v-card flat>
        <v-layout row wrap justify-space-around class="pt-4">
          <v-flex sx6 sm4>
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
          <v-flex xs12 sm6>
            <v-text-field
              label="Publicações"
              :placeholder="'Pesquise por ' + search.optionSelected.option.toLowerCase()"
              append-icon="search"
              v-model="search.elem"
            ></v-text-field>
          </v-flex>
        </v-layout>
        <v-layout wrap justify-center class="grey lighten-1">
          <v-expansion-panel expand="true">
            <v-expansion-panel-content v-for="research in filteredResearches" :key="research.name">
              <template v-slot:header>
                <div class="font-weight-bold">{{research.name}}</div>
              </template>
              <v-card class="pb-4 ">
                <v-layout row justify-space-around align-center>
                  <v-flex sx6 sm4 class="pl-3">
                    <v-avatar :tile="tile" :size="100" color="grey lighten-1">
                      <img
                        src="https://genslerzudansdentistry.com/wp-content/uploads/2015/11/anonymous-user.png"
                        alt="avatar"
                      >
                    </v-avatar>
                  </v-flex>
                  <v-flex sx12 sm6>
                    <v-card v-for="project in research.projects" :key="project.name">
                      <v-layout row wrap :class="`pa-3 project ${project.class}`">
                        <v-flex xs12 md6>
                          <div class="caption grey--text">Nome do projeto</div>
                          <div>{{ project.name }}</div>
                        </v-flex>
                        <v-spacer></v-spacer>
                        <v-flex xs2 sm4 md2 >
                          <div class="right">
                            <v-chip
                              :class="`${project.class} white--text my-2 caption`"
                            >{{ project.type }}</v-chip>
                          </div>
                        </v-flex>
                      </v-layout>
                      <v-divider></v-divider>
                    </v-card>
                  </v-flex>
                </v-layout>
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
          { option: "Tipo de projeto", filter: "type" },
          { option: "Projetos", filter: "project" }
        ],
        optionSelected: { option: "nome", filter: "name" }
      },
      researches: [
        {
          name: "Professor1",
          projects: [
            { name: "Projeto1", type: "Mestrado", class: "mestrado" },
            {
              name: "Projeto2",
              type: "Iniciação científica",
              class: "iniciacao"
            }
          ]
        },
        {
          name: "Professor2",
          projects: [
            { name: "Projeto3", type: "Doutorado", class: "doutorado" }
          ]
        },
        {
          name: "Aluno1",
          projects: [{ name: "Projeto1", type: "Mestrado", class: "mestrado" }]
        }
      ]
    };
  },
  computed: {
    /**
     *  Método que filtra os pesquisadores pela categoria, nome do pesquisador
     *  ou nome de projeto ou tipo de pesquisa, com as informações obtidas
     *  pelo usuário através da barra de pesquisa
     *  @returns{researches[]} array de pesquisadores que correspondem ao que o usuário almeja
    */
    filteredResearches: function() {
      return this.researches.filter(research => {
        let value = [];

        if (this.search.optionSelected.filter === "project") {
          for (let project of research.projects) {
            value.push(project.name.toLowerCase.trim());
          }
        } else if (this.search.optionSelected.filter === "type") {
          for (let project of research.projects) {
            value.push(project.type.toLowerCase.trim());
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
.project.mestrado {
    border-left: 4px solid darkmagenta;
}
.project.iniciacao {
    border-left: 4px solid #ffb300; 
}
.project.doutorado {
    border-left: 4px solid #c6ff00; 
}
.project.pos-doutorado {
    border-left: 4px solid #00bfa5; 
}

.v-chip.mestrado {
  background: darkmagenta;
}
.v-chip.iniciacao {
  background: #ffb300;
}
.v-chip.doutorado {
  background: #c6ff00;
}
.v-chip.pos-doutorado {
  background: #00bfa5;
}
</style>
