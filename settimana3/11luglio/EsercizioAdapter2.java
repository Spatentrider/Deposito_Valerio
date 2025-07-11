import java.util.ArrayList;
import java.util.Scanner;

//interfaccia
interface UserManagement {
    void createUser(String name);
    void deleteUser(String name);
    void findUser(String name);
}

//classe Utente
class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

//interfaccia Strategy
interface SearchStrategy {
    User search(String name, ArrayList<User> users);
}
//strategia per cercare utente base
class SimpleSearch implements SearchStrategy {
    public User search(String name, ArrayList<User> users) {
        for (User user : users) {
            if (user.getName().equals(name)) {
                System.out.println("Utente trovato tramite ricerca semplice" + name);
                return user;
            }
        }
        System.out.println("Utente non trovato");
        return null;
    }
}
//strategia per cercare utente caseIsensitive
class CaseInsensitiveSearch implements SearchStrategy {
    public User search(String name, ArrayList<User> users) {
        for (User user : users) {
            if (user.getName().equalsIgnoreCase(name)) {
                System.out.println("Utente trovato tramite ricerca case insensitive " + name);
                return user;
            }
        }
        System.out.println("Utente non trovato");
        return null;
    }
}

//classe Legacy da adattare
class LegacyUserSystem {
    ArrayList<User> users = new ArrayList<>();
    private SearchStrategy searchStrategy = new SimpleSearch(); // Default strategy

    public void setSearchStrategy(SearchStrategy strategy) {
        this.searchStrategy = strategy;
    }

    public void addUser(User user) {
        users.add(user);
        System.out.println("Legacy: User " + user.getName() + " aggiunto.");
    }

    public void removeUser(User user) {
        users.removeIf(u -> u.getName().equals(user.getName()));
        System.out.println("Legacy: User " + user.getName() + " rimosso.");
    }

    public User searchUser(User user) {
        return searchStrategy.search(user.getName(), users);
    }
}

//classe Adapter
class UserManagementAdapter implements UserManagement {
    private LegacyUserSystem legacySystem;

    //costruttore con parametro oggetto Legacy
    public UserManagementAdapter(LegacyUserSystem legacySystem) {
        this.legacySystem = legacySystem;
    }

    //metodi per creare, cancellare e cercare Utente
    public void createUser(String name) {
        legacySystem.addUser(new User(name));
    }

    public void deleteUser(String name) {
        legacySystem.removeUser(new User(name));
    }

    public void findUser(String name) {
        legacySystem.searchUser(new User(name));
    }
}

//classe Facade  per gestire menu con input utente
class UserManagementFacade {
    //creazione oggetti Scanner , Legacy e adapter
    private Scanner scanner = new Scanner(System.in);
    private UserManagement userManagement;
    private LegacyUserSystem legacySystem;

    //costruttore con parametri
    public UserManagementFacade(UserManagement userManagement, LegacyUserSystem legacySystem) {
        this.userManagement = userManagement;
        this.legacySystem = legacySystem;
    }

    //metodo per gestire menu
    public void avviaMenu() {
        String input;
        do {
            System.out.println("Comandi disponibili: create, delete, find, strategy, esci");
            System.out.print("Inserisci comando: ");
            input = scanner.nextLine();

            switch (input) {
                case "esci":
                    System.out.println("Chiusura programma.");
                    return;

                case "create":
                case "delete":
                case "find":
                    //prende nome utente e chiamata metodi create, delete o find dell'adapter
                    System.out.print("Inserisci nome utente: ");
                    String nomeUtente = scanner.nextLine();
                    switch (input) {
                        case "create":
                            userManagement.createUser(nomeUtente);
                            break;
                        case "delete":
                            userManagement.deleteUser(nomeUtente);
                            break;
                        case "find":
                            userManagement.findUser(nomeUtente);
                            break;
                    }
                    break;

                case "strategy"://case per cambiare strategia del find
                    scegliStrategia();
                    break;

                default:
                    System.out.println("Comando non riconosciuto.");
            }
        } while (true);
    }

    //metodo per scegliere strategyy con input
    private void scegliStrategia() {
        System.out.println("Strategie disponibili:");
        System.out.println("1. SimpleSearch");
        System.out.println("2. CaseInsensitiveSearch");
        System.out.print("Scegli una strategia (1 o 2): ");
        String scelta = scanner.nextLine();
        switch (scelta) {
            case "1"://imposta find con strategia base
                legacySystem.setSearchStrategy(new SimpleSearch());
                break;
            case "2"://imposta find con strategia case insensitive
                legacySystem.setSearchStrategy(new CaseInsensitiveSearch());
                break;
            default:
                System.out.println("Scelta non valida. Strategia invariata.");
        }
    }
}
