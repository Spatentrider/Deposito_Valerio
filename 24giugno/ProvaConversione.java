public class ProvaConversione {
    public static void main(String[] args) {
        //dichiarazione e assegnazione variabile
        int myInt = 9;

        //casting di int in double
        double myDouble = myInt;
        // casting automatico: int to double

        //stampa
        System.out.println(myInt);
        System.out.println(myDouble);

        //prova casting restringente
        double myDouble2 = 9.78d;
        //casting esplicito (int)
        int myInt2 = (int) myDouble2;

        //stampa
        System.out.println(myDouble2);
        System.out.println(myInt2);
    
    }
    
}
