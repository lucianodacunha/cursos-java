

public class TestaForEncadeado {
    public static void main(String[] args){

        for (int multiplicador = 1; multiplicador <= 10; multiplicador++) {
            for(int multiplicando = 0; multiplicando <= 10; multiplicando++){
                System.out.print((multiplicador * multiplicando) + " ");
            }
            System.out.println();
        }

    }
}