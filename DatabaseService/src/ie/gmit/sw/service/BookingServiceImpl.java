package ie.gmit.sw.service;

import java.rmi.*;
import java.rmi.server.*;

public class BookingServiceImpl extends UnicastRemoteObject implements BookingService {
	private static final long serialVersionUID = 1L;

	public BookingServiceImpl() throws RemoteException{
		super();
	}


}
