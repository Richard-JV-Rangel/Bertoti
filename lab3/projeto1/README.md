# 🎮 Lab 3 - Fase 1: API REST de Jogos

Este projeto representa a primeira fase da entrega do Lab 3. O foco aqui é a construção de uma **API RESTful back-end pura**, responsável por expor endpoints de CRUD e garantir a persistência segura dos dados.

## ⚙️ Arquitetura e Tecnologias
- **Linguagem:** Java 17
- **Framework:** Spring Boot (Web, Data JPA)
- **Banco de Dados:** MySQL Relacional
- **Gerenciador de Dependências:** Maven

## 🗄️ Estrutura do Banco
O banco `LAB3_JOGOS` contém a tabela principal `jogo`, responsável por armazenar o título e um ID autoincremental de cada registro. A aplicação possui scripts automatizados (`schema-bootstrap.sql` e `schema-app.sql`) que constroem a base e inserem dados iniciais na primeira execução.

## 📡 Endpoints da API
Abaixo estão as rotas disponíveis para consumo (podem ser testadas via arquivo `.http` interno, Postman ou Insomnia no endereço `http://localhost:8080`):

| Método | Rota | Ação |
|---|---|---|
| **GET** | `/games` | Lista todos os jogos cadastrados. |
| **GET** | `/games/{id}` | Busca os detalhes de um jogo específico. |
| **POST** | `/games` | Insere um novo jogo no banco de dados. |
| **PUT** | `/games/{id}` | Atualiza o título de um jogo existente. |
| **DELETE** | `/games/{id}` | Remove um jogo definitivamente. |