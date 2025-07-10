// Interfaccia prodotto
interface IVeicolo {
    void avvia();
    void MostraTipo();
}

// Implementazione concreta Auto 
class Auto implements IVeicolo {
    public void avvia() {
        System.out.println("Avvio dell'auto");
    }
    public void MostraTipo() {
        System.out.println("Tipo: Auto");
    }
}
// Implementazione concreta Moto
class Moto implements IVeicolo {
    public void avvia() {
        System.out.println("Avvio della moto");
    }
    public void MostraTipo() {
        System.out.println("Tipo: Moto");
    }
}
// Implementazione concreta Camion
class Camion implements IVeicolo {
    public void avvia() {
        System.out.println("Avvio del camion");
    }
    public void MostraTipo() {
        System.out.println("Tipo: Camion");
    }
}

// Classe astratta factory di Veicolo
abstract class VeicoloFactory {
    //metodo astratto di crea veicolo con parametro Stringa
    public abstract IVeicolo creaVeicolo(String tipo);

    // metodo che crea un veicolo  con argomenti stringa e ne chiama i metodi
    public void usaVeicolo(String tipo) {
        IVeicolo veicolo = creaVeicolo(tipo);
        if (veicolo != null) {
            veicolo.avvia();
            veicolo.MostraTipo();
        } else {//se null errore stampa
            System.out.println("Tipo di veicolo non supportato da questa factory.");
        }
    }
}

//Creatore concreta di Auto
class AutoCreator extends VeicoloFactory {
    public IVeicolo creaVeicolo(String tipo) {
        if (tipo.equals("auto")) {
            return new Auto();
        }
        return null;
    }
}

//Creatore concreta di Moto
class MotoCreator extends VeicoloFactory {
    public IVeicolo creaVeicolo(String tipo) {
        if (tipo.equals("moto")) {
            return new Moto();
        }
        return null;
    }
}

//Creatore concreta di Camion
class CamionCreator extends VeicoloFactory {
    public IVeicolo creaVeicolo(String tipo) {
        if (tipo.equals("camion")) {
            return new Camion();
        }
        return null;
    }
}
