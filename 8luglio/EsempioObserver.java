import java.util.ArrayList;
import java.util.List;

// Interfaccia Observer
interface Observer {
    void update(String message);
}

// Interfaccia Subject
interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}

// ConcreteSubject classe che viene osservata
class ConcreteSubject implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String state;

    //cambia stato e notifica gli observers
    public void setState(String state) {
        this.state = state;
        notifyObservers();
    }

    //aggiungere observer
    public void registerObserver(Observer o) {
        observers.add(o);
    }

     //rimuovere observer
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    //notifica observers
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(state);
        }
    }
}

// ConcreteObserver classe che osserva il Subjeect
class ConcreteObserver implements Observer {
    private String name;

    //costruttore
    public ConcreteObserver(String name) {
        this.name = name;
    }

    //metodo di stampa
    public void update(String message) {
        System.out.println(name + " ha ricevuto aggiornamento: " + message);
    }
}