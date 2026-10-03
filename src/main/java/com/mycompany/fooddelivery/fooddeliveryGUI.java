package com.mycompany.fooddelivery;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import org.mindrot.jbcrypt.BCrypt;

public class fooddeliveryGUI extends JFrame implements ActionListener {
    
    private JLabel lblheader, username, password, remind;
    private JButton btnlogin, btnregister;
    private JTextArea txauser;
    private JPasswordField jpfpass;
    private JScrollPane error;
    private JPanel panel;
    
    
    fooddeliveryGUI(){
        setSize(600, 700);
        setTitle("Food Delivery");
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
       
        panel = new JPanel();
        panel.setBounds(30, 100, 520, 500);
        panel.setBackground(Color.gray);
        panel.setLayout(null);
        add(panel);
        
        //Setting of a Label Login Page
        lblheader = new JLabel ("Online Food Delivery System",SwingConstants.CENTER);
        lblheader.setBounds(190, 25, 175, 50);
        panel.add(lblheader);
        
        
        //Labels
        username = new JLabel ("Username: ");
        username.setBounds(180, 120, 90, 30);
        panel.add(username);
        
        
        password = new JLabel ("Password: ");
        password.setBounds(180, 160, 90, 30);
        panel.add(password);
        
        remind = new JLabel ("Do You Have Account?");
        remind.setBounds(215, 330, 140, 30);
        panel.add(remind);
        
        //Text and Password
        txauser = new JTextArea();
        txauser.setBounds(250, 125, 130, 20);
        panel.add(txauser);
        
        jpfpass = new JPasswordField();
        jpfpass.setBounds(250, 165, 130, 20);
        panel.add(jpfpass);
        
        //Setting of Buttons
        btnlogin = new JButton("Login");
        btnlogin.setBounds(230, 250, 100, 40);
        btnlogin.setBackground(new Color(70, 160, 90));
        panel.add(btnlogin);
        
        btnregister = new JButton("Register");
        btnregister.setBounds(230, 380, 100, 40);
        btnregister.setBackground(new Color(150, 70, 80));
        panel.add(btnregister);
        
        
        
        
       btnlogin.addActionListener(this);
       btnregister.addActionListener(this);        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == btnlogin){
         
           String username = txauser.getText().trim();
           String password = new String (jpfpass.getPassword());
       
           
           if(username.isEmpty()){
               JOptionPane.showMessageDialog(this, "Please Enter the Username", "Error", JOptionPane.ERROR_MESSAGE);
           }
           else if(password.isEmpty()){
               JOptionPane.showMessageDialog(this, "Please Check the Password", "Error", JOptionPane.ERROR_MESSAGE);
           }
           else{ 
               String sql = "SELECT * FROM users WHERE username = ?";
               try{
                   Connection con = DBConnection.getConnection();
                   
                   PreparedStatement pet = con.prepareStatement(sql);
                   
                   pet.setString(1, username);
                   ResultSet res = pet.executeQuery();
                   
                   if(res.next()){
                       String hash = res.getString("password");
                       
                       if(hash != null && (hash.startsWith("$2a$")|| hash.startsWith("$2b$")|| hash.startsWith("$2y$"))){
                           if (BCrypt.checkpw(password, hash)){
                           JOptionPane.showMessageDialog(this, "Login Successful", "Login", JOptionPane.INFORMATION_MESSAGE);
                           }  
                           Homepage home = new Homepage();
                           home.setVisible(true);
                           this.dispose();
                       }else{
                           JOptionPane.showMessageDialog(this, "Invalid Username or Password", "Error", JOptionPane.ERROR_MESSAGE);
                       }    
                        
                   }
                   else{
                     JOptionPane.showMessageDialog(this, "Invalid Username or Password", "Error", JOptionPane.ERROR_MESSAGE);
                   }
                   
                   res.close();
                   pet.close();
                   con.close();
                       
               }catch(SQLException ex){
                 JOptionPane.showMessageDialog(this, "Database Error: " + ex.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
                 
                 ex.printStackTrace();
           }   
        }
    }
       else if(e.getSource() == btnregister){
           register reg = new register();
           reg.setVisible(true);
           this.dispose();
       }
    }
}
