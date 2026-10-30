
package com.mycompany.fooddelivery;

import java.sql.*;

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
    
    public static void Tables(){
        
        String tables[] = {
                "CREATE TABLE IF NOT EXISTS restaurant_accounts("
                + "id INT AUTO_INCREMENT PRIMARY KEY,"
                + "username VARCHAR (50) NOT NULL UNIQUE,"
                + "password VARCHAR (255) NOT NULL);",
                
                "CREATE TABLE IF NOT EXISTS menu("
                + "food_id INT NOT NULL PRIMARY KEY,"
                + "item_name VARCHAR(100) NOT NULL,"
                + "description VARCHAR(255) NOT NULL,"
                + "price DECIMAL (10,2) NOT NULL,"
                + "availability VARCHAR (20) DEFAULT 'available');",
                
                "CREATE TABLE IF NOT EXISTS menu_chow("
                + "restaurant_id INT NOT NULL PRIMARY KEY,"
                + "item_name VARCHAR(100) NOT NULL,"
                + "description VARCHAR(255) NOT NULL,"
                + "price DECIMAL (10,2) NOT NULL,"
                + "availability VARCHAR (20) DEFAULT 'available');",
                
                "CREATE TABLE IF NOT EXISTS menu_jollibee("
                + "foodID INT NOT NULL PRIMARY KEY,"
                + "foodName VARCHAR(100) NOT NULL,"
                + "description VARCHAR(255) NOT NULL,"
                + "prices DECIMAL (10,2) NOT NULL,"
                + "availability VARCHAR (20) DEFAULT 'available');",
                
                "CREATE TABLE IF NOT EXISTS menu_mang("
                + "foodID INT NOT NULL,"
                + "foodname VARCHAR (100) NOT NULL,"
                + "description VARCHAR (255) NOT NULL,"
                + "prices DECIMAL (10, 2) NOT NULL,"
                + "availability VARCHAR (20) DEFAULT 'available');",
                
                """
                CREATE TABLE IF NOT EXISTS orders (
                    orderid INT AUTO_INCREMENT PRIMARY KEY,
                    customerid INT NOT NULL,
                    items TEXT NOT NULL,
                    address VARCHAR(255) NOT NULL,
                    total DECIMAL(10, 2) NOT NULL,
                    status VARCHAR(30) DEFAULT 'Pending',
                    type VARCHAR(20) NOT NULL DEFAULT 'NORMAL');""",
                
                """
                CREATE TABLE IF NOT EXISTS orders_jol (
                    orderid INT AUTO_INCREMENT PRIMARY KEY,
                    customerid INT NOT NULL,
                    items TEXT NOT NULL,
                    address VARCHAR(255) NOT NULL,
                    total DECIMAL(10, 2) NOT NULL,
                    status VARCHAR(30) DEFAULT 'Pending',
                    type VARCHAR(20) NOT NULL DEFAULT 'NORMAL');""",
                
                """
                CREATE TABLE IF NOT EXISTS orders_mang (
                    orderid INT AUTO_INCREMENT PRIMARY KEY,
                    customerid INT NOT NULL,
                    items TEXT NOT NULL,
                    address VARCHAR(255) NOT NULL,
                    total DECIMAL(10, 2) NOT NULL,
                    status VARCHAR(30) DEFAULT 'Pending',
                    type VARCHAR(20) NOT NULL DEFAULT 'NORMAL');""",
                
                """
                CREATE TABLE IF NOT EXISTS orders_chow (
                    orderid INT AUTO_INCREMENT PRIMARY KEY,
                    customerid INT NOT NULL,
                    items TEXT NOT NULL,
                    address VARCHAR(255) NOT NULL,
                    total DECIMAL(10, 2) NOT NULL,
                    status VARCHAR(30) DEFAULT 'Pending',
                    type VARCHAR(20) NOT NULL DEFAULT 'NORMAL');"""
        };
        
        try(Connection c = getConnection();
            Statement st = c.createStatement()){
            
            for (String sql: tables){
                st.executeUpdate(sql);
            }
            System.out.println("All table have been created");
            
        }catch(SQLException ex ){
            ex.printStackTrace();
        }
        
        
    }
    
    public static void defaultadmin(){
       String Table = "CREATE TABLE IF NOT EXISTS users ("
                + "id INT AUTO_INCREMENT PRIMARY KEY, "
                + "username VARCHAR (50) NOT NULL UNIQUE,"
                + "password VARCHAR (255) NOT NULL);";
       
       String insert = "INSERT IGNORE INTO users(username, password) VALUES (?, ?);";
       
       try(Connection c = DBConnection.getConnection();){
           if(c == null){
               System.out.println("Cannot created default admin. Database connection failed");
               return;
           }
           
           try(Statement st = c.createStatement()){
           st.executeUpdate(Table);
           }
           
           try(PreparedStatement ps =c.prepareStatement(insert)){
               ps.setString(1, "admin");
               ps.setString(2, "admin123");
               
               int result = ps.executeUpdate();
               
               if(result > 0){
                   System.out.println("Default Admin is created");
               }else{
                   System.out.println("Admin is alreadry exist");
               }
           }
           
       }catch(SQLException ex){
           ex.printStackTrace();
       }
    }
}
