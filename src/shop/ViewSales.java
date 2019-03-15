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
public class ViewSales {
	

	@SuppressWarnings("unchecked")
	public  void availableSales() {
		// TODO Auto-generated method stub
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("All Sales");
		
		TableView<SalesDetails> sales;
		
		TableColumn<SalesDetails ,String> nameColumn = new TableColumn<>("ID");	
		nameColumn.setMinWidth(70);
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("ID"));
		
		TableColumn<SalesDetails, String> product_descriptionColumn = new TableColumn<>("Price");	
		product_descriptionColumn.setMinWidth(70);
		product_descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
		
		TableColumn<SalesDetails ,String> idColumn = new TableColumn<>("QuantitySold");
		idColumn.setMinWidth(70);
		idColumn.setCellValueFactory(new PropertyValueFactory<>("quant"));
		
		TableColumn<SalesDetails ,String> quantityColumn = new TableColumn<>("ProductID");
		quantityColumn.setMinWidth(70);
		quantityColumn.setCellValueFactory(new PropertyValueFactory<>("prodID"));
		
		TableColumn<SalesDetails ,String> priceColumn = new TableColumn<>("Totals");
		priceColumn.setMinWidth(70);
		priceColumn.setCellValueFactory(new PropertyValueFactory<>("totals"));
		/*
		TableColumn<StockDetails, String> amountColumn = new TableColumn<>("Total Amount Sold");
		amountColumn.setMinWidth(150);
		amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
		*/
		sales = new TableView<>();
		sales.setItems(getSales());
		sales.getColumns().addAll(nameColumn,product_descriptionColumn,idColumn, quantityColumn,priceColumn);
		
		VBox layout1 = new VBox();
		layout1.getChildren().addAll(sales);
		
		Scene scene = new Scene(layout1, 500, 400);
		window.setScene(scene);
		window.showAndWait();
		
	}

	public  ObservableList<SalesDetails> getSales(){
		ObservableList<SalesDetails> sales = FXCollections.observableArrayList();
		try {
			
			
			String url = "jdbc:mysql://localhost/shop7";
			String uname = "root";
			String pass = "    ";
			
			String query = "select * from Sales";
			
			Connection con = DriverManager.getConnection(url, uname, pass);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			//String address;
			int ID;
                        int price;
			int quant;
			int prodID;
                        int tots;
			while(rs.next()) {
				//name = rs.getString("ProductName");
				ID=  rs.getInt(1);
				price = rs.getInt(2);
                                quant = rs.getInt(3);
                                prodID = rs.getInt(4);
                                tots = rs.getInt(5);
				//System.out.print(product_description);
				sales.add(new SalesDetails(ID,price,quant,prodID,tots));
			}
		}
		catch(SQLException ex) {
			System.out.println(ex);
		}
		return sales;		
		
	}
}