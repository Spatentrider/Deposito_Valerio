import java.util.Scanner;

public class EsercizioFunzioni {

    //funzione potenza con parametro int
    static double potenza (double numero){
        //ciclo if per controllo numeri positivi
        if(numero > 0){
            double risultato = Math.pow(numero, numero);
            System.out.println("la potenza di " + numero + " è " + risultato);
            return risultato;
        }
        //se negativo stampa messaggio errore
        else{
            System.out.println("Numero non valido");
            return -1;
        }
    }
    //overloading potenza con parametro String
    static void potenza(String messaggio){
       
        System.out.println("La parola è lunga " + messaggio.length() + " lettere ");

    }

    public static void main(String[] args) {

        //dichiarazione variabili input
        double inputnumero; 
        String inputstringa;

        //dichiarazione oggetti Scanner
        Scanner numeri = new Scanner(System.in);
        Scanner stringhe = new Scanner(System.in);

        //richiamo metodo con parametro double
        System.out.println("Inserisci un numero: ");
        inputnumero = numeri.nextDouble();
        potenza(inputnumero);

        //richiamo metodo con parametro double negativo
        System.out.println("Prova overloading con numero negativo");
        potenza(-3);

        //richiamo metodo con parametro String
        System.out.println("Inserisci una parola: ");
        inputstringa = stringhe.nextLine();
        potenza(inputstringa);
    } 
}
