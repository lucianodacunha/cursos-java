package aula15.excecoesecontroledeerros;

/**
 * Controlando exceptions
 * 
 * @author luciano
 *
 */
public class Program {

	public static void main(String[] args) {

		try {
			int rnd = (int) (1 + (Math.random() * 20));

			if (rnd > 10) {
				throw new MinhaRuntimeException(
						String.format("Valor excede o limite de 10: %d", rnd));
			} else if (rnd > 5) {
				throw new MinhaException(
						String.format("Valor excede o limite de 5: %d", rnd));
			} else {
				System.out.println("OK");
			}

		} catch (MinhaRuntimeException | MinhaException e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("Finalizando o programa");
		}
	}
}

// criando uma unchecked exception
class MinhaRuntimeException extends RuntimeException {

	public MinhaRuntimeException(String msg) {
		super(msg);
	}
}

//criando uma checked exception
class MinhaException extends Exception {

	public MinhaException(String msg) {
		super(msg);
	}
}
