<template>
<div class="disciplines">
    <v-container fluid class="lighten-3 secondary">
        <h1 class="font-weight-regular blue-grey--text text--darken-4 ml-3">Disciplinas</h1>
        <v-card flat>
            <v-layout wrap justify-center class="lighten-3 secondary">
                <v-flex xs6 sm6 class="pt-4">
                <v-text-field
                    outline
                    placeholder="nome da disciplina"
                    append-icon="search"
                    v-model="searchStr"
                ></v-text-field>
                </v-flex>
            </v-layout>
            <v-layout wrap justify-center class="grey lighten-1">
                <v-expansion-panel>
                <v-expansion-panel-content expand-icon="null" v-for="d in filteredDisciplines" :key="d.name">
                    <template v-slot:header>
                        <router-link class="font-weight-bold link" 
                            :to="'/disciplines/' + d.name.toLowerCase().replace(/\s/g,'')"
                        >
                            {{d.name}}
                        </router-link>
                    </template>
                </v-expansion-panel-content>
                </v-expansion-panel>
            </v-layout>
        </v-card>
    </v-container>
</div>
</template>

<script>
export default {
    data(){
        return{
            //Apenas para propósitos de simulação, futuramente, as disciplinas serão lidas do 
            //banco de dados
            disciplines: [
                {id: 150, name: "Banco de dados"},
                {id: 278, name: "Programação Web"},
                {id: 179, name: "Inteligência Artificial"},
                {id: 188, name: "Estrutura de dados"},
            ],

            searchStr: ''
        }
    },

    computed:{
        filteredDisciplines(){
            return this.disciplines.filter(discipline => {
                let disciplineName = discipline.name.toUpperCase();
                return disciplineName.match(this.searchStr.toUpperCase());
            });
        }
    }
};
</script>

<style>

a{
    text-decoration: none;
}

a:hover{
    text-decoration: underline;
    color: rgb(68, 170, 151);
}
</style>
