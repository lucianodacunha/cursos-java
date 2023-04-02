package io.github.lucianodacunha.main.cap05.test;

public class Test {
	public static void main(String[] args) {
		A a = new A();
		A b = new B();
		
		a.printaFrase2("Hello World");
		b.printaFrase2("Hello World");
	}
}

class A {
	void printaFrase(String frase) {
		System.out.println(frase);
	}
	
	void printaFrase2(String frase) {
		System.out.println(frase);		
	}
}

class B extends A {
	
	@Override
	void printaFrase(String frase) {
		super.printaFrase("Método B: " + frase);
		//System.out.println("Método B: " + frase);
		//return String.format("Método de B: %s", frase);
	}
	
	
	void printaFrase2(String frase) {
		super.printaFrase("Método B: " + frase);
	}
}