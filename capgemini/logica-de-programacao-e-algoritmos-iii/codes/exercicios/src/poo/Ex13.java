package poo;

import java.util.Locale;

/**
* 13. Crie uma classe Calculadora. Esta classe deve implementar as 
* operações básicas (soma, subtração, divisão e multiplicação). 
* Utilizando o conceito de herança crie uma classe chamada  calculadora 
* cientifica que implementa os seguintes cálculos: raizQuadrada e a 
* potencia. Dica utilize a classe Math do pacote java.lang.
*/public class Ex13 {    

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        Double a = (double)(int)(1 + (Math.random() *  100));
        Double b = (double)(int)(1 + (Math.random() *  50));

        System.out.printf("a: %.2f, b: %.2f\n", a, b);
        System.out.printf("soma: %.2f\n", Calculadora.soma(a, b));
        System.out.printf("divisao: %.2f\n", Calculadora.divisao(a, b));
        System.out.printf("subtracao: %.2f\n", Calculadora.subtracao(a, b));
        System.out.printf("multiplicacao: %.2f\n", 
            Calculadora.multiplicacao(a, b));

        System.out.printf("raiz quadrada: %.2f\n", 
            CalculadoraCientifica.raizQuadrada(a));
        System.out.printf("potencia: %.2f\n", 
            CalculadoraCientifica.potencia(a, b));

    }
}

class Calculadora {
    public static Double soma(Double a, Double b){
        return a + b;
    }

    public static Double subtracao(Double a, Double b){
        return a - b;
    }

    public static Double divisao(Double a, Double b){
        return a / b;
    }

    public static Double multiplicacao(Double a, Double b){
        return a * b;
    }

}

class CalculadoraCientifica extends Calculadora {
    public static Double raizQuadrada(Double a){
        return Math.sqrt(a);
    }

    public static Double potencia(Double a, Double b){
        return Math.pow(a, b);
    }

}