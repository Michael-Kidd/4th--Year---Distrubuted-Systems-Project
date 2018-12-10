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
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import ie.gmit.sw.Booking;
import ie.gmit.sw.Customer;
import ie.gmit.sw.DatabaseService;
import ie.gmit.sw.Vehicle;

//The default path for all Booking related rest requests
@Path("bookinglist")
public class BookingResource {
	
	private String service = "/databaseService";
	private String address = "localhost:1099";

	//Get requests, used when querying and not editing
    @GET
    @Path("/get") //Path labelled as get.
    @Produces(MediaType.APPLICATION_JSON) //produces Json objects that will be returned to requester
    public Response getJson() throws RemoteException, MalformedURLException, NotBoundException, SQLException {
    	
    	//Connect using RMI to Database Server
    	DatabaseService ds = (DatabaseService)Naming.lookup( "rmi://" + address + service);
    	
    	//Connect
    	ds.Connect();
    	
    	//return the values needed
    	List<Object> rs = ds.ReadBookings("SELECT * FROM BOOKINGS");
    	
    	//Close the Connection
    	ds.Close();
    	
    	//Gson, Used for converting objects too and from json format
    	Gson gson = new Gson();
    	
    	//convert to json
        String jsonResp = gson.toJson(rs);
    	
        //return a response to a requester
        return Response.ok(jsonResp, MediaType.APPLICATION_JSON).build();
        
    }
    
    //Post requests
    @SuppressWarnings("unused")
	@POST
    @Path("/add") //Path used for post requests
    @Consumes(MediaType.APPLICATION_JSON)//take in json objects
    @Produces(MediaType.APPLICATION_JSON)//returns json objects
    public Response addBooking() throws RemoteException, MalformedURLException, NotBoundException, SQLException {
		
    	String name = "";
    	String address = "";
    	
    	String reg = "";
    	String make = "";
    	String model = "";
    	
    	//a new booking object containing a vehicle and the customer that booked it
    	Booking b = new Booking(new Vehicle(reg, make, model, true), new Customer(name, address));
    	
    	//Connect using RMI to Database Server
    	DatabaseService ds = (DatabaseService)Naming.lookup( "rmi://" + address + service);
    	
    	//Connect
    	ds.Connect();
    	
    	//into values into the Database
    	ds.Create("INSERT INTO BOOKINGS (REG, MAKE, MODEL, NAME, ADDRESS) VALUES ('"+reg+"', '"+make+"', '"+model+"', '"+name+"', '"+address+"');");
    	ds.Create("INSERT INTO VEHICLES (REG, MAKE, MODEL, BOOKED) VALUES ('"+reg+"', '"+make+"', '"+model+"', '1');");
    	ds.Create("INSERT INTO CUSTOMERS (NAME, ADDRESS) VALUES ('"+name+"', '"+address+"');");
    	
    	//return the values needed
    	List<Object> rs = ds.ReadBookings("SELECT * FROM BOOKINGS");
    	
    	//Close the Connection
    	ds.Close();
    	
    	//Gson, used for converting to and from json
    	Gson gson = new Gson();
    	
    	//convert to json
        String jsonResp = gson.toJson(rs);
    	
        //return a response to a requester
        return Response.ok(jsonResp, MediaType.APPLICATION_JSON).build();
        
    }
    
    //Put used for updating values
    @SuppressWarnings("unused")
	@PUT
    @Path("/update") //path fpr updating when put request made
    @Consumes(MediaType.APPLICATION_JSON)//takes in json objects
    public Response update() throws RemoteException, MalformedURLException, NotBoundException, SQLException {
    	
    	String name = "";
    	String address = "";
    	
    	String reg = "";
    	String make = "";
    	String model = "";
    	
    	//Booking objects, used to make a booking.
    	Booking b = new Booking(new Vehicle(reg, make, model, true), new Customer(name, address));
    	
    	//Connect using RMI to Database Server
    	DatabaseService ds = (DatabaseService)Naming.lookup( "rmi://" + address + service);
    	
    	//Connect
    	ds.Connect();
    	
    	//update the database
    	ds.Update("UPDATE TABLE BOOKINGS ( MAKE, MODEL, NAME, ADDRESS) VALUES ('"+make+"', '"+model+"', '"+name+"', '"+address+"') WHERE REG="+reg+"; ");
    	
    	//return the values needed
    	List<Object> rs = ds.ReadBookings("SELECT * FROM BOOKINGS");
    	
    	//Close the Connection
    	ds.Close();
    	
    	//Gson, used to make convertions between and from json objects
    	Gson gson = new Gson();
    	
    	//convert to json
        String jsonResp = gson.toJson(rs);
    	
        //return a response to the caller
        return Response.ok(jsonResp, MediaType.APPLICATION_JSON).build();
    }
    
    @SuppressWarnings("unused")
	@DELETE
    @Path("/delete")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delete() throws RemoteException, MalformedURLException, NotBoundException, SQLException {
    	
    	String name = "";
    	String address = "";
    	
    	String reg = "";
    	String make = "";
    	String model = "";
    	
    	//new booking object, will be used to identify the data that will be deleted. not really needed
    	Booking b = new Booking(new Vehicle(reg, make, model, true), new Customer(name, address));
    	
    	//Connect using RMI to Database Server
    	DatabaseService ds = (DatabaseService)Naming.lookup( "rmi://" + address + service);
    	
    	//Connect
    	ds.Connect();
    
    	//delete entries from the tables in the database
    	ds.Delete("DELETE FROM BOOKINGS WHERE NAME ='"+name+"';");
    	ds.Update("UPDATE TABLE VEHICLES (BOOKED) VALUES ('0') WHERE REG="+reg+"; ");
    	
    	//return the values needed
    	List<Object> rs = ds.ReadBookings("SELECT * FROM BOOKINGS");
    	
    	//Close the Connection
    	ds.Close();
    	
    	//Gson
    	Gson gson = new Gson();
    	
    	//convert to json
        String jsonResp = gson.toJson(rs);
    	
        //respond to the requester
        return Response.ok(jsonResp, MediaType.APPLICATION_JSON).build();
        
    }
    
}
