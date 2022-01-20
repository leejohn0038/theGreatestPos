package project.database.receipts_DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import project.database.DBConnector;

public class Sales {
	
	public static Object[] getData(String gname) {
		String sql = "select gid, gname, gprice from goods where gname = ?";
		Object[] result = new Object[4];
		
		try (
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
		) {
			pstmt.setString(1, gname);
			
			try(ResultSet rs = pstmt.executeQuery();) {	
				while (rs.next()) {
					result[0] = rs.getObject("gid");
					result[1] = rs.getObject("gname");
					result[2] = (Object)(1);
					result[3] = rs.getObject("gprice");
				}	
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
