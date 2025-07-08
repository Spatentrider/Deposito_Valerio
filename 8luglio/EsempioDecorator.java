// Interfaccia Component definisce interfaccia comune per concreteComponent e Decorator
interface Component {
    void operation();
}

// Componente Concreto, oggetti a cui vogliamo aggiungere funzionalità
class ConcreteComponent implements Component {
    public void operation() {
        System.out.println("Operazione base");
    }
}

// Decorator astratto che incapsula l'oggetto Component
abstract class Decorator implements Component {
    //riferimento oggetto Component
    protected Component component;
    //costruttore con riferimento interfaccia
    public Decorator(Component component) {
        this.component = component;
    }

    //metodo che richiama metodo interfaccia
    public void operation() {
        component.operation();
    }
}

// Decoratore Concreto estende Decorator
class ConcreteDecoratorA extends Decorator {
    //costruttore con super di oggetto Component
    public ConcreteDecoratorA(Component component) {
        super(component);
    }

    //metodo con funzionalità aggiuntive
    public void operation() {
        super.operation();
        System.out.println("Aggiunta funzionalità A");
    }
}