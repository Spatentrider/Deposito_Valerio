import java.util.Scanner;

public class EsercizioCondizioni2 {
    public static void main(String[] args) {
        
        // istanziazione classe Scanner
        Scanner myObj = new Scanner(System.in);

        // input dell'età
        System.out.println("Inserisci età: ");
        int età = myObj.nextInt();

        // input anni di esperienza alla guida
        System.out.println("Quanti anni di esperienza alla guida hai ? ");
        int anniesperienzaguida = myObj.nextInt();

         // input incidenti ultimi anni
        System.out.println("Quanti incidenti negli ultimi 5 anni? ");
        int incidenti = myObj.nextInt();
         
        // input pacchetto
        System.out.println("Che pacchetto assicurativo vuoi? \n 0: standard\n 1: intermedio\n 2: premium");
        int pacchetto = myObj.nextInt();

        //dichiarazione e assegnazione prezzo base e finale
        int prezzobase = 500;
        int prezzofinale = prezzobase;
        boolean idoneità = true;

        //switch calcolo maggiorazioni per età
        if(età < 18) {
            idoneità = false;
        }
        else if(età <= 25){
            prezzofinale += 100;
        }
        else if(età <= 50){
            
        }
        else{
            prezzofinale -= 50;
        }

        //switch calcolo maggiorazioni per anni di esperienza guida
        switch(anniesperienzaguida){
            case 0:
                prezzofinale += 150;
                break;
            case 1:
                prezzofinale += 150;
                break;
            case 2:
               prezzofinale += 150;
                break;
            default:
                break;
        }
        //switch calcolo maggiorazioni per incidenti
        switch(incidenti){
            case 0:
                break;
            case 1:
                prezzofinale = (int)(prezzofinale * 1.15);
                break;
            case 2:
                prezzofinale = (int)(prezzofinale * 1.30);
                break;
            case 3:
                prezzofinale = (int)(prezzofinale * 1.30);
                break;
            default:
                idoneità = false;
                break;
        }
        //switch calcolo maggiorazioni per pacchetto scelto
        switch(pacchetto){
            case 0:
                break;
            case 1:
                prezzofinale = (int)(prezzofinale * 1.30);
                break;
            case 2:
                prezzofinale = (int)(prezzofinale * 1.50);
                break;
        }
        //controllo idoneità
        
        if(idoneità == true){
        System.out.println("prezzo assicurazione è : " + prezzofinale);}
        else{
             System.out.println("Non sei idoneo per l'assicurazione");
        }
        }
    }