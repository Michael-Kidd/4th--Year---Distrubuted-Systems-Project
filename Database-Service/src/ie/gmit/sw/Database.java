package ie.gmit.sw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database
{
	
	// JDBC driver name and database URL 
	private static final String JDBC_DRIVER = "org.h2.Driver";   
   	private static final String DB_URL = "jdbc:h2:~/BookingServiceDB";

	private static Connection conn = null;
	
	public static void main(String[] args) {
		
		try {
			
			Class.forName (JDBC_DRIVER);
		
			conn = DriverManager.getConnection (DB_URL, "",""); 
			
			System.out.println("Connected to H2 Database");
				
			@SuppressWarnings("unused")
			Statement stmt = conn.createStatement();

			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}finally {
			
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} 
			
		}
		
	}
	
	// Only need these while creating the tables, wont be used in the live program //
	
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