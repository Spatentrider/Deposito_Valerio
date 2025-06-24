public class ProvaVariabili {
    public static void main(String[] args){
    // prova variabile interi
    int provaNumero = 12;
    // prova variabile stringa
    String provaTesto = "Ciao Mondo";
    // prova variabile booleano
    boolean provaBool = true;

    // prova dichiarazione senza inizializzazione
    boolean provaBool2;

    // prova inizializzazione in un momento successivo
    provaBool = false;
    provaBool = true;
    
    //prova final
    final int provaNum = 15;

    // errore sovrascrizione variabile final
    // provaNumero = 20;

    //prova variabile stringa e stampa

    String testo = "Prova";
    System.out.println(testo);

    //prova concatenazione 
    testo = "Mondo";
    System.out.println("Ciao " + testo);

    //concatenazione tra variabili
    String firstPart = "Ciao ";
    String lastPart = "Mondo";
    String fullPart = firstPart + lastPart;
    System.out.println(fullPart);

    //stampa delle variabili con operatore matematico
    int x = 5;
    int y = 6;
    System.out.println(x + y);

    //dichiarazione variabili stesso tipo con elenco
    int a= 5, b = 6, c = 50;

    //stampa
    System.out.println(a + b + c);

    //assegnazione stesso valore piu variabili

    int d, e, f;
    d = e = f = 50;
    System.out.println(d + e + f);





}}
