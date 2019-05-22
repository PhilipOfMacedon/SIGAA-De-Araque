<template>
  <v-container class="md-4" fluid>
    <v-layout justify-center>
      <v-flex sx12 sm8 md6 justify-center>
        <v-container>
          <v-card elevation="5">
            <v-layout row wrap justify-center class="pt-3">
              <v-flex sx12 class="text-sm-center">
                <v-avatar :tile="true" :size="180" color="primary lighten-4">
                  <img :src="user.img_src" alt="profile picture">
                </v-avatar>
                <v-layout row justify-center class="my-3">
                  <v-flex sx12>
                    <v-btn bottom color="primary">
                      <v-icon>edit</v-icon>
                      <span>Alterar Imagem</span>
                    </v-btn>
                  </v-flex>
                </v-layout>
              </v-flex>
            </v-layout>
            <v-form>
              <v-layout justify-center row wrap>
                <v-flex sx12 md6 class="px-3">
                  <v-text-field v-model="user.email" :rules="nameRules" label="Email" required></v-text-field>
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
              </v-layout>
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
                  <v-text-field v-model="user.cpf" :rules="nameRules" label="CPF" required></v-text-field>
                </v-flex>
                <v-flex sx12 md4>
                  <v-text-field
                    v-model="user.contact_number"
                    :rules="nameRules"
                    label="Número de contato"
                    required
                  ></v-text-field>
                </v-flex>
              </v-layout>
              <!-- Utilziar disabled nos botoôes de formulário -->
              <v-layout row wrap justify-space-around class="pt-4 pb-2">
                <v-flex sx6 md4>
                  <v-btn color="success" @click="validate">Enviar</v-btn>
                </v-flex>
                <v-flex sx6 md4>
                  <v-btn color="warning" @click="validate">Resetar</v-btn>
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
export default {
  data() {
    return {
      user: {
        name: "rilipe",
        last_name: " rodrigues",
        cpf: "666",
        rg: "6969",
        contact_number: "123-123",
        email: "filiperodrigues@gmail.com",
        password: "easter egg",
        about: "This is a test",
        img_src: "https://avatars2.githubusercontent.com/u/28969294?s=460&v=4"
      },
      showPasswd: false
    };
  }
};
</script>

<style>
</style>
