import java.util.ArrayList;
import java.util.Scanner;
// Classe astratta VeicoloConsegna
abstract class VeicoloConsegna {
    //attributi protetti
    protected String targa;
    protected float caricoMassimo;

    //costruttore con parametro
    public VeicoloConsegna(String targa, float caricoMassimo) {
        this.targa = targa;
        this.caricoMassimo = caricoMassimo;
    }

    //metodo astratto di consegna
    public abstract void consegnaPacco(String destinazione);

    //metodo concreto di stampa
    public void stampaInfo() {
        System.out.println("Targa: " + targa + " | Carico massimo: " + caricoMassimo + " kg");
    }
}

// Interfaccia Tracciabile
interface Tracciabile {
    //metodo vuoto di tracciaConsegna
    void tracciaConsegna(String codiceTracking);
}

// Classe Furgone che eredita VeicoloConsegna e implemente interfaccia Tracciabile
class Furgone extends VeicoloConsegna implements Tracciabile {
    //costruttore con metodo super
    public Furgone(String targa, float caricoMassimo) {
        super(targa, caricoMassimo);
    }

    //definizione del metodo abstract consegna pacco
    public void consegnaPacco(String destinazione) {
        System.out.println("Furgone " + targa + " via terra sta consegnando a " + destinazione);
    }

    //definizione del metodo tracciaConsegna
    public void tracciaConsegna(String codiceTracking) {
        System.out.println("Tracciamento via strada: codice " + codiceTracking);
    }
}
// Classe Furgone che eredita VeicoloConsegna e implemente interfaccia Tracciabile
class Drone extends VeicoloConsegna implements Tracciabile{
    //costruttore con metodo super
    public Drone(String targa, float caricoMassimo) {
        super(targa, caricoMassimo);
    }

    //definizione del metodo abstract consegna pacco
    public void consegnaPacco(String destinazione) {
        System.out.println("Drone " + targa + " via aerea sta consegnando a " + destinazione);
    }

    //definizione del metodo tracciaConsegna
    public void tracciaConsegna(String codiceTracking) {
        System.out.println("Tracciamento automatico drone: codice " + codiceTracking);
    }
    
}






public class EsercizioInterfaccia {
    public static void main(String[] args) {

        //creazione oggetto Scanner
        Scanner scanner = new Scanner(System.in);

        //creazione ArrayList di oggetti VeicoloConsegna
        ArrayList<VeicoloConsegna> veicoli = new ArrayList<>();
        
        //aggiunto Oggetti Furgone e Drona ad ArrayList
        veicoli.add(new Furgone("ahjs", 3));
        veicoli.add(new Drone("sjdsj", 3));

        //ciclo for prendere input utente
        for(VeicoloConsegna veicolo : veicoli){
            veicolo.stampaInfo();
            System.out.println("Inserisci destinazione");
            String destinazione = scanner.nextLine();
            veicolo.consegnaPacco(destinazione);
            System.out.print("Inserisci codice tracking: ");
            String codice = scanner.nextLine();
            if (veicolo instanceof Tracciabile) {
                ((Tracciabile) veicolo).tracciaConsegna(codice);
            }
        }
        
    }
    
}
