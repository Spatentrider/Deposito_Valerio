import java.util.ArrayList;

class Studente {
    //dichiarazione attributi
    private String nome;
    private int voto;
    private static int id = 1;
  

    //costruttore predefinito con assegnazione valori ad attributi
    Studente(String nome, int voto) {
        this.nome = nome;
        this.voto = voto;
        //aumento variabile statica
        id++;
    }

    //getter nome
    public String getNome() {
        return nome;
    }

    //getter voto
    public int getVoto() {
        return voto;
    }

    //setter voyo
    public void setVoto(int voto) {
        //controllo voto valido 
        if (voto >= 0 && voto <= 10) {
            this.voto = voto;//se valido assegnazione nuovo voro
        } else {
            System.out.println("Voto non valido ");//se non valido errore stampa
        }
    }

    //Metodo per cercare studente
    public void cercaStudente(ArrayList<Studente> lista, String nome) {
        boolean trovato = false;//booleano falso per condizione trovato
        for (Studente studente : lista) {//ciclo for each dell'ArrayList
            if (studente.getNome().equals(nome)) {//se nome trovato stampa
                System.out.println("Trovato: " + studente.getNome() + " - Voto: " + studente.getVoto());
                trovato = true;//booleano diventa true
                break;
            }
        }//se booleano rimane false stampa di errore
        if (!trovato) {
            System.out.println("Studente non trovato.");
        }
    }
}



public class EsercizioIncapsulamento {
    public static void main(String[] args) {

        //creazione oggetto ArrayList di Studente
        ArrayList<Studente> Studenti = new ArrayList<>();
        
        //creazione oggetto Studente
        Studente studente = new Studente("Marco", 2);
        System.out.println("Nome studente: " + studente.getNome() + " voto " + studente.getVoto());
        //prova voto valido
        studente.setVoto(7);
        System.out.println("Nome studente: " + studente.getNome() + " voto " + studente.getVoto());
        //prova voto non valido
        studente.setVoto(22);
        System.out.println("Nome studente: " + studente.getNome() + " voto " + studente.getVoto());
        ////Aggiunta di studente ad ArrayList
        Studenti.add(studente);
        //chiamata metodo cercaStudente
        studente.cercaStudente(Studenti, "Marco");
        studente.cercaStudente(Studenti, "Giulia");
    }
}
