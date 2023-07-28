package org.pritam.jdbc.topic_3g;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PrepareStatement {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdb", "root", "9er$Y%F49yD4");

			//Insert via Prepare statement
			String insertQuery = "insert into customers(CustomerName,ContactName,Address,City,PostalCode,Country) values(?,?,?,?,?,?)";
			PreparedStatement prepareStatement = connection.prepareStatement(insertQuery);
			prepareStatement.setString(1, "Aditya Ghosh");
			prepareStatement.setString(2, "Sudipta Ghosh");
			prepareStatement.setString(3, "Ghola Kachary Road");
			prepareStatement.setString(4, "Kolkata");
			prepareStatement.setString(5, "700124");
			prepareStatement.setString(6, "India");
			int count = prepareStatement.executeUpdate();
			System.out.println("Inserted "+count+" rows.");

			//Update via statement
			String updateQuery = "update customers set country=? where country=?";
			prepareStatement = connection.prepareStatement(updateQuery);
			prepareStatement.setString(1, "Pakistan");
			prepareStatement.setString(2, "Mexico");
			count = prepareStatement.executeUpdate();
			System.out.println("Updated "+count+" rows.");

			//Delete via statement
			String deleteQuery = "delete from customers where country=?";
			prepareStatement = connection.prepareStatement(deleteQuery);
			prepareStatement.setString(1, "Germany");
			count = prepareStatement.executeUpdate();
			System.out.println("Deleted "+count+" rows.");

			//Select via statement
			String selectQuery="select * from customers where country = ?";
			prepareStatement = connection.prepareStatement(selectQuery);
			prepareStatement.setString(1, "UK");
			ResultSet resultSet = prepareStatement.executeQuery();
			System.out.println("----RESULT SET-----");
			while(resultSet.next()) {
				System.out.println(resultSet.getString("CustomerName"));
			}
			
			prepareStatement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
