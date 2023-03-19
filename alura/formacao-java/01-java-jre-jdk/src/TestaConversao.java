
public class TestaConversao {

    public static void main(String[] args){
        double salario = 7240.40;
        
        // 01-intro/src/TestaConversao.java:6: error: incompatible types: 
        // possible lossy conversion from double to int
        // int valor = salario;
        
        int inteiro = (int) salario;
        System.out.println("Valor de inteiro: " + inteiro);
        // Saída: Valor de inteiro: 7240

        float pontoFlutuante = 3.14f;
        System.out.println("Valor de ponto flutuante: " + pontoFlutuante);

    }
}