# Instruções para Executar o Projeto

## Pré-requisitos
- Java 8 ou superior
- Maven 3.6 ou superior
- Node.js 16 ou superior
- npm ou yarn

## Backend (Spring Boot)

### Execução via Maven
```bash
# Compilar o projeto
mvn clean compile

# Executar o backend
mvn spring-boot:run
```

### Execução via Script (Windows)
```bash
# Execute o arquivo start-backend.bat
start-backend.bat
```

O backend estará disponível em:
- **URL Principal**: http://localhost:8080
- **Swagger UI**: http://localhost:8080/swagger-ui.html
- **H2 Console**: http://localhost:8080/h2-console

### Credenciais para autenticação
- **Usuário**: admin
- **Senha**: admin123

## Frontend (Angular)

### Execução via npm
```bash
# Navegar para a pasta do frontend
cd frontend

# Instalar dependências
npm install

# Executar o frontend
ng serve --host 0.0.0.0 --port 4200
```

### Execução via Script (Windows)
```bash
# Execute o arquivo start-frontend.bat
start-frontend.bat
```

O frontend estará disponível em:
- **URL Principal**: http://localhost:4200

## Endpoints da API

### Usuários
- `GET /usuarios` - Listar todos os usuários
- `POST /usuarios` - Criar novo usuário
- `GET /usuarios/{id}` - Buscar usuário por ID
- `PUT /usuarios/{id}` - Atualizar usuário
- `DELETE /usuarios/{id}` - Remover usuário

### Cartões
- `POST /usuarios/{id}/cartoes` - Adicionar cartão ao usuário
- `DELETE /usuarios/{id}/cartoes/{cartaoId}` - Remover cartão do usuário

## Configurações de Segurança

O projeto está configurado para aceitar conexões de qualquer origem (CORS) para facilitar o desenvolvimento. Em produção, recomenda-se restringir as origens permitidas.

## Banco de Dados

O projeto utiliza H2 Database em memória, que é reiniciado a cada execução. Os dados são perdidos quando o servidor é parado.

Para acessar o console do H2:
1. Acesse http://localhost:8080/h2-console
2. Use as credenciais:
   - JDBC URL: jdbc:h2:mem:testdb
   - User Name: sa
   - Password: (deixe em branco)
