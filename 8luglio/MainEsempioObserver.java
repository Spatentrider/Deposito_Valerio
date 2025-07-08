public class MainEsempioObserver {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();

        Observer observer1 = new ConcreteObserver("Osservatore 1");
        Observer observer2 = new ConcreteObserver("Osservatore 2");

        subject.registerObserver(observer1);
        subject.registerObserver(observer2);

        subject.setState("Stato aggiornato!");
    }
}
