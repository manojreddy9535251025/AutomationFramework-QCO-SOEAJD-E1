package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver; 

public class FetchData {

	public static void main(String[] args) throws SQLException {
	     // step 1 : Register driver
		 Driver driverRef = new Driver();
	      DriverManager.registerDriver(driverRef);
		
		//connection to database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/manojdb", "root", "Manoj@2001");
		
		//create a statement
		Statement stat = con.createStatement();
		String query = "select * from student";
		
		//Execute query
		ResultSet result = stat.executeQuery(query);
		while (result.next()) {
			System.out.println(result.getInt(1)+"\t"+result.getString(2)+"\t"+ result.getString(3)+"\t"+result.getString(4));
		}
		System.out.println("Query Executed");
		
		// close the connection
		con.close();
		
	}

}
