package com.mycompany.fooddelivery;

import java.sql.Connection;
import java.sql.SQLException;

public class FoodDelivery {

    public static void main(String[] args) throws Exception {
        
        DBConnection.CreateDatabase();
        DBConnection.Tables();
        DBConnection.defaultadmin();
        Connection c = DBConnection.getConnection();

       
//    Checking if the database is working
        if (c != null) {
        System.out.println("SUCCESS: Java is connected to MySQL!");
        try{
            c.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    
        int customerid = 1;
        
        Choices cs = new Choices(customerid);
        cs.setVisible(true);
        
        }else{
            System.out.println("Unable to connect into database");
        }
    }
    
}
