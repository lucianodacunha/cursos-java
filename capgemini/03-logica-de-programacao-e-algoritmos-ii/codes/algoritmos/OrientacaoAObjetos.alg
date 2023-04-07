algoritmo "Orientação a Objetos"

tipo
    pessoa = registro
        nome: caractere
        idade: inteiro
        email: caractere
    fimregistro
var
    aluno: vetor[1..3] de pessoa
    opcao, nomeParaPesquisar: caractere
    i: inteiro
    semInformacoes, encontrado: logico
inicio

    repita
        escreval("1 - Cadastrar")
        escreval("2 - Pesquisar")
        escreval("3 - Sair")
        leia(opcao)

        se opcao = "1" entao
            para i de 1 ate 3 faca
                se aluno[i].nome = "" entao
                    escreval("Entre com o nome do aluno: ")
                    leia(aluno[i].nome)

                    escreval("Entre com a idade do aluno: ")
                    leia(aluno[i].idade)

                    escreval("Entre com o email do aluno: ")
                    leia(aluno[i].email)
                    interrompa
                fimse
            fimpara
        senao
            se opcao = "2" entao
                escreval("Digite o nome para pesquisar: ")
                leia(nomeParaPesquisar)
                para i de 1 ate 3 faca
                    se (pessoa[i].nome <> "") e (pessoa[i].nome = nomeParaPesquisar) entao
                        encontrado <- verdadeiro
                    fimse
                    interrompa
                fimpara
                se encontrado entao
                    escreval("Nome: ", aluno[i].nome)
                    escreval("Idade:", aluno[i].idade)
                    escreval("Email:", aluno[i].email)
                senao
                    escreval("Registro nao encontrado")
                fimse
            senao
                interrompa
            fimse
        fimse
    ate opcao = 3

    semInformacoes <- verdadeiro

    escreval("Dados dos alunos:")
    para i de 1 ate 3 faca
        se aluno[i].nome <> "" entao
            escreval("Nome: ", aluno[i].nome)
            escreval("Idade:", aluno[i].idade)
            escreval("Email:", aluno[i].email)
            semInformacoes <- falso
        fimse
    fimpara
    
    se semInformacoes entao
        escreval("Sem dados cadastrados")
    fimse
fimalgoritmo