package ie.gmit.sw;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

    // static variable of type Singleton
    private static DBConnector DBCInstance = null;
    private static Driver myDriver = new oracle.jdbc.driver.OracleDriver();

	DBConnector(){
		
		try {
		   
			DriverManager.registerDriver( myDriver );
		   
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
    // static method to create instance of Singleton class
    public static DBConnector getInstance()
    {
        if (DBCInstance == null)
        	DBCInstance = new DBConnector();
  
        return DBCInstance;
    }
    
	public static Driver getMyDriver() {
		return myDriver;
	}
	
}
