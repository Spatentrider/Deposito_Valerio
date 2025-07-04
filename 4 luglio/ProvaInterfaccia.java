interface Animal{
    //metodi interfaccia 
    public void animalSound(); 
    public void sleep();
}

//classe che implementa interfaccia
class Pig implements Animal{
    //definizione del corpo dei metodi dell'interfaccia
    public void animalSound(){
        System.out.println("The pig says: wee wee");
    }
    public void sleep(){
        System.out.println("Zzz");
    }
}

public class ProvaInterfaccia {
    public static void main(String[] args) {
        //creazione oggetto Pig
        Pig myPig = new Pig();
        //chiamata metodi
        myPig.animalSound();
        myPig.sleep();    
    }  
}
