package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JJ_OjdbcConnection {
	
	// 원래 private이었음.
	public static String driver = "oracle.jdbc.driver.OracleDriver";
	public static String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	public static String id = "hr";
	public static String password = "1234";
	
	
	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		try {
		return DriverManager.getConnection(url, id, password);
		} catch (SQLException e) {
			System.out.println("ojdbc getConnection() error");
			return null;
		}
	}
}
