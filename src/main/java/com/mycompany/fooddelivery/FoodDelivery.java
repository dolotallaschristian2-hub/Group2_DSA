package com.mycompany.fooddelivery;

import java.sql.Connection;

public class FoodDelivery {

    public static void main(String[] args) {
       
        fooddeliveryGUI fooddelivery = new fooddeliveryGUI();
        fooddelivery.setVisible(true);
        Connection conn = DBConnection.getConnection();

    if (conn != null) {
        System.out.println("SUCCESS: Java is connected to MySQL!");
    }
        
    }
}
