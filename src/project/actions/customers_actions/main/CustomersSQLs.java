package project.actions.customers_actions.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomersSQLs {
	public CustomersSQLs() {
		String sql = "select * from customers";
		try (
				Connection conn = CustomersDBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
			) {
			System.out.println("EMPLOTEE_ID\tNAME\t"
					+ "HIRE_DATE\t\tTEL\t"
					+ "POSITION\n");
			while (rs.next()) {
				System.out.printf("%d\t\t%s\t\t%s\t\t%.2f\n",
						rs.getInt("phone"),
						rs.getString("customers_name"),
						rs.getDate("customers_address"),
						rs.getString("subscription_date"),
						rs.getString("membership_point"));
				//System.out.println(rs.getString("first_name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
