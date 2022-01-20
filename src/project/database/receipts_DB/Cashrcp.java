package project.database.receipts_DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import project.database.DBConnector;

public class Cashrcp {
	private static int rid;
	
	public static String getCashrcp(int rid) {
		String sql = "select cashrcp from receipts where rid = ?";
		StringBuilder cashrcp = new StringBuilder();
		try (
				Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
			) {
				pstmt.setInt(1, rid);
				Cashrcp.rid = rid;
				try (ResultSet rs = pstmt.executeQuery()) {
					rs.next();
					cashrcp.append(rs.getString("cashrcp"));
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cashrcp.toString();
	}
	
	public static void updateCashrcp() {
		String sql = "update receipts set cashrcp = 'true' where rid = ?";
		
		try (
				Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
			) {
				pstmt.setInt(1, rid);
				pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
