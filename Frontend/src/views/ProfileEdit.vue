<template>
  <v-container class="md-4" fluid>
    <v-layout justify-center>
      <v-flex sx12 sm8 md6 justify-center>
        <v-container>
          <v-card elevation="5">
            <v-layout row wrap justify-center class="pt-3">
              <v-flex sx12 class="text-sm-center">
                <v-avatar :tile="true" :size="180" color="primary lighten-4">
                  <img :src="getUserImage" alt="profile picture" />
                </v-avatar>
                <v-layout row justify-center class="my-3">
                  <v-flex sx12>
                    <v-btn bottom color="primary" @click="$refs.inputUpload.click()">
                      <v-icon>edit</v-icon>
                      <span class="white--text">Alterar Imagem</span>
                      <input
                        type="file"
                        style="display: none"
                        @change="onFileSelected"
                        ref="inputUpload"
                      />
                    </v-btn>
                  </v-flex>
                </v-layout>
              </v-flex>
            </v-layout>
            <v-form ref="form">
              <!-- <v-layout justify-center row wrap>
                <v-flex sx12 md6 class="px-3">
                  <v-text-field v-model="user.email" :rules="rules.email" label="Email" required></v-text-field>
                </v-flex>
                <v-flex sm6 md4>
                  <v-text-field
                    :append-icon="showPasswd? 'visibility': 'visibility_off'"
                    :type=" showPasswd? 'text' : 'password'"
                    @click:append="showPasswd = !showPasswd"
                    v-model="user.password"
                    :rules="nameRules"
                    label="Senha"
                    required
                  ></v-text-field>
                </v-flex>
              </v-layout> -->
              <v-layout justify-space-around row wrap class="pt-2">
                <v-flex sx12 sm6 md4 class="px-3">
                  <v-text-field v-model="user.name" :rules="nameRules" label="Nome" required></v-text-field>
                </v-flex>
                <v-flex sx12 sm6 md4>
                  <v-text-field
                    v-model="user.last_name"
                    :rules="nameRules"
                    label="Sobrenome"
                    required
                  ></v-text-field>
                </v-flex>
              </v-layout>
              <v-layout justify-space-around wrap>
                <v-flex sx12 md4 class="px-3">
                  <v-text-field
                    v-model="user.cpf"
                    :rules="rules.cpf"
                    label="CPF"
                    v-mask="['###.###.###-##']"
                    required
                  ></v-text-field>
                </v-flex>
                <v-flex sx12 md4>
                  <v-text-field
                    v-model="user.contact_number"
                    :rules="rules.phone"
                    label="Número de contato"
                    v-mask="['(##) ####-####', '(##) #####-####']"
                    required
                  ></v-text-field>
                </v-flex>
              </v-layout>
                <v-layout justify-center row wrap class="pt-2" >
                <v-flex sx12 sm8 md6 class="px-3">
                  <v-text-field v-model="user.room" :rules="nameRules" label="Sala" required></v-text-field>
                </v-flex>              
              </v-layout>
              <!-- Utilziar disabled nos botoôes de formulário -->
              <v-layout row wrap justify-space-around class="pt-4 pb-2">
                <v-flex sx6 md4>
                  <v-btn color="success" @click="submitEdit">Editar Perfil</v-btn>
                </v-flex>
                <v-flex sx6 md4>
                  <v-btn color="warning" @click="reset">Limpar</v-btn>
                </v-flex>
              </v-layout>
            </v-form>
          </v-card>
        </v-container>
      </v-flex>
    </v-layout>
  </v-container>
</template>

<script>
import { mask } from "vue-the-mask";
import cpfValidator from "../utils/validators/cpfValidator";
import phoneValidator from "../utils/validators/phoneValidator";

export default {
  data() {
    return {
      user: {
        name: "rilipe",
        last_name: " rodrigues",
        cpf: "66666666666",
        rg: "6969",
        contact_number: "35996325657",
        email: "filiperodrigues@gmail.com",
        password: "easter egg",
        about: "This is a test",
        room: "Sala 21 do dcc",
        img_url: "https://avatars2.githubusercontent.com/u/28969294?s=460&v=4"
      },
      showPasswd: false,
      rules: {
        // email: [ v => !!v || 'Email é obrigatório',
        // v => /.+@.+/.test(v) || 'Email inválido'],
        cpf: [cpf => cpfValidator.validate(cpf) || cpfValidator.getMessage()],
        phone: [
          number =>
            phoneValidator.validate(number.toString()) ||
            phoneValidator.getMessage()
        ]
      },
      uploadImage : ""
    };
  },
  directives: { mask },
  methods: {
    submitEdit() {
      if (this.$refs.form.validate()) {
        // Código de submissão de ediçao para o back após a a validação
      }
    },
    reset() {
      this.$refs.form.reset();
      this.$refs.form.resetValidation();
    },
    onFileSelected(event) {
      console.log(event);
      // this.user.img_url = event.target.files[0]
      // da um http post request para o servidor com a nova imagem
      // buscar o novo url da imagem
      this.uploadImage = event.target.files[0]
    },
    uploadImageReq() {
      //enviar requisição  de form data com a nova imagem
      const fd = FormData();
      fd.append('image', this.selecetedFile, this.selecetedFile.name)
      // axios.post()
      this.getUserImage()
    }
  },
  computed: {
    getUserImage() {
      // adicionar rota para imagem
      return this.user.img_url
        ? this.user.img_url
        : "https://genslerzudansdentistry.com/wp-content/uploads/2015/11/anonymous-user.png";
    }
  }
};
</script>

<style>
</style>
