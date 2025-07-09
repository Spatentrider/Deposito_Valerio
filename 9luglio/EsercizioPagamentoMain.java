import java.util.Scanner;

public class EsercizioPagamentoMain {

    public static void main(String[] args) {


    //Scanner per numeri e stringhe 
     Scanner scannerNumeri = new Scanner(System.in);
     Scanner scannerTesto = new Scanner(System.in);   

        //creazione oggetto PagamentoContext
        PagamentoContext context = PagamentoContext.getInstance();

        int scelta;
        //ciclo do while per prendere input utente
        do {
            System.out.println("1. Imposta metodo: Carta di Credito 2. Imposta metodo: Paypal 3 Esegui pagamento 4. Aggiungi cliente o 0 per uscire");

            scelta = scannerNumeri.nextInt();

            switch (scelta) {
                case 1:
                    //settatoMetodoPagamento a Strategy Carta di Credito
                    context.setMetodoPagamento(new CartadiCredito());
                    System.out.println("Metodo impostato: Carta di Credito");
                    break;
                case 2:
                     //settatoMetodoPagamento a Strategy PayPal
                    context.setMetodoPagamento(new Paypal());
                    System.out.println("Metodo impostato: Paypal");
                    break;
                case 3:
                    //chiamata strategy con input utente
                    System.out.print("Inserisci importo da pagare: ");
                    double importo = scannerNumeri.nextDouble();
                    context.performTask(importo);
                    break;
                case 4:
                    //creazione classe Clienti e aggiunta nella lista si context
                    System.out.print("Inserisci il nome del nuovo cliente: ");
                    String nomeCliente = scannerTesto.nextLine();
                    Clienti nuovoCliente = new Clienti(nomeCliente);
                    context.aggiungiClienti(nuovoCliente);
                    System.out.println("Cliente aggiunto con successo.");
                    break;
                case 0:
                    System.out.println("Uscita...");
                    break;
                default:
                    System.out.println("Scelta non valida!");
            }

        } while (scelta != 0);
    }
}
