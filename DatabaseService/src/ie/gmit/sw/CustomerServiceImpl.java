package ie.gmit.sw;

import java.rmi.*;
import java.rmi.server.*;

import ie.gmit.sw.service.CustomerService;

public class CustomerServiceImpl extends UnicastRemoteObject implements CustomerService {
	private static final long serialVersionUID = 1L;

	public CustomerServiceImpl() throws RemoteException{
		super();
	}


}
