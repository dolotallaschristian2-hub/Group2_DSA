package com.mycompany.fooddelivery;

import java.awt.*;
import javax.swing.*;

public class Browse extends JFrame {
    
    private JLabel title, MCDO, JOL, MANG, CHOW;
    private JButton mcdo, jol, mang, chow, back;
    private JTextField carttext;

    private double total = 0;
    
    Browse(){
        setSize(600, 600);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Bai N Eat - Browse");
        
        title = new JLabel("Browse Food Menu");
        title.setFont(new Font("Arial", Font.BOLD, 25));
        title.setBounds(170, 30, 300, 35);
        add(title);

    }

}