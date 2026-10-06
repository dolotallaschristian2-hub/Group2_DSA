package com.mycompany.fooddelivery;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.LinkedList;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;



public class Homepage extends JFrame implements ActionListener  {
    
    private LinkedList<String> menuData = new LinkedList<>();
    private JLabel lblDashboard, lblWelcome;
    private JMenuBar menuBar;
    private JMenu accountMenu;
    private JMenuItem profileItem,settingsItem,logoutItem;  
    private String loggedInUser;  
    
    public Homepage(){
        setSize(600, 600);
        setTitle("Food Deliver");
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        //initialize menubar and menu
        
        menuBar = new JMenuBar();
        accountMenu = new JMenu("Menu");
        
        profileItem = new JMenuItem("profile");
        profileItem.setFont(new Font("Arial", Font.PLAIN, 18 ));
        
        settingsItem = new JMenuItem("settings");
        settingsItem.setFont(new Font("Arial", Font.PLAIN, 18 ));
        
        logoutItem = new JMenuItem("logout");
        logoutItem.setFont(new Font("Arial", Font.PLAIN, 18 ));
        
        accountMenu.add(profileItem);
        accountMenu.add(settingsItem);
        accountMenu.add(logoutItem);
        
        menuBar.add(Box.createHorizontalGlue());
        menuBar.add(accountMenu);
        setJMenuBar(menuBar);
        
        //gui's
        lblDashboard = new JLabel("Food Deliver");
        lblDashboard.setBounds(30,30,400,40);
        lblDashboard.setFont(new Font("Arial", Font.BOLD, 25));
        
        lblWelcome = new JLabel("Welcome " + loggedInUser);
        lblWelcome.setBounds(30,80,400,30);
        lblWelcome.setFont(new Font("Arial", Font.PLAIN, 16));
        
       
        add(lblDashboard);
        add(lblWelcome);
        
        profileItem.addActionListener(this);
        settingsItem.addActionListener(this);
        logoutItem.addActionListener(this);
           
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == profileItem){
            JOptionPane.showMessageDialog(this, "User Profile: ","profile",JOptionPane.INFORMATION_MESSAGE);
        }else if(e.getSource() == settingsItem){
            JOptionPane.showMessageDialog(this, "Settings coming soon???","settings", JOptionPane.INFORMATION_MESSAGE);
        }else if(e.getSource() == logoutItem){
            int choice = JOptionPane.showConfirmDialog(this, "Do you want to close?","Logout", JOptionPane.YES_NO_CANCEL_OPTION);
           
           if(choice == JOptionPane.YES_OPTION){
               fooddeliveryGUI loginScreen = new fooddeliveryGUI();
               loginScreen.setVisible(true);
               this.dispose();
           }
        }
            }    
}