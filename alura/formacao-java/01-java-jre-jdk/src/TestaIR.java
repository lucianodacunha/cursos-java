

public class TestaIR {
    public static void main(String[] args){

        double salarioBruto = 3000;
        double salarioLiquido;
        double percentualDeImposto = 0.0;
        double impostoAPagar = 0.0;
        double deducao = 0.0;

        if (salarioBruto >= 1900.0 && salarioBruto <= 2800.0){
            percentualDeImposto = 0.075;
            deducao = 142.0;
        } else {
            if (salarioBruto > 2800.0 && salarioBruto <= 3751.0){
                percentualDeImposto = 0.15;
                deducao = 350.0;
            } else {
                if (salarioBruto > 3751.0 && salarioBruto <= 4664.0){
                    percentualDeImposto = 0.225;
                    deducao = 636.0;
                }
            }
        }

        impostoAPagar = (salarioBruto * percentualDeImposto) - deducao;
        salarioLiquido = salarioBruto - impostoAPagar;
        
        System.out.println("Salário Bruto: " + salarioBruto);
        System.out.println("% de imposto: " + percentualDeImposto);
        System.out.println(
            "Valor de imposto inicial: " + (salarioBruto * percentualDeImposto));
        System.out.println("Valor da dedução permitida: " + deducao);
        System.out.println("Valor do imposto a pagar: " + impostoAPagar);
        System.out.println("Salário Líquido: " + salarioLiquido);
            
    }
}