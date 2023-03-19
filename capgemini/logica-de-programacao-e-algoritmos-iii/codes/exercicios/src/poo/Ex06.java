package poo;


import java.util.Locale;
import com.github.javafaker.Faker;


/*
* 6. Crie uma classe chamada Invoice que possa ser utilizado por uma loja 
* de suprimentos de informática para representar uma fatura de um item 
* vendido na loja. Uma fatura deve incluir as seguintes informações
* como atributos:
* a. o número do item faturado,
* b. a descrição do item,
* c. a quantidade comprada do item e
* d. o preço unitário do item.
* Sua classe deve ter um construtor que inicialize os quatro atributos. Se 
* quantidade não for positiva, ela deve ser configurada como 0. Se o preço 
* por item não for positivo ele deve ser configurado como 0.0.
* Forneça os métodos getters e setters para cada variável de instância. 
* Além disso, forneça um método chamado getInvoiceAmount que calcula o 
* valor da fatura (isso é, multiplica a quantidade pelo preço por
* item) e depois retorna o valor como um double. Escreva um aplicativo de 
* teste que demonstra as capacidades da classe Invoice.
*/
public class Ex06 {
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Faker faker = new Faker();

        Fatura f = new Fatura(
            (int)(1 + (Math.random() * 999)),
            faker.commerce().productName(),
            (double)faker.number().numberBetween(10, 100),
            faker.number().randomDouble(2, 10, 1000)
        );

        System.out.printf("%s\n", f);
    }
}

class Fatura {
    private Integer numero;
    private String descricao;
    private Double quantidade;
    private Double precoUnitario;

    public Fatura(Integer numero, String descricao, 
        Double quantidade, Double precoUnitario){
        this.numero = numero;
        this.descricao = descricao;
        setQuantidade(quantidade);
        setPrecoUnitario(precoUnitario);
    }

    public Integer getNumero(){
        return this.numero;
    }

    public String getDescricao(){
        return this.descricao;
    }

    public void setQuantidade(Double quantidade){
        if (quantidade > 0.0){
            this.quantidade = quantidade;
        } else {
            this.quantidade = 0.0;
        }
    }

    public void setPrecoUnitario(Double precoUnitario){
        if (precoUnitario > 0.0){
            this.precoUnitario = precoUnitario;
        } else {
            this.precoUnitario = 0.0;
        }
    }

    public Double getQuantidade(){
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
            "Fatura numero %d\nDescricao: %s\nPreco unitario: %.2f\n" +
            "Quantidade: %.2f\nTotal: %.2f",
            getNumero(), getDescricao(), getPrecoUnitario(), getQuantidade(),
            getTotalDaFatura()
        );
    }
}