package logica;

import java.util.Scanner;
import java.util.Locale;

import com.github.javafaker.Faker;

public class Program {

    private static Scanner sc;

    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        sc = new Scanner(System.in);
        ex20();
        sc.close();
    }      

    /**
    * 1. Faça um algoritmo que receba dois números e exiba o resultado da sua 
    * soma;
    */
    static void ex01(){
        System.out.print("Infome dois número inteiros: ");
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int soma = n1 + n2;

        System.out.printf(
            "Soma dos números informados (%d, %d) é %d\n", n1, n2, soma);
    }

    /**
    * 2. Faça um algoritmo que receba dois números e ao final mostre a soma, 
    * subtração, multiplicação e a divisão dos dois números lidos; 
    */
    static void ex02(){
        System.out.print("Infome dois número inteiros: ");
        double n1 = sc.nextDouble();
        double n2 = sc.nextDouble();
        double soma = n1 + n2;
        double subt = n1 - n2;
        double mult = n1 * n2;
        double divi = n1 / n2;

        System.out.printf(
            "Soma: %.2f\nSubtração: %.2f\nMultiplicação: %.2f\nDivisão: %.2f\n",
            soma, subt, mult, divi
        );
    }

    /**
    * 3. Escreva um algoritmo para determinar o consumo médio de um automóvel 
    * sendo fornecida a distância total percorrida pelo automóvel e o total de 
    * combustível gasto; 
    */
    static void ex03(){
        System.out.print("Entre com a dist. total percorrida (KM): ");
        double distancia = sc.nextDouble();
        System.out.print("Entre com o combustível gasto (L): ");
        double combustivel = sc.nextDouble();

        double consumoMedio = distancia / combustivel;
        System.out.printf("Consumo médio foi de %.2f KM/L\n", consumoMedio);
    }

    /**
    * 4. Escreva um algoritmo que leia o nome de um vendedor, o seu salário 
    * fixo e o total de vendas efetuadas por ele no mês (em dinheiro). Sabendo 
    * que este vendedor ganha 15% de comissão sobre suas vendas efetuadas, 
    * informar o seu nome, o salário fixo e salário no final do mês; 
    */    
    static void ex04(){
        System.out.print("Entre com o nome do vendedor: ");
        String nomeDoVendedor = sc.nextLine();
        System.out.print("Entre com o salário do vendedor: ");
        double salario = sc.nextDouble();
        System.out.print("Entre com as vendas do vendedor: ");
        double totalDeVendas = sc.nextDouble();

        double comissao = totalDeVendas * .15;
        double salarioFinal = salario + comissao;

        System.out.printf(
            "Vendedor %s\nSalário Fixo: %.2f\nSalário Final: %.2f\n",
            nomeDoVendedor, salario, salarioFinal);

    }

    /**
    * 5. Escreva um algoritmo que leia o nome de um aluno e as notas das três 
    * provas que ele obteve no semestre. No final informar o nome do aluno e a 
    * sua média (aritmética); 
    */
    static void ex05(){
        System.out.print("Entre com o nome do aluno: ");
        String nomeDoAluno = sc.nextLine();
        System.out.print("Entre com a nota 1: ");
        double nota1 = sc.nextDouble();
        System.out.print("Entre com a nota 2: ");
        double nota2 = sc.nextDouble();
        System.out.print("Entre com a nota 3: ");
        double nota3 = sc.nextDouble();

        double media = (nota1 + nota2 + nota3) / 3;

        System.out.printf("Nome: %s\nMédia: %.2f\n", nomeDoAluno, media);
    }

    /**
    * 6. Leia dois valores para as variáveis A e B, e efetuar as trocas dos 
    * valores de forma que a variávelApasse a possuir ovalor da variável B e a 
    * variável B passe a possuir o valor da variável A.Apresentar osvalores
    * trocados;
    */
    static void ex06(){
        System.out.print("Entre com o valor de a e b: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int temp = a;
        a = b;
        b = temp;

        System.out.printf("a: %d, b: %d\n", a, b);
    }

    /**
    * 7. Leia uma temperatura em graus Celsius e apresentá-la convertida em 
    * graus Fahrenheit. Afórmula de conversão é:F=(9*C+160) / 5, sendo F a 
    * temperatura em Fahrenheit e C a temperatura emCelsius;
    */
    static void ex07(){
        System.out.print("Entre com temperatura em Celsius: ");
        double celsius = sc.nextDouble();
        double fahrenheit = (9 * celsius + 160) / 5;

        System.out.printf("Temperatura em Fahrenheit: %.2f\n",fahrenheit);
    }

    /**
    * 8. Elabore um algoritmo que efetue a apresentação do valor da conversão 
    * em real (R$) de um valorlido em dólar (US$). O algoritmo deverá solicitar 
    * o valor da cotação do dólar e também aquantidade de dólares disponíveis 
    * com ousuário;
    */
    static void ex08(){
        System.out.print("Entre com o valor da cotação do dólar (R$): ");
        double cotacao = sc.nextDouble();
        System.out.print("Entre com a qtde. de dólares disponíveis (US$): ");
        double quantidadeDeDolares = sc.nextDouble();
        double conversao = quantidadeDeDolares * cotacao;
        System.out.printf("Valor da conversão em R$: %.2f\n", conversao);    
    }

    /**
    * 9. Faça um algoritmo que receba um valor que foi depositado e exiba o 
    * valor com rendimento após um mês.Considere fixo o juro da poupança em 
    * 0,07% a.m; 
    */
    static void ex09(){
        System.out.print("Entre com o valor do deposito: ");
        double valorDeposito = sc.nextDouble();
        double percJuros = 0.07;
        double periodo = 1.0;
        double rendimento = (valorDeposito * percJuros * periodo);
        double montante = valorDeposito + rendimento;

        System.out.printf("Valor com rendimento após 1 mês: %.2f\n", montante);
    }

    /**
    * 10. A Loja Mamão com Açúcar está vendendo seus produtos em5(cinco)
    * prestações sem juros. Faça um algoritmo que receba um valor de uma compra 
    * e mostre o valor das prestações;
    */
    static void ex10(){
        System.out.print("Entre com o valor da compra: ");
        double valorDaCompra = sc.nextDouble();
        double QUANTIDADE_DE_PRESTACOES = 5;

        double valorDasPrestações = valorDaCompra / QUANTIDADE_DE_PRESTACOES;

        System.out.printf("Prestações\n");
        for (int i = 1; i <= 5; i++){
            System.out.printf("%d = %.2f ", i, valorDasPrestações);
        }

        System.out.printf("\n");
    }

    /**
    * 11. Faça um algoritmo que receba o preço de custo de um produto e mostre 
    * o valor de venda. Sabe-se que o preço de custo receberá um acréscimo de 
    * acordo com um percentual informado pelo usuário; 
    */
    static void ex11(){
        System.out.print("Entre com o preço de custo: ");
        double precoDeCusto = sc.nextDouble();
        System.out.print("Entre com percentual de acréscimo: ");
        double percAcrescimo = sc.nextDouble();
        double valorDeVenda = precoDeCusto * (1 + percAcrescimo);

        System.out.printf("Valor de venda: %.2f\n", valorDeVenda);
    }

    /** 
    * 12. O custo de um carro novo ao consumidor é a soma do custo de fábrica 
    * mais o percentual do distribuidor e dos impostos aplicados (primeiro os 
    * impostos são aplicados sobre o custo de fábrica, e depois o percentual
    * do distribuidor sobre o resultado). Supondo que o percentual do 
    * distribuidor seja de 28% e os impostos 45%, escreva um algoritmo que leia 
    * o custo de fábrica de um carro e informe o custo ao consumidor do mesmo
    */
    static void ex12(){
        System.out.print("Entre com o custo de fábrica: ");
        double custoDeFabrica = sc.nextDouble();
        double IMPOSTOS = 0.45;
        double PERCENTUAL_DO_DISTRIBUIDOR = 0.28;

        double custoAoConsumidor = 
            (custoDeFabrica * (1 + IMPOSTOS)) * 
                (1 + PERCENTUAL_DO_DISTRIBUIDOR);

        System.out.printf("Custo ao consumidor: %.2f\n", custoAoConsumidor);
    }

    /**
    * 13. Faça um algoritmo que receba um número e mostre uma mensagem caso 
    * este número seja maior que 10; 
    */
    static void ex13(){
        System.out.print("Entre com um valor: ");
        int valor = sc.nextInt();
        int LIMITE = 10;
        
        if (valor > LIMITE) {
            System.out.println("Valor maior que 10");
        }
    }

    /** 
    * 14. Escreva um algoritmo que leia dois valores inteiro distintos e 
    * informe qual é o maior;
    */
    static void ex14(){
        System.out.print("Informe dois valores distintos: ");
        int valor1 = sc.nextInt();
        int valor2 = sc.nextInt();

        if (valor1 > valor2) {
            System.out.printf("O maior valor é %d\n", valor1);
        } else {
            System.out.printf("O maior valor é %d\n", valor2);
        }
    }

    /** 
    * 15. Faça um algoritmo que receba um número e diga se este número está 
    * no intervalo entre 100 e 200; 
    */
    static void ex15(){
        System.out.print("Informe um valor: "); 
        int valor = sc.nextInt();

        if (valor >= 100 && valor <= 200) {
            System.out.println("O valor digitado ESTÁ entre 100 e 200"); 
        } else {
            System.out.println("O valor digitado NÃO ESTÁ entre 100 e 200");
        }
    }

    /**
    * 16. Escreva um algoritmo que leia o nome e as três notas obtidas por um
    * aluno durante o semestre. Calcular a sua média (aritmética), informar o 
    * nome e sua menção aprovado (media >= 7), Reprovado (media <= 5) e
    * Recuperação (media entre 5.1 a 6.9);
    */
    static void ex16(){
        System.out.print("Entre com o nome do aluno: "); 
        String nome = sc.nextLine();
        System.out.print("Entre com a nota 1: "); 
        double nota1 = sc.nextDouble();
        System.out.print("Entre com a nota 2: "); 
        double nota2 = sc.nextDouble();
        System.out.print("Entre com a nota 3: "); 
        double nota3 = sc.nextDouble();

        double media = (nota1 + nota2 + nota3) / 3;

        if (media >= 7) {
            System.out.printf(
                "Nota: %.2f - Aluno %s APROVADO\n", media, nome); 
        } else {
            if (media <= 5) {
                System.out.printf(
                    "Nota: %.2f - Aluno %s REPROVADO\n", media, nome);
            } else {
                System.out.printf(
                    "Nota: %.2f - Aluno %s de RECUPERAÇÃO\n", media, nome);
            }
        }
    }

    /** 
    * 17. Leia 80 números e ao final informar quantos número(s) est(á)ão no 
    * intervalo entre 10 (inclusive) e 150 (inclusive);
    */
    static void ex17(){        
        int quantidade = 0;
        int aleatorio = 0;

        for (int i = 0; i < 80; i++){
            aleatorio = (1 + (int) (Math.random() * 1000));
            if (aleatorio >= 10 && aleatorio <= 150) {
                quantidade++;
            }
        }

        System.out.printf(
            "Quantidade de ocorrências entre 10-150: %d\n", quantidade);
    }

    /** 
    * 18. Faça um algoritmo que receba a idade de 75 pessoas e mostre mensagem 
    * informando “maior de idade” e “menor de idade” para cada pessoa. 
    * Considere a idade a partir de 18 anos como maior de idade;
    */
    static void ex18(){
        int quantidadeMaior = 0;
        int quantidadeMenor = 0;
        int aleatorio = 0;        

        for(int i = 0; i < 75; i++){
            aleatorio = (1 + (int) (Math.random() * 75));
            if (aleatorio >= 18){
                quantidadeMaior++;
            } else {
                quantidadeMenor++;
            }
        }

        System.out.printf("Quantidade menor: %d\nQuantidade maior: %d\n",
            quantidadeMenor, quantidadeMaior);

    }
    
    /** 
    * 19. Escreva um algoritmo que leia o nome e o sexo de 56 pessoas e informe 
    * o nome e se ela é homem ou mulher. No final informe total de homens e de 
    * mulheres;
    */ 
    static void ex19(){
        char sexos[] = {'F', 'M'};
        int feminino = 0;
        int masculino = 0;
        
        for (int i = 0; i < 56; i ++) {
            char nome = (char) (65 + (int) (Math.random() * 25)); 
            char sexo = sexos[(0 + (int) (Math.random() * 2))];
            
            if (sexo == 'F') {
                feminino++;
            } else {
                masculino++;
            }
        }
        System.out.printf("%s homens, %s mulheres\n", masculino, feminino);
    }
    
    /** 
    * 20. A concessionária de veículos “CARANGO VELHO” está vendendo os seus 
    * veículos com desconto. Faça um algoritmo que calcule e exiba o valor do 
    * desconto e o valor a ser pago pelo cliente de vários carros. O
    * desconto deverá ser calculado de acordo com o ano do veículo. 
    * Até 2000 - 12% e acima de 2000 - 7%. O sistema deverá perguntar se deseja 
    * continuar calculando desconto até que a resposta seja: “(N) Não”.
    * Informar total de carros com ano até 2000 e total geral;
    */ 
    static void ex20(){
        int quantidadeDeCarros = 0;
        int quantidadeDeCarrosAte2000 = 0;
        double percDesconto = 0.0;
        Character resposta;
        char[] respostas = new char[]{'S', 'N'};        

        do {
            int ano = (int)(1980 + (Math.random() * 42));
            System.out.printf("Informe o ano do carro: %d\n", ano);
            double valor = (5000 + (Math.random() * 200000));
            System.out.printf("Informe o valor do carro: %.2f\n", valor); 

            if (ano <= 2000){
                percDesconto = 0.12;
                quantidadeDeCarrosAte2000++;
            } else {
                percDesconto = 0.07;
            }

            quantidadeDeCarros++;
            double valorDesconto = valor * percDesconto;
            double valorFinal = valor - (valor * percDesconto);

            System.out.printf(
                "Perc. do desconto: %.2f\nValor do desconto: %.2f\nValor a ser " + 
                "pago : %.2f\n",
                percDesconto, valorDesconto, valorFinal);

            resposta = respostas[(int)(0 + (Math.random() * 2))];

            System.out.printf("Deseja continuar?  %s\n\n", 
                resposta);

        } while (Character.toUpperCase(resposta) == 'S');

        System.out.printf(
            "Total de carros: %d\nTotal de carros até 2000: %d\n",
            quantidadeDeCarros, quantidadeDeCarrosAte2000);
    }

    /** 
    * 21. Escreva um algoritmo que leia os dados de “N” pessoas (nome, sexo, 
    * idade e saúde) e informe se está apta ou não para cumprir o serviço 
    * militar obrigatório. Informe os totais;
    */
    static void ex21(){
        System.out.print("Entre com o nome: ");
        String nome = sc.next();
        System.out.print("Entre com o sexo: ");
        char sexo = (char)sc.next().charAt(0);
        System.out.print("Entre com o idade: ");
        int idade = Integer.parseInt(sc.next());
        System.out.print("Entre com o saúde: ");
        String saude = sc.next();

        if (idade >= 18 && saude.equals("bom")) {
            System.out.printf(
                "Nome: %s\nSexo: %s\nIdade: %d\nSaúde: %s\n" +
                "Está APTO para o serviço.\n",
                nome, sexo, idade, saude
            );
        } else {
            System.out.printf(
                "Nome: %s\nSexo: %s\nIdade: %d\nSaúde: %s\n" +
                "Está INAPTO para o serviço.\n",
                nome, sexo, idade, saude
            );            
        }
    }

    /** 
    * 22. Faça um algoritmo que receba o preço de custo e o preço de venda de 
    * 40 produtos. Mostre como resultado se houve lucro, prejuízo ou empate 
    * para cada produto. Informe o valor de custo de cada produto, o valor
    * de venda de cada produto, amédia de preço de custo e do preço de venda;
    */
    static void ex22(){
        
        double custoAcumulado = 0.0;
        double vendaAcumulado = 0.0;
        int quantidade = 10;

        for (int i = 0; i < quantidade; i++){
        
            double precoCusto = 1 + (Math.random() * 100);
            custoAcumulado += precoCusto;

            double precoVenda = 1 + (Math.random() * 100);
            vendaAcumulado += precoVenda;

            System.out.printf("Preço de custo: %.2f\n", precoCusto);
            System.out.printf("Preço de venda: %.2f\n", precoVenda);

            double resultado = precoVenda - precoCusto;

            if (resultado > 0.0) {
                System.out.printf("Resultado: %.2f, Lucro\n", resultado);
            } else {
                if (resultado == 0.0) {
                    System.out.printf("Resultado: %.2f, Empate\n", resultado);
                } else {
                    System.out.printf("Resultado: %.2f, Prejuízo\n", resultado);
                }
            }
        }

        double mediaCusto = custoAcumulado / quantidade;
        double mediaVenda = vendaAcumulado / quantidade;

        System.out.println();

        System.out.printf("Média do preço de custo: %.2f\n" + 
            "Média do preço venda: %.2f\n", mediaCusto, mediaVenda);
    }

    /** 
    * 23. Faça um algoritmo que receba um número e mostre uma mensagem caso 
    * este número sege maior que 80, menor que 25 ou igual a 40;
    */ 
    static void ex23(){

        for(int i = 0; i < 10; i++){
            int numero = (int)(1 + (Math.random() * 100));
            if (numero > 80) {
                System.out.printf("numero: %d maior que 80\n", numero);
            } else {
                if (numero < 25) {
                    System.out.printf("numero: %d menor que 25\n", numero);
                } else {
                    if (numero == 40) {
                        System.out.printf("numero: %d igual a 40\n",
                            numero);
                    } else {
                        System.out.printf("numero: %d\n", numero);
                    }
                }
            }
        }
    }

    /** 
    * 24. Faça um algoritmo que receba “N” números e mostre positivo, negativo 
    * ou zero para cada número;
    */
    static void ex24(){
        for (int i = 0; i< 100; i++){
            int numero = (int)(-100 + (Math.random() * 200));

            if (numero > 0) {
                System.out.printf("numero: %d, POSITIVO\n", numero);
            } else {
                if (numero < 0) {
                    System.out.printf("numero: %d, NEGATIVO\n", numero);
                } else {
                    System.out.printf("numero: %d, ZERO\n", numero);
                }
            }
        }
    }

    /** 
    * 25. Faça um algoritmo que leia dois números e identifique se são iguais 
    * ou diferentes. Caso eles sejam iguais imprima uma mensagem dizendo que 
    * eles são iguais. Caso sejam diferentes, informe qual número é o maior, e 
    * uma mensagem que são diferentes; 
    */
    static void ex25(){
        int numero1 = (int)(1 + (Math.random() * 100));
        int numero2 = (int)(1 + (Math.random() * 100));

        if (numero1 == numero2) {
            System.out.printf("numeros %d e %d são IGUAIS\n", 
                numero1, numero2);
        } else {
            if (numero1 > numero2)  {
                System.out.printf("numeros %d e %d são DIFERENTES, sendo o %d MAIOR\n", numero1, numero2, numero1);
            } else {
                System.out.printf("numeros %d e %d são DIFERENTES, sendo o %d MAIOR\n", numero1, numero2, numero2);

            }
        }
    }

    /** 
    * 26. Faça um algoritmo que leia um número de 1 a 5 e escreva por extenso. 
    * Caso o usuário digite um número que não esteja neste intervalo, exibir a 
    * seguinte mensagem: número inválido;
    */
    static void ex26(){
        int numero1 = (int)(1 + (Math.random() * 10));

        switch(numero1) {
            case 1:
                System.out.printf("numero %d um\n", numero1);
                break;
            case 2:
                System.out.printf("numero %d dois\n", numero1);
                break;
            case 3:
                System.out.printf("numero %d três\n", numero1);
                break;
            case 4:
                System.out.printf("numero %d quatro\n", numero1);
                break;
            case 5:
                System.out.printf("numero %d cinco\n", numero1);
                break;
            default:
                System.out.printf("numero %d inválido\n", numero1);
        }

    }

    /** 
    * 27. A concessionária de veículos “CARANGO” está vendendo os seus veículos 
    * com desconto. Faça um algoritmo que calcule e exiba o valor do desconto e 
    * o valor a ser pago pelo cliente. O desconto deverá ser
    * calculado sobre o valor do veículo de acordo com o combustível (álcool – 
    * 25%, gasolina – 21% ou diesel–14%). Com valor do veículo zero encerra 
    * entrada de dados. Informe total de desconto e total pago pelos clientes;
    */
    static void ex27(){

        double percDesconto;
        double valorDoDesconto;
        double valorAPagar;
        double descontoTotal = 0.0;
        double valorTotal = 0.0;

        while(true) {
            System.out.print("Entre com o valor do carro: ");
            double valorDoCarro = sc.nextDouble();

            if (valorDoCarro == 0.0){
                break;
            }

            System.out.print("Entre com o tipo de combustível: ");
            String combustivel = sc.next();

            if (combustivel.toUpperCase().equals("ALCOOL")) {
                percDesconto = 0.25;
                valorDoDesconto = valorDoCarro * percDesconto;
                valorAPagar = valorDoCarro - valorDoDesconto;
                descontoTotal += valorDoDesconto;
                valorTotal += valorAPagar;
            } else {
                if (combustivel.toUpperCase().equals("GASOLINA")) {
                    percDesconto = 0.21;
                    valorDoDesconto = valorDoCarro * percDesconto;
                    valorAPagar = valorDoCarro - valorDoDesconto;
                    descontoTotal += valorDoDesconto;
                    valorTotal += valorAPagar;
                } else {
                    percDesconto = 0.14;
                    valorDoDesconto = valorDoCarro * percDesconto;
                    valorAPagar = valorDoCarro - valorDoDesconto;
                    descontoTotal += valorDoDesconto;
                    valorTotal += valorAPagar;
                }
            }             
        }

        System.out.printf("Total de Descontos: %.2f\n" +
            "Total Pago pelos Clientes: %.2f\n", descontoTotal, valorTotal);
    }

    /** 
    * 28. Escreva um algoritmo para uma empresa que decide dar um reajuste a 
    * seus 584 funcionários de acordo com os seguintes critérios:
    * a. 50% para aqueles que ganham menos do que três salários mínimos;
    * b. 20% para aqueles que ganham entre três até dez salários mínimos;
    * c. 15% para aqueles que ganham acima de dez até vinte salários mínimos;
    * d. 10% para os demais funcionários.    
    * Leia o nome do funcionário, seu salário e o valor do salário mínimo. 
    * Calcule o seu novo salário
    * reajustado. Escrever o nome do funcionário, o reajuste e seu novo 
    * salário. Calcule quanto à empresa vai aumentar sua folha de pagamento;    
    */
    static void ex28(){
        Faker faker = new Faker();
        int quantidade = 5;
        double totalReajuste = 0.0;

        for(int i = 0; i < quantidade; i++){

            System.out.print("Entre com o nome do funcionário: ");
            String nome = faker.name().firstName();
            System.out.printf("%s\n", nome);

            System.out.print("Entre com o salário do funcionário: ");
            double salarioMinimo = 1302.00;
            double salarioAtual = salarioMinimo * (1 + (Math.random() * 25));
            System.out.printf("%.2f\n", salarioAtual);

            double salarioReajustado;
            double percReajuste;
            double valorReajuste;

            if (salarioAtual < (3 * salarioMinimo)) {
                percReajuste = 0.50;
                valorReajuste = salarioAtual * percReajuste;
                salarioReajustado = salarioAtual + valorReajuste;
                totalReajuste += valorReajuste;
            } else {
                if (salarioAtual < (10 * salarioMinimo)) {
                    percReajuste = 0.20;
                    valorReajuste = salarioAtual * percReajuste;
                    salarioReajustado = salarioAtual + valorReajuste;
                    totalReajuste += valorReajuste;

                } else {
                    if (salarioAtual < (20 * salarioMinimo)) {
                        percReajuste = 0.15;
                        valorReajuste = salarioAtual * percReajuste;
                        salarioReajustado = salarioAtual + valorReajuste;
                        totalReajuste += valorReajuste;
                    } else {
                        percReajuste = 0.10;
                        valorReajuste = salarioAtual * percReajuste;
                        salarioReajustado = salarioAtual + valorReajuste;
                        totalReajuste += valorReajuste;
                    }
                }
            }

            System.out.printf("Nome: %s, Reajuste: %.2f, Novo Salário: %.2f\n",
                nome, valorReajuste, salarioReajustado);
            System.out.println();

        }
        System.out.printf("Aumento total da folha: %.2f\n", totalReajuste);
    }


    /**
    * 29. Faça um algoritmo que receba o número do mês e mostre o mês    
    * correspondente. Valide mês inválido;
    */    
    static void ex29(){
        System.out.print("Entre com o número do mes: ");
        int numeroMes = (int) (1 + (Math.random() * 13));
        System.out.printf("%d\n", numeroMes);

        switch(numeroMes){
            case 1:
                System.out.println("JANEIRO");
                break;
            case 2:
                System.out.println("FEVEREIRO");
                break;
            case 3:
                System.out.println("MARÇO");
                break;
            case 4:
                System.out.println("ABRIL");
                break;
            case 5:
                System.out.println("MAIO");
                break;
            case 6:
                System.out.println("JUNHO");
                break;
            case 7:
                System.out.println("JULHO");
                break;
            case 8:
                System.out.println("AGOSTO");
                break;
            case 9:
                System.out.println("SETEMBRO");
                break;
            case 10:
                System.out.println("OUTUBRO");
                break;
            case 11:
                System.out.println("NOVEMBRO");
                break;
            case 12:
                System.out.println("DEZEMBRO");
                break; 
            default:
                System.out.println("MÊS INVÁLIDO");
        }
    }
    

    /**
    * 30. Escreva um algoritmo que leia três valores inteiros distintos e os 
    * escreva em ordem crescente;
    */
    static void ex30(){
        int quantidade = 10;
        System.out.printf("Entre com %d valores distintos: ", quantidade);
        int[] valores = new int[quantidade];

        for(int i = 0; i < quantidade; i++){
            valores[i] = (int) (1 + Math.random() * 100);
            System.out.printf("%d ", valores[i]);
        }
        
        System.out.println();

        for(int i = 0; i < quantidade; i++){
            for(int j = 0; j < quantidade; j++){
                if (valores[j] > valores[i]){
                    int temp = valores[j];
                    valores[j] = valores[i];
                    valores[i] = temp;
                }
            }
        }

        System.out.print("Valores ordenados: ");

        for(int i = 0; i < quantidade; i++){
            System.out.printf("%d ", valores[i]);
        }

        System.out.println();
    }

    
    /**
    * 31. Dados três valores A, B e C, em que A e B são números reais e C é 
    * um  caractere, pede-se para imprimir o resultado da operação de A por B 
    * se C for um símbolo de operador aritmético; caso contrário deve ser
    * impressa uma mensagem de operador não definido. Tratar erro de divisão 
    * por zero;
    */
    static void ex31(){
        Character[] caracteres = new Character[]{'A', '-', '+', 'B', '*', '/', 'D', 'E'};
        double a = (1 + (Math.random() * 10));
        double b = (1 + (Math.random() * 10));
        Faker faker = new Faker();
        Character c = faker.options().nextElement(caracteres);
        double resultado = 0.0;

        try {
            switch(c) {
                case '+':
                    resultado = a + b;
                    break;
                case '-':
                    resultado = a - b;
                    break;
                case '*':
                    resultado = a * b;
                    break;
                case '/':
                    resultado = a / b;
                    break;
                default:                    
                    System.out.println("Operador não definido.");
            }
        } catch (ArithmeticException ae ) {
            System.out.println("ArithmeticException occured!");
        }

        System.out.printf("%.2f, %.2f, %s\nResultado: %.2f\n", 
            a, b, c, resultado);        
        
    }

    /**
    * 32. Escreva um algoritmo que leia três valores inteiros e verifique se 
    * eles podem ser os lados de um triângulo.
    * Se forem, informar qual o tipo de triângulo que eles formam: 
    * equilátero, isóscele ou escaleno.
    * Propriedade: o comprimento de cada lado de um triângulo é menor do que a 
    * soma dos comprimentos dos outros dois lados.
    * a. Triângulo Equilátero: aquele que tem os comprimentos dos três lados 
    * iguais;
    * b. Triângulo Isóscele: aquele que tem os comprimentos de dois lados 
    * iguais.
    * c. Triângulo equilátero é também isóscele;
    * d. Triângulo Escaleno: aquele que tem os comprimentos de seus três lados
    * diferentes;
    */
    static void ex32(){

        int n = 20;
        
        for (int i = 0; i < n; i++){
            int a = (int) (1 + (Math.random() * 42));
            int b = (int) (1 + (Math.random() * 42));
            int c = (int) (1 + (Math.random() * 42));

            if ((a > (b + c)) || (b > (a + c)) || (c > (b + a))){
                System.out.printf("%d, %d, %d, NÃO é um triângulo\n", a, b, c);
            } else {
                if ((a == b) && (b == c)) {
                    System.out.printf("%d, %d, %d, Equilátero\n", a, b, c);
                } else {
                    if ((a == b) || (b == c) || (c == a)){
                        System.out.printf("%d, %d, %d, Isóscele\n", a, b, c);
                    } else {
                        System.out.printf("%d, %d, %d, Escaleno\n", a, b, c);
                    }
                }
            }
        }        
    }
    
    /**
    * 33. A escola “APRENDER” faz o pagamento de seus professores por 
    * hora/aula. Faça um algoritmo que calcule e exiba o salário de um 
    * professor. Sabe-se que o valor da hora/aula segue a tabela abaixo:
    * a. Professor Nível 1 R$12,00 por hora/aula;
    * b. Professor Nível 2 R$17,00 por hora/aula;
    * c. Professor Nível 3 R$25,00 por hora/aula.
    */
    static void ex33(){
        int n = 5;
        
        for (int i = 0; i < n; i++){
            System.out.print("Entre com a com a qtde de hora/aula: ");
            int horaAula = (int) (1 + (Math.random() * 220));
            System.out.printf("%d\n", horaAula);

            System.out.print("Entre com o nível: ");
            int nivel = (int) (1 + (Math.random() * 3));
            System.out.printf("%d\n", nivel);

            double[] valores = new double[]{12.00, 17.00, 25.00};

            double salario = valores[nivel - 1] * horaAula;
            System.out.printf("Salário: %.2f\n", salario);
            System.out.println();
        }
    }
    
    /**
    * 34. Elabore um algoritmo que, dada a idade de um nadador. Classifique-o 
    * em uma das seguintes categorias:
    * a. Infantil A = 5 - 7 anos;
    * b. Infantil B = 8 - 10 anos;
    * c. Juvenil A = 11- 13 anos;
    * d. Juvenil B = 14 - 17 anos;
    * e. Sênior = 18 - 25 anos.
    * Apresentar mensagem “idade fora da faixa etária” quando for outro ano 
    * não contemplado;
    */
    static void ex34(){
        int n = 5;

        for (int i = 0; i < n; i++){
            System.out.print("Entre com a idade do nadador: ");
            int idade = (int)(1 + (Math.random() * 30));
            System.out.printf("%d\n", idade);

            if (idade >= 8 && idade <= 10) {
                System.out.printf("%s\n", "Infantil B");
            } else {
                if (idade >= 11 && idade <= 13) {
                    System.out.printf("%s\n", "Juvenil A");
                } else {
                    if (idade >= 14 && idade <= 17) {
                        System.out.printf("%s\n", "Juvenil B");
                    } else {
                        if (idade >= 18 && idade <= 25) {
                            System.out.printf("%s\n", "Sênior");
                        } else {
                            System.out.printf("%s\n", "Idade fora da faixa etária");
                        }
                    }
                }
            }
            System.out.println();
        }
    }


    /**
    * 35. Faça um algoritmo que calcule o valor da conta de luz de uma 
    * pessoa. Sabe-se que o cálculo da conta de luz segue a tabela abaixo:
    * Tipo de Cliente Valor do KW/h
    * a. (Residência) 0,60;
    * b. (Comércio) 0,48;   
    * c. (Indústria) 1,29. 
    */
    static void ex35(){
        Faker faker = new Faker();
        double valorDaConta = 0.0;

        System.out.print("Entre com o consumo de energia (Kw): ");
        int kw = (int) (1 + (Math.random() * 200));
        System.out.printf("%d\n", kw);

        System.out.printf(
            "Tipo de Cliente Valor do KW/h\n" +
            "\ta. (Residência) 0,60\n" +
            "\tb. (Comércio) 0,48\n" +   
            "\tc. (Indústria) 1,29\n");
        Character[] tipos = new Character[]{'a','b','c'};
        char tipo = faker.options().nextElement(tipos);
        System.out.printf("\t> %s\n\n", tipo);
        
        switch(tipo){
            case 'a':
                valorDaConta = 0.60 * kw;
                System.out.printf("Valor da conta: %.2f\n", valorDaConta);
                break;
            case 'b':
                valorDaConta = 0.48 * kw;
                System.out.printf("Valor da conta: %.2f\n", valorDaConta);
                break;
            case 'c':
                valorDaConta = 1.29 * kw;
                System.out.printf("Valor da conta: %.2f\n", valorDaConta);
                break;
            default:
                System.out.println("Tipo inválido");
        }

        System.out.println();

    }

}