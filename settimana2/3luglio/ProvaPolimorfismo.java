import java.util.ArrayList;



public class ProvaPolimorfismo {


    //ArrayList che accetta sia classe madre che figli
    ArrayList <X> InsiemeX = new ArrayList<X>();

    void azionatore(X obj){

        //metodo azione cambia in base all'oggetto
        obj.azione();

    }


    public static void main(String[] args) {
        

    }

    //classe madre
    class X {
   
    void azione(){
        System.out.println("azione generica");
    }
    

}

 //classe figlia 
 class X2 extends X {
   
    //polimorfismo
    void azione(){
        System.out.println("azione x2");
    }

}
//classe figlia 
 class X1 extends X {
   
    //polimorfismo
     void azione(){
        System.out.println("azione x1");
    }
   
}}
