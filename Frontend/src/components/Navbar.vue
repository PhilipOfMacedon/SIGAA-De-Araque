<template>
  <nav>
    <v-toolbar app>
      <v-toolbar-side-icon class="grey--text text--darken-3" @click="drawer = !drawer"></v-toolbar-side-icon>
      <v-toolbar-title class="grey--text">
        <span class="font-weight-light primary--text">SIGAA</span>
        <span class="secondary--text">DeAraque</span>
      </v-toolbar-title>
      <v-spacer></v-spacer>
      <v-btn flat color="red">
        <span>Sair</span>
        <v-icon right>exit_to_app</v-icon>
      </v-btn>
    </v-toolbar>
    <v-navigation-drawer temporary dark v-model="drawer" app class="indigo secondary">
      <v-list>
        <v-list-tile avatar>
          <v-list-tile-avatar>
            <img
              src="https://genslerzudansdentistry.com/wp-content/uploads/2015/11/anonymous-user.png"
            >
          </v-list-tile-avatar>
          <v-list-tile-content>
            <v-list-tile-title>Olá (nome do usuário)</v-list-tile-title>
          </v-list-tile-content>
        </v-list-tile>
      </v-list>

      <v-divider light class="secondary"></v-divider>

      <v-list>
        <v-list-tile v-for="link in links" :key="link.text" router :to="link.route">
          <v-list-tile-action>
            <v-icon class="white--text">{{link.icon}}</v-icon>
          </v-list-tile-action>
          <v-list-tile-content>
            <v-list-tile-title class="white--text">{{link.text}}</v-list-tile-title>
          </v-list-tile-content>
        </v-list-tile>

        <v-list-group prepend-icon="account_circle" value="false" no-action>
          <template v-slot:activator>
            <v-list-tile>
              <v-list-tile-title>Perfil</v-list-tile-title>
            </v-list-tile>
          </template>

          <v-list-tile
            v-for="userConfig in userConfigs"
            :key="userConfig.text"
            router
            :to="userConfig.route"
          >
            <v-list-tile-action>
              <v-icon small class="white--text">{{userConfig.icon}}</v-icon>
            </v-list-tile-action>
            <v-list-tile-content>
              <v-list-tile-title small class="white--text">{{userConfig.text}}</v-list-tile-title>
            </v-list-tile-content>
          </v-list-tile>
        </v-list-group>
      </v-list>
    </v-navigation-drawer>
  </nav>
</template>

<script>
export default {
  name: "Navbar",
  data() {
    return {
      drawer: false,
      links: [
        { icon: "home", text: "Home", route: "/" },
        { icon: "folder", text: "Projetos", route: "/projetos" },
        { icon: "assignment_ind", text: "Pesquisadores", route: "/" },
        { icon: "fa-tasks", text: "Disciplinas", route: "/" },
        { icon: "people", text: "Grupo de pesquisa", route: "/" },
        { icon: "fa-copy", text: "Publicações", route: "/" }
      ],
      userConfigs: [
        { icon: "fa-edit", text: "Editar pefil", route: "/" },
        { icon: "settings", text: "Configurações", route: "/projects" }
      ]
    };
  }
};
</script>

<style>
/* .v-list__group__header__prepend-icon .v-icon {
    color: red;
}   */
</style>
