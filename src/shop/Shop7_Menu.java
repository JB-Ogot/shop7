package shop;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.util.Scanner;

/**
 *
 * @author h3mitt
 */
public class Shop7_Menu extends Application {
    
    Stage window;
    BorderPane layout;
     public static void main(String[] args) {
        launch(args);
        
    }
     
    @Override
    public void start(Stage primaryStage) {
 window = primaryStage;
 window.setTitle("SHOP7");
 
   //goods menu
   Menu Shop_items = new Menu("SHOP ITEMS");
   Shop_items.getItems().add(new MenuItem("All items"));
                    //men items
   Shop_items.getItems().add(new MenuItem("men suits"));
   Shop_items.getItems().add(new MenuItem("men trousers"));
   Shop_items.getItems().add(new MenuItem("men shirts"));
   Shop_items.getItems().add(new MenuItem("men jackets"));
                  //women items
   Shop_items.getItems().add(new MenuItem("women blouses"));
   Shop_items.getItems().add(new MenuItem("women trousers"));
   Shop_items.getItems().add(new MenuItem("women skirts"));
   Shop_items.getItems().add(new MenuItem("women shoes"));
   Shop_items.getItems().add(new SeparatorMenuItem());
   Shop_items.getItems().add(new MenuItem("Exit"));
   
 
  //customers menu 
  Menu CUSTOMERS =  new Menu("CUSTOMERS");
  CUSTOMERS.getItems().add(new MenuItem("Add new"));
  CUSTOMERS.getItems().add(new MenuItem("View all"));
  CUSTOMERS.getItems().add(new MenuItem("delete"));
  CUSTOMERS.getItems().add(new SeparatorMenuItem());
  CUSTOMERS.getItems().add(new MenuItem("Exit"));
  
  
 //stock menu
        Menu STOCK = new Menu("STOCK");
        MenuItem newstock = new MenuItem("New...");
        STOCK.getItems().add(new MenuItem("Check stock"));
        STOCK.getItems().add(new MenuItem("Remove items"));
        STOCK.getItems().add(new MenuItem("Stock worth"));
        STOCK.getItems().add(new SeparatorMenuItem());
        STOCK.getItems().add(new MenuItem("Exit"));
        
        
 //sales menu
        Menu SALES = new Menu("SALES");
        SALES.getItems().add(new MenuItem("All sales"));        
        SALES.getItems().add(new MenuItem("Cash sales..."));
        SALES.getItems().add(new MenuItem("Credit sales"));
        SALES.getItems().add(new MenuItem("Total cash sales"));
        SALES.getItems().add(new MenuItem("Total credit sales"));
        SALES.getItems().add(new SeparatorMenuItem());
        SALES.getItems().add(new MenuItem("Exit"));
        
      
        //search menu
 
       Menu  search = new Menu("SEARCH");
       MenuItem srch = new MenuItem("");
       search.getItems().add(new MenuItem("type here..."));
       Scanner sch = new Scanner(System.in);
       srch.setOnAction(e ->System.out.println(System.in) );
        
    
    MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(Shop_items,CUSTOMERS,STOCK,SALES,search);
        
        
        //SIGN UP FORM
        
        
        
        
        
        
        
        

        
        
        
        
        layout = new BorderPane();
        layout.setTop(menuBar);
        Scene scene = new Scene(layout, 550, 600);
        window.setScene(scene);
        window.show();
    
    }

    }
   
    

