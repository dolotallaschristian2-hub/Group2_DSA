package com.mycompany.fooddelivery;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;


public class profile extends JFrame implements ActionListener {
    private JLabel set;
    private JPanel side;
    private JButton home, browse, orders, settings, profile, logout, id, history;
    private int customerid;
            
    profile(int customerid){
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setTitle("Bai N Eat - Profile");
        
        this.customerid = customerid;
        
        Color red = new Color(35, 35,35);
        Color dirty = new Color (220, 220, 190);
        
        set = new JLabel("Profile");
        set.setBounds(170, 30, 300, 35);
        set.setFont(new Font("Arial", Font.BOLD, 25));
        add(set);
        
        side = new JPanel();
        side.setLayout(null);
        side.setBounds(0, 0, 150, 600);
        side.setBackground(red);
        add(side);
        
        home = new JButton("Home");
        home.setBounds(25, 30, 90, 40);
        home.setBackground(red);
        home.setForeground(dirty);
        side.add(home);
        
        browse = new JButton("Browse");
        browse.setBounds(25, 110, 90, 40);
        browse.setBackground(red);
        browse.setForeground(dirty);
        side.add(browse);
        
        orders = new JButton("Orders");
        orders.setBounds(25, 190, 90, 40);
        orders.setBackground(red);
        orders.setForeground(dirty);
        side.add(orders);
        
        profile = new JButton("Profile");
        profile.setBounds(25, 270, 90, 40);
        profile.setBackground(red);
        profile.setForeground(dirty);
        side.add(profile);
        
        settings = new JButton("Settings");
        settings.setBounds(25, 340, 90, 40);
        settings.setBackground(red);
        settings.setForeground(dirty);
        side.add(settings);
        
        logout = new JButton("Logout");
        logout.setBounds(25, 420, 90, 40);
        logout.setForeground(dirty);
        logout.setBackground(red);
        side.add(logout);
        
        id = new JButton("Customer ID");
        id.setBounds(180, 100, 150, 30);
        add(id);
        
        history = new JButton("Order History");
        history.setBounds(180, 150, 150, 30);
        add(history);
        
        home.addActionListener(this);
        browse.addActionListener(this);
        settings.addActionListener(this);
        orders.addActionListener(this);
        profile.addActionListener(this);
        logout.addActionListener(this);
        id.addActionListener(this);
        history.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         if(e.getSource() == home){
            Homepage h = new Homepage(customerid);
            h.setVisible(true);
            this.dispose();
            
        }else if (e.getSource() == browse){
            Browse b = new Browse(customerid);
            b.setVisible(true);
            this.dispose();
            
        }else if(e.getSource() == orders){
            Orderss o = new Orderss(customerid);
            o.setVisible(true);
            this.dispose();
            
        }else if(e.getSource() == settings){
            Settings s = new Settings(customerid);
            s.setVisible(true);
            this.dispose();
            
        }else if(e.getSource() == profile){
            profile p = new profile(customerid);
            p.setVisible(true);
            this.dispose();
            
        }else if(e.getSource() == logout){
            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure to logout?", "Log out", JOptionPane.YES_NO_OPTION);
            if(confirm == JOptionPane.YES_OPTION){
                fooddeliveryGUI g = new fooddeliveryGUI(customerid);
                    g.setVisible(true);
                    this.dispose();
            }
        }else if(e.getSource() == history){
            showOrderHistory();
            
        }else if(e.getSource() == id){
            JOptionPane.showMessageDialog(this,"Customer ID: " + customerid,"Customer ID",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    
private void showOrderHistory() {
    String sql =
        "SELECT orderid, customerid, items, total, status, type, " +
        "'McDonalds' AS restaurant FROM orders " +
        "WHERE customerid = ? " +

        "UNION ALL " +

        "SELECT orderid, customerid, items, total, status, type, " +
        "'Jollibee' AS restaurant FROM orders_jol " +
        "WHERE customerid = ? " +

        "UNION ALL " +

        "SELECT orderid, customerid, items, total, status, type, " +
        "'Mang Inasal' AS restaurant FROM orders_mang " +
        "WHERE customerid = ? " +

        "UNION ALL " +

        "SELECT orderid, customerid, items, total, status, type, " +
        "'Chowking' AS restaurant FROM orders_chow " +
        "WHERE customerid = ? " +

        "ORDER BY orderid DESC";

    StringBuilder result = new StringBuilder();

    try (Connection c = DBConnection.getConnection();
         PreparedStatement p = c.prepareStatement(sql)) {

        p.setInt(1, customerid);
        p.setInt(2, customerid);
        p.setInt(3, customerid);
        p.setInt(4, customerid);

        try (ResultSet rs = p.executeQuery()) {
            while (rs.next()) {
                result.append("Order ID: ")
                        .append(rs.getInt("orderid"))
                        .append("\nRestaurant: ")
                        .append(rs.getString("restaurant"))
                        .append("\nItems: ")
                        .append(rs.getString("items"))
                        .append("\nTotal: ₱")
                        .append(rs.getBigDecimal("total"))
                        .append("\nStatus: ")
                        .append(rs.getString("status"))
                        .append("\nOrder Type: ")
                        .append(rs.getString("type"))
                        .append("\n--------------------------\n");
            }
        }

        if (result.length() == 0) {
            result.append("You have no order history yet.");
        }

        JTextArea textArea = new JTextArea(result.toString(), 18, 35);
        textArea.setEditable(false);
        textArea.setCaretPosition(0);

        JOptionPane.showMessageDialog(
                this,
                new JScrollPane(textArea),
                "All Restaurant Order History",
                JOptionPane.INFORMATION_MESSAGE
        );

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(
                this,
                "Unable to load order history: " + ex.getMessage(),
                "Database Error",
                JOptionPane.ERROR_MESSAGE
        );
    }
}

    
}
