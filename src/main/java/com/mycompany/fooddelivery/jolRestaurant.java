package com.mycompany.fooddelivery;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class jolRestaurant extends JFrame implements ActionListener {
    private JLabel label, orders;
    private JButton shows, menuadd;
    private DefaultListModel<String> listmodel;
    private JScrollPane scroll;
    private JList<String> list;
    
    jolRestaurant(){
        setSize(600, 600);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        
        label = new JLabel("Welcome, JOLLIBEE", SwingConstants.CENTER);
        label.setBounds(200, 30, 200, 30);
        label.setFont(new Font("Arial", Font.BOLD, 16));
        add(label);
        
        orders = new JLabel("Orders");
        orders.setBounds(70, 80, 70, 30);
        add(orders);
        
        listmodel = new DefaultListModel<>();
        list = new JList<>(listmodel);
        scroll = new JScrollPane(list);
        scroll.setBounds(70, 120, 350, 250);
        add(scroll);
        
        shows = new JButton("Show Order");
        shows.setBounds(440, 120, 120, 30);
        add(shows);
        
        menuadd = new JButton("Add Menu");
        menuadd.setBounds(440, 170, 120, 30);
        add(menuadd);
        
        shows.addActionListener(this);
        menuadd.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == shows){
            
        }else if(e.getSource() == menuadd){
            menuaddJol j = new menuaddJol();
            j.setVisible(true);
        }
    }
}
