package com.mycompany.fooddelivery;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Choices extends JFrame implements ActionListener{
    
    private Color bgColor= new Color(250, 232, 218);
    private Color paneColor = Color.WHITE;
    private Color borderColor = new Color(224, 229, 235);
    private Color textColor = new Color(28, 33, 39);
    private Color restoBg = new Color(224, 90, 43);
    private Color custoBg = new Color(248, 250, 252);
    
    private JPanel pane;
    private JLabel label;
    private JButton resto, custo, back;
    private int customerid;
    
    Choices(int customerid){
        setSize(500, 500);
        setTitle("Please Select");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        getContentPane().setBackground(bgColor);
        
        this.customerid = customerid;
        
        pane = new JPanel();
        pane.setBounds(100, 100, 300, 300);
        pane.setLayout(null);
        pane.setBackground(paneColor);
        pane.setBorder(BorderFactory.createLineBorder(borderColor,1,true));
        add(pane);
        
        label = new JLabel("Are you a?", SwingConstants.CENTER);
        label.setBounds(50, 20, 200, 30);
        label.setFont(new Font("SanSerif", Font.BOLD,20));
        label.setForeground(textColor);
        pane.add(label);
        
        resto = new JButton("Restaurant");
        resto.setBounds(70, 80, 160, 50);
        resto.setFont(new Font("SansSerif", Font.BOLD,14));
        resto.setForeground(Color.WHITE);
        resto.setBackground(restoBg);
        resto.setFocusPainted(false);
        resto.setBorderPainted(false);
        resto.setOpaque(true);
        pane.add(resto);
        
        custo = new JButton("Customer");
        custo.setBounds(70, 150, 160, 50);
        custo.setFont(new Font("SansSerif", Font.BOLD,14));
        custo.setForeground(textColor);
        custo.setBackground(custoBg);
        custo.setFocusPainted(false);
        custo.setOpaque(true);
        custo.setBorder(BorderFactory.createLineBorder(borderColor,1,true));
        pane.add(custo);
       
        
        
        resto.addActionListener(this);
        custo.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == resto){
            SwingUtilities.invokeLater(() ->{
            Restaurant rm = new Restaurant(customerid);
            rm.setVisible(true);
        });
            this.dispose();
        }
        else if(e.getSource() == custo){
            SwingUtilities.invokeLater(() ->{
            fooddeliveryGUI fooddelivery = new fooddeliveryGUI(customerid);
            fooddelivery.setVisible(true);
            });
            this.dispose();
            
        }
    }
        
}
