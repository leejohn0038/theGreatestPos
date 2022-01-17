package project.database.receipts_DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import project.database.DBConnector;

public class ReceiptSearching {
	
	private static final String SQL = 
			"SELECT * FROM receipts WHERE rid BETWEEN ? AND ? "
					+ "AND price BETWEEN ? AND ? "
					+ "AND period BETWEEN ? AND ? ";
	
	private static final String PHONE_QUERY = "AND phone BETWEEN ? AND ? ";
	private static final String PAYMENT_QUERY = "AND payment = ?";
	
	
	public static ArrayList<Object[]> getData(String[] sqls, boolean isEmpty) {
		
		ArrayList<Object[]> results = new ArrayList<>();
		Object[] result;
		String sql = SQL;
		sql = !isEmpty ? sql += PHONE_QUERY : sql;
		sql = !sqls[8].equals("전체") ? sql += PAYMENT_QUERY : sql;
		try (
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
		) {
				pstmt.setInt(1, Integer.parseInt(sqls[0]));
				pstmt.setInt(2, Integer.parseInt(sqls[1]));
				pstmt.setInt(3, Integer.parseInt(sqls[4]));
				pstmt.setInt(4, Integer.parseInt(sqls[5]));
				pstmt.setString(5, sqls[6]);
				pstmt.setString(6, sqls[7]);
				
				if(isEmpty && !sqls[8].equals("전체")) {
					pstmt.setString(7, sqls[8]);
				} else if (!isEmpty && sqls[8].equals("전체")) {
					pstmt.setString(7, sqls[2]);
					pstmt.setString(8, sqls[3]);
				} else if (!isEmpty && !sqls[8].equals("전체")) {
					pstmt.setString(7, sqls[3]);
					pstmt.setString(8, sqls[4]);
					pstmt.setString(9, sqls[8]);
				}
			
			try(ResultSet rs = pstmt.executeQuery();) {	
				while (rs.next()) {
					result = new Object[5];
					result[0] = rs.getObject("rid");
					result[1] = rs.getObject("phone");
					result[2] = rs.getObject("price");
					result[3] = rs.getObject("payment");
					result[4] = rs.getObject("period");
					results.add(result);
				}	
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		sql = SQL;
		return results;
	}
}
