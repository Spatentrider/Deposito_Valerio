import java.util.ArrayList;
import java.util.List;

// Interfaccia Observer
interface ObserverDisplay {
    void aggiorna(float temperatura);
}

// Interfaccia Subject
interface SubjectStazioneMeteo {
    void aggiungiDisplay(ObserverDisplay display);
    void rimuoviDisplay(ObserverDisplay display);
    void notificaDisplay();
}

// ConcreteSubject classe che viene osservata
class StazioneMeteo implements SubjectStazioneMeteo {
    private List<ObserverDisplay> displays = new ArrayList<>();
    private float temperatura;

    //
    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
        notificaDisplay();
    }

    //metodo aggiunta display
    public void aggiungiDisplay(ObserverDisplay display) {
        displays.add(display);
    }

    //metodo aggiunta display
    public void rimuoviDisplay(ObserverDisplay display) {
        displays.remove(display);
    }

    //metodo scorrere display e chiamata metodo aggiorna
    public void notificaDisplay() {
        for (ObserverDisplay display : displays) {
            display.aggiorna(temperatura);
        }
    }
}

// ConcreteObserver Console
class DisplayConsole implements ObserverDisplay {
    private String name;

    public DisplayConsole(String name) {
        this.name = name;
    }

    //metodo stampa
    public void aggiorna(float temperatura) {
        System.out.println("Display Console " + name + " Temperatura cambiata " + temperatura);
    }
}

// ConcreteObserver Mobile
class DisplayMobile implements ObserverDisplay {
    private String name;


    public DisplayMobile(String name) {
        this.name = name;
    }

    //metodo stampa
    public void aggiorna(float temperatura) {
        System.out.println("Display Mobile : " + name + " Temperatura cambiata " + temperatura);
    }
}
