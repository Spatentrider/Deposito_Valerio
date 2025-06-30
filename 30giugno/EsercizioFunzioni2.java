import java.util.Scanner;

public class EsercizioFunzioni2 {

    //funzione somma interi
    static int base(int n, int i){
        System.out.println("Il risultato della somma di " + n + " + " + i + " è " + (n + i));
        return n + i;
    }

    //funzione moltiplicazione interi
    static int multiply(int n, int i){
        System.out.println("Il risultato della moltiplicazione di " + n + " * " + i + " è " + (n * i));
        return n * i;
    }

     //funzione  overloadata moltiplicazione double
    static double multiply(double n, double i, double j){
          System.out.println("Il risultato della moltiplicazione di " + n + " * " + i + " * " + j + " è " + (n * i * j));
        return n * i * j;
    }

    static int naturali(int n) {
    int somma;
    if (n == 1) return 1;
    return n + naturali(n - 1);
    } 

    static void modificaPrimitivo(int x) {
        x = x + 10;
        System.out.println("Dentro funzione: x = " + x);
    }

      static void modificaArray(int[] arr) {
        arr[0] = arr[0] + 10;
        System.out.println("Dentro funzione: arr[0] = " + arr[0]);
    }

    public static void main(String[] args) {

        //dichiarazione variabili
        String input;
        int addendo1;
        int addendo2;
        int addendo3;
        double numero1;
        double numero2;
        double numero3;
        int somma;

        //creazione oggetti scanner
        Scanner stringhe = new Scanner(System.in);
        Scanner numeri = new Scanner(System.in);
        
        //richiesta input tramite do-while
        do{
            //assegnazione input utente
            System.out.println("Scegli \"base\" per esercizio 1, \"overloading\" per esercizio 2, \"ricorsione\" per esercizio 3, \"passaggio\" per esercizio 4 o \"fine\" per terminare" );
            input = stringhe.nextLine();
            //controllo input utente
            if(input.equals("base")){
                //assegnazione input utente per somma
                System.out.println("Scegli primo numero");
                addendo1 = numeri.nextInt();
                System.out.println("Scegli secondo numero");
                addendo2 = numeri.nextInt();
                //chiamata funzione
                base(addendo1, addendo2);
            }
            //controllo input utente
            else if(input.equals("overloading")){
                System.out.println("Vuoi moltiplicare 2 o 3 numeri?");
                int quanti = numeri.nextInt();
                //se input 2 chiamata funzione con int 
                if (quanti == 2) {
                    System.out.println("Inserisci primo numero:");
                    addendo1 = numeri.nextInt();
                    System.out.println("Inserisci secondo numero:");
                    addendo2 = numeri.nextInt();
                    //chiamata metodo
                    multiply(addendo1, addendo2);
                //se input 3 chiamata funzione con double
                } else if (quanti == 3) {
                    System.out.println("Inserisci primo numero:");
                    numero1 = numeri.nextInt();
                    System.out.println("Inserisci secondo numero:");
                    numero2 = numeri.nextInt();
                    System.out.println("Inserisci terzo numero:");
                    numero3 = numeri.nextInt();
                    multiply(numero1, numero2, numero3);
                //in caso contrario scelta errata
                } else {
                    System.out.println("Scelta non valida");
                }
            }
            //controllo input utente
            else if(input.equals("ricorsione")){
                System.out.println("inserisci un numero");
                addendo1 = numeri.nextInt();
                //chiamata funzione e stampa
                somma = naturali(addendo1);
                System.out.println("La somma dei primi " + addendo1 + " numeri naturali è: " + somma);
            }
            //controllo input utente
            else if(input.equals("passaggio")){
                //creazione variabile
                int numero = 10;
                System.out.println("Valore primitivo prima: numero = " + numero);
                //chiamata funzione e stampa
                modificaPrimitivo(numero);
                System.out.println("Valore primitivo dopo: numero = " + numero);

                //creazione variabile
                int[] array = {10};
                System.out.println("\nArray prima: array[0] = " + array[0]);
                //chiamata funzione e stampa
                modificaArray(array);
                System.out.println("Array dopo: array[0] = " + array[0]);
            }
            
        }while(!input.equals("fine"));

    System.out.println("Programma terminato");
    }  
}
