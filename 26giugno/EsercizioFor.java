import java.util.Scanner;

public class EsercizioFor {
    public static void main(String[] args) {

        // dichiarazioni variabili
        int numerovoti, voto, votinonvalidi;

        votinonvalidi = 0;

        // istanziazione classe Scanner
        Scanner scanner = new Scanner(System.in);

        // richiesta input e assegnazione valore
        System.out.println("Quanti voti vuoi inserire?");
        numerovoti = scanner.nextInt();

        //ciclo while per controllo numeri positivi
        while (numerovoti <= 0) {
            System.out.println("Numero non valido");
            numerovoti = scanner.nextInt();
        }

        // ciclo for controllo voti
        for (int i = 0; i < numerovoti; i++) {
            //richiesta input e assegnazione variabile voto
            System.out.println("Inserisci il voto");
            voto = scanner.nextInt();
            //controllo if else voti
            if (voto < 18) {
                System.out.println("Insufficiente");
            } else if (voto >= 18 && voto < 24) {
                System.out.println("Sufficiente");
            } else if (voto < 30) {
                System.out.println("Buono");
            }
            else if(voto == 30){
                System.out.println("Ottimo");
            } else { //se voto non valido aumento contatore votinonvalidi
                System.out.println("Voto non valido");
                votinonvalidi++;
            }
        }

        //stampa con calcolo voti inseriti
        System.out.println("Inseriti " + (numerovoti - votinonvalidi) + " voti");
    }
}
