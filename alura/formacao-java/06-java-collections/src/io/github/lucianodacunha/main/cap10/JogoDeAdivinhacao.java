package io.github.lucianodacunha.main.cap10;

import java.util.Random;
import java.util.Scanner;

public class JogoDeAdivinhacao {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int secretNumber = new Random().nextInt(100);

        System.out.println("Jogo de advinhação.");
        System.out.println("O computador escolheu um número de 1 a 100, descubra qual é este numero.");

        for(int i = 3; i > 0; i--){

            if( i == 1 ) System.out.print("Sua última tentativa!: ");
            else System.out.print(String.format("Digite um número, você tem mais %d tentativas: ", i));

            int attempt = scanner.nextInt();

            if (attempt == secretNumber) {
                System.out.println("Parabéns. Você venceu!");
                System.out.println("O número secreto é: " + secretNumber);
                break;
            }

            if ( i == 1 && attempt != secretNumber) {
                System.out.println("Não foi desta vez, o número secreto é: " + secretNumber);
            }

            if (attempt > secretNumber) System.out.println("O número digitado é maior que o número secreto.");
            else System.out.println("O número digitado é menor que o número secreto.");
        }
    }
}
