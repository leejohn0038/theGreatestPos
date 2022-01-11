package project.database.receipts_DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import project.database.DBConnector;

public class ReceiptSearching {
	
	public static Object[] getData(String[] sqls) {
		String sql = String.format("SELECT * FROM receipts WHERE rid BETWEEN %d AND %d "
				+ "AND phone BETWEEN %s AND %s "
				+ "AND price BETWEEN %d AND %d "
				+ "AND payment IN ( %s ) "
				+ "AND period BETWEEN %s AND %s", 
				Integer.parseInt(sqls[0]), Integer.parseInt(sqls[1]), sqls[2], sqls[3], 
				Integer.parseInt(sqls[4]), Integer.parseInt(sqls[5]),
				sqls[6], sqls[7], sqls[8]);
		Object[] result = new Object[5];
		try (
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
		) {
			while (rs.next()) {
				result[0] = rs.getObject("rid");
				result[1] = rs.getObject("phone");
				result[2] = rs.getObject("price");
				result[3] = rs.getObject("payment");
				result[4] = rs.getObject("period");
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
