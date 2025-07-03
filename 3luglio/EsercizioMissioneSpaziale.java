import java.util.ArrayList;
import java.util.Scanner;


class Astronauta {
    //Attributi protetti
    protected String nome;
    protected String email;
    protected float creditoOssigeno;
    protected int azioni;

    //costruttor con inizializzazione attributi con parametri
    Astronauta(String nome, String email){
        this.nome = nome;
        this.email = email;
        this.azioni = 0;
        //inizializzazione random di ossigeno
        creditoOssigeno =(float) Math.random() * 100;
    }

    //getter e setter
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

      public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

      public float getCreditoOssigeno() {
        return creditoOssigeno;
    }

    public void setCreditoOssigeno(float creditoOssigeno) {
        this.creditoOssigeno = creditoOssigeno;
    }

     public int getAzioni() {
        return azioni;
    }

    public void setAzioni(int azioni) {
        this.azioni = azioni;
    }

    // Metodi vuoti della classe base
    public Astronauta aggiungiEsperimento(StazioneSpaziale stazione, String esperimento) {
        return this;
    }

    public Astronauta aggiungiValutazione(StazioneSpaziale stazione, int valutazione) {
        return this;
    }

    //metodo di stampa
    public void mostraInfo(){
        System.out.println("Nome:" + this.nome + "Email" + this.email + " ossigeno: " + this.creditoOssigeno + "Azioni " + azioni);
    }
}

class StazioneSpaziale {
    //dichiarazione ArrayList
    private ArrayList<String> esperimenti;
    private ArrayList<Integer> valutazioni;

    //Inizializazione dell'ArrayList nei costruttori
    StazioneSpaziale() {
        esperimenti = new ArrayList<>();
        valutazioni = new ArrayList<>();
    }

    //metodo per aggiungere All'ArrayList esperimenti
    public void aggiungiEsperimento(String nome) {
        esperimenti.add(nome);
        System.out.println("Esperimento aggiunto: " + nome);
    }

    //metodo per aggiungere All'ArrayList valutazioni
    public void aggiungiValutazione(int voto) {
        //controllo se il voto è compreso da 1 a 5
        if (voto >= 1 && voto <= 5) {
            valutazioni.add(voto);// se true aggiunta voto
            System.out.println("Valutazione inserita: " + voto);
        } else {//se false stampa errore
            System.out.println("Valutazione non valida. Inserire un numero da 1 a 5.");
        }
    }

    //metodo per stampare esperimenti
     public void stampaEsperimenti() {
        //check se ArrayList è vuoto
        if (esperimenti.isEmpty()) {
            //se true stampa di errore
            System.out.println("Nessun esperimento presente.");
        } else {
            //se false ciclo for each e stampa
            System.out.println("Esperimenti nella stazione:");
            for (String esperimento : esperimenti) {
                System.out.println(esperimento);
            }
        }
    }

    
    //metodo per stampare valutazioni
    public void stampaValutazioni() {
        //check se ArrayList è vuoto
        if (valutazioni.isEmpty()) {//se true stampa di errore
            System.out.println("Nessuna valutazione inserita.");
        } else {
            //se false ciclo for each e stampa
            System.out.println("Valutazioni registrate:");
            for (Integer valutazione : valutazioni) {
                System.out.println(valutazione);
            }
        }
}}
//classe derivata Scienziato
class Scienziato extends Astronauta {
    //costruttore con metodo super
    public Scienziato(String nome, String email) {
        super(nome, email);
    }

    //Override del metodo aggiungiEsperimento
    @Override
    public Astronauta aggiungiEsperimento(StazioneSpaziale stazione, String esperimento) {
        stazione.aggiungiEsperimento(esperimento);
        //aumento contatore azioni
        azioni++;
        //se azioni maggiore o uguale a 3 creazione e ritorno di Oggetto ScienziatoCapo
        if (azioni >= 3) {
            System.out.println("Complimenti! Sei diventato uno Scienziato Capo!");
            return new ScienziatoCapo(nome, email, creditoOssigeno, azioni);
        }
        //altrimenti ritorno dell' Oggetto Scienziato
        return this;
    }
    }

//classe ScienzatoCapo derivata di Scienziato
class ScienziatoCapo extends Scienziato {
    //costruttore con metodo super E inizializzazione attributi propri
    public ScienziatoCapo(String nome, String email, float ossigeno, int azioni) {
        super(nome, email);
        this.creditoOssigeno = ossigeno;
        this.azioni = azioni;
    }

    //metodo proprio di stampa esperimenti
    public void stampaEsperimenti(StazioneSpaziale stazione) {
        stazione.stampaEsperimenti();
    }
}


//classe derivata Ispettore
class Ispettore extends Astronauta {
    //costruttore con metodo super
    public Ispettore(String nome, String email) {
        super(nome, email);
    }

    //Override del metodo aggiungiValutazione
    @Override
      public Astronauta aggiungiValutazione(StazioneSpaziale stazione, int voto) {
        stazione.aggiungiValutazione(voto);
        //aumento contatore azioni
        azioni++;
        if (azioni >= 3) { //se azioni maggiore o uguale a 3 creazione e ritorno di Oggetto IspettoreEsperto
            System.out.println("Complimenti! Sei diventato un Ispettore Esperto!");
            return new IspettoreEsperto(nome, email, creditoOssigeno, azioni);
        }//altrimenti ritorno dell' Oggetto Ispettore
        return this;
    }
}

//classe IspettoreEsperto derivata di Ispettore
class IspettoreEsperto extends Ispettore {
    //costruttore con metodo super E inizializzazione attributi propri
    public IspettoreEsperto(String nome, String email, float ossigeno, int azioni) {
        super(nome, email);
        this.creditoOssigeno = ossigeno;
        this.azioni = azioni;
    }

    //metodo proprio di stampa esperimenti
    public void stampaEsperimenti(StazioneSpaziale stazione) {
        stazione.stampaEsperimenti();
    }
}

public class EsercizioMissioneSpaziale {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Scanner scannernumeri = new Scanner(System.in);
        String input = "";
        int inputnumero = 0; 

        StazioneSpaziale stazionespaziale = new StazioneSpaziale();
        Astronauta astronauta = new Astronauta("pippo", "dmksd");
        
        do {
            System.out.println("Inserisci 1 per creare astronauta ,2 per visualizzare dati astronauta, 3 per ripetere il login, 4 per interagire con il profile o 5 per uscire dal programma");

            inputnumero = scannernumeri.nextInt();
            switch (inputnumero) {
                case 1:
                    System.out.print("Inserisci nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Inserisci email: ");
                    String email = scanner.nextLine();
                    System.out.print("Qual è il tuo pianeta preferito? ");
                    String pianeta = scanner.nextLine();

                    if (pianeta.contains("terra") || pianeta.contains("venere")) {
                        astronauta = new Scienziato(nome, email);
                    } else {
                        astronauta = new Ispettore(nome, email);
                    }
                    System.out.println("Astronauta creato con successo");
                    break;
                case 2:
                    
                    break;
                default:
                    System.out.println("Comando non valido");
                    break;
                
            
            }
            System.out.println("Vuoi continuare? \"si\" o \"no\"");
            input = scanner.nextLine();
        } while (!input.equals("no"));
    }

    
}
