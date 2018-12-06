package ie.gmit.sw;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

@WebServlet("/Customers")
public class ClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ClientServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Create a client
		Client client = Client.create();
		
		//Request a connection to the Jax rs service
		WebResource wr = client.resource("http://localhost:8080/WebService/webapi/myresource/get");
		
		//Get a response from the service
		ClientResponse r = wr.accept("text/html").get(ClientResponse.class);
		
		//get the status of the response - if status = 200 we are connected and response should return
		if(r.getStatus() == 200) {
			
			System.out.println("Response");
			
		}
		else {
			
			System.out.println("Failed");
			
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}
}
