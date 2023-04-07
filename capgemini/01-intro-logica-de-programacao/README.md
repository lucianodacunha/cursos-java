# Introdução à Lógica de Programação

## Breve histórico 

- Ábaco
- Calculadora, Blaise Pascal
- Calculadora de bolso, Leibneiz
- Máquina Programável, Joseph Marrie
- Lógica Booleana Matemática, George Boole
- Computador Analógico, Charles Babbage

## Evolução dos computadores

- Primeira Geração: circuitos, válvulas, grandes
- Segunda Geração: transistores e início de comercialização
- Terceira Geração: circuitos integrados, chips
- Quarta Geração: microprocessadores, smartphones, etc

## Lógica no mundo

- Lógica é conhecida desde os tempos dos antigos filósofos gregos
  
> A lógica consiste na construção racional e coerente do raciocínio.

## Hardware 

> Placa-mãe, memória primária, memória secundária, processador e periféricos

- Arquitetura geral entre a maioria dos computadores
- Entrada + Processamento + Saída

## Softwares / Linguagens

- Software de Sistemas: Conjunto de instruções para operar o hardware
- Drivers: Controlam dispositivos específicos
- Aplicativos: fazem interface entre o usuário e o computador.

## Linguagens de Programação

- É através de linguagens de programação que programadores operam computadores.
- Essas linguagens possuem características que as fazem úteis em contextos específicos
- Podem ser compiladas ou interpretadas
- Compiladas: Tradução é realizada uma vez, gerando o código de máquina que será executado pela máquina.
- Interpretadas: Toda execução exige uma interpretação para a linguagem de máquina.
- Assembly: linguagem de baixo nível utilizada pelo computador
- Assembler: programa que lê o Assembly
- Linguagem de Máquina: a saída gerada pelo Assembler para execução da máquina.

> Utilizamos periféricos para interagir com o computador. A conexão entre o periférico e o sistema é feita através de drivers, que auxiliam na comunicação.
> Os softwares respondem com a saída de dados. 
> Ao fechar um software a memórica RAM é liberada.

## Lógica na Solução de Problemas

- Algoritmo: Sequência de ações.
- Lógica formal: baseada em proposições, ajuda a desenvolver pensamentos e identificar raciocínios válidos e não válidos.
- Proposições: Frase declarativa que recebe um valor lógico.


## Princípios da Lógica Formal

> Definição de Algoritmo: 
> - Sequência de ações
> - obedecem a uma lógica 
> - estado inicial
> - período de tempo finito
> - resultados esperados e bem definidos 

- Princípios: 
  - Identitidade, 
  - Não contradição e 
  - Terceiro excluído.

## Álgebra Booleana

- É uma ciência que a partir da lógica formal, define algumas leis:
  - meio excluído: V ou F, não existe meio
  - contradição: V ou F, não exite os dois
  - funcionalidade: quando composta, o resultado final será a composição de cada uma de suas proposições.

## Operadores

- Tabela Verdade: representa proposições e suas combinações
- Operadores:
  - negação: ~, ~ V = F
  - disjunção: OU, V OU F = V   
  - conjunção: E, V E F = F

> A ideia da algebra booleana é transformar símbolos em matemática expressando proposições que irão operar o computador.

## Algoritmo

> Regras lógicas, bem definidas, que solucionem um problema por completo.

- Características: efetivo + bem definido + finito + completo

**IMPORTANTE**

> - Ordem, início e fim: completo, detalhado.
> - Cada etapa é chamada de instrução.


## Resolução de Problemas

**Etapas recomendadas na solução de um problema**

- Problema: entender o problema
- Solução: descrever os passos para a solução
- Codificação: codificar em uma linguagem de programação
- Solução: programa de computador

> DICA: Antes de codificar o problema, tenha um algoritmo bem definido.

## Formas de Representar o Algoritmo

- Fluxograma
- Pseudocódigo
- Regras: **Objetivade**
  - Somente um verbo 
  - De forma imperativa
  - Objetiva

## Construindo um Algoritmo

Para construir um algoritmo, é importante dividir um problema em 3 partes, por exemplo:

- Problema: Conversão de Reais (R$) em Dólares (U$)

  - Entrada: 
    - Qtde de R$
    - Cotação do U$
  - Processamento:
    - Dividir a qtde de R$ pelo valor da cotação do U$
  - Saída:
    - Exibir o resultado


## Exercícios

- Faça um algoritmo que receba dois números e ao final mostre o resultado da soma dos dois números lidos;

```
INICIO

    LEIA primeiroNumero
    LEIA segundoNumero

    soma = primeiroNumero + segundoNumero

    ESCREVER soma

FIM
```


- Faça um algoritmo para informar à Joãozinho se ele foi aprovado na matéria de Lógica para programação. Joãozinho fez 3 provas e a média necessária para ser aprovado é de 7;

```
INICIO

    LEIA nota1
    LEIA nota2
    LEIA nota3

    media = (nota1 + nota2 + nota3) / 3

    SE media >= 7
        ESCREVA "Aprovado"
    SENAO
        ESCREVA "Reprovado
    FIM SE

FIM
```


- Faça um algoritmo para preparar um macarrão instantâneo. Parta do principio que você está na cozinha e deve prepará-lo e servi-lo.

```
INICIO 

    Ferva 500 ml de água em uma panela
    Adicione o macarrão
    Adicione o tempero
    Mexa a mistura
    Sirva o macarrão

FIM
```


- Escreva um algoritmo para determinar o consumo médio de um automóvel sendo fornecida a distância total percorrida pelo automóvel e o total de combustível gasto;

```
INICIO

    LEIA distanciaTotalPercorrida
    LEIA combustivelGasto

    consumoMedio = distanciaTotalPercorrida / combustivelGasto

    ESCREVA consumoMedio

FIM

```

- Faça um algoritmo para realizar a tarefa de tomar banho;

```
INICIO

Entre no banheiro
Defina a temperatura do chuveiro
Abra o registro de água
Tire a roupa completamente
Molhe todo o corpo embaixo dágua
Ensaboe todo o corpo
Esfregue com a esponja todo o corpo
Retire todo o sabão com água
Feche o registro de água
Seque todo o corpo
Coloque toda a roupa novamente
Saia do banheiro

FIM
```