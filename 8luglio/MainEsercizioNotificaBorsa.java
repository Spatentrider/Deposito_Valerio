public class MainEsercizioNotificaBorsa {
    public static void main(String[] args) {

        //Creazione oggetto AgenziaBorsa 
        AgenziaBorsaSingleton agenziaborsa = AgenziaBorsaSingleton.getInstance();

        //Creazione oggetti InvestitorePrivato  InvestitoreBancario
        Investitore investitoreprivato = new InvestitorePrivato("Marco");
        Investitore investitorebancario = new InvestitoreBancario("Paolo");


        agenziaborsa.aggiungiInvestitore(investitorebancario);
        agenziaborsa.aggiungiInvestitore(investitoreprivato);

        agenziaborsa.aggiornaValoreAzione("Ferrari", 7);
        agenziaborsa.aggiornaValoreAzione("Barilla", 99);
        
    }
    
}
