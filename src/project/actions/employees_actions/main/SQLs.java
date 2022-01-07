package project.actions.employees_actions.main;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class SQLs {
	
	ArrayList<Employee> employees = new ArrayList<>();
	private final String SQL = "select * from mart_employees";
	private int row;
	private String[] title;
	
	public SQLs(final String addSql) {
		
		try (
				Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SQL + " order by employee_id");
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
				row = objs.length;
				
				for(int col = 1; col<=meta.getColumnCount(); col++) {
					if(rs.getString(meta.getColumnName(col)) != null) {
						objs[col - 1] = rs.getObject(meta.getColumnName(col));	
					}else {
						objs[col - 1] = "null";
					}
				}
				employees.add(new Employee(objs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	ArrayList<Employee> getEmplotees() {
		return employees;
	}
	
	public String[] getTitle() {
		return title;
	}
	
	public Object[][] getRowData(){
		int col = employees.size();
		Object[][] rowData = new Object[col][row];
		
		for(int i = 0; i<col; i++) {
			for(int j=0; j<row; j++) {
				rowData[i] = employees.get(i).getDate();
			}
		}
		
		return rowData;
	}
}
