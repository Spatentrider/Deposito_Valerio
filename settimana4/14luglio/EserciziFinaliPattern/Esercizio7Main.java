import java.util.Scanner;

public class Esercizio7Main {

    public static void main(String[] args) {
        //creazione oggetti Scanner, testo con testo default e context
        Scanner scanner = new Scanner(System.in);
        ComponenteTesto testo = new TestoSemplice("Hello World");
        EditorTesto editor = new EditorTesto(testo);

        boolean continua = true;

        //ciclo per prendere inpiut utente e fargli scegliere operazioni
        do {
            System.out.println("--- MENU EDITOR TESTO ---");
            System.out.println("1 - Inserisci nuovo testo");
            System.out.println("2 - Aggiungi decorazione Grassetto");
            System.out.println("3 - Aggiungi decorazione Corsivo");
            System.out.println("4 - Aggiungi decorazione Sottolineato");
            System.out.println("5 - Mostra testo");
            System.out.println("6 - Imposta salvataggio Locale");
            System.out.println("7 - Imposta salvataggio Cloud");
            System.out.println("8 - Imposta salvataggio Criptato");
            System.out.println("9 - Salva testo");
            System.out.println("0 - Esci");
            System.out.print("Scegli opzione: ");

            int scelta = scanner.nextInt();
            scanner.nextLine();

            switch (scelta) {
                //creazione nuovo testo base
                case 1:
                    System.out.print("Inserisci il nuovo testo: ");
                    String nuovoTesto = scanner.nextLine();
                    testo = new TestoSemplice(nuovoTesto);
                    editor.impostaComponenteTesto(testo);
                    System.out.println("Nuovo testo impostato.");
                    break;
                    //aggiunta DecoratoreGrassetto a testo base
                case 2:
                    testo = new DecoratoreGrassetto(testo);
                    editor.impostaComponenteTesto(testo);
                    System.out.println("Decorazione Grassetto applicata.");
                    break;
                     //aggiunta DecoratoreCorsivo a testo base
                case 3:
                    testo = new DecoratoreCorsivo(testo);
                    editor.impostaComponenteTesto(testo);
                    System.out.println("Decorazione Corsivo applicata.");
                    break;
                     //aggiunta DecoratoreSottolineato a testo base
                case 4:
                    testo = new DecoratoreSottolineato(testo);
                    editor.impostaComponenteTesto(testo);
                    System.out.println("Decorazione Sottolineato applicata.");
                    break;
                case 5:
                //metodo stampa testo
                    editor.mostraTesto();
                    break;
                case 6:
                //cambiata strategia a SalvataggioLocale
                    editor.impostaStrategiaSalvataggio(new SalvataggioLocale());
                    System.out.println("Strategia salvataggio impostata su Locale.");
                    break;
                case 7:
                  //cambiata strategia a Salvataggioloud
                    editor.impostaStrategiaSalvataggio(new SalvataggioCloud());
                    System.out.println("Strategia salvataggio impostata su Cloud.");
                    break;
                case 8:
                  //cambiata strategia a SalvataggioCriptato
                    editor.impostaStrategiaSalvataggio(new SalvataggioCriptato());
                    System.out.println("Strategia salvataggio impostata su Criptato.");
                    break;
                case 9:
                    //chiamata metodo strategy
                    editor.salvaTesto();
                    break;
                case 0:
                    //impostato booleano false per uscire da ciclo
                    System.out.println("Uscita dal programma.");
                    continua = false;
                    break;
                default:
                    System.out.println("Opzione non valida, riprova.");
            }

        } while (continua);

    }
}
