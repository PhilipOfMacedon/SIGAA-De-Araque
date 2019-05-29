<template>
	<div id="lv-researchGroups">
		<v-layout wrap justify-center class="grey lighten-1">
			<v-expansion-panel expand=true>
				<v-expansion-panel-content expand>
					<template v-slot:header>
						<div class="font-weight-bold">{{title}}</div>
					</template>
					<v-card>
						<v-layout row >
							<v-flex>
								<v-card-text class="font-weight-regular px-2 text-md-left">
									<v-list v-for="member in members">
										{{member}}
									</v-list>
									<v-list>
										<v-btn round outline small color="info" @click="addNewMember">
											<v-icon center style="height:auto;">add_circle</v-icon>
											Novo membro
										</v-btn>
									</v-list>
								</v-card-text>
							</v-flex>
						</v-layout>
						<v-dialog v-model="newMember" max-width="600px">
							<v-card class="mx-auto px-3 pt-4 pb-3 black--tex card-register" color="white lighten-1" elevation=12>
								<v-layout row>
									<v-flex text-xs-center xs12 md12>
										<v-toolbar-title>
											<h3 class="display-1 font-weight-light grey--text text-sm-center">
												Novo Membro
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
										<v-text-field label="Nome do Membro"
										v-model="name">
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
			</v-expansion-panel-content>
		</v-expansion-panel>
	</v-layout>
</div>
</template>

<script>
export default{
	name: 'lv-researchGroups',
	data() {
		return {
			name: '',
			newMember: false,
		}
	},
	props: {
		title: String,
		members: Array,
	},
	methods: {
		addNewMember() {
			this.newMember = true
		},
		confirm(){
			let newName = this.name
			if(newName !== ''){
				this.members.push(newName)
				this.name = ""
				this.newMember = false
			}
		},
		cancel(){
			this.newMember = false
		},
	}
}
</script>

<style>

</style>