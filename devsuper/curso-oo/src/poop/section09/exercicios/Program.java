package poop.section09.exercicios;

public class Program {
    public static void main(String[] args){
        int numeroDaConta = 7801;
        String nome = "Maria Brown";
        char temDepositoInicial = 'n';
        Double valorDepositoInicial = 0.0;
        Double valorDeposito = 200.0;
        Double valorDeSaque = 198.0;
        
        Cliente cliente1 = new Cliente(nome);
        Conta conta1;

        if (temDepositoInicial == 'y'){
            conta1 = 
                new Conta(numeroDaConta, cliente1, valorDepositoInicial);
        } else {
            conta1 = new Conta(numeroDaConta, cliente1);
        }

        System.out.printf("Entre com o numero da conta: %d\n", 
            conta1.getNumero());
        System.out.printf("Entre com o titular da conta: %s\n", 
            conta1.getCliente().getNome());

        if (temDepositoInicial == 'y'){
            System.out.printf("A conta tem deposito inicial? %s\n", 
            temDepositoInicial);
            System.out.printf(
                "Entre com um valor de deposito incial: %.2f\n\n", 
                valorDepositoInicial);
        } else {
            System.out.printf("A conta tem deposito inicial? %s\n\n", 
            temDepositoInicial);
        }

        System.out.printf(
            "Dados da conta:\nConta: %d, Cliente: %s, Saldo: %.2f\n\n",
            conta1.getNumero(), conta1.getCliente().getNome(), 
            conta1.getSaldo());
        
        System.out.printf("Entre com um valor de deposito: %.2f\n", 
            valorDeposito);
        conta1.deposita(valorDeposito); 

        System.out.printf("Atualizando dados da conta:\n" +
            "Conta: %d, Cliente: %s, Saldo: %.2f\n\n", conta1.getNumero(), 
            conta1.getCliente().getNome(), conta1.getSaldo());



        System.out.printf("Entre com o valor de saque: %.2f\n", valorDeSaque);

        conta1.saca(valorDeSaque);

        System.out.printf("Atualizando dados da conta:\n" +
            "Conta: %d, Cliente: %s, Saldo: %.2f\n", conta1.getNumero(), 
            conta1.getCliente().getNome(), conta1.getSaldo());
    }
}

class Conta {
    private int numero;
    private Cliente cliente;
    private double saldo;

    public Conta(int numero, Cliente cliente){
        this(numero, cliente, 0.0);
    }

    public Conta(int numero, Cliente cliente, Double depositoInicial){
        this.numero = numero;
        this.cliente = cliente;
        deposita(depositoInicial);
    }

    public int getNumero(){
        return this.numero;
    }

    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }

    public Cliente getCliente(){
        return this.cliente;
    }

    public double getSaldo(){
        return this.saldo;
    }

    public void deposita(double valor){
        if (valor <= 0){
            return;
        }
        this.saldo += valor;        
    }

    public void saca(double valor){
        double taxaDeSaque = 5.0;
        this.saldo -= (valor + taxaDeSaque);
    }
}

class Cliente {
    private String nome;

    public Cliente(String nome){
        this.nome = nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }
}
