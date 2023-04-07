package poo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.Period;

import java.util.Date;
import java.text.SimpleDateFormat;

import com.github.javafaker.Faker;

/**
* 10. Crie uma classe para representar um jogador de futebol, com os 
* atributos:
* a. nome;
* b. posição;
* c. data de nascimento;
* d. nacionalidade;
* e. altura;
* f. peso;
* Crie os métodos públicos necessários para getters e setters e também um 
* método para imprimir todos os dados do jogador. Crie um método para 
* calcular a idade do jogador e outro método para mostrar quanto
* tempo falta para o jogador se aposentar. Para isso, considere que os 
* jogadores da posição de defesa se aposentam em média aos 40 anos, os 
* jogadores de meio-campo aos 38 e os atacantes aos 35.
*/
public class Ex11 {
    private static SimpleDateFormat sdf; 
    private static DateTimeFormatter dtf;

    public static void main(String[] args){
        Faker faker = new Faker();
        sdf = new SimpleDateFormat("dd-MM-yyyy");
        dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        JogadorDeFutebol j1 = new JogadorDeFutebol(
            faker.name().firstName(),
            faker.options().nextElement(
                new String[]{"Defesa", "Meio-Campo", "Ataque"}),
            LocalDate.parse(
                sdf.format(faker.date().birthday(18,40)), dtf),
            faker.options().nextElement(
                new String[]{"Brasileiro", "Argentino", "Português"}),
            (1.55 + (Math.random() * 0.45)), 
            (60 + (Math.random() * 40))
        );

        System.out.printf("%s\n", j1);
    }
}

class JogadorDeFutebol{
    private String nome;
    private String posicao;
    private LocalDate dataDeNascimento;
    private String nacionalidade;
    private Double altura;
    private Double peso;

    public JogadorDeFutebol(String nome, String posicao,
        LocalDate dataDeNascimento, String nacionalidade, Double altura, 
        Double peso){
        this.nome = nome;
        this.posicao = posicao;
        this.dataDeNascimento = dataDeNascimento;
        this.nacionalidade = nacionalidade;
        this.altura = altura;
        this.peso = peso;
    }

    public Integer getIdade(){
        Period periodo = Period.between(this.dataDeNascimento, LocalDate.now());
        return periodo.getYears();
        
    }

    public String getNome(){
        return this.nome;
    }

    public String getPosicao(){
        return this.posicao;
    }

    public LocalDate getDataDeNascimento(){
        return this.dataDeNascimento;
    }

    public String getNacionalidade(){
        return this.nacionalidade;
    }

    public Double getAltura(){
        return this.altura;
    }

    public Double getPeso(){
        return this.peso;
    }

    public Integer getTempoParaAposentar(){
        int idadeAposentarioDefesa = 40;
        int idadeAposentarioMeio = 38;
        int idadeAposentarioAtaque = 35;

        if (this.getPosicao().equals("Defesa")) {
            return idadeAposentarioDefesa - this.getIdade();
        } else if (this.getPosicao().equals("Meio-Campo")) {
            return idadeAposentarioMeio - this.getIdade();
        } else {
            return idadeAposentarioAtaque - this.getIdade();
        }
    }

    public String toString(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        return String.format(
            "Nome: %s\nPosicao: %s\nDt. Nascimento: %s\nIdade: %d\n" + "Nacionalidade: %s\nAltura: %.2f\nPeso: %.2f\n" +
            "Tempo para Aposentar: %d\n", 
            this.getNome(), this.getPosicao(),
            this.getDataDeNascimento().format(dtf), this.getIdade(), 
            this.getNacionalidade(), this.getAltura(), this.getPeso(),
            this.getTempoParaAposentar()
        );
    }

}