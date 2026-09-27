package com.mycompany.fooddelivery;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
       private static final String URL = "jdbc:mysql://localhost:3306/logindb";
       private static final String user = "root";
       private static final String pass = "123456";
       
       public static Connection getConnection() {
        try {
            Connection conn = DriverManager.getConnection(
                    URL,
                    user,
                    pass
            );

            System.out.println("Database connected!");

            return conn;

        } catch (SQLException e) {
            System.out.println("Database connection failed!");
            e.printStackTrace();
            return null;
        }
       }    
}
