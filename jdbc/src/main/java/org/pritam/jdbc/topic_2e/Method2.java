package org.pritam.jdbc.topic_2e;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class Method2 
{
    public static void main( String[] args )
    {
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdb", "root", "9er$Y%F49yD4");
			System.out.println("Connection established");
			System.out.println("Connection :- "+connection);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    }
}
