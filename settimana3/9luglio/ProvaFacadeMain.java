public class ProvaFacadeMain {
    public static void main(String[] args) {
        //creazione oggetto Facade
        Facade facade = new Facade();
        //chiamata metodo che richiama i metodi dei Subsystem
        facade.operazioneUnificata();
    }
    
}
