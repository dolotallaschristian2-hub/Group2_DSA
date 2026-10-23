package com.mycompany.fooddelivery;

import java.awt.Font;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class menuaddChow extends JFrame{
    private JLabel title, rest, name,desc, price;
    private JTextField resID, restname, descrp, prices;
    private JButton save, clear, back;
    
    menuaddChow(){
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
    }
}
