# Forum-Hub

Hub é uma aplicação de fórum desenvolvida utilizando Spring Boot para o back-end. Este projeto permite que usuários criem, atualizem, visualizem e excluam postagens e comentários. Além disso, a aplicação possui autenticação de usuário e suporte a CORS.


## Tecnologias Utilizadas
* Java 17
* Spring Boot 3.3.1
* Spring Security
* Spring Data JPA
* MySQL
* Flyway
* Thymeleaf
* Maven
* Lombok

## Configuração do Projeto

* Pré-requisitos
* Java 17 instalado
* Maven instalado
* MySQL instalado e configurado

## Estrutura do projeto


![Captura de tela 2024-07-15 125557](https://github.com/user-attachments/assets/feaab627-5025-4279-9cc1-5ba8f705f163)



##


## Clone o repositório:
bash

* git clone https://github.com/seu-usuario/hub.git
* Navegue até o diretório do projeto:
bash

* cd hub
* Compile e instale as dependências do projeto usando Maven:
bash

* mvn clean install

## Configuração do Banco de Dados
* Certifique-se de que o MySQL está rodando.
* Crie o banco de dados:
* sql



## Endpoints da API
Autenticação

* POST /api/authenticate: Autentica um usuário.


Segurança
A segurança é configurada utilizando Spring Security. O arquivo de configuração está localizado em src/main/java/com/forum/hub/config/SecurityConfig.java.

