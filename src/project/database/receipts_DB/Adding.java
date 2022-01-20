package project.database.receipts_DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JTextField;

import project.database.DBConnector;

public class Adding {
	
	public static boolean insertCustomer(JTextField[] fields, String date) {
		String sql = "insert into customers values (?, ?, ?, ?, 0)";
		try (
				Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
			) {
				pstmt.setString(1, fields[1].getText());
				pstmt.setString(2, fields[0].getText());
				pstmt.setString(3, fields[2].getText());
				pstmt.setString(4, date);
				pstmt.executeUpdate();
				return true;
		} catch (SQLException e) {
			return false;
		}
	}
}
