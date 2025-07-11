import java.util.ArrayList;
import java.util.Scanner;

// ====================== INTERFACCIA ======================
interface UserManagement {
    void createUser(String name);
    void deleteUser(String name);
    void findUser(String name);
}

// ====================== MODEL ======================
class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// ====================== STRATEGY ======================
interface SearchStrategy {
    User search(String name, ArrayList<User> users);
}

class SimpleSearch implements SearchStrategy {
    public User search(String name, ArrayList<User> users) {
        for (User user : users) {
            if (user.getName().equals(name)) {
                System.out.println("Strategy: Simple search found " + name);
                return user;
            }
        }
        System.out.println("Strategy: Simple search did not find " + name);
        return null;
    }
}

class CaseInsensitiveSearch implements SearchStrategy {
    public User search(String name, ArrayList<User> users) {
        for (User user : users) {
            if (user.getName().equalsIgnoreCase(name)) {
                System.out.println("Strategy: Case-insensitive search found " + name);
                return user;
            }
        }
        System.out.println("Strategy: Case-insensitive search did not find " + name);
        return null;
    }
}

// ====================== LEGACY SYSTEM ======================
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

// ====================== ADAPTER ======================
class UserManagementAdapter implements UserManagement {
    private LegacyUserSystem legacySystem;

    public UserManagementAdapter(LegacyUserSystem legacySystem) {
        this.legacySystem = legacySystem;
    }

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

// ====================== FACADE ======================
class UserManagementFacade {
    private Scanner scanner = new Scanner(System.in);
    private UserManagement userManagement;
    private LegacyUserSystem legacySystem;

    public UserManagementFacade(UserManagement userManagement, LegacyUserSystem legacySystem) {
        this.userManagement = userManagement;
        this.legacySystem = legacySystem;
    }

    public void avviaMenu() {
        String input;
        do {
            System.out.println("\nComandi disponibili: create, delete, find, strategy, esci");
            System.out.print("Inserisci comando: ");
            input = scanner.nextLine().toLowerCase();

            switch (input) {
                case "esci" -> {
                    System.out.println("Chiusura programma.");
                    return;
                }
                case "create", "delete", "find" -> {
                    System.out.print("Inserisci nome utente: ");
                    String nomeUtente = scanner.nextLine();
                    switch (input) {
                        case "create" -> userManagement.createUser(nomeUtente);
                        case "delete" -> userManagement.deleteUser(nomeUtente);
                        case "find" -> userManagement.findUser(nomeUtente);
                    }
                }
                case "strategy" -> scegliStrategia();
                default -> System.out.println("Comando non riconosciuto.");
            }
        } while (true);
    }

    private void scegliStrategia() {
        System.out.println("Strategie disponibili:");
        System.out.println("1. SimpleSearch");
        System.out.println("2. CaseInsensitiveSearch");
        System.out.print("Scegli una strategia (1 o 2): ");
        String scelta = scanner.nextLine();
        switch (scelta) {
            case "1" -> legacySystem.setSearchStrategy(new SimpleSearch());
            case "2" -> legacySystem.setSearchStrategy(new CaseInsensitiveSearch());
            default -> System.out.println("Scelta non valida. Strategia invariata.");
        }
    }
}

