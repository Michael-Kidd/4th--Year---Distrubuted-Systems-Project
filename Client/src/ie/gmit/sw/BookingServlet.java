package ie.gmit.sw;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

@WebServlet("/Bookings")
public class BookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public BookingServlet() {
        super();
    }

    //call get requests from jax-rs
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Create a client
		Client client = Client.create();
		
		//Request a connection to the Jax rs service
		WebResource wr = client.resource("http://localhost:8080/WebService/webapi/bookinglist/get");
		//Get a response from the service
		String r = wr.accept(MediaType.APPLICATION_JSON).get(String.class);
	
		Gson gson=new Gson();
		
		//get the type of objects being read in
		Type listType = new TypeToken<ArrayList<Booking>>(){}.getType();
		
		//create a list of objects from a json response
		List<Booking> bookings = gson.fromJson(r, listType);

		//add the list of objects to the jsp file
        request.setAttribute("bookings", bookings);
        
        //show the jsp page
        request.getRequestDispatcher("/WEB-INF/Bookings.jsp").forward(request, response);

	}

	//post requests
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//if the rquest came from the delete button
		if (request.getParameter("delButton") != null) {
			
			System.out.println("DELETE");
			del(request, response);
            //call the delete method
			
        }
		//If the update button is pressed
		else if (request.getParameter("updateButton") != null) {
        	
        	System.out.println("PUT");
        	update(request, response);
        	//call the update method
        
        }
		//if the new booking button made the post request
		else if (request.getParameter("newBooking") != null) {
        	
        	System.out.println("POST");
        	add(request, response);
        	//call the add method
        
        }
		//call the get method, to show the list again
		doGet(request, response);
	}
	
	private void del(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Create a client
		Client client = Client.create();
		
		//Request a connection to the Jax rs service
		client.resource("http://localhost:8080/WebService/webapi/bookinglist/delete").delete();
        
	}
	
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Create a client
		Client client = Client.create();
		
		//Request a connection to the Jax rs service
		client.resource("http://localhost:8080/WebService/webapi/bookinglist/update").put();
        
		
	}
	
	@SuppressWarnings("unused")
	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Create a client
		Client client = Client.create();
		
		Customer c = new Customer(request.getParameter("name"), request.getParameter("address"));
		Vehicle v = new Vehicle(request.getParameter("reg"), request.getParameter("make"), request.getParameter("model"), true);
		Booking b = new Booking(v, c);
		
		//gson
		Gson gson=new Gson();
		
		//conert to json
		String json = gson.toJson(b);
		
		//Request a connection to the Jax rs service
		client.resource("http://localhost:8080/WebService/webapi/bookinglist/add").type(MediaType.APPLICATION_JSON).post();
		
	}
	
}
