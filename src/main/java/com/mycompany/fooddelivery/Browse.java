package com.mycompany.fooddelivery;

import java.awt.*;
import javax.swing.*;

public class Browse extends JFrame {
    
    private JLabel title, MCDO, JOL, MANG, CHOW;
    private JButton mcdo, jol, mang, chow, back;
    private JTextField carttext;
    private JPanel panel;

    private double total = 0;
    
    Browse(){
        setSize(600, 600);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Bai N Eat - Browse");
        
        Color red = new Color(35, 35 ,35);
        
        title = new JLabel("Browse Food Menu");
        title.setFont(new Font("Arial", Font.BOLD, 25));
        title.setBounds(170, 30, 300, 35);
        add(title);
        
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 150, 550);
        panel.setBackground(red);
        add(panel);

    }

}