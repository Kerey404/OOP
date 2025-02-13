package kz.aitu.oop.Erasyl_Kassymkhan.Transport.OOP.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/transport_db";
    private static final String USER = "postgres";
    private static final String PASSWORD = "MasterKeyForSql";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database", e);
        }
    }
}
