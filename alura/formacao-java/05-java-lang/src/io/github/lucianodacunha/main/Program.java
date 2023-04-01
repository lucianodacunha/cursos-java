package io.github.lucianodacunha.main;

import io.github.lucianodacunha.model.Conta;
import io.github.lucianodacunha.model.ContaCorrente;

/**
 * Programa que cria uma conta e realizada operações de depósito e saque.
 * 
 * @author luciano
 *
 */
public class Program {
	public static void main(String[] args) {
		
		Conta c = new ContaCorrente();

		c.deposita(110d);

		System.out.println(c);

		c.saca(100d);

		System.out.println(c);
	}

}
