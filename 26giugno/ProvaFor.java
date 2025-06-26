import java.util.Scanner;

public class ProvaFor{

public static void main(String[] args) {

    //creazione oggetto scanner
    Scanner scanner = new Scanner(System.in);

    //richiests input utente
    System.out.println("Inserisci un numero: ");

    //dichiarazione e assegnazione numero e stampa
    int numero = scanner.nextInt();
    System.out.println("Tabellina del " + numero + ":");
    
    //ciclo for per moltiplicare da 1 a 10
    for(int i = 1; i <= 10; i++){
        System.out.println(numero + " x " + i + " = " + (numero * i));
    }

}}