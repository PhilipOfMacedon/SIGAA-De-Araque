<template>
  <v-container>
    <h1 class="my-2 display-2">{{discipline.name}}</h1>
    <div class="mb-4">
      <span class="subheading">{{discipline.description}}</span>
    </div>
    <v-layout  class = "mb-4" row v-for="lesson in discipline.lessons" :key="lesson.name">
      <v-flex sx12>
        <v-card>
          <v-card-title class= "display-1" primary-title>{{lesson.name}}</v-card-title>
          <v-card-text>
              <div class="pb-3"> {{lesson.description}}</div>
              <div> <span class="font-italic font-weight-light"> <v-icon> date_range </v-icon> Iniciado em {{lesson.date_init}}</span> </div>
          </v-card-text>
        </v-card>
      </v-flex>
    </v-layout>
  </v-container>
</template>

<script>
export default {
  props: {
    id: Number
  },
  data() {
    return {
      discipline: {
        id: 188,
        name: "Estrutura de dados",
        description: "Essa não é uma disciplina legal 2",
        lessons: [
          {
            name: "aulas 1",
            description: "teste de iniciação",
            date_init: "06/02/2019"
          },
          {
            name: "aulas 2",
            description: "isso é um teste 2",
            date_init: "06/05/2019"
          }
        ]
      },
      students: [{ id: 3, name: "Filipe" }, { id: 4, name: "Barros" }]
    };
  }
};
</script>

<style>
</style>
