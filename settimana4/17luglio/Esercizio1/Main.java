package com.example;

import java.util.Scanner;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        //creazione dati per connessione database
        String url = "jdbc:mysql://localhost:3306/sakila"; // Cambia "world" con il nome corretto del tuo DB
        String user = "";
        String password = "";

        //creazione Scanner
        Scanner scanner = new Scanner(System.in);
        int scelta;

//ciclo do while input utente
 do {
        System.out.println("Menu:");
        System.out.println("1. Mostra i 10 film più noleggiati");
        System.out.println("2. Mostra i 10 film meno noleggiati");
        System.out.println("0. Esci");
        System.out.print("Scelta: ");
        scelta = scanner.nextInt();

        //mostra 10 film piu noleggiati
        if (scelta == 1) {
            mostraFilmNoleggiati(url, user, password, true);
        //mostra 10 film meno noleggiati
        } else if (scelta == 2) {
            mostraFilmNoleggiati(url, user, password, false);
        } else if (scelta == 0) {
            System.out.println("Uscita...");
        } else {
            System.out.println("Scelta non valida.");
        }

    } while (scelta != 0);

    scanner.close();
}


    public static void mostraFilmNoleggiati(String url, String user, String password, boolean piuNoleggiati) {
    String ordine;
    if (piuNoleggiati) {// se case 1 ORDER BY DESC
        ordine = "DESC";
    } else {//altrimenti ASC
        ordine = "ASC";
    }

    String descrizione;
    if (piuNoleggiati) {//se case 1 stampa piu
        descrizione = "più";
    } else {//altrimenti meno
        descrizione = "meno";
    }
    //query che seleziona titolo dei film, conta il rental, unisce la table film con inventory tramite code e rental con inventory con JOIN e le raggruppa per titolo e le ordina per l'ordine scelto fino a 10
    String query = """
    SELECT f.title, COUNT(r.rental_id) AS numero_noleggi
    FROM film f
    JOIN inventory i ON f.film_id = i.film_id
    JOIN rental r ON i.inventory_id = r.inventory_id
    GROUP BY f.title
    ORDER BY numero_noleggi """ + " " + ordine + """
    LIMIT 10
""";


    try (
        //usa connection per stabilire connessione
        Connection conn = DriverManager.getConnection(url, user, password);
        //crea statement
        Statement stmt = conn.createStatement();
        //fa una query con la query creata come argomento
        ResultSet rs = stmt.executeQuery(query)
    ) {
        System.out.println("I 10 film " + descrizione + " noleggiati:");
        while (rs.next()) {
            //fino a 10 stampa il risultato della query
            String titolo = rs.getString("title");
            int numero = rs.getInt("numero_noleggi");
            System.out.println(titolo + " - " + numero + " noleggi");
        }
    } catch (SQLException e) {
        System.out.println("Errore nella connessione o nella query.");
        e.printStackTrace();
    }
}
}