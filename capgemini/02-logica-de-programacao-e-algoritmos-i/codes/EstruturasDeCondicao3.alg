algoritmo "EstruturasCondicionais3"
var
    normal, leve, media, grave, gravissima, tolerancia, velocidade: real
inicio
    normal <- 50
    media <- 70
    grave <- 90
    gravissima <- 110
    tolerancia <- 1.1

    escreval("Informe a velocidade que veículo passou: ")
    leia(velocidade)
    
    se velocidade <= (normal * tolerancia) entao
        escreval("Isento")
    senao
        se velocidade <= (media * tolerancia) entao
            escreval("3 pontos na carteira")
        senao
            se velocidade <= (grave * tolerancia) entao
                escreval("4 pontos na carteira")
            senao
                se velocidade <= (gravissima * tolerancia) entao
                    escreval("5 pontos na carteira")
                senao
                    escreval("7 pontos na carteira")
                fimse
            fimse
        fimse
    fimse
fimalgoritmo
