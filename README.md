## Documentação das APIs (Swagger)

Após iniciar a aplicação, acesse a documentação interativa das APIs via Swagger UI:

- [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

Você pode visualizar, testar e explorar todos os endpoints REST disponíveis.

# Trivia Web App Backend

> Backend da aplicação Trivia Web App, desenvolvido com Java 21 e Spring Boot.

## Estrutura do Projeto

- `src/main/java/com/trivia/client` — Integrações com clientes externos
- `src/main/java/com/trivia/service` — Lógica de negócio
- `src/main/java/com/trivia/controller` — Controllers REST
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

## Endpoints

### Health Check

- **GET** `/health-check`
	 - Retorna: `Service is up and running`
	 - Exemplo de requisição:
		```shell
		curl http://localhost:8080/health-check
		```

## Testes

Para rodar os testes automatizados:

```shell
mvn test
```

## Documentação

Consulte o arquivo `.github/copilot-instructions.md` para o checklist de setup e automações do projeto.
