import java.util.ArrayList;
import java.util.Collections;

public class ProvaArrayList {
    public static void main(String[] args) {
        //creazione oggetto ArrayList per numeri
        //meglio usare ArrayList per numeri
        ArrayList<Integer> numeri = new ArrayList<>();
        //uso del metodo add per aggiungere numeri
        numeri.add(10);
        numeri.add(20);
        numeri.add(30);

        //creazione oggetto ArrayList per stringhe
        ArrayList<String> nomi = new ArrayList<>();
        //uso del metodo add per aggiungere stringhe
        nomi.add("Bob");
        nomi.add("John");

        //creazione oggetto ArrayList per numerii
        ArrayList<Integer> numeri2 = new ArrayList<>();

        // Aggiunta di 10 numeri casuali
        for(int i = 0; i < 10; i++){
            numeri2.add((int) (Math.random() * 100) + 1);
        }

        //Stampa della lista originale
        System.out.println("Lista originale: " + numeri2);
        
        //Ordinamento della lista
        Collections.sort(numeri2);

        //Stampa della lista ordinata
        System.out.println("Lista ordinata: " + numeri2);

        //metodo get stampa il valore nella posizione data
        System.out.println(numeri2.get(3));

        //metodo set mette alla posizione data l'elemento dato
        System.out.println(numeri2.set(3, 55));

        //metodo contains controlla se è presente quel valore e ritorna un booleano  
        System.out.println(numeri2.contains(3));

        //metoso remove rimuove elemento alla posizione data
        System.out.println(numeri2.remove(3));
    }
}
