

public class TestaEscopo {
    public static void main(String[] args) {
        System.out.println("Testando Escopo: ");
        System.out.println("----------------");

        int anoAtual = 2023;

/**
        if (anoAtual <= 2023) {
            boolean prazoVigente = true;            
        } else {
            boolean prazoVigente = false;            
        }

        if (prazoVigente){
            System.out.println("Prazo Vigente");
        } else {
            System.out.println("Acabou o prazo");
        }

        Erro:
        01-intro/src/TestaEscopo.java:16: error: cannot find symbol
        if (prazoVigente){
            ^
        symbol:   variable prazoVigente
        location: class TestaEscopo
        01-intro/src/TestaEscopo.java:16: error: illegal parenthesized expression
                if (prazoVigente){
                ^
*/

        boolean prazoVigente;            
        if (anoAtual <= 2023) {
            prazoVigente = true;
        } else {
            prazoVigente = false;            
        }

        if (prazoVigente){
            System.out.println("Prazo Vigente");
        } else {
            System.out.println("Acabou o prazo");
        }


    }
}