package joo.cap04;

/**
* Realizar o relacionamento entre classes através de composição;
* Vantagens de se isolar informações repetidas em outra classe;
* Detalhes da composição;
* NullPointerException para atributos não inicializados e seus cuidados.
*/
public class Program {
    public static void main(String[] args){
        Conta conta1 = new Conta(); 
        conta1.numero = 1;
        conta1.deposita(200);

        Cliente cliente1 = new Cliente();
        cliente1.nome = "Ze";
        cliente1.cpf = "010101010101";
        cliente1.profissao = "Dev";

        conta1.titular = cliente1;

        System.out.printf(
            "Conta %d, titular %s, saldo %.2f\n", 
            conta1.numero, conta1.titular.nome, conta1.saldo);
    }
}

class Conta {
    int agencia;
    int numero;
    Cliente titular;
    double saldo;

    public void deposita(double valor){
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
    String nome;
    String cpf;
    String profissao;
}