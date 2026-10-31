package com.mycompany.fooddelivery;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class restaurant_register extends JFrame implements ActionListener{
    private JLabel label ,user ,password, again;
    private JButton create, back, agains;
    private JTextArea text;
    private JPasswordField pass, another;
    private int customerid;
    
        restaurant_register(int customerid){
        setSize(600, 600);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        
        this.customerid = customerid;
        
        label = new JLabel("Create Account", SwingConstants.CENTER);
        label.setBounds(220, 90, 120, 30);
        add(label);
        
        user = new JLabel("Username: ");
        user.setBounds(170, 140, 80, 30);
        add(user);
        
        password = new JLabel("Password: ");
        password.setBounds(170, 200, 80, 30);
        add(password);
        
        again = new JLabel("Confirm Password: ");
        again.setBounds(170, 260, 120, 30);
        add(again);
        
        text = new JTextArea();
        text.setBounds(240, 140, 150, 30);
        add(text);
        
        pass = new JPasswordField();
        pass.setBounds(240, 200, 150, 30);
        add(pass);
       
        another = new JPasswordField();
        another.setBounds(290, 260, 150, 30);
        add(another);
        
        create = new JButton("Create");
        create.setBounds(220, 310, 90, 30);
        add(create);
        
        back = new JButton("<-----");
        back.setBounds(20, 10, 80, 30);
        add(back);
        
        create.addActionListener(this);
        back.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == create){
            String user = text.getText().trim();
            String password = new String (pass.getPassword());
            String agains = new String(another.getPassword());
            
            if(user.isEmpty()){
                JOptionPane.showMessageDialog(this, "Please input username", "Info", JOptionPane.INFORMATION_MESSAGE);
            }else if(password.isEmpty()){    
                 JOptionPane.showMessageDialog(this, "Please input password", "Info", JOptionPane.INFORMATION_MESSAGE);
            }else if(!password.equals(agains)){
                 JOptionPane.showMessageDialog(this, "Please input correct password", "Error", JOptionPane.ERROR_MESSAGE);
            }else{
                try{
                    String hash = encryption.hash(password);
                    String sql = "INSERT INTO restaurant_accounts SET username = ?, password = ?";
                    try(Connection c = DBConnection.getConnection()){
                        PreparedStatement p = c.prepareStatement(sql);
                        
                        p.setString(1, user);
                        p.setString(2, hash);
                        
                        int Resultset = p.executeUpdate();
                        JOptionPane.showMessageDialog(this, "Account is Created", "Info", JOptionPane.INFORMATION_MESSAGE);
                        
                        Restaurant r = new Restaurant(customerid);
                        r.setVisible(true);
                        this.dispose();
                        
                    }catch(SQLException ex){
                        JOptionPane.showMessageDialog(this, "Password has an error" + ex, "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(this, "Database Error" + ex ,"Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        
        }
    }
}
