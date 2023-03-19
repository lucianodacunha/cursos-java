package joo.cap03;

/**
* como definir métodos com parâmetros e retorno
* como retornar algo usando a palavra chave return
* como usar a referência this para acessar um atributo
* que podemos passar uma referência como parâmetro do método
* métodos são chamadas a partir da referência usando o operador .
*/
public class Program {
    public static void main(String[] args){
        Conta c1 = new Conta(); 
        c1.numero = 1;       
        c1.deposita(200);

        Conta c2 = new Conta();
        c2.numero = 2;
        c2.deposita(300);

        boolean sucesso = false;

        System.out.printf("saldo c1: %.2f\n", c1.saldo);
        System.out.printf("saldo c2: %.2f\n", c2.saldo);

        sucesso = c2.transfere(100, c1);

        if (sucesso){
            System.out.println("Operacao realizada com sucesso");
        } else {
            System.out.println("Falha na operacao");
        }

        System.out.printf("saldo c1: %.2f\n", c1.saldo);
        System.out.printf("saldo c2: %.2f\n", c2.saldo);

        sucesso = c2.transfere(1000, c1);

        if (sucesso){
            System.out.println("Operacao realizada com sucesso");
        } else {
            System.out.println("Falha na operacao");
        }

        System.out.printf("saldo c1: %.2f\n", c1.saldo);
        System.out.printf("saldo c2: %.2f\n", c2.saldo);        
    }
}

class Conta {
    int agencia;
    int numero;
    String titular;
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