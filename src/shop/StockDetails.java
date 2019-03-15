/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop;

/**
 *
 * @author h3mitt
 */
public class StockDetails {

	
	//private String name;
        private final int id;
	private final String prodN;
	private final int quantity;
	private final int price;
	private final int totals;
	
	public StockDetails(int id, String prodN, int price, int quantity,int totals) {
		//this.name = name;
                this.id = id;
		this.prodN = prodN;
                this.price = price;
		this.quantity = quantity;
		this.totals = totals;
		//this.amount = amount;
		System.out.print(price);
		}
        public int getid(){
		return this.id;
	}
	
	public String getProductName(){
                return this.prodN;
            
        }
	
	public int getPrice() {
		return this.price;
	}
	public int getQuantity() {
		return this.quantity;
	}
	
	public int getTotals(){
                return this.totals;
            
        }

    }
