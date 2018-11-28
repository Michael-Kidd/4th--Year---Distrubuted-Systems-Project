package ie.gmit.sw;

import java.rmi.*;
import java.rmi.server.*;

public class DatabaseServiceImpl extends UnicastRemoteObject implements DatabaseService {
	private static final long serialVersionUID = 1L;

	public DatabaseServiceImpl() throws RemoteException{
		super();
	}

}
