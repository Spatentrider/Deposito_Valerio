class Person {

    //dichiarazione attributo privato
    private String name;

    //metodo getter
    //password e dati sensibili no get
    public String getName() {
        return name;
    }

    //metodo setter
    //dentro set if di controllo password e/o nome
    public void setName(String newName){
        this.name = newName;
    }
}


class Persona{
    //campi privati(incapsulamento)
    private String nome;
    private int età;

    //costruttora pubblico
    public Persona(String nome, int età){
        this.nome = nome;
        this.età = età;
    }

    //metodo privato utilizzato dalla classe
    private boolean verificaMaggiorenne(){
        return this.età >= 18;
    }

    public void stampaStatus(){
        if(verificaMaggiorenne()){
            System.out.println(this.nome + " è maggiorenne.");
        }
        else{
            System.out.println(this.nome + " non è maggiorenne");
        }
    }
}
public class ProvaIncapsulamento {
    public static void main(String[] args) {

        //creazione oggetto
        Person myObj = new Person();
        //chiamata metodo setName
        myObj.setName(("Pippo"));
        //stampa metodo get
        System.out.println(myObj.getName());

        //creazione oggetto
        Persona Persona = new Persona("Mario", 22);
        //chiamata metodo stampaStatus
        Persona.stampaStatus();
    }
    
}
