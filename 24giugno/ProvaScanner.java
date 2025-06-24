import java.util.Scanner;

public class ProvaScanner {
    public static void main(String[] args) {
        //istanziazione classe
        Scanner myObj = new Scanner(System.in);

        //stampa messaggio
        System.out.println("Enter username");

        //salvataggio dell'input dell'utente
        String userName = myObj.nextLine();

        //stampa con stringa presa dall'input
        System.out.println("Username is: " + userName);
        
    }
    
}
