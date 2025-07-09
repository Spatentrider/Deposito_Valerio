public class EsercizioStrategyMain {
    public static void main(String[] args) {

        Calcolatore calcolatore = new Calcolatore();
        calcolatore.setOperazione(new Addizione());
        calcolatore.performTask(4, 7);
        calcolatore.setOperazione(new Moltiplicazione());
        calcolatore.performTask(4, 7);
        
    }
    
}
