package ie.gmit.sw;

import java.io.Serializable;

public class Customer implements Serializable{
	
	/*
	 * This object will be used to make Customer records,
	 * It consists of a name and an address for each customer.
	 * 
	 * */

	private static final long serialVersionUID = 1L;
	
	private String name;
	private String address;

	public Customer() {
		
	}
	
	public Customer(String n, String a) {
		this.name = n;
		this.address = a;
	}

	public String getName() {
	    return name;
	}
	
	public void setName(String name) {
	    this.name = name;
	}
	
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

} 