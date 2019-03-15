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
import javafx.event.EventHandler;
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
public class Sell {
    
		Stage window;

	
	  
	  public void start(Stage primarystage,Scene scene2) {
	         window=primarystage;
	         window.setTitle("Customer"); 
	         
	         GridPane grid=new GridPane();
	         grid.setAlignment(Pos.CENTER);
	         grid.setVgap(20);
	         grid.setHgap(20);
	         grid.setPadding(new Insets(10));
	         
	         Text welcomeTxt=new Text(" Sell Product");
	         welcomeTxt.setFont(Font.font("Tahoma", FontWeight.LIGHT, 25));
	         grid.add(welcomeTxt, 0, 0);
	         
	         Label lblCustomer=new Label("Customer ID");
	         grid.add(lblCustomer, 0, 1);
	         
	         Label lblItem=new Label("Product ID");
	         grid.add(lblItem, 0, 2);
	         
	         Label lblQuantity=new Label("Quantity");
	         grid.add(lblQuantity, 0, 3);
	         
	         Label lblprice=new Label("Unit Price");
	         grid.add(lblprice, 0, 4);
	       /*  
	         Label lbltcost=new Label("Total Cost");
	         grid.add(lbltcost, 0, 5);
                 
	         */
	         
	         TextField txtCustomer=new TextField();
	         txtCustomer.setPromptText("Customer ID");
	         grid.add(txtCustomer, 1, 1);
	         
	         
	         TextField txtItem=new TextField();
	         txtItem.setPromptText("Product ID");
	         grid.add(txtItem, 1, 2); 
	        
	         TextField txtQuantity=new TextField();
	         txtQuantity.setPromptText("Quantity");
	         grid.add(txtQuantity, 1, 3); 
	        
	         TextField txtprice=new TextField();
	         txtprice.setPromptText("Unit Price");
	         grid.add(txtprice, 1, 4); 
	        /* 
	         TextField txttcost=new TextField();
	         txttcost.setPromptText("Total Cost");
	         grid.add(txttcost, 1, 5); 
                
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
                Button okBtn = new Button("Sell");
               grid.add(okBtn,0,5);
               okBtn.setOnAction((ActionEvent e) ->{
                    String custN = txtCustomer.getText();
                    int custNI = Integer.parseInt(custN);
                    String prodN = txtItem.getText();
                    int prodNI = Integer.parseInt(prodN);
                    String quant = txtQuantity.getText();
                    int quantI = Integer.parseInt(quant);
                    String price = txtprice.getText();
                    int priceI = Integer.parseInt(price);
                    Controller cntl = new Controller();
                     try {
                         cntl.sell(custNI, prodNI, quantI,priceI);
                     } catch (SQLException ex) {
                         Logger.getLogger(Sell.class.getName()).log(Level.SEVERE, null, ex);
                     }
                        txtCustomer.clear();
                        txtItem.clear();
                        txtQuantity.clear();
                        txtprice.clear();
                    });
               
	         Button cancelbtn=new Button("Cancel");
	         grid.add(cancelbtn, 3, 5   );
                 cancelbtn.setOnAction((ActionEvent e) ->{
                        txtCustomer.clear();
                        txtItem.clear();
                        txtQuantity.clear();
                        txtprice.clear();
                     window.setScene(scene2);
                        
                        });
	         
	         
	         
	         Scene scene=new Scene(grid, 500,400);
	         window.setScene(scene);
	         window.show();
	         
	         
	          
	         
	         
	         
	          

	  }

    
    
    
    
    
    
}
