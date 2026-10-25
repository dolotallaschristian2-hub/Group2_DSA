
package com.mycompany.fooddelivery;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.*;

public class mcdoCustomer extends JFrame implements ActionListener {

    private JLabel title, queueLabel, addressLabel, phoneLabel, nameLabel;
    private JTable menuTable;
    private DefaultTableModel menuModel;
    private JTextArea cartArea, queueArea;
    private JLabel totalLabel;
    private JComboBox<String> sizes;
    private JSpinner qty;
    private JTextField customerName, phone;
    private JTextArea address;
    private double cartTotal = 0;
    private int orderCounter = 1;
    private JButton addBtn, normalBtn, priorityBtn, serveBtn;
    private ArrayList<String> cartItems;
    private JScrollPane cartScroll, menuScroll, addressScroll, queueScroll;
    private Queue<Order> normalQueue = new LinkedList<>();
    private PriorityQueue<Order> priorityQueue =
        new PriorityQueue<>(
            Comparator.comparingInt((Order o) -> o.priorityLevel)
                      .thenComparingInt(o -> o.orderNo)
        );

    static class Order {
        int orderNo;
        int priorityLevel;
        String items;
        String type;
        String customer;
        String phone;
        String address;
        double total;

        Order(int no, String items, double total,
              int level, String type, String customer,
              String phone, String address) {

            this.orderNo = no;
            this.items = items;
            this.total = total;
            this.priorityLevel = level;
            this.type = type;
            this.customer = customer;
            this.phone = phone;
            this.address = address;
        }

        @Override
        public String toString() {
            return "Order #" + orderNo
                + " [" + type + "]"
                + "\nCustomer: " + customer
                + "\nPhone: " + phone
                + "\nAddress: " + address
                + "\nItems: " + items
                + "\nTotal: P" + String.format("%.2f", total)
                + "\n-------------------------";
        }
    }

    public mcdoCustomer() {
        setTitle("Online Food Delivery System");
        setSize(600, 600);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        title = new JLabel("ONLINE FOOD DELIVERY");
        title.setBounds(220, 10, 300, 25);
        add(title);

        // Menu table
        menuModel = new DefaultTableModel(
            new String[]{"Food ID", "Food Name", "Price"}, 0
        ) {
            @Override
            public boolean isCellEditable(int r, int c) {
                return false;
            }
        };

        menuTable = new JTable(menuModel);

        menuScroll = new JScrollPane(menuTable);
        menuScroll.setBounds(20, 45, 645, 150);
        add(menuScroll);

        // Food selection
        sizes = new JComboBox<>(
            new String[]{"Small", "Medium", "Large"}
        );
        sizes.setBounds(20, 205, 100, 30);
        add(sizes);

        qty = new JSpinner(new SpinnerNumberModel(1, 1, 99, 1));
        qty.setBounds(135, 205, 60, 30);
        add(qty);

        addBtn = new JButton("Add to Cart");
        addBtn.setBounds(210, 205, 130, 30);
        add(addBtn);

        cartItems = new ArrayList<>();
        cartArea = new JTextArea();
        cartArea.setEditable(false);

        cartScroll = new JScrollPane(cartArea);
        cartScroll.setBounds(20, 245, 645, 90);
        add(cartScroll);

        totalLabel = new JLabel("Total: P0.00");
        totalLabel.setBounds(20, 340, 200, 25);
        add(totalLabel);

        // Customer information
        nameLabel = new JLabel("Customer Name:");
        nameLabel.setBounds(20, 375, 120, 25);
        add(nameLabel);

        customerName = new JTextField();
        customerName.setBounds(145, 375, 220, 25);
        add(customerName);

        phoneLabel = new JLabel("Phone Number:");
        phoneLabel.setBounds(380, 375, 110, 25);
        add(phoneLabel);

        phone = new JTextField();
        phone.setBounds(485, 375, 180, 25);
        add(phone);

        addressLabel = new JLabel("Delivery Address:");
        addressLabel.setBounds(20, 410, 120, 25);
        add(addressLabel);

        address = new JTextArea();
        address.setLineWrap(true);
        address.setWrapStyleWord(true);

        addressScroll = new JScrollPane(address);
        addressScroll.setBounds(145, 410, 520, 55);
        add(addressScroll);

        // Delivery buttons
        normalBtn = new JButton("Normal Delivery");
        normalBtn.setBounds(20, 475, 180, 30);
        normalBtn.addActionListener(e -> placeOrder(false));
        add(normalBtn);

        priorityBtn = new JButton("Priority Delivery");
        priorityBtn.setBounds(215, 475, 180, 30);
        priorityBtn.addActionListener(e -> placeOrder(true));
        add(priorityBtn);

        serveBtn = new JButton("Serve Next Order");
        serveBtn.setBounds(410, 475, 255, 30);
        serveBtn.addActionListener(e -> serveNext());
        add(serveBtn);

        queueLabel = new JLabel("Delivery Order Queue");
        queueLabel.setBounds(20, 515, 250, 25);
        add(queueLabel);

        queueArea = new JTextArea();
        queueArea.setEditable(false);

        queueScroll = new JScrollPane(queueArea);
        queueScroll.setBounds(20, 545, 645, 240);
        add(queueScroll);

        loadMenu();
        refreshQueues();
        setVisible(true);
        
        addBtn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == addBtn) {

            int row = menuTable.getSelectedRow();

            if (row == -1) {
                JOptionPane.showMessageDialog(
                    this, "Please select a food item."
                );
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

            cartItems.add(
                quantity + "x " + size + " " + name
            );

            cartTotal += subtotal;

            cartArea.append(
                quantity + "x " + size + " " + name
                + " = P" + String.format("%.2f", subtotal)
                + "\n"
            );

            totalLabel.setText(
                "Total: P" + String.format("%.2f", cartTotal)
            );
        }
    }

    private void loadMenu() {

        menuModel.setRowCount(0);

        String sql =
            "SELECT food_id, item_name, price FROM menu";

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
            JOptionPane.showMessageDialog(
                this, "Unable to load menu: " + ex.getMessage()
            );
        }
    }

    private void placeOrder(boolean isPriority) {

        if (cartItems.isEmpty()) {
            JOptionPane.showMessageDialog(
                this, "Your shopping cart is empty."
            );
            return;
        }

        String name = customerName.getText().trim();
        String customerPhone = phone.getText().trim();
        String deliveryAddress = address.getText().trim();

        if (name.isEmpty() || customerPhone.isEmpty()
                || deliveryAddress.isEmpty()) {
            JOptionPane.showMessageDialog(
                this,
                "Please enter your name, phone number, "
                + "and delivery address."
            );
            return;
        }

        String items = String.join(", ", cartItems);

        int level = 0;
        String type = "NORMAL";

        if (isPriority) {

            String[] options = {
                "Senior/PWD",
                "Rush",
                "Member"
            };

            int choice = JOptionPane.showOptionDialog(
                this,
                "Select priority category:",
                "Priority Delivery",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
            );

            if (choice == -1) {
                return;
            }

            level = choice + 1;
            type = options[choice];
        }

        Order order = new Order(
            orderCounter++,
            items,
            cartTotal,
            level,
            type,
            name,
            customerPhone,
            deliveryAddress
        );

        if (isPriority) {
            priorityQueue.offer(order);
        } else {
            normalQueue.offer(order);
        }

        JOptionPane.showMessageDialog(
            this,
            "Order placed successfully!\n"
            + "Order Number: #" + order.orderNo
            + "\nDelivery Type: " + type
            + "\nTotal: P" + String.format("%.2f", order.total)
        );

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
            JOptionPane.showMessageDialog(
                this, "There are no pending delivery orders."
            );
            return;
        }

        JOptionPane.showMessageDialog(
            this,
            "Order is now being processed for delivery:\n\n"
            + served
        );

        refreshQueues();
    }

    private void refreshQueues() {

        StringBuilder sb = new StringBuilder();

        sb.append("PRIORITY DELIVERY QUEUE\n");

        PriorityQueue<Order> copy =
            new PriorityQueue<>(priorityQueue);

        while (!copy.isEmpty()) {
            sb.append(copy.poll()).append("\n");
        }

        sb.append("\nNORMAL DELIVERY QUEUE\n");

        for (Order o : normalQueue) {
            sb.append(o).append("\n");
        }

        queueArea.setText(sb.toString());
    }
}
