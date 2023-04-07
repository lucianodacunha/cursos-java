package poo;

import java.util.Locale;
import java.util.Date;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.github.javafaker.Faker;

/**
* 17. O agendamento de compromissos é uma das tarefas mais comuns para 
* profissionais. Um sistema com essa finalidade deve ser capaz de gerenciar 
* compromissos, atribuindo a cada um o seu tipo (reunião, pagamento,
* entrega de projeto); data; nome do participante ( pessoa, empresa etc) 
* alguém com quem acontecerá é o compromisso) e seu telefone. Desenvolva um 
* sistema que seja capaz de fazer operações básicas como agendar, remover 
* e alterar compromissos e exibir compromissos por participante e por data.
*/
public class Ex17 {
    private static Scanner sc;
    public static void main(String[] args) throws ParseException {
        Faker faker = new Faker();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sc = new Scanner(System.in);
        int opcao;

        Agenda agenda = new Agenda();

        do {
            System.out.printf(
                "1 - Agendar compromisso\n" +
                "2 - Remover compromisso\n" +
                "3 - Alterar compromisso\n" +
                "4 - Exibir compromisso\n" +
                "5 - Sair\n"
            );

            opcao = sc.nextInt();

            switch(opcao){
                case 1:
                    agendar(agenda);
                    break;
                case 2:
                    remover(agenda);
                    break;
                case 3:
                    alterar(agenda);
                    break;
                case 4:
                    exibir(agenda);
                    break;
                case 5:
                    break;      
                default:
                    System.out.println("Opção inválida");
            }
        } while(opcao != 5);
    }

    void agendar(Agenda agenda){
        String tipo = "";
        Date data = new Date();
        Pessoa pessoa = new Pessoa();
        agenda.criarCompromisso(tipo, data, pessoa);

    }

    void remover(Agenda agenda){
        exibir(agenda);

        System.out.print("Entre com o id do compromisso a ser removido: ");
        int id = sc.nextInt();
        agenda.removerCompromisso(id);
    }

    void alterar(){
        exibir();
        System.out.print("Entre com o id do compromisso a ser alterado: ");
        int id = sc.nextInt();
        agenda.alterarCompromisso(id);        
    }

    void exibir(Agenda agenda){
        Compromisso[] compromissos = agenda.getCompromissos();

        for(int i = 0; i < compromissos.length; i++){
            if (compromissos[i] != null){
                System.out.printf("%s", compromissos[i]);
            }
        }
    }
}

class Agenda {
    private Compromisso[] compromissos = new Compromisso[10];
    private int indice;

    public void criarCompromisso(String tipo, Date data, Pessoa participante){
        Compromisso compromisso = new Compromisso(
            this.indice, tipo, data, participante
        );
        this.adicionarCompromisso(compromisso);
    }

    public void adicionarCompromisso(Compromisso compromisso){
        if (indice < this.compromissos.length){
            this.compromissos[indice] = compromisso;
            indice++;
        }

        System.out.println("\nCompromisso não adicionado, agenda cheia\n");
    }

    public void removerCompromisso(Integer id){

        for(int i = 0; i < this.compromissos.length; i++){

            if (this.compromissos[i] != null) {
                if (this.compromissos[i].getId() == id){
                    this.compromissos[i] = null;
                }
            }
        }
    }

    public void alterarCompromisso(){
        
    }

    public Compromisso[] getCompromissos(){
        return this.compromissos;
    }
}

class Compromisso {
    private Integer id;
    private String tipo;
    private Date data;
    private Pessoa participante;

    public Compromisso(Integer id, String tipo, Date data, Pessoa participante)
    {        
        this.id = id;
        this.tipo = tipo;
        this.data = data;
        this.participante = participante;
    }

    private void setId(Integer id){
        this.id = id;
    }

    public Integer getId(){
        return this.id;
    }

    public String getTipo(){
        return this.tipo;
    }
    public Date getData(){
        return this.data;
    }

    public Pessoa getParticipante(){
        return this.participante;
    }

    public String toString(){
        return String.format(
            "Id: %d, Tipo: %s, Data: %s, Participante: %s\n", 
            this.getId(), this.getTipo(), this.getData(), this.getParticipante()
        );
    }
}

class Pessoa {
    private String nome;
    private String telefone;

    public Pessoa(){}

    public Pessoa(String nome, String telefone){
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getNome(){
        return this.nome;
    }

    public String getTelefone(){
        return this.telefone;
    }

    public String toString(){
        return String.format(
            "Nome: %s, Telefone: %s\n",
            this.getNome(), this.getTelefone()
        );
    }
}