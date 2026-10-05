/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fooddelivery;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.*;
/**
 *
 * @author Mark Joseph Alvarez
 */
public class Order extends JFrame implements ActionListener {

    private DefaultListModel<String> menuModel;
    private DefaultListModel<String> orderModel;

    private LinkedList<String> menuList;
    private LinkedList<Double> menuPriceList;

    private LinkedList<String> orderItems;
    private LinkedList<Double> orderPrices;

    private LinkedList<String> suggestionList;

    private JList<String> menu;
    private JList<String> order;

    private JScrollPane menuScrollPane;
    private JScrollPane orderScrollPane;

    private JButton btnMcDo;
    private JButton btnJollibee;
    private JButton btnMangInasal;
    private JButton btnChowking;

    private JButton btnAdd;
    private JButton btnRemove;
    private JButton btnSuggestion;

    private JTextField txtSuggestion;

    private JLabel lblRestaurant;
    private JLabel lblAddress;
    private JLabel lblTotal;

    private String selectedRestaurant;
    private String selectedAddress;

    public Order() {
    // Initialize Data
    menuModel = new DefaultListModel<>();
    orderModel = new DefaultListModel<>();

    menuList = new LinkedList<>();
    menuPriceList = new LinkedList<>();

    orderItems = new LinkedList<>();
    orderPrices = new LinkedList<>();

    suggestionList = new LinkedList<>();

    // 0rder Windoow
    setTitle("Online Food Delivery - Order");
    setSize(700, 650);
    setLayout(null);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setResizable(false);

    // Restaurant Label
    JLabel lblSelect = new JLabel("Select Restaurant:");
    lblSelect.setBounds(20, 15, 150, 25);
    add(lblSelect);
    
    // Restaurant Buttons
    btnMcDo = new JButton("McDonald's");
    btnMcDo.setBounds(20, 45, 140, 30);
    add(btnMcDo);

    btnJollibee = new JButton("Jollibee");
    btnJollibee.setBounds(170, 45, 120, 30);
    add(btnJollibee);

    btnMangInasal = new JButton("Mang Inasal");
    btnMangInasal.setBounds(300, 45, 140, 30);
    add(btnMangInasal);

    btnChowking = new JButton("Chowking");
    btnChowking.setBounds(450, 45, 120, 30);
    add(btnChowking);
        
    // Restaurant Information
    lblRestaurant = new JLabel("Restaurant: ");
    lblRestaurant.setBounds(20, 90, 400, 25);
    add(lblRestaurant);

    lblAddress = new JLabel("Address: ");
    lblAddress.setBounds(20, 115, 600, 25);
    add(lblAddress);

    // Menu
    JLabel lblMenu = new JLabel("Menu:");
    lblMenu.setBounds(20, 150, 100, 25);
    add(lblMenu);

    menu = new JList<>(menuModel);
    menuScrollPane = new JScrollPane(menu);
    menuScrollPane.setBounds(20, 180, 300, 170);
    add(menuScrollPane);

    // Order
    JLabel lblOrder = new JLabel("Your Order:");
    lblOrder.setBounds(350, 150, 150, 25);
    add(lblOrder);

    order = new JList<>(orderModel);
    orderScrollPane = new JScrollPane(order);
    orderScrollPane.setBounds(350, 180, 300, 170);
    add(orderScrollPane);

    // Buttons
    btnAdd = new JButton("Add to Order");
    btnAdd.setBounds(20, 365, 140, 35);
    add(btnAdd);

    btnRemove = new JButton("Remove");
    btnRemove.setBounds(180, 365, 120, 35);
    add(btnRemove);

    // Total
    lblTotal = new JLabel("Total: ₱0.00");
    lblTotal.setBounds(350, 365, 250, 35);
    add(lblTotal);


    // ActionListeners
    btnMcDo.addActionListener(this);
    btnJollibee.addActionListener(this);
    btnMangInasal.addActionListener(this);
    btnChowking.addActionListener(this);

   
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // McDonald's
        if (e.getSource() == btnMcDo) {

            selectedRestaurant = "McDonald's";
            selectedAddress = "Manila South Road, Biñan, Laguna";

            lblRestaurant.setText("Restaurant: " + selectedRestaurant);
            lblAddress.setText("Address: " + selectedAddress);

            loadMenu(
                new String[]{
                    "Big Mac - ₱189.00",
                    "McChicken - ₱169.00",
                    "Chicken McNuggets - ₱139.00",
                    "McDonald's Fries - ₱89.00",
                    "McFlurry - ₱79.00"
                },
                new double[]{189, 169, 139, 89, 79}
            );

        // Jollibee
        } else if (e.getSource() == btnJollibee) {

            selectedRestaurant = "Jollibee";
            selectedAddress = "A. Bonifacio Street, Biñan, Laguna";

            lblRestaurant.setText("Restaurant: " + selectedRestaurant);
            lblAddress.setText("Address: " + selectedAddress);

            loadMenu(
                new String[]{
                    "1pc Chickenjoy with Rice - ₱99.00",
                    "2pc Chickenjoy with Rice - ₱185.00",
                    "Yumburger - ₱45.00",
                    "Jolly Spaghetti - ₱65.00",
                    "Peach Mango Pie - ₱45.00"
                },
                new double[]{99, 185, 45, 65, 45}
            );

        // Mang Inasal
        } else if (e.getSource() == btnMangInasal) {

            selectedRestaurant = "Mang Inasal";
            selectedAddress = "A. Bonifacio Street, Biñan, Laguna";

            lblRestaurant.setText("Restaurant: " + selectedRestaurant);
            lblAddress.setText("Address: " + selectedAddress);

            loadMenu(
                new String[]{
                    "Regular Chicken + 1 Rice - ₱99.00",
                    "Paa Large + 1 Rice - ₱139.00",
                    "Pecho Large + 1 Rice - ₱169.00",
                    "Pork BBQ - ₱50.00",
                    "Halo-Halo - ₱39.00"
                },
                new double[]{99, 139, 169, 50, 39}
            );

        // Chowking
        } else if (e.getSource() == btnChowking) {

            selectedRestaurant = "Chowking";
            selectedAddress = "Central Mall Biñan, General Malvar Street, Biñan, Laguna";

            lblRestaurant.setText("Restaurant: " + selectedRestaurant);
            lblAddress.setText("Address: " + selectedAddress);

            loadMenu(
            new String[]{
                "Siomai Chao Fan - ₱99.00",
                "Siomai Spicy Chao Fan - ₱99.00",
                "Chunky Asado Siopao - ₱55.00",
                "Halo-Halo - ₱75.00",
                "Chinese-Style Fried Chicken - ₱99.00"
            },
            new double[]{99, 99, 55, 75, 99}
        );
    }

}   
    //Restaurant Menu

    private void loadMenu(String[] items, double[] prices) {

    menuModel.clear();
    menuList.clear();
    menuPriceList.clear();

    for (int i = 0; i < items.length; i++) {

        menuList.add(items[i]);
        menuPriceList.add(prices[i]);

        menuModel.addElement(items[i]);
    }
}

}