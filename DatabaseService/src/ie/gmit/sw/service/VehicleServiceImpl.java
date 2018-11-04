package ie.gmit.sw.service;

import java.rmi.*;
import java.rmi.server.*;

public class VehicleServiceImpl extends UnicastRemoteObject implements VehicleService {
	private static final long serialVersionUID = 1L;

	public VehicleServiceImpl() throws RemoteException{
		super();
	}


}
