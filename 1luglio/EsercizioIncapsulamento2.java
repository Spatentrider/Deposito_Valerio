import java.util.ArrayList;

class Aereo{
    //dichiarazione attributi
    private String modello;
    private int numeroPosti;
    private String codice;

    //Costruttore predefinito
    Aereo(String modello, int numeroPosti, String codice){
        this.modello = modello;
        this.numeroPosti = numeroPosti;
        this.codice = codice;
    }

    //getter modello
    public String getModello() {
        return modello;
    }

    //setter modello
    public void setModello(String modello) {
        this.modello = modello;
    }

    //metodo privato per controllare numero posti se positivi
    private boolean checkPosti(int posti) {
        return posti > 0;
    }
    //getter numeroPosti
    public int getNumeroPosti() {
        return numeroPosti;
    }

    //setter numeroPosti
    public void setNumeroPosti(int numeroPosti) {
        //se il metodo booleano torna true setta l'attributo
        if (checkPosti(numeroPosti)) {
            this.numeroPosti = numeroPosti;
        } else {//se falso errore di stampa
            System.out.println("Numero non valido");
        }
    }

    //getter codice
    public String getCodice() {
        return codice;
    }

    //setter codice
    public void setCodice(String codice) {
        this.codice = codice;
    }

    //metodo di stampa
        public void stampaInfo() {
        System.out.println("Modello: " + modello + " Codice: " + codice + " Posti: " + numeroPosti);
    }



}

class Pilota{
    //dichiarazione attributi
    private String nome;
    private String numeroBrevetto;
    private int oreVolo;

    //costruttore predefinito classe Pilota
    Pilota(String nome, String numeroBrevetto, int oreVolo){
        this.nome = nome;
        this.numeroBrevetto = numeroBrevetto;
        this.oreVolo = oreVolo;
    }

    //getter nome
    public String getNome() {
        return nome;
    }

    //setter nome
    public void setNome(String nome) {
        this.nome = nome;
    }

    //getter numeroBrevetto
    public String getNumeroBrevetto() {
        return numeroBrevetto;
    }

    //Setter numeroBrevetto
    public void setNumeroBrevetto(String numeroBrevetto) {
        this.numeroBrevetto = numeroBrevetto;
    }

    //metodo privato che torna un booleano true se ore positivo
    private boolean checkOreVolo(int ore) {
        return ore > 0;
    }

    //getter oreVolo
    public int getOreVolo() {
        return oreVolo;
    }

    //setter oreVolo
      public void setOreVolo(int oreVolo) {
        //controllo con metodo privato checkOrevVolo, se positivo setta attributo
        if (checkOreVolo(oreVolo)) {
            this.oreVolo = oreVolo;
        } else {//se negativo errore di stampa
            System.out.println("Ore di volo non valide");
        }
    }

    //metodo di stampa
     public void stampaInfo() {
        System.out.println("Nome: " + nome + " Brevetto: " + numeroBrevetto + " Ore volo: " + oreVolo);
    }


}

class CompagniaAerea{
    //dichiarazione attributi
    private String nome;
    private ArrayList<Aereo> flotta;
    private ArrayList<Pilota> piloti;

    //costruttore predefinito classe CompagniaAerea
    CompagniaAerea(String nome){
        this.nome = nome;
        //creazione Oggetti ArrayList di classi Aereo e Pilote
        this.flotta = new ArrayList<>();
        this.piloti = new ArrayList<>();
    }
    //metodo per aggiungere Aereo ad ArrayList
    public void aggiungiAereo(Aereo aereo) {
        flotta.add(aereo);
    }

    //metodo per aggiungere pilota ad ArrayList
    public void aggiungiPilota(Pilota pilota) {
        piloti.add(pilota);
    }

    //metodo di stampa ArrayList flotta e piloti
     public void stampaInfo() {
        System.out.println("Compagnia: " + nome);
        System.out.println("Aerei presenti nela flotta: ");
        //ciclo for each per scorrere ArrayList e chiamata metodo di stampa
        for (Aereo aereo : flotta) {
            aereo.stampaInfo();
        }
        System.out.println("Piloti inseriti:");
        //ciclo for each per scorrere ArrayList e chiamata metodo di stamp
        for (Pilota pilota : piloti) {
            pilota.stampaInfo();
        }
    }

}

public class EsercizioIncapsulamento2 {
    public static void main(String[] args) {

        //creazione oggetto CompagniaAerea
        CompagniaAerea compagnia = new CompagniaAerea("AirFrance");

        //creazione oggetti Aereo
        Aereo aereo1 = new Aereo("Boeing ", 180, "dss77");
        Aereo aereo2 = new Aereo("monoposto", 1, "djd56");

        //creazione oggetti Pilota
        Pilota pilota1 = new Pilota("Paolo Rossi", "345864", 1500);
        Pilota pilota2 = new Pilota("Michele Apicella", "345797", 2000);

        //chiamata metodi per aggiungere Aereo
        compagnia.aggiungiAereo(aereo1);
        compagnia.aggiungiAereo(aereo2);
        //chiamata metodi per aggiungere Pilota
        compagnia.aggiungiPilota(pilota1);
        compagnia.aggiungiPilota(pilota2);

        //chiamata metodi per stampare ArrayList Aereo e pilota
        compagnia.stampaInfo();
    }
        
    
    
}
