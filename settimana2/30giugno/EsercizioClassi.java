    import java.util.Scanner;

    class Persona{
        String nome;
        String città;
        int età;

        Persona(String nome, String città){
            this.nome = nome;
            this.città = città;
            this.età = 22;
        }

        void mostraInfo() {
        System.out.println("Nome: " + nome + ", Città: " + città + ", Età: " + età);
    }
    }
    
    //creazione class
    class Libro {
    //dichiarazione attributi
    String titolo;
    String autore;
    double prezzo;
    //attributi static
    static int codice_numerico_autoincrementante = 0;

    //metodo costruttore
    Libro(String titolo, String autore, double prezzo)
    {
        //assegnazione valore dei parametri del costruttore agli attributi
        this.titolo = titolo;
        this.autore = autore;
        this.prezzo = prezzo;
        codice_numerico_autoincrementante++;
    }

    //metodo di stampa
    void mostraInfo() {
        System.out.println(titolo + " - " + autore + " - $ " + prezzo);
        System.out.println("Libri pubblicati: " + codice_numerico_autoincrementante);
    }
    }

public class EsercizioClassi {
    
    public static void main(String[] args) {

        String nome, città;
        int età;

        Scanner input = new Scanner(System.in);


        

        //creazione oggetto1 e chiamata metodo
        Libro Libro1 = new Libro("It", "Stephen King", 15);
        Libro1.mostraInfo();
        //creazione oggetto2 e chiamata metodo
        Libro Libro2 = new Libro("Uno studio in rosso", "Arthur Conan Doyle", 12.99);
        Libro2.mostraInfo();

        //richiesta input utente
        System.out.println("Inserisci nome : ");
        nome = input.nextLine();
        System.out.println("Inserisci città : ");
        città = input.nextLine();

        //creazione oggetto con i parametri presi da input e stampa
        Persona Persona1 = new Persona(nome, città);
        Persona1.mostraInfo();

        //richiesta input utente
        System.out.println("Inserisci nome : ");
        nome = input.nextLine();
        System.out.println("Inserisci città : ");
        città = input.nextLine();

        
        //creazione oggetto con i parametri presi da input e stampa
        Persona Persona2 = new Persona(nome, città);
        Persona2.mostraInfo();
    }
    
}
