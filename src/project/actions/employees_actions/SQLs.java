package project.actions.employees_actions;

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
import project.actions.employees_actions.main.object.AddData;

public class SQLs {
	
	private ArrayList<AddData> addDatas;
	AddData addData;
	private int row;
	private int col;
	private String[] title;
	private String title_txt;
	
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
			case "삭제":
				final String DEL_SQL = "DELETE FROM mart_employees WHERE ";
				delete(DEL_SQL, conn);
				break;
			case "검색":
				final String SLE_SQL = "select * from mart_employees WHERE ";
				select(SLE_SQL, conn);
				break;
			case "수정":
				final String UPDATA_SQL = "UPDATE mart_employees SET ";
				updata(UPDATA_SQL, conn);
				break;
			case "리셋":
				final String RESET_SQL = "select * from mart_employees ";
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
		
		PreparedStatement pstmt = conn.prepareStatement(SQL + "order by 사원번호");
		ResultSet rs = pstmt.executeQuery();
		ResultSetMetaData meta = rs.getMetaData();
		
		addDatas = new ArrayList<>();
		title = new String[meta.getColumnCount()];
		
		System.out.println();
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
				
				System.out.print(objs[col] + " ");
			}
			
			System.out.println();
			addDatas.add(new AddData(objs));
		}
		
		pstmt.close();
		rs.close();
	}
	
	void select(String SQL, Connection conn) throws SQLException {
		
		final String ADD_SQL = " like '%'||?||'%'";
		Object[] objs = addData.getDates();
		row = 0;
		
		tableReset("select * from mart_employees ", conn);
		
		addDatas = new ArrayList<>();
		
		//데이터 위치 찾기
		for(col = 0; col<objs.length; col++) {
			if(objs[col] != null) {
				title_txt = title[col];
				break;
			}
		}
		
		PreparedStatement pstmt = conn.prepareStatement(SQL + title_txt + ADD_SQL);
		ResultSet rs;
		
		pstmt.setString(1, (String)objs[col]);
		
		rs = pstmt.executeQuery();
		ResultSetMetaData meta = rs.getMetaData();
		
		while(rs.next()) {
			row++;
			for(int col = 0; col<meta.getColumnCount(); col++) {
				if(rs.getString(meta.getColumnName(col+1)) != null) {
					objs[col] = rs.getObject(meta.getColumnName(col+1));
				}else {
					objs[col] = "";
				}
			}

			addDatas.add(new AddData(objs));
		}
		
		for(int i = 0; i<addDatas.size(); i++) {
			Object[] obj = addDatas.get(i).getDates();
			
			for(Object o : obj) {
				System.out.print(o + " ");
			}
			System.out.println();
		}
		
		pstmt.close();
		rs.close();
	}
	
	void delete(String SQL, Connection conn) throws SQLException{
		final String ADD_SQL = "사원번호 = ?";
		PreparedStatement pstmt = conn.prepareStatement(SQL + ADD_SQL);
		ResultSet rs;
		
		int id = addData.getID();
		
		pstmt.setInt(1, id);
		
		rs = pstmt.executeQuery();
		
		pstmt.close();
		rs.close();
	}
	
	void updata(String SQL, Connection conn) throws SQLException {
		final String ADD_SQL = "이름 = ?, 입사일 = ?, "
				+ "전화번호 = ?, 직책 = ? WHERE 사원번호 = ?";
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
	
	public Object[][] getRowData(){
		int maxRow = addDatas.size();
		int maxCol = addDatas.get(0).getDatesSize();
		Object[][] rowData = new Object[maxRow][maxCol];
		
		
		if(maxRow == 0 || maxCol == 0) {
			rowData[0][0] = addDatas.get(0).getDates();
		}
		
		for(int i = 0; i<maxRow; i++) {
			rowData[i] = addDatas.get(i).getDates();
		}
		
		return rowData;
	}
	
	public void setUpdataRow(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	void setAddData(AddData addData) {
		this.addData = addData;
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
	public int getEmp_id() {
		Object[][] rowData = getRowData();
		
		if(rowData.length == 0) {
			return 100;
		}
		
		return Integer.parseInt(String.valueOf(rowData[rowData.length-1][0]))+1;
	}
}
