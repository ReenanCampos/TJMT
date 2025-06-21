
# Teste 1
# 🛠️ Análise e Refatoração de Código Java

Este repositório contém a refatoração de um código responsável por realizar o cadastro de clientes. O objetivo foi melhorar a organização, a legibilidade e aplicar boas práticas de desenvolvimento orientado a objetos.


## 🚨 Código refatorado

 - Abrir o projeto na pasta [Solucao](Solucao) em uma IDE (este foi criado em IntelliJ, sem maven, projeto java puro)
 - Executar a classe [app.Main](Solucao\src\app\Main.java)

## 📄 Descrição do Problema

O código original possuía um método chamado `salvarCliente`, responsável por receber os dados de um cliente (**nome, CPF, telefone e e-mail**) e realizar validações simples antes de simular o salvamento.

### 🔍 Pontos identificados no código original:

- O método possuía **muitos parâmetros**, dificultando a leitura e manutenção.
- As **validações estavam acopladas diretamente no método**, contrariando boas práticas.
- As **regras de validação eram básicas e pouco estruturadas**.
- Faltava uma **classe que representasse o Cliente**, comprometendo os princípios da orientação a objetos.

## 🚀 Soluções Aplicadas

### 1. ✔️ Criação da Classe `Cliente`:
- Responsável por encapsular os dados do cliente.
- Melhora a organização do código e segue os princípios da **Programação Orientada a Objetos (POO)**.

### 2. ✔️ Organização da Service:
- O método `salvarCliente` passou a receber um **objeto Cliente** como parâmetro, tornando o código mais limpo e de fácil manutenção.
- A responsabilidade pela **validação dos dados foi separada** do método de salvamento.

### 3. ✔️ Melhoria nas Regras de Validação:
- Validação de **nome e CPF não nulos ou vazios**.
- Validação para CPF com **11 dígitos numéricos**.
- Validação adicional de **e-mail e telefone**, garantindo consistência dos dados.

## 🏁 Considerações Finais

A refatoração mantém a lógica principal do código, mas traz melhorias significativas em sua estrutura, organização e qualidade. 

O resultado segue boas práticas como:
- ✅ Programação Orientada a Objetos (POO);
- ✅ Separação de responsabilidades;
- ✅ Código mais limpo, escalável e de fácil manutenção.

Estas mudanças tornam o código mais robusto, aderente a padrões acadêmicos e profissionais, facilitando sua evolução e entendimento por outros desenvolvedores.

---
