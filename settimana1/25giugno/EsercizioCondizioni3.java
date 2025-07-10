import java.util.Scanner;

public class EsercizioCondizioni3 {
    public static void main(String[] args) {
        //dichiarazione variabili
        double età, tempo100metri, peso, altezza, BMI, etàminima, etàmassima, limiteetàminima, limiteetàmassima;

        //inizializzazione variabili etàminma e etàmassima
        etàminima = 18;
        etàmassima = 40;

        // istanziazione classe Scanner per stringhe
        Scanner Stringhe = new Scanner(System.in);

        // istanziazione classe Scanner per numeri
        Scanner Numeri = new Scanner(System.in);

        //richiesta input e assegnazione del valore età
        System.out.println("Inserire età: ");
        età = Numeri.nextDouble();

        //richiesta input e assegnazione del valore tempo100metri
        System.out.println("Inserire miglior tempo sui 100 metri: ");
        tempo100metri = Numeri.nextDouble();

        //richiesta input e assegnazione del valore peso
        System.out.println("Inserire peso: ");
        peso = Numeri.nextDouble();

        //richiesta input e assegnazione del valore altezza
        System.out.println("Inserire altezza: ");
        altezza = Numeri.nextDouble();

        //calcolo BMI
        BMI = peso / Math.pow(altezza, 2);

        //calcolo limite età minima
        limiteetàminima = Math.min(età, etàminima);

        //calcolo limite età massima
        limiteetàmassima = Math.max(età, etàmassima);

        //controllo di tutte le condizioni
        if (limiteetàminima >= etàminima && limiteetàmassima <= etàmassima && tempo100metri < 12 && BMI < 25 ) {
            System.out.println("Ammesso alla gara");
        } else{
            System.out.println("Non ammesso alla gara");
        }
    }
    
}
