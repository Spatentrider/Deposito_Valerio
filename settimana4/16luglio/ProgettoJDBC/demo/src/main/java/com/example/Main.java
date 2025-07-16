package com.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/sakila"; // Cambia "world" con il nome corretto del tuo DB
        String user = "root";
        String password = "prova";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connessione riuscita");
        } catch (SQLException e) {
            System.out.println("Errore nella connessione");
            e.printStackTrace();
        }
    }
}
