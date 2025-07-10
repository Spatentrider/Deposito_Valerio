import java.util.Scanner;

public class EsercizioFactoryMethodMain {
    public static void main(String[] args) {
        //scanner
        Scanner scanner = new Scanner(System.in);
        String tipo;

        //ciclo do while input utente
        do {
            System.out.print("Inserisci tipo veicolo (auto, moto, camion) o 'esci' per terminare: ");
            tipo = scanner.nextLine();

            //creazione oggetto factory
            VeicoloFactory factory = null;

            switch (tipo) {
                case "auto"://creazione Auto e chiamata metodi
                    factory = new AutoCreator();
                    factory.usaVeicolo(tipo);
                    break;
                case "moto"://creazione Moto e chiamata metodi
                    factory = new MotoCreator();
                    factory.usaVeicolo(tipo);
                    break;
                case "camion"://creazione Camion e chiamata metodi
                    factory = new CamionCreator();
                    factory.usaVeicolo(tipo);
                    break;
                case "esci":
                    System.out.println("Uscita dal programma");
                    break;
                default:
                    System.out.println("Tipo di veicolo non riconosciuto.");
                    continue;
            }

        } while (true);
    }
    }
    