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
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginForm{
	
	Stage window;

  public void start(Stage primarystage) {
         window=primarystage;
         window.setTitle("Login Form"); 
         
         GridPane grid=new GridPane();
         grid.setAlignment(Pos.CENTER);
         grid.setVgap(20);
         grid.setHgap(20);
         grid.setPadding(new Insets(20));
         
         Text welcomeTxt=new Text("Welcome");
         welcomeTxt.setFont(Font.font("Tahoma", FontWeight.LIGHT, 25));
         grid.add(welcomeTxt, 0, 0);
         
         Label lblUser=new Label("Username");
         grid.add(lblUser, 0, 1);
         
         TextField txtUser=new TextField();
         txtUser.setPromptText("username");
         grid.add(txtUser, 1, 1);
         
         Label lblPassword=new Label("Password");
         grid.add(lblPassword, 0, 2);
         
         PasswordField pwBox=new PasswordField();
         pwBox.setPromptText("Password");
         grid.add(pwBox, 1, 2); 
         
         Button loginbtn=new Button("Login");
         grid.add(loginbtn, 1, 3);
         
         Scene scene=new Scene(grid, 500,500);
         window.setScene(scene);
         window.show();
                

  }
}
