# Projeto SIGAA-De-Araque
Repositório para o trabalho da disciplina de Programação WEB - Universidade Federal de Lavras :smiley:

![Watch on GitHub](https://img.shields.io/github/watchers/Filipe-Rodrigues/SIGAA-De-Araque.svg?style=social)
![Star on GitHub](https://img.shields.io/github/stars/Filipe-Rodrigues/SIGAA-De-Araque.svg?style=social)
## Aspectos gerais

###  Sobre
O projeto "SIGAA de Araque" tem como objetivo a implementação de um sistema WEB para o gerenciamento de atividades relacionadas a um docente/pesquisador. Com sua utilização será possível a gestão de alunos, projetos de pesquisa, aulas lecionadas, grupos de pesquisa e publicações referentes a um professor.

### Tecnologia
- Backend: Como tecnologia empregada no backend do sistema, será utilizado o Spring Boot, framework open source para a plataforma Java. A escolha da plataforma foi baseada na necessidade de se encontrar um conhecimento de programação comum aos desenvolvedores backend, e que, portanto, aprimore a eficiência de trabalho. Nesse contexto, a escolha do Spring Boot é fortemente baseada na definição da plataforma, além das vantagens de diminuir o tempo de desenvolvimento, facilitar testes de unidade e integração, e dispor de uma comunidade ativa, encontrando, facilmente, diversos materiais de apoio.


### Padronização do projeto
Serão apresentadas conjuntos de regras de desenvolvimento de forma a facilitar o entendimento e a comunicação entre os integrantes na função de desenvolvedores, bem como melhorar consideravelmente o gerenciamento do projeto como um todo.

#### Uso de Branches
- A master é uma branch protegida, logo não são permitdos commits diretos nela, os commits devem ser realizados em uma branch de trabalho do desenvolvedor e trazidos para master através de pulls requests.
- Cada branch deve possuir em seu nome o prefixo **dev** ou **fix**, o prefixo **dev** determina que o conteúdo da branch é o desenvolvimento de alguma funcionalidade, ou a adição de algo no repositório equanto o prefixo **fix** determina que a branch possui um conteúdo para correção de determinado problema propriamente delimitado na aplicação. Além do prefixo, o nome da branch deve conter palavras que que expõem alguma ideia sobre o que esta sendo trabalhado naquela branch.
- Assim, o nome de cada branch é padronizado como dev/{nomedabranch} ou fix/{nomedabranch}. Como exemplo, quando for necessário criar um projeto vue no repositório, deve-se criar a branch **dev/createVueProject**, onde ficarão os commits relacionados.
#### Commits
  Objetivando garantir rastreabilidade bidirecional entre commits e ítens do backlog do produto, é apresentada uma padronização da mensagem de commit, na qual:
- Uma mensagem de commit deve se iniciar por uma sentença que traga, objetivamente, a função do commit em questão.
- Uma mensagem de commit sempre deve indicar a **issue** a qual se relaciona, contendo em seu corpo um # ligado ao número da issue, essa indicação ocorre separada de vírgula da sentença inicial.
- Em caso de finalização total da terfa contida em uma issue, uma mensagem de commit deve utilizar a plavra chave **close** seguida do # e o número da issue.
- Nesse contexto, uma mensagem de commit pode ser apresentada da seguinte forma:
  1. Para tarefas totalmentes finalizadas
  ```
  finished vue components, close #23
  ```
  2. Em outros casos
  ```
  almost fixed component css,  #23
  ```
  Em caso de dois ou mais issues relacionados ao commit, separa cada issue por vrgula, incluindo o *keyword close* para cada repetição, se necessário
  
## Boas práticas de programação 

### Padrão de codificação

A organização da codificação e comentários no código do sistema são importantes para o seu desenvolvimento, correção de bugs, atividades de validação, manutenção e futuras extensões. Para isso, ser faz necessário um padrão de codificação, que deverá ser seguido por todos os desenvolvedores e é apresentado abaixo. 

#### Comentários

Os comentários deverão ser utilizados nos seguintes contextos:

- Descrição de métodos: deve aparecer antes do código referente ao método, na forma Nome – Método exemplificada a seguir.

“Cadastrar Usuário – Realização do cadastro do usuário, sendo necessário seu nome, idade e profissão.”

- Correção de bugs e modificações: deve aparecer antes do trecho de código referente ao problema encontrado ou modificação necessária, respeitando o padrão mostrado no exemplo:

“CORREÇÃO – Modificar o atributo curso para um ‘drop-down’, pegando todos os valores no banco de dados.”

#### Identação

Em cada um dos códigos a identação deve ser feita por tabulação(em um total de 2 espaços). 

#### Estruturas

As estruturas devem estar em mais de uma linha e identadas entre os níveis. Sua delimitação deve ser feita obrigatoriamente com chaves (“{}”).

#### Quebras de linha

Cada linha deve ter no máximo 80 caracteres. Ao passar esse limite, a linha deve ser quebrada, respeitando a identação. 

#### Linha em Branco

Deverá aparecer uma linha em branco:
- Entre métodos e construtores;
- Depois da última variável de instância;
- Dentro de um método entre variáveis locais e a primeira instrução;
- Dentro de um método para separar segmentos lógicos de código;
- Antes de comentários de uma linha ou bloco.


#### Métodos 

Os padrões de codificação referentes aos métodos serão:

- Métodos construtores devem ser os primeiros listados, seguidos dos estáticos e de instâncias. 
- Na assinatura dos métodos não há espaços entre o nome do método e o parêntese de abertura. 
- A chave de abertura “{“ deverá aparecer na mesma linha da declaração do método. 
- O nome do método não pode possuir nenhum caractere especial (ç, á, â, ...).
- Os nomes não devem ser abreviados, devem estar claros e ser auto explicativos. 

#### Nomenclatura – JavaScript

- Nomes de variáveis e métodos devem ser auto explicativos e não podem ser abreviados.
- Toda váriavel deve ser declarada utilizando apenas as palavras chaves let ou const
- Cada palavra referente ao nome de objetos, funções e instâncias devem ser iniciadas com letra maiúscula (exceto a primeira), sem espaço entre elas. 
```
let nomeProjeto = {};
function criarProjetoUsuario() {}
     let usuario = new Usuario({
          nome: 'Rebeca'
});
```
- Cada palavra referente ao nome de classes e construtores devem ser iniciadas com letra maiúscula, sem espaço entre elas. 
```
function Usuario(nomeUsuario) {
        this.nome = nomeUsuario.nome;
}

let usuarioAtual = new Usuario({
        nome: 'Rebeca'
});
```
- Use um sublinhado à esquerda _ ao nomear propriedades private:
```
this._primeiroNome = 'Isadora';
```
- Ao salvar uma referência do this use _this:
```
function() {
     const _this = this;
     return function() {
          console.log(_this);
     };
}
```
- É obrigatório a nomeação de funções:

```
const log = function log(msg) {
       console.log(msg);
};
```

#### Padrão Vue

 - Ao usar a propriedade data em um componente, o valor deve ser uma função que retorna um objeto. 
```
Vue.component('some-comp', {
  	data: function () {
    		return {
      			foo: 'bar'
    		}
  	}
})
```
- As definições dos props devem ser o mais detalhadas possível.

- Nunca use v-if no mesmo elemento que v-for.
```
<ul v-if="shouldShowUsers">
  	<li
    	     v-for="user in users"
            :key="user.id"
  	>
    	      {{ user.name }}
  	</li>
</ul>
```
- Estilos nos componentes que não são de nível superior ou de layout devem sempre ter o escopo definido. 
```
<template>
  	<button class="button button-close">X</button>
</template>

<style scoped>
.button {
  		border: none;
  		border-radius: 2px;
}

.button-close {
 		background-color: red;
}
</style>
```

- Nomes de arquivos de componentes de arquivo único devem ter a primeira letra de cada palavra do nome em letra maiúscula.
```
components/
|- MyComponent.vue
```
- Componentes de base que se aplicam estilos e convenções específicas para a aplicação devem todos começam com um prefixo específico, tais como Base, App, ou V.
```
components/
|- BaseButton.vue
|- BaseTable.vue
|- BaseIcon.vue
```
- Componentes que devem ter apenas uma única instância ativa devem começar com o prefixo The, para indicar que pode haver apenas um.

- Componentes filhos que são fortemente acoplados a seus pais devem incluir o nome do componente pai como um prefixo.

- Os nomes de componentes devem começar com as palavras de nível mais alto e terminar com palavras de modificação descritivas.
```
components/
|- SearchButtonClear.vue
|- SearchButtonRun.vue
|- SearchInputQuery.vue
```

- Os nomes dos componentes não devem ser abreviados.

- Elementos com vários atributos devem abranger várias linhas, com um atributo por linha.



