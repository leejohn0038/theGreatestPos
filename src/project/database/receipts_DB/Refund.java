package project.database.receipts_DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import project.database.DBConnector;

public class Refund {
	
	private final static String[] SQLS = {
			"update goods set gqty = gqty - ? where gname = ?",
   		    "update customers set 포인트 = 포인트 - ? where 전화번호 = ?",
   		    "update receipts set price = price - ? where rid = ?",
   		    "delete from sales where sid = ?",
   		    "delete from receipts where rid = ?",
   		    "select sid, sal.rid, sal.price, gname, qty, payment from sales sal "
			+ "inner join goods using(gid) inner join receipts r on sal.rid = r.rid "
			+ "where r.rid = ?"
			};
	
	public static ArrayList<Object[]> getData(int rid) {
		
		ArrayList<Object[]> results = new ArrayList<>();
		Object[] result;
		try (
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SQLS[5]);
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
	
	public static void deleteSalesRows(int id, int index) {
		try (
				Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SQLS[index]);
			) {
					pstmt.setInt(1, id);
					pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	
	public static void updateData(int index, int number, String varchar, boolean isNumber) {
		try (
				Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SQLS[index]);
			) {
				if (isNumber) {
					pstmt.setInt(1, number);
					pstmt.setInt(2, Integer.parseInt(varchar));
				} else {						
					pstmt.setInt(1, number);
					pstmt.setString(2, varchar);
				}
				pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} 
}
