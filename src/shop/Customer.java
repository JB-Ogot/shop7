package shop;


import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Customer {
		
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
	         
	         Label lblQuantity=new Label("Address");
	         grid.add(lblQuantity, 0, 3);
	        /* 
	         Label lblprice=new Label("Credit Balance");
	         grid.add(lblprice, 0, 4);
	         /*
	         Label lbltcost=new Label("Total Cost");
	         grid.add(lbltcost, 0, 5);
                 */
	         
	         
	         TextField txtCustomer=new TextField();
	         txtCustomer.setPromptText("customer_ID");
	         grid.add(txtCustomer, 1, 1);
	         
	         
	         TextField txtItem=new TextField();
	         txtItem.setPromptText("Name");
	         grid.add(txtItem, 1, 2); 
	       
	         TextField txtQuantity=new TextField();
	         txtQuantity.setPromptText("Address");
	         grid.add(txtQuantity, 1, 3); 
	         /*
	         TextField txtprice=new TextField();
	         txtprice.setPromptText("Credit Balance");
	         grid.add(txtprice, 1, 4); 
	        /*
	         TextField txttcost=new TextField();
	         txttcost.setPromptText("Total Cost");
	         grid.add(txttcost, 1, 5); 
                 */
	         
	         Button okbtn=new Button("Add");
	         grid.add(okbtn, 1, 5);
                 okbtn.setOnAction((ActionEvent e) ->{
                        String custID = txtCustomer.getText() ;
                        int custIDI = Integer.parseInt(custID);
                        String name = txtItem.getText();
                        String address = txtQuantity.getText();
                      //  String credBal = txtprice.getText();
                     //   int credBalI = Integer.parseInt(credBal);
                      
                        Controller mycon = new Controller();
                     try {
                         mycon.addCustomer(custIDI, name, address);
                     } catch (SQLException ex) {
                         Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
                     }  
                        txtCustomer.clear();
                        txtItem.clear();
                        txtQuantity.clear();
                        
                        
                        }); 
	        /* okbtn.setOnAction(new EventHandler<ActionEvent>(){
	        	 
				@Override
				public void handle(ActionEvent arg0) {
					
					 txtCustomer.clear();
	        		 txtItem.clear();
	        		 txtQuantity.clear();
	        		 txtprice.clear();
	        		 txttcost.clear();
	        		 
				}
	         });
	         */
	         
	        /* Button resetbtn=new Button("Reset");
	         grid.add(resetbtn, 1, 6);
	         resetbtn.setOnAction(new EventHandler<ActionEvent>(){
	        	 
				@Override
				public void handle(ActionEvent arg0) {
					
					 txtCustomer.clear();
	        		 txtItem.clear();
	        		 txtQuantity.clear();
	        		 txtprice.clear();
	        		 txttcost.clear();
	        		 
				}
	         });
	         */
                
	         Button cancelbtn=new Button("Cancel");
                cancelbtn.setOnAction((ActionEvent e) ->{
                        txtCustomer.clear();
                        txtItem.clear();
                        txtQuantity.clear();
                 window.setScene(scene2);
                 
                 });
	         grid.add(cancelbtn, 2, 5);
	         
	         
	         
	         Scene scene=new Scene(grid, 500,400);
	         window.setScene(scene);
	         window.show();
	         
	         
	          
	         
	         
	         
	          

	  }
	}


