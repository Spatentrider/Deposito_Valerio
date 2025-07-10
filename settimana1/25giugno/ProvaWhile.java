import java.util.Scanner;

public class ProvaWhile {
    public static void main(String[] args) {
        //esempio ciclo while
        //inizializzazione della variabile di controllo
        int i = 1;

        //ciclo while
        while(i <= 5){
            i++; //incremento della variabile di controllo
            System.out.println(i);
        }
        
        //ciclo do-while condizionato
        //istanziazione classe Scanner
        Scanner input = new Scanner(System.in);
        //dichiarazione variabile;
        int numero;

        //ciclo do-while
        do{
            System.out.println("Inserisci un numero (0 per uscire): ");
            numero = input.nextInt();
        }while(numero != 0);

        //stampa messaggio con input
        System.out.println("Hai inserito 0. Programma terminato.");
    }
}
