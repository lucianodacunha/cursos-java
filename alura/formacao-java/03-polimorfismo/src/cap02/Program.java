package cap02;

import java.util.Locale;
import com.github.javafaker.Faker;

public class Program {
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Faker faker = new Faker();

        Funcionario f = getFuncionario(faker);
        Gerente g = getGerente(faker);

        System.out.printf("%s\n", f);
        System.out.printf("%s\n", g);

        Integer senha = faker.number().numberBetween(1000, 9999);
        boolean autenticou = g.autentica(senha);

        System.out.printf("Senha digitada: %d, Autenticou? %s\n", 
            senha, autenticou);
    }

    static Funcionario getFuncionario(Faker faker){
        return new Funcionario(
            faker.name().firstName(), 
            faker.code().imei().substring(0, 11),
            faker.number().randomDouble(2, 1200, 5000));
    }

    static Gerente getGerente(Faker faker){
        return new Gerente(
            faker.name().firstName(), 
            faker.code().imei().substring(0, 11),
            faker.number().randomDouble(2, 5000, 10000),
            faker.number().numberBetween(1000, 9999));
    }    
}

class Funcionario {
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

class Gerente extends Funcionario{

    private Integer senha;


    public Gerente(String nome, String cpf, Double salario, Integer senha){
        super(nome, cpf, salario);
        this.senha = senha;
    }

    public void setSenha(Integer senha){
        this.senha = senha;
    }

    public Integer getSenha(){
        return this.senha;
    }

    public boolean autentica(Integer senha){
        return this.getSenha() == senha;
    }

    @Override
    public Double getBonificacao(){
        return super.getBonificacao() + super.getSalario();
    }

    @Override
    public String toString(){
        return String.format("%s, Senha: %d", super.toString(), 
            this.getSenha());
    }
}