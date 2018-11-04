package ie.gmit.sw;

import java.rmi.*;
import java.rmi.server.*;

import ie.gmit.sw.service.VehicleService;

public class VehicleServiceImpl extends UnicastRemoteObject implements VehicleService {
	private static final long serialVersionUID = 1L;

	public VehicleServiceImpl() throws RemoteException{
		super();
	}


}
