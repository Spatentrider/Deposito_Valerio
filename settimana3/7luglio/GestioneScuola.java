import java.util.ArrayList;
import java.util.Scanner;

//classe astratta
abstract class Persona{
    //dichiarazione attributi privati
    private String nome;
    private int età;

    //getter e setter
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getEtà() {
        return età;
    }

    public void setEtà(int età) {
        this.età = età;
    }

    //costruttore con parametri
    Persona(String nome, int età){
        this.nome = nome;
        this.età = età;
    }

    //dichiarazione metodo astratto
    abstract void descriviRuolo();
  
}

//interfaccia con metodo vuoto
interface Registrabile{
    void registrazione();
}

class Studente extends Persona implements Registrabile{
    //dichiarazione attributo privato proprio
    private String classeFrequentata;

    //getter e setter
    public String getClasseFrequentata() {
        return classeFrequentata;
    }

    public void setClasseFrequentata(String classeFrequentata) {
        this.classeFrequentata = classeFrequentata;
    }

    //costruttore con parametri e metodo super
    Studente(String nome, int età, String classeFrequentata){
        super(nome, età);
        this.classeFrequentata = classeFrequentata;
    }

    //Override con definzione del corpo del metodo astratto
    @Override
    void descriviRuolo() {
        System.out.println("Sono lo studente " + getNome() + " di anni " + getEtà() + " e frequento la classe " + getClasseFrequentata());
    }

    @Override

    //Override con definzione del corpo del metodo dell'interfaccia
    public void registrazione(){
        System.out.println("Registrazione tramite modulo online");
    }
}

class Docente extends Persona implements Registrabile{
    //dichiarazione attributo privato proprio
    private String materia;
    
    //getter e setter
    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    //costruttore con parametri e metodo super
    Docente(String nome, int età, String materia){
        super(nome, età);
        this.materia = materia;
    }

    //Override con definzione del corpo del metodo astratto
    @Override
    void descriviRuolo(){
        System.out.println("Sono il docente " + getNome() + " e insegno " + getMateria());
    }

    //Override con definzione del corpo del metodo dell'interfaccia
    @Override
    public void registrazione(){
        System.out.println("Registrazione tramite segreteria didattica");
    }
    
}

public class GestioneScuola {

    public static void main(String[] args) {
    
        //creazione ArrayList di oggetti Persona
        ArrayList<Persona> persone = new ArrayList<>();

        //creazione oggetti scanner per stringhe e numeri
        Scanner scanner = new Scanner(System.in); 
        Scanner scannernumeri = new Scanner(System.in); 

        //input utente
        int scelta;

        //ciclo do while per prendere input utente
        do {
            System.out.println("Inserisci 1 per aggiungere studente, 2 per aggiungere docente, 3 per stampare lista o 4 per uscire");
            scelta = scannernumeri.nextInt();
            switch (scelta) {
                //aggiungi studente
                case 1:
                //creazione di oggetto Studente tramite parametri presi dell'input utente e aggiunto all'ArrayList
                    System.out.print("Nome studente: ");
                    String nomeStudente = scanner.nextLine();
                    System.out.print("Età: ");
                    int etaStudente = scannernumeri.nextInt();
                    System.out.print("Classe frequentata: ");
                    String classe = scanner.nextLine();
                    persone.add(new Studente(nomeStudente, etaStudente, classe));
                    System.out.println("Studente aggiunto.");
                    break;

                case 2:
                    //creazione di oggetto Docente tramite parametri presi dell'input utente e aggiunto all'ArrayList
                    System.out.print("Nome docente: ");
                    String nomeDocente = scanner.nextLine();
                    System.out.print("Età: ");
                    int etaDocente = scannernumeri.nextInt();
                    System.out.print("Materia insegnata: ");
                    String materia = scanner.nextLine();
                    persone.add(new Docente(nomeDocente, etaDocente, materia));
                    System.out.println("Docente aggiunto.");
                    break;

                case 3:
                    //ciclo for each per scorrere ArrayList
                    for (Persona persona : persone) {
                        //chiamata metodo stampa attributi
                        persona.descriviRuolo();
                        if (persona instanceof Registrabile) {
                            //chiamata metodo di stampa dell'interfaccia
                            ((Registrabile) persona).registrazione();
                        }
                    }
                    break;

                case 4:
                    System.out.println("Chiusura programma.");
                    break;

                //stamoa di errore
                default:
                    System.out.println("Scelta non valida.");
            }

        } while (scelta != 4);//condizine di uscita dal programma
    }
    }

        
    
    
