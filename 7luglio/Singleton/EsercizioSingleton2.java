import java.util.Scanner;

class DatabaseManager{
    
    // Istanza privata statica
    private static DatabaseManager istanza;

    //contatore delle connessioni statico
    private static int connectioncount = 0;

    //getter connessioni
    public static int getConnectionCount() {
        return connectioncount;
    }

    // Costruttore privato per impedire l'istanziazione diretta
    private DatabaseManager() {}

    //Metodo statico per creare istanza se non presente o tornare sempre la stessa
     public static DatabaseManager getIstanza() {
        if (istanza == null) {
            istanza = new DatabaseManager();

        }
        return istanza;
    }
    //Istanziazione primo oggetto e metodo di simulazione connessione a database
    public void connect() {
        //aumento contatore connessioni
        connectioncount++;
        System.out.println("Connessione stabilita. Connessioni attive: " + getConnectionCount());
    }

    //metodo per cancellare istanza
    public static void resetIstanza() {
        istanza = null;
        //diminuzione contatore connessini e stampa
        connectioncount--;
        System.out.println("Istanza distrutta. Connessioni attive: " + getConnectionCount());
    }



}

public class EsercizioSingleton2 {
    public static void main(String[] args) {

        //Istanziazione primo oggetto e metodo di simulazione connessione a database
        DatabaseManager db1 = DatabaseManager.getIstanza();
        db1.connect();

        //stampa contatore connessioni
        DatabaseManager.getConnectionCount();
        //Istanziazione primo oggetto e metodo di simulazione connessione a database
        DatabaseManager db2 = DatabaseManager.getIstanza();
        db2.connect();

        //stampa contatore connessioni
        DatabaseManager.getConnectionCount();

        // Verifica che sia la stessa istanza
        if (db1.equals(db2)) {
            System.out.println("Le istanze sono uguali");
        } else {
            System.out.println("Le istanze sono diverse");
        }

        
        
        //creazione Oggetto scanner e variabile per salvare input utente
        Scanner scanner = new Scanner(System.in);
        int scelta;

        //ciclo do while per prendere input utente
        do {
            System.out.println("Inserisci 1 per creare nuova connessione utente , 2 cancellare utente o 3 per uscire");
            scelta = scanner.nextInt();
            //switch per effettuare le varie scelte
            switch (scelta) {
                case 1://creazione istanza e chiamata metodo simulazione connessione database
                    DatabaseManager db = DatabaseManager.getIstanza();
                    db.connect();
                    break;

                case 2:
                    //chiamata metodo per cancellare istanza
                    DatabaseManager.resetIstanza();
                    break;

                case 3://scelta per uscire dal ciclo
                    System.out.println("Uscita dal programma.");
                    break;

                default://errore di stampa
                    System.out.println("Scelta non valida.");
            }

        } while (scelta != 3);
    }
    }
    

