package poop.section10.exercicios;

import java.util.Locale;
import com.github.javafaker.Faker;

public class Program {
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        ex11();
    }

    static void ex01(){
        int n = (int) (1 + (Math.random() * 30));
        int[] numeros = new int[n];

        System.out.printf("Quantos numeros vc vai digitar? %d\n", n);

        for(int i = 0; i < n; i++){
            numeros[i] = (int)(-100 + (Math.random() * 200));
            System.out.printf("Digite um numero: %d\n", numeros[i]);
        }

        System.out.printf("%s\n", "NUMERO NEGATIVOS");
        for(int i = 0; i < n; i++){
            if (numeros[i] < 0){
                System.out.printf("%2d ", numeros[i]);
            }
        }
        
        System.out.println();

    }

    static void ex02(){
        int n = (int) (1 + (Math.random() * 10));
        double[] numeros = new double[n];
        double soma = 0d;

        System.out.printf("Quantos numeros vc vai digitar? %d\n", n);

        for(int i = 0; i < n; i++){
            numeros[i] = (int)(1 + (Math.random() * 20));
            System.out.printf("Digite um numero: %.2f\n", numeros[i]);
        }

        System.out.printf("\n%s", "VALORES: ");
        for(int i = 0; i < n; i++){              
            System.out.printf("%.2f ", numeros[i]);
            soma += numeros[i];
        }
        
        double media = soma / n;
        System.out.printf("\nSOMA: %.2f\nMEDIA: %.2f\n", soma, media);

    }    

    static void ex03(){
        int n = (int) (1 + (Math.random() * 10));
        Pessoa[] pessoas = new Pessoa[n];
        Faker faker = new Faker();

        for(int i = 0; i < n; i++){
            System.out.printf("Dados da %da pessoa:\n", i + 1);
            String nome = faker.name().firstName();
            int idade = (int) (1 + (Math.random() * 80));
            double altura = (1.55 + (Math.random() * 0.45));
            System.out.printf("\tNome: %s\n", nome);
            System.out.printf("\tIdade: %d\n", idade);
            System.out.printf("\tAltura: %.2f\n", altura);
            pessoas[i] = new Pessoa(nome, idade, altura);
        }

        Relatorio relatorio = ResumePessoas.relatorio(pessoas);
        System.out.printf(
            "Altura media: %.2f\n%% de pessoas menores de 16 anos: %.2f%%\n",
            relatorio.getAlturaMedia(), relatorio.getPercMenorDe16Anos());

        for (int i = 0; i < relatorio.getNomesMenorDe16Anos().length; i++){
            if (relatorio.getNomesMenorDe16Anos()[i] != null)
                System.out.printf("%s ", relatorio.getNomesMenorDe16Anos()[i]);
        }

        System.out.println();

    }

    // numeros pares
    static void ex04(){
        int n = (int) (1 + (Math.random() * 20));
        int[] v = new int[n];
        int pares = 0;

        for (int i = 0; i < n; i++){
            v[i] = (int)(1 + (Math.random() * 100));
        }


        for(int i = 0; i < n; i++){
            if((v[i] % 2) == 0){
                System.out.printf("%d ", v[i]);
                pares++;
            }
        }
        System.out.println();
        System.out.printf("Pares: %d\n", pares);
    }

    // maior posicao
    static void ex05(){
        int n = (int) (1 + (Math.random() * 20));
        int[] v = new int[n];
        int maior = 0;
        int posicaoDoMaior = 0;

        for (int i = 0; i < n; i++){
            v[i] = (int)(1 + (Math.random() * 100));            
            if (v[i] > maior){
                maior = v[i];
                posicaoDoMaior = i;
            }
        }
        System.out.print("Valores: ");
        for(int i = 0; i < n; i++){            
            System.out.printf("%d ", v[i]);
        }        

        System.out.printf("\nMaior %d\n", maior);        
        System.out.printf("Posicao: %d\n", posicaoDoMaior);        
    }

    // soma vetores
    static void ex06(){
        int n = (int) (1 + (Math.random() * 20));
        int[] v1 = new int[n];
        int[] v2 = new int[n];
        int[] v3 = new int[n];

        for (int i = 0; i < n; i++){
            v1[i] = (int)(1 + (Math.random() * 100));
            v2[i] = (int)(1 + (Math.random() * 100));

            v3[i] = v1[i] + v2[i];
        }

        System.out.print("Valores 1: ");
        for(int i = 0; i < n; i++){            
            System.out.printf("%3d ", v1[i]);
        }           

        System.out.println();

        System.out.print("Valores 2: ");
        for(int i = 0; i < n; i++){            
            System.out.printf("%3d ", v2[i]);
        }   
        
        System.out.println();

        System.out.print("Valores 3: ");
        for(int i = 0; i < n; i++){            
            System.out.printf("%3d ", v3[i]);
        }            
        
        System.out.println();        
    }

    static void ex07(){
        int n = (int) (1 + (Math.random() * 10));
        double[] v1 = new double[n];
        double soma = 0d;
        double media = 0d;

        for (int i = 0; i < n; i++){
            v1[i] = (1 + (Math.random() * 100));            
            soma += v1[i];            
        }

        media = soma / n;

        System.out.print("Valores: ");
        for(int i = 0; i < n; i++){            
            System.out.printf("%.2f ", v1[i]);
        }

        System.out.println();

        System.out.printf("Media: %.3f\n", media);
        System.out.print("Abaixo da media: ");

        for (int i = 0; i < n; i++){
            if (v1[i] < media)
                System.out.printf("%.1f ", v1[i]);
        }

        System.out.println();
    }

    static void ex08(){
        int n = (int) (1 + (Math.random() * 10));
        int[] v1 = new int[n];
        int somaPares = 0;
        int qtdePares = 0;
        double mediaPares = 0;

        System.out.print("Valores: ");
        for (int i = 0; i < n; i++){
            v1[i] = (int)(1 + (Math.random() * 100)); 
            System.out.printf("%d ", v1[i]); 
            if (v1[i] % 2 == 0){
                somaPares += v1[i];            
                qtdePares++;
                mediaPares = somaPares / qtdePares;
            }
        }

        System.out.println();
        if (qtdePares > 0) {
            System.out.printf("Media Pares: %.1f\n", mediaPares);
        } else {
            System.out.println("Nenhum numero par");
        }
    }

    // mais velho
    static void ex09(){
        int n = (int) (1 + (Math.random() * 10));
        String[] pessoas = new String[n];
        int[] idades = new int[n];
        int maiorIdade = 0;
        int posicaoMaiorIdade = 0;
        Faker faker = new Faker();

        for (int i = 0; i < n; i++){
            pessoas[i] = faker.name().firstName();
            idades[i] = (int)(1 + (Math.random() * 80));

            System.out.printf("Nome: %s, idade: %d\n", pessoas[i], idades[i]);

            if (idades[i] > maiorIdade){
                maiorIdade = idades[i];
                posicaoMaiorIdade = i;
            }            
        }

        System.out.printf("Pessoa mais velha: %s\n", 
            pessoas[posicaoMaiorIdade]);
    }

    // aprovados
    static void ex10(){
        int n = (int) (1 + (Math.random() * 10));
        String[] pessoas = new String[n];
        double[] notas1 = new double[n];
        double[] notas2 = new double[n];
        double[] medias = new double[n];
        Faker faker = new Faker();

        for (int i = 0; i < n; i++){
            pessoas[i] = faker.name().firstName();
            notas1[i] = (1 + (Math.random() * 10));
            notas2[i] = (1 + (Math.random() * 10));
            medias[i] = (notas1[i] + notas2[i]) / 2;

            System.out.printf("nome: %s, nota1: %.2f, nota2: %.2f, " +
            "media: %.2f\n", 
            pessoas[i], notas1[i], notas2[i], medias[i]);         
        }

        System.out.print("aprovados: ");
        for(int i = 0; i < n; i++){         
                if (medias[i] >= 6.0)
                    System.out.printf("%s ", pessoas[i]);
        }          

        System.out.println();
    }

    // dados pessoas
    static void ex11(){
        int n = (int) (1 + (Math.random() * 10));
        Character[] generos = new Character[n];
        Character[] tipos = new Character[]{'F', 'M'};
        double[] alturas = new double[n];
        double somaAlturaM = 0d;
        double somaAlturaF = 0d;
        double mediaAlturaM = 0d;
        double mediaAlturaF = 0d;
        double menorAltura = 2d;
        double maiorAltura = 0d;
        int qtdeM = 0;
        int qtdeF = 0;
        Faker faker = new Faker();        


        for (int i = 0; i < n; i++){
            generos[i] = faker.options().nextElement(tipos);
            alturas[i] = (1.55 + (Math.random() * 0.45));

            if (alturas[i] > maiorAltura){
                maiorAltura = alturas[i];
            }

            if (alturas[i] < menorAltura){
                menorAltura = alturas[i];
            }

            if (generos[i] == 'M'){
                somaAlturaM += alturas[i];
                qtdeM++;
                mediaAlturaM = somaAlturaM / qtdeM;
            } else {
                somaAlturaF += alturas[i];
                qtdeF++;
                mediaAlturaF = somaAlturaF / qtdeF;
            }

            System.out.printf("Altura: %.2f, Genero: %s\n", 
                alturas[i], generos[i]);
        }

        System.out.printf("Menor altura: %.2f\nMaior altura: %.2f\n" +
            "Media de altura da mulheres: %.2f\nNumero de homens: %d\n",
            menorAltura, maiorAltura, mediaAlturaF, qtdeM);

    }
}

class Pessoa{
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
}

class ResumePessoas {

    public static Relatorio relatorio(Pessoa[] pessoas){
        Double alturaAcumulada = 0d;
        Double alturaMedia = 0d;
        int quantidadeDePessoasMenorDe16 = 0;
        Double percDePessoasMenorDe16 = 0d;
        String[] nomesMenorDe16Anos = new String[pessoas.length];

        for (int i = 0; i < pessoas.length; i++){
            alturaAcumulada += pessoas[i].getAltura();
            if (pessoas[i].getIdade() < 16){
                nomesMenorDe16Anos[quantidadeDePessoasMenorDe16] = 
                    pessoas[i].getNome();
                quantidadeDePessoasMenorDe16++;                
            }
        }

        alturaMedia = alturaAcumulada / pessoas.length;
        percDePessoasMenorDe16 = 
            (double)quantidadeDePessoasMenorDe16 / (double)pessoas.length * 100;

        return new Relatorio(
            alturaMedia, percDePessoasMenorDe16, nomesMenorDe16Anos
        );
    }
}

class Relatorio {
    private Double alturaMedia;
    private Double percMenorDe16Anos;
    private String[] nomesMenorDe16Anos;

    public Relatorio(Double alturaMedia, Double percMenorDe16Anos, 
        String[] nomesMenorDe16Anos){
        this.alturaMedia = alturaMedia;
        this.percMenorDe16Anos = percMenorDe16Anos;
        this.nomesMenorDe16Anos = nomesMenorDe16Anos;
    }

    public Double getAlturaMedia(){
        return this.alturaMedia;
    }

    public Double getPercMenorDe16Anos(){
        return this.percMenorDe16Anos;
    }

    public String[] getNomesMenorDe16Anos(){
        return this.nomesMenorDe16Anos;
    }
}