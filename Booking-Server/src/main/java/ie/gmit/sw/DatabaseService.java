package ie.gmit.sw;

import java.rmi.Remote;

public interface DatabaseService extends Remote{
	
	public void Connect();
	
	public void Create(String sql);
	
	public String Read(String sql);
	
	public void Update(String sql);
	
	public void Delete(String sql);
	
	public void Close();

}
