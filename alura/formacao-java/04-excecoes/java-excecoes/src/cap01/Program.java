package cap01;

public class Program {

	public static void main(String[] args) {
		System.out.println("Inicio main");
		metodo1(); 
		System.out.println("Fim main");
	}
	
	static void metodo1() {
		System.out.println("Inicio m1");
		metodo2();
		System.out.println("Fim m1");
	}
	
	static void metodo2() {
		System.out.println("Inicio m2");
		for (int i = 0; i < 5; i++) {
			System.out.printf("%d ", i);
		}
		System.out.println("\nFim m2");
		
	}	
	
}