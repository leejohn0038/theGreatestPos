package project.database.receipts_DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import project.database.DBConnector;

public class Refund {
	
	private static final String SQL = "select sid, sal.rid, sal.price, gname, qty, payment from sales sal "
									+ "inner join goods using(gid) inner join receipts r on sal.rid = r.rid "
									+ "where r.rid = ?";
	
	public static ArrayList<Object[]> getData(int rid) {
		ArrayList<Object[]> results = new ArrayList<>();
		Object[] result;
		try (
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SQL);
		) {
				pstmt.setInt(1, rid);
			
			try(ResultSet rs = pstmt.executeQuery();) {	
				while (rs.next()) {
					result = new Object[6];
					result[0] = rs.getObject("sid");
					result[1] = rs.getObject("rid");
					result[2] = rs.getObject("gname");
					result[3] = rs.getObject("price");
					result[4] = rs.getObject("qty");
					result[5] = rs.getObject("payment");
					results.add(result);
				}	
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return results;
	}
}
