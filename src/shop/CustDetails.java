/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop;

/**
 * 
 *
 * @author h3mitt
 */
public class CustDetails {

	
	//private String name;

	private final int custID;
	private final String name;
	private final String address;
	//private final int maxCred;
	
	public CustDetails(int custID, String name, String address) {
		//this.name = name;
		this.custID = custID;
		this.name = name;
		this.address = address;
                
        }
	
	/*public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	*/
	

	
	public String getName() {
		return this.name;
	}
	
	public String getAddress(){
                return this.address;
            
        }
	
	public int getCustID() {
		return this.custID;
	}
	
	/*
	
	public int getCred() {
		return this.maxCred;
	}
	/*
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public int getAmount() {
		return this.amount;
	}

*/
    }
