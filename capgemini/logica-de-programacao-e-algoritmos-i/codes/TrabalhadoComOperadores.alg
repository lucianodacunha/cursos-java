algoritmo "TrabalhandoComOperadores"
var
    x, y: inteiro
    z: real
    w: logico
inicio
    Escreval("Entre com um número inteiro: ")
    leia(x)
    Escreval("Entre com um número inteiro: ")
    leia(y)
    Escreval("")
    Escreval("Verifique o resultado das operações: ")

    z <- x + y
    Escreval("Soma de a + b: ",z)
    
    z <- x - y
    Escreval("Subtração de a - b: ",z)
    
    z <- x / y
    Escreval("Divisão de a / b: ",z)

    z <- x * y
    Escreval("Multiplicação de a * b: ",z)

    z <- x MOD y
    Escreval("Módulo de a MOD b: ",z)

    z <- x DIV y
    Escreval("Divisão inteira de a DIV b: ",z)

    w <- x < y
    Escreval("Comparação entre a < b: ",w)
fimalgoritmo
