

INSERT INTO aluno (nome, email) VALUES 
('Ana Silva', 'ana@example.com'),
('Bruno Costa', 'bruno@example.com'),
('Carla Souza', 'carla@example.com'),
('Diego Lima', 'diego@example.com'),
('Eduarda Martins', 'eduarda@example.com');

INSERT INTO curso (nome, descricao) VALUES 
('Banco de Dados', 'Curso de PostgreSQL'),
('Desenvolvimento Web', 'HTML, CSS, JavaScript'),
('Python Avançado', 'Automação e análise de dados'),
('Machine Learning', 'Introdução ao aprendizado de máquina'),
('Gestão de Projetos', 'Metodologias ágeis e PMBOK'),
('NodeJS Iniciante', 'Introdução ao NodeJS');

INSERT INTO matricula (aluno_id, curso_id, data_matricula, status) VALUES
(1, 1, '2025-01-15', 'ativa'),
(1, 2, '2025-02-10', 'ativa'),
(2, 3, '2025-03-05', 'ativa'),
(2, 1, '2025-03-10', 'ativa'),
(3, 4, '2025-04-12', 'ativa'),
(4, 1, '2025-05-01', 'ativa'),
(5, 2, '2025-06-10', 'ativa');

