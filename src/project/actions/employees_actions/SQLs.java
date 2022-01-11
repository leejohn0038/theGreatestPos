package project.actions.employees_actions;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import java.util.ArrayList;


import javax.swing.JFrame;
import javax.xml.crypto.Data;

import project.actions.employees_actions.main.DBConnector;
import project.actions.employees_actions.main.object.AddData;
import project.actions.employees_actions.main.object.Employee;

public class SQLs {
	
	ArrayList<Employee> employees = new ArrayList<>();
	AddData addData;
	private int row;
	private int col;
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
			case "수정":
				final String UPDATA_SQL = "UPDATE mart_employees ";
				updata(UPDATA_SQL, conn);
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
		
		pstmt.close();
		rs.close();
	}
	
	void setAddData(AddData addData) {
		this.addData = addData;
	}
	
	void updata(String SQL, Connection conn) throws SQLException {
		final String ADD_SQL = "SET name = ?, hire_date = ?, "
				+ "tel = ?, position = ? WHERE employee_id = ?";
		PreparedStatement pstmt = conn.prepareStatement(SQL + ADD_SQL);
		ResultSet rs;
		Object[] datas = addData.getDates();
		
		pstmt.setString(1, (String) datas[1]);
		pstmt.setDate(2, (Date)datas[2]);
		pstmt.setString(3,(String) datas[3]);
		pstmt.setString(4,(String) datas[4]);
		pstmt.setInt(5,(int)datas[0]);
		
		rs = pstmt.executeQuery();
		
		pstmt.close();
		rs.close();
		
	}
	
	void add(String SQL, Connection conn) throws SQLException {
		final String addSql = "(?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(SQL + addSql);
		ResultSet rs;
		Object[] datas = addData.getDates();
		
		pstmt.setInt(1,(int)datas[0]);
		pstmt.setString(2, (String) datas[1]);
		pstmt.setDate(3, (Date)datas[2]);
		pstmt.setString(4,(String) datas[3]);
		pstmt.setString(5,(String) datas[4]);
		
		rs = pstmt.executeQuery();
		
		pstmt.close();
		rs.close();
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
	
	public void setUpdataRow(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	public int getUpdataEmp_id() {
		Object[][] rowData = getRowData();
		return Integer.parseInt(String.valueOf(rowData[row][0]));
	}
	
	public String getUpdataEmp_data(int col) {
		Object[][] rowData = getRowData();
		return String.valueOf(rowData[row][col]);
	}
	
	public int getEmp_id() {
		Object[][] rowData = getRowData();
		return Integer.parseInt(String.valueOf(rowData[rowData.length-1][0]))+1;
	}
}
