import java.util.Scanner;

public class EsercizioArray {
    public static void main(String[] args) {
        //dichiarazione variabili
        int contatore = 0;
        int sommadolci = 0;
        int  quantitàtest = 0;
        int[] quantità = new int[10];
        String[] dolci = new String[10];

        //creazione oggetti Scanner
        Scanner numeri = new Scanner(System.in);
        Scanner stringhe = new Scanner(System.in);
        

        //richiesta input tramite do while
        do{
            //richiesta dolci
            System.out.println("Che dolce vuoi?");
            dolci[contatore] = stringhe.nextLine();
            //richiesta porzioni
            System.out.println("Quante porzioni?");
            quantitàtest = numeri.nextInt();
            //controllo quantità non sia negativo
            if(quantitàtest <= 0){
                System.out.println("Numero non valido");
            }else{
                quantità[contatore] = quantitàtest;
                contatore++;
            }
        }while(contatore < 10);

        //stampa degli ordini e calcolo quantità totale
        for (int i = 0; i < contatore; i++) {
            //stampa ordini
            System.out.println("Ordinati :" + quantità[i] + " " + dolci[i]);
            //calcolo quantità totale
            sommadolci += quantità[i];

    }
    //stampa quantità totale
    System.out.println("Sono stati ordinati in totale " + sommadolci + " dolci");
    }
    
}
