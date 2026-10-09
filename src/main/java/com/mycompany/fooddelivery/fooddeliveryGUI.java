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
    
    private JLabel lblheader, username, password, remind;
    private JButton btnlogin, btnregister, back, fpass;
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
        panel.setBounds(30, 80, 520, 500);
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
        btnregister.setBounds(230, 360, 100, 40);
        btnregister.setBackground(new Color(150, 70, 80));
        panel.add(btnregister);
        
        fpass = new JButton("Forget Password");
        fpass.setBounds(200, 420, 140, 30);
        panel.add(fpass);
        
        back = new JButton("<-----");
        back.setBounds(20, 10, 80, 40);
        add(back);
        
        
        
       btnlogin.addActionListener(this);
       btnregister.addActionListener(this); 
       back.addActionListener(this);
       fpass.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == btnlogin){
//         Actions for the user if they login with the account they created
           String username = txauser.getText().trim();
           String password = new String (jpfpass.getPassword());
       
           
           if(username.isEmpty()){
//               This error would show if the user did not enter there username
               JOptionPane.showMessageDialog(this, "Please Enter the Username", "Error", JOptionPane.ERROR_MESSAGE);
           }
           else if(password.isEmpty()){
//               This error would show if the user did not enter the password after they enter the username
               JOptionPane.showMessageDialog(this, "Please Check the Password", "Error", JOptionPane.ERROR_MESSAGE);
           }
           else{ 
//               This would show if the user enter both username and password
               String sql = "SELECT * FROM users WHERE BINARY username = ?";
//             Username case sensitive query to the database
               try{
                   Connection con = DBConnection.getConnection();
                   
                   PreparedStatement pet = con.prepareStatement(sql);
                   
                   pet.setString(1, username);
                   ResultSet res = pet.executeQuery();
                   
//                   Hashing the personal password of the user 
                   if(res.next()){
                       String hash = res.getString("password");
                       
                       if(hash != null){
                           
                          try{ 
//                              If both username and password correct
                           if (encryption.Password(password, hash)){
                           JOptionPane.showMessageDialog(this, "Login Successful", "Login", JOptionPane.INFORMATION_MESSAGE);
                           
                           Homepage home = new Homepage();
                           home.setVisible(true);
                           this.dispose();
                           }
//                           Error handling
                           else{
                               JOptionPane.showMessageDialog(this, "Invalid Username or Password", "Error", JOptionPane.ERROR_MESSAGE);
                           }
//                           Encryption Error Handling 
                        }catch(Exception ex){
                             JOptionPane.showMessageDialog(this, "Password verification error: " + ex.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
                             
                        }  
                   }
//                       If neither the username and password incorrect
                   else{
                     JOptionPane.showMessageDialog(this, "Invalid Username or Password", "Error", JOptionPane.ERROR_MESSAGE);
                   }
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
//           Goes to the register class
           register reg = new register();
           reg.setVisible(true);
           this.dispose();
       }
       else if (e.getSource() == back){
//           Goes to the choices class
            Choices cs = new Choices();
            cs.setVisible(true);
            this.dispose();
        }
       else if (e.getSource() == fpass){
//           Goes to the forgetPass class
            forgetPass fp = new forgetPass();
            fp.setVisible(true);
            this.dispose();
       }
    }
}
