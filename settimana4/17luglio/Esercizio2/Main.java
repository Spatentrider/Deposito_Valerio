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
    System.out.println("1. Recupera tutti i clienti che iniziano per A");
    System.out.println("2. Quanti clienti in ogni città");
    System.out.println("3. Mostra 5 clienti più recenti");
    System.out.println("4. Seleziona clienti dal più vecchio al più nuovo");
    System.out.println("0. Esci");
    System.out.print("Scelta: ");
    scelta = scanner.nextInt();
    scanner.nextLine();

    switch (scelta) {
        case 1:
            clientiCheInizianoPerA(url, user, password);
            break;
        case 2:
            numeroClientiPerCitta(url, user, password);
            break;
        case 3:
            clientiPiuRecenti(url, user, password);
            break;
        case 4:
            clientiDalPiuVecchio(url, user, password);
            break;
        case 0:
            System.out.println("Uscita...");
            break;
        default:
            System.out.println("Scelta non valida.");
    }

} while (scelta != 0);

scanner.close();
}

public static void clientiCheInizianoPerA(String url, String user, String password) {
    //query per per prendere customer che inizia per A
    String query = "SELECT first_name, last_name FROM customer WHERE first_name LIKE 'A%'";
    try (Connection conn = DriverManager.getConnection(url, user, password);
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(query)) {

        System.out.println("Clienti che iniziano con A:");
        while (rs.next()) {
            System.out.println(rs.getString("first_name") + " " + rs.getString("last_name"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


public static void numeroClientiPerCitta(String url, String user, String password) {
    //query per prendere numero clienti per città
    String query = "SELECT city.city, COUNT(*) AS numero_clienti\n" + //
                "FROM customer\n" + //
                "JOIN address ON customer.address_id = address.address_id\n" + //
                "JOIN city ON address.city_id = city.city_id\n" + //
                "GROUP BY city.city\n" + //
                "ORDER BY numero_clienti DESC;";
    try (Connection conn = DriverManager.getConnection(url, user, password);
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(query)) {

        System.out.println("Numero clienti per città:");
        while (rs.next()) {
System.out.println(rs.getString("city") + ": " + rs.getInt("numero_clienti"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

public static void clientiPiuRecenti(String url, String user, String password) {
    //query per prendere nome, cognome e data dei 5 clienti piu recenti
    String query = "SELECT first_name, last_name, create_date\n" + //
                "FROM customer\n" + //
                "ORDER BY create_date DESC\n" + //
                "LIMIT 5;";
    try (Connection conn = DriverManager.getConnection(url, user, password);
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(query)) {

        System.out.println("5 Clienti piu recenti :");
        while (rs.next()) {
            System.out.println(rs.getString("first_name") + " " + rs.getString("last_name")
                        + " - " + rs.getTimestamp("create_date"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


public static void clientiDalPiuVecchio(String url, String user, String password) {
    //query per prendere nome, cognome e data dei clienti in ordine dal piu vecchio
    String query = "SELECT first_name, last_name, create_date\n" + //
                "FROM customer\n" + //
                "ORDER BY create_date ASC;";
    try (Connection conn = DriverManager.getConnection(url, user, password);
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(query)) {

        System.out.println("Clienti in ordine dal piu vecchio a piu recente:");
        while (rs.next()) {
             System.out.println(rs.getString("first_name") + " " + rs.getString("last_name")
                        + " - " + rs.getTimestamp("create_date"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
}