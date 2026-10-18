package com.mycompany.fooddelivery;

import java.awt.*;
import javax.swing.*;

public class Browse extends JFrame {
    
    private JLabel title, MCDO, JOL, MANG, CHOW, infomc, infojol, infomang, infochow, pricemc, pricejol, pricemang, pricechow;
    private JButton mcdo, jol, mang, chow, back, home, browse,orders, profile, settings,logout;
    private JTextField carttext;
    private JPanel panel, pan1, pan2, pan3, pan4;

    private double total = 0;
    
    Browse(){
        setSize(600, 600);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Bai N Eat - Browse");
        
        Color red = new Color(35, 35 ,35);
        Color dirty = new Color(220, 220, 190);
        
        title = new JLabel("Browse Food Menu");
        title.setFont(new Font("Arial", Font.BOLD, 25));
        title.setBounds(170, 30, 300, 35);
        add(title);
        
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 150, 600);
        panel.setBackground(red);
        add(panel);
        
        pan1 = new JPanel();
        pan1.setLayout(null);
        pan1.setBounds(170, 70, 400, 120);
        pan1.setBackground(dirty);
        add(pan1);
        
        pan2 = new JPanel();
        pan2.setLayout(null);
        pan2.setBounds(170, 200, 400, 120);
        pan2.setBackground(dirty);
        add(pan2);
        
        pan3 = new JPanel();
        pan3.setLayout(null);
        pan3.setBounds(170, 330, 400, 120);
        pan3.setBackground(dirty);
        add(pan3);
        
        
        
        home = new JButton("Home");
        home.setBounds(25, 30, 90, 40);
        home.setBackground(red);
        home.setForeground(dirty);
        panel.add(home);
        
        browse = new JButton("Browse");
        browse.setBounds(25, 110, 90, 40);
        browse.setBackground(red);
        browse.setForeground(dirty);
        panel.add(browse);
        
        orders = new JButton("Orders");
        orders.setBounds(25, 190, 90, 40);
        orders.setBackground(red);
        orders.setForeground(dirty);
        panel.add(orders);
        
        profile = new JButton("Profile");
        profile.setBounds(25, 270, 90, 40);
        profile.setBackground(red);
        profile.setForeground(dirty);
        panel.add(profile);
        
        settings = new JButton("Settings");
        settings.setBounds(25, 340, 90, 40);
        settings.setBackground(red);
        settings.setForeground(dirty);
        panel.add(settings);
        
        logout = new JButton("Logout");
        logout.setBounds(25, 420, 90, 40);
        logout.setForeground(dirty);
        logout.setBackground(red);
        panel.add(logout);
        
        back = new JButton("<-----");
        back.setBounds(500, 10, 80, 40);
        add(back);
        
        //Mcdo Browse Label and View
        MCDO = new JLabel("McDonald's - Mixed and Match");
        MCDO.setBounds(30, 20, 350, 30);
        MCDO.setFont(new Font("Sans-Serif", Font.PLAIN, 16));
        pan1.add(MCDO);
        
        pricemc = new JLabel("₱99");
        pricemc.setBounds(30, 40, 50, 30);
        pricemc.setFont(new Font("Sans-Serif", Font.PLAIN, 16));
        pan1.add(pricemc);
        
        mcdo = new JButton("Add to cart");
        mcdo.setBounds(260, 20, 130, 30);
        pan1.add(mcdo);
        
        infomc = new JLabel("Click ADD TO CART to add the meal");
        infomc.setBounds(30, 60, 350, 30);
        infomc.setFont(new Font("Sans-Serif", Font.PLAIN, 14));
        pan1.add(infomc);
        
//      Jollibee    
    }

}