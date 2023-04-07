algoritmo "Vetores 3: Cria um segundo vetor a partir da multiplicação do primeiro vetor"

var
    vetor1, vetor2: vetor[1..5] de inteiro
    i: inteiro
inicio

    aleatorio 1, 100

        para i de 1 ate 5 faca
            leia(vetor1[i])
        fimpara
    aleatorio off
    
    limpaTela
    escreval("Gerando vetor...")
    
    escreval("Multiplicando vetor...")
    para i de 1 ate 5 faca
        vetor2[i] <- vetor1[i] * 3
    fimpara

    escreva("Imprimindo vetor: ")
    para i de 1 ate 5 faca
        escreva(vetor2[i])
    fimpara

    
    escreval("")
fimalgoritmo
