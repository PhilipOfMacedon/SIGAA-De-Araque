<template>
  <v-container>
    <h1 class="my-2 display-2">{{discipline.name}}</h1>
    <div class="mb-4">
      <span class="subheading">{{discipline.description}}</span>
    </div>
    <v-layout class="mb-4" row v-for="(lesson,index) in discipline.lessons" :key="lesson.name">
      <v-flex sx12>
        <v-card>
          <v-card-title class="display-1" primary-title>Aula {{index}} - {{lesson.name}}</v-card-title>
          <v-card-text>
            <div class="pb-3">{{lesson.description}}</div>
            <div>
              <span class="font-italic font-weight-light">
                <v-icon>date_range</v-icon>
                Iniciado em {{lesson.date_init}}
              </span>
            </div>
          </v-card-text>
        </v-card>
      </v-flex>
    </v-layout>
    <v-layout row>
      <v-dialog v-model="newLessonDialog" persistent max-width="600px">
        <template v-slot:activator="{ on }">
          <v-btn block color="info" v-on="on">Adicionar nova aula</v-btn>
        </template>
        <v-form ref="form">
          <v-card>
            <v-card-title>
              <span class="headline" primary-title>Nova Aula</span>
            </v-card-title>
            <v-card-text>
              <v-container grid-list-md>
                <v-layout row>
                  <v-flex xs12 sm5 md6>
                    <v-text-field
                      label="Título para aula"
                      required
                      v-model="input.title"
                      :rules="rules.lessonTitle"
                    ></v-text-field>
                  </v-flex>
                </v-layout>
                <v-layout row>
                  <v-flex xs12 sm10>
                    <v-textarea
                      solo
                      label="Descrição"
                      v-model="input.description"
                      value="Escreva aqui um resumo sobre o que será a aula"
                      hint="Descrição sucinta sobre a aula"
                      counter
                    ></v-textarea>
                  </v-flex>
                </v-layout>
                <v-layout row>
                  <v-flex sx12 sm6>
                    <v-menu
                      ref="menu1"
                      v-model="dateMenu"
                      :close-on-content-click="false"
                      :nudge-right="40"
                      lazy
                      transition="scale-transition"
                      offset-x
                      full-width
                      max-width="290px"
                      min-width="290px"
                    >
                      <template v-slot:activator="{ on }">
                        <v-text-field
                          :value="dateFormatted"
                          label="Data de inicio"
                          hint=" Escolha uma data no formato DD/MM/YYYY"
                          persistent-hint
                          prepend-icon="event"
                          v-on="on"
                          readonly
                        ></v-text-field>
                      </template>
                      <v-date-picker v-model="input.initDate" no-title @input="dateMenu = false"></v-date-picker>
                    </v-menu>
                  </v-flex>
                </v-layout>
              </v-container>
            </v-card-text>
            <v-spacer></v-spacer>
            <v-card-actions>
              <v-layout row justify-space-around>
                <v-flex md3>
                  <v-btn class="success" @click="addNewLesson">Adicionar</v-btn>
                </v-flex>
                <v-flex md3>
                  <v-btn class="warning" @click="resetInput">Fechar</v-btn>
                </v-flex>
              </v-layout>
            </v-card-actions>
          </v-card>
        </v-form>
      </v-dialog>
    </v-layout>
  </v-container>
</template>

<script>
import moment from "moment";

export default {
  props: {
    id: Number
  },
  data() {
    return {
      newLessonDialog: false,
      dateMenu: false,
      discipline: {
        id: 188,
        name: "Estrutura de dados",
        description: "Essa não é uma disciplina legal 2",
        lessons: [
          {
            name: "Pratica em laboratório",
            description: "teste de iniciação",
            date_init: "06/02/2019"
          },
          {
            name: "Conceitos avançados",
            description: "isso é um teste 2",
            date_init: "06/05/2019"
          }
        ]
      },
      students: [{ id: 3, name: "Filipe" }, { id: 4, name: "Barros" }],
      input: {
        title: "",
        description: "Escreva aqui sobre a aula",
        initDate: new Date().toISOString().substr(0, 10)
      },
      rules: {
        lessonTitle: [
          title => !!title || "O título é obrigatório",
          title => title.length >= 4 || "Mínimo de 4 caracteres"
        ]
      }
    };
  },
  computed: {
    dateFormatted() {
      return this.input.initDate
        ? moment(this.input.initDate).format("DD/MM/YYYY")
        : "";
    }
  },
  methods: {
    addNewLesson() {
      if (this.$refs.form.validate()) {
        this.discipline.lessons.push({
          name: this.input.title,
          description: this.input.description,
          date_init: this.dateFormatted
        });
        this.resetInput();
      }
    },
    mounted() {
      this.$http.get('http://192.168.1.101:8080/project/projects')
      .then( reponse => {
        this.projects = response.body
      })
      .catch(error => {
        console.log("Acontceu um erro")
        console.log(error)
      })
    },
    resetInput() {
      this.newLessonDialog = false;
      (this.input.title = ""),
        (this.input.description = "Escreva aqui sobre a aula"),
        (this.input.initDate = new Date().toISOString().substr(0, 10));
    }
  }
};
</script>

<style>
</style>
