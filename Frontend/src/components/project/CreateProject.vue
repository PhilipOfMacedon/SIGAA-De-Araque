<template>
  <v-dialog persistent v-model="showDialog" max-width="800">
    <v-card>
      <v-card-title class="justify-center">
        <span class="headline grey--text text--darken-2 font-weight-medium ">Criar novo projeto</span>
      </v-card-title>
      <v-card-text>
        <v-container grid-list-md>
          <v-form ref="form">
            <v-layout row>
              <v-text-field v-model="project.name" :counter="15" label="Nome do projeto" required></v-text-field>
            </v-layout>
            <v-spacer></v-spacer>
            <v-layout row>
              <v-text-field v-model="project.categoria" :counter="15" label="Categoria" required></v-text-field>
            </v-layout>
          </v-form>
        </v-container>
      </v-card-text>
      <v-layout justify-space-around>
        <v-btn flat large color="success darken-1">Salvar</v-btn>
        <v-btn flat large color="orange darken-1" @click="$emit('input', false)">Cancelar</v-btn>
      </v-layout>
    </v-card>
  </v-dialog>
</template>

<script>
export default {
  props: ["value"],
  data() {
    return {
      showDialog : this.value,
      project: { name: "", categoria: "", alunos: "" }
    };
  }
};
</script>

<style>
</style>
