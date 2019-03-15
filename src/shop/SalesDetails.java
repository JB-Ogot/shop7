/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop;

import java.beans.PropertyChangeSupport;

/**
 * 
 *
 * @author h3mitt
 */
public class SalesDetails {

	
	//private String name;

	private final int ID;
	private final int price;
        private final int quant;
	private final int prodID;
	private final int tots;
	
	public SalesDetails(int ID,int price, int quant, int prodID,int tots) {
		this.ID = ID;
		this.price = price;
		this.quant = quant;
		this.prodID = prodID;
                this.tots = tots;
                
        }

    /**
     * @return the ID
     */
    public int getID() {
        return ID;
    }

    /**
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * @return the quant
     */
    public int getQuant() {
        return quant;
    }

    /**
     * @return the prodID
     */
    public int getProdID() {
        return prodID;
    }

    /**
     * @return the tots
     */
    public int getTotals() {
        return tots;
    }
    private final transient PropertyChangeSupport propertyChangeSupport = new java.beans.PropertyChangeSupport(this);
    public static final String PROP_ID = "ID";
    public static final String PROP_PRICE = "price";
    public static final String PROP_QUANT = "quant";
    public static final String PROP_PRODID = "prodID";
    public static final String PROP_TOTS = "tots";
     

  
	

    }
