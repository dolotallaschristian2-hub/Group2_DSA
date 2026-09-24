package com.mycompany.fooddelivery;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class register extends JFrame implements ActionListener{
    private JLabel username, password, again;
    private JTextField user;
    private JPasswordField pass, confirm;
    private JButton create;
    private JPanel panel;
            
    
    
    public register(){
        setTitle("Registration");
        setSize(600, 600);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        username = new JLabel("Username:");
        username.setBounds(155, 150, 100, 40);
        add(username);
        
        password = new JLabel("Password:");
        password.setBounds(155, 180, 100, 40);
        add(password);
        
        again = new JLabel("Confirm Password:");
        again.setBounds(155, 210, 150, 40);
        add(again);
        
        user = new JTextField();
        user.setBounds(225, 160, 150, 20);
        add(user);
        
        pass = new JPasswordField();
        pass.setBounds(225, 190, 150, 20);
        add(pass);
        
        confirm = new JPasswordField();
        confirm.setBounds(270, 220, 150, 20);
        add(confirm);
        
        
        create = new JButton("Create Account");
        create.setBounds(230, 250, 150, 45);
        add(create);
        
        panel = new JPanel();
        panel.setBounds(130, 140, 320, 210);
        panel.setBackground(Color.red);
        add(panel);
        
        
       create.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == create){
            String username = new String (user.getText());
            String word = new String (pass.getPassword());
            String agains = new String (confirm.getPassword());
            
            if (username.isEmpty()){
                JOptionPane.showMessageDialog(this, "Please Enter Username", "Error", JOptionPane.ERROR_MESSAGE);      
            }else if(word.isEmpty()){
                JOptionPane.showMessageDialog(this, "Plase enter password", "Error", JOptionPane.ERROR_MESSAGE);
            }else if (!word.equals(agains)){
                JOptionPane.showMessageDialog(this, "Plase check your password", "Error", JOptionPane.ERROR_MESSAGE);
            }else {
                JOptionPane.showMessageDialog(this, "Account is Created", "Account", JOptionPane.INFORMATION_MESSAGE);
                fooddeliveryGUI fooddelivery = new fooddeliveryGUI();
                fooddelivery.setVisible (true);
                this.dispose();
                
            }
        }
    }
}
