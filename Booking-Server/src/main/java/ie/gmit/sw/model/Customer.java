package ie.gmit.sw.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "customer")
public class Customer {
	
	private String name;
	
	public Customer(String n) {
		this.name = n;
	}

	@XmlElement
	public String getName() {
	    return name;
	}
	
	public void setName(String name) {
	    this.name = name;
	}

} 