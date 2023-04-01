package io.github.lucianodacunha.model;

/**
 * Classe que representa uma conta bancária, do tipo Corrente.
 * Nesse tipo de conta, o saque é tributado com $ 0.50, valor definido na  
 * constante {@code TAXA_ADICIONAL}. 
 * 
 * @author luciano
 *
 */
public class ContaCorrente extends Conta {
	/**
	 * Uma constante que representa a taxa adicional a ser cobrada em saques
	 * nesse tipo de conta.
	 */
	private double TAXA_ADICIONAL = 0.5;

	/**
	 * Realiza retiradas de valores da conta, subtraindo de {@code saldo} o 
	 * parâmetro {@code valor} + a {@code taxaAdicional}. 
	 * @param valor Valor a ser sacado 
	 * 
	 */
	@Override
	public void saca(double valor) {
		super.saca(valor + this.TAXA_ADICIONAL);		
		System.out.printf("Sacando $ %.2f + taxa adicional de $ %.2f\n", 
				valor, this.TAXA_ADICIONAL);
	}
}
