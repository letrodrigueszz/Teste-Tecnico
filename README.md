# Teste Técnico – Cadastro de Usuários e Cartões

## Descrição
API em Java (Spring Boot) para cadastro de usuários e cartões de ônibus, com operações de CRUD, associação de cartões a usuários e ativação/inativação de cartões. Frontend em Angular com Bootstrap para consumir a API.

## Requisitos
- Java 8+
- Node.js 18+ (para o frontend)
- Maven (ou Maven Wrapper)

## Backend (Spring Boot)

### Tecnologias e features
- Spring Web, Spring Data JPA (H2 em memória)
- Flyway (migrações em `src/main/resources/db/migration`)
- Spring Security (HTTP Basic) – usuário padrão `admin`/`admin123`
- Bean Validation + `@ControllerAdvice`
- Swagger/OpenAPI (`springdoc-openapi`)
- Queries nativas em `UserRepository` e `CardRepository`

### Como rodar
1. No terminal, navegue até a pasta do projeto:
```
cd "C:\Users\letic\OneDrive\Documentos\teste tecnico"
```
2. Inicie a API:
```
mvn spring-boot:run
```
3. Endpoints úteis:
- Swagger UI: `http://localhost:8080/swagger-ui.html`
- H2 Console: `http://localhost:8080/h2-console`  
  JDBC: `jdbc:h2:mem:testdb` | User: `sa` | Senha: (vazia)

### Endpoints principais
- `GET /usuarios` – Lista todos os usuários
- `POST /usuarios` – Cria um novo usuário
- `PUT /usuarios/{id}` – Atualiza um usuário
- `DELETE /usuarios/{id}` – Remove um usuário
- `POST /usuarios/{id}/cartoes` – Adiciona cartão a um usuário
- `DELETE /usuarios/{id}/cartoes/{cartaoId}` – Remove cartão de um usuário
- `GET /cartoes` – Lista todos os cartões
- `PUT /cartoes/{id}/status?status=true|false` – Ativa/Inativa cartão
- `DELETE /cartoes/{id}` – Remove cartão

## Frontend (Angular + Bootstrap)

### Como criar (já criado neste repo)
O projeto Angular foi criado em `frontend/` com roteamento, SCSS e Bootstrap.

### Como rodar
1. Instale dependências:
```
cd frontend
npm install
```
2. Rode o servidor de desenvolvimento:
```
npm start
```
Acesse `http://localhost:4200`.

### Integração com a API
- A API exige autenticação HTTP Basic (`admin`/`admin123`). Configure um interceptor para enviar o header `Authorization` quando necessário.
- CORS está liberado para `http://localhost:4200` no backend.

## Estrutura do Projeto
```
├── pom.xml
├── README.md
├── src/
│   └── main/
│       ├── java/
│       │   └── com/example/testetecnico/
│       │       ├── Application.java
│       │       ├── config/
│       │       ├── controller/
│       │       ├── controller/advice/
│       │       ├── dto/
│       │       ├── model/
│       │       ├── repository/
│       │       └── service/
│       └── resources/
│           ├── application.properties
│           └── db/migration/V1__init.sql
└── frontend/
    ├── angular.json
    ├── package.json
    └── src/
```

## Observações
- O banco H2 é em memória (os dados somem ao parar a aplicação).
- Para usar outro banco, ajuste `application.properties` e a dependência no `pom.xml`.
- Para produção, substitua a autenticação in-memory por usuários e perfis persistidos.

---

Dúvidas? Abra uma issue ou entre em contato.
