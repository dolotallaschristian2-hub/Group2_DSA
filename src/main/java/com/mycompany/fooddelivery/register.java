package com.mycompany.fooddelivery;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
        
        panel = new JPanel();
        panel.setBounds(120, 120, 360, 250);
        panel.setLayout(null);
        add(panel);

        //      LABELS
        
        username = new JLabel("Username:");
        username.setBounds(30, 30, 100, 40);
        panel.add(username);
        
        password = new JLabel("Password:");
        password.setBounds(30, 75, 100, 40);
        panel.add(password);
        
        again = new JLabel("Confirm Password:");
        again.setBounds(30, 120, 120, 40);
        panel.add(again);
       
        //      TEXT AND PASSWORD
        
        user = new JTextField();
        user.setBounds(140, 40, 170, 20);
        panel.add(user);
        
        pass = new JPasswordField();
        pass.setBounds(140, 85, 170, 20);
        panel.add(pass);
        
        confirm = new JPasswordField();
        confirm.setBounds(140, 130, 170, 20);
        panel.add(confirm);
        
        //      BUTTONS
        
        create = new JButton("Create Account");
        create.setBounds(100, 170, 160, 45);
        panel.add(create);
        
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
                return;
            } 
                String sql = "INSERT INTO logindb.users SET username = ?, password =  ?";
                try(Connection cn = DBConnection.getConnection()){
                   PreparedStatement st = cn.prepareStatement(sql);
                   
                   st.setString(1, username);
                   st.setString(2, word);
                   
                   int result = st.executeUpdate();
                   System.out.println("Rows Inserted " + result);
                    
                   JOptionPane.showMessageDialog(this, "Account is Created", "Account", JOptionPane.INFORMATION_MESSAGE);
                
                fooddeliveryGUI fooddelivery = new fooddeliveryGUI();
                fooddelivery.setVisible (true);
                this.dispose();
                
                
                }catch (SQLException ex){
                    JOptionPane.showMessageDialog(this, "Database Error" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
                }
                
            }
        }
    }

