
package com.mycompany.fooddelivery;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.*;

public class mcdoCustomer extends JFrame implements ActionListener {

    private JTable menuTable;
    private DefaultTableModel menuModel;
    private JTextArea cartArea, queueArea;
    private JLabel totalLabel;
    private JComboBox<String> sizes;
    private JSpinner qty;
    private double cartTotal = 0;
    private int orderCounter = 1;
    private JButton addBtn, normalBtn, priorityBtn, serveBtn;
    private JScrollPane queueScroll, cartScroll, menuScroll;

    private ArrayList<String> cartItems;
    private Queue<Order> normalQueue = new LinkedList<>();

    private PriorityQueue<Order> priorityQueue = new PriorityQueue<>(
        Comparator.comparingInt((Order o) -> o.priorityLevel)
                  .thenComparingInt(o -> o.orderNo)
    );

    

    static class Order {
        int orderNo, priorityLevel;
        String items, type;
        double total;

        Order(int no, String items, double total, int level, String type) {
            this.orderNo = no;
            this.items = items;
            this.total = total;
            this.priorityLevel = level;
            this.type = type;
        }

        @Override
        public String toString() {
            return "#" + orderNo + " [" + type + "] P"
                + String.format("%.2f", total) + " - " + items;
        }
    }

    public mcdoCustomer() {
        setTitle("McDonald's");
        setSize(600, 600);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        menuModel = new DefaultTableModel(
            new String[]{"ID", "Item", "Price"}, 0
        ) 
        {
            @Override
            public boolean isCellEditable(int r, int c) {
                return false;
            }
        };

        menuTable = new JTable(menuModel);
        menuScroll = new JScrollPane(menuTable);
        menuScroll.setBounds(20, 20, 545, 170);
        add(menuScroll);

        sizes = new JComboBox<>(new String[]{"Small", "Medium", "Large"});
        sizes.setBounds(20, 200, 100, 30);
        add(sizes);

        qty = new JSpinner(new SpinnerNumberModel(1, 1, 99, 1));
        qty.setBounds(135, 200, 60, 30);
        add(qty);

        addBtn = new JButton("Add to Cart");
        addBtn.setBounds(210, 200, 130, 30);
        add(addBtn);
       

        cartItems = new ArrayList<>();
        cartArea = new JTextArea();
        cartArea.setEditable(false);
        cartScroll = new JScrollPane(cartArea);
        cartScroll.setBounds(20, 240, 545, 80);
        add(cartScroll);

        totalLabel = new JLabel("Total: P0.00");
        totalLabel.setBounds(20, 325, 200, 25);
        add(totalLabel);

        normalBtn = new JButton("Normal Delivery");
        normalBtn.setBounds(20, 355, 160, 30);
        add(normalBtn);
       

        priorityBtn = new JButton("Priority Delivery");
        priorityBtn.setBounds(195, 355, 160, 30);
        add(priorityBtn);
       

        serveBtn = new JButton("Serve Next");
        serveBtn.setBounds(370, 355, 195, 30);
        add(serveBtn);
        serveBtn.addActionListener(e -> serveNext());

        queueArea = new JTextArea();
        queueArea.setEditable(false);
        queueScroll = new JScrollPane(queueArea);
        queueScroll.setBounds(20, 400, 545, 150);
        add(queueScroll);
        
        

        loadMenu();
        refreshQueues();
        setVisible(true);
        
         addBtn.addActionListener(this);
         normalBtn.addActionListener(e -> placeOrder(false));
         priorityBtn.addActionListener(e -> placeOrder(true));
        
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == addBtn ){
             int row = menuTable.getSelectedRow();

            if (row == -1) {
            JOptionPane.showMessageDialog(this, "Select a menu item.");
            return;
            }

            String name = menuModel.getValueAt(row, 1).toString();
            double price = Double.parseDouble(
            menuModel.getValueAt(row, 2).toString()
            );

            int quantity = (Integer) qty.getValue();
            String size = sizes.getSelectedItem().toString();

            double multiplier = size.equals("Small") ? 1.0
            : size.equals("Medium") ? 1.2 : 1.5;

            double subtotal = price * multiplier * quantity;

            cartItems.add(quantity + "x " + size + " " + name);
            cartTotal += subtotal;

            cartArea.append(quantity + "x " + size + " " + name
            + " = P" + String.format("%.2f", subtotal) + "\n");

            totalLabel.setText("Total: P" + String.format("%.2f", cartTotal));
        }
    }
    private void loadMenu() {
        menuModel.setRowCount(0);

        String sql = "SELECT food_id, item_name, description, price FROM menu";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                menuModel.addRow(new Object[]{
                    rs.getInt("food_id"),
                    rs.getString("item_name"),
                    rs.getDouble("price")
                });
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    private void placeOrder(boolean isPriority) {
        if (cartItems.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Cart is empty.");
            return;
        }

        String items = String.join(", ", cartItems);

        if (isPriority) {
            String[] options = {"Senior/PWD", "Rush", "Member"};

            int choice = JOptionPane.showOptionDialog(
                this, "Select priority type:", "Priority Order",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, options, options[0]
            );

            if (choice == -1) return;

            Order o = new Order(orderCounter++, items, cartTotal,
                choice + 1, options[choice]);

            priorityQueue.offer(o);
        } else {
            normalQueue.offer(new Order(
                orderCounter++, items, cartTotal, 0, "NORMAL"
            ));
        }

        cartItems.clear();
        cartTotal = 0;
        cartArea.setText("");
        totalLabel.setText("Total: P0.00");
        refreshQueues();
    }

    private void serveNext() {
        Order served;

        if (!priorityQueue.isEmpty()) {
            served = priorityQueue.poll();
        } else if (!normalQueue.isEmpty()) {
            served = normalQueue.poll();
        } else {
            JOptionPane.showMessageDialog(this, "No pending orders.");
            return;
        }

        JOptionPane.showMessageDialog(this, "Now serving:\n" + served);
        refreshQueues();
    }

    private void refreshQueues() {
        StringBuilder sb = new StringBuilder("PRIORITY QUEUE:\n");

        PriorityQueue<Order> copy = new PriorityQueue<>(priorityQueue);
        while (!copy.isEmpty()) {
            sb.append(copy.poll()).append("\n");
        }

        sb.append("\nNORMAL QUEUE:\n");
        for (Order o : normalQueue) {
            sb.append(o).append("\n");
        }

        queueArea.setText(sb.toString());
    }

   
}
