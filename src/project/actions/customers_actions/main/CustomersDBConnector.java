package project.actions.customers_actions.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import project.actions.customers_actions.CustomersSQLs;

public class CustomersDBConnector {
	
	private static String driverName = "oracle.jdbc.driver.OracleDriver";
	private static String url = "jdbc:oracle:thin:@59.9.112.194:1521/XE";
	private static String user_id = "pch";
	private static String user_pass = "1234";
	
	static {
		try {
			Class.forName(driverName);
			System.out.println("����Ŭ JDBC ����̺� ���� ����");
		}catch (Exception e) {
			System.out.println("����Ŭ JDBC ����̺� ���� ����");
		}
	}
	
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url,user_id,user_pass);
	}
	
	/*
	public static PreparedStatement allFruits(String table) {
		return 
	}*/

}