package project.components.goods_components;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PosDBConnector {

	private static String driverName = "oracle.jdbc.driver.OracleDriver";
	private static String url = "jdbc:oracle:thin:@59.9.112.194:1521:XE";
	private static String user = "pch";
	private static String password = "1234";
	
	static {
		try {
			Class.forName(driverName);
			System.out.println("driver loaded");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}
}
