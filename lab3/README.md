# Lab 3: API REST de Gerenciamento de Jogos 🎮

Este projeto foi desenvolvido como parte das atividades de laboratório (Lab 3) da disciplina do professor Giuliano Bertoti. O objetivo principal é evoluir uma API REST básica em memória para uma aplicação que persiste dados em um Banco de Dados Relacional.

## 🎯 Objetivo do Projeto
Criar uma API RESTful completa utilizando **Java e Spring Boot**, implementando as quatro operações fundamentais (CRUD) através dos métodos HTTP (GET, POST, PUT, DELETE), e conectando a aplicação a um banco de dados **MySQL**.

## 🛠️ Tecnologias Utilizadas
* **Java 17**
* **Spring Boot** (Web, Data JPA)
* **MySQL** (Banco de Dados Relacional)
* **Maven** (Gerenciador de dependências)

## 🗄️ Estrutura do Banco de Dados
A aplicação utiliza um banco de dados chamado `LAB3_JOGOS`. A tabela principal é a `jogo`, contendo as seguintes colunas:
* `id` (BIGINT, Primary Key, Auto Increment)
* `titulo` (VARCHAR, Not Null)

*Nota: Os scripts de inicialização (`schema-bootstrap.sql` e `schema-app.sql`) estão configurados para criar o banco e popular alguns jogos iniciais automaticamente.*

## 🚀 Como Executar o Projeto

1. **Pré-requisitos:** Ter o Java 17+, Maven e o MySQL Server instalados e rodando na sua máquina.
2. **Configuração do Banco:** Certifique-se de que as credenciais do banco de dados no arquivo `Database.java` ou `application.properties` correspondem ao seu usuário local do MySQL (padrão: `root` / `123456`).
3. **Rodando a API:**
   Abra o terminal na raiz do projeto e execute:
   ```bash
   ./mvnw spring-boot:run
4. A API estará disponível em: http://localhost:8080/games📡 
## *Endpoints da API*
## 📡 Endpoints da API

Você pode testar as rotas abaixo utilizando o Postman ou Insomnia:

| Método HTTP | Endpoint | Descrição |
|---|---|---|
| **GET** | `/games` | Retorna a lista de todos os jogos. |
| **GET** | `/games/{id}` | Retorna um jogo específico pelo ID. |
| **POST** | `/games` | Cria um novo jogo. |
| **PUT** | `/games/{id}` | Atualiza o título de um jogo existente. |
| **DELETE** | `/games/{id}` | Remove um jogo do banco de dados. |

Desenvolvido para a disciplina de Banco de Dados / Laboratório de Desenvolvimento 3.