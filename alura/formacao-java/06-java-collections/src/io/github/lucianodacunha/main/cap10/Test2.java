package io.github.lucianodacunha.main.cap10;

public class Test2 {

	public static void main(String[] args) {
		Pessoa pessoa = new Pessoa("Fulano");
		Conta conta = new Conta(pessoa);
		conta.deposita(100.0);
		System.out.println(conta);
	}

}

class Pessoa {
	private String nome;
	
	public Pessoa(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	@Override
	public String toString() {
		return String.format("%s", this.getNome());
	}
}


class Conta {
	private Pessoa titular;
	private Double saldo;
	
	public Conta(Pessoa titular) {
		this.titular = titular;
		this.saldo = 0.0;
	}
	
	public Pessoa getTitular() {
		return titular;
	}
	
	public Double getSaldo() {
		return saldo;
	}
	
	public void deposita(Double valor) {
		this.saldo += valor;
	}
	
	public void saca(Double valor) {
		this.saldo -= valor;
	}
	@Override
	public String toString() {	
		return String.format("Titular: %s, Saldo: %.2f", this.getTitular(), this.getSaldo());
	}
}
