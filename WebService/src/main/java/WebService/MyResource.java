package WebService;

import java.rmi.Naming;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ie.gmit.sw.BookingService;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
    	
		String service = "/bookingService";
		String address = "localhost:1099";
		
        try
        {
           
        	BookingService bs = (BookingService)Naming.lookup( "rmi://" + address + service);
        	System.out.println("test service");
           
        } 
        catch (Exception e) 
        {
           e.printStackTrace(); 
        }
        
        
        return "Got it!";
    }
}
