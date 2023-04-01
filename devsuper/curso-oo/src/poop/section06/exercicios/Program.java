package poop.section06.exercicios;

/**
* Exercícios sobre estrutura repetitiva while e for
*/
public class Program {
    public static void main(String[] args){
        ex04();       
    }

    static void ex01(){
        String senhaGravada = "2002";
        boolean acessoPermitido = false;

        do {
            String senhaDigitada = 
                String.valueOf((int)(2000 + Math.random() * 10));
            System.out.printf("Entre com a senha: %s\n", senhaDigitada);
            
            acessoPermitido = senhaDigitada.equals(senhaGravada);

            if (acessoPermitido) {
                System.out.printf("%s\n", "ACESSO PERMITIDO");
            } else {
                System.out.printf("%s\n", "SENHA INVÁLIDA");
            }
        } while (acessoPermitido == false);
    }

    static void ex02(){
        int x;
        int y;

        do {
            x = (int)(-10 + (Math.random() * 20));
            y = (int)(-10 + (Math.random() * 20));

            if (x > 0 && y > 0) {
                System.out.printf("%2d, %2d: %s\n", x, y, "PRIMEIRO");
            } else {
                if (x < 0 && y > 0) {
                    System.out.printf("%2d, %2d: %s\n", x, y, "SEGUNDO");
                } else {
                    if (x < 0 && y < 0) {
                        System.out.printf("%2d, %2d: %s\n", x, y, "TERCEIRO");
                    } else {
                        if (x > 0 && y < 0) {
                            System.out.printf("%2d, %2d: %s\n", x, y, "QUARTO");
                        } else {
                            System.out.printf("%2d, %2d\n", x, y);
                        }
                    }
                }
            }
            
        } while (x != 0 && y != 0);
    }

    static void ex03(){
        int alcool = 0;
        int gasolina = 0;
        int diesel = 0;
        int opcao;

        do {
            opcao = (int)(1 + Math.random() * 5);

            System.out.printf(
                "Entre com o código do combustível preferido: \n" +
                "\t1 - Alcool\n" +
                "\t2 - Gasolina\n" +
                "\t3 - Diesel\n" +
                "\t4 - Fim\n" +
                "\t> %d\n", opcao);

            switch(opcao){
                case 1: 
                    alcool++;
                    break;
                case 2: 
                    gasolina++;
                    break;
                case 3: 
                    diesel++;
                    break;
                case 4: 
                    break;
                default:
                    System.out.println("Código inválido, informe novamente");
            }

        } while (opcao != 4);
            
        System.out.printf(
            "MUITO OBRIGADO\n\tAlcool: %d\n\tGasolina: %d\n\tDiesel: %d\n",
            alcool, gasolina, diesel);        
    }

    static void ex04(){
        int valor = (int)(1 + (Math.random() * 100));
        int[] impares = new int[valor];
        int indice = 0;

        System.out.printf("Entre com um valor limite: %d\n", valor);
        System.out.printf("Exibindo impares ate %d\n", valor);

        for (int i = 1; i <= impares.length; i++){
            if (i % 2 != 0) {
                impares[indice] = (i);
                indice++;
            }
        }

        for (int i = 0; i < impares.length; i++){
            if (impares[i] == 0) {
                break;
            }
            System.out.printf("%d\n", impares[i]);
        }
    }
}
