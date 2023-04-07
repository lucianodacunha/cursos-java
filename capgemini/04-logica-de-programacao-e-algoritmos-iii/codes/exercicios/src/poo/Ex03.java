package poo;

/**
* 3. Crie uma classe para representar uma BombaCombustivel. A classe 
* BombaCombustivel deve conter os seguintes atributos: tipo de combustível,
* valor por litro e quantidade de combustível. Além desses atributos a 
* classes deve conter os seguintes métodos.
* a. abastecerPorValor; //método onde é informado o valor a ser abastecido 
* mostra a quantidade de litros que foi colocada no veículo
* b. abastecerPorLitro; // método onde é informado a quantidade em litros 
* de combustível e mostra o valor a ser pago pelo cliente.
* c. alterarValor; //altera o valor do litro do combustível.
* d. alterarCombustivel; //altera o tipo do combustível.
* e. alterarQuantidadeCombustivel; //altera a quantidade de combustível 
* restante na bomba.
* Crie uma classe que contenha um método main para testar sua classe 
* BombaCombustível
*/
public class Ex03 {
    public static void main(String[] args){
        BombaDeCombustivel b = new BombaDeCombustivel(
            "Alcool", (1 + (Math.random() * 9)), (1 + (Math.random() * 100))
        );

        System.out.println("Dados da bomba de combustível");
        System.out.printf("\tTipo de combustível: %s\n", 
            b.getTipoDeCombustivel());
        System.out.printf("\tValor por litro R$ %.2f\n", b.getValorPorLitro());
        System.out.printf("\tQuantidade armazenada: %.2fL\n", 
            b.getQuantidade());
        System.out.println();

        b.abastecerPorLitro(20.0);
        b.abastecerPorValor(50.0);
        b.alterarValor((1 + (Math.random() * 9)));
        b.alterarQuantidadeDeCombustivel((1 + (Math.random() * 100)));
        System.out.println();

        System.out.println("\tDados da bomba de combustível");
        System.out.printf("\tTipo de combustível: %s\n", 
            b.getTipoDeCombustivel());
        System.out.printf("\tValor por litro R$ %.2f\n", b.getValorPorLitro());
        System.out.printf("\tQuantidade armazenada: %.2fL\n", 
            b.getQuantidade());

    }
}

class BombaDeCombustivel {
    private String tipoDeCombustivel;
    private Double valorPorLitro;
    private Double quantidade;

    public BombaDeCombustivel(String tipoDeCombustivel, Double valorPorLitro, 
        Double quantidade){
        this.tipoDeCombustivel = tipoDeCombustivel;
        this.valorPorLitro = valorPorLitro;
        this.quantidade = quantidade;
    }


    public String getTipoDeCombustivel(){
        return this.tipoDeCombustivel;
    }

    public Double getValorPorLitro(){
        return this.valorPorLitro;
    }

    public Double getQuantidade(){
        return this.quantidade;
    }

    public void abastecerPorValor(Double valor){
        System.out.printf(
            "Abastecendo por valor\n" +
            "\tValor pago: R$ %.2f\n" +
            "\tQuantidade abastecida: %.2f litros\n", 
            valor, valor / this.valorPorLitro);
    }

    public void abastecerPorLitro(Double litro){
        System.out.printf(
            "Abastecendo por litro\n" +
            "\tQuantidade em litros %.2f\n" +
            "\tValor a ser pago: R$ %.2f \n", 
        litro, litro / this.valorPorLitro);
    }

    public void alterarValor(Double novoValor){
        this.valorPorLitro = novoValor;
    }

    public void alterarCombustivel(String combustivel){
        this.tipoDeCombustivel = combustivel;
    }

    public void alterarQuantidadeDeCombustivel(Double quantidade){
        this.quantidade = quantidade;
    }
}