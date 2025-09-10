# Teste Técnico – API Usuários e Cartões

[![Deploy Angular to GitHub Pages](https://github.com/letrodrigueszz/Teste-Tecnico/actions/workflows/gh-pages.yml/badge.svg)](https://github.com/letrodrigueszz/Teste-Tecnico/actions/workflows/gh-pages.yml)

- Site (frontend): `https://letrodrigueszz.github.io/Teste-Tecnico/`
- API local: `http://localhost:8080` | Swagger: `http://localhost:8080/swagger-ui.html`

## Stack
- Java 8 (Spring Boot 2.7.18)
- Spring Web, Data JPA, Validation, Security (HTTP Basic)
- H2 (memória) + Flyway
- Swagger/OpenAPI (springdoc 1.7.0)
- Angular 17 + Bootstrap 5 (frontend opcional)

## Backend – Build/Run
```
mvn clean package
mvn spring-boot:run
```
- Auth: `admin` / `admin123`
- H2 Console: `http://localhost:8080/h2-console` (JDBC `jdbc:h2:mem:testdb`)

## Endpoints
- Usuários: `GET/POST/PUT/DELETE /usuarios`
- Cartões por usuário: `POST /usuarios/{id}/cartoes`, `DELETE /usuarios/{id}/cartoes/{cartaoId}`
- Cartões: `GET/POST/DELETE /cartoes`, `PUT /cartoes/{id}/status?status=true|false`

Exemplos (payloads):
```json
// UserDTO
{
  "nome": "Maria Silva",
  "email": "maria@exemplo.com",
  "senha": "segredo123"
}
```
```json
// CardDTO
{
  "numeroCartao": 1234567890,
  "nome": "Cartão da Maria",
  "status": true,
  "tipoCartao": "COMUM"
}
```

## Migrações/Modelo
- Flyway em `src/main/resources/db/migration` (DDL em `V1__init.sql`)
- Tabelas: `users` e `cards` com FK; `email` único; senha com BCrypt
- Queries nativas: `UserRepository#findByEmailNative`, `CardRepository#findAllByUserIdNative`

## Frontend – Execução
```
cd frontend
npm install
npm start
```
- Deploy automático em GitHub Pages (branch `gh-pages`).

## Estrutura
```
src/main/java/...   (API)
src/main/resources/ (config + Flyway)
frontend/           (Angular)
docs/               (Guia técnico)
```

## Guia técnico
- Veja `docs/Guia.md` (build, DDL completa, contratos REST, segurança).
