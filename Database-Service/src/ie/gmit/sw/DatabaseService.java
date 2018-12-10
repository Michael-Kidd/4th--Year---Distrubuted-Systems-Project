package ie.gmit.sw;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/*
 * An RMI interface that invokes methods for dealing with a database
 * the database should consist of Customer, Vehicle and Booking Tables
 * 
 * */

public interface DatabaseService extends Remote{
	
	//For connecting to the database
	public void Connect() throws RemoteException;
	
	//for creating tables or making general queries
	public void Create(String sql) throws RemoteException;
	
	//for retriving a list of all customers
	public List<Object> ReadCustomers(String sql) throws RemoteException;
	
	//for retriving a list of all vehicles
	public List<Object> ReadVehicles(String sql) throws RemoteException;

	//for retriving a list of all bookings
	public List<Object> ReadBookings(String sql) throws RemoteException;
	
	//for updating values in the database
	public void Update(String sql) throws RemoteException;
	
	//for deleting values in the database
	public void Delete(String sql) throws RemoteException;
	
	//for closing the connection
	public void Close() throws RemoteException;

}
