package org.pritam.jdbc.topic_3h;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CallableStatement {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdb", "root", "9er$Y%F49yD4");
			java.sql.CallableStatement callableStatement = connection.prepareCall("call getSummeryByCity()");
			ResultSet resultSet = callableStatement.executeQuery();
			System.out.println("----RESULT SET-----");
			while(resultSet.next()) {
				System.out.println(resultSet.getString(1)+"====="+resultSet.getInt(2));
			}
			callableStatement.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		


	}

}
