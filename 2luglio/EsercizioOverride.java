import java.util.ArrayList;
import java.util.Scanner;

// Classe Camera
class Camera {
    // Attributi protetti
    protected int numero;
    protected float prezzo;

    // Costruttore con parametri
    Camera(int numero, float prezzo) {
        this.numero = numero;
        this.prezzo = prezzo;
    }

    // Getter e Setter
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    // Metodo dettagli - versione base
    public void dettagli() {
        System.out.println("Camera n°" + numero + " - Prezzo: " + prezzo + "€");
    }

    // Overload del metodo dettagli con parametro booleano
    public void dettagli(boolean conPrezzo) {
        if (conPrezzo) {
            System.out.println("Camera n°" + numero + " - Prezzo: " + prezzo + "€");
        } else {
            System.out.println("Camera n°" + numero);
        }
    }
}

// Classe derivata Suite
class Suite extends Camera {
    // Attributo aggiuntivo
    private String serviziextra;

    // Costruttore con super
    Suite(int numero, float prezzo, String serviziextra) {
        super(numero, prezzo);
        this.serviziextra = serviziextra;
    }

    public String getServiziExtra() {
        return serviziextra;
    }

    // Corretto il setter (accetta parametro!)
    public void setServiziExtra(String serviziextra) {
        this.serviziextra = serviziextra;
    }

    // Override del metodo dettagli per includere i servizi extra
    @Override
    public void dettagli() {
        System.out.println("Suite n°" + numero + " - Prezzo: " + prezzo + "€ - Servizi extra: " + serviziextra);
    }
}

// Classe contenitore Hotel
class Hotel {
    private String nome;
    private ArrayList<Camera> camere;

    // Costruttore
    Hotel(String nome) {
        this.nome = nome;
        this.camere = new ArrayList<>();
    }

    public void aggiungiCamera(Camera camera) {
        camere.add(camera);
    }

    public ArrayList<Camera> getCamere() {
        return camere;
    }

    // Mostra tutte le camere registrate
    public void mostraCamere() {
        System.out.println("\n=== Camere presenti in hotel " + nome + " ===");
        for (Camera camera : camere) {
            camera.dettagli(); // Polimorfismo: chiama override o base in base al tipo
        }
    }

    // Metodo statico per contare le suite
    public static int contaSuite(ArrayList<Camera> camere) {
        int count = 0;
        for (Camera camera : camere) {
            if (camera instanceof Suite) {
                count++;
            }
        }
        return count;
    }
}

// Classe principale
public class EsercizioOverride {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Hotel hotel = new Hotel("Hilton");

        // Inizializzazione camere e suite
        hotel.aggiungiCamera(new Camera(101, 80.5f));
        hotel.aggiungiCamera(new Camera(102, 75.0f));
        hotel.aggiungiCamera(new Suite(201, 150.0f, "Jacuzzi"));
        hotel.aggiungiCamera(new Suite(202, 180.0f, "Spa"));

        // Prima stampa iniziale
        hotel.mostraCamere();

        // Uso dei vari overload e override
        System.out.println("\n=== Dettagli specifici ===");
        hotel.getCamere().get(0).dettagli();          // base
        hotel.getCamere().get(1).dettagli(false);      // overload
        hotel.getCamere().get(2).dettagli();           // override
        hotel.getCamere().get(3).dettagli(true);       // overload

        // Conteggio delle suite
        int numeroSuite = Hotel.contaSuite(hotel.getCamere());
        System.out.println("\nNumero di suite in hotel: " + numeroSuite);

        // Loop per inserimento da parte utente
        String input;
        do {
            System.out.println("\nVuoi aggiungere una nuova camera?");
            System.out.print("Digita 1 per Camera, 2 per Suite: ");
            int scelta = Integer.parseInt(scanner.nextLine());

            switch (scelta) {
                case 1:
                    System.out.print("Numero camera: ");
                    int numero = Integer.parseInt(scanner.nextLine());
                    System.out.print("Prezzo: ");
                    float prezzo = Float.parseFloat(scanner.nextLine());
                    hotel.aggiungiCamera(new Camera(numero, prezzo));
                    System.out.println("✓ Camera aggiunta");
                    break;
                case 2:
                    System.out.print("Numero suite: ");
                    int numero2 = Integer.parseInt(scanner.nextLine());
                    System.out.print("Prezzo: ");
                    float prezzo2 = Float.parseFloat(scanner.nextLine());
                    System.out.print("Servizi extra: ");
                    String servizi = scanner.nextLine();
                    hotel.aggiungiCamera(new Suite(numero2, prezzo2, servizi));
                    System.out.println("✓ Suite aggiunta");
                    break;
                default:
                    System.out.println("⚠ Comando non valido.");
            }

            System.out.print("Vuoi continuare? (si/no): ");
            input = scanner.nextLine().toLowerCase();

        } while (!input.equals("no"));

        // Stampa finale
        hotel.mostraCamere();
        scanner.close();
    }
}

