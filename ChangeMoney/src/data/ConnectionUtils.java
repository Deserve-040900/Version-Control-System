package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {

	public static Connection getConnection() throws SQLException {
		Connection connection=null;
		try {
			String url="jdbc:mysql://localhost:3306/changemoney";
			String user="root";
			String password="";
			connection=DriverManager.getConnection(url,user,password);
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return connection;
	}
}