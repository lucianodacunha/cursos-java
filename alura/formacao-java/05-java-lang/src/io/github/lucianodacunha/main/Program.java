package io.github.lucianodacunha.main;

import io.github.lucianodacunha.model.Conta;
import io.github.lucianodacunha.model.ContaCorrente;


public class Program {
	public static void main(String[] args) {		
		
		Conta c = new ContaCorrente();
		
		c.saca(100d);
		
		c.deposita(100d);
	}

}
