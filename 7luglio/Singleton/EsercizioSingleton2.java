import java.util.Scanner;

class DatabaseManager{
    
    private static DatabaseManager istanza;

    private static int connectioncount = 0;

    public static int getConnectionCount() {
        return connectioncount;
    }

    private DatabaseManager() {}

     public static DatabaseManager getIstanza() {
        if (istanza == null) {
            istanza = new DatabaseManager();

        }
        return istanza;
    }

     // Metodo per scrivere un messaggio
    public void connect() {
        connectioncount++;
        System.out.println("Connessione stabilita. Connessioni attive: " + getConnectionCount());
    }

    public static void resetIstanza() {
        istanza = null;
        connectioncount--;
        System.out.println("Istanza distrutta. Connessioni attive: " + getConnectionCount());
    }



}

public class EsercizioSingleton2 {
    public static void main(String[] args) {

        DatabaseManager db1 = DatabaseManager.getIstanza();
        db1.connect();

        System.out.println(DatabaseManager.getConnectionCount());
        DatabaseManager db2 = DatabaseManager.getIstanza();
        db2.connect();

        DatabaseManager.getConnectionCount();

        // Verifica che sia la stessa istanza
        if (db1.equals(db2)) {
            System.out.println("Le istanze sono uguali");
        } else {
            System.out.println("Le istanze sono diverse");
        }

        System.out.println(DatabaseManager.getConnectionCount());

        Scanner scanner = new Scanner(System.in);
        int scelta;

        do {
            System.out.println("Inserisci 1 per creare nuova connessione utente , 2 cancellare utente o 3 per uscire");
            scelta = scanner.nextInt();
            switch (scelta) {
                case 1:
                    DatabaseManager db = DatabaseManager.getIstanza();
                    db.connect();
                    break;

                case 2:
                    DatabaseManager.resetIstanza();
                    break;

                case 3:
                    System.out.println("Uscita dal programma.");
                    break;

                default:
                    System.out.println("Scelta non valida.");
            }

        } while (scelta != 3);
    }

        
    }
    

