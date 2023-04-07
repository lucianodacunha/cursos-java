package poo;

import java.util.Locale;
import com.github.javafaker.Faker;

/**
* 2. Crie uma classe para implementar uma ContaCorrente. A classe deve 
* possuir os seguintes atributos:
* número da conta, nome do correntista e saldo. Os métodos são os 
* seguintes: alterarNome, depósito e saque; No construtor, saldo é 
* opcional, com valor default zero e os demais atributos são obrigatórios.
*/
public class Ex02 {
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Faker faker = new Faker();

        ContaCorrente c1 = new ContaCorrente(
            (int)(1 + (Math.random() * 9998)), 
            faker.name().firstName(), 
            (10.0 + (Math.random() * 1990.0)));
        ContaCorrente c2 = new ContaCorrente(
            (int)(1 + (Math.random() * 9998)), 
            faker.name().firstName());            

        System.out.println("Dados das contas:");
        System.out.printf("Conta n.: %d, titular: %s, saldo: %.2f\n",
            c1.getNumero(), c1.getTitular(), c1.getSaldo());
        System.out.printf("Conta n.: %d, titular: %s, saldo: %.2f\n",
            c2.getNumero(), c2.getTitular(), c2.getSaldo());

        System.out.println();

        c1.sacar((10.0 + (Math.random() * 1990.0)));
        c2.depositar((10.0 + (Math.random() * 1990.0)));

        System.out.println("Dados das contas:");
        System.out.printf("Conta n.: %d, titular: %s, saldo: %.2f\n",
            c1.getNumero(), c1.getTitular(), c1.getSaldo());
        System.out.printf("Conta n.: %d, titular: %s, saldo: %.2f\n",
            c2.getNumero(), c2.getTitular(), c2.getSaldo());

    }
}

class ContaCorrente {
    private Integer numero;
    private String titular;
    private Double saldo;

    public ContaCorrente(Integer numero, String titular) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = 0.0;
    }    

    public ContaCorrente(Integer numero, String titular, Double saldo) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;
    }

    public Integer getNumero(){
        return this.numero;
    }

    public String getTitular(){
        return this.titular;
    }

    public Double getSaldo(){
        return this.saldo;
    }

    public void setNome(String titular){
        this.titular = titular;
    }

    public void depositar(Double valor){
        System.out.printf("Depositando %.2f na conta %d\n", valor, this.numero);
        this.saldo += valor;
    }

    public boolean sacar(Double valor){
        System.out.printf("Sacando %.2f na conta %d\n", valor, this.numero);
        if (this.saldo >= valor){
            this.saldo -= valor;
            return true;
        } else {
            System.out.printf(
                "Valor do saque (%.2f) maior que o saldo (%.2f)\n", 
                valor, this.saldo);
            return false;
        }
    }
}
