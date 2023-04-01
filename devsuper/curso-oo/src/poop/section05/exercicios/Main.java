
package poop.section05.exercicios;

import java.util.Scanner;
import java.util.Locale;

import com.github.javafaker.Faker;

public class Main {
    private static Scanner sc;

    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        sc = new Scanner(System.in);

        exerc08();

        sc.close();
    }

    static void exerc01(){

        System.out.print("Entre com um número inteiro: ");
        int numero = sc.nextInt();

        if (numero >= 0){
            System.out.println("Não Negativo");
        } else {
            System.out.println("Negativo");
        }
    }

    static void exerc02(){

        System.out.print("Type a integer number: ");
        int numero = Integer.parseInt(sc.next());
        
        if (numero % 2 == 0){
            System.out.println("EVEN number");
        } else {
            System.out.println("ODD number");
        }
    }

    static void exerc03(){

        System.out.print("Type a two integer numbers: ");
        int number1 = Integer.parseInt(sc.next());
        int number2 = Integer.parseInt(sc.next());

        if (number1 < number2){
            if (number2 % number1 == 0) {
                System.out.println("The numbers are multiples.");
            } else {
                System.out.println("The numbers aren't multiples.");
            }
        } else {
            if (number1 % number2 == 0) {
                System.out.println("The numbers are multiples.");
            } else {
                System.out.println("The numbers aren't multiples.");
            }
        }
    }

    static void exerc04(){

        System.out.print("Enter start time and the end time: ");
        int startHour = sc.nextInt();
        int endHour = sc.nextInt();
        int duration;

        if (startHour < endHour){
            duration = endHour - startHour;

        } else {
            duration = (24 - startHour) + endHour;
        }

        System.out.printf("The game took place for %d hours.\n", duration);
    }

    static void exerc05(){
        System.out.print("Type the item code and quantity: ");
        int itemCode = sc.nextInt();
        int itemQuantity = sc.nextInt();
        double itemValue;
        String itemName;

        if (itemCode == 1) {
            itemName = "Cachorro Quente";
            itemValue = 4.00;
        } else {
            if (itemCode == 2) {
                itemName = "Cachorro X-Salada";
                itemValue = 4.50;
            } else {
                if (itemCode == 3) {
                    itemName = "X-Bacon";
                    itemValue = 5.00;
                } else {
                    if (itemCode == 4) {
                        itemName = "Torrada Simples";
                        itemValue = 2.00;
                    } else {
                        if (itemCode == 5) {
                            itemName = "Cachorro Refrigerante";
                            itemValue = 1.50;
                        } else {
                            itemName = "Not found";
                            System.out.println("Item not found!");
                            itemValue = 0.0;
                        }
                    }
                }
            }
        }

        double amountToPay = itemValue * itemQuantity;

        System.out.printf("%d %s, %.2f each, amount to pay: %.2f\n",
            itemQuantity, itemName, itemValue, amountToPay);
    }

    static void exerc06(){
        System.out.print(
            "Enter a number, that falls between one of the ranges below: ");
        double value = sc.nextDouble();
        String message;

        if (value >= 0.0 && value <= 25.0) {
            message = "Interval (0,25]";
        } else {
            if (value > 25.0 && value <= 50) {
                message = "Interval (25,50]";
            } else {
                if (value > 50 && value <= 75) {
                    message = "Interval (50, 75]";
                } else {
                    if (value > 75 && value <= 100) {
                        message = "Interval (75, 100]";
                    } else {
                        message = "Out of range";
                    }
                }
            }
        }

        System.out.printf("%s\n", message);
    }

    static void exerc07(){
        System.out.print("Enter with x and y values: ");
        double x = sc.nextDouble();
        double y = sc.nextDouble();
        String quadrant;

        if (x == 0 && y == 0) {
            quadrant = "Origin";
        } else {
            if (x >= 0 && y >= 0) {
                quadrant = "Q1";
            } else {
                if (x >= 0 && y < 0) {
                    quadrant = "Q4";
                } else {
                    if (x < 0 && y < 0) {
                        quadrant = "Q3";
                    } else {
                        quadrant = "Q2";
                    }
                }
            }
        }

        System.out.printf("Quadrant: %s\n", quadrant);
    }

    static void exerc08(){
        // Faker faker = new Faker();
        // double salario = faker.number().randomDouble(2, 1000, 10000);
        double salario;
        double[] entradas = new double[]{3002.0, 1701.12, 4520.0};

        for (int i = 0; i < 3; i++){
            salario = entradas[i];
            System.out.printf("Entre com o salário: %.2f\n", salario);  

            double percImposto1 = 0.08;
            double percImposto2 = 0.18;
            double percImposto3 = 0.28;
            double valorImposto = 0.0;

            if (salario < 2000.0) {                
                System.out.printf("Valor do imposto: %s\n\n", "ISENTO");
            } else {
                if (salario < 3000.0) {                    
                    valorImposto = (salario - 2000.0) * percImposto1;
                    System.out.printf("Valor do imposto: %.2f\n\n", 
                        valorImposto);
                } else {
                    if (salario < 4500.0) {                        
                        valorImposto = (3000 - 2000.0) * percImposto1;
                        valorImposto += (salario - 3000.0) * percImposto2;
                        System.out.printf("Valor do imposto: %.2f\n\n", 
                            valorImposto);
                    } else {
                        valorImposto = (3000 - 2000.0) * percImposto1;
                        valorImposto += (4500 - 3000.0) * percImposto2;
                        valorImposto += (salario - 4500.0) * percImposto3;
                        System.out.printf("Valor do imposto: %.2f\n\n", 
                            valorImposto);
                    }
                }
            } 
        }
    }
}