/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
public class ViewStock {
	

	@SuppressWarnings("unchecked")
	public  void availableSales() {
		// TODO Auto-generated method stub
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Total goods sold");
		
		TableView<StockDetails> sales_table;
		
		TableColumn<StockDetails, Integer> nameColumn = new TableColumn<>("ID");	
		nameColumn.setMinWidth(70);
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
		
		TableColumn<StockDetails, String> product_descriptionColumn = new TableColumn<>("Product Name");	
		product_descriptionColumn.setMinWidth(150);
		product_descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("ProductName"));
		
		TableColumn<StockDetails, String> idColumn = new TableColumn<>("Price");
		idColumn.setMinWidth(70);
		idColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
		
		TableColumn<StockDetails, String> quantityColumn = new TableColumn<>("Quantity");
		quantityColumn.setMinWidth(70);
		quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
		
		TableColumn<StockDetails, String> priceColumn = new TableColumn<>("Price");
		priceColumn.setMinWidth(70);
		priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
		
		TableColumn<StockDetails, String> amountColumn = new TableColumn<>("Totals");
		amountColumn.setMinWidth(150);
		amountColumn.setCellValueFactory(new PropertyValueFactory<>("totals"));
		
		sales_table = new TableView<>();
		sales_table.setItems(getSales());
		sales_table.getColumns().addAll(product_descriptionColumn,idColumn, quantityColumn,amountColumn);
		
		VBox layout1 = new VBox();
		layout1.getChildren().addAll(sales_table);
		
		Scene scene = new Scene(layout1, 500, 400);
		window.setScene(scene);
		window.showAndWait();
		
	}

	public  ObservableList<StockDetails> getSales(){
		ObservableList<StockDetails> sales = FXCollections.observableArrayList();
		try {
			
			
			String url = "jdbc:mysql://localhost/shop7";
			String uname = "root";
			String pass = "    ";
			
			String query = "select * from shopItems";
			
			Connection con = DriverManager.getConnection(url, uname, pass);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			String product_description;
			int quantity;
			int price;
			int id;
                        int tots;
			while(rs.next()) {
				//name = rs.getString("ProductName");
				
				id=  rs.getInt("ID");
                                product_description = rs.getString("ProductName");
                                price = rs.getInt("Price");
				quantity = rs.getInt("Quantity");
                                tots = rs.getInt("Totals");
				//amount = rs.getInt(6);
				//System.out.print(product_description);
				sales.add(new StockDetails(id,product_description,price,quantity,tots));
			}
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
		return sales;		
		
	}
}