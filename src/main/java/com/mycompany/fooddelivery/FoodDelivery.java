package com.mycompany.fooddelivery;

import java.sql.Connection;

public class FoodDelivery {

    public static void main(String[] args) {
       
        Choices cs = new Choices();
        cs.setVisible(true);
        Connection c = DBConnection.getConnection();

//    Checking if the database is working
        if (c != null) {
        System.out.println("SUCCESS: Java is connected to MySQL!");
    }
        
    }
}
