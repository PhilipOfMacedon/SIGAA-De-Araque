<template>
	<div>
		<v-layout row>
			<v-flex text-xs-center xs12 md12>
				<v-toolbar-title>
					Cadastre-se
				</v-toolbar-title>
			</v-flex>
		</v-layout>
		<div class="px-3">
			<v-layout row>
				<v-flex xs12 md12></v-flex>
			</v-layout>
			<v-layout row>
				<v-flex xs7>
					<v-text-field label="Nome"
					v-model="user.name">
				</v-text-field>
			</v-flex>
			<v-flex xs1></v-flex>
			<v-flex xs4>
				<v-text-field label="Sobrenome"
				v-model="user.lastname">
			</v-text-field>
		</v-flex>
	</v-layout>
	<v-layout row>
		<v-flex xs6>
			<v-text-field label="Cpf"
			v-model="user.cpf">
		</v-text-field>
	</v-flex>
	<v-flex xs1></v-flex>
	<v-flex xs5>
		<v-text-field label="Rg"
		v-model="user.rg">
	</v-text-field>
</v-flex>
</v-layout>
<v-layout row>
	<v-flex xs12>
		<v-text-field label="Telefone"
		v-model="user.telephone">
	</v-text-field>
</v-flex>
</v-layout>
<v-layout row>
	<v-flex xs12 md12>
		<v-text-field
		v-model="user.email"
		:rules="[rules.required, rules.email]"
		label="E-mail">
	</v-text-field>
</v-flex>
</v-layout>
<v-layout row>
	<v-flex xs12 md12>
		<v-text-field
		v-model="user.password"
		:append-icon="show ? 'visibility' : 'visibility_off'"
		:rules="[rules.required, rules.min]"
		:type="show ? 'text' : 'password'"
		name="input-10-1"
		label="Senha"
		@click:append="show = !show"
		>
	</v-text-field>
</v-flex>
</v-layout>
<v-layout row>
	<v-flex xs12 md12>
		<v-text-field
		v-model="user.password2"
		:append-icon="show ? 'visibility' : 'visibility_off'"
		:rules="[rules.required, rules.min]"
		:type="show ? 'text' : 'password'"
		name="input-10-1"
		label="Confirmar a senha"
		@click:append="show = !show"
		>
	</v-text-field>
</v-flex>
</v-layout>
<v-layout row>
	<v-flex text-xs-center xs12 md12>
		<v-btn color="info">
			Cadastrar
		</v-btn>
	</v-flex>
</v-layout>
</div>
</div>
</template>

<script>
export default{
	name: 'LvRegister',
	data() {
		return {
			user: {
				name: '',
				lastname: '',
				cpf: '',
				rg: '',
				telephone: '',
				email: '',
				password: '',
				password2: ''
			},
			show: false,
			rules: {
				required: value => !!value || 'Obrigatório.',
				counter: value => value.length <= 20 || 'No máximo 20 caracteres',
				email: value => {
					const pattern = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
					return pattern.test(value) || 'E-mail inválido.'
				},
				min: v => v.length >= 8 || 'Mínimo 8 caracteres',
			},
			route: "/",
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
span {
	color: blue;
}
</style>