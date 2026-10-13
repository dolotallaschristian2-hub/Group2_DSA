
package com.mycompany.fooddelivery;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.*;

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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
