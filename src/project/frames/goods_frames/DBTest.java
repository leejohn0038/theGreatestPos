package project.frames.goods_frames;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import project.components.goods_components.PosDBConnector;

public class DBTest {

	public static void main(String[] args) {
		try (
			Connection conn = PosDBConnector.getConnection();		
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM goods");
			ResultSet rs = pstmt.executeQuery();
		) {
			while (rs.next()) {
				System.out.println(rs.getString("gname"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
