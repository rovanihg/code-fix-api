# 🛠️ Code & Fix API - Sistema de Gestão de Manutenção de Hardware

API RESTful desenvolvida em **Java (Spring Boot)** para gerenciamento de ordens de serviço e diagnósticos de bancada técnica. O projeto conta com persistência relacional via **PostgreSQL** em ambiente containerizado com **Docker**, documentação interativa via **Swagger**, e script de integração automatizada em **Python**.

---

## 🚀 Tecnologias Utilizadas
- **Linguagem & Framework:** Java 17+ | Spring Boot 4
- **Persistência de Dados:** Spring Data JPA | Hibernate | PostgreSQL
- **DevOps & Infrastructure:** Docker | Docker Compose
- **Documentação:** Springdoc OpenAPI (Swagger UI)
- **Scripting & Automação:** Python 3 (Requests)

---

## 📌 Funcionalidades
- **CRUD Completo:**
  - `GET /api/reparos` - Lista todos os registros.
  - `GET /api/reparos/{id}` - Busca registro específico por ID.
  - `POST /api/reparos` - Cadastra uma nova ordem de serviço.
  - `PUT /api/reparos/{id}` - Atualiza os dados de uma ordem existente.
  - `DELETE /api/reparos/{id}` - Remove um registro.
- **Auditoria Automática:** Carimbo de data/hora (`dataCriacao`) gerado no momento do salvamento.
- **Documentação Interativa:** Interface visual para teste de rotas.

---

## 🛠️ Como Executar o Projeto

### Pré-requisitos
- Docker e Docker Compose instalados.
- Java 17+ instalado.

### Passo a Passo
1. **Clonar o repositório:**
   ```bash
   git clone [https://github.com/SEU_USUARIO/code-fix-api.git](https://github.com/SEU_USUARIO/code-fix-api.git)
