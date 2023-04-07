package poo;

/**
* 4. Crie uma classe denominada Elevador para armazenar as informações de 
* um elevador dentro de um prédio. A classe deve armazenar o andar atual 
* (térreo = 0), total de andares no prédio (desconsiderando o térreo), 
* capacidade do elevador e quantas pessoas estão presentes nele. A classe 
* deve também disponibilizar os seguintes métodos:
* a. Inicializa: que deve receber como parâmetros a capacidade do elevador 
* e o total de andares no prédio (os elevadores sempre começam no térreo e 
* vazio);
* b. Entra: para acrescentar uma pessoa no elevador (só deve acrescentar se
*  ainda houver espaço);
* c. Sai: para remover uma pessoa do elevador (só deve remover se houver 
* alguém * dentro dele);
* d. Sobe: para subir um andar (não deve subir se já estiver no último 
* andar);
* e. Desce: para descer um andar (não deve descer se já estiver no térreo);
*/
public class Ex04 {
    public static void main(String[] args){
        Elevador e = new Elevador();

        e.inicializa(8, 10);

        System.out.println("Dados do elevador: ");
        System.out.printf(
            "\tAndar atual: %d\n" + 
            "\tTotal de andares: %d\n" + 
            "\tCapacidade do elevador: %d\n" + 
            "\tQuantidade de pessoas presentes: %d\n\n",
            e.getAndarAtual(), e.getTotalDeAndares(), 
            e.getCapacidadeDoElevador(), e.getQuantidadeDePessoasPresentes()
        );

        e.entra();
        e.entra();
        e.sobe();
        e.sobe();
        e.sobe();
        e.sobe();
        e.sai();
        e.desce();
        e.entra();
        e.sobe();
        e.sobe();
        e.sobe();
        e.sobe();
        e.sai();
        e.entra();
        e.desce();

        System.out.println("Dados do elevador: ");
        System.out.printf(
            "\tAndar atual: %d\n" + 
            "\tTotal de andares: %d\n" + 
            "\tCapacidade do elevador: %d\n" + 
            "\tQuantidade de pessoas presentes: %d\n",
            e.getAndarAtual(), e.getTotalDeAndares(), 
            e.getCapacidadeDoElevador(), e.getQuantidadeDePessoasPresentes()
        );        
    }
}

class Elevador {
    private Integer andarAtual = 0;
    private Integer totalDeAndares;
    private Integer capacidadeDoElevador;
    private Integer quantidadeDePessoasPresentes = 0;

    public Integer getAndarAtual(){
        return this.andarAtual;
    }

    public Integer getTotalDeAndares(){
        return this.totalDeAndares;
    }

    public Integer getCapacidadeDoElevador(){
        return this.capacidadeDoElevador;        
    }

    public Integer getQuantidadeDePessoasPresentes(){
        return this.quantidadeDePessoasPresentes;
    }

    public void inicializa(
        Integer capacidadeDoElevador, Integer totalDeAndares){
        this.capacidadeDoElevador = capacidadeDoElevador;
        this.totalDeAndares = totalDeAndares;
    }

    public void entra(){
        System.out.println("Entrando uma pessoa\n");
        if (quantidadeDePessoasPresentes < capacidadeDoElevador){
            quantidadeDePessoasPresentes++;
        } else {
            System.out.printf("Entrada proibida\n" +
            "Capacidade maxima atingida (%d)\n", 
                this.quantidadeDePessoasPresentes);
        }
    }

    public void sai(){
        System.out.println("Saindo uma pessoa\n");
        if (quantidadeDePessoasPresentes >= 1){
            quantidadeDePessoasPresentes--;
        } else {
            System.out.printf("O elevador está vazio.(%d)\n", 
                this.quantidadeDePessoasPresentes);
        }
    }

    public void sobe(){
        if (this.andarAtual < this.totalDeAndares){
            this.andarAtual++;
        } else {
            System.out.printf("Andar maximo atingido (%d)\n", this.andarAtual);
        }
    }

    public void desce(){
        if (this.andarAtual > 0){
            this.andarAtual--;
        } else {
            System.out.printf("Andar minimo atingido (%d)n", this.andarAtual);
        }
    }
}