
package com.mycompany.fooddelivery;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Homepage extends JFrame implements ActionListener {

    private int customerId;

    private JLabel lblDashboard, bannerTitle, bannerSubtitle;

    private JPanel sidebar, main, banner, banner2;

    private JButton home, browse, orders, profile, settings, logout;
    private JButton mcdo, jollibee, manginasal, chowking;

    private JTextField search;

    // COLOR PALETTE
    Color cream = new Color(248, 241, 231);
    Color red = new Color(201, 54, 54);
    Color lightRed = new Color(170, 43, 43);
    Color peach = new Color(245, 217, 181);
    Color brown = new Color(84, 45, 43);
    Color white = Color.WHITE;

    public Homepage(int customerId) {

        setSize(600, 600);
        setTitle("Bai N Eat - Food Delivery");
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        this.customerId = customerId;

        // SIDEBAR
        sidebar = new JPanel();
        sidebar.setBounds(0, 0, 150, 550);
        sidebar.setLayout(null);
        sidebar.setBackground(red);
        add(sidebar);

        // MAIN PANEL
        main = new JPanel();
        main.setLayout(null);
        main.setBounds(150, 0, 450, 550);
        main.setBackground(cream);
        add(main);

        // BANNERS
        banner = new JPanel();
        banner.setLayout(null);
        banner.setBounds(20, 110, 400, 150);
        banner.setBackground(red);
        banner.setBorder(BorderFactory.createLineBorder(lightRed, 1));
        main.add(banner);

        banner2 = new JPanel();
        banner2.setLayout(null);
        banner2.setBounds(20, 280, 400, 150);
        banner2.setBackground(peach);
        main.add(banner2);

        // SIDEBAR BUTTONS
        home = new JButton("Home");
        home.setBounds(25, 30, 90, 40);
        styleNavButton(home, true);
        sidebar.add(home);

        browse = new JButton("Browse");
        browse.setBounds(25, 110, 90, 40);
        styleNavButton(browse, false);
        sidebar.add(browse);

        orders = new JButton("Orders");
        orders.setBounds(25, 190, 90, 40);
        styleNavButton(orders, false);
        sidebar.add(orders);

        profile = new JButton("Profile");
        profile.setBounds(25, 270, 90, 40);
        styleNavButton(profile, false);
        sidebar.add(profile);

        settings = new JButton("Settings");
        settings.setBounds(25, 340, 90, 40);
        styleNavButton(settings, false);
        sidebar.add(settings);

        logout = new JButton("Logout");
        logout.setBounds(25, 420, 90, 40);
        styleNavButton(logout, false);
        sidebar.add(logout);

        // RESTAURANT BUTTONS
        mcdo = new JButton("McDonald's");
        mcdo.setBounds(25, 65, 100, 30);
        styleRestaurantButton(mcdo);
        banner.add(mcdo);

        jollibee = new JButton("Jollibee");
        jollibee.setBounds(25, 110, 100, 30);
        styleRestaurantButton(jollibee);
        banner.add(jollibee);

        manginasal = new JButton("Mang Inasal");
        manginasal.setBounds(205, 65, 110, 30);
        styleRestaurantButton(manginasal);
        banner.add(manginasal);

        chowking = new JButton("Chowking");
        chowking.setBounds(205, 110, 100, 30);
        styleRestaurantButton(chowking);
        banner.add(chowking);

        // SEARCH FIELD
        search = new JTextField();
        search.setBounds(200, 15, 200, 30);
        search.setFont(new Font("Arial", Font.PLAIN, 12));
        search.setBackground(white);
        search.setForeground(brown);
        search.setBorder(
            BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(peach, 2),
                BorderFactory.createEmptyBorder(3, 8, 3, 8)
            )
        );
        search.setText("Search food or restaurant");
        main.add(search);

        // LABELS
        lblDashboard = new JLabel("Food Delivery");
        lblDashboard.setBounds(30, 15, 400, 40);
        lblDashboard.setFont(new Font("Arial", Font.BOLD, 25));
        lblDashboard.setForeground(brown);
        main.add(lblDashboard);

        bannerTitle = new JLabel("Delicious food right at your door!");
        bannerTitle.setBounds(25, 15, 370, 30);
        bannerTitle.setFont(new Font("Arial", Font.BOLD, 18));
        bannerTitle.setForeground(white);
        banner.add(bannerTitle);

        bannerSubtitle = new JLabel("Order your favorite meals with Bai N Eat.");
        bannerSubtitle.setBounds(25, 45, 370, 25);
        bannerSubtitle.setFont(new Font("Arial", Font.PLAIN, 12));
        bannerSubtitle.setForeground(cream);
        banner.add(bannerSubtitle);

        JLabel restaurantTitle = new JLabel("Choose Your Restaurant");
        restaurantTitle.setBounds(15, 10, 370, 30);
        restaurantTitle.setFont(new Font("Arial", Font.BOLD, 18));
        restaurantTitle.setForeground(brown);
        banner2.add(restaurantTitle);

        // ACTION LISTENERS
        home.addActionListener(this);
        browse.addActionListener(this);
        orders.addActionListener(this);
        profile.addActionListener(this);
        settings.addActionListener(this);
        logout.addActionListener(this);

        mcdo.addActionListener(this);
        jollibee.addActionListener(this);
        manginasal.addActionListener(this);
        chowking.addActionListener(this);
    }

    // SIDEBAR BUTTON DESIGN
    private void styleNavButton(JButton button, boolean active) {
        button.setFont(new Font("Arial", Font.BOLD, 13));
        button.setForeground(white);
        button.setBackground(active ? lightRed : red);
        button.setOpaque(true);
        button.setContentAreaFilled(true);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    // RESTAURANT BUTTON DESIGN
    private void styleRestaurantButton(JButton button) {
        button.setFont(new Font("Arial", Font.BOLD, 12));
        button.setForeground(brown);
        button.setBackground(white);
        button.setOpaque(true);
        button.setContentAreaFilled(true);
        button.setFocusPainted(false);
        button.setBorder(
            BorderFactory.createLineBorder(new Color(230, 195, 160), 2)
        );
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == home) {

            Homepage hm = new Homepage(customerId);
            hm.setVisible(true);
            this.dispose();

        } else if (e.getSource() == browse) {

            Browse b = new Browse(customerId);
            b.setVisible(true);
            this.dispose();

        } else if (e.getSource() == orders) {

            Orderss o = new Orderss(customerId);
            o.setVisible(true);
            this.dispose();

        } else if (e.getSource() == profile) {

            profile p = new profile(customerId);
            p.setVisible(true);
            this.dispose();

        } else if (e.getSource() == settings) {

            Settings s = new Settings(customerId);
            s.setVisible(true);
            this.dispose();

        } else if (e.getSource() == logout) {

            int confirm = JOptionPane.showConfirmDialog(
                this,
                "Are you sure to log out?",
                "Log out",
                JOptionPane.YES_NO_OPTION
            );

            if (confirm == JOptionPane.YES_OPTION) {
                fooddeliveryGUI g = new fooddeliveryGUI(customerId);
                g.setVisible(true);
                this.dispose();
            }

        } else if (e.getSource() == mcdo) {

            mcdoCustomer m = new mcdoCustomer(customerId);
            m.setVisible(true);
            this.dispose();

        } else if (e.getSource() == jollibee) {

            jolCustomer j = new jolCustomer(customerId);
            j.setVisible(true);
            this.dispose();

        } else if (e.getSource() == manginasal) {

            mangCustomer s = new mangCustomer(customerId);
            s.setVisible(true);
            this.dispose();

        } else if (e.getSource() == chowking) {

            chowCustomer c = new chowCustomer(customerId);
            c.setVisible(true);
            this.dispose();
        }
    }
}
