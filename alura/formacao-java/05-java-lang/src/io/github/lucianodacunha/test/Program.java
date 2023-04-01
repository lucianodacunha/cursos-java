package io.github.lucianodacunha.test;

import java.io.PrintStream;

/**
 * Testando métodos da classe String e System.out.println
 * 
 * @author luciano
 *
 */
public class Program {
	public static void main(String[] args) {
		
		testString();
		testSystem();
	}

	static void testSystem() {
	
		PrintStream out = System.out;
		out.println("Imprimindo com PrintStream");
	}

	static void testString() {
		String ide = "Eclipse";
		System.out.println(ide);
		
		// replace
		System.out.println(ide.replace('i', '1'));
		
		// toLowerCase
		System.out.println(ide.toLowerCase());
		
		String ide2 = "";
		
		// charAt, valueOf, toUpperCase
		for (int i = 0; i < 3; i++) {
			int posicao = (int)(1 + (Math.random() * (ide.length() - 1)));
			Character c = String.valueOf(ide.charAt(posicao)).toUpperCase().charAt(0);
			ide2 += c;
			ide2 += ";";
		}
		
		// trim
		System.out.println(ide2.trim());
		
		// contains
		System.out.println(ide2.contains("E"));		 
		
		// split
		String[] strings = ide2.split(";");
		for(int i = 0; i < strings.length; i++)
			System.out.printf("%d: %s\n", i, strings[i]);
	}
}
