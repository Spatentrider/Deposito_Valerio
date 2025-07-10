import java.util.ArrayList;
import java.util.List;

// Interfaccia Observer 
interface Investitore {
    void notifica(String azione, double valore);
}

// Interfaccia Subject
interface SubjectAgenziaBorsa {
    void aggiungiInvestitore(Investitore investitore);
    void rimuoviInvestitore(Investitore investitore);
    void notificaInvestitore();
}

// classe che viene osservata e implementa SubjectAgenziaBorsa e con Singleton
class AgenziaBorsaSingleton implements SubjectAgenziaBorsa {

    //Attributo statico per singleton
    private static AgenziaBorsaSingleton instance;

    //dichiarazione attributi privati e List di Investitore
    private List<Investitore> investitori = new ArrayList<>();
    private String nome;
    private double valore;

    //costruttore privato
    private AgenziaBorsaSingleton(){};

    //metodo per creare solo un'istanza 
     public static AgenziaBorsaSingleton getInstance() {
        if (instance == null) {
            instance = new AgenziaBorsaSingleton();
        }
        return instance;
    }

    //metodo per cambiare attributo valor e nome e notificarlo agli investitori
    public void aggiornaValoreAzione(String nome, double valore) {
        this.nome= nome;
        this.valore = valore;
        notificaInvestitore();
    }

    //metodo aggiunta Investitore 
    public void aggiungiInvestitore(Investitore investitore) {
        investitori.add(investitore);
    }

    //metodo rimuovere Investitore
   public void rimuoviInvestitore(Investitore investitore) {
        investitori.remove(investitore);
    }

    //metodo scorrere List Investitore e chiamata metodo notifica
    public void notificaInvestitore() {
        for (Investitore investitore : investitori) {
            investitore.notifica(nome, valore);
        }
    }
}

//classe InvestitorePrivato implemente interfaccia Investitore
class InvestitorePrivato implements Investitore {
    private String name;

    //costruttore con parametro
    public InvestitorePrivato(String name) {
        this.name = name;
    }

    //metodo stampa
    public void notifica(String nome, double valore) {
        System.out.println("Investitore privato " + name + " il valore dell'azione " + nome + " è cambiato a " + valore);
    }
}

//classe InvestitoreBancario implemente interfaccia Investitore
class InvestitoreBancario implements Investitore {
    private String name;


    //costruttore con parametro
    public InvestitoreBancario(String name) {
        this.name = name;
    }

    //metodo stampa
    public void notifica(String nome, double valore) {
        System.out.println("Investitore bancario " + name + " il valore dell'azione " + nome +" è cambiato a " + valore);
    }
}
