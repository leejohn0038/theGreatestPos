package project.components.goods_components;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LookupStatement {
	PreparedStatement pstmt;
	
	public PreparedStatement goodsStatment(String sql) {
			
		try (
			Connection conn = PosDBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
		) {
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pstmt;
	}
}
