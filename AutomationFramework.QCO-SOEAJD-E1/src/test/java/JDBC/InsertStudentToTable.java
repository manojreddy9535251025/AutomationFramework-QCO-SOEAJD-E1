package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class InsertStudentToTable {

	public static void main(String[] args) throws SQLException {
    
		// Register or Load the mysql database
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
		// get connection to the Database.
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/manojdb", "root", "Manoj@2001");
		
		//create statement 
		Statement stat = connection.createStatement();
		
		String query = "insert into student(first_name,last_name,adress)values('Sandeep','Kumar','Bangalore')";
		int result  = stat.executeUpdate(query);
		if (result == 1) {
			System.out.println("Data Updated");
		}
		else {
			System.out.println("Data not Updated");
		}
		connection.close();
		
	}

}
