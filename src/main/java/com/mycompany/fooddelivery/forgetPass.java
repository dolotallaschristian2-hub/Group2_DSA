package com.mycompany.fooddelivery;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import org.mindrot.jbcrypt.BCrypt;

public class forgetPass extends JFrame implements ActionListener {
    
    private JLabel label, usir, paswurd;
    private JTextField user;
    private JPasswordField pass;
    private JButton upd;
    private JPanel panel;
    
    forgetPass(){
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setTitle("Forget Password");
        setLocationRelativeTo(null);
        setResizable(false);
        
        panel = new JPanel();
        panel.setBounds(50, 50, 400, 400);
        panel.setLayout(null);
        add(panel);
        
        label = new JLabel("Forget Password", SwingConstants.CENTER);
        label.setBounds(140, 40, 140, 50);
        panel.add(label);
        
        usir = new JLabel("Username:");
        usir.setBounds(100, 80, 70, 50);
        panel.add(usir);

        paswurd = new JLabel("Change Password:");
        paswurd.setBounds(100, 110, 120, 50);
        panel.add(paswurd);
        
        user = new JTextField();
        user.setBounds(170, 95, 120, 20);
        panel.add(user);
        
        pass = new JPasswordField();
        pass.setBounds(210, 125, 120, 20);
        panel.add(pass);
        
        upd = new JButton("Update");
        upd.setBounds(140, 170, 140, 40);
        panel.add(upd);
        
        upd.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == upd){
            String us = user.getText().trim();
            String word = new String (pass.getPassword());
            
            if(us.isEmpty()){
                JOptionPane.showMessageDialog(this, "Please Enter your Username", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if(word.isEmpty()){
               JOptionPane.showMessageDialog(this, "Please Enter your Password", "Error", JOptionPane.ERROR_MESSAGE);
               return;
           }
            try{
                Connection cv = DBConnection.getConnection();
                String check = "SELECT username FROM users WHERE username = ?";
                
                PreparedStatement search = cv.prepareStatement(check);
                search.setString(1, us);
                
                ResultSet outcome = search.executeQuery();
                
                if(outcome.next()){
                    String hash = BCrypt.hashpw(word, BCrypt.gensalt(12));
                    
                String update = "UPDATE users SET password = ? WHERE username = ?";
                
                PreparedStatement upd = cv.prepareStatement(update);
                
                upd.setString(1, hash);
                upd.setString(2, us);
                
                int rows = upd.executeUpdate();
                
                if( rows > 0){
                    JOptionPane.showMessageDialog(this, "Password Succefully Change", "Successful", JOptionPane.INFORMATION_MESSAGE);
                
                    upd.close();
                    outcome.close();
                    cv.close();
                    search.close();
                    
                    fooddeliveryGUI fd = new fooddeliveryGUI();
                    fd.setVisible(true);
                    this.dispose();
                }
                }
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(this, "Database has an error" + ex, "Error", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
            
        }
    }
    
}
