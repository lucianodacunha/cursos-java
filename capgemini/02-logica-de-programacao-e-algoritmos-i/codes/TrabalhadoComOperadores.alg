algoritmo "TrabalhandoComOperadores"
var
    x, y: inteiro
    z: real
    w: logico
inicio
    Escreval("Entre com um n�mero inteiro: ")
    leia(x)
    Escreval("Entre com um n�mero inteiro: ")
    leia(y)
    Escreval("")
    Escreval("Verifique o resultado das opera��es: ")

    z <- x + y
    Escreval("Soma de a + b: ",z)
    
    z <- x - y
    Escreval("Subtra��o de a - b: ",z)
    
    z <- x / y
    Escreval("Divis�o de a / b: ",z)

    z <- x * y
    Escreval("Multiplica��o de a * b: ",z)

    z <- x MOD y
    Escreval("M�dulo de a MOD b: ",z)

    z <- x DIV y
    Escreval("Divis�o inteira de a DIV b: ",z)

    w <- x < y
    Escreval("Compara��o entre a < b: ",w)
fimalgoritmo
