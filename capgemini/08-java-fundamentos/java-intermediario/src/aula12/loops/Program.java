package aula12.loops;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Program {

	public static void main(String[] args) {
		
		int[] i = new int[] {1,2,3,4,5};
		
		for(Integer n : i)
			System.out.println(n);
		
		List<Integer> l = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));		
		l.forEach(t -> {System.out.println(t);});
	}
}
