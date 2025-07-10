public class MainEsercizioDecorator {
    public static void main(String[] args) {

        //creazione oggetto da decorare
        Messaggio messaggio = new ImplementaMessaggio();
        //creazione oggetto Decoratore con oggetto da decorare passato come argomento
        Messaggio messaggioDecorato = new ConcreteDecoratoreMaiuscolo(messaggio);

        //stampa metodo oggetto da decorare
        System.out.println("Messaggio originale: " + messaggio.getContenuto());
        //stampa metodo oggetto decorato
        System.out.println("Messaggio decorato: " + messaggioDecorato.getContenuto());
    }
        
    }
    

