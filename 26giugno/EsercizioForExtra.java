import java.util.Scanner;

public class EsercizioForExtra {
    public static void main(String[] args) {

        
        // dichiarazioni variabili
        int numerovoti, voto, votinonvalidi;
        String nome, controlloinput;

        votinonvalidi = 0;

        // istanziazione classi Scanner
        Scanner numeri = new Scanner(System.in);
        Scanner stringhe = new Scanner(System.in);

        while(true){
        // richiesta nominativo utente
        System.out.println("Inserire nome");
        nome = stringhe.nextLine();
        

        // richiesta input e assegnazione valore
        System.out.println("Quanti voti vuoi inserire?");
        numerovoti = numeri.nextInt();

        //ciclo while per controllo numeri positivi
        while (numerovoti <= 0) {
            System.out.println("Numero non valido");
            numerovoti = numeri.nextInt();
        }

        // ciclo for controllo voti
        for (int i = 0; i < numerovoti; i++) {
            //richiesta input e assegnazione variabile voto
            System.out.println("Inserisci il voto");
            voto = numeri.nextInt();
            //controllo if else voti
            if (voto < 18) {
                System.out.println("Insufficiente");
            } else if (voto >= 18 && voto < 24) {
                System.out.println("Sufficiente");
            } else if (voto <= 30) {
                System.out.println("Buono o Ottimo");
            } else { //se voto non valido aumento contatore votinonvalidi
                System.out.println("Voto non valido");
                votinonvalidi++;
            }
        }

        //stampa con calcolo voti inseriti
        System.out.println(nome + "Hai inserito " + (numerovoti - votinonvalidi) + " voti");
        //richiesta continuazione e assegnazione input
        System.out.println("Vuoi continuare (n o y)");
        controlloinput = stringhe.nextLine();
    }
}
    }
    
