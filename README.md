# 🗣️ Forum Hub

API REST desenvolvida em **Java com Spring Boot** para gerenciamento de tópicos de um fórum.  
O projeto implementa autenticação com **JWT**, controle de usuários e CRUD de tópicos.

---

# 🚀 Tecnologias utilizadas

- Java 17+
- Spring Boot
- Spring Security
- Spring Data JPA
- JWT (JSON Web Token)
- MySQL
- Maven
- Lombok
- Flyway

---

# 🔐 Autenticação

A API utiliza **JWT (JSON Web Token)** para autenticação.

Fluxo de autenticação:

1. O usuário faz login.
2. A API retorna um token JWT.
3. O token deve ser enviado nas requisições protegidas.

   ---

# ▶️ Como executar o projeto

### 1. Clonar o repositório

```
git clone https://github.com/seu-usuario/forumhub.git](https://github.com/julianavsleal/Forum-Hub.git
```

### 2. Entrar na pasta do projeto

```
cd forumhub
```

### 3. Executar o projeto

```
mvn spring-boot:run
```

A aplicação iniciará em:

```
http://localhost:8080
```

---

# 🧪 Testando a API

Você pode testar os endpoints utilizando ferramentas como:

- Insomnia
- Postman

---

# 📖 Funcionalidades

✔ Cadastro de tópicos  
✔ Listagem de tópicos  
✔ Atualização de tópicos  
✔ Exclusão de tópicos  
✔ Autenticação com JWT  
✔ Proteção de rotas com Spring Security  
✔ Registra Login
   
