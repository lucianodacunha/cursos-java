package poop.section04.exercicios;

import java.util.Scanner;
import java.util.Locale;

public class Main {
    private static Scanner sc;

    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        sc = new Scanner(System.in);
        
        exerc06();

        sc.close();
    }

    static void exerc01(){

        System.out.print("Entre com o valor 1: ");
        int valor1 = sc.nextInt();
        System.out.print("Entre com o valor 2: ");
        int valor2 = sc.nextInt();

        System.out.println("Soma dos valores: " + (valor1 + valor2));
    }

    static void exerc02(){
        
        double PI = 3.14159;

        System.out.print("Entre com o valor do raio: ");
        double raio = sc.nextDouble();
        
        double area =  PI * (raio * raio);
        System.out.printf("Área do círculo: %.4f\n", area);
    }

    static void exerc03(){

        System.out.println("Entre com os valores de ");
        System.out.print("A: ");
        int a = sc.nextInt();
        System.out.print("B: ");
        int b = sc.nextInt();
        System.out.print("C: ");
        int c = sc.nextInt();
        System.out.print("D: ");
        int d = sc.nextInt();

        int diferenca = (a * b - c * d);

        System.out.printf("Diferença: %d\n", diferenca);


    }

    static void exerc04(){

        System.out.print("Entre com o código do funcionário: ");
        int codigoDoFuncionario = sc.nextInt();

        System.out.print("Entre com a quantidade de horas trabalhadas: ");
        int horasTrabalhadas = sc.nextInt();

        System.out.print("Entre com o valor por hora: ");
        double valorPorHora = sc.nextDouble();

        double salarioDoFuncionario = valorPorHora * horasTrabalhadas;

        System.out.printf(
            "Código do Funcionário: %d\nSalário do Funcionário: %.2f\n", codigoDoFuncionario, salarioDoFuncionario);

    }   

    static void exerc05(){

        System.out.println(
            "Entre com o código, a quantidade e o valor unitário da peça:");
        int codigoDaPeca1 = Integer.parseInt(sc.next());
        int quantidadeDePecas1 = Integer.parseInt(sc.next());
        double valorUnitarioDaPeca1 = Double.parseDouble(sc.next());

        int codigoDaPeca2 = Integer.parseInt(sc.next());
        int quantidadeDePecas2 = Integer.parseInt(sc.next());
        double valorUnitarioDaPeca2 = Double.parseDouble(sc.next());
               
        double valorAPagar = ((quantidadeDePecas1 * valorUnitarioDaPeca1) + 
            (quantidadeDePecas2 * valorUnitarioDaPeca2));

        System.out.printf("Valor a pagar: %.2f\n", valorAPagar);
    } 

    static void exerc06(){

        System.out.println("Entre com 3 valores de ponto flutuante: ");
        double a = Double.parseDouble(sc.next());
        double b = Double.parseDouble(sc.next());
        double c = Double.parseDouble(sc.next());

        double PI = 3.14159;
        double areaDoTrianguloRetangulo = a * c / 2;
        double areaDoCirculo = PI * (c * c);
        double areaDoTrapezio = (a + b) * c / 2;
        double areaDoQuadrado = b * b;
        double areaDoRetangulo = a * b;

        System.out.printf(
            "Triângulo: %.3f\nCírculo: %.3f\nTrapézio: %.3f\n" + 
            "Quadrado: %.3f\nRetângulo: %.3f\n", areaDoTrianguloRetangulo, 
            areaDoCirculo, areaDoTrapezio, areaDoQuadrado, areaDoRetangulo);
    }
}