// Target interface
interface Target {
    void request();
}

// Adaptee
class Adaptee {
    void specificRequest() {
        System.out.println("Richiesta specifica eseguita.");
    }
}

// Adapter
class Adapter implements Target {
    //istanza privata della classe da adattare
    private Adaptee adaptee;

    //costruttore con parametro istanza
    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    //metodo interfaccia che richiama metodo della classe da adattare
    public void request() {
        adaptee.specificRequest();
    }
}