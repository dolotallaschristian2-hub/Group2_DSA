package com.mycompany.fooddelivery;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class fooddeliveryGUI extends JFrame implements ActionListener {
    
    private JLabel lblheader, username, password, remind;
    private JButton btnlogin, btnregister;
    private JTextArea txauser;
    private JPasswordField jpfpass;
    private JScrollPane error;
    final String user = "admin";
    final String pass = "123456";
    
    fooddeliveryGUI(){
        setSize(600, 700);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        
        //Setting of a Label Login Page
        lblheader = new JLabel ("Online Food Delivery System",SwingConstants.CENTER);
        lblheader.setBounds(190, 25, 175, 200);
        add(lblheader);
        
        
        username = new JLabel ("Username: ");
        username.setBounds(180, 120, 90, 130);
        add(username);
        
        
        password = new JLabel ("Password: ");
        password.setBounds(180, 160, 90, 130);
        add(password);
        
        remind = new JLabel ("Do You Have Account?");
        remind.setBounds(215, 330, 140, 130);
        add(remind);
        
        
        txauser = new JTextArea();
        txauser.setBounds(250, 175, 130, 20);
        add(txauser);
        
        jpfpass = new JPasswordField();
        jpfpass.setBounds(250, 215, 130, 20);
        add(jpfpass);
        
        //Setting of Buttons
        btnlogin = new JButton("Login");
        btnlogin.setBounds(230, 250, 100, 40);
        add(btnlogin);
        
        btnregister = new JButton("Register");
        btnregister.setBounds(230, 420, 100, 40);
        add(btnregister);
        
       btnlogin.addActionListener(this);
       btnregister.addActionListener(this);        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == btnlogin){
           String password = new String(jpfpass.getPassword());
           String username = new String (txauser.getText());
           
           if(username.isEmpty()){
               JOptionPane.showMessageDialog(this, "Please Enter the Username", "Error", JOptionPane.ERROR_MESSAGE);
           }
           else if(password.isEmpty()){
               JOptionPane.showMessageDialog(this, "Please Check the Password", "Error", JOptionPane.ERROR_MESSAGE);
           }
           else if(password.equals(pass) && username.equals(user)){
           JOptionPane.showMessageDialog(this, "Login Successful", "Login", JOptionPane.INFORMATION_MESSAGE);
           Homepage hm = new Homepage();
           hm.setVisible(true);
           this.dispose();
           } else {
               JOptionPane.showMessageDialog(this, "Login Denied", "Error", JOptionPane.ERROR_MESSAGE);
           }
       }
       else if(e.getSource() == btnregister){
           register reg = new register();
           reg.setVisible(true);
           this.dispose();
       }
    }
}
