package shop;


    import java.time.LocalDate;
    import javafx.application.Application;
    import javafx.event.ActionEvent;
    import javafx.event.EventHandler;
    import javafx.geometry.Insets;
    import javafx.geometry.Pos;
    import javafx.scene.Scene;
    import javafx.scene.control.Button;
    import javafx.scene.control.DatePicker;
    import javafx.scene.control.Label;
    import javafx.scene.control.PasswordField;
    import javafx.scene.control.TextField;
    import javafx.scene.layout.GridPane;
    import javafx.scene.layout.StackPane;
    import javafx.scene.text.Font;
    import javafx.scene.text.FontWeight;
    import javafx.scene.text.Text;
    import javafx.stage.Stage;

public class Inventory  {
	
	        
              Stage window;

		  
		  public void start(Stage primarystage) {
		         window=primarystage;
		         window.setTitle("Inventory"); 
		         
		         GridPane grid=new GridPane();
		         grid.setAlignment(Pos.CENTER);
		         grid.setVgap(10);
		         grid.setHgap(10);
		         grid.setPadding(new Insets(10));
		         
		         Text welcomeTxt=new Text("INVENTORY");
		         welcomeTxt.setFont(Font.font("Tahoma", FontWeight.LIGHT, 25));
		         grid.add(welcomeTxt, 0, 0);
		         
		         Label lblitemid=new Label("Item_ID");
		         grid.add(lblitemid, 0, 1);
		         
		         Label lblItem=new Label("Item");
		         grid.add(lblItem, 0, 2);
		         
		         Label lblQuantity=new Label("Quantity");
		         grid.add(lblQuantity, 0, 3);
		         
		         Label lblprice=new Label("Unit Price");
		         grid.add(lblprice, 0, 4);
		         
		         Label lbldate=new Label("Date Modified");
		         grid.add(lbldate, 0, 5);
		         
		         
		         TextField txtitemid=new TextField();
		         txtitemid.setPromptText("Item_ID");
		         grid.add(txtitemid, 1, 1);
		         
		         
		         TextField txtItem=new TextField();
		         txtItem.setPromptText("Item");
		         grid.add(txtItem, 1, 2); 
		         
		         TextField txtQuantity=new TextField();
		         txtQuantity.setPromptText("Quantity");
		         grid.add(txtQuantity, 1, 3); 
		         
		         TextField txtprice=new TextField();
		         txtprice.setPromptText("Unit Price");
		         grid.add(txtprice, 1, 4); 
		         
		         DatePicker dob =new DatePicker();
		         grid.add(dob, 1, 5); 
		         dob.setValue(LocalDate.now());
		         
		         Button okbtn=new Button("OK");
		         grid.add(okbtn, 1, 6);
		         okbtn.setOnAction(new EventHandler<ActionEvent>(){
		        	 @Override
						public void handle(ActionEvent arg0) {
							
							 txtitemid.clear();
			        		 txtItem.clear();
			        		 txtQuantity.clear();
			        		 txtprice.clear();
			        		
			        		 
						}
		         });
		       
		  
		         Button cancelbtn=new Button("Cancel");
		         grid.add(cancelbtn, 2, 6);
		         

                               Scene scene=new Scene(grid, 500,500);
                               window.setScene(scene);
                               window.show();
		  }                      
}



		         
		  
