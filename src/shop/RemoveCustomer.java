/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author h3mitt
 */
public class RemoveCustomer {
                Stage window;

	
	  
	  public void start(Stage primarystage,Scene scene2) {
	         window=primarystage;
	         window.setTitle("Customer"); 
	         
	         GridPane grid=new GridPane();
	         grid.setAlignment(Pos.CENTER);
	         grid.setVgap(20);
	         grid.setHgap(20);
	         grid.setPadding(new Insets(10));
	         
	         Text welcomeTxt=new Text("Customer");
	         welcomeTxt.setFont(Font.font("Tahoma", FontWeight.LIGHT, 25));
	         grid.add(welcomeTxt, 0, 0);
	         
	         Label lblCustomer=new Label("Customer_ID");
	         grid.add(lblCustomer, 0, 1);
	         
	         Label lblItem=new Label("Name");
	         grid.add(lblItem, 0, 2);
                 
	         TextField txtCustomer=new TextField();
	         txtCustomer.setPromptText("customer_ID");
	         grid.add(txtCustomer, 1, 1);
	         
	         
	         TextField txtItem=new TextField();
	         txtItem.setPromptText("Name");
	         grid.add(txtItem, 1, 2); 
    
                  Button okbtn=new Button("Delete");
	         grid.add(okbtn, 0, 3);
                 
                okbtn.setOnAction((ActionEvent e) ->{
                        String custID = txtCustomer.getText() ;
                        int custIDI = Integer.parseInt(custID);         
                        String name = txtItem.getText();
                        
                        
                      
                        Controller mycon = new Controller();
                     try {
                         mycon.removeCustomer(custIDI, name);
                     } catch (SQLException ex) {
                         Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
                     }
                        txtCustomer.clear();
                        txtItem.clear();
                        
                        
                        
                        });
                        
    
	         Button cancelbtn=new Button("Cancel");
	         grid.add(cancelbtn, 3, 3);
                 cancelbtn.setOnAction((ActionEvent e) ->{
                        txtCustomer.clear();
                        txtItem.clear();
                           
                     window.setScene(scene2);
                        
                        });
	         
	         
	         
	         Scene scene=new Scene(grid, 500,400);
	         window.setScene(scene);
	         window.show();
	         
    
}
}