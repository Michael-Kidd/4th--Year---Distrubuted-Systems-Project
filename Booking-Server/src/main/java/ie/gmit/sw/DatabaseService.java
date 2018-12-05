package ie.gmit.sw;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface DatabaseService extends Remote{
	
	public void Connect() throws RemoteException;
	
	public void Create(String sql) throws RemoteException;
	
	public String Read(String sql) throws RemoteException;
	
	public void Update(String sql) throws RemoteException;
	
	public void Delete(String sql) throws RemoteException;
	
	public void Close() throws RemoteException;

}
