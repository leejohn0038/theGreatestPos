package project.database.receipts_DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import project.actions.receipts_actions.Values;
import project.database.DBConnector;

public class Buying {
	public static void insertReceiptDatas(Values values) {
		String sql = "insert into receipts values(?, null, ?, ?, ?, ?, null)";
		try (
				Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
			) {
				pstmt.setInt(1, values.id);
				pstmt.setInt(2, values.price);
				pstmt.setString(3, values.payment);
				pstmt.setString(4, values.date);
				pstmt.setString(5, values.cardinfo);
				pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void insertSaleDatas() {
		
	}
	
	public static int getGqty(String gName) {
		String sql = "select gqty from goods where gname  = ?";
		int gqty = 0;
		try (
				Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
			) {
				pstmt.setString(1, gName);
				try(ResultSet rs = pstmt.executeQuery();) {					
					rs.next();
					gqty = rs.getInt(1);
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return gqty;
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
