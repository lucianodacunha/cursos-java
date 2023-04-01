package io.github.lucianodacunha.model;

public class Conta {

	double saldo;
	
	public void saca(double valor) {
		System.out.printf("Saque de $ %.2f\n", valor);
	}
	
	public void deposita(double valor) {
		System.out.printf("Deposito de $ %.2f\n", valor);
		
	}
}
