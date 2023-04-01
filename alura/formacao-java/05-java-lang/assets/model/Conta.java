package io.github.lucianodacunha.model;

/**
 * A classe {@code Conta} representa uma conta bancária genérica.
 * 
 * @author luciano
 *
 */
public class Conta {

	private double saldo;
	
	/**
	 * Realiza retiradas de valores da conta, subtraindo de {@code saldo} o 
	 * parâmetro {@code valor}. 
	 * @param valor o valor a ser sacado.
	 */
	public void saca(double valor) {
		System.out.printf("Saque de $ %.2f\n", valor);
		this.saldo -= valor;
	}
	
	/**
	 * Realiza adições de valores na conta, adicionando a {@code saldo} o 
	 * parâmetro {@code valor}.
	 * @param valor o valor a ser depositado.
	 */
	public void deposita(double valor) {
		System.out.printf("Deposito de $ %.2f\n", valor);
		this.saldo += valor;
	}
	
	/**
	 * Retorna o valor atual de {@code saldo}.
	 * @return o valor atual de {@code saldo}
	 */
	public double getSaldo() {
		return this.saldo;
	}
	
	/**
	 * Retorna o valor do {@code saldo} representando a conta atual.
	 */
	public String toString() {
		return String.format("Saldo: %.2f", this.saldo);
	}
}
