algoritmo "EstrutaDeRepeticao2"
var
    i, limite: inteiro
inicio
    i <- 1
    
    escreva("Entre com o valor limite (1 - 100): ")
    leia(limite)
    
    escreval("")

    enquanto (i <= 100) faca
        escreva(i)
        se(i = limite) entao
            interrompa
        fimse
        se (i MOD 10 = 0) entao
            escreval("")
        fimse
        i <- i + 1
    fimenquanto
    
fimalgoritmo
