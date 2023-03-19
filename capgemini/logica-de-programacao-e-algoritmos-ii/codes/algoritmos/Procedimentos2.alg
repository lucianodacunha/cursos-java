algoritmo "Procedimentos2: CRUD"

var
    clientes: vetor[1..3] de literal
    indiceCadastro, qtdeMaximaDeClientes: inteiro

    procedimento menu()
        var
            opcao: literal
    
        inicio
            repita
                escreval("Entre com a opção desejada: ")
                escreval("1 - Cadastrar")
                escreval("2 - Atualizar")
                escreval("3 - Procurar")
                escreval("4 - Excluir")
                escreval("5 - Listar")
                escreval("6 - Sair")
                leia(opcao)
                
                escolha opcao
                    caso "1"
                        cadastrar()
                    caso "2"
                        atualizar()
                    caso "3"
                        procurar()
                    caso "4"
                        excluir()
                    caso "5"
                        listar()
                    caso "6"
                        interrompa
                    outrocaso
                        escreval("Opção inválida")
                fimescolha
            ate opcao = "6"
        fimprocedimento

    procedimento cadastrar()
        var
            i: inteiro
        inicio
            se (indiceCadastro <= qtdeMaximaDeClientes) entao
                escreva("Entre com o nome do cliente: ")
                leia(clientes[indiceCadastro])
                indiceCadastro <- indiceCadastro + 1
                escreval("Cliente cadastrado com sucesso!")
            senao
                escreval("Limite máximo de clientes cadastrados atingido!")
            fimse
        fimprocedimento
        
    procedimento atualizar()
        var
            i, codigoCliente: inteiro
            nomeAtualizado: literal
        inicio
            listar()
            escreval("Informe a código do cliente: ")
            leia(codigoCliente)
            escreval("Informe o nome atualizado do cliente: ")
            leia(nomeAtualizado)

            para i de 1 ate 3 faca
                se (codigoCliente = i) entao
                    clientes[i] <- nomeAtualizado
                fimse
            fimpara

        fimprocedimento

    procedimento procurar()
        var
            nomeProcurado: literal
            i: inteiro
            encontrado: logico
        inicio
            escreva("Informe o nome procurado: ")
            leia(nomeProcurado)
            escreval()
            para i de 1 ate 3 faca
                se (clientes[i] <> "") entao
                    se (clientes[i] = nomeProcurado) entao
                        encontrado <- verdadeiro
                    senao
                        encontrado <- falso
                    fimse
                fimse
            fimpara
            
            se encontrado entao
                escreval("Cliente encontrado")
            senao
                escreval("Cliente não encontrado")
            fimse
        fimprocedimento

    procedimento listar()
        var
            i: inteiro
        inicio
            escreval("Listando clientes cadastrados: ")
            para i de 1 ate 3 faca
                se (clientes[i] <> "") entao
                    escreval("Código:", i," -", clientes[i])
                fimse
            fimpara
        fimprocedimento

    procedimento excluir()
        var
            i, codigoCliente: inteiro
        inicio
            listar()
            escreval("Informe a código do cliente: ")
            leia(codigoCliente)
            
            para i de 1 ate 3 faca
                se (codigoCliente = i) entao
                    clientes[i] <- ""
                fimse
            fimpara
        
        fimprocedimento


inicio
    indiceCadastro <- 1
    qtdeMaximaDeClientes <- 3
    menu()

fimalgoritmo
