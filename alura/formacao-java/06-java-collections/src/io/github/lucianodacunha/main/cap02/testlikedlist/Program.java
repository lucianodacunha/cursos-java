package io.github.lucianodacunha.main.cap02.testlikedlist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Program {

	public static void main(String[] args) {
		List<Integer> nLinked = new LinkedList<Integer>();
		List<Integer> nArray = new ArrayList<Integer>();
		
		long addTimeLinked = add(nLinked);
		long addTimeArray = add(nArray);
		
		System.out.printf("Add -> Tempo com linked: %d, Tempo com array: %d\n",
				addTimeLinked, addTimeArray);		

		long removeTimeLinked = remove(nLinked);
		long removeTimeArray = remove(nArray);
		
		System.out.printf("Remove -> Tempo com linked: %d, Tempo com array: %d\n",
				removeTimeLinked, removeTimeArray);
		
		
	}
	
	static long add(List<Integer> n) {
		long limit = 1000000;
		
		long ini = System.currentTimeMillis();
		
		for(int i = 0; i < limit; i++) {
			n.add(i);
		} 
		
		long fim = System.currentTimeMillis();
		
		return fim - ini;
	}
	
	static long remove(List<Integer> n) {
		long limit = 1000000;
		
		long ini = System.currentTimeMillis();
		
		for(int i = 0; i < limit; i++) {
			n.remove(0);
		} 
		
		long fim = System.currentTimeMillis();
		
		return fim - ini;
	}
	
}
