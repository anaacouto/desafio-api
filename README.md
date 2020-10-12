# desafio-api
API Restful feita em Java com o framework Spring, utilizando o gerenciador de banco de dados PostgreSQL. A IDE utilizada durante a criação e execução do projeto foi a IDE Eclipse. Abaixo seguem-se instruções para instalação e execução do projeto:

### Banco de Dados
Para executar o projeto, é necessário ter instalado o gerenciador de banco de dados PostgreSQL. Caso não o tenha em sua máquina, siga a [documentação oficial](https://www.postgresql.org/download/) do postgres para instalação.
Com o postgreSQL instalado, acesse o pgAdmin para criar um banco com o nome **desafio**. Com o banco criado, certifique-se de que existe um schema com o nome **public**. Não é necessário executar um *script* para criação das entidades já que o Spring mesmo irá criá-las quando o projeto for executado.

### API
Após realizar a importação do projeto na IDE, abra o arquivo **application.properties** localizado dentro do caminho *src/main/resources*. Foque nas seguintes linhas:
```
spring.datasource.url=jdbc:postgresql://localhost:5432/desafio
spring.datasource.username=postgres
spring.datasource.password=postgres
server.port=8080
```
A primeira linha contém o endereço do seu banco de dados. Use *localhost* se estiver rodando na sua máquina, *5432* é a porta padrão do PostgreSQL, altere-a caso esteja utilizando uma diferente. Em */desafio* é o nome do banco de dados criado no passo anterior.

A segunda e a terceira linha contém, respectivamente, o usuário e a senha para acesso ao banco. Altere caso use credenciais diferentes.

A quarta linha contém a porta em que será executada a aplicação.

Antes de executar a aplicação, realize o update das dependências do Maven. No Eclipse, basta clicar com o botão direito no nome do seu projeto e seguir o caminho *Maven > update project*. Depois que abrir a janela *update maven project*, marque a opção *force update of snapshots/releases* e clique em ok. Aguarde a atualização finalizar.

Com as dependências instaladas, basta executar o projeto clicando no ícone de **run** ou clicando novamente em cima do nome do seu projeto e seguindo o caminho *run as > java application*. Na janela que irá abrir, procure o item **DesafioApplication - br.com.dev.desafio** e clique em ok.

### Swagger
Para uma melhor visualização e utilização dos endpoints da API foi utilizado o **Swagger**. Após executar a aplicação na IDE, acesse a url abaixo em um browser para visualizar o swagger:

> http://localhost:8080/swagger-ui/

Você poderá visualizar os endpoints nas sessões **projeto-resource** e **tarefa-resource**.
