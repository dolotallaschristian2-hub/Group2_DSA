package com.mycompany.fooddelivery;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;


public class mangRestaurant extends JFrame implements ActionListener{
    private JLabel label, orders;
    private JButton shows, menuadd;
    private DefaultListModel<OrderInfo> listmodel;
    private JScrollPane scroll;
    private JList<OrderInfo> list;
    
    mangRestaurant(){
        setSize(600, 600);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        
        label = new JLabel("Welcome, MANG INASAL", SwingConstants.CENTER);
        label.setBounds(180, 30, 200, 30);
        label.setFont(new Font("Arial", Font.BOLD, 16));
        add(label);
        
        orders = new JLabel("Orders");
        orders.setBounds(70, 80, 70, 30);
        add(orders);
        
        listmodel = new DefaultListModel<>();
        list = new JList<>(listmodel);
        scroll = new JScrollPane(list);
        scroll.setBounds(70, 120, 350, 250);
        add(scroll);
        
        shows = new JButton("Show Order");
        shows.setBounds(440, 120, 120, 30);
        add(shows);
        
        menuadd = new JButton("Add Menu");
        menuadd.setBounds(440, 170, 120, 30);
        add(menuadd);
        
        shows.addActionListener(this);
        menuadd.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == shows){
           
       }else if(e.getSource() == menuadd){
           menuaddMang m = new menuaddMang();
           m.setVisible(true);
           this.dispose();
       }
    }
    
     private void load(){
         listmodel.clear();

            String sql = "SELECT orderid, customerid, items, status, type "
                + "FROM orders_mang WHERE status <> 'Delivered' "
                + "ORDER BY CASE "
                + "WHEN UPPER (type) = 'PRIORITY' THEN 0 "
                + "WHEN UPPER (type) = 'NORMAL' THEN 1 "
                + "ELSE 2 END, orderid ASC ;";

                try (Connection c = DBConnection.getConnection();
                PreparedStatement p = c.prepareStatement(sql);
                ResultSet rs = p.executeQuery()) {

                while (rs.next()) {
                    listmodel.addElement(new mangRestaurant.OrderInfo(
                    rs.getInt("orderid"),
                    rs.getInt("customerid"),
                    rs.getString("items"),
                    rs.getString("status"),
                    rs.getString("type")
                    ));
        }
                
        if (listmodel.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "No current orders found.");
        }

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this,
                "Unable to load orders: " + ex.getMessage());
        }
    }
      private static class OrderInfo {
        int id;
        int customerId;
        String items;
        String status;
        String type;

        OrderInfo(int id, int customerId, String items, String status, String type) {
            this.id = id;
            this.customerId = customerId;
            this.items = items;
            this.status = status;
            this.type = type;
        }

        @Override
        public String toString() {
            return "Order #" + id
                    + " | Customer: " + customerId
                    + " | " + status
                    + " | " + items
                    + " | " + type;
        }
    }

}    
