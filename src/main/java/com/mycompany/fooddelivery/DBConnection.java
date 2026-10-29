
package com.mycompany.fooddelivery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

    private static final String URL =
            "jdbc:mysql://localhost:3306/";

    private static final String USER = "root";
    private static final String PASS = "root";

    public static void CreateDatabase() {
        String sql = "CREATE DATABASE IF NOT EXISTS logindb";

        try (Connection conn = DriverManager.getConnection(
                    URL, USER, PASS);
             Statement stmt = conn.createStatement()) {

            stmt.executeUpdate(sql);
            System.out.println("Database logindb is ready!");

        } catch (SQLException e) {
            System.out.println("Failed to create database!");
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        try {
            Connection conn = DriverManager.getConnection(
                    URL + "logindb", USER, PASS);

            System.out.println("Database connected!");
            return conn;

        } catch (SQLException e) {
            System.out.println("Database connection failed!");
            e.printStackTrace();
            return null;
        }
    }
}
