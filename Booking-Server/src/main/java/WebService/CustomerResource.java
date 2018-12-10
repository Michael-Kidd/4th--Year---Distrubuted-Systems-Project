package WebService;


import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import ie.gmit.sw.Customer;
import ie.gmit.sw.DatabaseService;

@Path("customerlist")
public class CustomerResource {
	
	private String service = "/databaseService";
	private String address = "localhost:1099";


	//Get requests
    @GET
    @Path("/get") // path for get request resources
    @Produces(MediaType.APPLICATION_JSON)// returns json objects
    public Response getJson() throws RemoteException, MalformedURLException, NotBoundException, SQLException {
    	
    	//Connect using RMI to Database Server
    	DatabaseService ds = (DatabaseService)Naming.lookup( "rmi://" + address + service);
    	
    	//Connect
    	ds.Connect();
    	
    	//return the values needed
    	List<Object> rs = ds.ReadCustomers("SELECT * FROM CUSTOMERS");
    	
    	//Close the Connection
    	ds.Close();
    	
    	//gson
    	Gson gson = new Gson();
    	
    	//convert to json objects
        String jsonResp = gson.toJson(rs);
    	
        //respond to the requester
        return Response.ok(jsonResp, MediaType.APPLICATION_JSON).build();
        
    }
    
    //used for updating entries
    @SuppressWarnings("unused")
	@PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update() throws RemoteException, MalformedURLException, NotBoundException, SQLException {
    	
    	
    	String name = "";
    	String address = "";
    	
    	//new customer object
    	Customer c = new Customer(name, address);
    	
    	//Connect using RMI to Database Server
    	DatabaseService ds = (DatabaseService)Naming.lookup( "rmi://" + address + service);
    	
    	//Connect
    	ds.Connect();
    	
    	//Update values using RMI
    	ds.Update("UPDATE TABLE CUSTOMERS (NAME, ADDRESS) VALUES ('"+name+"', '"+address+"') WHERE NAME="+name+"; ");
    	
    	//return the values needed
    	List<Object> rs = ds.ReadCustomers("SELECT * FROM CUSTOMERS");
    	
    	//Close the Connection
    	ds.Close();
    	
    	//gson
    	Gson gson = new Gson();
    	
    	//convert to json
        String jsonResp = gson.toJson(rs);
    	
        //respond to the requester
        return Response.ok(jsonResp, MediaType.APPLICATION_JSON).build();
    }
    
    //Used for delete requests
    @SuppressWarnings("unused")
	@DELETE
    @Path("/delete")
    @Consumes(MediaType.TEXT_PLAIN)
    public Response delete() throws RemoteException, MalformedURLException, NotBoundException, SQLException {
    	
    	String name = "";
    	String address = "";
    	
    	String reg = "";
    	String make = "";
    	String model = "";
    	
    	
    	//new customer object
    	Customer c= new Customer(name, address);
    	
    	//Connect using RMI to Database Server
    	DatabaseService ds = (DatabaseService)Naming.lookup( "rmi://" + address + service);
    	
    	//Connect
    	ds.Connect();
    
    	//Perform detetions and updates when customer record deleted
    	ds.Delete("DELETE FROM CUSTOMERS WHERE NAME ='"+name+"';");
    	ds.Delete("DELETE FROM BOOKINGS WHERE NAME ='"+name+"';");
    	ds.Update("UPDATE TABLE VEHICLES (BOOKED) VALUES ('0') WHERE NAME="+name+"; ");
    	
    	//return the values needed
    	List<Object> rs = ds.ReadBookings("SELECT * FROM CUSTOMERS");
    	
    	//Close the Connection
    	ds.Close();
    	
    	//gson
    	Gson gson = new Gson();
    	
    	//convert to json
        String jsonResp = gson.toJson(rs);
    	
        //respond to the requester
        return Response.ok(jsonResp, MediaType.APPLICATION_JSON).build();
        
    }
    
}
