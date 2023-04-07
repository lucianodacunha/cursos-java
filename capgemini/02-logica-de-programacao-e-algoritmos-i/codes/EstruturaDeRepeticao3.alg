algoritmo "EstruturasDeRepeticao3"
var
    senhaGravada, senhaDigitada: literal
inicio
    senhaGravada <- "senha"
    
    repita
        escreva("Digite sua senha: ")
        leia(senhaDigitada)
        se (senhaGravada = senhaDigitada) entao
            limpaTela
            escreval("Bem vindo!")
        senao
            escreval("Senha incorreta")
        fimse
    ate senhaGravada = senhaDigitada
fimalgoritmo
