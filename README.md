# DAC-JPA

# Biblioteca API

## Descrição do Projeto

Este projeto é uma API RESTful para gerenciamento de uma biblioteca. Utilizando o Java Persistence API (JPA) e o PostgreSQL, a API permite o gerenciamento de livros, clientes, empréstimos e muito mais. É uma aplicação ideal para entender conceitos de persistência de dados e interação com bancos de dados.

## Entidades

O domínio do sistema é composto pelas seguintes entidades:

1. **Cliente**
   - Representa os usuários que podem emprestar livros.
   - Atributos: `id`, `nome`, `email`, `telefone`.

2. **Livro**
   - Representa os livros disponíveis na biblioteca.
   - Atributos: `id`, `titulo`, `isbn`, `autor`, `categoria`.

3. **Autor**
   - Representa os autores dos livros.
   - Atributos: `id`, `nome`, `nacionalidade`.

4. **Categoria**
   - Classifica os livros em diferentes gêneros.
   - Atributos: `id`, `nome`.

5. **Emprestimo**
   - Registra os empréstimos de livros pelos clientes.
   - Atributos: `id`, `dataEmprestimo`, `dataDevolucao`, `livro`, `cliente`.

6. **Funcionario**
   - Representa os funcionários da biblioteca que gerenciam o sistema.
   - Atributos: `id`, `nome`, `cargo`.

7. **Editora**
   - Representa as editoras dos livros.
   - Atributos: `id`, `nome`.

8. **Multa**
   - Registra as multas aplicadas aos clientes por atraso na devolução de livros.
   - Atributos: `id`, `valor`, `cliente`, `emprestimo`.

9. **Avaliacao**
   - Permite que os clientes avaliem os livros.
   - Atributos: `id`, `nota`, `comentario`, `livro`, `cliente`.

10. **Reserva**
    - Registra as reservas de livros feitas pelos clientes.
    - Atributos: `id`, `dataReserva`, `livro`, `cliente`.

## Endpoints

A API fornece os seguintes endpoints para interação:

### Clientes

- `GET /clientes`: Lista todos os clientes.
- `GET /clientes/{id}`: Obtém detalhes de um cliente por ID.
- `POST /clientes`: Cria um novo cliente.
- `PUT /clientes/{id}`: Atualiza os dados de um cliente existente.
- `DELETE /clientes/{id}`: Remove um cliente.

### Livros

- `GET /livros`: Lista todos os livros.
- `GET /livros/{id}`: Obtém detalhes de um livro por ID.
- `POST /livros`: Adiciona um novo livro.
- `PUT /livros/{id}`: Atualiza os dados de um livro existente.
- `DELETE /livros/{id}`: Remove um livro.

### Autores

- `GET /autores`: Lista todos os autores.
- `GET /autores/{id}`: Obtém detalhes de um autor por ID.
- `POST /autores`: Adiciona um novo autor.
- `PUT /autores/{id}`: Atualiza os dados de um autor existente.
- `DELETE /autores/{id}`: Remove um autor.

### Categorias

- `GET /categorias`: Lista todas as categorias.
- `GET /categorias/{id}`: Obtém detalhes de uma categoria por ID.
- `POST /categorias`: Adiciona uma nova categoria.
- `PUT /categorias/{id}`: Atualiza os dados de uma categoria existente.
- `DELETE /categorias/{id}`: Remove uma categoria.

### Empréstimos

- `GET /emprestimos`: Lista todos os empréstimos.
- `GET /emprestimos/{id}`: Obtém detalhes de um empréstimo por ID.
- `POST /emprestimos`: Registra um novo empréstimo.
- `PUT /emprestimos/{id}`: Atualiza os dados de um empréstimo existente.
- `DELETE /emprestimos/{id}`: Remove um empréstimo.

### Funcionários

- `GET /funcionarios`: Lista todos os funcionários.
- `GET /funcionarios/{id}`: Obtém detalhes de um funcionário por ID.
- `POST /funcionarios`: Adiciona um novo funcionário.
- `PUT /funcionarios/{id}`: Atualiza os dados de um funcionário existente.
- `DELETE /funcionarios/{id}`: Remove um funcionário.

### Editoras

- `GET /editoras`: Lista todas as editoras.
- `GET /editoras/{id}`: Obtém detalhes de uma editora por ID.
- `POST /editoras`: Adiciona uma nova editora.
- `PUT /editoras/{id}`: Atualiza os dados de uma editora existente.
- `DELETE /editoras/{id}`: Remove uma editora.

### Multas

- `GET /multas`: Lista todas as multas.
- `GET /multas/{id}`: Obtém detalhes de uma multa por ID.
- `POST /multas`: Adiciona uma nova multa.
- `PUT /multas/{id}`: Atualiza os dados de uma multa existente.
- `DELETE /multas/{id}`: Remove uma multa.

### Avaliações

- `GET /avaliacoes`: Lista todas as avaliações.
- `GET /avaliacoes/{id}`: Obtém detalhes de uma avaliação por ID.
- `POST /avaliacoes`: Adiciona uma nova avaliação.
- `PUT /avaliacoes/{id}`: Atualiza os dados de uma avaliação existente.
- `DELETE /avaliacoes/{id}`: Remove uma avaliação.

### Reservas

- `GET /reservas`: Lista todas as reservas.
- `GET /reservas/{id}`: Obtém detalhes de uma reserva por ID.
- `POST /reservas`: Registra uma nova reserva.
- `PUT /reservas/{id}`: Atualiza os dados de uma reserva existente.
- `DELETE /reservas/{id}`: Remove uma reserva.
