package cap04;

public class Program {

	public static void main(String[] args) {
		System.out.println("Inicio main");
		try {
			metodo1();		
		} catch (ArithmeticException | NullPointerException e) {
			System.out.printf("\n%s\n", e);
			System.out.printf("%s, %s\n", e.getMessage(), e.getStackTrace());
		} catch (ValorMuitoBaixoException e) {
			System.out.printf("Minha exceção: %s, %s\n", e.getMessage(), e.getStackTrace());
		} catch (Exception e) {
			System.out.printf("Exceção genérica: %s, %s\n", e.getMessage(), e.getStackTrace());
		}
		System.out.println("Fim main");
	}

	static void metodo1() throws ValorMuitoBaixoException {
		System.out.println("Inicio m1");
		metodo2();
		System.out.println("Fim m1");
	}

	static void metodo2() throws ValorMuitoBaixoException {
		System.out.println("Inicio m2");
		
		int r = (int)(1 + (Math.random() * 10));
		System.out.printf("Random value: %d\n", r);
		if (r > 7) {			
			throw new ArithmeticException("Forçando exceções");
		} else if (r > 5){
			throw new NullPointerException();
		} else {
			throw new ValorMuitoBaixoException("Lançando minha exceção");
		}
	}
}

class ValorMuitoBaixoException extends Exception {

	private static final long serialVersionUID = 1L;

	public ValorMuitoBaixoException(String msg) {
		super(msg);
	}
}

class Conta {
	void deposita(int r) {}
}
