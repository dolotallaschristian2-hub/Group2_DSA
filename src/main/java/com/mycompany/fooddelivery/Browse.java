package com.mycompany.fooddelivery;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Browse extends JFrame implements ActionListener{
    
    private JLabel title, MCDO, JOL, MANG, infomc, infojol, infomang, pricemc, pricejol, pricemang;
    private JButton mcdo, jol, mang, home, browse, orders, profile, settings,logout;
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
        JOL = new JLabel("Jollibee's - Mixed and Match");
        JOL.setBounds(30, 20, 350, 30);
        JOL.setFont(new Font("Sans-Serif", Font.PLAIN, 16));
        pan2.add(JOL);
        
        pricejol = new JLabel("₱99");
        pricejol.setBounds(30, 40, 50, 30);
        pricejol.setFont(new Font("Sans-Serif", Font.PLAIN, 16));
        pan2.add(pricejol);
        
        jol = new JButton("Add to cart");
        jol.setBounds(260, 20, 130, 30);
        pan2.add(jol);
        
        infojol = new JLabel("Click ADD TO CART to add the meal");
        infojol.setBounds(30, 60, 350, 30);
        infojol.setFont(new Font("Sans-Serif", Font.PLAIN, 14));
        pan2.add(infojol);
        
        
 //     Manginasal  
        MANG = new JLabel("Mang inasal's - Pecho Large");
        MANG.setBounds(30, 20, 350, 30);
        MANG.setFont(new Font("Sans-Serif", Font.PLAIN, 16));
        pan3.add(MANG);
        
        pricemang = new JLabel("₱169");
        pricemang.setBounds(30, 40, 50, 30);
        pricemang.setFont(new Font("Sans-Serif", Font.PLAIN, 16));
        pan3.add(pricemang);
        
        mang = new JButton("Add to cart");
        mang.setBounds(260, 20, 130, 30);
        pan3.add(mang);
        
        infomang = new JLabel("Click ADD TO CART to add the meal");
        infomang.setBounds(30, 60, 350, 30);
        infomang.setFont(new Font("Sans-Serif", Font.PLAIN, 14));
        pan3.add(infomang);
        
        mcdo.addActionListener(this);
        jol.addActionListener(this);
        mang.addActionListener(this);
        home.addActionListener(this);
        browse.addActionListener(this);
        settings.addActionListener(this);
        orders.addActionListener(this);
        profile.addActionListener(this);
        logout.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         if(e.getSource() == home){
             Homepage h = new Homepage();
             h.setVisible(true);
             this.dispose();
         }else if(e.getSource() == browse){
             Browse s = new Browse();
             s.setVisible(true);
             this.dispose();
         }else if(e.getSource() == orders){
             
         }else if(e.getSource() == settings){
             
         }else if(e.getSource() == profile){
             
         }else if(e.getSource() == logout){
             int confirm = JOptionPane.showConfirmDialog(this, "Are you sure to logout?", "Logout", JOptionPane.YES_NO_OPTION);
             if(confirm == JOptionPane.YES_OPTION){
                  fooddeliveryGUI g = new fooddeliveryGUI();
                    g.setVisible(true);
                    this.dispose();
             }
             
         }
    }

}