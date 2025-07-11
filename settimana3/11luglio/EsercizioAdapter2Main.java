public class EsercizioAdapter2Main {

    public static void main(String[] args) {
       //creazione oggetto legacy
       LegacyUserSystem legacySystem = new LegacyUserSystem();
        //creazione oggetto adapter con legacy passato come argomento
       UserManagement adapter = new UserManagementAdapter(legacySystem);
       //creazione oggetto facade con legacy e adapter passati come argomento
       UserManagementFacade facade = new UserManagementFacade(adapter, legacySystem);

       //chiamata metodo facade 
       facade.avviaMenu();
        
    }
    
}
