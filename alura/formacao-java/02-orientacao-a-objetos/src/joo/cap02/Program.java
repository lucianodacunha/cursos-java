package joo.cap02;

/**
* O que é uma classe
* Como criar uma classe
* Como criar um objeto ou instância de uma classe
* O que são atributos
* Como definir e visualizar valores de atributos
* Como funciona a atribuição de uma referência à uma variável
*/
public class Program {
    public static void main(String[] args){
        Conta c1 = new Conta();
        Conta c2 = c1;
        c1.saldo = 100;

        System.out.println("saldo c1: " + c1.saldo);
        System.out.println("saldo c2: " + c2.saldo);

        System.out.printf("Referência c1: %s\nReferência c2: %s\n", c1, c2);

    }
}

class Conta {
    int agencia;
    int numero;
    String titular;
    double saldo;
}