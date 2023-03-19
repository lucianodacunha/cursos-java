package poo;


import java.util.Date;


/** 
* 9. Escreva uma classe em que cada objeto representa um Voo que acontece 
* em determinada data e em determinado horário. Cada vôo possui no máximo 
* 100 passageiros, e a classe  permite controlar a ocupação das vagas. A 
* classe deve ter os seguintes métodos:
* a. Construtor: configura os dados do vôo (recebidos como parâmetro): 
* número do vôo, data (para armazenar a data utilize um objeto da classe 
* Data, criada na questão anterior);
* b. ProximoLivre: retorna o número da próxima cadeira livre
* c. Verifica: verifica se o número da cadeira recebido como parâmetro está 
* ocupada
* d. Ocupa: ocupa determinada cadeira do vôo, cujo número é recebido como 
* parâmetro, e retorna verdadeiro se a cadeira ainda não estiver ocupada 
* (operação foi bem sucedida) e falso caso contrário
* e. Vagas: retorna o número de cadeiras vagas disponíveis (não ocupadas) 
* no vôo
* f. GetVoo: retorna o número do vôo
*/
public class Ex09 {
    public static void main(String[] args){
        Voo voo = new Voo(1234, new Date());

        System.out.printf("Informações do voo %d\n", voo.getVoo());
        System.out.printf("Quantidade de vagas: %d\n", voo.vagas());

        int cadeiraLivre = voo.proximoLivre();
        System.out.printf("Proximo livre: %d\n", cadeiraLivre);
        boolean cadeiraReservada = voo.ocupa(cadeiraLivre);
        System.out.printf("Cadeira %d reservada? %s\n", 
            cadeiraLivre, cadeiraReservada);

        cadeiraReservada = voo.verifica(cadeiraLivre);
        System.out.printf("Cadeira %d ocupada? %s\n", 
            cadeiraLivre, voo.verifica(cadeiraLivre));
        System.out.printf("Quantidade de vagas: %d\n", voo.vagas());

    }
}

class Voo {
    private Integer numero;
    private Date data;
    private Integer[] cadeiras = new Integer[100];

    public Voo(Integer numero, Date data){
        this.numero = numero;
        this.data = data;
    }

    public Integer proximoLivre(){
        for (int i = 0; i < cadeiras.length; i++){
            if (!verifica(i))
                return i;
        }
        System.out.printf("Todas as cadeiras estão ocupadas");
        return -1;
    }

    public boolean verifica(Integer cadeira){
        return cadeiras[cadeira] != null;
    }

    public boolean ocupa(Integer cadeira){
        if (!verifica(cadeira)){
            this.cadeiras[cadeira] = 1;
            return true;
        }
        return false;
    }

    public Integer vagas(){
        int vagasDisponiveis = 0;

        for (int i = 0; i < cadeiras.length; i++){
            if (cadeiras[i] == null)
                vagasDisponiveis++;
        }

        return vagasDisponiveis;

    }

    public Integer getVoo(){
        return this.numero;
    }
}