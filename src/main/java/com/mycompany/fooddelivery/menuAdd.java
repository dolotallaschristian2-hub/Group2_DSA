/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.fooddelivery;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.*;

public class menuAdd extends JFrame implements ActionListener {

    private JLabel title, subtitle;
    private JLabel rest, name, desc, price;

    private JTextField resID, restname, descrp, prices;

    private JButton save, clear, back;

    private JPanel header, formPanel;

    private int customerid;

    // COLOR PALETTE
    Color cream = new Color(248, 241, 231);
    Color red = new Color(201, 54, 54);
    Color lightRed = new Color(170, 43, 43);
    Color peach = new Color(245, 217, 181);
    Color brown = new Color(84, 45, 43);
    Color white = Color.WHITE;

    menuAdd(int customerid) {

        this.customerid = customerid;

        setTitle("Bai N Eat - Add Menu Item");
        setSize(650, 600);
        setLayout(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        getContentPane().setBackground(cream);

        // HEADER
        header = new JPanel();
        header.setLayout(null);
        header.setBounds(0, 0, 650, 110);
        header.setBackground(brown);
        add(header);

        // BACK BUTTON
        back = new JButton("Back");

        back.setBounds(20, 20, 80, 35);

        back.setBackground(lightRed);
        back.setForeground(white);

        back.setFont(
                new Font("Sans-Serif", Font.BOLD, 13)
        );

        back.setFocusPainted(false);
        back.setBorderPainted(false);

        header.add(back);

        // TITLE
        title = new JLabel(
                "Add Menu Item",
                SwingConstants.CENTER
        );

        title.setFont(
                new Font("Sans-Serif", Font.BOLD, 27)
        );

        title.setForeground(white);
        title.setBounds(150, 25, 350, 35);

        header.add(title);

        // SUBTITLE
        subtitle = new JLabel(
                "Enter the details of the food item",
                SwingConstants.CENTER
        );

        subtitle.setFont(
                new Font("Sans-Serif", Font.PLAIN, 14)
        );

        subtitle.setForeground(cream);
        subtitle.setBounds(150, 65, 350, 25);

        header.add(subtitle);

        // FORM PANEL
        formPanel = new JPanel();
        formPanel.setLayout(null);
        formPanel.setBounds(75, 140, 500, 350);
        formPanel.setBackground(peach);

        formPanel.setBorder(
                new CompoundBorder(
                        new LineBorder(
                                new Color(225, 195, 160), 1
                        ),
                        new EmptyBorder(20, 20, 20, 20)
                )
        );

        add(formPanel);

        // FOOD ID
        rest = createLabel("Food ID:");
        rest.setBounds(35, 30, 120, 30);
        formPanel.add(rest);

        resID = createTextField();
        resID.setBounds(160, 30, 300, 35);
        formPanel.add(resID);

        // FOOD NAME
        name = createLabel("Food Name:");
        name.setBounds(35, 90, 120, 30);
        formPanel.add(name);

        restname = createTextField();
        restname.setBounds(160, 90, 300, 35);
        formPanel.add(restname);

        // DESCRIPTION
        desc = createLabel("Description:");
        desc.setBounds(35, 150, 120, 30);
        formPanel.add(desc);

        descrp = createTextField();
        descrp.setBounds(160, 150, 300, 35);
        formPanel.add(descrp);

        // PRICE
        price = createLabel("Price:");
        price.setBounds(35, 210, 120, 30);
        formPanel.add(price);

        prices = createTextField();
        prices.setBounds(160, 210, 300, 35);
        formPanel.add(prices);

        // SAVE BUTTON
        save = new JButton("Save");

        save.setBounds(160, 275, 140, 40);

        save.setBackground(red);
        save.setForeground(white);

        save.setFont(
                new Font("Sans-Serif", Font.BOLD, 14)
        );

        save.setFocusPainted(false);
        save.setBorderPainted(false);

        save.setCursor(
                new Cursor(Cursor.HAND_CURSOR)
        );

        formPanel.add(save);

        // CLEAR BUTTON
        clear = new JButton("Clear");

        clear.setBounds(320, 275, 140, 40);

        clear.setBackground(lightRed);
        clear.setForeground(white);

        clear.setFont(
                new Font("Sans-Serif", Font.BOLD, 14)
        );

        clear.setFocusPainted(false);
        clear.setBorderPainted(false);

        clear.setCursor(
                new Cursor(Cursor.HAND_CURSOR)
        );

        formPanel.add(clear);

        // ACTION LISTENERS
        save.addActionListener(this);
        clear.addActionListener(this);
        back.addActionListener(this);
    }

    // LABEL DESIGN
    private JLabel createLabel(String text) {

        JLabel label = new JLabel(text);

        label.setFont(
                new Font("Sans-Serif", Font.BOLD, 15)
        );

        label.setForeground(brown);

        return label;
    }

    // TEXT FIELD DESIGN
    private JTextField createTextField() {

        JTextField field = new JTextField();

        field.setFont(
                new Font("Sans-Serif", Font.PLAIN, 14)
        );

        field.setBackground(white);
        field.setForeground(brown);

        field.setCaretColor(red);

        field.setBorder(
                new CompoundBorder(
                        new LineBorder(
                                new Color(210, 180, 150), 1
                        ),
                        new EmptyBorder(5, 10, 5, 10)
                )
        );

        return field;
    }

    // CLEAR INPUT FIELDS
    private void clearFields() {

        resID.setText("");
        restname.setText("");
        descrp.setText("");
        prices.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == save) {

            String foodID = resID.getText().trim();
            String foodname = restname.getText().trim();
            String des = descrp.getText().trim();
            String pri = prices.getText().trim();

            // VALIDATION
            if (foodID.isEmpty()
                    || foodname.isEmpty()
                    || pri.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please input Food ID, Name and Price.",
                        "Missing Information",
                        JOptionPane.INFORMATION_MESSAGE
                );

                return;
            }

            int foodId;
            double money;

            try {

                foodId = Integer.parseInt(foodID);
                money = Double.parseDouble(pri);

                if (foodId <= 0
                        || money <= 0
                        || !Double.isFinite(money)) {

                    JOptionPane.showMessageDialog(
                            this,
                            "Please enter a valid Food ID and Price.",
                            "Invalid Input",
                            JOptionPane.ERROR_MESSAGE
                    );

                    return;
                }

            } catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(
                        this,
                        "Food ID must be a whole number "
                        + "and Price must be numeric.",
                        "Invalid Input",
                        JOptionPane.ERROR_MESSAGE
                );

                return;
            }

            // DATABASE INSERT
            String sql =
                    "INSERT INTO menu "
                    + "(food_id, item_name, description, price) "
                    + "VALUES (?, ?, ?, ?)";

            try (
                    Connection c = DBConnection.getConnection();
                    PreparedStatement pst = c.prepareStatement(sql)
            ) {

                pst.setInt(1, foodId);
                pst.setString(2, foodname);
                pst.setString(3, des);
                pst.setDouble(4, money);

                int rows = pst.executeUpdate();

                if (rows > 0) {

                    JOptionPane.showMessageDialog(
                            this,
                            "Menu Item Saved Successfully!",
                            "Success",
                            JOptionPane.INFORMATION_MESSAGE
                    );

                    clearFields();
                }

            } catch (SQLException ex) {

                JOptionPane.showMessageDialog(
                        this,
                        "Error Saving Menu: " + ex.getMessage(),
                        "Database Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }

        } else if (e.getSource() == clear) {

            clearFields();

        } else if (e.getSource() == back) {

            mcdoRestaurant r =
                    new mcdoRestaurant(customerid);

            r.setVisible(true);

            this.dispose();
        }
    }
}
