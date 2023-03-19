
public class TestandoCondicionais {
    public static void main(String[] args){

        System.out.println("Verificando validade da  CNH: ");
        System.out.println("-----------------------------");
        
        int anoAtual = 2023;
        int ultimaRenovacao = 2017;
        int idade = 61;
        int periodoDeValidade; // anos

        if (idade > 60) {
            if (anoAtual > (ultimaRenovacao + 5)) {
                System.out.println("Sua CNH venceu!");
            } else {
                System.out.println("Sua CNH está dentro da validade!");
            }
        } else {
            if (anoAtual > (ultimaRenovacao + 10)) {
                System.out.println("Sua CNH venceu!");
            } else {
                System.out.println("Sua CNH está dentro da validade!");
            }
        }
    }
}