algoritmo "Vetores"

var
    nomes: vetor[1..3] de literal
    i: inteiro
inicio

    para i de 1 ate 3 faca
        escreval("Digite um nome: ")
        leia(nomes[i])
    fimpara
    
    limpatela
    
    escreval("Nomes informados: ")

    para i de 1 ate 3 faca
        escreval("Nome ", i, ":", nomes[i])
    fimpara

fimalgoritmo
