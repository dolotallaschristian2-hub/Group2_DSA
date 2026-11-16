package com.mycompany.fooddelivery;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MapClass extends JFrame implements ActionListener{
    private final int customerId;
    private final String resName = "McDonald's Biñan Bayan";
    private final String resLoc = "35 A Bonifacio Street, Brgy. Poblacion";
    private JLabel title, name, add;
    private JButton con;
    
    
    MapClass(int customerId){
        this.customerId = customerId;
        
        setTitle("Bai N Eat - Restaurant Location");
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        
        title = new JLabel("Restaurant Location");
        title.setBounds(30, 20, 400, 35);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        add(title);
        
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
        con.setBounds(180, 440, 220, 40);
        add(con);
        
        con.addActionListener(this);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == con){
            mcdoCustomer m = new mcdoCustomer(customerId);
            m.setVisible(true);
            this.dispose();
        }
    }
    
    public class MapPanel extends JPanel{
        MapPanel(){
            setBackground(new Color(235, 240, 230));
            setBorder(BorderFactory.createLineBorder(Color.gray));
        }
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

