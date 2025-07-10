public class MainEsercizioObserver {
    public static void main(String[] args) {
        
        //creazione oggetto StazioneMeteo
        StazioneMeteo stazione = new StazioneMeteo();

        //Creazione oggetti DisplayConsole e DisplayMobile
        ObserverDisplay display1 = new DisplayConsole("A");
        ObserverDisplay display2 = new DisplayMobile("B");

        //chiamata metodo per aggiungere display
        stazione.aggiungiDisplay(display1);
        stazione.aggiungiDisplay(display2);

        //chiamata metodo per cambiare temperatira
        stazione.setTemperatura(18.5f);
        stazione.setTemperatura(21.0f);
    }
}
