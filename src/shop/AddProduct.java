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
public class AddProduct {
    
    
		Stage window;

	
	  
	  public void start(Stage primarystage,Scene scene2) {
	         window=primarystage;
	         window.setTitle("Customer"); 
	         
	         GridPane grid=new GridPane();
	         grid.setAlignment(Pos.CENTER);
	         grid.setVgap(20);
	         grid.setHgap(20);
	         grid.setPadding(new Insets(10));
	         
	         Text welcomeTxt=new Text(" Add Product");
	         welcomeTxt.setFont(Font.font("Tahoma", FontWeight.LIGHT, 25));
	         grid.add(welcomeTxt, 0, 0);
	         
	         Label lblCustomer=new Label("Product ID");
	         grid.add(lblCustomer, 0, 1);
	         /*
	         Label lblItem=new Label("Product Name");
	         grid.add(lblItem, 0, 2);
	         */
	         Label lblQuantity=new Label("Quantity");
	         grid.add(lblQuantity, 0, 2);
	         
	         Label lblprice=new Label("Unit Price");
	         grid.add(lblprice, 0, 3);
	         /*
	         Label lbltcost=new Label("Total Cost");
	         grid.add(lbltcost, 0, 5);
                 */
	         
	         TextField txtCustomer=new TextField();
	         txtCustomer.setPromptText("Product ID");
	         grid.add(txtCustomer, 1, 1);
	         
	         
	         TextField txtItem=new TextField();
	         txtItem.setPromptText("Quantity");
	         grid.add(txtItem, 1, 2); 
	        
	         TextField txtQuantity=new TextField();
	         txtQuantity.setPromptText("Price");
	         grid.add(txtQuantity, 1, 3); 
	         /*
	         TextField txtprice=new TextField();
	         txtprice.setPromptText("Unit Price");
	         grid.add(txtprice, 1, 4); 
	         
	         TextField txttcost=new TextField();
	         txttcost.setPromptText("Total Cost");
	         grid.add(txttcost, 1, 5); 
                 */
	         /*
	         Button okbtn=new Button("ADD");
	         grid.add(okbtn, 0, 3);
	         okbtn.setOnAction((ActionEvent arg0) -> {
                     txtCustomer.clear();
                     txtItem.clear();
                     txtQuantity.clear();
                     txtprice.clear();
                     txttcost.clear();
                 });
	         
	         
	         Button resetbtn=new Button("Reset");
	         grid.add(resetbtn, 1, 6);
	         resetbtn.setOnAction((ActionEvent arg0) -> {
                     txtCustomer.clear();
                     txtItem.clear();
                     txtQuantity.clear();
                     txtprice.clear();
                     txttcost.clear();
                 });
	         
                */
                Button okBtn = new Button("Add");
               grid.add(okBtn,1,4);
               okBtn.setOnAction((ActionEvent e) ->{
                        String productName = txtCustomer.getText();
                        int productNameI = Integer.parseInt(productName);
                        String quantity = txtItem.getText();
                        int quantityI = Integer.parseInt(quantity);
                        String price = txtQuantity.getText();
                        int priceI = Integer.parseInt(price);
                       // String price = txtQuantity.getText();
                       // int priceI = Integer.parseInt(price);
                      
                        Controller mycon = new Controller();
                     try {
                         mycon.addProduct(productNameI, quantityI ,priceI);
                     } catch (SQLException ex) {
                         Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
                     }
                        txtCustomer.clear();
                        txtItem.clear();
                        txtQuantity.clear();
                        
                        }); 
               
	         Button cancelbtn=new Button("Cancel");
	         grid.add(cancelbtn, 2, 4);
                 cancelbtn.setOnAction((ActionEvent e) ->{
                        txtCustomer.clear();
                        txtItem.clear();
                        txtQuantity.clear();
                        window.setScene(scene2);
                        
                        });
	         
	         
	         
	         Scene scene=new Scene(grid, 500,400);
	         window.setScene(scene);
	         window.show();
	         
	         
	          
	         
	         
	         
	          

	  }
    
}
