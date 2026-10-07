/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fooddelivery;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Restaurant extends JFrame {
    
    private JLabel idLabel, nameLabel, addressLabel, orderLabel ;
    private JTextField nameField, addressField, orderField, idField ;
    private JButton createBtn, addOrderBtn, showBtn;
    private JTextArea displayArea;
    //
  Restaurant(){
         setSize(400, 400);
         setTitle("fred");
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
         JLabel idLabel = new JLabel("ID:");
         idLabel.setBounds(20, 20, 100, 20);
         add(idLabel);
         
         idField = new JTextField();
         idField.setBounds(120, 20, 200, 20);
         add(idField);
         
         JLabel nameLabel = new JLabel("Name:");
         nameLabel.setBounds(20, 50, 100, 20);
         add(nameLabel);
         
         nameField = new JTextField();
         nameField.setBounds(120, 50, 200, 20);
         add(nameField);
         
         JLabel addressLabel = new JLabel("Address:");
         addressLabel.setBounds(20, 80, 100, 20);
         add(addressLabel);
         
         addressField = new JTextField();
         addressField.setBounds(120, 80, 200, 20);
         add(addressField);
         
         JLabel orderLabel = new JLabel("Order:");
         orderLabel.setBounds(20, 110, 100, 20);
         add(orderLabel);
         
         orderField = new JTextField();
         orderField.setBounds(120, 110, 200, 20);
         add(orderField);
         
         JButton createBtn = new JButton("Create Customer");
         createBtn.setBounds(20, 150, 150, 25);
         add(createBtn);

         JButton addOrderBtn = new JButton("Add Order");
         addOrderBtn.setBounds(200, 150, 120, 25);
         add(addOrderBtn);
         
         JButton showBtn = new JButton("Show Info");
         showBtn.setBounds(120, 190, 150, 25);
         add(showBtn);
         
          displayArea = new JTextArea();
          displayArea.setBounds(20, 230, 340, 120);
          add(displayArea);












        
        
    }
}
