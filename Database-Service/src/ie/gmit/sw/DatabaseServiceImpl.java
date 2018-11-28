package ie.gmit.sw;

import java.rmi.*;
import java.rmi.server.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseServiceImpl extends UnicastRemoteObject implements DatabaseService {
	private static final long serialVersionUID = 1L;
	
	// JDBC driver name and database URL 
	private static final String JDBC_DRIVER = "org.h2.Driver";   
   	private static final String DB_URL = "jdbc:h2:~/BookingServiceDB";

	private static Connection conn = null;
	
	
	public DatabaseServiceImpl() throws RemoteException{
		super();
	}

	public void Connect() {
		
		try {
			
			Class.forName (JDBC_DRIVER);
		
			conn = DriverManager.getConnection (DB_URL, "","");
			
			System.out.println("Connected to H2 Database");
				

		} catch (ClassNotFoundException e) {
			
			System.out.println("Failed to Connect");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
	}
	
	public void Create(String sql) {
		
		try {
			
			Statement stmt = conn.createStatement();
			
			stmt.execute(sql);
			
		} catch (SQLException e) {
		}
		
	}
	
	public String Read(String sql) {
		
		try {
			
			Statement stmt = conn.createStatement();
			
			stmt.execute(sql);
			
		} catch (SQLException e) {
		}
		
		return "TEST";
	}
	
	public void Update(String sql) {
		
		try {
			
			Statement stmt = conn.createStatement();
			
			stmt.execute(sql);
			
		} catch (SQLException e) {
		}
		
	}
	
	public void Delete(String sql) {
		
		try {
			
			Statement stmt = conn.createStatement();
			
			stmt.execute(sql);
			
		} catch (SQLException e) {
		}
		
	}
	
	public void Close() {
		
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	// Only need these while creating the tables, wont be used in the live program //
	// Also will not be included in the interface //
	
	public static void CreateBookingsTable(Statement stmt) {
		
		String sql =  "CREATE TABLE BOOKINGS " +
				 "(MODEL VARCHAR(255) not NULL, "	+
				 "MAKE VARCHAR(255) not NULL,"	+ 
				 "NAME VARCHAR(255) not NULL, " + 
				 " PRIMARY KEY ( NAME ))";
		
		try {
			
			stmt.execute(sql);
			
		} catch (SQLException e) {
		}
		
	}
	
	public static void CreateVehiclesTable(Statement stmt) {
		
		String sql =  "CREATE TABLE VEHICLES" +
				 "(MODEL VARCHAR(255) not NULL, " +
				 "MAKE VARCHAR(255) not NULL,"	+
				 " PRIMARY KEY (MODEL))";
		
		try {
			
			stmt.execute(sql);
			
		} catch (SQLException e) {
		}
		
	}
	
	public static void CreateCustomersTable(Statement stmt) {
		
		String sql =  "CREATE TABLE CUSTOMERS" +
				 "(NAME VARCHAR(255) not NULL, " +
				 " PRIMARY KEY (NAME))";
		
		try {
			
			stmt.execute(sql);
			
		} catch (SQLException e) {
		}
		
	}
}
