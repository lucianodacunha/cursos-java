algoritmo "EstruturasDeCondicao2"
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
        escreval("Voc� foi APROVADO. Sua m�dia � ", media)
    senao
        se media >= 5 entao
            escreval("Voc� est� de RECUPERA��O. Sua m�dia � ", media)
        senao
            escreval("Voc� foi REPROVADO. Sua m�dia � ", media)
        fimse
    fimse

fimalgoritmo
