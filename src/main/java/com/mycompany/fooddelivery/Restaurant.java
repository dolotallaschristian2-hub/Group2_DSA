package com.mycompany.fooddelivery;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;


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
        panel.setBounds(50, 50, 450, 300);
        add(panel);
        
        label = new JLabel("Restaurant Account",SwingConstants.CENTER);
        label.setBounds(170, 30, 150, 30);
        panel.add(label);
        
        user = new JLabel("Username: ");
        user.setBounds(120, 90, 70, 30);
        panel.add(user);
        
        pass = new JLabel("Password: ");
        pass.setBounds(120, 150, 70, 30);
        panel.add(pass);
        
        text = new JTextField();
        text.setBounds(210, 90, 150, 30);
        panel.add(text);

        password = new JPasswordField();
        password.setBounds(210, 150, 150, 30);
        panel.add(password);
        
        login = new JButton("Log In");
        login.setBounds(190, 200, 100, 30);
        panel.add(login);
        
        create = new JButton("Create Account");
        create.setBounds(170, 250, 140, 30);
        panel.add(create);
        
        back = new JButton("<-----");
        back.setBounds(20, 10, 80, 30);
        add(back);
        
        login.addActionListener(this);
        back.addActionListener(this);
        create.addActionListener(this);
        
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == login){
            String user = text.getText().trim();
            String pass = new String (password.getPassword());
                if(user.isEmpty()){
                    JOptionPane.showMessageDialog(this, "Please Enter the Restaurant Account", "Error", JOptionPane.ERROR_MESSAGE);
                }else if(pass.isEmpty()){
                    JOptionPane.showMessageDialog(this, "Please Input the Password", "Error", JOptionPane.ERROR_MESSAGE);
                }else {
                    String sql = "SELECT * FROM restaurant_accounts WHERE BINARY username = ?";
                    try{
                        Connection c = DBConnection.getConnection();
                        PreparedStatement pst = c.prepareStatement(sql);
                        
                        pst.setString(1, user);
                        
                        ResultSet r = pst.executeQuery();
                        
                            if(r.next()){
                                String hash = r.getString("password");
                                
                                if(hash != null && !hash.isEmpty()){
                                        try{
                                            if(encryption.Password(pass, hash)){
                                                JOptionPane.showMessageDialog(this, "Login Sucessfully", "Login", JOptionPane.INFORMATION_MESSAGE);
                                                RestaurantHome h = new RestaurantHome();
                                                h.setVisible(true);
                                                this.dispose();
                                            }else{
                                                JOptionPane.showMessageDialog(this, "Access Denied", "Error", JOptionPane.ERROR_MESSAGE);
                                            }
                                        }catch(Exception ex){
                                            JOptionPane.showMessageDialog(this, "Password Verification Error" + ex, "Error", JOptionPane.ERROR_MESSAGE);
                                        }
                                }else{
                                    JOptionPane.showMessageDialog(this, "Invalid Username or Password", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            }else{
                                JOptionPane.showMessageDialog(this, "Invalid User or Password", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        
                        r.close();
                        pst.close();
                        c.close();
                        
                        
                    }catch(SQLException ex){
                        JOptionPane.showMessageDialog(this, "Database Error" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        
        else if(e.getSource() == back){
            int confirm = JOptionPane.showConfirmDialog(this, "Back?", "Info", JOptionPane.YES_NO_OPTION);
            if(confirm == JOptionPane.YES_OPTION ){
                Choices g = new Choices();
                g.setVisible(true);
                this.dispose();
            }
        }else if(e.getSource() == create){
            restaurant_register r = new restaurant_register();
            r.setVisible(true);
            this.dispose();
        }
    
    }
}
