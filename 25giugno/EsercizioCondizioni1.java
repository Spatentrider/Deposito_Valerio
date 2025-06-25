import java.util.Scanner;

public class EsercizioCondizioni1 {
    public static void main(String[] args) {

        // Istanziazione della classe Scanner
        Scanner myObj = new Scanner(System.in);

        // Input dell'età
        System.out.println("Inserisci età: ");
        int età = myObj.nextInt();

        // Input biglietto
        System.out.println("Hai un biglietto? (true/false): ");
        boolean bigliettovalido = myObj.nextBoolean();

        // Input accompagnatore
        System.out.println("Sei accompagnato da un adulto? (true/false): ");
        boolean adultoaccompagnatore = myObj.nextBoolean();

        // Input salta la fila
        System.out.println("Hai acquistato il \"Salta la fila\"? (true/false): ");
        boolean saltafila = myObj.nextBoolean();

        // Condizipni
        if (bigliettovalido == true) {
            if (età < 14 && !adultoaccompagnatore) {
                System.out.println("Devi avere un accompagnatore");
            } else if (saltafila == true) {
                System.out.println("Accesso con saltafila consentito");
            } else {
                System.out.println("Accesso consentito");
            }
        } else {
            System.out.println("Entrata negata");
        }

        myObj.close();
    }
}



