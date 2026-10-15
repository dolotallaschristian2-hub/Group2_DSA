package com.mycompany.fooddelivery;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class Restaurant extends JFrame implements ActionListener {
    
    private JLabel label, user, pass;
    private JButton login, create, back;
    private JTextField text;
    private JPasswordField password;
    private JPanel panel;
    
    
    Restaurant(){
        setSize(600, 600);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(50, 50, 450, 250);
        add(panel);
        
        label = new JLabel("Restaurant Account",SwingConstants.CENTER);
        label.setBounds(170, 30, 150, 30);
        panel.add(label);
        
        user = new JLabel("Username");
        user.setBounds(120, 90, 70, 30);
        panel.add(user);
        
        pass = new JLabel("Password");
        pass.setBounds(120, 150, 70, 30);
        panel.add(pass);
        
        text = new JTextField();
        text.setBounds(210, 90, 150, 30);
        panel.add(text);

        password = new JPasswordField();
        password.setBounds(210, 150, 150, 30);
        panel.add(password);
        
        login = new JButton("Log In");
        login.setBounds(170, 200, 100, 30);
        panel.add(login);
        
        back = new JButton("<-----");
        back.setBounds(20, 10, 80, 30);
        add(back);
        
        login.addActionListener(this);
        back.addActionListener(this);
        
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == login){
            
        }else if(e.getSource() == back){
            int confirm = JOptionPane.showConfirmDialog(this, "Back?", "Info", JOptionPane.YES_NO_OPTION);
            if(confirm == JOptionPane.YES_OPTION ){
                Choices g = new Choices();
                g.setVisible(true);
                this.dispose();
            }
        }
    
    }
}
