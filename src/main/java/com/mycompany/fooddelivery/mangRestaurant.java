package com.mycompany.fooddelivery;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;


public class mangRestaurant extends JFrame implements ActionListener{
    private JLabel label, orders;
    private JButton shows, menuadd, delivered;
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
        scroll.setBounds(70, 120, 450, 300);
        add(scroll);
        
        shows = new JButton("Show Order");
        shows.setBounds(70, 450, 120, 30);
        add(shows);
        
        menuadd = new JButton("Add Menu");
        menuadd.setBounds(220, 450, 120, 30);
        add(menuadd);
        
        delivered = new JButton("Delivered");
        delivered.setBounds(370, 450, 120, 30);
        add(delivered);
        
        shows.addActionListener(this);
        menuadd.addActionListener(this);
        delivered.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == shows){
           load();
           
       }else if(e.getSource() == menuadd){
           menuaddMang m = new menuaddMang();
           m.setVisible(true);
           this.dispose();
           
       }else if(e.getSource() == delivered){
           markDelivered();
           
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
     private void markDelivered() {
        OrderInfo selected = list.getSelectedValue();

        if (selected == null || selected.id == 0) {
            JOptionPane.showMessageDialog(this,
                    "Please select an order first.");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(
                this,
                "Mark Order #" + selected.id + " as delivered?",
                "Confirm Delivery",
                JOptionPane.YES_NO_OPTION
        );

        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        String sql = "UPDATE orders_mang SET status = 'Delivered' "
                + "WHERE orderid = ? "
                + "AND status <> 'Delivered'";

        try (Connection c = DBConnection.getConnection();
             PreparedStatement p = c.prepareStatement(sql)) {

            p.setInt(1, selected.id);

            int updated = p.executeUpdate();

            if (updated > 0) {
                JOptionPane.showMessageDialog(this,
                        "Order #" + selected.id
                                + " has been delivered.");
                load();
            } else {
                JOptionPane.showMessageDialog(this,
                        "Order was already delivered or not found.");
                load();
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,
                    "Unable to update order: " + ex.getMessage());
        }
    }
}    
