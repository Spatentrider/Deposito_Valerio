import java.util.Scanner;

public class EsercizioJava {

    public static void main(String[] args) {

        //creazione oggetti scanner
        Scanner Stringhe = new Scanner(System.in);
        Scanner Numeri = new Scanner(System.in);

        //stampa messaggio
        System.out.println("Inserisci stringa");

        //creazione stringa e assegnazione valore tramite metodo di oggetto scanner
        String name = Stringhe.nextLine();
        System.out.println(name);

        //input di testo e assegnazione di inpu intt dell'utente
        System.out.println("Inserisci int");
        int numero = Numeri.nextInt();
        System.out.println("int è" + numero);

        //input di testo e assegnazione di input short dell'utente
        System.out.println("Inserisci short");
        short numero2 = Numeri.nextShort();
        System.out.println("short è" +numero2);

        //input di testo e assegnazione di input boolean dell'utente
        System.out.println("Inserisci booleano");
        boolean istrue = Stringhe.nextBoolean();
        System.out.println(istrue);

        //input di testo e assegnazione di input byte dell'utente
        System.out.println("Inserisci byte");
        byte numero3 = Numeri.nextByte();
        System.out.println(numero3);

        //input di testo e assegnazione di input double dell'utente
        System.out.println("Inserisci double");
        double numero4 = Numeri.nextDouble();
        System.out.println(numero4);

        //input di testo e assegnazione di input float dell'utente
        System.out.println("Inserisci float");
        float numero5 = Numeri.nextFloat();
        System.out.println(numero5);

        //input di testo e assegnazione di input long dell'utente
        System.out.println("Inserisci long");
        long numero6 = Numeri.nextLong();
        System.out.println(numero6);


        //Conversione int a double
        double daintadouble = numero;

        System.out.println("Conversione int a double");
        System.out.println(daintadouble);

         //Conversione int a double
        int dadoubleaint = (int) numero4;

        System.out.println("Conversione double a int");
        System.out.println(dadoubleaint);















        
    }


    
}
