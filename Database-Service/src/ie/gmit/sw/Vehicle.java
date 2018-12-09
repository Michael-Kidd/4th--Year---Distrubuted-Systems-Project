package ie.gmit.sw;

import java.io.Serializable;

public class Vehicle implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String make;
	private String model;
	private String reg;
	private boolean booked;
	
	public Vehicle() {
		
	}
	
	public Vehicle(String reg, String make, String model, boolean b) {
		this.make = make;
		this.model = model;
		this.reg = reg;
		this.booked = b;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getReg() {
		return reg;
	}

	public void setReg(String reg) {
		this.reg = reg;
	}

	public boolean isBooked() {
		return booked;
	}

	public void setBooked(boolean booked) {
		this.booked = booked;
	}
	
	
} 