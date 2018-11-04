package WebService;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.rmi.Naming;

@Path("/hellosingleton")
@Singleton
public class HelloSingleton {

	int timesCalled = 0;

	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHello() {
			
		String service = "/bookingService";
		String address = "localhost:1099";

		BookingService bs = null;
		
        try 
        {
           
        	bs = (BookingService)Naming.lookup( "rmi://" + address + service);
        	
        	System.out.println(bs);
           
        } 
        catch (Exception e) 
        { 
           e.printStackTrace(); 
        }

		timesCalled++;
		return "Hello World number: " + timesCalled;
	}
}