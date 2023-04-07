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
* 1. Crie uma classe para representar uma Pessoa com os atributos privados 
* de nome, data de nascimento e altura. Crie os métodos públicos 
* necessários para getters e setters e também um método para imprimir
* todos dados de uma pessoa. Crie um método para calcular a idade da pessoa.
*/
public class Ex01 {    

    public static void main(String[] args) throws ParseException {
        Faker faker = new Faker();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        int n = 20;

        LocalDate data = LocalDate.now();
        System.out.printf("Data: %s\n\n", data.format(dtf));

        for (int i = 0; i < n; i++){
            
            String nome = faker.name().firstName();
            LocalDate dataDeNascimento = LocalDate.parse(
                sdf.format(faker.date().birthday()), dtf);

            Double altura = (1.55 + (Math.random() * 0.45));

            Pessoa p1 = new Pessoa(nome, dataDeNascimento, altura);
            System.out.printf("%s", p1);
        }

        System.out.println();
    }
}

class Pessoa {
    private String nome;
    private LocalDate dataDeNascimento;
    private Double altura;

    public Pessoa(String nome, LocalDate dataDeNascimento, Double altura){
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
        this.altura = altura;
    }

    public String getNome(){
        return this.nome;
    }

    public LocalDate getDataDeNascimento(){
        return this.dataDeNascimento;
    }

    public Double getAltura(){
        return this.altura;
    }

    private int getIdade(){
        LocalDate agora = LocalDate.now();
        Period periodo = Period.between(dataDeNascimento, agora);        
        return periodo.getYears();
    }

    public String toString(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return String.format(
            "Nome: %s, Dt. Nascimento: %s, Idade: %d, Altura: %.2f\n",
            getNome(), getDataDeNascimento().format(dtf), getIdade(), 
            getAltura()
        );
    }

}
