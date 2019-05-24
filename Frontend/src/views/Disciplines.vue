<template>
  <div class="disciplines">
    <h1 id="title" class="font-weight-regular blue-grey--text text--darken-4 text-md-center">Disciplinas</h1>
  
    <v-toolbar dense class="search-bar">
        <v-text-field hide-details prepend-icon="search" 
            single-line placeholder="Nome da disciplina"
            v-model="searchStr"
        >
        </v-text-field>
    </v-toolbar>
    
    <ul>
        <li v-for="d in filteredDisciplines" :key="d.name"><a>{{ d.name }}</a></li>
    </ul>

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
.disciplines{
    display: flex;
    align-items: center;
    justify-content: center;
    flex-direction: column;
}

#title{
    margin-bottom: 30px;
}

.search-bar{
    max-width: 40%;
}

ul{
    background-color: rgb(46, 3, 77);
    list-style: none;
    padding: 10px;
    margin-top: 30px;
    text-align: center;
    width: 45%;
}

li{
    background-color: #fff;
    border: 1px solid #eee;
    padding: 2px 20px;
    font-size: 1.6em;
}

a:hover{
    text-decoration: underline;
    color: rgb(68, 170, 151);
}
</style>
