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
    private JPanel sidebar;
    private JButton home, browse, orders;
    
    public Homepage(){
        setSize(600, 600);
        setTitle("Food Deliver");
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        Color background = new Color(245,245,245);
        Color red = new Color(200, 35,35);
        //initialize menubar and menu
        
        JPanel sidebar = new JPanel();
        sidebar.setBounds(0, 0, 150, 450);
        sidebar.setLayout(null);
        sidebar.setBackground(red);
        add(sidebar);
        
        JButton home = new JButton("Home");
        home.setBounds(25, 30, 90, 40);
        sidebar.add(home);
        
        JButton browse = new JButton("Browse");
        browse.setBounds(25, 110, 90, 40);
        sidebar.add(browse);
        
        JButton orders = new JButton("Orders");
        orders.setBounds(25, 190, 90, 40);
        sidebar.add(orders);
        
        menuBar = new JMenuBar();
        accountMenu = new JMenu("Menu");
        
        profileItem = new JMenuItem("profile");
        profileItem.setFont(new Font("Arial", Font.PLAIN, 18 ));
        accountMenu.add(profileItem);
        
        settingsItem = new JMenuItem("settings");
        settingsItem.setFont(new Font("Arial", Font.PLAIN, 18 ));
        accountMenu.add(settingsItem);
        
        logoutItem = new JMenuItem("logout");
        logoutItem.setFont(new Font("Arial", Font.PLAIN, 18 ));
        accountMenu.add(logoutItem);
        
        
        menuBar.add(Box.createHorizontalGlue());
        menuBar.add(accountMenu);
        setJMenuBar(menuBar);
     
        //gui's
        lblDashboard = new JLabel("Food Deliver");
        lblDashboard.setBounds(180, 30, 400, 40);
        lblDashboard.setFont(new Font("Arial", Font.BOLD, 25));
        add(lblDashboard);
        
        lblWelcome = new JLabel("Welcome " + loggedInUser);
        lblWelcome.setBounds(30,80,400,30);
        lblWelcome.setFont(new Font("Arial", Font.PLAIN, 16));
        add(lblWelcome);
        
        profileItem.addActionListener(this);
        settingsItem.addActionListener(this);
        logoutItem.addActionListener(this);
        home.addActionListener(this);
        browse.addActionListener(this);
//        orders.addActionListener(this);
           
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == profileItem){
            JOptionPane.showMessageDialog(this, "User Profile: ","profile",JOptionPane.INFORMATION_MESSAGE);
        }else if(e.getSource() == settingsItem){
            JOptionPane.showMessageDialog(this, "Settings coming soon???","settings", JOptionPane.INFORMATION_MESSAGE);
        }else if(e.getSource() == logoutItem){
            int choice = JOptionPane.showConfirmDialog(this, "Do you want to close?","Logout", JOptionPane.YES_NO_OPTION);
           
           if(choice == JOptionPane.YES_OPTION){
               fooddeliveryGUI lg = new fooddeliveryGUI();
               lg.setVisible(true);
               this.dispose();
           }
        }
            }    
}