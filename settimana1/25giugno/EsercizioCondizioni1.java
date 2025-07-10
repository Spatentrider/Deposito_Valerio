import java.util.Scanner;

public class EsercizioCondizioni1 {
    public static void main(String[] args) {

        // istanziazione classe Scanner
        Scanner myObj = new Scanner(System.in);

        // input dell'età
        System.out.println("Inserisci età: ");
        int età = myObj.nextInt();

        // input biglietto
        System.out.println("Hai un biglietto? (true/false): ");
        boolean bigliettovalido = myObj.nextBoolean();

        // input accompagnatore
        System.out.println("Sei accompagnato da un adulto? (true/false): ");
        boolean adultoaccompagnatore = myObj.nextBoolean();

        // input salta la fila
        System.out.println("Hai acquistato il \"Salta la fila\"? (true/false): ");
        boolean saltafila = myObj.nextBoolean();

        // controllo se il biglietto è valido
        if (bigliettovalido == true) {
            // controllo che l'utente ha meno di 14 anni e non è accompagnato da un adulto
            if (età < 14 && !adultoaccompagnatore) {
                System.out.println("Devi avere un accompagnatore");
            } // controllo che l'utente ha acquistato il Salta la fila
             else if (saltafila == true) {
                System.out.println("Accesso con saltafila consentito");
            } else //accesso normale
             {
                System.out.println("Accesso consentito");
            }
        } else {
            System.out.println("Accesso negato");
        }
    }
}



