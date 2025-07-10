class Auto {
    String marca;
    int anno;
    double prezzo;

    void mostraInfo() {
        System.out.println(marca + " - " + anno + " - $ " + prezzo);
    }
}

class Studente {
    String nome;
    static int totaleStudenti = 0;

    Studente(String nome) {
        this.nome = nome;
        totaleStudenti++;
    }
}

public class EsempioClassi {

    public static void main(String[] args) {

        // Creazione oggetto Auto
        Auto miaAuto = new Auto();
        miaAuto.marca = "Tesla";
        miaAuto.anno = 2023;
        miaAuto.prezzo = 59999.99;
        miaAuto.mostraInfo();

        // Creazione oggetti Studente
        Studente studente1 = new Studente("Marco");
        System.out.println("Totale studenti: " + Studente.totaleStudenti);

        Studente studente2 = new Studente("Mirko");
        System.out.println("Totale studenti: " + Studente.totaleStudenti);
    }
}
