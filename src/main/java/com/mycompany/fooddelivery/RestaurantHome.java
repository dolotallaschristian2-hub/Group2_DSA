package com.mycompany.fooddelivery;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class RestaurantHome extends JFrame implements ActionListener{
        private JButton mcd, chow, jol, mang, back, logout;
        private JLabel title;
        private int customerid;
        
            RestaurantHome(int customerid){
            setSize(600, 600);
            setLayout(null);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setResizable(false);
            
            this.customerid = customerid;
            
            title = new JLabel("Welcome",SwingConstants.CENTER);
            title.setBounds(250, 30, 100, 30);
            title.setFont(new Font("Arial", Font.BOLD, 16));
            add(title);
            
            mcd = new JButton("Mcdonalds");
            mcd.setBounds(120, 230, 170, 40);
            add(mcd);
            
            chow = new JButton("Chowking");
            chow.setBounds(120, 160, 170, 40);
            add(chow);
            
            mang = new JButton("Mang Inasal");
            mang.setBounds(350, 160, 170, 40);
            add(mang);
            
            jol = new JButton("Jollibee");
            jol.setBounds(350, 230, 170, 40);
            add(jol);
            
            logout = new JButton("Logut");
            logout.setBounds(500, 10, 80, 40);
            add(logout);
            
            mcd.addActionListener(this);
            chow.addActionListener(this);
            mang.addActionListener(this);
            jol.addActionListener(this);
            logout.addActionListener(this);
            
        }

    @Override
    public void actionPerformed(ActionEvent e) {
            if(e.getSource() == mcd){
                mcdoRestaurant re = new mcdoRestaurant();
                re.setVisible(true);
                
            }else if(e.getSource() == chow){
                
            }else if(e.getSource() == mang){
                mangRestaurant m = new mangRestaurant();
                m.setVisible(true);
                this.dispose();
                
            }else if(e.getSource() == jol){
                jolRestaurant r = new jolRestaurant();
                r.setVisible(true);
                this.dispose();
                
            }else if(e.getSource() == logout){
                int confirm = JOptionPane.showConfirmDialog(this, "Log out?", "Logout", JOptionPane.YES_NO_OPTION);
                if(confirm == JOptionPane.YES_OPTION){
                    Restaurant r = new Restaurant(customerid);
                    r.setVisible(true);
                    this.dispose();
                }
            } 
       
    }
        
}
