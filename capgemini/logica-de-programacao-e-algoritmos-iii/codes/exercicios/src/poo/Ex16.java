package poo;

import java.util.Locale;
import com.github.javafaker.Faker;

/**
* 16. Construa uma classe para representar um carro. O tanque de 
* combustível do carro armazena no máximo 50 litros de gasolina. O carro 
* consome 15 km/litro. Deve ser possível:
* a. Abastecer o carro com certa quantidade de gasolina;
* b. Mover o carro em uma determinada distância (medida em km);
* c. Retornar a quantidade de combustível e a distância total percorrida.
* No programa principal, crie 2 carros. Abasteça 20 litros no primeiro e 30 
* litros no segundo. Desloque o primeiro em 200 km e o segundo em 400 km. 
* Exiba na tela a distância percorrida e o total de combustível restante 
* para cada um.
*/
public class Ex16 {    

    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        
        Carro c1 = new Carro();
        Carro c2 = new Carro();

        c1.abastecer(3d);
        c2.abastecer(3d);

        System.out.printf("%s", c1);
        System.out.printf("%s", c2);

        c1.deslocar(30d);
        c2.deslocar(100d);

        System.out.printf("%s", c1);
        System.out.printf("%s", c2);
    }
}

class Carro {
    private Double CAPACIDADE_TANQUE_COMBUSTIVEL = 50d;
    private Double AUTONOMIA = 15d;
    private Double quantidadeDeCombustivel = 0d;
    private Double distanciaPercorrida = 0d;

    public void abastecer(Double litros){
        if (this.quantidadeDeCombustivel + litros <= 
            this.CAPACIDADE_TANQUE_COMBUSTIVEL){
            this.quantidadeDeCombustivel += litros;
        } else {
            System.out.printf("Quantidade %.2f excede a capacidade %.2f\n",
            litros, this.CAPACIDADE_TANQUE_COMBUSTIVEL);
        }
    }

    public void deslocar(Double distancia){
        double consumo = distancia / this.AUTONOMIA;
        if ((this.quantidadeDeCombustivel - consumo) >= 0){
            this.distanciaPercorrida += distancia;
            this.quantidadeDeCombustivel -= consumo;
        } else {
            System.out.printf("Combustível insuficiente para essa distância\n");
        }
    }

    @Override
    public String toString(){
        return String.format(
            "Distância percorrida: %.2f, Total de combustível restante: %.2f\n",
            this.distanciaPercorrida, this.quantidadeDeCombustivel
        );        
    }
}
