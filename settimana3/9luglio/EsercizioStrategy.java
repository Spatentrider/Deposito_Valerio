// Interfaccia Strategy
interface Operazione {
    int esegui(int a, int b);
}

// Strategia concreta: Addizione
class Addizione implements Operazione {
    @Override
    public int esegui(int a, int b) {
        int c = a + b;
        System.out.println("La somma di " + a + " + " + b + " è " + c);
        return c;
    }
}

// Strategia concreta: Moltiplicazione
class Moltiplicazione implements Operazione {
    @Override
    public int esegui(int a, int b) {
        int c = a * b;
        System.out.println("La moltiplicazione di " + a + " * " + b + " è " + c);
        return c;
    }
}

// Context
class Calcolatore {
    //interfaccia privata
    private Operazione operazione;

    //assegnazione istanza di un concreteStrategy
    public void setOperazione(Operazione operazione) {
        this.operazione = operazione;
    }

    //metodo dell'interfaccia specializzato nelle strategie concrete
    public void performTask(int a, int b) {
        operazione.esegui(a, b);
    }
}