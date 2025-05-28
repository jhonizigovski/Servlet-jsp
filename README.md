# Sistema de Cadastro e Gerenciamento de Carros

Este projeto é uma aplicação web simples para cadastro, listagem e remoção de carros, utilizando Java EE (Servlets, JSP), JDBC e banco de dados PostgreSQL. A interface utiliza Bootstrap para responsividade.

---

## Tecnologias Utilizadas

- Java Servlet API
- JSP com JSTL (JSP Standard Tag Library)
- JDBC para acesso a banco de dados PostgreSQL
- Bootstrap 5 para estilização
- JSTL Core e Format para renderização JSP
- DataSource configurado via JNDI (`java:/comp/env/jdbc/postgresql`)

---

## Estrutura do Projeto

- **Modelo (`br.edu.ifms.modelo`)**: Classe `Carro` representando o objeto carro com atributos como marca, nome, modelo, cor, data de fabricação, chassi e status ativo.
- **DAO (`br.edu.ifms.dao`)**: Classe `CarroDAO` para operações de CRUD no banco de dados.
- **Controle (`br.edu.ifms.controle`)**:
  - `AdminControle`: Servlet para ações administrativas (listar, apagar carros).
  - `IndexControle`: Servlet para ações públicas (novo cadastro, inserir carro).
- **Utilitários (`br.edu.ifms.controle.util`)**: Classe `ManipulacaoData` para conversão de strings para `Date`.
- **Configuração de conexão (`br.edu.ifms.dao.util.Conexao`)**: Utiliza `DataSource` via JNDI para obter conexão com o banco.

---

## Funcionalidades

- Cadastro de novos carros através do formulário em JSP.
- Listagem de carros cadastrados na área administrativa.
- Exclusão de carros cadastrados pela área administrativa.
- Conversão de datas do formato `dd/MM/yyyy` para objeto `Date`.
- Interface responsiva e amigável com Bootstrap.
- Navegação entre páginas via parâmetros `acao` nos Servlets.

---

## Configuração do Banco de Dados

- Utiliza PostgreSQL.
- Configurar `DataSource` no servidor de aplicação (ex: Tomcat) com o nome `java:/comp/env/jdbc/postgresql`.
- Tabela `carro` com colunas:

 " create table carro(
	id bigserial not null,
	ativo boolean,
	marca character varying(15),
	nome character varying(20),
	modelo character varying(20),
	cor character varying(20),
	fabricacao date,
	chassi character varying(15),
	constraint carro_pkey primary key (id)
);"

---

## Como Executar

1. Configurar o banco de dados PostgreSQL e criar a tabela `carro`.
2. Configurar o recurso JNDI `jdbc/postgresql` no servidor de aplicação.
3. Implantar a aplicação no servidor (ex: Tomcat).
4. Acessar a URL base para acessar a página pública de cadastro:  
   `http://localhost:8080/seuApp/publica`
5. Acessar a área administrativa para gerenciar carros:  
   `http://localhost:8080/seuApp/auth/admin?acao=listar`

---

## Melhorias Futuras

- Implementar autenticação e controle de acesso para a área administrativa.
- Validar entradas do usuário no backend e frontend.
- Implementar paginação na listagem de carros.
- Adicionar funcionalidades de edição de carros.
- Tratar melhor erros e mensagens para o usuário.
- Testes automatizados.

---

## Autor

Projeto desenvolvido para fins educacionais.


