package io.github.lucianodacunha.main.cap05.test;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;

public class Program {

	public static void main(String[] args) {
		Collection<Integer> nLinked = new LinkedList<Integer>();
		Collection<Integer> nHash = new HashSet<Integer>();
		
		long addTimeLinked = add(nLinked);
		long addTimeArray = add(nHash);
		
		System.out.printf("Add -> Tempo com linked: %d, Tempo com hash: %d\n",
				addTimeLinked, addTimeArray);		

		long removeTimeLinked = remove(nLinked);
		long removeTimeHash = remove(nHash);
		
		System.out.printf("Remove -> Tempo com linked: %d, Tempo com hash: %d\n",
				removeTimeLinked, removeTimeHash);		
	}
	
	static long add(Collection<Integer> n) {
		long limit = 100000;
		
		long ini = System.currentTimeMillis();
		
		for(int i = 0; i < limit; i++) {
			n.add(i);
		} 
		
		long fim = System.currentTimeMillis();
		
		return fim - ini;
	}
	
	static long remove(Collection<Integer> n) {
		long limit = 100000;
		
		long ini = System.currentTimeMillis();
		
		for(int i = 0; i < limit; i++) {
			n.remove(0);
		} 
		
		long fim = System.currentTimeMillis();
		
		return fim - ini;
	}
	
}
