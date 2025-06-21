
# Teste 4
# 🧠 Criatividade na Solução de Problemas (MVP)

## 🏗️ (4.1) Possível solução usando Java e PostgreSQL.

A solução consiste no desenvolvimento de uma aplicação em Java, que permite o controle de entrada e saída de visitantes em uma organização. O sistema realiza o cadastro do visitante com informações como nome, motivo da visita, horário de entrada e horário de saída, além de controlar o status de aprovação da entrada, que é feita por um segurança.

Os dados são armazenados em um banco de dados PostgreSQL, que garante a persistência e integridade das informações. A aplicação em Java se conecta ao banco através de JDBC, realizando as operações de cadastro, atualização e consulta dos visitantes.

O sistema funciona de forma simples e prática, permitindo:

- Registrar a entrada de um visitante.

- Aprovar ou rejeitar a entrada.

- Registrar a saída ao finalizar a visita.

- Consultar quais visitantes estão presentes no momento.

A proposta tem como foco uma **solução mínima viável (MVP)**, funcional, utilizando tecnologias robustas, amplamente conhecidas e de fácil manutenção.

---

## 💬(4.2) Fluxo básico com BPMN
Arquivos:
 - BPMN - [fluxo.bpmn](fluxo.bpmn)
 - PNG - [fluxo.png](fluxo.png)

---

## 🚨(4.4) Implementação da solução como bônus

 - Abrir o projeto na pasta [Solução](Solucao) em uma IDE (este foi criado em IntelliJ)
 - Criar database e tabela com o [schema.sql](Solucao\controle-visitantes-java\database\schema.sql)
 - Executar a classe [Main](Solucao\controle-visitantes-java\src\main\java\com\projeto\app\Main.java)

 
---

## 💭(4.3) Proposta de estrutura de classes ou pseudo-código.

Esta proposta apresenta a estrutura de classes para a solução do problema de Controle de Entrada e Saída de Visitantes, utilizando Java e PostgreSQL.

---

### Estrutura de Classes

#### 🔹 Classe `Visitante`
**Descrição:** Representa o visitante no sistema.

- **Atributos:**
  - `id`: int
  - `nome`: String
  - `motivo`: String
  - `horarioEntrada`: LocalDateTime
  - `horarioSaida`: LocalDateTime
  - `aprovado`: boolean

- **Métodos:**
  - Getters e Setters
  - Construtor com parâmetros (`nome`, `motivo`)
  - Construtor vazio

---

#### 🔹 Classe `Conexao`
**Descrição:** Responsável por gerenciar a conexão com o banco de dados PostgreSQL.

- **Métodos:**
  - `conectar()`: Connection  
  → Retorna uma conexão ativa com o banco de dados.

---

#### 🔹 Classe `VisitanteRepository`
**Descrição:** Responsável pelo acesso e manipulação dos dados no banco.

- **Métodos:**
  - `salvar(Visitante v)`: int  
  → Insere um visitante e retorna o ID gerado.
  
  - `buscarPorId(int id)`: Visitante  
  → Retorna um visitante com base no ID.

  - `aprovarEntrada(int id)`: void  
  → Atualiza o status do visitante para aprovado.

  - `registrarSaida(int id, LocalDateTime horario)`: void  
  → Registra o horário de saída do visitante.

  - `listarPresentes()`: List<Visitante>  
  → Retorna a lista de visitantes que estão presentes (entrada aprovada e sem saída registrada).

---

#### 🔹 Classe `VisitanteService`
**Descrição:** Contém a lógica de negócio e as regras do processo.

- **Métodos:**
  - `registrarEntrada(Visitante v)`: int  
  → Salva uma nova solicitação de entrada no sistema.

  - `aprovarEntrada(int id)`: void  
  → Aprova a entrada do visitante, validando se ele existe e se ainda não está aprovado.

  - `registrarSaida(int id)`: void  
  → Registra a saída do visitante, desde que ele exista, tenha entrada aprovada e não tenha uma saída já registrada.

  - `listarVisitantesPresentes()`: List<Visitante>  
  → Lista os visitantes que estão presentes no local.

---

#### 🔹 Classe `Main`
**Descrição:** Ponto de entrada da aplicação, com interface de interação via terminal/console.

- Exibe o menu com as opções:
  - Registrar entrada
  - Aprovar entrada
  - Registrar saída
  - Listar visitantes presentes
  - Sair
- Gerencia as entradas do usuário e faz chamadas para os métodos do `VisitanteService`.


