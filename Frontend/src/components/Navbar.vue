<template>
  <nav>
    <v-toolbar app color="indigo" class="indigo accent-4">
      <v-toolbar-side-icon class="white--text text--lighten-2" @click="drawer = !drawer"></v-toolbar-side-icon>
      <v-toolbar-title class="white--text">
        <span class="font-weight-light  ">SIGAA</span>
        <span class="white--text fornt-weight-bold text--darken-1">DeAraque</span>
      </v-toolbar-title>
      <v-spacer></v-spacer>
      <v-btn flat color="white" class="" :to="homepage">
        <span>Sair</span>
        <v-icon right>exit_to_app</v-icon>
      </v-btn>
    </v-toolbar>
    <v-navigation-drawer  dark v-model="drawer" app class="indigo accent-4">
      <v-list>
        <v-list-tile avatar>
          <v-list-tile-avatar>
            <img
              src="https://genslerzudansdentistry.com/wp-content/uploads/2015/11/anonymous-user.png"
            >
          </v-list-tile-avatar>
          <v-list-tile-content>
            <v-list-tile-title>Olá usuário </v-list-tile-title>
          </v-list-tile-content>
        </v-list-tile>
      </v-list>

      <v-divider light class="white"></v-divider>

      <v-list>
        <v-list-tile v-for="link in links" :key="link.text" router :to="link.route">
          <v-list-tile-action>
            <v-icon class="white--text">{{link.icon}}</v-icon>
          </v-list-tile-action>
          <v-list-tile-content>
            <v-list-tile-title class="white--text">{{link.text}}</v-list-tile-title>
          </v-list-tile-content>
        </v-list-tile>

        <v-list-group prepend-icon="account_circle" no-action>
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
      drawer: true,
      homepage: "/",
      links: [
        { icon: "home", text: "Home", route: "/home" },
        { icon: "folder", text: "Projetos", route: "/projects" },
        { icon: "assignment_ind", text: "Pesquisadores", route: "/researches" },
        { icon: "fa-tasks", text: "Disciplinas", route: "/disciplines" },
        { icon: "people", text: "Grupo de pesquisa", route: "/" },
        { icon: "fa-copy", text: "Publicações", route: "/publications" }
      ],
      userConfigs: [
        { icon: "fa-edit", text: "Editar pefil", route: "/profile/edit" },
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
