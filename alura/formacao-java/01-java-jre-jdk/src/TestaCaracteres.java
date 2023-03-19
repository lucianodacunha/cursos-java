
public class TestaCaracteres {
    public static void main(String[] args){

        char letra = 'B';
        System.out.println("Letra: " + letra);

        char valor = 67;
        System.out.println("Valor: " + valor);

        // 01-intro/src/TestaCaracteres.java:11: error: incompatible types: 
        // possible lossy conversion from int to char
        // valor = valor + 1;
        
        valor = (char) (valor + 1);
        System.out.println("Valor: " + valor);

        String linguagem = "Java";
        System.out.println("Palavra: " + linguagem);

        int anoAtual = 2023;
        System.out.println("Apredendo " + linguagem + " em " + anoAtual);

    }
}
