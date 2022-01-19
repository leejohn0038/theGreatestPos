package project.database.receipts_DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import project.database.DBConnector;

public class PointCollecting {
	public static boolean updateData(int point, int rid, String phone) {
		String sql1 = "update customers set 포인트 = 포인트 + ? where 전화번호 = ?";
		String sql2 = "update receipts set phone = ? where rid = ?";
		try (
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt1 = conn.prepareStatement(sql1);
			PreparedStatement pstmt2 = conn.prepareStatement(sql2);
		) {
			pstmt1.setInt(1, point);
			pstmt1.setString(2, phone);
			pstmt2.setString(1, phone);
			pstmt2.setInt(2, rid);
			if(pstmt1.executeUpdate() == 0) {
				return false;
			} else {				
				pstmt2.executeUpdate();
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
