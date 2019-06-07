<template>
	<div class="login">
		<v-layout row>
			<v-flex text-xs-center xs12 md12>
				<v-toolbar-title>
					<h3 class="display-1 font-weight-light grey--text text--darken-1 text-sm-center">
						Login
					</h3>
				</v-toolbar-title>
			</v-flex>
		</v-layout>
		<div class="px-3">
			<v-layout row>
				<v-flex xs12 md12></v-flex>
			</v-layout>
			<v-layout row>
				<v-flex xs12 md12>
					<v-text-field
					v-model="user.email"
					:rules="[rules.required, rules.email]"
					label="E-mail"
					>
				</v-text-field>
			</v-flex>
		</v-layout>
		<v-layout row>
			<v-flex xs12 md12>
				<v-text-field
				v-model="user.password"
				:append-icon="show1 ? 'visibility' : 'visibility_off'"
				:rules="[rules.required, rules.min]"
				:type="show1 ? 'text' : 'password'"
				name="input-10-1"
				label="Senha"
				@click:append="show1 = !show1"
				>
			</v-text-field>
		</v-flex>
	</v-layout>
	<v-layout row>
		<v-flex text-xs-center xs12 md12>
			<v-btn color="secondary" :to="route">
				Login
			</v-btn>
		</v-flex>
	</v-layout>
</div>
</div>
</template>

<script>
export default{
	name: 'LvLogin',
	data() {
		return {
			title: 'Login',
			user: {
				email: '',
				password: ''
			},
			show1: false,
			rules: {
				required: value => !!value || 'Obrigatório.',
				counter: value => value.length <= 20 || 'No máximo 20 caracteres',
				email: value => {
					const pattern = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
					return pattern.test(value) || 'E-mail inválido.'
				},
				min: v => v.length >= 8 || 'Mínimo 8 caracteres',
			},
			route: "/home",
		}
	},
	methods: {
	},
	components: {
	}
}
</script>

<style>
.borda {
	border: 1px solid red;
}
span .login {
	color: blue;
}
</style>