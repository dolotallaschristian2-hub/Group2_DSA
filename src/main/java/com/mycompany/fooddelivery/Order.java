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

    // Restaurant Information
    lblRestaurant = new JLabel("Restaurant: ");
    lblRestaurant.setBounds(20, 90, 400, 25);
    add(lblRestaurant);

    lblAddress = new JLabel("Address: ");
    lblAddress.setBounds(20, 115, 600, 25);
    add(lblAddress);

    // Total
    lblTotal = new JLabel("Total: ₱0.00");
    lblTotal.setBounds(350, 365, 250, 35);
    add(lblTotal);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}