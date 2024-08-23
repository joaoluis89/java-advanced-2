Este projeto demonstra o uso do Spring Boot para criar uma API RESTful. Aqui você encontrará explicações sobre conceitos básicos relacionados ao Spring Boot, APIs REST, verbos HTTP e códigos de status HTTP.

## Sumário

- [Spring Boot](#spring-boot)
- [API REST](#api-rest)
- [Verbos HTTP](#verbos-http)
- [Códigos de Status HTTP](#códigos-de-status-http)

## Spring Boot

Spring Boot é um framework Java que simplifica o desenvolvimento de aplicações Java, especialmente as baseadas em Spring, ao configurar automaticamente a aplicação e permitir o uso de convenções ao invés de configurações explícitas. Ele elimina a necessidade de configuração manual extensa e facilita a criação e execução de serviços e aplicações de maneira rápida e eficiente.

### Características Principais:

- **Configuração Automática:** Spring Boot fornece uma configuração padrão que pode ser customizada conforme necessário, permitindo que você comece a desenvolver rapidamente.
- **Servidor Web Embutido:** Você pode executar aplicações Spring Boot diretamente em um servidor embutido como Tomcat, sem a necessidade de empacotá-las como WAR.
- **Dependências Starter:** Spring Boot oferece uma coleção de "starters" para simplificar a adição de bibliotecas à sua aplicação.

## API REST

API REST (Representational State Transfer) é um estilo arquitetural que utiliza os princípios do protocolo HTTP para construção de serviços web escaláveis e performáticos. As APIs RESTful se comunicam utilizando requisições HTTP e são descritas pelas suas operações de manipulação (Verbos) de recursos.

### Características de uma API RESTful:

- **Stateless:** Cada pedido de cliente para servidor deve conter todas as informações necessárias para entender e processar o pedido.
- **Interface Uniforme:** Simplifica e desconsidera a arquitetura, beneficiando a independência da aplicação da parte cliente.

## Verbos HTTP

Os verbos HTTP definem o tipo de operação que está sendo solicitada. Os mais comuns em APIs RESTful incluem:

- **GET:** Recupera dados de um servidor no servidor por URI fornecida. É seguro e idempotente.
- **POST:** Envia dados para o servidor para criar um novo recurso. Pode resultar em uma modificação do estado do servidor.
- **PUT:** Atualiza um recurso completo no servidor com dados fornecidos na requisição.
- **PATCH:** Atualiza parcialmente um recurso no servidor.
- **DELETE:** Remove um recurso do servidor.

## Códigos de Status HTTP

Os códigos de status HTTP mostram o resultado de uma requisição HTTP. Eles são divididos em categorias:

- **1xx (Informacionais):** Indica que o pedido foi recebido e o processo continua.
- **2xx (Sucesso):** A requisição foi recebida com sucesso. Exemplos:
  - **200 OK:** Requisição bem-sucedida.
  - **201 Created:** Novo recurso foi criado com sucesso.
- **3xx (Redirecionamento):** A ação adicional é necessária para completar o pedido.
- **4xx (Erro do Cliente):** A requisição contém sintaxe inválida ou não pode ser cumprida. Exemplos:
  - **400 Bad Request:** O servidor não pode ou não processará o pedido devido a algo que é percebido como um erro do cliente.
  - **404 Not Found:** O recurso requisitado não foi encontrado.
- **5xx (Erro do Servidor):** O servidor falhou ao completar uma requisição aparentemente válida. Exemplos:
  - **500 Internal Server Error:** Um erro genérico para quando o servidor encontra uma condição inesperada.
