import java.util.ArrayList;
import java.util.Scanner;

//classe base
class Hamburger{
    //Attributo protetto
    protected String nome;
    //costruttore con parametro
    Hamburger(String nome){
        this.nome = nome;
    }

    //getter del nome
    String getNome(){
        return nome;
    }

    //metodo base vuoto
    public void prepara(){}
}
//classe derivata di Hamburger
class Cheeseburger extends Hamburger{

    //costruttore con metodo super
    Cheeseburger(){
        super("Cheeseburger");
    }
    //metodo con override per stampa diversa
    @Override
    public void prepara() {
        System.out.println("Preparazione Cheeseburger: pane, carne, formaggio, ketchup");
    }
}
//classe derivata di Hamburger
class VegBurger extends Hamburger{

    //costruttore con metodo super
    VegBurger(){
        super("Vegburger");
    }
    //metodo con override per stampa diversa
    @Override
    public void prepara() {
        System.out.println("Preparazione VegBurger: pane integrale, burger vegetale, insalata, pomodoro");
    }

}
//classe derivata di Hamburger
class DoubleBacon extends Hamburger{

    //costruttore con metodo super
    DoubleBacon(){
        super("DoubleBacon");
    }
    //metodo con override per stampa diversa
    @Override
    public void prepara() {
        System.out.println("Preparazione DoubleBacon: pane, doppia carne, bacon, cheddar, maionese");
    }

}
public class EsercizioPolimorfismo2 {
    public static void main(String[] args) {
        //creazione oggetto Scanner
        Scanner scanner = new Scanner(System.in);
        Scanner scannernumeri = new Scanner(System.in);
        //creazione ArrayList di classe Hamburger
        ArrayList<Hamburger> ordini = new ArrayList<>();
        //Creazione oggetto Hamburger e attributi
        //Hamburger hamburger = null;
        int inputnumero;
        String input;

        //ciclo do while per prendere input utente
        do {
            System.out.println("Inserisci 1 per ordinare Cheeseburger, 2 per VegBurger, 3 per DoubleBacon, 4 per preparare tutti gli ordini o 5 per uscire");

            //assegnazione input utente tramite metodo di scanner
            inputnumero = scannernumeri.nextInt();
            //switch per check input
            switch (inputnumero) {
                case 1:
                //creazione oggetto Cheeseburger e aggiunto all'ArrayList
                    ordini.add(new Cheeseburger());
                    System.out.println("Cheeseburger aggiunto all\'ordine!");
                    break;
                case 2:
                //creazione oggetto Vegburger e aggiunto all'ArrayList
                    ordini.add(new VegBurger());
                    System.out.println("VegBurger aggiunto all\'ordine!");
                    break;
                case 3:
                //creazione oggetto DoubleBacon e aggiunto all'ArrayList
                    ordini.add(new DoubleBacon());
                    System.out.println("DoubleBacon aggiunto all\'ordine!");
                    break;
                case 4:
                    System.out.println("Preparazione Ordini");
                    //ciclo for per scorrere Oggetti nell'array con stampa
                    for (Hamburger h : ordini) {
                        System.out.println(h.getNome());
                        h.prepara();
                    }
                    break;
                default:
                    //stampa di errore
                    System.out.println("Comando non valido.");
                    break;
            }

            //richiesta input per continuare
            System.out.println("Vuoi continuare? (si/no)");
            input = scanner.nextLine(); // legge la risposta dell'utente
        } while (!input.equals("no")); //se input = no esce dal ciclo

        System.out.println("Programma terminato");
    }
    
}
