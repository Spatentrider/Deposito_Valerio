class Studente{
    //dichiarazione attributi
    private String nome;
    private int età;

    //Costruttore
    public Studente(String nome, int età){
        this.nome = nome;
        this.età = età;
    }

    //Override del metodo toString()
    @Override
    public String toString(){
        return "Studente:" + nome + " Età:" + età;
    }


}

class Veicolo{
    //Creazione di una classe genitore. definire un metodo
    void run(){
        System.out.println("Il veicolo è in marcia");
    }
}

class Bike extends Veicolo{}

class Bike2 extends Veicolo{
    //override del metodo
    void run(){
        System.out.println("La bici sta correndo in sicurezza");
    }
}


public class ProvaOverride {
    public static void main(String[] args) {

        //creazione oggetto senza override
        Bike obj = new Bike();
        obj.run();
        //creazione oggetto con override
        Bike2 obj2 = new Bike2();
        obj2.run();

        //creazione oggetto Studente
        Studente s1 = new Studente("Luca ", 20);
        //chiama automaticamente toString()
        System.out.println(s1);
        
    }
}
