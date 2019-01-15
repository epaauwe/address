package getconenction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;


public class GetConenction {
    

    
  
    public static void main(String[] args) {
       //scanner for input
        Scanner in = new Scanner(System.in);
        //get window
        Window window = new Window();
        
    
        try{
        //load JDBC driver 
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
        //connection
        Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=AddressBook;user=evin;password=evin;");
        // System.out.println("\nconnected!\n");
        //prompt
        System.out.println("What state are you looking for cities in?:\n");
        String state = in.nextLine();
       
        Statement stmt = con.createStatement();
        String SQL = "SELECT * FROM AddressBook.dbo.city WHERE stateID = '"+state+"'";
        ResultSet rs = stmt.executeQuery(SQL);
        displayRow("CITY", rs);
        }
        catch(ClassNotFoundException sqle){
        System.out.println("Class Not Found: "+sqle.getMessage());//.getMessage() returns exception description
        }
        catch(SQLException e){
            System.out.println("SQL Exception: "+e.getMessage());
        }
    }
    
    private static void displayRow(String title, ResultSet rs) throws SQLException{
        System.out.println(title);
        while(rs.next()){
            System.out.println(rs.getString("cityName")+":"+rs.getString("stateID"));
        }
    }
 }
    
    

