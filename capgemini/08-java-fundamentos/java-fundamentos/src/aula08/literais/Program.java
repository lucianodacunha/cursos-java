package aula08.literais;

public class Program {

	public static void main(String[] args) {
		String palavra = "Hello";
		int inteiro = 10;
		long inteiro2 = 10l;
		float decimal1 = 10f;
		double decimal2 = 10d;
		char caracter = '\u004E';
		boolean logico = true;
		
		System.out.printf(
				"palavra: %s\n" + 
				"int: %d\n" +
				"long: %d\n" +
				"float: %.2f\n" + 
				"double: %.2f\n" + 
				"char: %s\n" +
				"boolean: %s\n",
				palavra, inteiro, inteiro2, decimal1, decimal2, caracter, logico);

	}
}