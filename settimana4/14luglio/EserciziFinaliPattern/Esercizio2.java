import java.util.Scanner;

//interfaccia metodo pagamento
interface Payment {
    void pay(double amount);
}

//classe Pagamento carta
class CardPayment implements Payment {
    public void pay(double amount) {
        System.out.printf("Pagamento con Carta di " + amount);
    }
}
//classe Pagamento Paypal
class PayPalPayment implements Payment {
    public void pay(double amount) {
        System.out.printf("Pagamento con PayPal di " + amount);
    }
}
//classe Pagamento Crypto
class CryptoPayment implements Payment {
    public void pay(double amount) {
        System.out.printf("Pagamento con Crypto di " + amount);
    }
}

//Metodo Factory
class PaymentFactory {
    public static Payment createPayment(String type) {

        //scelta creazione oggetti con stringa passata 
        if (type.equalsIgnoreCase("carta")) {
            return new CardPayment();
        } else if (type.equalsIgnoreCase("paypal")) {
            return new PayPalPayment();
        } else if (type.equalsIgnoreCase("crypto")) {
            return new CryptoPayment();
        } else {
            return null;
        }
    }
}

class CheckoutFacade {
    //creazione Scanner
    private final Scanner scanner = new Scanner(System.in);


    //metodo di avvio
    public void start() {

        String continua;

        //ciclo do while per prendere input utente
        do {
            // Input metodo di pagamento
            System.out.print("Scegli un metodo di pagamento (carta, paypal, crypto): ");
            String metodo = scanner.nextLine();

            //creazione oggetto tramite factory
            Payment payment = PaymentFactory.createPayment(metodo);

            if (payment == null) {
                System.out.println("Metodo di pagamento non valido.");
            } else {
                //input importo e chiamata metodo
                System.out.print("Inserisci l'importo da pagare: ");
                double amount = scanner.nextDouble();
                scanner.nextLine();
                payment.pay(amount);
            }

            //richiesta per continuare ciclo
            System.out.print("Vuoi eseguire un altro pagamento? (s/n): ");
            continua = scanner.nextLine();
        } while (!continua.equalsIgnoreCase("n"));

        System.out.println("Programma terminato.");
    }
}
