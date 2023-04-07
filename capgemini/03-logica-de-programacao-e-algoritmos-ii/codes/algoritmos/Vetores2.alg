algoritmo "Vetores2"

var
    clientesCadastrados: vetor[1..3] de literal
    clientePesquisado: literal
    encontrado: logico
    i: inteiro
inicio

    encontrado <- falso

    clientesCadastrados[1] <- "João"
    clientesCadastrados[2] <- "José"
    clientesCadastrados[3] <- "Maria"
    
    escreval("Informe o nome procurado: ")
    leia(clientePesquisado)
    
    para i de 1 ate 3 faca
        se clientePesquisado = clientesCadastrados[i] entao
            encontrado <- verdadeiro
            interrompa
        fimse
    fimpara
    
    se encontrado entao
        escreval("Cliente encontrado")
    senao
        escreval("Cliente não encontrado")
    fimse

fimalgoritmo
