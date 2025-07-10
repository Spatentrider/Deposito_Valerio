import java.util.Scanner;

public class MenuFacade {
    private Scanner scannerNumeri;
    private Scanner scannerTesto;

    public MenuFacade() {
        scannerNumeri = new Scanner(System.in);
        scannerTesto = new Scanner(System.in);
    }

    public void startMenu() {
        int scelta;

        do {
            System.out.println("1. Imposta metodo: Carta di Credito");

            System.out.print("Inserisci la tua scelta: ");
            scelta = scannerNumeri.nextInt();

            switch (scelta) {
                case 1:
                    
                    System.out.println("Metodo impostato: Carta di Credito");
                    break;
                case 2:
                    
                    System.out.println("Metodo impostato: Paypal");
                    break;
                case 3:
                    System.out.print("Inserisci importo da pagare: ");
                    break;
                case 4:
                    System.out.print("Inserisci il nome del nuovo cliente: ");
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
