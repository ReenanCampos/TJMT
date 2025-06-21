

-- Alunos matriculados em mais de um curso
SELECT aluno.id, aluno.nome, COUNT(matricula.curso_id) AS qtd_cursos
FROM matricula
JOIN aluno ON aluno.id = matricula.aluno_id
GROUP BY aluno.id, aluno.nome
HAVING COUNT(matricula.curso_id) > 1;
/* 
Resultado esperado: 
    Ana Silva(id 1)     | 2 cursos
    Bruno Costa(id 2)   | 2 cursos
*/


-- Cursos sem alunos matriculados
SELECT curso.id, curso.nome
FROM curso
LEFT JOIN matricula ON curso.id = matricula.curso_id
WHERE matricula.id IS NULL;
/* 
Resultado esperado:
    Gestão de Projetos (id 5)
    NodeJS Iniciante (id 6)
*/


-- Os 5 cursos com mais alunos
SELECT curso.id, curso.nome, COUNT(matricula.aluno_id) AS total_alunos
FROM curso
LEFT JOIN matricula ON curso.id = matricula.curso_id
GROUP BY curso.id, curso.nome
ORDER BY total_alunos DESC
LIMIT 5;
/* 
Resultado esperado:
    Banco de Dados(id 1)        | 3 alunos
    Desenvolvimento Web(id 2)   | 2 alunos
    Python Avançado(id 3)       | 1 aluno
    Machine Learning(id 4)      | 1 aluno
    Gestão de Projetos(id 5)    | 0 alunos
*/

