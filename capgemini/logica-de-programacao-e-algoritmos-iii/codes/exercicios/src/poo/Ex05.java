package poo;

import java.util.Locale;
import com.github.javafaker.Faker;

/**
* 5. Escreva uma classe cujos objetos representam alunos matriculados em 
* uma disciplina. Cada objeto dessa classe deve guardar os seguintes dados 
* do aluno: matrícula, nome, 2 notas de prova e 1 nota de trabalho.
* Escreva os seguintes métodos para esta classe:
* a. media: calcula a média final do aluno (cada prova tem peso 2,5 e o 
* trabalho tem peso 2)
* b. final: calcula quanto o aluno precisa para a prova final (retorna zero
* se ele não for para a final)
*/
public class Ex05 {
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Faker faker = new Faker();

        Matricula m = new Matricula(
            (int) (1000 + (Math.random() * 9000)), 
            faker.name().firstName());

        m.setNotaProva(1 + (Math.random() * 10));
        m.setNotaProva(1 + (Math.random() * 10));
        m.setNotaTrabalho(1 + (Math.random() * 10));

        System.out.printf("Dados\n");
        System.out.printf("\tMatricula: %d\n", m.getMatricula());
        System.out.printf("\tNome: %s\n", m.getNome());
        System.out.printf("\tNotas: \n%s", m.getNotas());
        System.out.printf("\tMedia: %.2f\n", m.media());
        System.out.printf("\tNota Final Requerida: %.2f\n", m.provaFinal());
    }
}

class Matricula {
    private Integer matricula;
    private String nome;
    private Double[] provas = new Double[2];
    private Double trabalho;
    private int indiceNota = 0;

    public Matricula(Integer matricula, String nome){
        this.matricula = matricula;
        this.nome = nome;
    }

    public void setNotaProva(Double nota){
        if (indiceNota <= provas.length){
            this.provas[indiceNota] = nota;
            indiceNota++;
        } else {
            System.out.println("Provas concluídas");
        }
    }

    public Integer getMatricula(){
        return this.matricula;
    }

    public String getNome(){
        return this.nome;
    }

    public String getNotas(){
        StringBuilder notas = new StringBuilder();

        notas.append(String.format("\t\tProva 1: %.2f, Prova 2: %.2f, " +
            "Trabalho: %.2f\n", 
            provas[0], provas[1], trabalho));

        return notas.toString();
    }

    public void setNotaTrabalho(Double nota){
        this.trabalho = nota;
    }

    public Double media(){
        return ((provas[0] * 2.5) + (provas[1] * 2.5) + (trabalho * 2)) / 7;
    }

    public Double provaFinal(){
        double notaFinal = 7.0 - media();
        if (notaFinal <= 0)
            return 0.0;
        return notaFinal;
    }
}

