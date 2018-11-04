package ie.gmit.sw.service;

import java.rmi.*;
import java.rmi.server.*;

public class CustomerServiceImpl extends UnicastRemoteObject implements CustomerService {
	private static final long serialVersionUID = 1L;

	public CustomerServiceImpl() throws RemoteException{
		super();
	}


}
