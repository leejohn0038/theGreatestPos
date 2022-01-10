package project.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

public class DBConnector {
	private static String driverName = "oracle.jdbc.driver.OracleDriver";
	private static String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private static String user = "hr";
	private static String password = "1234";
	
	static {
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}
	
	public static Object[] getData() {
		String sql = "select rid, eid, gid, qty, price  from receipt";
		Object[] result = new Object[5];
		try (
			Connection conn = DriverManager.getConnection(url, user, password);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
		) {
			while (rs.next()) {
				result[0] = rs.getObject("rid");
				result[1] = rs.getObject("eid");
				result[2] = rs.getObject("gid");
				result[3] = rs.getObject("qty");
				result[4] = rs.getObject("price");
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
