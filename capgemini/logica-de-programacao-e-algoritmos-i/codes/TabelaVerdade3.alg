algoritmo "TabelaVerdade3"
var
    peso, altura, imc: real

inicio
    escreva("Entre o valor do peso: ")
    leia(peso)

    escreva("Entre o valor da altura: ")
    leia(altura)

    imc <- peso / altura ^ 2

    se imc < 19 entao
        escreva("Abaixo do peso")
    senao
        se imc < 33 entao
            escreva("Peso ideal")
        senao
            escreva("Acima do peso")
        fimse
    fimse

fimalgoritmo
