package com.mycompany.fooddelivery;

import javax.swing.*;

public class mcdoCustomer extends JFrame {
        private JLabel label;
        private JPanel pane;
        private JButton order,add,shop;
        private JComboBox<String> sizes;
        
        
        mcdoCustomer(){
            setSize(600, 600);
            setLayout(null);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setResizable(false);
            setTitle("Mcdonalds");
            
            
        }
}
