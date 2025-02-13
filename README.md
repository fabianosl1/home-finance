## Introdução:

Aplicação web para gerenciar as finanças de uma casa.

O backend é uma API rest em java com Spring boot, Spring Data JPA e Spring Web. Já o frontend, é um SPA utilizando TypeScript com React (Vite) e Chakra UI.

## Melhorias:

- Adição de cache no calculo dos custos e receitas por pessoal e nos totais.

- Realizar buscas paginadas.

- Implementar autenticação e autorização para os usuarios.

## Deploy:

Toda a aplicação está na plataforma [Render](https://render.com/) (Banco de dados, Api e o app).

> [!WARNING]
> O [Render](https://render.com/) pode demorar até 50 segundos para atender a primeira requisição.

- frontend: https://home-finance-e5b5.onrender.com
- backend: https://home-finance-api.onrender.com

## Dev:

> http://localhost:3000

```shell
# requisitos: Docker e Node.js
docker compose up -d

cd frontend

npm install && npm run dev
```

## Testes:

A API possui testes de integração que verificam os principais fluxos.

> [!TIP]
> O banco de dados deve estar ligado.

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

###### ambiente

- Docker
- Postgres 16

###### ferramentas

- Render
