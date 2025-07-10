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

            switch (tipo) {
                case "auto"://creazione Auto e chiamata metodi
                    VeicoloFactory factory = new AutoCreator();
                    factory.usaVeicolo(tipo);
                    break;
                case "moto"://creazione Moto e chiamata metodi
                    VeicoloFactory factory2 = new MotoCreator();
                    factory2.usaVeicolo(tipo);
                    break;
                case "camion"://creazione Camion e chiamata metodi
                    VeicoloFactory factory3 = new CamionCreator();
                    factory3.usaVeicolo(tipo);
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
    