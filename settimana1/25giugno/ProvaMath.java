public class ProvaMath {
    public static void main(String[] args) {
        //funzione max e stampa
        System.out.println(Math.max(5, 10));

        //funzione min e stampa
        System.out.println(Math.min(5, 10));

        //funzione sqrt e stampa
        System.out.println(Math.sqrt(64));

        //funzione abs (valore assoluto positivo) e stampa
        System.out.println(Math.abs(-4.7));

        //funzione Math e stampa (numero tra 0 e 1)
        System.out.println(Math.random());

        

        //funzione Math e stampa (numero tra 0 e 101)
        int randomnum = (int)(Math.random() * 101);
        System.out.println(randomnum);
    }
    
}
