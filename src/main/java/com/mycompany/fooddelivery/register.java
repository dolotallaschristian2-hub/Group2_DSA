package com.mycompany.fooddelivery;
import javax.swing.*;

/**
 *
 * @author Christian Dolotallas
 */
public class register extends JFrame{
    private JLabel username, password, again;
    private JTextField user;
    private JPasswordField pass;
    
    public register(){
        setTitle("Register");
        setSize(400, 600);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        username = new JLabel("Username:");
        username.setBounds(100, 150, 100, 30);
        add(username);
        
        password = new JLabel("Password:");
        password.setBounds(100, 180, 100, 30);
        add(password);
    }
}
