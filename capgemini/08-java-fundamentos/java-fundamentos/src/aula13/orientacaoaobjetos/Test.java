package aula13.orientacaoaobjetos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		Conta conta1 = new Conta(1);
		Conta conta2 = new Conta(2);
		List<Conta> contas = new ArrayList<>();
		contas.add(conta2);
		contas.add(conta1);		
		
		contas.forEach(conta -> {System.out.println(conta);});
		Collections.sort(contas);
		contas.forEach(conta -> {System.out.println(conta);});
	}
}

class Conta implements Comparable<Conta> {
	int numero;

	public Conta(int n) {
		this.numero = n;
	}

	@Override
	public int compareTo(Conta o) {
		return this.numero - o.numero;
	}
	
	@Override
	public String toString() {	
		return "Conta " + numero;
	}
}
