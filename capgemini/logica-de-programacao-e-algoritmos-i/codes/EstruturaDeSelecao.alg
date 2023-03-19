algoritmo "EstruturaDeSelecao"
var
    voto: literal
inicio
    escreva("Digite seu voto: ")
    leia(voto)
    
    escolha voto
        caso "20"
            escreval("Você votou no João")
        caso "33"
            escreva("Você votou no José")
        caso "60"
            escreva("Você votou no Antônio")
        outrocaso
            escreva("Você votou nulo")
    fimescolha
fimalgoritmo
