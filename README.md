# Loguin_Usuario

Este é um projeto simples desenvolvido em **Java** com **Swing** para a interface gráfica e **MySQL** como banco de dados, que realiza o cadastro de usuários (login e senha).

## Tecnologias Utilizadas

- **Java** (Swing) - Para a criação da interface gráfica.
- **MySQL** - Banco de dados para armazenar as informações de login e senha.
- **JDBC** - Para estabelecer a conexão entre o Java e o MySQL.

## Funcionalidades

- Tela de cadastro de usuário.
- Armazenamento de informações de login e senha no banco de dados MySQL.

## Como Usar

1. **Configuração do Banco de Dados:**
   - Crie um banco de dados chamado `usuario` no MySQL com a seguinte estrutura:
     ```sql
     CREATE DATABASE usuario;
     USE usuario;

     CREATE TABLE usuarios (
         id INT AUTO_INCREMENT PRIMARY KEY,
         email VARCHAR(100) NOT NULL,
         senha VARCHAR(100) NOT NULL
     );
     ```
2. **Configuração do Projeto:**
   - Clone este repositório no seu ambiente local.
   - Certifique-se de ter o MySQL configurado e funcionando.
   - No arquivo de configuração do banco (no código Java), ajuste o usuário, a senha e o nome do banco de dados de acordo com sua instalação do MySQL.

3. **Executando o Projeto:**
   - Compile e execute o projeto na sua IDE (como Eclipse, NetBeans ou IntelliJ IDEA).
   - Na interface gráfica, insira um email e uma senha para cadastrar um novo usuário.

## Como Contribuir

Sinta-se à vontade para contribuir com o projeto, corrigindo bugs, sugerindo melhorias ou adicionando novas funcionalidades. Para isso, basta criar um fork deste repositório, fazer suas alterações e submeter um pull request.
