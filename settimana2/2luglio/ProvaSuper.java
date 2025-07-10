// Classe base
class Persona {
    protected String nome;

    public Persona(String nome) {
        this.nome = nome;
    }

    public void saluta() {
        System.out.println("Ciao, sono " + nome);
    }
}

// Classe derivata
class StudenteSuper extends Persona {
    private String scuola;

    // Costruttore: usa super per chiamare il costruttore della classe madre
    public StudenteSuper(String nome, String scuola) {
        super(nome); // chiama il costruttore di Persona
        this.scuola = scuola;
    }

    // Metodo: usa super per richiamare il metodo saluta della superclasse
    public void saluta() {
        super.saluta(); // chiama saluta() da Persona
        System.out.println("Vado alla scuola " + scuola);
    }
}


public class ProvaSuper {
    public static void main(String[] args) {
        StudenteSuper s = new StudenteSuper("Luca", "ITIS Informatico");
        s.saluta();
    }
}
