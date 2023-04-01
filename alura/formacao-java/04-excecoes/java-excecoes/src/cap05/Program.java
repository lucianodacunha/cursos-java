package cap05;

import java.util.Locale;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);

		try {
			run();
		} catch (InsufficientBalanceException | IllegalValueException e) {
			System.out.println(e.getMessage());
		}

	}

	private static void run() throws InsufficientBalanceException {
		Conta c = new Conta();
		Double valor = (-10 + (Math.random() * 100));
		c.deposita(valor);

		valor = (1 + (Math.random() * 100));

		System.out.printf("Saldo: $ %.2f\n", c.saldo);

		c.saca(valor);

		System.out.printf("Saldo: %.2f\n", c.saldo);
		valor = (1 + (Math.random() * 110));

		c.deposita(valor);

		System.out.printf("Saldo: %.2f\n", c.saldo);

	}

}

class Conta {
	double saldo;

	void deposita(double valor) {
		System.out.printf("Depositando $ %.2f.\n", valor);
		if (valor >= 0) {
			saldo += valor;
		} else {
			throw new IllegalValueException("Valor não permitido para essa operação.");
		}
	}

	void saca(double valor) throws InsufficientBalanceException {
		System.out.printf("Sacando $ %.2f.\n", valor);
		if (saldo >= valor) {
			saldo -= valor;
		} else {
			throw new InsufficientBalanceException("Saldo insuficiente.");
		}
	}
}

// unchecked
class IllegalValueException extends RuntimeException {
	public IllegalValueException(String msg) {
		super(msg);
	}
}

// checked
class InsufficientBalanceException extends Exception {
	public InsufficientBalanceException(String msg) {
		super(msg);
	}
}