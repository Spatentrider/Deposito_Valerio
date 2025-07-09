public class EsercizioFacadeMain {
    public static void main(String[] args) {


        //creazione oggetto Facade
        GestioneLuciFacade gestioneLuciFacade = new GestioneLuciFacade();
        //chiamata metodo facade che chiama metodi dei sottosistemi
        gestioneLuciFacade.accendiTutte();
        
    }
}
