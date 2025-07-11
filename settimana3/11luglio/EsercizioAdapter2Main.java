public class EsercizioAdapter2Main {

    public static void main(String[] args) {
       LegacyUserSystem legacySystem = new LegacyUserSystem();
        UserManagement adapter = new UserManagementAdapter(legacySystem);
        UserManagementFacade facade = new UserManagementFacade(adapter, legacySystem);

        facade.avviaMenu();
        
    }
    
}
