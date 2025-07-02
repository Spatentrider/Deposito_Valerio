//classe padre
class Vehicle{
    //stringa protected
    protected String brand = "Ford";
    //metodo che verrà ereditayo
    public void honk(){
        System.out.println("Tuut, Tuut!");
    }
}
//classe figlia che estende Vehicle
class Car extends Vehicle{
    private String modelName = "Fiat";

public String getModelName() {
        return modelName;
    }
}

public class ProvaEreditarietà{
    public static void main(String[] args) {

        //creazione oggetto Car
        Car myCar = new Car();
        //chiamata metodo ereditato da classe madre
        myCar.honk();
        //stampa attributo ereditato e attributo privato classe figlia
        System.out.println(myCar.brand + " " + myCar.getModelName());
        
    }
}