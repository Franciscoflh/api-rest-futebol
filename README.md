# API Rest de Futebol

Esta é uma API Rest de exemplo para gerenciamento de campeonatos de futebol. A API permite realizar operações CRUD (Create, Read, Update, Delete) em entidades como Times, Jogadores, Partidas e Campeonatos.

## Tecnologias utilizadas

- Java 17
-   Spring Boot
-   Spring Data JPA
-   Swagger
-   FlywayDB


## Executando o projeto

1.  Clone o repositório: `git clone https://github.com/Franciscoflh/api-rest-futebol.git`
2.  Acesse o diretório do projeto: `cd api-rest-futebol`
3.  Execute o comando: `gradle bootRun`

## Documentação da API

A API é documentada utilizando o Swagger. Após executar o projeto, você pode acessar a documentação 
em [http://localhost:server-port/swagger-ui.html](http://localhost:8090/swagger-ui.html).

A documentação descreve os endpoints disponíveis, os parâmetros esperados em cada requisição e as respostas retornadas pela API.

## Endpoints disponíveis

A API possui os seguintes endpoints principais:

-   `/times`: Gerenciamento dos times.
-   `/jogadores`: Gerenciamento dos jogadores.
-   `/partidas`: Gerenciamento das partidas.
-   `/campeonatos`: Gerenciamento dos campeonatos.
- `/resultados`: Gerenciamento dos resultados

Você pode utilizar ferramentas como o Postman ou o cURL para realizar requisições HTTP para os endpoints e testar a API.

##  Contribuindo

Contribuições são bem-vindas! Sinta-se à vontade para enviar pull requests ou abrir issues caso encontre algum problema ou queira sugerir melhorias para o projeto.
