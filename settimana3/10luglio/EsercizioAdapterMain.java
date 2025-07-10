public class EsercizioAdapterMain {
    public static void main(String[] args) {
        AmericanSocket americanSocket = new AmericanSocket();
        //creazione oggetto Adapter con passato oggetto adaptee
        EuropeanSocket europeanDevice = new SocketAdapter(americanSocket);
        //chiamata metodo

        Lampada lampada = new Lampada(europeanDevice);
        lampada.giveElectricity();
    }
}
