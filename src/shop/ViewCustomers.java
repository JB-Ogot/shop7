/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author h3mitt
 */
public class ViewCustomers {
	

	@SuppressWarnings("unchecked")
	public  void availableCusts() {
		// TODO Auto-generated method stub
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("All Customers");
		
		TableView<CustDetails> custs;
		
		TableColumn<CustDetails ,String> nameColumn = new TableColumn<>("ID");	
		nameColumn.setMinWidth(70);
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("custID"));
		/*
		TableColumn<StockDetails, String> product_descriptionColumn = new TableColumn<>("Product Name");	
		product_descriptionColumn.setMinWidth(150);
		product_descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("ProductName"));
		*/
		TableColumn<CustDetails ,String> idColumn = new TableColumn<>("Name");
		idColumn.setMinWidth(70);
		idColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		
		TableColumn<CustDetails ,String> quantityColumn = new TableColumn<>("Address");
		quantityColumn.setMinWidth(70);
		quantityColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
		/*
		TableColumn<CustDetails ,String> priceColumn = new TableColumn<>("Max Credit");
		priceColumn.setMinWidth(70);
		priceColumn.setCellValueFactory(new PropertyValueFactory<>("maxCred"));
		/*
		TableColumn<StockDetails, String> amountColumn = new TableColumn<>("Total Amount Sold");
		amountColumn.setMinWidth(150);
		amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
		*/
		custs = new TableView<>();
		custs.setItems(getCusts());
		custs.getColumns().addAll(nameColumn,idColumn, quantityColumn);
		
		VBox layout1 = new VBox();
		layout1.getChildren().addAll(custs);
		
		Scene scene = new Scene(layout1, 500, 400);
		window.setScene(scene);
		window.showAndWait();
		
	}

	public  ObservableList<CustDetails> getCusts(){
		ObservableList<CustDetails> custS = FXCollections.observableArrayList();
		try {
			
			
			String url = "jdbc:mysql://localhost/shop7";
			String uname = "root";
			String pass = "    ";
			
			String query = "select * from Customers";
			
			Connection con = DriverManager.getConnection(url, uname, pass);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			String address;
			int custID;
			int maxCred;
			String name;
			while(rs.next()) {
				//name = rs.getString("ProductName");
				custID=  rs.getInt(1);
				name = rs.getString(2);
                                address = rs.getString(3);
                              //  maxCred = rs.getInt(4);
				//amount = rs.getInt(6);
				//System.out.print(product_description);
				custS.add(new CustDetails(custID,name,address));
			}
		}
		catch(SQLException ex) {
			System.out.println(ex);
		}
		return custS;		
		
	}
}