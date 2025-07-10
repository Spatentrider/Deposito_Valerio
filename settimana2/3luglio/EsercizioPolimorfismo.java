//classe base
class Persona{
    //attributo protetto
    protected String nome;
    //costruttore con parametro
    Persona(String nome){
        this.nome = nome;
    }

    //metodo base
    public void saluto(){
        System.out.println("Ciao! Sono " + nome);
    }

}
//classe derivata
class Pirata extends Persona{
    //costruttore con super
    Pirata(String nome){
        super(nome);
    }

    //override del metodo base
    @Override
    public void saluto(){
        System.out.println("Ahrrr! Sono il pirata " + nome);
    }
}

public class EsercizioPolimorfismo {
    public static void main(String[] args) {
        //creazione oggetti Persona e oggetto Pirata 
        Persona persona = new Persona("Mario");
        Persona persona2 = new Persona("Luigi");
        Pirata pirata = new Pirata("Jack");

        //chiamata metodi base
        persona.saluto();
        persona2.saluto();
        //chiamata metodo con override
        pirata.saluto();
    }
    
}
