algoritmo "Vetores 4: Ordena de forma crescente os valores de um vetor utilizando o algoritmo bolha"

var
    vetor1: vetor[1..3] de inteiro
    i, j, l, aux, tamanhoDoVetor: inteiro
inicio

    tamanhoDoVetor <- 3

    //aleatorio 1, 100
    //    para i de 1 ate tamanhoDoVetor faca
    //        leia(vetor1[i])
    //    fimpara
    //aleatorio off
    vetor1[1] <- 58
    vetor1[2] <- 66
    vetor1[3] <- 54
    
    limpaTela
    
    escreva("Vetor gerado: ")
    para i de 1 ate tamanhoDoVetor faca
        escreva(vetor1[i])
    fimpara

    para i de 1 ate tamanhoDoVetor faca
        para j de 1 ate tamanhoDoVetor faca
            se vetor1[j] > vetor1[i] entao
                aux <- vetor1[i]
                vetor1[i] <- vetor1[j]
                vetor1[j] <- aux
            fimse
            escreval()
            escreva("Se o", j, " era > que o",i," entao :")
            para l de 1 ate tamanhoDoVetor faca
                escreva(vetor1[l])
            fimpara
        fimpara
    fimpara
    
    escreval("")
    escreva("Vetor ordenado: ")
    para i de 1 ate tamanhoDoVetor faca
        escreva(vetor1[i])
    fimpara
    
    escreval("")

fimalgoritmo
