
import java.util.Locale;

public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);

		Cliente cliente = new Cliente(
				"Leandro Souza", "222.222.222-22", "Programador");

		Conta conta = new Conta(1001, 1, cliente);
		conta.deposita(100.0);
		conta.saca(10.0);
		
		System.out.println();
		System.out.printf("%s\n", conta);
	}
}

class Conta {

	private double saldo;
	private int agencia;
	private int numero;
	private Cliente titular;

	public Conta(int agencia, int numero, Cliente titular) {
		this.setAgencia(agencia);
		this.setNumero(numero);
		this.titular = titular;
	}

	public void deposita(double valor) {

		this.saldo += valor;
		System.out.printf("%s você depositou %.2f.\n", 
				this.getTitular().getNome(), valor);
	}

	public boolean saca(double valor) {

		if (this.saldo >= valor) {

			this.saldo -= valor;
			System.out.printf(
					"%s você sacou %.2f. Seu saldo agora é de %.2f.\n",
					this.getTitular().getNome(), valor, this.saldo);
			return true;

		} else {

			System.out.println("Você não possui saldo suficiente");
			return false;

		}
	}

	public boolean transfere(double valor, Conta destino) {
		if (this.saldo >= valor) {
			this.saldo -= valor;
			destino.deposita(valor);
			return true;
		}
		return false;
	}

	public double getSaldo() {

		return this.saldo;
	}

	public int getNumero() {

		return this.numero;

	}

	public int getAgencia() {

		return this.agencia;
	}

	public Cliente getTitular() {

		return titular;

	}

	private void setNumero(int numero) {

		if (numero <= 99999 && numero >= 00001) {

			this.numero = numero;

		} else {

			System.out.println("Insira um número de conta válido.");
		}
	}

	private void setAgencia(int novaAgencia) {

		if (novaAgencia <= 9999 && novaAgencia >= 1000) {

			this.agencia = novaAgencia;

		} else {

			System.out.println("Insira um número de Agência válido.");
		}
	}

	public void setTitular(Cliente titular) {

		this.titular = titular;
	}

	@Override
	public String toString() {
		return String.format(
				"Agencia: %d\nConta: %d\n%s\nSaldo: %.2f.", 
				this.getAgencia(), this.getNumero(),
				this.getTitular(), this.getSaldo());
	}
	

}

class Cliente {

	private String nome;
	private String cpf;
	private String profissao;

	public Cliente(String nome, String cpf, String profissao) {
		this.nome = nome;
		this.cpf = cpf;
		this.profissao = profissao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	@Override
	public String toString() {
		return String.format("Cliente: %s\nCpf: %s\nProfissão: %s", 
				this.getNome(), this.getCpf(),
				this.getProfissao());
	}

}