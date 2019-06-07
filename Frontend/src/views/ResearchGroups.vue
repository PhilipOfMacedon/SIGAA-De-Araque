<template>
	<div class="researcheGroups">
		<v-container fluid >
			<h1 class="title-group pb-3 display-1 font-weight-light white--text--darken-4">Grupos de Pesquisa</h1>
			<v-card class="card-home">
				<v-layout row >
					<v-flex sm6 offset-xs6 class="pt-4">
						<v-text-field class="search-bar"
						label="Grupos de pesquisa"
						placeholder="nome do grupo"
						append-icon="search"
						v-model="search"
						></v-text-field>
					</v-flex>
				</v-layout>
				<v-list class="pl-1 pr-1" v-for="group in filteredGroups" :key="groups.title">
					<LvResearchGroups :title="group.title" :members="group.members"/>
				</v-list>
				<v-layout row justify-center>
					<v-btn large color="info" @click="addGroup">
						<v-icon left>group_add</v-icon> Adicionar Grupo de Pesquisa
					</v-btn>
				</v-layout>
				<v-dialog v-model="addNewGroup" max-width="600px">
					<v-card class="mx-auto px-3 pt-4 pb-3 black--tex card-register" color="white lighten-1" elevation=12>
						<v-layout row>
							<v-flex text-xs-center xs12 md12>
								<v-toolbar-title>
									<h3 class="display-1 font-weight-light grey--text text-sm-center">
										Novo Grupo de Pesquisa
									</h3>
								</v-toolbar-title>
							</v-flex>
						</v-layout>
						<v-layout row>
							<v-flex text-xs-center xs12 md12>
							</v-flex>
						</v-layout>
						<v-layout row>
							<v-flex xs12>
								<v-text-field label="Nome do Grupo"
								v-model="title">
							</v-text-field>
						</v-flex>
					</v-layout>
					<v-layout row>
						<v-flex text-xs-center xs6 md6>
							<v-btn large color="info" @click="confirm">
								Adicionar
							</v-btn>
						</v-flex>
						<v-flex text-xs-center xs6 md6>
							<v-btn large color="warning" @click="cancel">
								Cancelar
							</v-btn>
						</v-flex>
					</v-layout>
				</v-card>
			</v-dialog>
		</v-card>
	</v-container>
</div>
</template>

<script>
import LvResearchGroups from '@/components/LvResearchGroups.vue'

export default{
	data() {
		return {
			title: "",
			addNewGroup: false,
			search: "",
			groups: [
			{title: "Grupo A", members: [
			{
				name: 'Alexandre',
				ocupation: 'Pesquisador',
			},
			{
				name: 'Rafaela',
				ocupation: 'Pesquisador',
			},
			{
				name: 'Tarik',
				ocupation: 'Pesquisador',
			},
			{
				name: 'Filipe',
				ocupation: 'Pesquisador',
			}
			]
		},
			// {title: "Grupo B", members: ['Raydson','Hemerson','Marcio','Ricardo']},
			// {title: "Grupo C", members: []},
			]
		}
	},
	components: {LvResearchGroups},
	methods: {
		addGroup(){
			this.addNewGroup = true
		},
		confirm(){
			let newTitle = this.title
			if(newTitle !== ''){
				this.groups.push({
					title: newTitle,
					members: []
				})
				this.title = ""
				this.addNewGroup = false
			}
		},
		cancel(){
			this.addNewGroup = false
		},
	},
	computed: {
		filteredGroups: function() {
			return this.groups.filter(groups => {
				let groupName = groups.title.toUpperCase();
				return groupName.match(this.search.toUpperCase());
			});
		}
	},
}
</script>

<style>
.title-group {
	margin-left: 148px;
}
</style>