package com.mycompany.fooddelivery;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;


public class menuaddMang extends JFrame implements ActionListener{
    private JLabel title, rest, name,desc, price;
    private JTextField resID, restname, descrp, prices;
    private JButton save, clear, back;
    
    menuaddMang(){
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
                String Des = descrp.getText().trim();
                String pric = prices.getText().trim();
                
                if(foodID.isEmpty() || foodname.isEmpty() || pric.isEmpty()){
                    JOptionPane.showMessageDialog(this, "Please input the ID, Name and Prices", "Info", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                
                int foodId;
                double price;
                
                try{
                    foodId = Integer.parseInt(foodID);
                    price = Double.parseDouble(pric);
                    
                    if(foodId <=0 || price <= 0 || !Double.isFinite(price)){
                        JOptionPane.showMessageDialog(this, "Enter a Valid Amount and ID", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(this, "Restaurant ID must be a whole number "+ "and price must be numeric.");
                    return;
                }
                
                String sql = "INSERT INTO menu_mang (foodID , foodname, description, prices) VALUES (?, ?, ?, ?)";
                try{
                    Connection c = DBConnection.getConnection();
                    PreparedStatement pst = c.prepareStatement(sql);
                    
                    pst.setInt(1, foodId);
                    pst.setString(2, foodname);
                    pst.setString(3, Des);
                    pst.setDouble(4, price);
                     int rows = pst.executeUpdate();
                      
                      if(rows > 0){
                          JOptionPane.showMessageDialog(this, "Menu Item Saved Successfully");
                      
                            resID.setText("");
                            restname.setText("");
                            descrp.setText("");
                            prices.setText("");
                                    
                            }
                    
                    
                }catch(SQLException ex){
                    JOptionPane.showMessageDialog(this, "Database has an error", "Error", JOptionPane.ERROR_MESSAGE);
                }
        } else if(e.getSource() == clear){
                resID.setText("");
                restname.setText("");
                descrp.setText("");
                prices.setText("");
        } else if(e.getSource() == back){
                mangRestaurant r = new mangRestaurant();
                r.setVisible(true);
                this.dispose();
        }
    }
}

