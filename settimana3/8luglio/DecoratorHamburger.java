import java.util.ArrayList;
import java.util.List;

//interfaccia che verrà implementata nella classe base e nell'abstract decorator
interface Hamburger{
    String getDescrizione();
    double getPrezzo();
}
//classe da decorare
class BaseBurger implements Hamburger{

    //metodo di stampa base
    public String getDescrizione(){
        String descrizione = "Panino base";
        return descrizione;
    }

    //metodo che torna prezzo base
    public double getPrezzo(){
        double prezzo = 5.5;
        return prezzo;
    }
    
}
//decoratore astratto
abstract class  HamburgerDecorator implements Hamburger{
    //incapsulamento interfaccia
    protected Hamburger hamburger;

    //costruttore con interfaccia come parametro
    public HamburgerDecorator(Hamburger hamburger){
        this.hamburger = hamburger;
    }

    //metodo che chiama metodo di stampa interfaccia
    public String getDescrizione() {
        return hamburger.getDescrizione();
    }

     //metodo che chiama metodo di prezzo interfaccia
    public double getPrezzo(){
        return hamburger.getPrezzo();
    }
}
//decoratore per cambiare classe base in panino con formaggio
class FormaggioDecorator extends HamburgerDecorator{
    //costruttore con super
    public FormaggioDecorator(Hamburger hamburger){
        super(hamburger);
    }

    //cambiamento del metodo con super con stampa diversa
    public String getDescrizione(){
        return super.getDescrizione() + " + formaggio";
    }

    //cambio del metodo del prezzo
    public double getPrezzo(){
        return super.getPrezzo() + 1;
    }
}
//decoratore per cambiare classe base in panino con bacon
class BaconDecorator extends HamburgerDecorator{
    public BaconDecorator(Hamburger hamburger){
         //costruttore con super
        super(hamburger);
    }

     //cambiamento del metodo con super con stampa diversa
    public String getDescrizione(){
        return super.getDescrizione() + " + bacon ";
    }

     //cambio del metodo del prezzo
    public double getPrezzo(){
        return super.getPrezzo() + 1.50;
    }
}
// Interfaccia Observer
interface OsservatoreOrdine {
    void notifica(String descrizione, double prezzo);
}
// Interfaccia  del subject
interface Ordini{
     public void aggiungiOsservatore(OsservatoreOrdine osservatore);
     public void rimuoviOsservatore(OsservatoreOrdine osservatore);
     public void nuovoOrdine(Hamburger hamburger);
}

//classe Subject con Singleton
class OrdiniSingleton implements Ordini {
    //istanza statica per singleton
    private static OrdiniSingleton instance;
    //List di Observer
    private List<OsservatoreOrdine> osservatori = new ArrayList<>();

    //costruttore privato per fare in modo che non sia richiamabile
    private OrdiniSingleton() {}

    //metodo statico èer creare un istanza singola
    public static OrdiniSingleton getInstance() {
        if (instance == null) {
            instance = new OrdiniSingleton();
        }
        return instance;
    }

    //metodo per aggiungere observer
    public void aggiungiOsservatore(OsservatoreOrdine osservatore) {
        osservatori.add(osservatore);
    }

    //metodo per rimuovere observer
    public void rimuoviOsservatore(OsservatoreOrdine osservatore) {
        osservatori.remove(osservatore);
    }

    //metodo che esegue nuovo ordine e notifica gli observer
    public void nuovoOrdine(Hamburger hamburger) {
        String descrizione = hamburger.getDescrizione();
        double prezzo = hamburger.getPrezzo();
        for (OsservatoreOrdine osservatore : osservatori) {
            osservatore.notifica(descrizione, prezzo);
        }
    }

    
}
//classe Observer
class Cliente implements OsservatoreOrdine {
    //attributo privato proprio
    private String nome;

    //costruttore con parametro
    public Cliente(String nome) {
        this.nome = nome;
    }

    //metodo di stampa quando avviene nuovo ordine
    public void notifica(String descrizione, double prezzo) {
        System.out.println(nome + " ha ricevuto notifica: Ordine creato  " + descrizione + "Prezzo: " + prezzo);
    }
}
