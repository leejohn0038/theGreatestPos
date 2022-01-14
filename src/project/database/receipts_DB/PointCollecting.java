package project.database.receipts_DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import project.database.DBConnector;

public class PointCollecting {
	public static void getData(int point, int rid, String phone) {
		String sql1 = "update customers set membership_point = membership_point + ? where phone = ?";
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
			pstmt1.executeUpdate();
			pstmt2.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
