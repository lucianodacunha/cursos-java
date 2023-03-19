package poo;


import java.util.Locale;
import com.github.javafaker.Faker;

/**
* 14. Crie uma classe em Java chamada Fatura para uma loja de suprimentos 
* de informática. A classe deve conter quatro atributos:
* a. número (String);
* b. descrição (String);
* c. quantidade comprada de um item (int);
* d. preço por item (double).
* A classe deve ter um construtor e os métodos getters e setters. Além 
* disso, forneça um método chamado getTotalFatura que calcula o valor da 
* fatura e depois retorna o valor como um double. Se o valor não for
* positivo, ele deve ser alterado para 0. Se o preço por item não for 
* positivo, ele deve ser alterado para 0.
* Escreva uma nova classe chamada FaturaTeste (que contenha o método main) 
* que demonstre as capacidades da classe Fatura.
*/
public class Ex14 {    

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Faker faker = new Faker();

        Fatura f = new Fatura(
            String.valueOf((int)(1 + (Math.random() * 999))),
            faker.commerce().productName(),
            faker.number().numberBetween(10, 100),
            faker.number().randomDouble(2, 10, 1000)
        );

        System.out.printf("%s\n", f);
    }   
}

class Fatura {
    private String numero;
    private String descricao;
    private Integer quantidade;
    private Double precoUnitario;

    public Fatura(String numero, String descricao, 
        Integer quantidade, Double precoUnitario){
        this.numero = numero;
        this.descricao = descricao;
        setQuantidade(quantidade);
        setPrecoUnitario(precoUnitario);
    }

    public String getNumero(){
        return this.numero;
    }

    public String getDescricao(){
        return this.descricao;
    }

    public void setQuantidade(Integer quantidade){
        if (quantidade > 0){
            this.quantidade = quantidade;
        } else {
            this.quantidade = 0;
        }
    }

    public void setPrecoUnitario(Double precoUnitario){
        if (precoUnitario > 0.0){
            this.precoUnitario = precoUnitario;
        } else {
            this.precoUnitario = 0.0;
        }
    }

    public Integer getQuantidade(){
        return this.quantidade;
    }

    public Double getPrecoUnitario(){
        return this.precoUnitario;
    }

    public Double getTotalDaFatura(){
        return this.getQuantidade() * this.getPrecoUnitario();
    }

    public String toString(){
        return String.format(
            "Fatura: %s\nDescricao: %s\nPreco unitario: %.2f\n" +
            "Quantidade: %d\nTotal: %.2f",
            getNumero(), getDescricao(), getPrecoUnitario(), getQuantidade(),
            getTotalDaFatura()
        );
    }
}