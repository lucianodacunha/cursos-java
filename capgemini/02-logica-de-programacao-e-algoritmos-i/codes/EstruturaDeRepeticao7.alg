algoritmo "EstruturaDeRepeticao7"
var
    numeroSecreto, palpite, i: inteiro
inicio
    aleatorio 1, 10
        leia(numeroSecreto)
    aleatorio off
    
    para i de 1 ate 3 faca
        escreva("Entre com o seu palpite (", i, " de 3 ): ")
        leia(palpite)

        se (palpite = numeroSecreto) entao
            escreval("Parabéns, vc acertou!")
            escreval("Número Secreto:", numeroSecreto, ", Seu Palpite", palpite)
            interrompa
        senao
            escreval("Tente novamente, vc errou!")
        fimse
    fimpara

fimalgoritmo
