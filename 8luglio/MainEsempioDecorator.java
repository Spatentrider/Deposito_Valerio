public class MainEsempioDecorator {
    public static void main(String[] args) {

         // Component base
        Component componenteBase = new ConcreteComponent();

        // Decorazione con funzionalità Decorator
        Component componenteDecorato = new ConcreteDecoratorA(componenteBase);

        // Esecuzione dell'operazione 
        //stampa senza aggiunta
        componenteBase.operation();
        //stampa con aggiunta
        componenteDecorato.operation();
        
    }
    
}
