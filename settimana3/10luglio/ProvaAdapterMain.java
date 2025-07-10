public class ProvaAdapterMain {
    public static void main(String[] args) {
        //Oggetto da adattare
        Adaptee adaptee = new Adaptee();
        //Oggetto adapter che prende come parametro classe da adattare
        Target adapter = new Adapter(adaptee);
        //chiamata metodo adapter
        adapter.request();
    }    
}
