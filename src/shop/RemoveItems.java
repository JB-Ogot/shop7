/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop;

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
    
    public class RemoveItems {
                Stage window;

	
	  
	  public void start(Stage primarystage) {
	         window=primarystage;
	         window.setTitle("Customer"); 
	         
	         GridPane grid=new GridPane();
	         grid.setAlignment(Pos.CENTER);
	         grid.setVgap(20);
	         grid.setHgap(20);
	         grid.setPadding(new Insets(10));
	         
	         Text welcomeTxt=new Text("Remove Product");
	         welcomeTxt.setFont(Font.font("Tahoma", FontWeight.LIGHT, 25));
	         grid.add(welcomeTxt, 0, 0);
	         
	         Label lblCustomer=new Label("Product");
	         grid.add(lblCustomer, 0, 1);
	         
	         Label lblItem=new Label("Quantity");
	         grid.add(lblItem, 0, 2);
                 
	         TextField txtCustomer=new TextField();
	         txtCustomer.setPromptText("Product Name");
	         grid.add(txtCustomer, 1, 1);
	         
	         
	         TextField txtItem=new TextField();
	         txtItem.setPromptText("    Quantity");
	         grid.add(txtItem, 1, 2); 
    
                  Button okbtn=new Button("Remove");
	         grid.add(okbtn, 0, 3);
    
	         Button cancelbtn=new Button("Cancel");
	         grid.add(cancelbtn, 3, 3);
	         
	         
	         
	         Scene scene=new Scene(grid, 500,400);
	         window.setScene(scene);
	         window.show();
          } 
    
}
