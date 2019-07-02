<template>
  <div class="configurations">
    <v-container fluid>
      <h1 class="display-1 font-weight-light text--darken-4 ml-3 pb-2">Configurações</h1>
      <!-- <v-card>
        <v-layout column align-center align-content-space-around class="mb-3">
          <v-flex sx12 sm6 md4>
            <v-btn large color="info" block>Editar Email</v-btn>
          </v-flex>
          <v-flex sx12 sm6 md3>
            <v-btn large color="info" block>Editar senha</v-btn>
          </v-flex>
        </v-layout>
      </v-card>-->
      <v-tabs v-model="active" color="secondary" dark grow slider-color="primary">
        <v-tab v-for="n in 2" :key="n" ripple>
          <template v-if="n===1">Editar email</template>

          <template v-else>Editar senha</template>
        </v-tab>
        <v-tab-item v-for="n in 2" :key="n">
          <template v-if="n===1">
            <EmailForm :user="user" />
          </template>
        </v-tab-item>
      </v-tabs>
    </v-container>
  </div>
</template>
<script>
import EmailForm from "../components/configurations/ChangeEmailForm";

export default {
  data() {
    return {
      active: null,
      user: {
        password: "teste123456",
        email: "ola@gmail.com"
      }
    };
  },
  components: {
    EmailForm
  }
};
</script>

<style>
</style>
