algoritmo "EstruturaDeSelecao"
var
    voto: literal
inicio
    escreva("Digite seu voto: ")
    leia(voto)
    
    escolha voto
        caso "20"
            escreval("Voc� votou no Jo�o")
        caso "33"
            escreva("Voc� votou no Jos�")
        caso "60"
            escreva("Voc� votou no Ant�nio")
        outrocaso
            escreva("Voc� votou nulo")
    fimescolha
fimalgoritmo
