
/**
* Testa condicionais com operadores booleanos
*/
public class TestandoCondicionais2 {
    public static void main(String[] args){

        System.out.println("Verificando validade da CNH: ");
        System.out.println("----------------------------");
        
        int anoAtual = 2023;
        int ultimaRenovacao = 2011;
        int idade = 60;
        int periodoDeValidade; // anos

        if (idade > 60 && (anoAtual > (ultimaRenovacao + 5))) {
            System.out.println("Sua CNH venceu! 1");
        } else {
            if (idade > 60 && (anoAtual <= (ultimaRenovacao + 5))) {
                    System.out.println("Sua CNH está dentro da validade! 1");
            } else {
                if (anoAtual > (ultimaRenovacao + 10)) {
                    System.out.println("Sua CNH venceu! 2");
                } else {
                    System.out.println("Sua CNH está dentro da validade! 2");
                }
            }
        }
    }
}