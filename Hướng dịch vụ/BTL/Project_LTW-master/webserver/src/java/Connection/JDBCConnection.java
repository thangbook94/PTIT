/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SA Nice
 */
public class JDBCConnection {
    
    public static Connection getConnection(){
        final String url = "jdbc:sqlserver://localhost:1433; databaseName=GlaZerr";
        final String username = "sa";
        final String password = "1";
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static void main(String[] args) {
        Connection con = getConnection();
        if(con != null){
            System.out.println("Connection Success");
        }
        else{
            System.out.println("Connection False");
        }
    }
}
