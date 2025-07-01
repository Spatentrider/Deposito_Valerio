import java.util.ArrayList;
import java.util.Scanner;

class Auto{
    //dichiarazione attributi
    String targa;
    String modello;

    //costruttore per passare valori targa e modello
    Auto(String modello, String targa){
        this.targa = targa;
        this.modello = modello;
    }
}

class Officina{
    //creazione ArrayList di Auto
    ArrayList<Auto> automobili;
     
    //Inizializzazione di ArrayList di Auto nel costruttpre 
    Officina(){
        automobili = new ArrayList<>();
    }

    //metodo per aggiunere Auto 
    void aggiungiAuto(Auto auto){
        automobili.add(auto);
        System.out.println("Aggiunto auto " + auto.modello + " targa " + auto.targa);
    }

    //Metodo per stampare lista auto aggiunte
    void stampaAuto(){
        //ciclo for per scorrere ArrayList e stampa
         for (Auto auto : automobili) {
            System.out.println("Modello " + auto.modello + "targa " + auto.targa);
        }
    }

}

public class UltimoEsercizioOggetti {
    public static void main(String[] args) {

        //dichiarazione stringa per prendere input
        String input;

        //Inizializzazione Oggetto Officine
        Officina Officina = new Officina();

        //Inizializzazione oggetto scannet
        Scanner scanner = new Scanner(System.in);

        //ciclo do while per prendere input utente
        do{
            //richiesta input utente
            System.out.println("Inserisci \"aggiungi\" per aggiungere auto o \"mostra\" per mostrare elenco macchine");
            input = scanner.nextLine();
            //se aggiungi richiesta input per modello e targa
            if(input.equals("aggiungi")){
                System.out.println("Inserisci modello");
                String modello = scanner.nextLine();
                System.out.println("Inserisci targa");
                String targa = scanner.nextLine();
                //chiamata metodo aggiungiAuto di Officina con gli argomenti presi in input
                Officina.aggiungiAuto(new Auto(modello, targa));
            }// se mostra chiamata metodo stampaAuto di Officina
            else if(input.equals("mostra")){
                System.out.println("Elenco auto inserite");
                Officina.stampaAuto();
            }//se nessuno dei due stampa di errore
            else{
                System.out.println("Comando non valido");
            }
            //richiesta di continuare per condizione per uscire dal ciclo
            System.out.println("Vuoi continuare? \"si\" o \"no\"");
            input = scanner.nextLine();
        }while(!input.equals("no"));//se input = no esce dal ciclo
        //stampa di uscita 
        System.out.println("Programma terminato");
        Officina.targa = "sjjs";
    }
}
