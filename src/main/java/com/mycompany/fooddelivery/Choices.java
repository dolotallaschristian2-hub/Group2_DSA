package com.mycompany.fooddelivery;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Choices extends JFrame implements ActionListener{
    
    private JPanel pane;
    private JLabel label;
    private JButton resto, custo;
    
    Choices(){
        setSize(500, 500);
        setTitle("Please Select");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        
        pane = new JPanel();
        pane.setBounds(120, 150, 300, 300);
        pane.setLayout(null);
        add(pane);
        
        label = new JLabel("Are you a?", SwingConstants.CENTER);
        label.setBounds(50, 20, 200, 30);
        pane.add(label);
        
        resto = new JButton("Restaurant");
        resto.setBounds(70, 80, 160, 50);
        pane.add(resto);
        
        custo = new JButton("Customer");
        custo.setBounds(70, 150, 160, 50);
        pane.add(custo);
        
        resto.addActionListener(this);
        custo.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == resto){
            Restaurant rm = new Restaurant();
            rm.setVisible(true);
        }
        else if(e.getSource() == custo){
            fooddeliveryGUI fooddelivery = new fooddeliveryGUI();
            fooddelivery.setVisible(true);
        }
    }
        
}
