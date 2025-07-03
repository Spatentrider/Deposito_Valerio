import java.util.ArrayList;

public class ProvaPolimorfismo {

    public static void azionatore(X obj){
        obj.azione();
    }

    public static void main(String[] args) {
        ArrayList<X> InsiemeX = new ArrayList<X>();

        X x = new X();
        X1 x1 = new X1();
        X2 x2 = new X2();

        InsiemeX.add(x);
        InsiemeX.add(x1);
        InsiemeX.add(x2);

        for (X elemento : InsiemeX) {
            azionatore(elemento);
        }
    }
}

class X {
    public void azione() {
        System.out.println("Azione generica");
    }
}

class X1 extends X {
    public void azione() {
        System.out.println("azione X1");
    }
}

class X2 extends X {
    public void azione() {
        System.out.println("azione X2");
    }
}
