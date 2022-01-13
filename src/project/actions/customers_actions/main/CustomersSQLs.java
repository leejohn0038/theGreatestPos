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
			System.out.println("phone\tcustomers_name\t"
					+ "customers_address\t\tsubscription_date\t"
					+ "membership_point\n");
			while (rs.next()) {
				System.out.printf("%s\t\t%s\t\t%s\t\t%s\t\t%f\n",
						rs.getString("phone"),
						rs.getString("customers_name"),
						rs.getString("customers_address"),
						rs.getString("subscription_date"),
						rs.getDouble("membership_point"));
				//System.out.println(rs.getString("first_name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
