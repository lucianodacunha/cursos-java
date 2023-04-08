package aula11.threads;

public class Program {

	static int i = 0;

	public static void main(String[] args) {
		new Thread(t1).start();
		new Thread(t2).start();

	}

	static void counter(String name) {
		i++;
		System.out.printf("The current value i is %d thread %s\n", i, name);
	}

	static Runnable t1 = new Runnable() {

		@Override
		public void run() {
			for (int i = 0; i < 5; i++) {
				counter("t1");
			}

		}
	};

	static Runnable t2 = new Runnable() {

		@Override
		public void run() {
			for (int i = 0; i < 5; i++) {
				counter("t2");
			}

		}
	};

}
