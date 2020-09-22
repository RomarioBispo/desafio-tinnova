# API de Veículos

Esse repositório trata-se de uma API simples de veículos desenvolvida como parte de um processo seletivo.

### Pré-Requisitos

- Versão doJava 11+
- IDE (STS ou Intellij)

### Instalação

Clone o projeto para seu computador

Então,

```
Importe o projeto como maven na IDE que foi escolhida (STS ou Intellij)
```

Por fim,

```
Rode a aplicação como Spring Boot
```

## Detalhes técnicos

- Aplicação roda na porta 8443
- Swagger disponível em http://localhost:8443/swagger-ui.html#/
- Banco de dados em memória (h2)

## Módulos da aplicação

Basicamente, a aplicação de desafio consiste em 3 módulos

- api: É a API propriamente dita, contém os controllers e seus tratamentos
- common: É um módulo auxiliar que contém os services e repositories
- exercicio: É um modulo com os desafios de exercicio da tinnova, onde cada classe representa uma questão.

## Built With

- [Spring Boot](https://spring.io/projects/spring-boot) - The web framework used
- [Maven](https://maven.apache.org/) - Dependency Management

## FrontEnd

Esse projeto possui um front end react js disponível no respectivo [repositório git](https://github.com/RomarioBispo/desafio-tinnova-frontend)
