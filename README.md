Seja bem-vindo ao Checkpoint 1 de Java Advanced - Turma 2TDSPR.  
Este CP tem por objetivo aferir seus conhecimentos a respeito de todo o conteúdo visto em sala de aula durante o mês de agosto de 2024.  
Este CP é composto por duas sessões: Sessão Teórica (3 pontos) e Sessão Prática (7 pontos).  
***LEIA ATENTAMENTE O ENUNCIADO DE CADA QUESTÃO***  
**Boa prova.**

## Sessão Teórica

1: Atribua o número em A à sua respectiva descrição em B.

| A | Verbo HTTP |
|:-:|------------|
| 1 | DELETE     |
| 2 | POST       |
| 3 | GET        |
| 4 | PUT        |
| 5 | PATCH      |

| B | Descrição                                                            |
|:-:|----------------------------------------------------------------------|
| 2 | Envia dados para criar um novo recurso no servidor.                  |
| 3 | Recupera dados de um recurso específico sem alterar seu estado.      |
| 1 | Remove um recurso específico do servidor.                            |
| 5 | Aplica modificações parciais a um recurso existente.                 |
| 4 | Atualiza completamente um recurso existente com os dados fornecidos. |

2: Em um servidor com validação de contrato implementada, qual status code
o servidor deve retornar quando uma requisição possui um body com dados inválidos?
Preencha a única alternativa correta com um X dentro de []: \
A) 500 - Internal Server Error []  
B) 400 - Bad Request [X]  
C) 404 - Not Found []  
D) 422 - Unprocessable Entity []  
E) 200 - Ok []

3: Qual o status code mais adequado para retornar em uma operação de POST bem-sucedida?
Preencha a única alternativa correta com um X dentro de []: \
A) 200 - Ok []  
B) 202 - Accepted []  
C) 201 - Created [X]  
D) 204 - No Content []  
E) 208 - Already Reported []

4: Preencha a única alternativa correta com um X dentro de []. O Spring é:  
D) Uma mãe e um sistema operacional para dispositivos móveis [] \
A) Uma mãe e uma biblioteca [] \
E) Uma mãe e um editor de texto para documentos acadêmicos [] \
B) Uma mãe e um framework [X] \
F) Uma mãe e uma linguagem de programação desenvolvida pela Oracle [] \

## Sessão Prática

### Controllers

Ajuste a interface ProfessorController criando os métodos solicitados nos comentários \
Implemente um ProfessorControllerImpl de acordo com a Interface ProfessorController constante no CP. \
Utilize o mapeamento de rotas, verbos http e response code mais adequado baseado na operação solicitada; \
Implemente java validation quando solicitado \
Utilize sempre que possível o conceito de DTO e independência de camadas

Uma requisição básica conterá o body:
```
{
  "id": "string",
  "nome": "string,
  "materia": "string
}
```

### Usecases
Implemente um SalvaProfessorImpl de acordo com a interface SalvaProfessor fornecida no CP;\
Disponibilize ele como um `Bean`
Além do método que você utilizou, comente na classe SalvaProfessorImpl outro método para registro de Beans

### Repositories
Crie um Repository para o domínio Professor, esse repository deve também ser um JPARepository

### Domain
Anote o domínio professor com as devidas annotations para que ele possa ser persistido em uma base de dados relacional

### Fase integrada
Ajuste a interface ProfessorControllerIntegrado criando uma assinatura de acordo com o solicitado \
Faça ProfessorControllerImpl também implementar a interface ProfessorControllerIntegrado \
Realize uma injeção de dependencia de SalvaProfessor no controller \
Injete o repository de professor em SalvaProfessor \
Garanta que pelo menos un registro de Professor foi salvo no banco de dados \
Garanta a independência de camadas