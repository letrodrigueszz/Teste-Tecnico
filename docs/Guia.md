# Guia do Projeto – Teste Técnico

Este guia explica como instalar, rodar, testar e usar o projeto (backend Spring Boot + frontend Angular), além de decisões técnicas.

## Arquitetura
- Backend: Spring Boot 2.7, JPA, H2, Flyway, Security (Basic Auth), Swagger.
- Frontend: Angular 17, Bootstrap 5, Bootstrap Icons.
- Camadas: controller → service → repository → model, com DTOs no backend e validações.

## Requisitos
- Java 8+
- Node 18+ e npm
- Maven

## Backend
- URL base: `http://localhost:8080`
- Swagger: `http://localhost:8080/swagger-ui.html`
- H2 Console: `http://localhost:8080/h2-console` (JDBC `jdbc:h2:mem:testdb`, user `sa`, senha vazia)
- Auth: HTTP Basic `admin` / `admin123`

### Como rodar
```
# na raiz do projeto
mvn spring-boot:run
```

### Migração
- Flyway ativo. Migrações em `src/main/resources/db/migration`.
- `V1__init.sql` cria tabelas `users` e `cards`.

### Endpoints
- Usuários: `GET/POST/PUT/DELETE /usuarios`, `POST /usuarios/{id}/cartoes`, `DELETE /usuarios/{id}/cartoes/{cartaoId}`
- Cartões: `GET/POST/DELETE /cartoes`, `PUT /cartoes/{id}/status?status=true|false`

## Frontend
- URL: `http://localhost:4200`
- Interceptor envia `Authorization: Basic ...` (usuário admin/admin123)

### Rodar
```
cd frontend
npm install
npm start
```

## Decisões Técnicas
- H2 em memória para desenvolvimento rápido; Flyway para versionar schema.
- Security in-memory para simplificar o login no teste (pode evoluir para usuários persistidos).
- DTOs para desacoplar a entidade do contrato de API.
- Queries nativas de exemplo em `UserRepository` e `CardRepository`.

## Como gerar PDF deste guia
- Abra este arquivo no GitHub (`docs/Guia.md`) e use o navegador: Imprimir → Salvar como PDF.
- Alternativa: use `docs/guia.html` (estilizado) e exporte como PDF.

## Estrutura
```
backend: src/main/java ... | src/main/resources
frontend: frontend/
documentação: docs/
```

## Próximos passos sugeridos
- Persistir usuários do login e perfis/roles no banco.
- Testes automatizados (unit e integration).
- Docker Compose para subir API e banco relacional.
