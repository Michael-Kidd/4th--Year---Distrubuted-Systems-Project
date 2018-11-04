package ie.gmit.sw;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import ie.gmit.sw.service.BookingService;

public class RMISetup {

	public static void main(String[] args) throws Exception {

		//Create an instance of a bookingServiceImpl. As BookingServiceImpl implements the bookingService
		//interface, it can be referred to as a service type.
		BookingService bs = new BookingServiceImpl();

		//Start the RMI registry on port 1099
		LocateRegistry.createRegistry(1099);

		//Bind our remote object to the registry with the human-readable name "bookingService"
		Naming.rebind("bookingService", bs);

		//Print a message to standard output
		System.out.println("Server ready.");

	}
}
