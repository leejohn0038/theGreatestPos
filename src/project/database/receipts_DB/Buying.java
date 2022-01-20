package project.database.receipts_DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import project.actions.receipts_actions.Values;
import project.database.DBConnector;

public class Buying {
	public static void insertReceiptDatas(Values values) {
		String sql = "insert into receipts values(?, null, ?, ?, ?, ?, ?)";
		try (
				Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
			) {
				pstmt.setInt(1, values.rid);
				pstmt.setInt(2, values.price);
				pstmt.setString(3, values.payment);
				pstmt.setString(4, values.date);
				pstmt.setString(5, values.cardinfo);
				pstmt.setString(6, values.cashrcp);
				pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void updateSaleDatas(HashMap<Integer, String[]> sales, Values values) {
		String[] sqls = {"insert into sales values (?, ?, ? , ?, ?, ?)",
						 "update goods set gqty = gqty - ? where gname = ?"};
		
		try (
				Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt1 = conn.prepareStatement(sqls[0]);
				PreparedStatement pstmt2 = conn.prepareStatement(sqls[1]);
			) {
				for (int i = 0; i < sales.size(); ++i) {					
					int sid = getMaxId(1) > 0 ? getMaxId(1) + 1 : 1;
					pstmt1.setInt(1, sid);
					pstmt1.setInt(2, values.rid);
					pstmt1.setInt(3, getGid(sales.get(i)[0]));
					pstmt1.setInt(4, values.eid);
					pstmt1.setInt(5, Integer.parseInt(sales.get(i)[1]));
					pstmt1.setInt(6, Integer.parseInt(sales.get(i)[2]));
					pstmt2.setInt(1 , Integer.parseInt(sales.get(i)[1]));
					pstmt2.setString(2, sales.get(i)[0]);
					pstmt1.executeUpdate();				
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void updateGqty(HashMap<Integer, String[]> sales) {
		String sql = "update goods set gqty = gqty - ? where gname = ?";
		
		try (
				Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
			) {
				for (int i = 0; i < sales.size(); ++i) {	
					int gqty = Integer.parseInt(sales.get(i)[1]);
					String gname = sales.get(i)[0];
					pstmt.setInt(1 , gqty);
					pstmt.setString(2, gname);
									
					System.out.println(pstmt.executeUpdate());
				}
				pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
	
	public static int getMaxId(int index) {
		String[] sqls = {"select max(rid) from receipts", "select max(sid) from sales"};
		int rid = 0;
		try (
				Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sqls[index]);
				ResultSet rs = pstmt.executeQuery();
			) {
				rs.next();
				rid = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rid;
	}
	
	public static int getGid(String gName) {
		String sql = "select gid from goods where gname = ?";
		int gid = 0;
		try (
				Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
			) {
				pstmt.setString(1, gName);
				try(ResultSet rs = pstmt.executeQuery();) {					
					rs.next();
					gid = rs.getInt(1);
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return gid;
	}

}
