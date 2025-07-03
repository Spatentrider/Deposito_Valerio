//classe astratta
abstract class Animal{
    //metodo astratta
    public abstract void animalSound();
    public void sleep(){
        System.out.println("Zzz");
    }
}
//classe derivata
class Pig extends Animal{
    //uso del metodo astratto
    public void animalSound(){
        System.out.println("The pig says: wee wee");
    }
}
//classe derivata
class Dog extends Animal{
    //uso del metodo astratto
    public void animalSound(){
        System.out.println("The dog says: bow wow");
    }
}

public class ProvaAstrazione {
    public static void main(String[] args) {

        //creazione oggetti Pig e Dog
        Pig myPig = new Pig();
        Dog myDog = new Dog();
        //chiamata metodi
        myPig.animalSound();
        myDog.animalSound();
    }
    
}
