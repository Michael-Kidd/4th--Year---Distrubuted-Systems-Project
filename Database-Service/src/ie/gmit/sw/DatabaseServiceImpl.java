package ie.gmit.sw;

import java.rmi.*;
import java.rmi.server.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseServiceImpl extends UnicastRemoteObject implements DatabaseService {
	private static final long serialVersionUID = 1L;
	
	// JDBC driver name and database URL 
	private static final String JDBC_DRIVER = "org.h2.Driver";   
   	private static final String DB_URL = "jdbc:h2:~/BookingServiceDB";

	private Connection conn = null;
	
	public DatabaseServiceImpl() throws RemoteException{
		super();
	}

	public void Connect() {
		
		try {
			
			Class.forName (JDBC_DRIVER);
		
			this.conn = DriverManager.getConnection (DB_URL, "","");
			
			System.out.println("Client Accessing Database");
			
		} catch (ClassNotFoundException e) {
			
			System.out.println("Failed to Connect");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
	}
	
	public void Create(String sql) {
		
		try {
			
			Statement stmt = this.conn.createStatement();
			
			stmt.execute(sql);
			
		} catch (SQLException e) {
		}
		
	}
	
	public List<Object> Read(String sql) {
		
		ResultSet rs = null;
		
    	//New List to return
    	ArrayList<Object> list = new ArrayList<>();
		
		try {
			
			Statement stmt = this.conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				Customer c = new Customer(rs.getString(1));
				
				list.add(c);
			} 
			
		} catch (SQLException e) {
			
		}
		
		return list;
	}
	
	public void Update(String sql) {
		
		try {
			
			Statement stmt = this.conn.createStatement();
			
			stmt.execute(sql);
			
		} catch (SQLException e) {
		}
		
	}
	
	public void Delete(String sql) {
		
		try {
			Statement stmt = this.conn.createStatement();
			stmt.execute(sql);
		} catch (SQLException e) {
			System.out.println("SQL Error");
		}
		
	}
	
	public void Close() {
		
		try {
			this.conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void createTables(Connection conn) {
		
		Statement stmt;
		
		try {
			
			stmt = conn.createStatement();
			
			CreateBookingsTable(stmt);
			CreateVehiclesTable(stmt);
			CreateCustomersTable(stmt);
			
		} catch (SQLException e) {
			
			System.out.println("SQL Error");
		
		}
		
	}
	
	// Only need these while creating the tables, wont be used in the live program //
	// Also will not be included in the interface //
	private static void CreateBookingsTable(Statement stmt) {
		
		String sql =  "CREATE TABLE BOOKINGS "+
				 "(MODEL VARCHAR(255) not NULL, "+
				 "MAKE VARCHAR(255) not NULL,"+ 
				 "NAME VARCHAR(255) not NULL, "+ 
				 " PRIMARY KEY ( NAME ))";
		
		try {
			stmt.execute(sql);
		} catch (SQLException e) {
			System.out.println(e);
		}
		
	}
	
	private static void CreateVehiclesTable(Statement stmt) {
		
		String sql =  "CREATE TABLE VEHICLES"+
				 "(MODEL VARCHAR(255) not NULL, "+
				 "MAKE VARCHAR(255) not NULL,"+
				 " PRIMARY KEY (MODEL))";
		
		try {
			stmt.execute(sql);
		} catch (SQLException e) {
			System.out.println(e);
		}
		
	}
	
	private static void CreateCustomersTable(Statement stmt) {
		
		String sql =  "CREATE TABLE CUSTOMERS"+
				 "(NAME VARCHAR(255) not NULL, "+
				 " PRIMARY KEY (NAME))";
		
		try {
			
			stmt.execute(sql);
			sql =  "INSERT INTO CUSTOMERS (NAME) VALUES ('Mike');";
			stmt.execute(sql);
			sql =  "INSERT INTO CUSTOMERS (NAME) VALUES ('John');";
			stmt.execute(sql);
			sql =  "INSERT INTO CUSTOMERS (NAME) VALUES ('Ray');";
			stmt.execute(sql);
			sql =  "INSERT INTO CUSTOMERS (NAME) VALUES ('Kevin');";
			stmt.execute(sql);

		} catch (SQLException e) {
			System.out.println(e);
		}
		
	}

}
