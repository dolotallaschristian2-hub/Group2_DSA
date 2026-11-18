package com.mycompany.fooddelivery;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.*;

public class MapClass extends JFrame implements ActionListener{
    private final int customerId;
    private final String resName = "McDonald's Biñan Bayan";
    private final String resLoc = "35 A Bonifacio Street, Brgy. Poblacion";
    private JLabel title, name, add, custt;
    private JButton con, route;
    private route deliveryRoute;
    private JComboBox<String> loc;
    private JTextArea text;
    private JScrollPane sc;
    
    MapClass(int customerId){
        this.customerId = customerId;
        
        setTitle("Bai N Eat - Restaurant Location");
        setSize(600, 650);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        
        deliveryRoute = new route();
        
        deliveryRoute.addRoad(resName, "Biñan Plaza" , 1.0);
        deliveryRoute.addRoad("Biñan Plaza", "Biñan City Hall", 1.5);
        deliveryRoute.addRoad(resName, "Biñan City Hall", 2.0);
        deliveryRoute.addRoad("Biñan City Hall", "Customer Location A", 1.5);
        deliveryRoute.addRoad("Biñan Plaza", "Customer Location A", 2.0);
        deliveryRoute.addRoad(resName, "PUP Biñan- CITE", 2.5);
        
        loc = new JComboBox<>();
        
        loc.addItem("Biñan Plaza");
        loc.addItem("Biñan City Hall");
        loc.addItem("PUP Biñan- CITE");
        loc.addItem("Customer Location A");
        
        loc.setBounds(180, 430, 200, 25);
        add(loc);
        
        
        title = new JLabel("Restaurant Location");
        title.setBounds(30, 20, 400, 35);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        add(title);
        
        custt = new JLabel("Customer Location");
        custt.setBounds(30, 430, 150, 25);
        add(custt);
        
        name = new JLabel(resName);
        name.setBounds(30, 65, 500, 30);
        name.setFont(new Font("Arial", Font.PLAIN, 13));
        add(name);
        
        add = new JLabel(resLoc);
        add.setFont(new Font("Arial", Font.PLAIN, 13));
        add.setBounds(30, 100, 530, 25);
        add(add);
        
        MapPanel mapPanel = new MapPanel();
        mapPanel.setBounds(30, 140, 520, 280);
        add(mapPanel);
        
        con = new JButton("Continue to Menu");
        con.setBounds(250, 465, 200, 35);
        add(con);
        
        route = new JButton("Find Shortest Route");
        route.setBounds(30, 465, 200, 35);
        add(route);
        
        text = new JTextArea();
        text.setEditable(false);
        sc = new JScrollPane(text);
        sc.setBounds(30, 510, 520, 50);
        add(sc);

        route.addActionListener(this);
        con.addActionListener(this);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == con){
            mcdoCustomer m = new mcdoCustomer(customerId);
            m.setVisible(true);
            this.dispose();
        }else if(e.getSource() == route){
            String start = resName;
            String destination = (String)loc.getSelectedItem();
            LinkedList<String> shortestPath = deliveryRoute.Shortestroute(start, destination);
            
            if(shortestPath == null){
                text.setText("No Available Route");
            }else {
                text.setText("Shortest Delivery Route: \n" + String.join("--->", shortestPath));
            }
        }
    }
    
    public class MapPanel extends JPanel{
        MapPanel(){
            setBackground(new Color(235, 240, 230));
            setBorder(BorderFactory.createLineBorder(Color.gray));
        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2 = (Graphics2D) g.create();

            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);

            int width = getWidth();
            int height = getHeight();

       
            g2.setColor(new Color(225, 235, 215));
            g2.fillRect(0, 0, width, height);

            // Roads
            g2.setColor(Color.WHITE);
            g2.setStroke(new BasicStroke(35));
            g2.drawLine(0, height / 2, width, height / 2);
            g2.drawLine(width / 2, 0, width / 2, height);

            // Road Borders
            g2.setColor(new Color(180, 180, 180));
            g2.setStroke(new BasicStroke(1));

            g2.drawLine(0, height / 2 - 18,
                    width, height / 2 - 18);

            g2.drawLine(0, height / 2 + 18,
                    width, height / 2 + 18);

            g2.drawLine(width / 2 - 18, 0,
                    width / 2 - 18, height);

            g2.drawLine(width / 2 + 18, 0,
                    width / 2 + 18, height);

            // Road Names
            g2.setColor(Color.DARK_GRAY);
            g2.setFont(new Font("Arial", Font.BOLD, 13));

            g2.drawString("Brgy. Poblacion", 20, height / 2 - 25);

            g2.drawString("35 A Bonifacio Street",
                    width / 2 + 25, 30);

            // Restaurant Marker
            int markerX = width / 2 + 45;
            int markerY = height / 2 + 45;

            g2.setColor(Color.RED);
            g2.fillOval(markerX, markerY, 25, 25);

            g2.setColor(Color.WHITE);
            g2.fillOval(markerX + 7, markerY + 7, 11, 11);

            // Restaurant Label
            g2.setColor(Color.BLACK);
            g2.setFont(new Font("Arial", Font.BOLD, 14));

            g2.drawString("McDonald's",
                    markerX + 30, markerY + 12);

            g2.dispose();
        }
    }
    
    
}

