/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.testhomepage;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;


public class Testhomepage extends JFrame  {
    
    private LinkedList<String> menuData = new LinkedList<>();
    private JLabel lblDashboard, lblWelcome;
    private JButton menu;
    private JButton profile, settings, logout, save;
    private JPanel menuPanel;
    private String username, gmail, phone;
    private JTextField txtName;
    private JButton btnsaveProfile;
            
    public Testhomepage(){
        setSize(600, 600);
        setTitle("DeliverNigger");
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        menuData.add("Profile");
        menuData.add("settings");
        menuData.add("logout");
        
        lblDashboard = new JLabel("DeliverFastNigger");
        lblDashboard.setBounds(30,30,400,40);
        lblDashboard.setFont(new Font("Arial", Font.BOLD, 25));
        
        lblWelcome = new JLabel("Welcome");
        lblWelcome.setBounds(30,80,400,30);
        
        add(lblDashboard);
        add(lblWelcome);
        
        //menu
        
        menu = new JButton("Menu");
        menu.setBounds(450, 30, 100, 40);
        add(menu);
        
        menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(3,1,5,5));
        menuPanel.setBounds(350, 75, 400, 135);
        
        profile = new JButton(menuData.get(0));
        settings = new JButton(menuData.get(1));
        logout = new JButton(menuData.get(2));
        
        menuPanel.add(profile);
        menuPanel.add(settings);
        menuPanel.add(logout);
                
        add(menuPanel);
        
        menuPanel.setVisible(false);
        
        JLabel lblName = new JLabel("Name: ");
            lblName.setBounds(50,150,100,30);
            add(lblName);
            
            txtName = new JTextField ();
            txtName.setBounds(120,150,200,30);
            add(txtName);
            
            btnsaveProfile = new JButton("Save");
            btnsaveProfile.setBounds(120,190,100,30);
            add(btnsaveProfile);
            
            lblName.setVisible(false);
            txtName.setVisible(false);
            btnsaveProfile.setVisible(false);
   
            btnsaveProfile.addActionListener(e ->{
            username = txtName.getText();
            
            lblName.setVisible(false);
            txtName.setVisible(false);
            btnsaveProfile.setVisible(false);
            
            
                
            });
        
        menu.addActionListener(e -> {
            if (menuPanel.isVisible()){
                menuPanel.setVisible(false);
            }else{
                menuPanel.setVisible(true);
                }           
        });
        
        
        profile.addActionListener(e -> {
            
            lblName.setVisible(true);
            txtName.setVisible(true);
            btnsaveProfile.setVisible(true);
   
            
        });
           
        settings.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Settings");
        });
        
         
    }
    
}