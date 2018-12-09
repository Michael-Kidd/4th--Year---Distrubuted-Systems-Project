package ie.gmit.sw;

import java.io.Serializable;

public class Booking implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Vehicle v;
	private Customer c;
	
	public Booking() {
		
	}
	
	public Booking(Vehicle v, Customer c) {
		this.v = v;
		this.c = c;
	}

	public Vehicle getV() {
		return v;
	}

	public void setV(Vehicle v) {
		this.v = v;
	}

	public Customer getC() {
		return c;
	}

	public void setC(Customer c) {
		this.c = c;
	}

} 