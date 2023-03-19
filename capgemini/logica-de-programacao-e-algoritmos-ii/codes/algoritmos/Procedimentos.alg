algoritmo "Procedimentos"

var
    resultado: inteiro

// O procedimento apenas processa e não retorna valores
procedimento soma(a, b: inteiro)
    inicio
        resultado <- a + b
    fimprocedimento
inicio
    soma(3, 3)
    escreval("Valor da soma de 3 + 3:", resultado)
fimalgoritmo
