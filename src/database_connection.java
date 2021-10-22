/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sadman
 */
 import java.sql.*;  
 import javax.swing.*;
public class database_connection {
    Connection con=null;
    Statement state=null; 
    
    public database_connection(){
        try{
          //Class.forName("com.mysql.jdbc.Driver");
         con=DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz","root","");//create connection
         state=con.createStatement();//responsible to execute queries with the database
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
            e.printStackTrace();
        }
    }
}
