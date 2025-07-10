public class EsercizioStrategyMain {
    public static void main(String[] args) {

        //creazione oggetto calcolatore
        Calcolatore calcolatore = new Calcolatore();
        //settata strategy Addizione
        calcolatore.setOperazione(new Addizione());
        //chiamata metodo Addizione
        calcolatore.performTask(4, 7);
        //settata strategy Moltiplicazione
        calcolatore.setOperazione(new Moltiplicazione());
        //chiamata metodo Moltiplicazione
        calcolatore.performTask(4, 7);
        
    }
    
}
