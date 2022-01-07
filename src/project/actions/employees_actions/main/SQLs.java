package project.actions.employees_actions.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLs {
	public SQLs() {
		String sql = "select * from mart_employees";
		try (
				Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
			) {
			System.out.println("EMPLOTEE_ID\tNAME\t"
					+ "HIRE_DATE\t\tTEL\t"
					+ "POSITION\n");
			while (rs.next()) {
				System.out.printf("%d\t\t%s\t\t%s\t\t%.2f\n",
						rs.getInt("employee_id"),
						rs.getString("name"),
						rs.getDate("hire_date"),
						rs.getString("tel"),
						rs.getString("position"));
				//System.out.println(rs.getString("first_name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
