package poop.section08.exercicios;

import java.util.Locale;


public class Program {
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        ex04();
    }

    static void ex01(){
        double largura = (int)(1 + (Math.random() * 10));
        double altura = (int)(1 + (Math.random() * 10));;
        System.out.printf(
            "Entre com a largura e altura de um retangulo: %.2f, %.2f\n", 
            largura, altura);

        Rectangle rect = new Rectangle();
        rect.width = largura;
        rect.height = altura;

        System.out.printf("AREA: %.2f\nPERIMETER: %.2f\nDIAGONAL: %.2f\n",
            rect.area(), rect.perimeter(), rect.diagonal());
    }

    static void ex02(){
        Funcionario func = new Funcionario();
        func.nome = "Ze";
        func.salarioBruto = 6000.0;
        func.valorImposto = 1000.0;

        System.out.printf(
            "Funcionário: %s\nSalário Bruto: $ %.2f\nImposto: $ %.2f\n\n", 
            func.nome, func.salarioBruto, func.valorImposto);

        System.out.printf(
            "Funcionário: %s, Salário Líquido: $ %.2f\n", 
            func.nome, func.salarioLiquido(), func.valorImposto);

        double percReajuste = 10.0;

        System.out.printf("Entre com o %% de reajuste do salário: %.2f\n\n", 
            percReajuste);

        func.reajustaSalario(percReajuste);

        System.out.printf("Funcionário: %s, Salário Líquido: $ %.2f\n", 
            func.nome, func.salarioLiquido());            
    }

    static void ex03(){
        Aluno aluno = new Aluno();
        aluno.nome = "Ze";
        aluno.notas = new Double[]{27.00, 31.00, 32.00};

        System.out.printf("Entre com o nome do aluno: %s\n", aluno.nome);
        System.out.printf("\tNota 1: %.2f\n", aluno.notas[0]);
        System.out.printf("\tNota 2: %.2f\n", aluno.notas[1]);
        System.out.printf("\tNota 3: %.2f\n", aluno.notas[2]);
        System.out.printf("\tMédia: %.2f\n", aluno.calculaMedia());
        System.out.printf("\tSituação Final: %s\n", aluno.situacaoFinal());

        Aluno aluno1 = new Aluno();
        aluno1.nome = "Jao";
        aluno1.notas = new Double[]{17.00, 20.00, 15.00};

        System.out.printf("Entre com o nome do aluno: %s\n", aluno1.nome);
        System.out.printf("\tNota 1: %.2f\n", aluno1.notas[0]);
        System.out.printf("\tNota 2: %.2f\n", aluno1.notas[1]);
        System.out.printf("\tNota 3: %.2f\n", aluno1.notas[2]);
        System.out.printf("\tMédia: %.2f\n", aluno1.calculaMedia());
        System.out.printf("\tSituação Final: %s\n", 
            aluno1.situacaoFinal());

        Aluno aluno2 = new Aluno();
        aluno2.nome = "Ran";
        aluno2.notas = new Double[]{
            (1 + (Math.random() * 30)), 
            (1 + (Math.random() * 35)),
            (1 + (Math.random() * 35))};

        System.out.printf("Entre com o nome do aluno: %s\n", aluno2.nome);
        System.out.printf("\tNota 1: %.2f\n", aluno2.notas[0]);
        System.out.printf("\tNota 2: %.2f\n", aluno2.notas[1]);
        System.out.printf("\tNota 3: %.2f\n", aluno2.notas[2]);
        System.out.printf("\tMédia: %.2f\n", aluno2.calculaMedia());
        System.out.printf("\tSituação Final: %s\n", 
            aluno2.situacaoFinal());            

    }

    static void ex04(){
        double cotacao = (1 + (Math.random() * 8));
        double quantidade = (int)(1 + (Math.random() * 1000));
        System.out.printf("Qual é a cotação do dólar: R$ %.2f\n", cotacao);
        System.out.printf("Quantos dólares deseja comprar: US$ %.2f\n", quantidade);

        double valorAPagar = 
            ConversorDeMoedas.conversorDeDolaresEmReais(quantidade, cotacao);

        System.out.printf("Quantia a ser paga em reais: R$ %.2f\n", 
            valorAPagar);

    }
}

class Rectangle {
    double width;
    double height;

    public double area(){
        return width * height;
    }

    public double perimeter(){
        return (width * 2) + (height * 2);        
    }

    public double diagonal(){
        return Math.sqrt(Math.pow(height, 2.0) + Math.pow(width, 2.0));
    }
}

class Funcionario {
    String nome;
    Double salarioBruto;
    Double valorImposto;

    public Double salarioLiquido(){
        return this.salarioBruto - valorImposto;
    }

    public void reajustaSalario(Double percReajuste){
        this.salarioBruto += (this.salarioBruto * percReajuste / 100);
    }
}

class Aluno {
    String nome;
    Double[] notas = new Double[3];

    public Double calculaMedia(){

        return notas[0] + notas[1] + notas[2];        
    }

    public String situacaoFinal(){
        if (calculaMedia() >= 60) {
            return "APROVADO";
        }
        return String.format("REPROVADO. Faltou %.2f pontos", 
            60 - calculaMedia());
    }
}

class ConversorDeMoedas {
    private static Double IOF = 0.06;

    public static Double conversorDeDolaresEmReais(
        Double quantidadeDeDolares, Double cotacao){
        return (quantidadeDeDolares * cotacao) * (1 + ConversorDeMoedas.IOF);
    }
}