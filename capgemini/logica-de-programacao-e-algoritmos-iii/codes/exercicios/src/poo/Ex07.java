package poo;

import java.util.Locale;
import com.github.javafaker.Faker;

/**
* 7. A fim de representar funcionários em uma empresa, crie uma classe 
* chamada Funcionario que inclui as três informações a seguir como 
* atributos:
* a. um primeiro nome,
* b. um sobrenome
* c. um salário mensal
* Sua classe deve ter um construtor que inicializa os três atributos. 
* Forneça os métodos getters e setters para cada atributo. Se o salário 
* mensal não for positivo, configure-o como 0.0. Escreva um aplicativo de 
* teste que demonstra as capacidades da classe. Crie duas instâncias da 
* classe e exiba o salário anual de cada instância. Então dê a cada 
* empregado um aumento de 10% e exiba novamente o salário anual de cada
* empregado.
*/
public class Ex07 {
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

        System.out.printf("%s\n", f1);
        System.out.printf("%s\n", f2);
        f1.reajusteSalario(0.10);
        f2.reajusteSalario(0.30);
        System.out.printf("%s\n", f1);
        System.out.printf("%s\n", f2);
    }
}

class Funcionario {
    private String nome;
    private String sobrenome;
    private Double salario;

    public Funcionario(String nome, String sobrenome, Double salario){
        this.nome = nome;
        this.sobrenome = sobrenome;
        setSalario(salario);
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
