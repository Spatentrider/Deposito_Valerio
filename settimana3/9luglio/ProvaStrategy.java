// Interfaccia Strategy
interface Strategy {
    void execute();
}

// Strategie Concrete
class ConcreteStrategyA implements Strategy {
    //override metodo interfaccia
    public void execute() {
        System.out.println("Strategia A eseguita.");
    }
}

class ConcreteStrategyB implements Strategy {
    //override metodo interfaccia
    public void execute() {
        System.out.println("Strategia B eseguita.");
    }
}

// Context
class Context {
    //interfaccia privata
    private Strategy strategy;

    //assegnazione istanza di un concreteStrategy
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    //metodo dell'interfaccia specializzato nelle strategie concrete
    public void performTask() {
        strategy.execute();
    }
}