/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package getconenction;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Evin
 */
public class Window extends JFrame{
    
    public Window(){
    BorderLayout bl = new BorderLayout();
    //Config
    this.setTitle("Address");
    this.setSize(800,600);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    
    //Add Panels
    this.add(getRSPanel(), bl.CENTER);
    this.add(getInputPanel(), bl.NORTH);
    
    //Set Frame Visible
    this.setVisible(true);
    }
    
    public JPanel getRSPanel(){
        JPanel panel = new JPanel();
        JTextArea txtArea = new JTextArea(20,20);
        
        panel.add(txtArea);
        //test
         panel.setBackground(Color.blue);
        return panel;
    }
    public JPanel getInputPanel(){
    //Layout
    BorderLayout bl = new BorderLayout();
    JPanel panel = new JPanel();
    //Text Fields
    JTextField txtFName = new JTextField(20);
    JTextField txtLName = new JTextField(20);
    //Labels
    JLabel lblFName = new JLabel("First Name");
    JLabel lblLName = new JLabel("Last Name");
    //add components
    panel.add(txtFName, bl.CENTER);
    panel.add(lblFName, bl.WEST);
    panel.add(txtLName, bl.CENTER);   
    panel.add(lblLName, bl.WEST);
    //test
     panel.setBackground(Color.red);
    return panel;
    }
}
