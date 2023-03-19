package joo.cap05;

/**
* Atributos privados, restringindo o acesso aos atributos
* Encapsulamento de código
* Métodos de leitura dos atributos, os getters
* Métodos de modificação dos atributos, os setters
* Getters e Setters de referência 
*/
public class Program {
    public static void main(String[] args){
        Conta conta1 = new Conta(); 
        conta1.setNumero(1);
        conta1.deposita(-200);

        Cliente cliente1 = new Cliente();
        cliente1.setNome("Ze");
        cliente1.setCpf("010101010101");
        cliente1.setProfissao("Dev");

        conta1.setTitular(cliente1);

        System.out.printf(
            "Conta %d, titular %s, profissao %s, saldo %.2f\n", 
            conta1.getNumero(), conta1.getTitular().getNome(), 
            conta1.getTitular().getProfissao(), conta1.getSaldo());

        conta1.deposita(200);
        System.out.printf(
            "Conta %d, titular %s, profissao %s, saldo %.2f\n", 
            conta1.getNumero(), conta1.getTitular().getNome(), 
            conta1.getTitular().getProfissao(), conta1.getSaldo());

    }
}

class Conta {
    private int agencia;
    private int numero;
    private Cliente titular;
    private double saldo;

    public void setAgencia(int agencia){
        this.agencia = agencia;
    }

    public void setNumero(int numero){
        this.numero = numero;
    }

    public void setTitular(Cliente titular){
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

    public void deposita(double valor){
        System.out.printf("Depositando %.2f na conta %d\n",
            valor, this.numero);
        if (valor <= 0){
            System.out.println("Valor de deposito não pode ser <= 0");
            return;
        }
        this.saldo += valor;
        
    }

    public boolean saca(double valor){
        System.out.printf("Depositando %.2f na conta %d\n", 
            valor, this.numero);
        if (this.saldo >= valor){
            this.saldo -= valor;
            return true;
        }
        return false;
    }

    public boolean transfere(double valor, Conta destino){
        System.out.printf("Transferindo %.2f da conta %d para a conta %d\n", 
            valor, this.numero, destino.numero);
        if (this.saca(valor)){
            destino.deposita(valor);
            return true;
        }
        return false;
    }
}

class Cliente {
    private String nome;
    private String cpf;
    private String profissao;

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public void setProfissao(String profissao){
        this.profissao = profissao;
    }

    public String getNome(){
        return this.nome;
    }

    public String getCpf(){
        return this.cpf;
    }

    public String getProfissao(){
        return this.profissao;
    }

}
