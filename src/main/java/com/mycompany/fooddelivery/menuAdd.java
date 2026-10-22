package com.mycompany.fooddelivery;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;


public class menuAdd extends JFrame implements ActionListener{
    private JLabel title, rest, name,desc, price;
    private JTextField resID, restname, descrp, prices;
    private JButton save, clear, back;
    
    menuAdd(){
        setTitle("Menu Add Item ");
        setSize(600, 600);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        
        title = new JLabel("Add Menu Item",SwingConstants.CENTER);
        title.setFont(new Font("Arial",Font.BOLD, 14));
        title.setBounds(200, 20, 250, 30);
        add(title);
        
        rest = new JLabel("Food ID: ");
        rest.setBounds(80, 90, 130, 30);
        add(rest);
        
        resID = new JTextField();
        resID.setBounds(180, 90, 250, 30);
        add(resID);
        
        name = new JLabel("Food Name: ");
        name.setBounds(80, 140, 130, 30);
        add(name);
        
        restname = new JTextField();
        restname.setBounds(180, 140, 250, 30);
        add(restname);
        
        desc = new JLabel("Description: ");
        desc.setBounds(80, 190, 130, 30);
        add(desc);
        
        descrp = new JTextField();
        descrp.setBounds(180, 190, 250, 30);
        add(descrp);
        
        price = new JLabel("Price: ");
        price.setBounds(80, 240, 130, 30);
        add(price);
        
        prices = new JTextField();
        prices.setBounds(180, 240, 250, 30);
        add(prices);
        
        save = new JButton("Save");
        save.setBounds(230, 300, 70, 30);
        add(save);
        
        clear = new JButton("Clear");
        clear.setBounds(320, 300, 70, 30);
        add(clear);
        
        back = new JButton("Back");
        back.setBounds(20, 10, 80, 40);
        add(back);
        
        save.addActionListener(this);
        clear.addActionListener(this);
        back.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            if(e.getSource() == save){
                  String foodID = resID.getText().trim();
                  String foodname = restname.getText().trim();
                  String des = descrp.getText().trim();
                  String pri = prices.getText().trim();
                  
                  if(foodID.isEmpty() || foodname.isEmpty() || pri.isEmpty()){
                      JOptionPane.showMessageDialog(this, "Please Input Food ID, Name and Price", "Info", JOptionPane.INFORMATION_MESSAGE);
                      return;
                  }
                  int foodId;
                  double money;
                  try{
                    foodId = Integer.parseInt(foodID);
                    money = Double.parseDouble(pri);
                    
                    if(foodId <=0 || money <= 0 || !Double.isFinite(money)){
                        JOptionPane.showMessageDialog(this, "Enter a Valid Amount and ID", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    } 
                    }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(this, "Restaurant ID must be a whole number "+ "and price must be numeric.");
                    return;
                    
                   }
                   String sql = "INSERT INTO menu (food_id , item_name , description , price) VALUES (?, ?, ?, ?)";
                   try{
                      Connection c = DBConnection.getConnection(); 
                      PreparedStatement pst = c.prepareStatement(sql);
                      
                      pst.setInt(1, foodId);
                      pst.setString(2, foodname);
                      pst.setString(3, des);
                      pst.setDouble(4, money);
                      
                      int rows = pst.executeUpdate();
                      
                      if(rows > 0){
                          JOptionPane.showMessageDialog(this, "Menu Item Saved Successfully");
                          
                          resID.setText("");
                          restname.setText("");
                          descrp.setText("");
                          prices.setText("");
                      }
                      
                      
                   }catch(SQLException ex){
                       JOptionPane.showMessageDialog(this, "Error Saving Menu" + ex.getMessage(),"Database Error", JOptionPane.ERROR_MESSAGE );
                   }
            }
            
    
    }
    
   
}
