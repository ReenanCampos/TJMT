

-- Crie o banco de dados manualmente ou use o comando abaixo no terminal psql:
-- CREATE DATABASE sistema_cursos;
-- E conecte usando: \c sistema_cursos;

CREATE TYPE status_matricula AS ENUM ('ativa', 'cancelada', 'pendente');

CREATE TABLE aluno (
	id SERIAL PRIMARY KEY,
	nome VARCHAR(100) NOT NULL,
	email VARCHAR(100) UNIQUE NOT NULL
);


CREATE TABLE curso (
	id SERIAL PRIMARY KEY,
	nome VARCHAR(100) NOT NULL,
	descricao TEXT
);


CREATE TABLE matricula (
	id SERIAL PRIMARY KEY,
	aluno_id INT NOT NULL REFERENCES aluno(id),
	curso_id INT NOT NULL REFERENCES curso(id),
	data_matricula DATE NOT NULL,
	status status_matricula NOT NULL DEFAULT 'ativa',
	CONSTRAINT unica_matricula UNIQUE (aluno_id, curso_id)
);

