/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author h3mitt
 */
public class Shop extends Application {
    Stage window;
    Scene scene,scene2,scene3;
    BorderPane layout;
    Scanner sch;
    TextField userTextField;
    PasswordField pwBox;
    
    
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
      
            window=primaryStage;
             
            
            GridPane grid=new GridPane();
            grid.setAlignment(Pos.CENTER);
            grid.setHgap(10);
            grid.setVgap(10);
            grid.setPadding(new Insets(25,25,25,25));
            
            //text
            Text scenetitle = new Text("Welcome");
            scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
            grid.add(scenetitle,0,0);
            
            
            //button
            Button btn = new Button("Login");
            HBox hbBtn = new HBox(10);
            hbBtn.setAlignment(Pos.CENTER);
            hbBtn.getChildren().add(btn);
            grid.add(hbBtn,1,3);
       
            
            //image
            Image image = new Image(new FileInputStream("/home/h3mitt/NetBeansProjects/Shop/Images/icons8-user-50.png"));
            ImageView imageView=new ImageView(image);
            imageView.setX(50);
            imageView.setY(20);
            
            imageView.setFitHeight(100);
            imageView.setFitWidth(100);
            imageView.setPreserveRatio(true);
            
            
            grid.add(imageView, 1, 0);
            
            
            
            //textfields
            Label userName = new Label("Username:");
            grid.add(userName, 0, 1);
            TextField userTextField = new TextField();
            grid.add(userTextField, 1, 1);
            Label pw = new Label("Password:");
            grid.add(pw, 0, 2);
            PasswordField pwBox = new PasswordField();
            grid.add(pwBox, 1, 2);
            
            
            scene = new Scene(grid, 500, 400);
            
            
            
       
            //SECOND SCENE
            
            //goods menu
            Menu Shop_items = new Menu("SHOP ITEMS");
            
            //men items
            MenuItem boots = new MenuItem("Boots (4500)");
            Shop_items.getItems().add(boots);
            boots.setOnAction((ActionEvent e) -> {
                Sell sale = new Sell();
                sale.start(window,scene2);
            });
                        MenuItem timber = new MenuItem("Timberlands (4500)");
            Shop_items.getItems().add(timber);
            timber.setOnAction((ActionEvent e) -> {
                Sell sale2 = new Sell();
                sale2.start(window,scene2);
            });
            MenuItem crocs = new MenuItem("Crocs (200)");
            Shop_items.getItems().add(crocs);
            crocs.setOnAction((ActionEvent e) -> {
                Sell sale1 = new Sell();
                sale1.start(window,scene2);
            });
            

            MenuItem adidas = new MenuItem("Adidas (3000)");
            Shop_items.getItems().add(adidas);
            adidas.setOnAction((ActionEvent e) -> {
                Sell sale3 = new Sell();
                sale3.start(window,scene2);
            });
            MenuItem nike=new MenuItem("Nikes (4000)");
            Shop_items.getItems().add(nike);
            nike.setOnAction((ActionEvent e) -> {
                Sell sale4 = new Sell();
                sale4.start(window,scene2);
            });
            
            MenuItem puma=new MenuItem("Pumas (3500)");
            Shop_items.getItems().add(puma);
            puma.setOnAction((ActionEvent ex) -> {
                Sell sale5 = new Sell();
                sale5.start(window,scene2);
            });
            
            Shop_items.getItems().add(new SeparatorMenuItem());
            Shop_items.getItems().add(new MenuItem("Exit"));
            
            
            //customers menu
            Menu CUSTOMERS =  new Menu("CUSTOMERS");
            MenuItem add_cust = new MenuItem("Add new");
            CUSTOMERS.getItems().add(add_cust);
            add_cust.setOnAction((ActionEvent e) -> {
                Customer myCust = new Customer();
                myCust.start(window,scene2);
            });
            MenuItem view = new MenuItem("View All");
            CUSTOMERS.getItems().add(view);
            view.setOnAction((ActionEvent e) ->{
                ViewCustomers vs = new ViewCustomers();
                vs.getCusts();
                vs.availableCusts();
                
                
                
                }); 
            MenuItem del_cust = new MenuItem("Remove");
            CUSTOMERS.getItems().add(del_cust);
            del_cust.setOnAction((ActionEvent e) -> {
                RemoveCustomer remo = new RemoveCustomer();
                remo.start(window,scene2);
            });
            CUSTOMERS.getItems().add(new SeparatorMenuItem());
            CUSTOMERS.getItems().add(new MenuItem("Exit"));
            
            
            //stock menu
            Menu STOCK = new Menu("STOCK");
            MenuItem addProduct = new MenuItem("Add Product");
            STOCK.getItems().add(addProduct);
            addProduct.setOnAction((ActionEvent e) ->{
                    AddProduct pdt = new AddProduct();
                    pdt.start(window, scene2);
                    
                    });
            MenuItem totG = new MenuItem("Total Goods");
            STOCK.getItems().add(totG);
            totG.setOnAction((ActionEvent e) ->{
                    ViewStock vs = new ViewStock();
                try {
                    vs.getSales();
                    vs.availableSales();
                } catch (Exception ex) {
                    Logger.getLogger(Shop.class.getName()).log(Level.SEVERE, null, ex);
                }
                    
                    
                    });
           
            MenuItem stw = new MenuItem("Stock Worth");
            STOCK.getItems().add(stw);
            stw.setOnAction((ActionEvent e) ->{
                int tot;
                 Controller cnt = new Controller();
                try {
                    tot = cnt.totStock();
                    JOptionPane.showMessageDialog(null, tot);
                    
                } catch (SQLException ex) {
                    Logger.getLogger(Shop.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                });
            
            STOCK.getItems().add(new SeparatorMenuItem());
            STOCK.getItems().add(new MenuItem("Exit"));
            
            
            
            //sales menu
            Menu SALES = new Menu("SALES");
            MenuItem sl = new MenuItem("Sales");
            SALES.getItems().add(sl);
            sl.setOnAction((ActionEvent e) ->{
                ViewSales vs = new ViewSales();
                vs.getSales();
                vs.availableSales();
                 }); 
            MenuItem totSales = new MenuItem("Total Sales");
            SALES.getItems().add(totSales);
            totSales.setOnAction((ActionEvent e) ->{
                
                        Controller cdr = new Controller();
                try {
                    int sales = cdr.getTots();
                    JOptionPane.showMessageDialog(null, sales);
                } catch (SQLException ex) {
                    Logger.getLogger(Shop.class.getName()).log(Level.SEVERE, null, ex);
                }
            
                    });
           
            SALES.getItems().add(new SeparatorMenuItem());
            SALES.getItems().add(new MenuItem("Exit"));
            
            
            //search menu
            
            Menu Logout = new Menu("LOG OUT");
            MenuItem exit = new MenuItem("Exit");
            
            Logout.getItems().add(exit);
            exit.setOnAction((ActionEvent e) -> {
                    window.setScene(scene);
                    userTextField.clear();
                    pwBox.clear();
                            });
            
            MenuBar menuBar = new MenuBar();
            menuBar.getMenus().addAll(Shop_items,CUSTOMERS,STOCK,SALES,Logout);
            
            //IMAGES
            
        GridPane grid5 = new GridPane();
       
        grid5.setAlignment(Pos.TOP_LEFT);
        grid5.setHgap(5);
        grid5.setVgap(5);
        grid5.setPadding(new Insets(15, 15, 15, 15));
        
        
        Image image1 = new Image(new FileInputStream("/home/h3mitt/NetBeansProjects/Shop/Images/dan-carlson-78151-unsplash.jpg"));
        ImageView i = new ImageView(image1);
        i.setX(10);
        i.setY(10);
        
        i.setFitHeight(150);
        i.setFitWidth(200);
        i.setPreserveRatio(true);
        
        grid5.add(i, 0, 0);
        
        
        Image image2 = new Image(new FileInputStream("/home/h3mitt/NetBeansProjects/Shop/Images/chuttersnap-604557-unsplash.jpg"));
        ImageView j = new ImageView(image2);
        j.setX(10);
        j.setY(10);
        
        j.setFitHeight(150);
        j.setFitWidth(200);
        j.setPreserveRatio(true);
        
        grid5.add(j, 5, 0);
        
        
        Image image3 = new Image(new FileInputStream("/home/h3mitt/NetBeansProjects/Shop/Images/greg-tockner-386887-unsplash.jpg"));
        ImageView k = new ImageView(image3);
        k.setX(10);
        k.setY(10);
        
        k.setFitHeight(150);
        k.setFitWidth(200);
        k.setPreserveRatio(true);
        
        grid5.add(k, 10, 0);
        
        
        
        Image image4 = new Image(new FileInputStream("/home/h3mitt/NetBeansProjects/Shop/Images/imani-clovis-234736-unsplash.jpg"));
        ImageView l = new ImageView(image4);
        l.setX(10);
        l.setY(10);
        
        l.setFitHeight(150);
        l.setFitWidth(200);
        l.setPreserveRatio(true);
        
        grid5.add(l, 15, 0);
        
        
        Image image5 = new Image(new FileInputStream("/home/h3mitt/NetBeansProjects/Shop/Images/imani-clovis-234736-unsplash.jpg"));
        ImageView m = new ImageView(image5);
        m.setX(10);
        m.setY(10);
        
        m.setFitHeight(150);
        m.setFitWidth(200);
        m.setPreserveRatio(true);
        
        grid5.add(m, 0, 5);
        
        
        Image image6 = new Image(new FileInputStream("/home/h3mitt/NetBeansProjects/Shop/Images/thomas-serer-420833-unsplash.jpg"));
        ImageView n = new ImageView(image6);
        n.setX(10);
        n.setY(10);
        
        n.setFitHeight(150);
        n.setFitWidth(200);
        n.setPreserveRatio(true);
        
        grid5.add(n, 5, 5);
        
        Image image7 = new Image(new FileInputStream("/home/h3mitt/NetBeansProjects/Shop/Images/malvestida-magazine-458582-unsplash.jpg"));
        ImageView o = new ImageView(image7);
        o.setX(10);
        o.setY(10);
        
        o.setFitHeight(150);
        o.setFitWidth(200);
        o.setPreserveRatio(true);
        
        grid5.add(o, 10, 5);
        
        
        Image image8 = new Image(new FileInputStream("/home/h3mitt/NetBeansProjects/Shop/Images/kristian-egelund-113903-unsplash.jpg"));
        ImageView p = new ImageView(image8);
        p.setX(10);
        p.setY(10);
        
        p.setFitHeight(150);
        p.setFitWidth(200);
        p.setPreserveRatio(true);
        
        grid5.add(p, 15, 5);
        
        Image image9 = new Image(new FileInputStream("/home/h3mitt/NetBeansProjects/Shop/Images/kristian-egelund-113903-unsplash.jpg"));
        //Image image9 = new Image("/home/h3mitt/NetBeansProjects/Shop/Images/kristian-egelund-113903-unsplash.jpg");
        ImageView q = new ImageView(image9);
        q.setX(10);
        q.setY(10);
        
        q.setFitHeight(150);
        q.setFitWidth(200);
        q.setPreserveRatio(true);
        
        grid5.add(q, 0, 10);
        
        Image image10 = new Image(new FileInputStream("/home/h3mitt/NetBeansProjects/Shop/Images/kristian-egelund-113903-unsplash.jpg"));
        //Image image10 = new Image("/home/h3mitt/NetBeansProjects/Shop/Images/kristian-egelund-113903-unsplash.jpg");
        ImageView r = new ImageView(image10);
        r.setX(10);
        r.setY(10);
        
        r.setFitHeight(150);
        r.setFitWidth(200);
        r.setPreserveRatio(true);
        
        grid5.add(r, 5, 10);
        
        Image image11 = new Image(new FileInputStream("/home/h3mitt/NetBeansProjects/Shop/Images/kristian-egelund-113903-unsplash.jpg"));
        //Image image11 = new Image("/home/h3mitt/NetBeansProjects/Shop/Images/kristian-egelund-113903-unsplash.jpg");
        ImageView s = new ImageView(image11);
        s.setX(10);
        s.setY(10);
        
        s.setFitHeight(150);
        s.setFitWidth(200);
        s.setPreserveRatio(true);
        
        grid5.add(s, 10, 10);
        
        Image image12 = new Image(new FileInputStream("/home/h3mitt/NetBeansProjects/Shop/Images/kristian-egelund-113903-unsplash.jpg"));
        //Image image12 = new Image("/home/h3mitt/NetBeansProjects/Shop/Images/kristian-egelund-113903-unsplash.jpg");
        ImageView t = new ImageView(image12);
        t.setX(10);
        t.setY(10);
        
        t.setFitHeight(150);
        t.setFitWidth(200);
        t.setPreserveRatio(true);
        
        grid5.add(t, 15, 10);
            
            
            
            
            
            
            
            
            layout = new BorderPane();
            layout.setTop(menuBar);
            layout.setLeft(grid5);
            
            scene2 = new Scene(layout, 900, 580);
            
            //String user = userTextField.getText();
            //String pswd = pwBox.getText();
            
            btn.setOnAction((ActionEvent e) ->{
                        String userS = userTextField.getText();
                        String pswdP = pwBox.getText();
                        Controller mycn = new Controller();
                try {
                    mycn.authenticate(userS, pswdP,window,scene2);
                 
                } catch (SQLException ex) {
                    System.out.println("Error");
                }
            
            
                        });
       
            
            
          /*
            GridPane grid2=new GridPane();
            grid2.setAlignment(Pos.CENTER);
            grid2.setVgap(10);
            grid2.setHgap(10);
            grid2.setPadding(new Insets(10));
            
            Text welcomeTxt=new Text("WELCOME");
            welcomeTxt.setFont(Font.font("Tahoma", FontWeight.LIGHT, 25));
            grid2.add(welcomeTxt, 1, 0);
            
            Text signupTxt=new Text("SIGN UP: ");
            signupTxt.setFont(Font.font("Tahoma", FontWeight.LIGHT, 17));
            grid2.add(signupTxt, 0, 1);
            
            Label lblUser=new Label("Username");
            grid2.add(lblUser, 0, 2);
            
            TextField txtUser=new TextField();
            txtUser.setPromptText("username");
            grid2.add(txtUser, 1, 2);
            
            Label lblnewPassword=new Label("New Password");
            grid2.add(lblnewPassword, 0, 3);
            
            Label lblconfirmPassword=new Label("Confirm Password");
            grid2.add(lblconfirmPassword, 0, 4);
            
            Label lblaccount=new Label ("Already have an account");
            grid2.add(lblaccount, 0, 6);
            lblaccount.setOnMouseClicked(e -> window.setScene(scene));
            
            PasswordField pwBox2=new PasswordField();
            pwBox2.setPromptText("New Password");
            grid2.add(pwBox2, 1, 3);
            
            PasswordField pswBox=new PasswordField();
            pswBox.setPromptText("Confirm Password");
            grid2.add(pswBox, 1, 4);
            
            Button signupbtn=new Button("Sign Up");
            grid2.add(signupbtn, 1, 5);
            signupbtn.setOnAction((ActionEvent arg0) -> {
            txtUser.clear();
            pwBox2.clear();
            pswBox.clear();
            window.setScene(scene2);
            });
            
            
            Button cancelbtn=new Button("Cancel");
            grid2.add(cancelbtn,2 ,5);
            
            scene3= new Scene(grid2,500,400);
            */
            
            Customer mycust = new Customer();
            mycust.start(window,scene2);
            
            
            
            
            
            
            window.setTitle("SHOP7");
            window.setScene(scene);
            window.show();
        
        
        
       
    
    }
    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        launch(args);
        //ConnectDB cbt = new ConnectDB();
        //ConnectDB.getConnection();
        
    }
    
}
