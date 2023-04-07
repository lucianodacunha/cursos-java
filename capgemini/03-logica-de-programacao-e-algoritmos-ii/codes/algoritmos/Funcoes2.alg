algoritmo "Funções 2"
var
    peso, altura, imc: real

    procedimento entradaDeDados()
        inicio
            escreva("Entre o valor do peso: ")
            leia(peso)

            escreva("Entre o valor da altura: ")
            leia(altura)

        fimprocedimento

    funcao calculaIMC(): literal
        var
            imc: real
        inicio
            imc <- peso / altura ^ 2

            se imc < 19 entao
                retorne "Abaixo do peso"
            senao
                se imc < 33 entao
                    retorne "Peso ideal"
                senao
                    retorne "Acima do peso"
                fimse
            fimse

        fimfuncao

inicio
    entradaDeDados()
    escreval(calculaIMC())
fimalgoritmo
