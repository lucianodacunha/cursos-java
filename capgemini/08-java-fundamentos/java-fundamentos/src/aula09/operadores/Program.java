package aula09.operadores;

public class Program {

	public static void main(String[] args) {
		double num1 = 13.0;
		double num2 = 5.0;
		double result;
		
		// aritméticos
		result = num1 + num2;		
		System.out.println("num1 + num2: " + result);
		result = num1 - num2;
		System.out.println("num1 - num2: " + result);
		result = num1 * num2;
		System.out.println("num1 * num2: " + result);
		result = num1 / num2;
		System.out.println("num1 / num2: " + result);
		result = num1 % num2;
		System.out.println("num1 % num2: " + result);		

		// incremento, decremento
		result = ++num1 + ++num2;
		System.out.println("++num1 + ++num2: " + result);
		
		// relacionais
		System.out.println("num1 == num2: " + (num1 == num2));
		System.out.println("num1 != num2: " + (num1 != num2));
		
		System.out.println("num1 > num2: " + (num1 > num2));
		System.out.println("num1 < num2: " + (num1 < num2));
		
		// lógícos
		System.out.println("num1 > num2 || num1 < num2: " + ((num1 > num2) || (num1 < num2)));
		System.out.println("num1 > num2 || num1 < num2: " + ((num1 > num2) && (num1 == num2)));
	}

}
