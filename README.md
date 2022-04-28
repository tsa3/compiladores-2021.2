# compiladores-2021.2
Disciplina de Teoria e Implementação de Linguagens Computacionais do Centro de Informática - UFPE

## Task 01 [RPNStacker Adhoc]
- Rever a Aula 07 sobre notacao pós-fixa [_reverse polish notation_]
- Implementar uma linguagem RPN stacker em Java usando uma pilha como estrutura de dados
- Programa lê um arquivo com a expressao em RPN e avalia


Exemplo de entrada:
```
10
10
+
Saida: 20
``` 

## Task 02 [RPNStacker Manual/Simple Scanning]
- Rever a Aula 11 sobre introdução à análise léxica [_scanning_]
- Evoluir o projeto da Task 01 para implementar uma _feature_ de _scanning_:
   - No geral, nosso programa lê um arquivo com a expressao em RPN e devolve a expressão avaliada;
   - A _feature_ de _scanning_ deve retornar uma lista de _tokens_;
   - A partir dessa lista de _tokens_ que é realizada a interpretacao das expressões com uma pilha;
   - A _feature_ de _scanning_ deve retornar um erro caso não reconheça um "num" [número] ou "op" [operador].

Exemplo de entrada [com sucesso]:
``` 
10
10
+
// a lista de tokens reconhecida [caso a imprima]
Token [type=NUM, lexeme=10]
Token [type=NUM, lexeme=10]
Token [type=PLUS, lexeme=+]
Saida: 20
``` 

Exemplo de entrada [com falha]:
``` 
10
s
+
Error: Unexpected character: s
``` 
