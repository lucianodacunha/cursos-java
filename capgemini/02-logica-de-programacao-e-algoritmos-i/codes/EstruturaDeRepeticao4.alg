algoritmo "EstruturaDeRepeticao4"
var
    opcao: literal
inicio

    opcao <- "0"
    
    repita
        escreval("1 - Computador")
        escreval("2 - Smartphone")
        escreval("3 - Sair")
        
        escreva("Entre com a opção desejada: ")
        leia(opcao)
        limpaTela
    ate opcao = "3"
    
    escreval("Fim do Programa")
fimalgoritmo
