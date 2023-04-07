algoritmo "EstruturasDeCondicao"
var
    nota1, nota2, nota3, media: real
inicio
    escreval("Entre com a nota1: ")
    leia(nota1)
    escreval("Entre com a nota2: ")
    leia(nota2)
    escreval("Entre com a nota3: ")
    leia(nota3)
    
    media <- (nota1 + nota2 + nota3) / 3
    
    se media >= 7 entao
        escreval("Você foi APROVADO. Sua média é ", media)
    senao
        escreval("Você foi REPROVADO. Sua média é ", media)
    fimse

fimalgoritmo
