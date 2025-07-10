
//classe base
class Animal{
    public void animalSound(){
        System.out.println("The animal makes a sound");
    }
}
//classe derivata con metodo override
class Pig extends Animal{
    public void animalSound(){
        System.out.println("The pig says: wee wee");
    }}
//classe derivata con metodo override
class Dog extends Animal{
    public void animalSound(){
        System.out.println("The dog says: bow bow");
    }
}
public class EsempioPolimorfismo {
    public static void main(String[] args) {
        //creazione oggetti
        Animal myAnimal = new Animal();
        Animal myPig = new Pig();
        Animal myDog = new Dog();

        //chiamata metodi
        myAnimal.animalSound();
        myPig.animalSound();
        myDog.animalSound();   
    }
    
}
