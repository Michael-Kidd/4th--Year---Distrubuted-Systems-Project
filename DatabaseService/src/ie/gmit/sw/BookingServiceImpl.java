package ie.gmit.sw;

import java.rmi.*;
import java.rmi.server.*;

import ie.gmit.sw.service.BookingService;

public class BookingServiceImpl extends UnicastRemoteObject implements BookingService {
	private static final long serialVersionUID = 1L;

	public BookingServiceImpl() throws RemoteException{
		super();
	}


}
