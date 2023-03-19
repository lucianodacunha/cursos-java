algoritmo "TabelaVerdade"
var
    valor1, valor2: inteiro

inicio
    escreval("Entre com o valor1 inteiro: ")
    leia(valor1)
    
    escreval("Entre com o valor2 inteiro: ")
    leia(valor2)

    se ((valor1 MOD 2) = 0) e ((valor2 MOD 2) = 0) entao
        escreval("Os dois valores são pares")
    senao
        se ((valor1 MOD 2) = 0) ou ((valor2 MOD 2) = 0) entao
            escreval("Pelo menos um valor é par")
        senao
            escreval("Todos os valores são impares")
        fimse
    fimse

fimalgoritmo
