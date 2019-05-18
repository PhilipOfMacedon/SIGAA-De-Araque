<template>
	<v-jumbotron class="mx-auto mt-5">
		<v-container grid-list-md>
			<v-card
				class="mx-auto mt-5 pt-4 pb-2 black--text card-principal"
				color="white lighten-1"
				elevation=12
			>
				<v-layout row>
					<v-flex text-xs-center xs12 md12>
						<v-toolbar-title>
							<h2>{{ title }}</h2>
						</v-toolbar-title>
					</v-flex>
				</v-layout>
				<v-layout row>
					<v-flex text-xs-center xs12 md12>
						<v-card-text>
							{{ description }}
						</v-card-text>
					</v-flex>
				</v-layout>
				<!-- Buttons and Card's -->
				<v-layout align-center row>
					<v-flex text-xs-center xs6 md6>
						<v-btn flat color="primary" @click="dialogLogin = !dialogLogin">Login</v-btn>
					</v-flex>
					<v-flex text-xs-center xs6 md6>
						<v-btn flat color="primary" @click="dialogRegister = !dialogRegister">Cadastro</v-btn>
					</v-flex>
				</v-layout>
				<v-dialog v-model="dialogLogin" max-width="400px">
					<v-card class="mx-auto pt-4 pb-2 black--text card-login" color="white lighten-1" elevation=12>
						<LvLogin />
					</v-card>
				</v-dialog>
				<v-dialog v-model="dialogRegister" max-width="600px">
					<v-card class="mx-auto pt-4 pb-2 black--tex card-register" color="white lighten-1" elevation=12>
						<LvRegister />
					</v-card>
				</v-dialog>
			</v-card>
		</v-container>
	</v-jumbotron>
</template>

<script>
import LvLogin from '@/components/LvLogin.vue'
import LvRegister from '@/components/LvRegister.vue'

export default{
	data() {
		return {
			title: "Bem vindo(a) ao SIGAA de Araque",
			description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer sagittis dolor eget elit placerat, in tincidunt sapien laoreet. Nunc bibendum molestie ultrices. Suspendisse sit amet urna lorem. Vivamus accumsan orci id elit vulputate, at facilisis eros sagittis. Mauris eget mi vitae leo sodales consectetur eget id lorem. Sed et nisl odio.",
			dialogLogin: false,
			dialogRegister: false,
		}
	},
	components: {LvLogin, LvRegister},
}
</script>

<style>
.card-principal {
	max-width: 600px;
	margin: auto;
}
.card-login {
	max-width: 400px;
	margin: auto;
}
.card-register {
	max-width: 600px;
	margin: auto;
}
.borda {
	border: 1px solid red;
}
</style>