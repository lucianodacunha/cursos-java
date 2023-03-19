package cap06;

import java.util.Locale;
import com.github.javafaker.Faker;

public class Program {
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Faker faker = new Faker();
        
        Autenticavel g = new Gerente(
            faker.name().firstName(), 
            faker.code().imei().substring(0, 11),
            faker.number().randomDouble(2, 5000, 10000),
            1234);
        
        Autenticavel c = new Cliente(faker.name().firstName(), 1234);
        Autenticavel a = new Administrador(
            faker.name().firstName(), 
            faker.code().imei().substring(0, 11),
            faker.number().randomDouble(2, 5000, 10000),
            1234);

        System.out.printf("%s\n", g);
        System.out.printf("%s\n", c);
        System.out.printf("%s\n", a);
    }

   
}

abstract class Funcionario {
    private String nome;
    private String cpf;
    private Double salario;

    public Funcionario(String nome, String cpf, Double salario){
        this.nome = nome;
        this.cpf = cpf;
        this.salario = salario;        
    }

    public String getNome(){
        return this.nome;
    }

    public String getCpf(){
        return this.cpf;
    }

    public Double getSalario(){
        return this.salario;
    }

    public Double getBonificacao(){
        return this.salario * 0.1;
    }

    public String toString(){
        return String.format(
            "Nome: %s, CPF: %s, Salario: %.2f, Bonificacao: %.2f",
            this.getNome(), this.getCpf(), this.getSalario(), 
            this.getBonificacao()
        );
    }
}

class Gerente extends Funcionario implements Autenticavel{

    private int senha;

    public Gerente(String nome, String cpf, Double salario, Integer senha){
        super(nome, cpf, salario);   
        this.senha = senha;     
    }


    @Override
    public void setSenha(int senha){
        this.senha = senha;
    }

    @Override
    public boolean autentica(int senha){
        return this.senha == senha;
    }


    @Override
    public Double getBonificacao(){
        return super.getBonificacao() + super.getSalario();
    }

    @Override
    public String toString(){
        return String.format("%s, Autentica: %s", super.toString(), 
            autentica(this.senha));
    }
}

class Cliente implements Autenticavel{
    private String nome;
    private int senha;

    public Cliente(String nome, int senha){
        this.nome = nome;
        this.senha = senha;
    }

    @Override
    public void setSenha(int senha){
        this.senha = senha;
    }

    @Override
    public boolean autentica(int senha){
        return this.senha == senha;
    }

    public String getNome(){
        return this.nome;
    }

    public String toString(){
        return String.format("Nome: %s, Autentica: %s", 
            this.getNome(), autentica(this.senha));
    }
}

class Administrador extends Funcionario implements Autenticavel {
    private int senha;

    public Administrador(String nome, String cpf, Double salario, int senha){
        super(nome, cpf, salario);
        this.senha = senha;
    }

    @Override
    public void setSenha(int senha){
        this.senha = senha;
    }

    @Override
    public boolean autentica(int senha){
        return this.senha == senha;
    }

    @Override 
    public String toString(){
        return String.format(
            "%s, Autentica: %s", super.toString(), this.autentica(this.senha)
        );
    }

}

class ControleBonificacao {
    private double totalDeBonificacao;

    public void registra(Funcionario funcionario){
        this.totalDeBonificacao += funcionario.getBonificacao();
    }

    public Double getTotalDeBonificacao(){
        return this.totalDeBonificacao;
    }
}

abstract interface Autenticavel{    

    public abstract void setSenha(int senha);

    public abstract boolean autentica(int senha);
}

class SistemaInterno {
    private int senha = 1234;

    public boolean autentica(Autenticavel autenticavel){
        boolean autentica = autenticavel.autentica(this.senha);

        if (autentica) {
            System.out.println("autenticado com sucesso");
            return true;
        } 

        System.out.println("autenticação negada");
        return false;
    }
}
