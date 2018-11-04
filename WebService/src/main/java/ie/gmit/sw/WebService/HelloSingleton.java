package ie.gmit.sw.WebService;

import java.rmi.Naming;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hellosingleton")
@Singleton
public class HelloSingleton {

	int timesCalled = 0;
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHello() {
			
		String service = "/bookingService";
		String address = "127.0.0.1:1099";

        try 
        { 
           
        	Naming.lookup( "//" + address + service);
           
        } 
        catch (Exception e) 
        { 
           e.printStackTrace(); 
        }

		timesCalled++;
		return "Hello World number: " + timesCalled;
	}
}