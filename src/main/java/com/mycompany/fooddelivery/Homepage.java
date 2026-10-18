package com.mycompany.fooddelivery;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.LinkedList;




public class Homepage extends JFrame implements ActionListener  {
    
    private LinkedList<String> menuData = new LinkedList<>();
    private JLabel lblDashboard, bannerTitle;
    private JMenuBar menuBar;
    private JMenu accountMenu;
    private JMenuItem profileItem,settingsItem,logoutItem;  
    private String loggedInUser;
    private JPanel sidebar, main, banner, banner2;
    private JButton home, browse, orders, profile, settings, logout, mcdo, jollibee, manginasal, chowking;
    private JTextField search;
    
    public Homepage(){
        setSize(600, 600);
        setTitle("Bai N Eat");
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        Color background = new Color(245,245,245);
        Color red = new Color(200, 35, 35);
        //initialize menubar and menu
//      Panels
        sidebar = new JPanel();
        sidebar.setBounds(0, 0, 150, 550);
        sidebar.setLayout(null);
        sidebar.setBackground(new Color(35, 35, 35));
        add(sidebar);
        
       
        main = new JPanel();
        main.setLayout(null);
        main.setBounds(150, 0, 450, 550);
        main.setBackground(background);
        add(main);
        
        banner = new JPanel();
        banner.setLayout(null);
        banner.setBounds(20, 110, 400, 150);
        banner.setBackground(red);
        main.add(banner);
        
        banner2 = new JPanel();
        banner2.setBounds(20, 280, 400, 150);
        banner2.setBackground(Color.BLUE);
        main.add(banner2);
        
//        Buttons
        home = new JButton("Home");
        home.setBounds(25, 30, 90, 40);
        sidebar.add(home);
        
        browse = new JButton("Browse");
        browse.setBounds(25, 110, 90, 40);
        sidebar.add(browse);
        
        orders = new JButton("Orders");
        orders.setBounds(25, 190, 90, 40);
        sidebar.add(orders);
        
        profile = new JButton("Profile");
        profile.setBounds(25, 270, 90, 40);
        sidebar.add(profile);
        
        settings = new JButton("Settings");
        settings.setBounds(25, 340, 90, 40);
        sidebar.add(settings);
        
        logout = new JButton("Logout");
        logout.setBounds(25, 420, 90, 40);
        sidebar.add(logout);
        
        mcdo = new JButton("Mcdonalds");
        mcdo.setBounds(25, 65, 100, 30);
        banner.add(mcdo);
        
        jollibee = new JButton("Jollibee");
        jollibee.setBounds(25, 110, 100, 30);
        banner.add(jollibee);
        
        manginasal = new JButton("Mang Inasal");
        manginasal.setBounds(205, 65, 110, 30);
        banner.add(manginasal);
        
        chowking = new JButton("Chowking");
        chowking.setBounds(205, 110, 100, 30);
        banner.add(chowking);
        
        search = new JTextField();
        search.setBounds(200, 15, 200, 30);
        search.setText("Search food or restaurant");
        main.add(search);
        
//      Labels

        lblDashboard = new JLabel("Food Deliver");
        lblDashboard.setBounds(30, 15, 400, 40);
        lblDashboard.setFont(new Font("Arial", Font.BOLD, 25));
        main.add(lblDashboard);
        
        JLabel bannerTitle = new JLabel("Delicious food right at your door");
        bannerTitle.setBounds(25, 20, 400, 30);
        bannerTitle.setFont(new Font("Arial", Font.BOLD, 18));
        bannerTitle.setForeground(Color.WHITE);
        banner.add(bannerTitle);
       
        home.addActionListener(this);
        browse.addActionListener(this);
        orders.addActionListener(this);
        profile.addActionListener(this);
        settings.addActionListener(this);
        logout.addActionListener(this);
        mcdo.addActionListener(this);
        jollibee.addActionListener(this);
        manginasal.addActionListener(this);
        chowking.addActionListener(this);
           
    }

    @Override
    public void actionPerformed(ActionEvent e) {
                if(e.getSource() == home){
                    Homepage hm = new Homepage();
                    hm.setVisible(true);
                    this.dispose();
                    
                }else if(e.getSource() == browse){
                    Browse b = new  Browse();
                    b.setVisible(true);
                    this.dispose();
                    
                }else if(e.getSource()== orders){
                     JOptionPane.showMessageDialog(this, "Clicked", "Info", JOptionPane.INFORMATION_MESSAGE);
                }else if(e.getSource()== settings){
                     JOptionPane.showMessageDialog(this, "Clicked", "Info", JOptionPane.INFORMATION_MESSAGE);
                }else if(e.getSource() == logout){
                   int confirm = JOptionPane.showConfirmDialog(this, "Are you sure to log out?", "Log out", JOptionPane.YES_NO_OPTION);
                    if(confirm == JOptionPane.YES_OPTION){
                    fooddeliveryGUI g = new fooddeliveryGUI();
                    g.setVisible(true);
                    this.dispose();
                    }
                    
                }else if(e.getSource() == mcdo){
                    mcdoCustomer cs = new mcdoCustomer();
                    cs.setVisible(true);
                    this.dispose();
                    
                }else if(e.getSource() == jollibee){
                     JOptionPane.showMessageDialog(this, "Clicked", "Info", JOptionPane.INFORMATION_MESSAGE);
                }else if(e.getSource() == manginasal){
                     JOptionPane.showMessageDialog(this, "Clicked", "Info", JOptionPane.INFORMATION_MESSAGE);
                }else if(e.getSource() == chowking){
                     JOptionPane.showMessageDialog(this, "Clicked", "Info", JOptionPane.INFORMATION_MESSAGE);
                }
            }    
}