package aula11.lacosderepeticao;

public class Program {

	public static void main(String[] args) {
		int limit = 3;
		// for
		for(int i = 1; i <= limit; i++) {
			System.out.println("loop FOR " + i);
		}
		
		// while 
		while (limit > 0) {
			System.out.println("loop WHILE " + limit);
			limit--;
		}
		
		// do while
		do {
			limit++;			
			System.out.println("loop DO...WHILE " + limit);
		} while (limit < 3);
		
		// break
		for(int i = 1; i <= limit; i++) {
			if (i == 2)
				break;
			System.out.println("loop break: " + i);
		}
		
		// break
		for(int i = 1; i <= limit; i++) {
			if (i == 2)
				continue;
			System.out.println("loop continue: " + i);
		}		
		
	}

}
