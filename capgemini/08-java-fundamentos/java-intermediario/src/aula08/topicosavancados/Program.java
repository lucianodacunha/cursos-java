package aula08.topicosavancados;

public class Program {

	public static void main(String[] args) {
		// Classes Wrapper
		Integer i = 10;
		Double d = 10.0;
		Float f = 10f;
		Character c = 'c';
		
		// Conversões
		String s = i.toString();
		System.out.printf("Valor %s, classe: %s\n", s, s.getClass());
		System.out.printf("Valor %s, classe: %s\n", i, i.getClass());
		System.out.printf("Valor %s, classe: %s\n", d, d.getClass());
		System.out.printf("Valor %s, classe: %s\n", c, c.getClass());
		
	}

}
