package project.actions.customers_actions.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomersDBConnector {
	
	private static String driverName = "oracle.jdbc.driver.OracleDriver";
	private static String url = "jdbc:oracle:thin:@59.9.112.194:1521:XE";
	private static String user = "pch";
	private static String password = "1234";
	
	static {
		try {
			Class.forName(driverName);
			System.out.println("오라클 JDBC 드라이브 연결 성공");
		}catch (Exception e) {
			System.out.println("오라클 JDBC 드라이브 연결 오류");
		}
	}
	
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url,user,password);
	}
	
	/*
	public static PreparedStatement allFruits(String table) {
		return 
	}*/
	public static void main(String[] args) {
		
		new CustomersSQLs();
	}
}
