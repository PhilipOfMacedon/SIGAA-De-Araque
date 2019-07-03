<template>
  <v-card>
    <v-container>
      <v-card-title primary-title>
        <span class="headline blue-grey--text text--darken-3">Mudar senha</span>
      </v-card-title>
      <v-card-text>
        <v-layout row>
          <v-flex sx12 sm6 md5>
            <v-form fluid ref="form">
              <div>
                <v-text-field
                  label="Senha atual"
                  v-model="inputOldPasswd"
                  required
                  :append-icon="showOldPasswd ? 'visibility' : 'visibility_off'"
                  @click:append="showOldPasswd = !showOldPasswd"
                  :type="showOldPasswd? 'text': 'password'"
                  :rules="[rules.password[0]]"
                ></v-text-field>
              </div>
              <div>
                <v-text-field
                  label="Senha nova"
                  v-model="inputNewPasswd"
                  required
                  :append-icon="showNewPasswd ? 'visibility' : 'visibility_off'"
                  @click:append="showNewPasswd = !showNewPasswd"
                  :type="showNewPasswd? 'text': 'password'"
                  :rules="rules.password"
                  counter
                ></v-text-field>
              </div>
                <div>
                    <v-text-field
                  label="Confirmação de nova senha"
                  v-model="inputConfirmPasswd"
                  required
                  type='password'
                  :rules="rules.confirmPassword"
                  counter
                ></v-text-field>
                </div>
   
              <v-btn class="mt-4 mb-0" color="info" @click="submitPasswdEdit">Enviar alteração</v-btn>
              <v-snackbar v-model="snackbar" :color="snackbarColor" bottom right :timeout="5000">
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
export default {
  data() {
    return {
      rules: {
        password: [passwd => !!passwd || "Senha obrigatória", passwd => passwd.length >= 8 || "Mínimo de 8 caracteres"],
        confirmPassword: [() => this.inputConfirmPasswd === this.inputNewPasswd || "As senhas estão diferentes"]
      },
      showOldPasswd: false,
      showNewPasswd: false,
      inputOldPasswd: "",
      inputNewPasswd: "",
      inputConfirmPasswd: "",
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
    submitPasswdEdit() {
      if (this.$refs.form.validate()) {
        if (this.user.password === this.inputPasswd) {
          //logica de alteração de usuário
          this.snackbarText = "Senha alterada com sucesso!";
          this.snackbar = true;
        } else {
          //colocar apos requisição mal sucedida
          this.snackbarText = "Houve um erro ao tentar alterar a senha!";
          this.snackbarColor = "error";
          this.snackbar = true;
        }
      }
    }
  },
  mounted() {
  }
};
</script>

<style>
</style>
