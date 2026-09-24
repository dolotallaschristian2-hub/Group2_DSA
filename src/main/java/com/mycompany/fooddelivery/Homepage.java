package com.mycompany.fooddelivery;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

public class Homepage extends JFrame implements ActionListener{
    
    private DefaultListModel<String> listmodel;
    private LinkedList<String> linklist;
    private JList<String> list;
    private JLabel home;
    private JScrollPane scrollpane;
    private JTextField text;
    private JButton add, remove, clear;
    
    Homepage(){
        setSize(600, 600);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        linklist  = new LinkedList<>();
        listmodel = new DefaultListModel<>();
        list = new JList<>(listmodel);
        
        scrollpane = new JScrollPane(list);
        scrollpane.setBounds(20, 30, 300, 170);
        add(scrollpane);
        
        text = new JTextField();
        text.setBounds(20, 220, 170, 30);
        add(text);
        
        add = new JButton("Add");
        add.setBounds(220, 220, 80, 50);
        add(add);
        
        remove = new JButton("Remove");
        remove.setBounds(220, 280, 80, 50);
        add(remove);
        
        clear = new JButton("Clear");
        clear.setBounds(220, 320, 80, 50);
        add(clear);
        
        add.addActionListener(this);
        remove.addActionListener(this);
        clear.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == add){
            String listItem = text.getText();
            if(!listItem.isEmpty()){
                linklist.add(listItem);
                listmodel.addElement(listItem);
                text.setText("");
                
            }else{
                JOptionPane.showMessageDialog(this, "Plase Enter text", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        }else if(e.getSource() == remove){
                int indexSelected = list.getSelectedIndex();
                
                if(indexSelected != -1 ){
                    linklist.remove(indexSelected);
                    listmodel.remove(indexSelected);
                }else{
                    JOptionPane.showMessageDialog(this,"Please Select Item", "Eror", JOptionPane.ERROR_MESSAGE);
                }
        }else if(e.getSource() == clear){
            if(!listmodel.isEmpty()){
                listmodel.clear();
            }
            else{
                JOptionPane.showMessageDialog(this, "Empty", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
    }
    
}
