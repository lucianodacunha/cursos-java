package joo.cap06;

/**
* Construtor da classe, possibilitando receber argumentos e inicializar 
* atributos a partir da criação de um objeto
* Com isso, a inicialização dos atributos recebidos no construtor torna-se 
* obrigatória
* Atributos da classe, os atributos estáticos
* Métodos da classe, os métodos estáticos
* Ausência de referência, do this, dentro de métodos estáticos
*/
public class Program {
    public static void main(String[] args){
        Cliente cliente1 = new Cliente("ze", "101010101", "dev");
        Cliente cliente2 = new Cliente("jao", "101010102", "ceo");

        Conta conta1 = new Conta(1, 1232, cliente1);         
        System.out.printf("Criando nova conta: %d, qtde. de contas: %d\n",
            conta1.getNumero(), Conta.getQuantidadeDeContas());
        Conta conta2 = new Conta(1, 2232, cliente2);
        System.out.printf("Criando nova conta: %d, qtde. de contas: %d\n",
            conta2.getNumero(), Conta.getQuantidadeDeContas());

        conta1.deposita(200);        
        conta2.deposita(100);

        System.out.printf(
            "Conta %d, titular %s, profissao %s, saldo %.2f\n", 
            conta1.getNumero(), conta1.getTitular().getNome(), 
            conta1.getTitular().getProfissao(), conta1.getSaldo());

        System.out.printf(
            "Conta %d, titular %s, profissao %s, saldo %.2f\n", 
            conta2.getNumero(), conta2.getTitular().getNome(), 
            conta2.getTitular().getProfissao(), conta2.getSaldo());
    }
}

class Conta {
    private int agencia;
    private int numero;
    private Cliente titular;
    private double saldo;
    private static int quantidadeDeContas;

    public Conta(int agencia, int numero, Cliente titular){
        this.agencia = agencia;
        this.numero = numero;
        this.titular = titular;
        Conta.adicionaConta();
    }

    private static void adicionaConta(){
        Conta.quantidadeDeContas++;
    }

    public static int getQuantidadeDeContas(){
        return Conta.quantidadeDeContas;
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

    public Cliente(String nome, String cpf, String profissao){
        this.nome = nome;
        this.cpf = cpf;
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
