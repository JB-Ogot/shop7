package shop;

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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SignupForm extends Application{

		Stage window;

		
                @Override
	  public void start(Stage primarystage) {
	         window=primarystage;
	         window.setTitle("Sign Up"); 
	         
	         GridPane grid=new GridPane();
	         grid.setAlignment(Pos.CENTER);
	         grid.setVgap(10);
	         grid.setHgap(10);
	         grid.setPadding(new Insets(10));
	         
	         Text welcomeTxt=new Text("WELCOME");
	         welcomeTxt.setFont(Font.font("Tahoma", FontWeight.LIGHT, 25));
	         grid.add(welcomeTxt, 1, 0);
	         
	         Text signupTxt=new Text("SIGN UP: ");
	         signupTxt.setFont(Font.font("Tahoma", FontWeight.LIGHT, 17));
	         grid.add(signupTxt, 0, 1);
	         
	         Label lblUser=new Label("Username");
	         grid.add(lblUser, 0, 2);
	         
	         TextField txtUser=new TextField();
	         txtUser.setPromptText("username");
	         grid.add(txtUser, 1, 2);
	         
	         Label lblnewPassword=new Label("New Password");
	         grid.add(lblnewPassword, 0, 3);
	         
	         Label lblconfirmPassword=new Label("Confirm Password");
	         grid.add(lblconfirmPassword, 0, 4);
	          
	         Label lblaccount=new Label ("Already have an account");
	         grid.add(lblaccount, 0, 6);
	           lblaccount.setOnMouseClicked(e->{
	        	   LoginForm  mForm=new LoginForm();
	        	   mForm.start(primarystage);
	           });
	        		 
	         PasswordField pwBox=new PasswordField();
	         pwBox.setPromptText("New Password");
	         grid.add(pwBox, 1, 3); 
	         
	         PasswordField pswBox=new PasswordField();
	         pswBox.setPromptText("Confirm Password");
	         grid.add(pswBox, 1, 4);
	         
	         Button signupbtn=new Button("Sign UP");
	         grid.add(signupbtn, 1, 5);
	         signupbtn.setOnAction((ActionEvent arg0) -> {
                     txtUser.clear();
                     pwBox.clear();
                     pswBox.clear();
                 });
	         
	         
	         Button cancelbtn=new Button("Cancel");
	         grid.add(cancelbtn,2 ,5);
	        	 
	         
	         
	         Scene scene=new Scene(grid, 400,400);
	         window.setScene(scene);
	         window.show();
	         
	         
	          
	         
	         
	         
	          

	  }
	}
