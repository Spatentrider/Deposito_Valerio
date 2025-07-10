import java.util.Scanner;

public class EsercizioWhile {
    public static void main(String[] args) {

        // istanziazione classe Scanner
        Scanner Stringhe = new Scanner(System.in);

        // dichiarazione e istanziazione password e contatore
        String password = "java123";
        String passwordutente;
        int i = 0;
        boolean accesso = false;
        String inpututente;

        // controllo password tramite ciclo while
        while (i < 3) {
            System.out.println("Inserisci password: ");
            passwordutente = Stringhe.nextLine();

            if (password.equals(passwordutente)) {
                System.out.println("Password corretta");
                accesso = true;
                break;
            } else {
                System.out.println("Password errata");
                i++;
            }

            if (!accesso && i == 3) {
                System.out.println("Accesso negato");
            }
        }

        // controllo booleano accesso
        if (accesso) {
            do {
                //assegnazione di input utente tramite Scanner
                System.out.println("Vuoi accedere al sistema (s/n) ");
                inpututente = Stringhe.nextLine();
                
                //controllo input utente
                if (inpututente.equals("n")) {
                    System.out.println("Accesso annullato");
                    break;
                } else if (inpututente.equals("s")) {
                    System.out.println("Accesso al sistema effettuato");
                    break;
                }
            } while (true);
        }
    }
}
