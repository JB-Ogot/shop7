/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author h3mitt
 */
public class Controller {
   

    /**
     *
     */
   // public  Connection con;
    //public Statement statement;
    
    
    
    /**
     *  
     * @param userName
     * @param passWord
     * @param window
     * @param scene2
     * @throws java.sql.SQLException
     */
    //public String[] authenticate(String userTextField,String pwBox) throws SQLException{
  

    public void authenticate(String userName,String passWord,Stage window,Scene scene2) throws SQLException{
             
            //connecting to DB
           
           // String usN = null;
            //String psD = null;
            
            try{
            //Statement statemnt = conn.createStatement();
                  
          
            String sql = "SELECT * FROM Shopkeeper WHERE Username = ? AND Password = ?";
           ResultSet rs;
           PreparedStatement rest = ConnectDB.getConnection().prepareStatement(sql);
           rest.setString(1, userName);
           rest.setString(2, passWord);
           rs = rest.executeQuery();
            if(rs.next()){
               // usN = rs.getString("Username");
               // psD = rs.getString("Password");
                window.setScene(scene2);
            }else{
                JOptionPane.showMessageDialog(null, "Wrong Username or Password");//showInputDialog("Wrong Username or Password");    
                }
             
        
            }catch(SQLException e){
                System.out.println("Not fetching");
                
            }
           // System.out.println(userName);
            //System.out.println(passWord);
        //String[] xs = new String []{usN,psD};
            
            //return new String []{userName,passWord};
        //return xs;
      
    }

    /**
     *
     * @param custID
     * @param name
     * @param address
     * @throws SQLException
     */
    public void addCustomer(int custID,String name,String address) throws SQLException{
                     //String query = "INSERT INTO Customers VALUES (null,'"+custID+"','"+name+"','"+address+"','"+credBal+"')";
                      String query = "INSERT INTO Customers (CustomerID,Name,Address) VALUES(?,?,?)";
                       try{
                            ConnectDB mycnt = new ConnectDB();
                            Connection con = mycnt.getConnection();
                            PreparedStatement stmnt = con.prepareStatement(query);
                          //  ResultSet rest1 = statemnt.executeQuery(query);
                          
                          stmnt.setInt(1, custID);
                          stmnt.setString(2, name);
                          stmnt.setString(3, address);
                        //  stmnt.setInt(4, credBal);
                          stmnt.executeUpdate();
                             }catch(SQLException e){
                                                    System.out.println("Not Inserting");
                                                    }   
     }
    
    
    
    public void addProduct(int product,int quantity,int price) throws SQLException{
        if(quantity > 0){
            String query ="UPDATE shopItems SET Quantity = Quantity + "+quantity+"  WHERE ID = "+product+" "; 
                ConnectDB cdb = new ConnectDB();
                Connection con = cdb.getConnection();
                
               // PreparedStatement pst = con.prepareStatement(query);
                //pst.setString(1, product);
                //pst.setInt(2, quantity);
                //pst.executeQuery();
                Statement stmnt = con.createStatement();
                stmnt.executeUpdate(query);
            String query2 = "UPDATE shopItems SET Totals = Quantity * Price WHERE ID = "+product+"";
                Statement rs = con.createStatement();
                rs.executeUpdate(query2);
        }else{
                JOptionPane.showMessageDialog(null, "Enter a valid quantity");
                }
    }
    
       
    public void sell(int custN,int prodN,int quant,int price) throws SQLException{
        if (quant > 0){
        
        
            String query1 ="SELECT * FROM Customers where CustomerID = ?";
            
            ConnectDB cdb1 = new ConnectDB();
            Connection con = cdb1.getConnection();
               
            PreparedStatement ps = con.prepareStatement(query1);
            ps.setInt(1, custN);
            ResultSet rst = ps.executeQuery();
            
            
            if(rst.next()){
                    String query2 = "UPDATE shopItems SET Quantity = Quantity - "+quant+"  WHERE ID = " + prodN+" ";
                   String query3 = "SELECT * FROM shopItems where Price = "+price+"";
                    Statement stm1 = con.createStatement();
                    Statement stml1 = con.createStatement();
                    ResultSet rs;
                    stm1.executeUpdate(query2);
                    rs = stml1.executeQuery(query3);
                       				rs.next();
                                    int priceI = rs.getInt(3);
                                     String query4 = "INSERT INTO Sales (Price,QuantitySold,ProductID,Totals) VALUES(?,?,?,?)";
                                     PreparedStatement pa = con.prepareStatement(query4);
                                   
                                     pa.setInt(1,priceI);
                                     pa.setInt(2,quant);
                                     pa.setInt(3,prodN);
                                     pa.setInt(4,price * quant);
                                     pa.execute();
                                     
                                            String query5 = "UPDATE shopItems SET Totals = Quantity * Price WHERE ID = "+prodN+"";
                                            Statement st = con.createStatement();
                                            st.executeUpdate(query5);
                    
                    
            
            
                }else{
                    System.out.println("Gotcha");
                    }
        }else{
                JOptionPane.showMessageDialog(null, "Enter a valid quantity");
                }
    
            }
    public void removeCustomer(int custID, String name) throws SQLException{
        String query = "Delete from Customers WHERE CustomerID = ?";
    
         ConnectDB cdb1 = new ConnectDB();
            Connection con = cdb1.getConnection();
            PreparedStatement psnt = con.prepareStatement(query);
            psnt.setInt(1, custID);
            psnt.executeUpdate();
    }    
            
          
            public int totStock() throws SQLException{
                int tots;
                String totS;
                String query = "SELECT SUM(Totals) FROM shopItems";
                 ConnectDB cdb = new ConnectDB();
                 Connection con = cdb.getConnection();
                 Statement rs = con.createStatement();
                 
                 ResultSet rst = rs.executeQuery(query);
                 rst.next();
                 totS = rst.getString(1);
                 tots = Integer.parseInt(totS);
                //System.out.print(tot
                return tots;
                 
                    }
            public int getTots() throws SQLException{
                    ConnectDB cg = new ConnectDB();
                    Connection con = cg.getConnection();
                    
                    String query = "SELECT SUM(Totals) FROM Sales";
                    Statement rt = con.createStatement();
                    
                    ResultSet rst = rt.executeQuery(query);
                    rst.next();
                    String sales = rst.getString(1);
                    int salesI = Integer.parseInt(sales);
                    return salesI; 
            
            
                        }
                
                
                    }
    
  
    
    
    
 

