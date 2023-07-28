package org.pritam.jdbc.topic_3g;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Statement {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdb", "root", "9er$Y%F49yD4");

			//Insert via statement
			String insertQuery = "insert into customers(CustomerName,ContactName,Address,City,PostalCode,Country) values('Aditya Ghosh','Sudipta Ghosh','Ghola Kachary Road','Kolkata','700124','India')";
			java.sql.Statement statement = connection.createStatement();
			int count = statement.executeUpdate(insertQuery);
			System.out.println("Inserted "+count+" rows.");
			
			//Update via statement
			String updateQuery = "update customers set country='Pakistan' where country='Mexico'";
			count = statement.executeUpdate(updateQuery);
			System.out.println("Updated "+count+" rows.");
			
			//Delete via statement
			String deleteQuery = "delete from customers where country='Germany'";
			count = statement.executeUpdate(deleteQuery);
			System.out.println("Deleted "+count+" rows.");
			
			//Select via statement
			String selectQuery="select * from customers where Country='UK'";
			ResultSet resultSet = statement.executeQuery(selectQuery);
			System.out.println("----RESULT SET-----");
			while(resultSet.next()) {
				System.out.println(resultSet.getString("CustomerName"));
			}
			
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
