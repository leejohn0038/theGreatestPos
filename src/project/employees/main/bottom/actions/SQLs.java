package project.employees.main.bottom.actions;

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
			System.out.println("EMPL\tfirst_name\t"
					+ "job_id\t\tsalary\n");
			while (rs.next()) {
				System.out.printf("%d\t\t%s\t\t%s\t\t%.2f\n",
						rs.getInt("employee_id"),
						rs.getString("first_name"),
						rs.getString("job_id"),
						rs.getDouble("salary"));
				//System.out.println(rs.getString("first_name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
