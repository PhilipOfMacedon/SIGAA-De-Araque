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
- Uma mensagem de commit sempre deve indicar a **issue** a qual se relaciona, contendo em sua corpo um # ligado ao número da issue, essa indicação ocorre separada de vírgula da sentença inicial.
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
  
 #### Backlog

## Front-end

## Back-end
