package cap03;

public class Program {

	public static void main(String[] args) {
		System.out.println("Inicio main");
		try {
			metodo1();
		
		} catch (ArithmeticException | NullPointerException e) {
			System.out.printf("\n%s\n", e);
			System.out.printf("%s\n", e.getStackTrace());
		} catch (Exception e) {
			System.out.printf("Exceção genérica: %s\n", e.getStackTrace());
		}
		System.out.println("Fim main");
	}

	static void metodo1() {
		System.out.println("Inicio m1");
		metodo2();
		System.out.println("Fim m1");
	}

	static void metodo2() {
		System.out.println("Inicio m2");
		
		int r = (int)(1 + (Math.random() * 10));
		System.out.printf("Random value: %d\n", r);
		if (r > 5) {			
			throw new ArithmeticException("Forçando exceções");
		} else {
			throw new NullPointerException();
		}
	}
}

class Conta {
	void deposita(int r) {}
}
