/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.fooddelivery;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.*;

public class Browse extends JFrame implements ActionListener {

    private int customerid;

    private JLabel title, MCDO, JOL, MANG;
    private JLabel infomc, infojol, infomang;
    private JLabel pricemc, pricejol, pricemang;

    private JButton mcdo, jol, mang;
    private JButton home, browse, orders;
    private JButton profile, settings, logout;

    private JPanel panel, pan1, pan2, pan3;

    // COLOR PALETTE
    Color cream = new Color(248, 241, 231);
    Color red = new Color(201, 54, 54);
    Color lightRed = new Color(170, 43, 43);
    Color peach = new Color(245, 217, 181);
    Color brown = new Color(84, 45, 43);
    Color white = Color.WHITE;

    Browse(int customerid) {

        this.customerid = customerid;

        setTitle("Bai N Eat - Browse");
        setSize(850, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);

        getContentPane().setBackground(cream);
        setLayout(null);

        // MAIN TITLE
        title = new JLabel("Browse Food Menu");
        title.setFont(new Font("Sans-Serif", Font.BOLD, 28));
        title.setForeground(brown);
        title.setBounds(190, 30, 450, 40);
        add(title);

        // SIDEBAR
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 160, 650);
        panel.setBackground(brown);
        add(panel);

        // SIDEBAR LOGO
        JLabel logo = new JLabel("Bai N Eat");
        logo.setFont(new Font("Sans-Serif", Font.BOLD, 22));
        logo.setForeground(white);
        logo.setBounds(25, 25, 130, 35);
        panel.add(logo);

        JLabel subtitle = new JLabel("Food Delivery");
        subtitle.setFont(new Font("Sans-Serif", Font.PLAIN, 12));
        subtitle.setForeground(cream);
        subtitle.setBounds(25, 60, 130, 20);
        panel.add(subtitle);

        // FOOD PANELS
        pan1 = createFoodPanel(190, 100);
        pan2 = createFoodPanel(190, 245);
        pan3 = createFoodPanel(190, 390);

        add(pan1);
        add(pan2);
        add(pan3);

        // SIDEBAR BUTTONS
        home = createNavButton("Home", 110);
        browse = createNavButton("Browse", 180);
        orders = createNavButton("Orders", 250);
        profile = createNavButton("Profile", 320);
        settings = createNavButton("Settings", 390);
        logout = createNavButton("Logout", 500);

        // MCDONALD'S
        MCDO = createFoodName(
                "McDonald's - Mixed and Match"
        );

        pricemc = createPrice("₱99");

        infomc = createInfo(
                "Click ADD TO CART to add the meal"
        );

        mcdo = createFoodButton();

        pan1.add(MCDO);
        pan1.add(pricemc);
        pan1.add(infomc);
        pan1.add(mcdo);

        // JOLLIBEE
        JOL = createFoodName(
                "Jollibee - Mixed and Match"
        );

        pricejol = createPrice("₱99");

        infojol = createInfo(
                "Click ADD TO CART to add the meal"
        );

        jol = createFoodButton();

        pan2.add(JOL);
        pan2.add(pricejol);
        pan2.add(infojol);
        pan2.add(jol);

        // MANG INASAL
        MANG = createFoodName(
                "Mang Inasal - Pecho Large"
        );

        pricemang = createPrice("₱169");

        infomang = createInfo(
                "Click ADD TO CART to add the meal"
        );

        mang = createFoodButton();

        pan3.add(MANG);
        pan3.add(pricemang);
        pan3.add(infomang);
        pan3.add(mang);

        // ACTION LISTENERS
        mcdo.addActionListener(this);
        jol.addActionListener(this);
        mang.addActionListener(this);

        home.addActionListener(this);
        browse.addActionListener(this);
        orders.addActionListener(this);
        profile.addActionListener(this);
        settings.addActionListener(this);
        logout.addActionListener(this);
    }

    // FOOD PANEL DESIGN
    private JPanel createFoodPanel(int x, int y) {

        JPanel foodPanel = new JPanel();
        foodPanel.setLayout(null);

        foodPanel.setBounds(x, y, 620, 120);
        foodPanel.setBackground(peach);

        foodPanel.setBorder(
                new CompoundBorder(
                        new LineBorder(
                                new Color(225, 195, 160), 1
                        ),
                        new EmptyBorder(10, 10, 10, 10)
                )
        );

        return foodPanel;
    }

    // NAVIGATION BUTTON DESIGN
    private JButton createNavButton(String text, int y) {

        JButton button = new JButton(text);

        button.setBounds(20, y, 120, 45);

        button.setBackground(brown);
        button.setForeground(cream);

        button.setFont(
                new Font("Sans-Serif", Font.BOLD, 14)
        );

        button.setFocusPainted(false);
        button.setBorder(
                new LineBorder(lightRed, 1)
        );

        button.setCursor(
                new Cursor(Cursor.HAND_CURSOR)
        );

        panel.add(button);

        return button;
    }

    // FOOD NAME DESIGN
    private JLabel createFoodName(String text) {

        JLabel label = new JLabel(text);

        label.setBounds(25, 15, 400, 30);

        label.setFont(
                new Font("Sans-Serif", Font.BOLD, 17)
        );

        label.setForeground(brown);

        return label;
    }

    // PRICE DESIGN
    private JLabel createPrice(String text) {

        JLabel label = new JLabel(text);

        label.setBounds(25, 45, 100, 25);

        label.setFont(
                new Font("Sans-Serif", Font.BOLD, 18)
        );

        label.setForeground(red);

        return label;
    }

    // DESCRIPTION DESIGN
    private JLabel createInfo(String text) {

        JLabel label = new JLabel(text);

        label.setBounds(25, 75, 400, 25);

        label.setFont(
                new Font("Sans-Serif", Font.PLAIN, 13)
        );

        label.setForeground(brown);

        return label;
    }

    // FOOD BUTTON DESIGN
    private JButton createFoodButton() {

        JButton button = new JButton("Add to cart");

        button.setBounds(450, 25, 140, 40);

        button.setBackground(lightRed);
        button.setForeground(white);

        button.setFont(
                new Font("Sans-Serif", Font.BOLD, 13)
        );

        button.setFocusPainted(false);
        button.setBorderPainted(false);

        button.setCursor(
                new Cursor(Cursor.HAND_CURSOR)
        );

        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == home) {

            Homepage h = new Homepage(customerid);
            h.setVisible(true);
            this.dispose();

        } else if (e.getSource() == browse) {

            Browse b = new Browse(customerid);
            b.setVisible(true);
            this.dispose();

        } else if (e.getSource() == orders) {

            Orderss o = new Orderss(customerid);
            o.setVisible(true);
            this.dispose();

        } else if (e.getSource() == settings) {

            Settings s = new Settings(customerid);
            s.setVisible(true);
            this.dispose();

        } else if (e.getSource() == profile) {

            profile p = new profile(customerid);
            p.setVisible(true);
            this.dispose();

        } else if (e.getSource() == logout) {

            int confirm = JOptionPane.showConfirmDialog(
                    this,
                    "Are you sure you want to logout?",
                    "Logout",
                    JOptionPane.YES_NO_OPTION
            );

            if (confirm == JOptionPane.YES_OPTION) {

                fooddeliveryGUI g =
                        new fooddeliveryGUI(customerid);

                g.setVisible(true);
                this.dispose();
            }

        } else if (e.getSource() == mcdo) {

            mcdoCustomer m =
                    new mcdoCustomer(customerid);

            m.setVisible(true);
            this.dispose();

        } else if (e.getSource() == jol) {

            jolCustomer j =
                    new jolCustomer(customerid);

            j.setVisible(true);
            this.dispose();

        } else if (e.getSource() == mang) {

            mangCustomer m =
                    new mangCustomer(customerid);

            m.setVisible(true);
            this.dispose();
        }
    }
}
