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
        this.customerId = customerId;

        setSize(800, 650);
        setTitle("Bai N Eat - Food Delivery");
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // SIDEBAR
        sidebar = new JPanel();
        sidebar.setBounds(0, 0, 180, 650);
        sidebar.setLayout(null);
        sidebar.setBackground(red);
        add(sidebar);

        // LOGO
        JLabel logo = new JLabel("Bai N Eat");
        logo.setBounds(25, 30, 140, 45);
        logo.setFont(new Font("Arial", Font.BOLD, 25));
        logo.setForeground(white);
        sidebar.add(logo);

        JLabel tagline = new JLabel("Food Delivery");
        tagline.setBounds(35, 72, 130, 25);
        tagline.setFont(new Font("Arial", Font.PLAIN, 13));
        tagline.setForeground(cream);
        sidebar.add(tagline);

        // MAIN PANEL
        main = new JPanel();
        main.setLayout(null);
        main.setBounds(180, 0, 620, 650);
        main.setBackground(cream);
        add(main);

        // DASHBOARD TITLE
        lblDashboard = new JLabel("Food Delivery");
        lblDashboard.setBounds(25, 20, 280, 40);
        lblDashboard.setFont(new Font("Arial", Font.BOLD, 27));
        lblDashboard.setForeground(brown);
        main.add(lblDashboard);

        // SEARCH FIELD
        search = new JTextField();
        search.setBounds(340, 25, 250, 35);
        search.setFont(new Font("Arial", Font.PLAIN, 13));
        search.setBackground(white);
        search.setForeground(brown);
        search.setBorder(
            BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(peach, 2),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
            )
        );
        search.setText("Search food or restaurant");
        main.add(search);

        // BANNER
        banner = new JPanel();
        banner.setLayout(null);
        banner.setBounds(25, 90, 570, 155);
        banner.setBackground(red);
        banner.setBorder(BorderFactory.createLineBorder(lightRed, 1));
        main.add(banner);

        bannerTitle = new JLabel("Delicious food right at your door!");
        bannerTitle.setBounds(25, 35, 520, 35);
        bannerTitle.setFont(new Font("Arial", Font.BOLD, 23));
        bannerTitle.setForeground(white);
        banner.add(bannerTitle);

        bannerSubtitle = new JLabel("Order your favorite meals with Bai N Eat.");
        bannerSubtitle.setBounds(27, 80, 500, 30);
        bannerSubtitle.setFont(new Font("Arial", Font.PLAIN, 15));
        bannerSubtitle.setForeground(cream);
        banner.add(bannerSubtitle);

        // RESTAURANT SECTION
        banner2 = new JPanel();
        banner2.setLayout(null);
        banner2.setBounds(25, 265, 570, 290);
        banner2.setBackground(peach);
        main.add(banner2);

        JLabel restaurantTitle = new JLabel("Choose Your Restaurant");
        restaurantTitle.setBounds(20, 15, 400, 35);
        restaurantTitle.setFont(new Font("Arial", Font.BOLD, 21));
        restaurantTitle.setForeground(brown);
        banner2.add(restaurantTitle);

        // RESTAURANT BUTTONS
        mcdo = new JButton("McDonald's");
        mcdo.setBounds(25, 65, 235, 75);
        styleRestaurantButton(mcdo);
        banner2.add(mcdo);

        jollibee = new JButton("Jollibee");
        jollibee.setBounds(300, 65, 235, 75);
        styleRestaurantButton(jollibee);
        banner2.add(jollibee);

        manginasal = new JButton("Mang Inasal");
        manginasal.setBounds(25, 165, 235, 75);
        styleRestaurantButton(manginasal);
        banner2.add(manginasal);

        chowking = new JButton("Chowking");
        chowking.setBounds(300, 165, 235, 75);
        styleRestaurantButton(chowking);
        banner2.add(chowking);

        // SIDEBAR BUTTONS
        home = new JButton("Home");
        home.setBounds(20, 135, 140, 45);
        styleNavButton(home, true);
        sidebar.add(home);

        browse = new JButton("Browse");
        browse.setBounds(20, 195, 140, 45);
        styleNavButton(browse, false);
        sidebar.add(browse);

        orders = new JButton("Orders");
        orders.setBounds(20, 255, 140, 45);
        styleNavButton(orders, false);
        sidebar.add(orders);

        profile = new JButton("Profile");
        profile.setBounds(20, 315, 140, 45);
        styleNavButton(profile, false);
        sidebar.add(profile);

        settings = new JButton("Settings");
        settings.setBounds(20, 375, 140, 45);
        styleNavButton(settings, false);
        sidebar.add(settings);

        logout = new JButton("Logout");
        logout.setBounds(20, 500, 140, 45);
        styleNavButton(logout, false);
        sidebar.add(logout);

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

    private void styleNavButton(JButton button, boolean active) {
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setForeground(white);
        button.setBackground(active ? lightRed : red);
        button.setOpaque(true);
        button.setContentAreaFilled(true);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    private void styleRestaurantButton(JButton button) {
        button.setFont(new Font("Arial", Font.BOLD, 17));
        button.setForeground(brown);
        button.setBackground(white);
        button.setOpaque(true);
        button.setContentAreaFilled(true);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(new Color(230, 195, 160), 2));
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Homepage(1).setVisible(true);
        });
    }
}