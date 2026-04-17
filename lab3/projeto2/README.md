# 🎮 Lab 3 - Fase 2: Full-Stack Game Manager

Este projeto representa a conclusão do Lab 3 da disciplina do professor Giuliano Bertoti. Nesta fase, a API REST desenvolvida anteriormente foi integrada a uma interface visual (Front-end), permitindo a gestão completa de uma biblioteca de jogos diretamente pelo navegador.

## 🌟 Diferenciais desta Fase
Diferente da Fase 1, que era uma API pura testada via terminal/Postman, esta versão utiliza o conceito de **Recursos Estáticos** do Spring Boot para servir uma interface Single Page Application (SPA) moderna e funcional.

## 🛠️ Stack Tecnológica
- **Back-end:** Java 17 com Spring Boot.
- **Banco de Dados:** MySQL (Persistência Relacional).
- **Front-end:** HTML5, CSS3 (Gamer Theme) e JavaScript Vanilla (Fetch API).
- **Arquitetura:** RESTful (Client-Server).

## 🏗️ Arquitetura do Sistema
A aplicação segue o modelo de comunicação discutido em sala:
1. **Cliente (Browser):** O `index.html` envia requisições assíncronas (AJAX/Fetch) para o servidor.
2. **Servidor (Spring Boot):** O `RestApiDemoController` processa as requisições e interage com o Banco de Dados.
3. **Persistência (MySQL):** O banco `LAB3_JOGOS` garante que os dados não sejam perdidos ao reiniciar a aplicação.

## 🚀 Como Executar e Visualizar
1. Certifique-se de que o serviço **MySQL** está ativo.
2. Execute a aplicação via IntelliJ ou terminal:
   ```bash
   ./mvnw spring-boot:run