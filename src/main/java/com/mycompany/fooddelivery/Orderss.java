package com.mycompany.fooddelivery;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Orderss extends JFrame implements ActionListener{
    private JLabel set;
    private JPanel side, panel;
    private JButton home, browse, orders, settings, profile, logout, mcdo, jol, mang, chow;
    private int customerid;
    Orderss(int customerid){
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setTitle("Bai N Eat - Settings");
        
        this.customerid = customerid;
        
        Color red = new Color(35, 35,35);
        Color dirty = new Color (220, 220, 190);
        
        set = new JLabel("Order");
        set.setBounds(170, 30, 300, 35);
        set.setFont(new Font("Arial", Font.BOLD, 25));
        add(set);
        
        side = new JPanel();
        side.setLayout(null);
        side.setBounds(0, 0, 150, 600);
        side.setBackground(red);
        add(side);
        
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(180, 60, 350, 450);
        panel.setBackground(dirty);
        add(panel);
        
        home = new JButton("Home");
        home.setBounds(25, 30, 90, 40);
        home.setBackground(red);
        home.setForeground(dirty);
        side.add(home);
        
        browse = new JButton("Browse");
        browse.setBounds(25, 110, 90, 40);
        browse.setBackground(red);
        browse.setForeground(dirty);
        side.add(browse);
        
        orders = new JButton("Orders");
        orders.setBounds(25, 190, 90, 40);
        orders.setBackground(red);
        orders.setForeground(dirty);
        side.add(orders);
        
        profile = new JButton("Profile");
        profile.setBounds(25, 270, 90, 40);
        profile.setBackground(red);
        profile.setForeground(dirty);
        side.add(profile);
        
        settings = new JButton("Settings");
        settings.setBounds(25, 340, 90, 40);
        settings.setBackground(red);
        settings.setForeground(dirty);
        side.add(settings);
        
        logout = new JButton("Logout");
        logout.setBounds(25, 420, 90, 40);
        logout.setForeground(dirty);
        logout.setBackground(red);
        side.add(logout);
        
        mcdo = new JButton("Mcdonalds");
        mcdo.setBounds(80, 35, 200, 60);
        panel.add(mcdo);
        
        jol = new JButton("Jollibee");
        jol.setBounds(80, 110, 200, 60);
        panel.add(jol);
        
        mang = new JButton("Mang Inasal");
        mang.setBounds(80, 190, 200, 60);
        panel.add(mang);
        
        chow = new JButton("Chowking");
        chow.setBounds(80, 265, 200, 60);
        panel.add(chow);
        
        home.addActionListener(this);
        browse.addActionListener(this);
        settings.addActionListener(this);
        orders.addActionListener(this);
        profile.addActionListener(this);
        logout.addActionListener(this);
        mcdo.addActionListener(this);
        jol.addActionListener(this);
        mang.addActionListener(this);
        chow.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == home){
            Homepage h = new Homepage(customerid);
            h.setVisible(true);
            this.dispose();
            
        }else if (e.getSource() == browse){
            Browse b = new Browse(customerid);
            b.setVisible(true);
            this.dispose();
            
        }else if(e.getSource() == orders){
            Orderss o = new Orderss(customerid);
            o.setVisible(true);
            this.dispose();
            
        }else if(e.getSource() == settings){
            Settings s = new Settings(customerid);
            s.setVisible(true);
            this.dispose();
            
        }else if(e.getSource() == profile){
            profile p = new profile(customerid);
            p.setVisible(true);
            this.dispose();
            
        }else if(e.getSource() == logout){
            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure to logout?", "Log out", JOptionPane.YES_NO_OPTION);
            if(confirm == JOptionPane.YES_OPTION){
                fooddeliveryGUI g = new fooddeliveryGUI(customerid);
                    g.setVisible(true);
                    this.dispose();
            }
        }else if(e.getSource() == mcdo){
            mcdoCustomer cs = new mcdoCustomer(customerid);
            cs.setVisible(true);
            this.dispose();
            
        }else if(e.getSource() == jol){
            jolCustomer c = new jolCustomer(customerid);
            c.setVisible(true);
            this.dispose();
            
        }else if(e.getSource() == mang){
            mangCustomer m = new mangCustomer(customerid);
            m.setVisible(true);
            this.dispose();
        
        }else if(e.getSource() == chow){
            chowCustomer c = new chowCustomer(customerid);
            c.setVisible(true);
            this.dispose();
        }
       
    }    
}