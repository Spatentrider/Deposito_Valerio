import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class EsercizioArray{
    public static void main(String[] args) {

        //dichiarazione variabili per prendere input e per contare nomi inseriti
        String input;
        int contatore = 0;
        //creazione ArrayList per nome studenti
        ArrayList<String> nomi = new ArrayList<>();

        //creazione oggetto Scanner
        Scanner stringhe = new Scanner(System.in);

        //richiesta input utente
        do{
            System.out.println("Inserisci nome dello studente, di uno già esistente per rimuoverlo o fine per terminare");
            input = stringhe.nextLine();
            //controllo per terminare input
            if(!input.equals("fine")){
                //controllo se nome già presente viene rimosso, decremento contatore nomi e stampa 
                if(nomi.contains(input)){
                    nomi.remove(input);
                    contatore--;
                    System.out.println("nome rimosso");
                }else{
                    //Se nome non presente viene aggiunto all arraylist, incremento contatore nomi e stampa
                    nomi.add(input);
                    contatore++;
                    System.out.println("Nome aggiunto");  
                }
                
            }
        }while(!input.equals("fine"));

        //uso del metodo sort dell'oggetto Collections per mettere in ordine alfabetico l'arraylist di nomr
        Collections.sort(nomi);
        // stampa lista finale
        System.out.println("Sono stati inseriti " + contatore + " nomi : \n" + nomi);
        
    }
}