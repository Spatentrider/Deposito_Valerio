public class MainEsercizioHamburger {
    public static void main(String[] args) {

        //creazione hamburger base
        Hamburger burger = new BaseBurger();

       
        //creazione oggetti Clienti observer
        Cliente cliente1 = new Cliente("Mario");
        Cliente cliente2 = new Cliente("Giovanni");

        //Creazione oggetto subject
        OrdiniSingleton gestore = OrdiniSingleton.getInstance();
        OrdiniSingleton gestore2 = OrdiniSingleton.getInstance();

        // Verifica che sia la stessa istanza
        if (gestore.equals(gestore2)) {
            System.out.println("Le istanze sono uguali");
        } else {
            System.out.println("Le istanze sono diverse");
        }

        //aggiunta clienti a gestore
        gestore.aggiungiOsservatore(cliente1);
        gestore.aggiungiOsservatore(cliente2);

        //metodo di notifica a observer
        gestore.nuovoOrdine(burger);

        //aggiunto primo decorator
        burger = new FormaggioDecorator(burger);

        //metodo di notifica a observer
        gestore.nuovoOrdine(burger);

        //aggiunto secondo decorator
        burger = new BaconDecorator(burger);

        //metodo di notifica a observer
        gestore.nuovoOrdine(burger);
        
    }
    
}
