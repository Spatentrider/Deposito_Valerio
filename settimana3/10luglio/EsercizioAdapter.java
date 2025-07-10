//interfaccia Target
interface EuropeanSocket{
    void giveElectricity();
}
//classe da adattare
class AmericanSocket{
    void provideElectricity(){
        System.out.println("da elettricità");
    }
}
//classe adapter implementa interfaccia e contiene istanza della classe da adattare
class SocketAdapter implements EuropeanSocket{
    private AmericanSocket americanSocket;

    //costruttore con classe da adattare
    public SocketAdapter(AmericanSocket americanSocket){
        this.americanSocket = americanSocket;
    }

    //metodo interfaccia che richiama metodo della classe da adattare
    public void giveElectricity(){
        americanSocket.provideElectricity();
    }
}

class Lampada {
    private EuropeanSocket socket;

    public Lampada(EuropeanSocket socket) {
        this.socket = socket;
    }

    public void giveElectricity() {
        System.out.println("Lampada accesa");
        socket.giveElectricity();
    }

}