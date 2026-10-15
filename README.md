# LeiloesTDSat

## Sobre o projeto

Projeto de um sistema desktop para apoiar as rotinas de uma casa de leilões, com telas de cadastro e listagem de produtos e estrutura de conexão com banco de dados. O material inicial contém a base da aplicação, que será desenvolvida nas próximas etapas.

## Tecnologias utilizadas

- Java
- Java Swing
- MySQL
- JDBC e MySQL Connector/J
- Apache Ant
- NetBeans
- Git e GitHub

## Banco de dados

O arquivo `uc11.sql` contém a estrutura da tabela `produtos` e os registros iniciais. Para preparar o banco, crie o schema `uc11` no MySQL e importe o arquivo SQL. A conexão é definida em `src/conectaDAO.java` e deve ser ajustada de acordo com o ambiente local.

## Estrutura do projeto

- `src/`: classes Java e formulários da interface.
- `lib/`: bibliotecas do MySQL Connector/J.
- `nbproject/`: configuração do projeto no NetBeans.
- `build.xml`: configuração de compilação com Apache Ant.
- `uc11.sql`: script do banco de dados.

## Abrir o projeto

Abra a pasta do projeto no NetBeans, configure o JDK compatível com o projeto (Java 18), prepare o banco de dados e confira os parâmetros da conexão antes de executar a aplicação.
