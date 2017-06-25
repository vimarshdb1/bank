package utility;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class Dao {
	 private static String url = "jdbc:mysql://localhost:3306/form";    
	    private static String driverName = "com.mysql.jdbc.Driver";   
	    private static String username = "root";   
	    private static String password = "vd123456";
	    private static Connection con;
	    private static String urlstring;
	    static String x;
	    
	    public static void setId(String a)
	    {
	    	x=a;
	    }
	    public static String getId()
	    {
	    	return x;
	    
	    }

	    public static Connection getConnection() {
	        try {
	            Class.forName(driverName);
	            try {
	                con = (Connection) DriverManager.getConnection(url,username,password);
	            } catch (SQLException ex) {
	                // log an exception. fro example:
	                System.out.println("Failed to create the database connection."); 
	            }
	        } catch (ClassNotFoundException ex) {
	            // log an exception. for example:
	            System.out.println("Driver not found."); 
	        }
	        return con;
	    }
}
