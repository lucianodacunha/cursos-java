algoritmo "TabelaVerdade2"
var
    lado1, lado2, lado3: real

inicio
    escreval("Entre o valor do lado1: ")
    leia(lado1)

    escreval("Entre o valor do lado2: ")
    leia(lado2)

    escreval("Entre o valor do lado3: ")
    leia(lado3)

    se (lado1 > (lado2 + lado3)) ou (lado2 > (lado1 + lado3)) ou (lado3 > (lado1 + lado2)) entao
        escreval("Não é um triangulo")
    senao
        se (lado1 = lado2) e (lado2 = lado3) entao
            escreval("Equilatero")
        senao
            se (lado1 = lado2) ou (lado2 = lado3) ou (lado3 = lado1) entao
                escreval("Isosceles")
            senao
                escreval("Escaleno")
            fimse
        fimse
    fimse


fimalgoritmo
