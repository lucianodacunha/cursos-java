algoritmo "EstrutaDeRepeticao"
var
    alturaPessoa1, alturaPessoa2, crescimentoPessoa1, crescimentoPessoa2, idade: real
inicio
    alturaPessoa1 <- 1.20
    alturaPessoa2 <- 1.05
    crescimentoPessoa1 <- 0.05
    crescimentoPessoa2 <- 0.07
    idade <- 8
    
    enquanto (alturaPessoa1 >= alturaPessoa2) faca
        alturaPessoa1 <- alturaPessoa1 + crescimentoPessoa1
        alturaPessoa2 <- alturaPessoa2 + crescimentoPessoa2
        idade <- idade + 1
    fimenquanto
    
    escreval("Altura Pessoa1: ", alturaPessoa1)
    escreval("Altura Pessoa2: ", alturaPessoa2)
    escreval("Idade: ", idade)
fimalgoritmo
