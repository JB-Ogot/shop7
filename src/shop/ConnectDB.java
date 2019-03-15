/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop;

import java.sql.DriverManager;
import java.sql.*;

/**
 *
 * @author h3mitt
 */
public class ConnectDB {
    public static final String USERNAME = "root";
    public static final String PASSWORD = "    ";
    public static final String CONN = "jdbc:mysql://localhost/shop7";
  
    /**
     *
     * @return 
     * @throws SQLException
     */
    public  static Connection getConnection() throws SQLException{
                            Connection con = null;
                           try{
                           con = DriverManager.getConnection(CONN, USERNAME, PASSWORD);
                           System.out.println("Connected");
                           
                           }catch(SQLException e){
                                System.out.println("Not Connected");
                           }
                                 
                             return con;
    }
}