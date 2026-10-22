package com.mycompany.fooddelivery;

import java.awt.*;
import javax.swing.*;


public class menuAdd extends JFrame{
    private JLabel title, rest, name,desc, price;
    private JTextField resID, restname, prices;
    private JButton save, clear, back;
    
    menuAdd(){
        setTitle("Menu Add Item ");
        setSize(600, 600);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        
        title = new JLabel("Add Menu Item");
        title.setFont(new Font("Arial",Font.BOLD, 14));
        title.setBounds(150, 20, 250, 30);
        add(title);
    }
}
