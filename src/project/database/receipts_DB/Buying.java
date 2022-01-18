package project.database.receipts_DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import project.database.DBConnector;

public class Buying {
	public static void insertReceiptDatas(int rid, int price, String date) {
		String sql = "insert into receipts values(?, null, ?, 'Çö±Ý', ?, null, null)";
		try (
				Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
			) {
				pstmt.setInt(1, rid);
				pstmt.setInt(2, price);
				pstmt.setString(3, date);
				pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void insertSaleDatas() {
		
	}
	
	public static int getMaxId() {
		String sql = "select max(rid) from receipts";
		int rid = 0;
		try (
				Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
			) {
				rs.next();
				rid = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rid;
	}

}
