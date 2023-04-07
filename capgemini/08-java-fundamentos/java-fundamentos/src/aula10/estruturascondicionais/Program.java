package aula10.estruturascondicionais;

public class Program {

	public static void main(String[] args) {
		int num1 = (int) (1 + (Math.random() * 10));
		int num2 = (int) (1 + (Math.random() * 10));
		int num3 = (int) (1 + (Math.random() * 10));

		System.out.printf("num1: %d, num2: %d, num3: %d\n", num1, num2, num3);

		// condicionais com if
		if (num1 > num2) {
			if (num1 > num3) {
				System.out.printf("1: num1: %d, num2: %d, num3: %d\n", num1, num2, num3);
			} else {
				System.out.println("Exiting 1");
			}
		} else if (num2 > num1) {
			if (num2 > num3) {
				System.out.printf("2: num1: %d, num2: %d, num3: %d\n", num1, num2, num3);
			} else {
				System.out.println("Exiting 2");
			}
		} else {
			System.out.printf("3: num1: %d, num2: %d, num3: %d\n", num1, num2, num3);
		}

		// switch
		int randNum = (int) (1 + (Math.random() * 10));
		System.out.printf("Valor %d\n", randNum);

		switch (randNum) {
		case 1:
			System.out.printf("1: Valor %d\n", randNum);
			break;
		case 2:
			System.out.printf("2: Valor %d\n", randNum);
			break;
		case 3:
			System.out.printf("3: Valor %d\n", randNum);
			break;
		default:
			System.out.printf("Outro Valor %d\n", randNum);
		}
	}
}
