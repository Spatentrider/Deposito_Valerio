import java.util.Scanner;

//creazione classe
class BankAccount{
    String accountHolderName;
    double balance;

    //costruttore con parametro per il nome
    BankAccount(String accountHolderName){
        this.accountHolderName = accountHolderName;
        this.balance = Math.random() * 100;
    }

    //metodo per deposito
    void deposit(double amount){
        this.balance += amount;
        System.out.println("Il saldo attuale è " + this.balance);

    }

    //metodo per prelievo
    void withdraw(double amount){
        if (amount > this.balance) {
            System.out.println("Errore: saldo insufficiente.");
        } else {
        this.balance -= amount;
        System.out.println("Il saldo attuale è " + this.balance);
    }
    }

    //metodo per saldo
    void displayBalance(){
         System.out.println("Il saldo attuale è " + this.balance);
    }
}

public class EsercizioClassi2 {
    public static void main(String[] args) {
        //dichiarazione variabili
        String input;
        double inputnumeri;

        //creazione oggetti scanner
        Scanner stringhe = new Scanner(System.in);
        Scanner numeri = new Scanner(System.in);

        //ciclo do while per prendere input utente
        do{
            System.out.println("Inserisci nome");
            input = stringhe.nextLine();
            BankAccount BankAccount = new BankAccount(input);
            System.out.println("Inserisci \"deposito\" per effettuare un deposito, \"prelievo\" per effettuare un prelievo o \"saldo\" per mostrare il saldo attuale" );
            input = stringhe.nextLine();
            //controllo input e chiamata metodo deposit
            if(input.equals("deposito")){
                System.out.println("inserisci la cifra che vuoi depositare: ");
                inputnumeri = numeri.nextInt();
                BankAccount.deposit(inputnumeri);
            }//controllo input e chiamata withdraw
            else if(input.equals("prelievo")){
                System.out.println("inserisci la cifra che vuoi prelevare: ");
                inputnumeri = numeri.nextInt();
                BankAccount.withdraw(inputnumeri);

            }
            //controllo input e chiamata metodo displayBalance
            else if(input.equals("saldo")){
                BankAccount.displayBalance();
            }
            //errore input
            else{
                System.out.println("scelta non valida");
            }

            System.out.println("Vuoi continuare? : \"si\" o \"no\"" );
            input = stringhe.nextLine();
        }while(!input.equals("no")); //scrivere fine per uscire dal programma
        
    System.out.println("Programma terminato");
    }
    
}
