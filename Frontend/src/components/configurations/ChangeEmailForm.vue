<template>
  <v-card>
    <v-container>
      <v-card-title>
        <span class="title blue-grey--text text--darken-3">Mudar endereço de email</span>
      </v-card-title>
      <v-card-text>
        <v-layout row>
          <v-flex sx12 sm6 md5>
            <v-form fluid ref="form">
              <v-text-field
                label="Novo email"
                :rules="rules.email"
                :placeholder="user.email"
                v-model="inputEmail"
                required
              ></v-text-field>
              <v-text-field
                label="Confirmação de senha"
                :rules="rules.password"
                v-model="inputPasswd"
                required
              ></v-text-field>

              <v-btn color="info" @click="submitUserEdit">Enviar alteração</v-btn>
              <v-snackbar
                v-model="snackbar"
                :color="snackbarColor"
                bottom
                right
                :timeout="5000"
              >
                {{snackbarText}}
                <v-btn :color="snackbarColor" flat @click="snackbar = false">Fechar</v-btn>
              </v-snackbar>
            </v-form>
          </v-flex>
        </v-layout>
      </v-card-text>
    </v-container>
  </v-card>
</template>

<script>
import emailValidator from "../../utils/validators/emailValidator";
export default {
  data() {
    return {
      rules: {
        email: [
          email => emailValidator.validate(email) || emailValidator.getMessage()
        ],
        password: [passwd => passwd.length >= 8 || "Mínimo de 8 carcateres"]
      },
      inputEmail: "",
      inputPasswd: "",
      snackbar: false,
      snackbarColor: "success",
      snackbarText: ""
    };
  },
  props: {
    user: {
      type: Object
    }
  },
  methods: {
    submitUserEdit() {
      if (this.$refs.form.validate()) {
        if (this.user.password === this.inputPasswd) {
          //logica de alteração de usuário
          this.snackbarText = "Email alterado com sucesso!";
          this.snackbar = true;
        } else {
          //colocar apos requisição mal sucedida
          this.snackbarText = "Houve um erro ao tentar alterar o email!";
          this.snackbarColor = "error";
          this.snackbar = true;
        }
      }
    }
  }
};
</script>

<style>
</style>
