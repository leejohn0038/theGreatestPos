package project.actions.employees_actions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JFrame;

import project.actions.employees_actions.main.DBConnector;
import project.actions.employees_actions.main.Employee;

public class SQLs {
	
	ArrayList<Employee> employees = new ArrayList<>();
	AddData addData;
	private int row;
	private String[] title;
	
	public SQLs(String type, JFrame f, AddData addData) {
		
		this.addData = addData;
		
		try (
				Connection conn = DBConnector.getConnection();
			) {
			
			switch (type) {
			case "등록":
				final String ADD_SQL = "INSERT into mart_employees VALUES ";
				add(ADD_SQL, conn);
				break;
			case "검색":
				break;
			case "리셋":
				final String RESET_SQL = "select * from mart_employees";
				tableReset(RESET_SQL, conn);
				break;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	void tableReset(String SQL, Connection conn) throws SQLException {
		
		PreparedStatement pstmt = conn.prepareStatement(SQL + " order by employee_id");
		ResultSet rs = pstmt.executeQuery();
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
					objs[col - 1] = "";
				}
			}
			employees.add(new Employee(objs));
		}
	}
	
	void setAddData(AddData addData) {
		this.addData = addData;
	}
	
	void add(String SQL, Connection conn) throws SQLException {
		String addSql = "(?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(SQL + addSql);
		ResultSet rs;
		
		System.out.println(addData.id);
		System.out.println(addData.name);
		System.out.println(addData.hire_data);
		System.out.println(addData.tel);
		System.out.println(addData.job);
		
		pstmt.setInt(1,addData.id);
		pstmt.setString(2, addData.name);
		pstmt.setDate(3, addData.hire_data);
		pstmt.setString(4,addData.tel);
		pstmt.setString(5,addData.job);
		
		System.out.println(1);
		
		rs = pstmt.executeQuery();
		
		//System.out.println(Arrays.toString(addData));
		System.out.println("수행완료");
	}
	
	/*
	ArrayList<Employee> getEmplotees() {
		return employees;
	}*/
	
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
	
	public int getEmp_id() {
		Object[][] rowData = getRowData();
		return Integer.parseInt(String.valueOf(rowData[rowData.length-1][0]))+1;
	}
}
