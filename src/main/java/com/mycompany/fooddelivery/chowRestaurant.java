package com.mycompany.fooddelivery;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class chowRestaurant extends JFrame implements ActionListener {
    private JLabel label, orders;
    private JButton shows, menuadd, delivered;
    private DefaultListModel<String> listmodel;
    private JScrollPane scroll;
    private JList<String> list;
    
    chowRestaurant(){
        setSize(600, 600);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        
        label = new JLabel("Welcome, MANG INASAL", SwingConstants.CENTER);
        label.setBounds(180, 30, 200, 30);
        label.setFont(new Font("Arial", Font.BOLD, 16));
        add(label);
        
        orders = new JLabel("Orders");
        orders.setBounds(70, 80, 70, 30);
        add(orders);
        
        listmodel = new DefaultListModel<>();
        list = new JList<>(listmodel);
        scroll = new JScrollPane(list);
        scroll.setBounds(70, 120, 450, 300);
        add(scroll);
        
        shows = new JButton("Show Order");
        shows.setBounds(70, 450, 120, 30);
        add(shows);
        
        menuadd = new JButton("Add Menu");
        menuadd.setBounds(220, 450, 120, 30);
        add(menuadd);
        
        delivered = new JButton("Delivered");
        delivered.setBounds(370, 450, 120, 30);
        add(delivered);
        
        shows.addActionListener(this);
        menuadd.addActionListener(this);
        delivered.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == shows){
            
        }else if(e.getSource() == menuadd){
            menuaddChow c = new menuaddChow();
            c.setVisible(true);
            this.dispose();
        }
    
    }
}