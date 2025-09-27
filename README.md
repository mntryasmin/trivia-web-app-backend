# Trivia Web App Backend

> Backend da aplicação Trivia Web App, desenvolvido com Java 21 e Spring Boot.

## Estrutura do Projeto

- `src/main/java/com/trivia/client` — Integração com APIs externas (OpenTdbClient)
- `src/main/java/com/trivia/client/dto` — DTOs para comunicação com APIs externas
- `src/main/java/com/trivia/service` — Serviços de negócio
- `src/main/java/com/trivia/service/dto` — DTOs e Enums usados internamente
- `src/main/java/com/trivia/controller` — Controllers REST
- `src/main/java/com/trivia/exception` — Exceptions customizadas
- `src/main/resources` — Configurações da aplicação
- `src/test/java` — Testes automatizados

## Requisitos

- JDK 21
- Maven 3.8+ (ou Gradle)

## Como Executar

1. Compile o projeto:
	```shell
	mvn clean install
	```
2. Execute a aplicação:
	```shell
	mvn spring-boot:run
	```
	A aplicação estará disponível em `http://localhost:8080`.

## Testes

Para rodar os testes automatizados:

```shell
mvn test
```

## Documentação das APIs (Swagger)

Após iniciar a aplicação, acesse a documentação interativa das APIs via Swagger UI:

- [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

Você pode visualizar, testar e explorar todos os endpoints REST disponíveis.

## Integração com OpenTDB

Este projeto integra a [OpenTDB](https://opentdb.com/api_config.php) para buscar perguntas, categorias, tokens e estatísticas do banco de dados público de trivia.

### Endpoints REST disponíveis

- **POST** `/opentdb/trivia` — Busca perguntas de trivia conforme parâmetros enviados
- **GET** `/opentdb/categories` — Lista todas as categorias disponíveis
- **GET** `/opentdb/token` — Gera um novo token de sessão
- **GET** `/opentdb/token/reset?token=...` — Reseta o token informado
- **GET** `/opentdb/count` — Retorna estatísticas globais de perguntas

### Funcionamento

- O client (`OpenTdbClient`) monta as URLs dinamicamente e faz requisições HTTP usando `RestTemplate`.
- Parâmetros só são enviados se forem diferentes de null.
- O tratamento de erros é centralizado: códigos de erro da OpenTDB são convertidos em exceptions customizadas e retornam mensagens padronizadas para o usuário.

### Tratamento de erros

- Códigos de resposta da OpenTDB são verificados e convertidos em exceptions específicas.
- Exemplo: código 5 (rate limit) retorna HTTP 429 para o cliente.
- Todos os erros são logados e retornam mensagens claras para facilitar o diagnóstico.

### Referência

- [Documentação oficial da OpenTDB](https://opentdb.com/api_config.php)