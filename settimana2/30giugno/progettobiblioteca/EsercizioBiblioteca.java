import java.util.ArrayList;
import java.util.Scanner;

class Book{
    //dichiarazione attributi
    String title;
    String author;
    boolean isAvailable;

    // Costruttore con parametri
    Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    //metodo per mostrare informazioni libro
    void displayBookInfo(){
        //controllo booleano se libro disponibile per stampe diverse
        if(isAvailable){
             System.out.println("titolo " + title + " \nautore: " + author + " è disponibile");
        }
        else{
                System.out.println("titolo " + title + " \nautore: " + author + " non è disponibile");
        }

    }

}

class Library{

    //dichiarazione ArrayList di Book
    ArrayList<Book> books;

    //costruttore con creazione ArrayList di Book
    Library(){
        books = new ArrayList<>();
    }

    //metodo per aggiungere libri all ArrayList
    void addBook(Book book){
        books.add(book);
        System.out.println("Libro aggiunto: " + book.title);
    }

    //metodo per visualizzare libri
    void displayBooks(){

        //ciclo for con chiamata al metodo di Book
         for (Book book : books) {
            book.displayBookInfo();
        }
    }

  void borrowBook(String title) {
    //dichiarazione booleano per controllo se libro esiste
    boolean trovato = false;

    //ciclo for per scorrere libri
    for (Book book : books) {
        //se trova il libro controlla trovato è true
        if (book.title.equals(title)) {
            trovato = true;
            //controllo booleano di classe Book
            if (book.isAvailable) {
                //se true, diventa false 
                book.isAvailable = false;
                System.out.println("Hai preso in prestito: " + book.title);
            } else {
                System.out.println("Il libro non è disponibile.");
            }
            break; // esce dal ciclo una volta trovato il libro
        }
    }

    //se primo booleano falso vuol dire che non è presente nell'ArrayList
    if (!trovato) {
        System.out.println("Libro non trovato.");
    }
}
   void returnBook(String title){
    //dichiarazione booleano per controllo se libro esiste
    boolean trovato = false;

    //ciclo for per scorrere libri
    for (Book book : books) {
        //se trova il libro controlla trovato è true
        if (book.title.equals(title)) {
            trovato = true;
            //controllo booleano di classe Book
            if (!book.isAvailable) {
                //se false, diventa true 
                book.isAvailable = true;
                System.out.println("Hai restituito : " + book.title);
            } else {
                System.out.println("Il libro è gia disponibile.");
            }
            break; // esce dal ciclo una volta trovato il libro
        }
    }

    //se primo booleano falso vuol dire che non è presente nell'ArrayList
    if (!trovato) {
        System.out.println("Libro non trovato.");
    }

    }

    void searchBook(String keyword) {
    //booleano per condizione
    boolean trovato = false;

    //ciclo for dell'arraylist
    for (Book book : books) {
        //se trova nome del libro o dell'autore booleano diventa true e chiamata metodo info
        if (book.title.equalsIgnoreCase(keyword) || book.author.equalsIgnoreCase(keyword)) {
            trovato = true;
            book.displayBookInfo();  // Mostra le info del libro trovato
        }
    }//stampa se booleano resta falso
    if (!trovato) {
        System.out.println("Libro non trovato.");
    }
}


    }





public class EsercizioBiblioteca{
    public static void main(String[] args) {

        //creazione oggetto Scanner
        Scanner scanner = new Scanner(System.in);
        //creazione oggetto Library
        Library biblioteca = new Library();
        //stringa per prendere input
        String comando = "";

        //ciclo do -while per prendere input utente 
        do{
            System.out.println("Inserisci un comando: aggiungi, visualizza, prestito, restituzione, ricerca o fine");
            comando = scanner.nextLine();
            //condizione per aggiungere libri
            if (comando.equals("aggiungi")) {
                //richiesta titolo e autore all'utente
                System.out.print("Inserisci il titolo del libro: ");
                String titolo = scanner.nextLine();
                System.out.print("Inserisci l'autore del libro: ");
                String autore = scanner.nextLine();
                //chiamata metodo addBook per aggiungere
                biblioteca.addBook(new Book(titolo, autore));
            }//condizione per visualizzare libri
            else if (comando.equals("visualizza")) {
                //chiamata metodo per visualizzare libri
                biblioteca.displayBooks();
            }// condizione per chiedere prestito libri 
            else if (comando.equals("prestito")) {
                //richiesta input
                System.out.print("Inserisci il titolo del libro da prendere in prestito: ");
                String titolo = scanner.nextLine();
                //chiamata metodo prestito
                biblioteca.borrowBook(titolo);
            }//condizione per restituire libri
             else if (comando.equals("restituzione")) {
                //richiesta input
                System.out.print("Inserisci il titolo del libro da restituire: ");
                String titolo = scanner.nextLine();
                //chiamata metodo restituzione
                biblioteca.returnBook(titolo);
            }//condizione per ricerca libri
            else if (comando.equals("ricerca")) {
                //richiesta input
                System.out.print("Inserisci il titolo del libro o dell'autore che vuoi cercare: ");
                String titolo = scanner.nextLine();
                //chiamata metodo ricerca
                biblioteca.searchBook(titolo);
            }//condizione per gestire eccezioni
             else if (!comando.equals("fine")) {
                System.out.println("Comando non valido.");
            }
        }while (!comando.equals("fine"));// ciclo finisce con comando "fine"

        //stampa finale
        System.out.println("Programma terminato.");
        
    }

}