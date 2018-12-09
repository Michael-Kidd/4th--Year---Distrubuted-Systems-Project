package ie.gmit.sw;

import java.io.Serializable;

public class Booking implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Customer c;
	private Vehicle v;
	
	public Booking() {
		
	}
	
	public Booking(Customer c, Vehicle v) {
		this.c = c;
		this.v = v;
	}

	public Customer getC() {
		return c;
	}

	public void setC(Customer c) {
		this.c = c;
	}

	public Vehicle getV() {
		return v;
	}

	public void setV(Vehicle v) {
		this.v = v;
	}

	
} 