algoritmo "Matrizes"

var
    cinema: vetor[1..5, 1..5] de literal
    fila, poltrona, qtdeFilas, qtdePoltronas, i, j: inteiro
    opcao: literal
inicio

    qtdeFilas <- 5
    qtdePoltronas <- 5

    para i de 1 ate qtdeFilas faca
        para j de 1 ate qtdePoltronas faca
            cinema[i, j] <- "O"
        fimpara
    fimpara

    repita
        escreval("Selecione a op��o desejada: ")
        escreval("1 - Comprar um ingresso")
        escreval("2 - Ver mapa de assentos")
        escreval("3 - Sair")
        leia(opcao)
        limpaTela
        
        escolha opcao
            caso "1"
                escreval("Escolha seu assento: ")
                escreva("Entre com o n�mero da fila: ")
                leia(fila)
                escreval()
                escreva("Entre com o n�mero da poltrona: ")
                leia(poltrona)

                se cinema[fila, poltrona] = "O" entao
                    escreval("Compra conclu�da com sucesso")
                    cinema[fila, poltrona] <- "X"
                senao
                    escreval("Poltrona indispon�vel")
                fimse

            caso "2"
                para i de 1 ate qtdeFilas faca
                    para j de 1 ate qtdePoltronas faca
                        escreva(cinema[i, j])
                    fimpara
                    escreval()
                fimpara
                escreval()

            caso "3"
                interrompa

            outrocaso
                escreval("Op��o indispon�vel")


        fimescolha
    ate opcao = "3"


fimalgoritmo
