package org.pritam.jdbc.topic_2g;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class DataBaseMetaData 
{
    public static void main( String[] args )
    {
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdb", "root", "9er$Y%F49yD4");
			DatabaseMetaData metaData = connection.getMetaData();
			System.out.println("Database Product Name :- "+metaData.getDatabaseProductName());
			System.out.println("Database Product Version :- "+metaData.getDatabaseProductVersion());
			System.out.println("Database User Name :- "+metaData.getUserName());
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    }
}
