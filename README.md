## Introdução:

Aplicação web para gerenciar as finanças residenciais.

O backend é uma API rest em java com Spring boot, Spring Data JPA e Spring Web.
Já o frontend, é um SPA utilizando TypeScript com React (Vite) e Chakra UI.

## Desenvolvimento:

Utilizei Java com Spring pois é a stack que tenho mais facilidade em trabalhar,
no front optei por utilizar chakra para ganhar agilidade no desenvolvimento da interface.

Utilzei Docker para chegar o mais proximo possivel do amibente de produção (Render).

Procurei manter uma separação clara entre os componentes da API (Dtos, Services e entities) e
evitar regras de negocio no frontend.

## Melhorias:

- Adição de cache no calculo dos custos e receitas por pessoal e nos totais.

- Realizar buscas paginadas.

- Implementar autenticação e autorização para os usuarios.

- CI/CD

## Deploy:

Toda a aplicação está na plataforma [Render](https://render.com/) (Banco de dados, Api e o app).

> [!WARNING]
> O [Render](https://render.com/) pode demorar até 50 segundos para atender a primeira requisição.

- frontend: https://home-finance-e5b5.onrender.com
- backend: https://home-finance-api.onrender.com

## Dev:

- frontend: http://localhost:5173
- backend: http://localhost:8080

```shell
# requisitos: Docker e Node.js
docker compose up -d

cd frontend

npm install && npm run dev
```

ou

```shell
# requisitos: Docker, Node.js e java 17
docker compose up -d database

cd backend

./gradlew bootRun

# outro terminal
cd frontend

npm install && npm run dev
```

## Testes:

A API possui testes de integração que verificam os principais fluxos.

```shell
# requisitos: java 17
cd backend

./gradlew test
```

## Stack:

###### app

- TypeScript
- Java
- React
- Chakra UI
- React Hook Form
- Spring Boot
- Spring Data JPA
- Spring Web
- Spring Validation

###### tests

- JUnit5
- H2 Database

###### ambiente

- Docker
- Postgres 16

###### ferramentas

- Render
