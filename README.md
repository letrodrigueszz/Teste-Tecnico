# Teste Técnico – API Usuários e Cartões

## 📌 Sobre o Projeto
Este projeto foi desenvolvido como parte de um **teste técnico**, com foco em demonstrar boas práticas de desenvolvimento de software, organização de código e utilização de testes automatizados.  
Ele implementa uma API REST para gerenciamento de **usuários** e **cartões**, com autenticação, validações e documentação.

---

## 🛠️ Tecnologias Utilizadas
- **Linguagem:** Java 8
- **Framework:** Spring Boot 2.7.18
- **Dependências principais:** Spring Web, Spring Data JPA, Spring Validation, Spring Security (HTTP Basic)
- **Banco de dados:** H2 em memória, com migrações via Flyway
- **Documentação de API:** Swagger / OpenAPI (springdoc 1.7.0)
- **Frontend (opcional):** Angular 17 + Bootstrap 5

---

## 📂 Estrutura do Projeto
```
.
├── frontend/                    # Aplicação Angular (opcional)
├── src/
│   └── main/                    # Código Java da API
│       ├── java/                # Código-fonte principal
│       └── resources/           # Configurações e migrações Flyway
├── docs/                        # Documentação técnica adicional
├── pom.xml                      # Gerenciamento de dependências (Maven)
└── README.md
```

---

## 🚀 Como Executar

### ▶️ Executando o Back-end
1. Certifique-se de ter **Java 8** e **Maven** instalados.
2. No diretório raiz do projeto, execute:
   ```bash
   mvn clean package
   mvn spring-boot:run
   ```
3. A API estará disponível em: `http://localhost:8080`  
4. A documentação interativa (Swagger) estará disponível em:  
   `http://localhost:8080/swagger-ui.html`

### 🖥️ Executando o Front-end (Opcional)
1. Entre na pasta do frontend:
   ```bash
   cd frontend
   npm install
   npm start
   ```
2. A aplicação estará disponível em: `http://localhost:4200`

---

## 📡 Endpoints Principais

| Recurso | Método | Caminho | Descrição |
|--------|--------|--------|-----------|
| Usuários | GET / POST / PUT / DELETE | `/usuarios` | CRUD de usuários |
| Cartões de um usuário | POST / DELETE | `/usuarios/{id}/cartoes` | Adicionar ou remover cartão de um usuário |
| Cartões | GET / POST / PUT / DELETE | `/cartoes` | CRUD de cartões |
| Ativar/Desativar cartão | PUT | `/cartoes/{id}/status?status=true|false` | Alterar status de um cartão |

### Exemplo de Payload – Usuário
```json
{
  "nome": "Maria Silva",
  "email": "maria@exemplo.com",
  "senha": "segredo123"
}
```

### Exemplo de Payload – Cartão
```json
{
  "numeroCartao": 1234567890,
  "nome": "Cartão da Maria",
  "status": true,
  "tipoCartao": "COMUM"
}
```

---

## 🗄️ Banco de Dados / Migrações
- Banco de dados em memória **H2**
- Migrações gerenciadas pelo **Flyway** (`src/main/resources/db/migration`)
- Regras importantes:
  - Email único por usuário
  - Senhas armazenadas com **BCrypt**
  - Consultas customizadas implementadas em repositórios nativos

Console do H2: `http://localhost:8080/h2-console`  
JDBC URL: `jdbc:h2:mem:testdb`

---

## 🔑 Autenticação
- **Método:** HTTP Basic
- **Credenciais padrão:**  
  - Usuário: `admin`  
  - Senha: `admin123`

---

## 📄 Documentação Técnica
Para detalhes sobre arquitetura, contratos REST e scripts de banco de dados, consulte a pasta `docs/`.

---

## ✅ Boas Práticas Implementadas
✔️ Código limpo e organizado  
✔️ Testes automatizados para endpoints críticos  
✔️ Validações de entrada e tratamento de erros  
✔️ Senhas criptografadas com **BCrypt**  
✔️ Documentação clara e atualizada

---

## 👨‍💻 Autor
**Letícia Rodrigues**  

---

> 📢 **Observação:** Este projeto foi desenvolvido exclusivamente para fins de avaliação técnica e demonstração de boas práticas de desenvolvimento.
