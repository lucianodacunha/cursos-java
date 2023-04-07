package poo;

import java.util.Locale;
import java.util.Scanner;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import com.github.javafaker.Faker;

/**
* 15. Crie uma classe chamada Funcionário que inclui três atributos:
* a. nome (String);
* b. sobrenome (String);
* c. salário mensal (double).
* A classe deve ter um construtor, métodos getters e setters para cada 
* atributo da classe. Escreva uma classe chamada FuncionarioTeste (que 
* contenha o método main) que cria dois objetos da classe Funcionario e
* exibe o salário de cada objeto. Então dê a cada Funcionario um aumento de 
* 10% e exiba novamente o salário anual de cada um deles. Introduza na 
* classe Funcionario uma variável de classe capaz de contabilizar o 
* numero de funcionarios que passaram pela empresa até a data.
*/
public class Ex15 {
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Faker faker = new Faker();

        Funcionario f1 = new Funcionario(
            faker.name().firstName(), faker.name().lastName(),
            faker.number().randomDouble(2, 1300, 10000)
        );
        Funcionario f2 = new Funcionario(
            faker.name().firstName(), faker.name().lastName(),
            faker.number().randomDouble(2, 1300, 10000)
        );

        int n = (int)(1 + (Math.random() * 100));
        Funcionario[] funcionarios = new Funcionario[n];
        for (int i = 0; i < n; i++){
            funcionarios[i] = new Funcionario(
                faker.name().firstName(), faker.name().lastName(),
                faker.number().randomDouble(2, 1300, 10000)
            );
        }

        int a = (int)(1 + (Math.random() * n));
        int b = (int)(1 + (Math.random() * n));


        System.out.printf("%s\n", funcionarios[a]);
        System.out.printf("%s\n", funcionarios[b]);
        funcionarios[a].reajusteSalario(0.10);
        funcionarios[b].reajusteSalario(0.10);
        System.out.printf("%s\n", funcionarios[a]);
        System.out.printf("%s\n", funcionarios[b]);

        System.out.printf("Qtde. de Funcionarios: %d\n",    
            Funcionario.getQuantidadeDeFuncionarios());
    }
}

class Funcionario {
    private String nome;
    private String sobrenome;
    private Double salario;
    private static Integer quantidadeDeFuncionarios = 0;

    public Funcionario(String nome, String sobrenome, Double salario){
        this.nome = nome;
        this.sobrenome = sobrenome;
        setSalario(salario);
        Funcionario.quantidadeDeFuncionarios++;
    }

    public static Integer getQuantidadeDeFuncionarios(){
        return Funcionario.quantidadeDeFuncionarios;
    }

    public void setSalario(Double salario){
        if (salario > 0){
            this.salario = salario;
        } else {
            System.out.printf("Salario nao pode ser menor que 0.0\n" +
                "Ajustando salario para 0.0");
            this.salario = 0.0;
        }        
    }

    public Double getSalario(){
        return this.salario;
    }

    public String getNome(){
        return this.nome;
    }

    public String getSobrenome(){
        return this.sobrenome;
    }

    public Double getSalarioAnual(){
        return this.salario * 12;
    }

    public void reajusteSalario(Double percentual){
        Double novoSalario = this.salario + (this.salario * percentual);
        setSalario(novoSalario);
    }

    public String toString(){
        return String.format(
            "Nome: %s\nSobrenome: %s\nSalario mensal: %.2f\n" + 
            "Salario anual: %.2f\n",
            getNome(), getSobrenome(), getSalario(), getSalarioAnual()
        );
    }


}

