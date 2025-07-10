import java.util.ArrayList;

//classe padre
class Animale{
    //dichiarazione attributi protetti
    protected String nome;
    protected int età;
    
    //metodo pubblico stampa verso
    public void faiVerso(){
        System.out.println("Verso generico...");
    }

    //metodo pubblico stampa info
    public void stampaInfo(){
        System.out.println("Nome: " + this.nome + "età: " + this.età);
        faiVerso();
    }

}
//classe figlia di Animale
class Cane extends Animale {
    //costruttore predefinito 
    public Cane(String nome, int età) {
        this.nome = nome;
        this.età = età;
    }
    //classe ereditata da classe padre e modificata
     public void faiVerso(){
        System.out.println("Bau!");
    }
}
//classe figlia di Animale
class Gatto extends Animale {
    //costruttore predefinito 
    public Gatto(String nome, int età) {
        this.nome = nome;
        this.età = età;
    }
    //classe ereditata da classe padre e modificata
     public void faiVerso(){
        System.out.println("Miao!");
    }
}
//classe zoo
class Zoo {
    //dichiarazione ArrayList
    private ArrayList<Cane> cani = new ArrayList<>();
    private ArrayList<Gatto> gatti = new ArrayList<>();

    //metodo per aggiungere oggetti Cane all'ArrayList
     public void aggiungiCane(Cane cane) {
        cani.add(cane);
    }

    //metodo per aggiungere oggetti Gattp all'ArrayList
    public void aggiungiGatto(Gatto gatto) {
        gatti.add(gatto);
    }
    

    //metodo di stampa ArrayList
    public void mostraAnimali() {
        System.out.println("Cani");
        //ciclo for each per scorrere ArrayList cani
        for (Cane cane : cani) {
            //chiamata metodo di stampa info di Cane
            cane.stampaInfo();
        }

        //ciclo for each per scorrere ArrayList gatti
        System.out.println("Gatti");
        for (Gatto gatto : gatti) {
             //chiamata metodo di stampa info di Gatto
            gatto.stampaInfo();
        }
    }
}


public class EsercizioEreditarietà {
    public static void main(String[] args) {

        //creazione ArrayList oggetto Animale
        ArrayList<Animale> animali = new ArrayList<>();

        //creazione Oggetti Cane e Gatto
        Cane cane = new Cane("cano", 3);
        Gatto gatto = new Gatto("Gato", 4);

        //chiamata metodo per aggiungere oggetto all'ArrayList
        animali.add(cane);
        animali.add(gatto);

        //ciclo for each per scorrere ArrayList gatti
        for (Animale animale : animali) {
            //chiamata metodo per stampare verso
            animale.faiVerso();
        }

        //crezione Oggetto Zoo
        Zoo zoo = new Zoo();

        //chiamata metodo per aggiungere oggetto all'ArrayList
        zoo.aggiungiCane(new Cane("Fido", 5));
        zoo.aggiungiGatto(new Gatto("Micio", 3));
        zoo.aggiungiCane(new Cane("Fuffi", 2));
        zoo.aggiungiGatto(new Gatto("Palla", 1));

        //chiamata metodo per stampare Animali
        zoo.mostraAnimali();
    } 
}
