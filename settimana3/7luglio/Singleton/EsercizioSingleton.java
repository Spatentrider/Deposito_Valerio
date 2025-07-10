

class Logger2{

    // Istanza privata statica
    private static Logger2 istanza;

    // Costruttore privato per impedire l'istanziazione diretta
    private Logger2() {}

    // Metodo statico per creare istanza se non presente o tornare sempre la stessa
    public static Logger2 getIstanza() {
        if (istanza == null) {
            istanza = new Logger2();
        }
        return istanza;
    }

    // Metodo per scrivere un messaggio
    public void scriviMessaggio(String messaggio) {
       
        System.out.println(messaggio);
    }

}

public class EsercizioSingleton {
    
    public static void main(String[] args) {
        // Primo punto del codice
        Logger2 logger1 = Logger2.getIstanza();
        logger1.scriviMessaggio("Data: 07/07/2025, Ora: 16:10");

        // Secondo punto del codice
        Logger2 logger2 = Logger2.getIstanza();
        logger2.scriviMessaggio("Data: 05/07/2025, Ora: 10:45");

        // Verifica che sia la stessa istanza
        if (logger1.equals(logger2)) {
            System.out.println("Le istanze sono uguali");
        } else {
            System.out.println("Le istanze sono diverse");
        }
        
    }
}
