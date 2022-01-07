package project.actions.employees_actions.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

public class SQLs {
	public SQLs(String sql) {
		sql = "select * from mart_employees";
		ArrayList<Employee> employees = new ArrayList<>();
		String[] title;
		try (
				Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
			) {
			ResultSetMetaData meta = rs.getMetaData();
			
			title = new String[meta.getColumnCount()];
			
			for(int i = 0; i<title.length; i++) {
				title[i] =meta.getColumnName(i+1);
				//System.out.println(title[i]);
			}
			
			
			while(rs.next()) {		
				
				Object[] objs = new Object[meta.getColumnCount()];
				
				for(int col = 1; col<=meta.getColumnCount(); col++) {
					if(rs.getString(meta.getColumnName(col)) != null) {
						objs[col - 1] = rs.getObject(meta.getColumnName(col));	
					}else {
						objs[col - 1] = "null";
					}
					
					System.out.print(objs[col-1]);
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(0);
		}
	}
}
