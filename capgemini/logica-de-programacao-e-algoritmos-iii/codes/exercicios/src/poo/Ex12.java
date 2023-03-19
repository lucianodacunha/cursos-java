package poo;


import com.github.javafaker.Faker;

/**
* 12. Crie uma classe Agenda que pode armazenar 10 pessoas e que seja capaz 
* de realizar as seguintes operações:
* a. void armazenarPessoa(String nome, int idade, float altura); //armazena 
* a pessoa em um array 
* b. void removerPessoa(String nome); //remove a pessoa do array
* c. int buscarPessoa(String nome); // informa em que posição da agenda 
* está a pessoa
* d. void imprimirAgenda(); // imprime os dados de todas as pessoas da 
* agenda
* e. void imprimirPessoa(int index); // imprime os dados da pessoa que está 
* na posição “i” da agenda.
*/
public class Ex12 {
    public static void main(String[] args){
        Faker faker = new Faker();
        Agenda a = new Agenda();
        String[] nomes = new String[10];

        for (int i = 0; i < 10; i++){
            String nome = faker.name().firstName();
            a.armazenarPessoa(new Pessoa(
                nome,
                (int)(18 + (Math.random() * 62)),
                (1.55 + (Math.random() * 0.45))
            ));
            nomes[i] = nome;
        }

        a.imprimirAgenda();

        String pessoaProcurada = faker.options().nextElement(nomes);

        System.out.printf("Buscando a pessoa %s\n", pessoaProcurada);
        a.buscaPessoa(pessoaProcurada);
        System.out.printf("Removendo a pessoa %s\n", pessoaProcurada);
        a.removerPessoa(pessoaProcurada);
        a.imprimirAgenda();


    }
}

class Agenda {
    private Pessoa[] pessoas = new Pessoa[10];
    private int indice = 0;

    public void armazenarPessoa(Pessoa pessoa){
        if (indice < pessoas.length){
            this.pessoas[indice] = pessoa;
            indice++;
            return;
        }
        System.out.printf("Agenda cheia\n");
    }

    public void removerPessoa(String nome){
        boolean removido = false;
        for (int i = 0; i < pessoas.length; i++){
            if ((pessoas[i] != null) && (pessoas[i].getNome().equals(nome))){
                pessoas[i] = null;
                removido = true;
            }
        }

        if (removido){
            System.out.printf("Pessoa %s removida com sucesso.\n", nome);
        } else {
            System.out.printf("Pessoa %s não encontrada.\n", nome);
        }
    }

    public void buscaPessoa(String nome){
        boolean encontrado = false;
        for (int i = 0; i < pessoas.length; i++){
            if ((pessoas[i] != null) && (pessoas[i].getNome().equals(nome))){
                System.out.printf("Pessoa %s encontrada na posição %d.\n", 
                    nome, i);
                encontrado = true;
            }
        }

        if (!encontrado){
            System.out.printf("Pessoa %s não encontrada.\n", nome);
        }
    }    

    public void imprimirAgenda(){
        for (int i = 0; i < pessoas.length; i++){
            if (pessoas[i] != null){
                this.imprimirPessoa(i);
            }
        }        
    }

    public void imprimirPessoa(Integer indice){
        System.out.printf("%s", pessoas[indice]);  
    }
}

class Pessoa {
    private String nome;
    private Integer idade;
    private Double altura;

    public Pessoa(String nome, Integer idade, Double altura){
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
    }

    public String getNome(){
        return this.nome;
    }

    public Integer getIdade(){
        return this.idade;
    }

    public Double getAltura(){
        return this.altura;
    }

    public String toString(){
        return String.format(
            "Nome: %s, Idade: %d, Altura: %.2f\n",
            this.getNome(), this.getIdade(), this.getAltura()
        );
    }
}