package project.database.employee_customer;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.xml.crypto.Data;

import project.actions.employees_actions.main.DBConnector;
import project.actions.employees_actions.main.object.Emp_addData;
import project.components.customers_components.object.Cus_addData;

public class SQLs {
	
	private ArrayList<Emp_addData> emp_addDatas;
	private ArrayList<Cus_addData> cus_addDatas;
	public Emp_addData emp_addData;
	public Cus_addData cus_addData;
	//public Cus_addData cus_addData;
	private int row;
	private int col;
	private String[] title;
	private String title_txt;
	private String dbName;
	private String type;
	
	public SQLs(String type, int f_type) {
		this.type = type;
		if(f_type == 1) {
			dbName = "mart_employees";
		}else {
			dbName = "customers";
		}
		selectSqlType();
	}
	
	public SQLs(String type, JFrame f, Cus_addData addData, int f_type) {
		this.cus_addData = addData;
		this.type = type;
		
		if(f_type == 1) {
			dbName = "mart_employees";
		}else {
			dbName = "customers";
		}
		
		selectSqlType();
	}
	
	public SQLs(String type, JFrame f, Emp_addData addData, int f_type) {
		this.emp_addData = addData;
		this.type = type;
		
		if(f_type == 1) {
			dbName = "mart_employees";
		}else {
			dbName = "customers";
		}
		
		selectSqlType();
	}
	
	void selectSqlType() {
		try (
				Connection conn = DBConnector.getConnection();
			) {
			
			switch (type) {
			case "등록":
				final String ADD_SQL = "INSERT into " + dbName + " VALUES ";
				add(ADD_SQL, conn);
				break;
			case "삭제":
				final String DEL_SQL = "DELETE FROM " + dbName + " WHERE ";
				delete(DEL_SQL, conn);
				break;
			case "검색":
				final String SLE_SQL = "select * from " + dbName + " WHERE ";
				select(SLE_SQL, conn);
				break;
			case "수정":
				final String UPDATA_SQL = "UPDATE " + dbName + " SET ";
				updata(UPDATA_SQL, conn);
				break;
			case "리셋":
				final String RESET_SQL = "select * from " + dbName + " ";
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
		
		PreparedStatement pstmt = conn.prepareStatement(SQL);
		ResultSet rs = pstmt.executeQuery();
		ResultSetMetaData meta = rs.getMetaData();
		
		if(dbName == "mart_employees") {
			emp_addDatas = new ArrayList<>();
		}else {
			cus_addDatas = new ArrayList<>();
		}
		
		title = new String[meta.getColumnCount()];

		for(int i = 0; i<title.length; i++) {
			title[i] = meta.getColumnName(i+1);
		}
		
		while(rs.next()) {		
			
			Object[] objs = new Object[meta.getColumnCount()];
			
			for(int col = 0; col<meta.getColumnCount(); col++) {
				
				if(rs.getString(meta.getColumnName(col+1)) != null) { 
					if(meta.getColumnName(col+1).contains("일")) {
						objs[col] = (rs.getString(meta.getColumnName(col+1)).substring(0, 10));
					}else {
						objs[col] = rs.getString(meta.getColumnName(col+1));
					}
					
				}else {
					objs[col] = "";
				}
				
			}
			
			if(dbName.contains("emp")) {
				emp_addDatas.add(new Emp_addData(objs));
			}else {
				cus_addDatas.add(new Cus_addData(objs));
			}
		}
		
		pstmt.close();
		rs.close();
	}
	
	void select(String SQL, Connection conn) throws SQLException {
		
		final String ADD_SQL = " like '%'||?||'%'";
		
		Object[] objs;
		if(dbName.contains("emp")) {
			tableReset("select * from mart_employees ", conn);
			objs = emp_addData.getDates();
			emp_addDatas = new ArrayList<>();
		}else {
			tableReset("select * from customers ", conn);
			objs = cus_addData.getDates();
			cus_addDatas = new ArrayList<>();
		}
		
		row = 0;
		
		//데이터 위치 찾기
		for(col = 0; col<objs.length; col++) {
			if(objs[col] != null) {
				title_txt = title[col];
				break;
			}
		}
		
		PreparedStatement pstmt = conn.prepareStatement(SQL + title_txt + ADD_SQL + " order by " + title_txt);
		ResultSet rs;
		
		pstmt.setString(1, (String)objs[col]);
		
		rs = pstmt.executeQuery();
		ResultSetMetaData meta = rs.getMetaData();
		
		while(rs.next()) {
			row++;
			for(int col = 0; col<meta.getColumnCount(); col++) {
				if(rs.getString(meta.getColumnName(col+1)) != null) {
					objs[col] = rs.getString(meta.getColumnName(col+1));
				}else {
					objs[col] = "";
				}	
			}
			if(dbName == "mart_employees") {
				emp_addDatas.add(new Emp_addData(objs));
			}
		}
		
		pstmt.close();
		rs.close();
	}
	
	void delete(String SQL, Connection conn) throws SQLException{
		
		PreparedStatement pstmt;
		
		if(dbName.contains("emp")) {
			final String EMP_ADD_SQL = "사원번호 = ?";
			pstmt = conn.prepareStatement(SQL + EMP_ADD_SQL);
			int id = emp_addData.getID();
			pstmt.setInt(1, id);
		}else {
			final String CUS_ADD_SQL = "전화번호 = ?";	
			pstmt = conn.prepareStatement(SQL + CUS_ADD_SQL);
			System.out.println(cus_addData.getID());
			String phone = cus_addData.getID();
			pstmt.setString(1, phone);
		}
		
		ResultSet rs;
		
		rs = pstmt.executeQuery();
		
		pstmt.close();
		rs.close();
	}
	
	void updata(String SQL, Connection conn) throws SQLException {
		final String ADD_SQL = "이름 = ?, 입사일 = ?, "
				+ "전화번호 = ?, 직책 = ? WHERE 사원번호 = ?";
		PreparedStatement pstmt = conn.prepareStatement(SQL + ADD_SQL);
		ResultSet rs;
		
		Object[] datas;
		if(dbName.contains("emp")) {
			datas = emp_addData.getDates(); 
		}else {
			datas = cus_addData.getDates();
		}
		
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
		
		Object[] datas;
		
		if(dbName.contains("emp")) {
			datas = emp_addData.getDates();
			
			pstmt.setInt(1,(int)datas[0]);
			pstmt.setString(2, (String) datas[1]);
			pstmt.setDate(3, (Date)datas[2]);
			pstmt.setString(4,(String) datas[3]);
			pstmt.setString(5,(String) datas[4]);
			
		}else {
			datas = cus_addData.getDates();
			
			pstmt.setString(1,(String)datas[0]);
			pstmt.setString(2, (String) datas[1]);
			pstmt.setString(3,(String) datas[2]);
			pstmt.setDate(4, (Date)datas[3]);
			pstmt.setInt(5,(int) datas[4]);
		}
			
		
		rs = pstmt.executeQuery();
		
		pstmt.close();
		rs.close();
	}
	
	public Object[][] getRowData(){
		
		int maxRow;
		int maxCol;
		
		if(dbName.contains("emp")) {
			maxRow = emp_addDatas.size();
			maxCol = emp_addDatas.get(0).getDatesSize();
		}else {
			maxRow = cus_addDatas.size();
			maxCol = cus_addDatas.get(0).getDatesSize();
		}
		
		Object[][] rowData = new Object[maxRow][maxCol];
		
		if(maxRow == 0 || maxCol == 0) {
			if(dbName.contains("emp")) {
				rowData[0][0] = emp_addDatas.get(0).getDates();
			}else {
				rowData[0][0] = cus_addDatas.get(0).getDates();
			}
			
		}
		
		for(int i = 0; i<maxRow; i++) {
			if(dbName.contains("emp")) {
				rowData[i] = emp_addDatas.get(i).getUpDates();
			}else {
				rowData[i] = cus_addDatas.get(i).getUpDates();
			}
		}
		
		return rowData;
	}
	
	public void setUpdataRow(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	void setAddData(Emp_addData addData) {
		if(dbName.contains("emp"))
		this.emp_addData = addData;
	}
	
	public String[] getTitle() {
		return title;
	}
	
	public int getMaxRow() {
		return row;
	}
	
	public int getUpdataEmp_id() {
		
		Object[][] rowData = getRowData();
		return Integer.parseInt(String.valueOf(rowData[row][0]));
	}
	
	public String getUpdataEmp_data(int col) {
		
		Object[][] rowData = getRowData();
		return String.valueOf(rowData[row][col]);
	}
	
	//등록시
	public int emp_getAddEmp_id() {
		
		Object[][] rowData = getRowData();
		
		if(rowData.length == 0) {
			return 100;
		}
		
		return Integer.parseInt(String.valueOf(rowData[rowData.length-1][0]))+1;
	}
}
