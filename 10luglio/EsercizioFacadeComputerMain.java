import java.util.Scanner;

public class EsercizioFacadeComputerMain {
    public static void main(String[] args) {

        //scanner per input client della scelte
        Scanner scannerNumeri = new Scanner(System.in);
        int scelta;

        //ciclo do while con input utente
        do {
            System.out.println("1 Avvio normale, 2 per avvio rapido o 3 per interrompere avvio");

            scelta = scannerNumeri.nextInt();

            switch (scelta) {
                case 1://creazione oggetto facade con strategy AvvioNormale e chiamata strategy avvioNormale
                    ComputerFacade pcNormale = new ComputerFacade(new AvvioNormale());
                    pcNormale.accendiComputer();
                    return;
                case 2://creazione oggetto facade con strategy AvvioRapido e chiamata strategy avvioRapido
                    ComputerFacade pcRapido = new ComputerFacade(new AvvioRapido());
                    pcRapido.accendiComputer();
                    return;
                case 3://uscita dal programma
                    System.out.println("Interruzione avvio in corso");
                    return;
                default://stampa di errore
                    System.out.println("Scelta non valida");
                    break;
            }

        } while (true);
    }
}
    
