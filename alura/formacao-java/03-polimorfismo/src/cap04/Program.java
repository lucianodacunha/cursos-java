package cap04;

import java.util.Locale;
import com.github.javafaker.Faker;

public class Program {
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Faker faker = new Faker();

        ContaCorrente cc = (ContaCorrente) getContaCorrente(faker);
        ContaPoupanca cp = (ContaPoupanca) getContaPoupanca(faker);

        System.out.printf("%s\n", cc);
        System.out.printf("%s\n", cp);

        cc.deposita(100.0);
        cp.deposita(100.0);

        System.out.printf("%s\n", cc);
        System.out.printf("%s\n", cp);

        cc.saca(30.0);
        cp.saca(30.0);

        System.out.printf("%s\n", cc);
        System.out.printf("%s\n", cp);


    }

    static Conta getContaCorrente(Faker faker){
        return new ContaCorrente(
            faker.number().numberBetween(1000, 9999),
            faker.number().numberBetween(1000, 9999),
            new Cliente(faker.name().firstName()));
    }

    static Conta getContaPoupanca(Faker faker){
        return new ContaPoupanca(
            faker.number().numberBetween(1000, 9999),
            faker.number().numberBetween(1000, 9999),
            new Cliente(faker.name().firstName()));
    }    
}

class Cliente {
    private String nome;

    public Cliente(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    public String toString(){
        return String.format("Nome: %s", this.getNome());
    }
}

abstract class Conta {
    private int agencia;
    private int numero;
    private Cliente titular;
    protected double saldo;

    public Conta(int agencia, int numero, Cliente titular){
        this.agencia = agencia;
        this.numero = numero;
        this.titular = titular;
    }

    public int getAgencia(){
        return this.agencia;
    }

    public int getNumero(){
        return this.numero;
    }

    public Cliente getTitular(){
        return this.titular;
    }

    public double getSaldo(){
        return this.saldo;
    }

    public abstract void deposita(double valor);

    public boolean saca(double valor){                   
        if (this.saldo >= valor){
            this.saldo -= valor;
            return true;
        }
        return false;
    }

    public boolean transfere(double valor, Conta destino){                    
        if (this.saca(valor)){
            destino.deposita(valor);
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        return String.format("Agencia: %d, Numero: %d, Titular: %s, " + 
            "Saldo: %.2f", this.getAgencia(), this.getNumero(), 
            this.getTitular().getNome(), this.getSaldo());
    }
}

class ContaCorrente extends Conta {

    public ContaCorrente(int agencia, int numero, Cliente titular){
        super(agencia, numero, titular);
    }

    @Override
    public void deposita(double valor){
        super.saldo += valor;
    }

    @Override
    public boolean saca(double valor){        
        double taxaDeSaque = 5.0;
        if (super.getSaldo() >= (valor + taxaDeSaque)){
            super.saca((valor + taxaDeSaque));
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        return String.format("Tipo: CC, %s", super.toString());
    }

}

class ContaPoupanca extends Conta {

    public ContaPoupanca(int agencia, int numero, Cliente titular){
        super(agencia, numero, titular);
    }

    @Override
    public void deposita(double valor){
        super.saldo += valor;
    }

    @Override
    public String toString(){
        return String.format("Tipo: CP, %s", super.toString());
    }
}
