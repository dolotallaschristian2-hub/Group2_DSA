package com.mycompany.fooddelivery;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;


public class fooddeliveryGUI extends JFrame implements ActionListener {
    
    private Color bgColor = new Color(250,232,218);
    private Color paneColor = Color.WHITE;
    private Color borderColor = new Color(224,229,235);
    private Color textColor = new Color(28, 33, 39);
    private Color primaryBtnBg = new Color (224, 90, 43);
    private Color secondaryBtnBg = new Color(248, 250, 252);
    
    private JLabel lblheader, username, password, remind;
    private JButton btnlogin, btnregister, back, fpass;
    private JTextField txauser;
    private JPasswordField jpfpass;
    private JPanel panel;
    private int customerid;
    
    fooddeliveryGUI(int customerid){
        setSize(600, 700);
        setTitle("Bai N Eat");
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        getContentPane().setBackground(bgColor);
        
        
        this.customerid = customerid;
        
        panel = new JPanel();
        panel.setBounds(40, 22, 520, 540);
        panel.setBackground(paneColor);
        panel.setLayout(null);
        panel.setBorder(BorderFactory.createLineBorder(borderColor,1,true));
        add(panel);
        
        //Setting of a Label Login Page
        lblheader = new JLabel ("Online Food Delivery System",SwingConstants.CENTER);
        lblheader.setBounds(0, 32, 520, 40);
        lblheader.setFont(new Font("SansSerif", Font.BOLD, 22));
        lblheader.setForeground(textColor);
        panel.add(lblheader);
        
        
        //Labels
        username = new JLabel ("Username: ");
        username.setBounds(75, 115, 100, 34);
        username.setFont(new Font("SansSerif", Font.BOLD, 14));
        username.setForeground(textColor);
        panel.add(username);
        
        
        password = new JLabel ("Password: ");
        password.setBounds(75, 165, 110, 30);
        password.setFont(new Font("SansSerif", Font.BOLD, 14));
        password.setForeground(textColor);
        panel.add(password);
        
        remind = new JLabel ("Do You Have Account?",SwingConstants.CENTER);
        remind.setBounds(0, 320, 520, 26);
        remind.setFont(new Font("SansSerif", Font.BOLD, 14));
        remind.setForeground(textColor);
        panel.add(remind);
        
        //Text and Password
        txauser = new JTextField();
        txauser.setBounds(170, 115, 185, 34);
        txauser.setFont(new Font("SansSerif", Font.BOLD, 14));
        txauser.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(borderColor,1,true),BorderFactory.createEmptyBorder(0,8,0,8)));
        panel.add(txauser);
        
        jpfpass = new JPasswordField();
        jpfpass.setBounds(170, 165, 185, 34);
        txauser.setFont(new Font("SansSerif", Font.BOLD, 14));
        txauser.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(borderColor,1,true),BorderFactory.createEmptyBorder(0,8,0,8)));
        panel.add(jpfpass);
        
        //Setting of Buttons
        btnlogin = new JButton("Login");
        btnlogin.setBounds(180, 235, 160, 42);
        btnlogin.setFont(new Font("SansSerif", Font.BOLD,14));
        btnlogin.setForeground(Color.WHITE);
        btnlogin.setBackground(primaryBtnBg);
        btnlogin.setFocusPainted(false);
        btnlogin.setBorderPainted(false);
        btnlogin.setOpaque(true);
        panel.add(btnlogin);
        
        btnregister = new JButton("Register");
        btnregister.setBounds(190, 355, 140, 38);
        btnregister.setBackground(new Color(150, 70, 80));
        panel.add(btnregister);
        
        fpass = new JButton("Forget Password");
        fpass.setBounds(180, 405, 160, 36);
        panel.add(fpass);
        
        back = new JButton("<-----");
        back.setBounds(39, 30, 75, 30);
        add(back);
        
        
        
       btnlogin.addActionListener(this);
       btnregister.addActionListener(this); 
       back.addActionListener(this);
       fpass.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnlogin) {

    String username = txauser.getText().trim();
    String password = new String(jpfpass.getPassword());

            if (username.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Enter the Username", "Error", JOptionPane.ERROR_MESSAGE);
            } 
            else if (password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Check the Password", "Error", JOptionPane.ERROR_MESSAGE);
            } 
            else {
                String sql = "SELECT * FROM users WHERE BINARY username = ?";

                try {
                    Connection con = DBConnection.getConnection();
                    PreparedStatement pet = con.prepareStatement(sql);

                    pet.setString(1, username);

                    ResultSet res = pet.executeQuery();

            // Check whether the username exists
                if (res.next()) {
                    String hash = res.getString("password");

                    if (hash != null && !hash.isEmpty()) {

                    try {
                        // Verify the password
                        if (encryption.Password(password, hash)) {
                            
                            int customerid = res.getInt("id");
                            
                            JOptionPane.showMessageDialog(this, "Login Successful", "Login", JOptionPane.INFORMATION_MESSAGE);

                            Homepage home = new Homepage(customerid);
                            home.setVisible(true);
                            this.dispose();
                        } else {
                            JOptionPane.showMessageDialog(this, "Invalid Username or Password","Error", JOptionPane.ERROR_MESSAGE);
                        }

                        } catch (Exception ex) {
                        JOptionPane.showMessageDialog(this, "Password verification error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        ex.printStackTrace();
                    }

                    } else {
                    JOptionPane.showMessageDialog(this, "Invalid Username or Password","Error", JOptionPane.ERROR_MESSAGE);
                    }

                } else {
                // IMPORTANT: Username was not found in the database
                JOptionPane.showMessageDialog(this, "Invalid Username or Password","Error", JOptionPane.ERROR_MESSAGE);
                }

            res.close();
            pet.close();
            con.close();

                }catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Database Error: " + ex.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            }
        }

       else if(e.getSource() == btnregister){
//           Goes to the register class
           register reg = new register(customerid);
           reg.setVisible(true);
           this.dispose();
       }
       else if (e.getSource() == back){
//           Goes to the choices class
            Choices cs = new Choices(customerid);
            cs.setVisible(true);
            this.dispose();
        }
       else if (e.getSource() == fpass){
//           Goes to the forgetPass class
            forgetPass fp = new forgetPass(customerid);
            fp.setVisible(true);
            this.dispose();
       }
    }
}
