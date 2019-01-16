/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package getconenction;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
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
public class Window extends JFrame {

    public JTextArea searchDB(String fName, String lname, JTextArea txtArea) {

        ResultSet rs = null;
        try {
            //load JDBC driver 
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //connection
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=Address;user=evin;password=evin;");
            System.out.println("connected!");
            Statement stmt = con.createStatement();
            String SQL = "Select * FROM AddressBook.dbo.city WHERE stateID = '" + fName + "'";
            rs = stmt.executeQuery(SQL);
            if (rs.next()) {
                while (rs.next()) {
                    txtArea.append(rs.getString("cityName") + ":" + rs.getString("stateID")+"\n");
                }
            } else {
                txtArea.setText("No rows returned");
            }

            return txtArea;

        } catch (ClassNotFoundException sqle) {
            System.out.println("Class Not Found: " + sqle.getMessage());//.getMessage() returns exception description
        } catch (SQLException sqe) {
            System.out.println("SQL Exception: " + sqe.getMessage());
        }
        return txtArea;
    }

    public Window() {
        BorderLayout bl = new BorderLayout();
        //Config
        this.setTitle("Address");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        //ADD RS PANEL
        JPanel pnlRS = new JPanel();
        JTextArea txtArea = new JTextArea(20, 20);
        //Add TextArea    
        pnlRS.add(txtArea);
        //test
        pnlRS.setBackground(Color.blue);

        //ADD INPUT PANEL
        JPanel pnlInput = new JPanel();
        //Text Fields
        JTextField txtFName = new JTextField(20);
        JTextField txtLName = new JTextField(20);
        //Labels
        JLabel lblFName = new JLabel("First Name");
        JLabel lblLName = new JLabel("Last Name");
        //Button
        JButton btnSearch = new JButton("Search");

        //code action for button
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchDB(txtFName.getText(), txtLName.getText(),txtArea);
            }

        });

        //add components
        pnlInput.add(txtFName, bl.CENTER);
        pnlInput.add(lblFName, bl.WEST);
        pnlInput.add(txtLName, bl.CENTER);
        pnlInput.add(lblLName, bl.WEST);
        pnlInput.add(btnSearch, bl.SOUTH);
        //test
        pnlInput.setBackground(Color.red);

        //ADD PANELS
        this.add(pnlInput, bl.NORTH);
        this.add(pnlRS, bl.CENTER);
        //Set Frame Visible
        this.setVisible(true);
    }

}
