package ie.gmit.sw;

import java.rmi.Naming;

import ie.gmit.sw.service.BookingService;

public class Client {

	public static void main(String[] args) throws Exception {

		BookingService fs = (BookingService) Naming.lookup("rmi://127.0.0.1:1099/fileService");

	}

}
