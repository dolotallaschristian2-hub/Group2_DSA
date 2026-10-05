/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mapmain;

/**
 *
 * @author admin
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MapClass extends JFrame implements ActionListener {

    private JLabel lblTitle;
    private JLabel lblStart;
    private JLabel lblDestination;

    private JComboBox<String> startComboBox;
    private JComboBox<String> destinationComboBox;

    private JButton btnFindRoute;

    private JTextArea txtResult;
    private JScrollPane scrollPane;

    MapClass() {

        setTitle("Delivery Route System");
        setSize(400, 450);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Title
        lblTitle = new JLabel("DELIVERY ROUTE SYSTEM");
        lblTitle.setBounds(120, 20, 200, 30);
        add(lblTitle);

        // Starting Loc
        lblStart = new JLabel("Starting Location:");
        lblStart.setBounds(30, 70, 150, 30);
        add(lblStart);

        startComboBox = new JComboBox<>();

        startComboBox.addItem("Loc1");
        startComboBox.addItem("Loc2");
        startComboBox.addItem("Loc3");
        startComboBox.addItem("Loc4");
        startComboBox.addItem("Loc5");

        startComboBox.setBounds(30, 100, 150, 30);
        add(startComboBox);

        // Customer
        lblDestination = new JLabel("Customer Location:");
        lblDestination.setBounds(30, 150, 150, 30);
        add(lblDestination);

        destinationComboBox = new JComboBox<>();

        destinationComboBox.addItem("Loc1");
        destinationComboBox.addItem("Loc2");
        destinationComboBox.addItem("Loc3");
        destinationComboBox.addItem("Loc4");
        destinationComboBox.addItem("Loc5");

        destinationComboBox.setBounds(30, 180, 150, 30);
        add(destinationComboBox);

        // Find
        btnFindRoute = new JButton("FIND DELIVERY ROUTE");
        btnFindRoute.setBounds(100, 230, 200, 40);
        add(btnFindRoute);

        btnFindRoute.addActionListener(this);

        // Result Area
        txtResult = new JTextArea();
        txtResult.setEditable(false);

        scrollPane = new JScrollPane(txtResult);
        scrollPane.setBounds(30, 290, 330, 100);
        add(scrollPane);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnFindRoute) {

            // Route code vv

        }
    }

    public static void main(String[] args) {

        MapClass frame = new MapClass();

        frame.setVisible(true);
    }
}
