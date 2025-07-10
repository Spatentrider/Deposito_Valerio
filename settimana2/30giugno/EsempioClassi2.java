import java.util.ArrayList;

class Calcolatrice{
//metodo con ritorno
int somma(int a, int b){
        return a + b;
    }

//metodo senza ritorno
void saluta() {
    System.out.println("Ciao!");
}
}

//classe Moto
class Moto {
    //dichiarazione variabili
    String marca;
    int anno;

    //costruttore e assegnazioni variabili
    Moto(String marca, int anno){
        this.marca = marca;
        this.anno = anno;
    }

}

public class EsempioClassi2 {
    public static void main(String[] args) {

        //creazione oggetto
        Calcolatrice calc = new Calcolatrice();
        //chiamata metodo saluta
        calc.saluta();
        //chiamata metodo somma
        int risultato = calc.somma(5, 3);
        System.out.println("La somma è: " + risultato);

        //creazione ArrayList
        ArrayList<Moto> MotoList = new ArrayList<>();
        //aggiunta elementi ArrayList
        MotoList.add((new Moto("Tesla", 2023)));
        MotoList.add(new Moto("Ford", 2020));

        //ciclo for per stampare
        for (Moto Moto2 : MotoList){
            System.out.println(Moto2.marca + " - " + Moto2.anno);
        }
    }
}
