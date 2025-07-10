import java.util.Arrays;

public class ProvaString {
    public static void main(String[] args) {
        //creazione stringa
        String parola = "hello world";

        //prova metodi lenght() stringa
        System.out.println("la lunghezza è " + parola.length());
        
        //prova metodi toUpperCase stringa
        System.out.println("la lunghezza è " + parola.toUpperCase());

        //prova metodi toLowerCase stringa
        System.out.println("la lunghezza è " + parola.toLowerCase());

        //creazione stringa
        String txt = "Please locate where 'locate' occurs!";
        //prova metodi indexOf stringa
        System.out.println(txt.indexOf("locate"));

        //creazione stringhe
        String nome = "John ";
        String cognome = "Doe";
         //prova metodi concat stringa
        System.out.println(nome.concat(cognome));

        //creazione stringhe con numeri
        String x = "10";
        String y = "20";

        //prova concatenazione  stringhe con numeri
        String z = (x + y);

        System.out.println(z);

        //prova carattere escape e stampa
        String vikings = "We are the so-called \"Vikings\" from the north";
        System.out.println(vikings);

        //prova carattere \n e stampa
        String vikings2 = "We are the so-called \n\"Vikings\" from the north";
        System.out.println(vikings2);

        //prova carattere \r e stampa
        String vikings3 = "We are the so-called \r\"Vikings\" from the north";
        System.out.println(vikings3);

        //prova carattere \t e stampa
        String vikings4 = "We are the so-called \t\"Vikings\" from the north";
        System.out.println(vikings4);

        //prova carattere \b e stampa
        String vikings5 = "We are the so-called \b\"Vikings\" from the north";
        System.out.println(vikings5);

        //prova carattere \f e stampa
        String vikings6 = "We are the so-called \f\"Vikings\" from the north";
        System.out.println(vikings6);

        //prova split
        String str = "Hello World";
        String[] words = str.split("\\s");
        System.out.println(Arrays.toString(words));

        //prova length() stringa piena
        int length = str.length();
        System.out.println("lunghezza: " + length);
        
        //prova length() stringa vuota
        String vuota = "";
        int length2 = vuota.length();
        System.out.println("lunghezza: " + length2);

        //prova equals
        String a = "ciao";
        String b = "ciao";
        System.out.println(a.equals(b));





    }

    
}
