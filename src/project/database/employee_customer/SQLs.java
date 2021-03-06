package project.database.employee_customer;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.xml.crypto.Data;

import oracle.net.aso.f;
import project.actions.employees_actions.main.DBConnector;
import project.actions.employees_actions.main.object.Emp_addData;
import project.components.customers_components.object.Cus_addData;

public class SQLs {
	
	private ArrayList<Emp_addData> emp_addDatas  = new ArrayList<>();
	private ArrayList<Cus_addData> cus_addDatas  = new ArrayList<>();
	public Emp_addData emp_addData;
	public Cus_addData cus_addData;
	private int row;
	private int col;
	private String[] title;
	private String title_txt;
	private String dbName;
	private String type;
	private String[] target;
	
	public SQLs(String type, String[] target) {
		this.type = type;
		this.target = target;
		dbName = "mart_employees";
		selectSqlType();
	}
	
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
			case "????":
				final String ADD_SQL = "INSERT into " + dbName + " VALUES ";
				add(ADD_SQL, conn);
				break;
			case "????":
				final String DEL_SQL = "DELETE FROM " + dbName + " WHERE ";
				delete(DEL_SQL, conn);
				break;
			case "?˻?":
				final String SLE_SQL = "select * from " + dbName + " WHERE ";
				select(SLE_SQL, conn);
				break;
			case "????":
				final String UPDATA_SQL = "UPDATE " + dbName + " SET ";
				updata(UPDATA_SQL, conn);
				break;
			case "????":
				final String RESET_SQL = "select * from " + dbName + " ";
				tableReset(RESET_SQL, conn);
				break;
			case "????":
				final String DATA_SQL = "select * from " + dbName + " WHERE ";
				selectData(DATA_SQL, conn, target);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	void tableReset(String SQL, Connection conn) throws SQLException {
		
		String addStr;
		
		if(dbName == "mart_employees") {
			addStr = "order by ??????ȣ";
		}else {
			addStr = "order by ??ȭ??ȣ";
		}
		
		PreparedStatement pstmt = conn.prepareStatement(SQL + addStr);
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
					if(meta.getColumnName(col+1).contains("??")) {
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
		
		//?????? ??ġ ã??
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
			if(dbName.contains("emp")) {
				emp_addDatas.add(new Emp_addData(objs));
			}else {
				cus_addDatas.add(new Cus_addData(objs));
			}
		}
		
		pstmt.close();
		rs.close();
	}
	
	void delete(String SQL, Connection conn) throws SQLException{
		
		PreparedStatement pstmt;
		
		if(dbName.contains("emp")) {
			final String EMP_ADD_SQL = "??????ȣ = ?";
			pstmt = conn.prepareStatement(SQL + EMP_ADD_SQL);
			int id = emp_addData.getID();
			pstmt.setInt(1, id);
		}else {
			final String CUS_ADD_SQL = "??ȭ??ȣ = ?";	
			pstmt = conn.prepareStatement(SQL + CUS_ADD_SQL);
			String phone = cus_addData.getID();
			pstmt.setString(1, phone);
		}
		
		ResultSet rs;
		
		rs = pstmt.executeQuery();
		
		pstmt.close();
		rs.close();
	}
	
	void updata(String SQL, Connection conn) throws SQLException {
		
		final String EMP_ADD_SQL = "?̸? = ?, ?Ի??? = ?, "
				+ "??ȭ??ȣ = ?, ??å = ? WHERE ??????ȣ = ? ";
		
		final String CUS_ADD_SQL = "??ȭ??ȣ = ?, ?̸? = ?, "
				+ "?ּ? = ?, ?????? = ?, ????Ʈ = ? WHERE ??ȭ??ȣ = ?";
		
		PreparedStatement pstmt;
		ResultSet rs;
		
		Object[] datas;
		
		if(dbName.contains("emp")) {
			pstmt = conn.prepareStatement(SQL + EMP_ADD_SQL);
			datas = emp_addData.getDates(); 
			
			pstmt.setString(1, (String) datas[1]);
			pstmt.setDate(2, (Date)datas[2]);
			pstmt.setString(3,(String) datas[3]);
			pstmt.setString(4,(String) datas[4]);
			pstmt.setInt(5,(int)datas[0]);
		}else {
			pstmt = conn.prepareStatement(SQL + CUS_ADD_SQL);
			datas = cus_addData.getDates();
			
			pstmt.setString(1, (String)datas[0]);
			pstmt.setString(2, (String) datas[1]);
			pstmt.setString(3,(String) datas[2]);
			pstmt.setDate(4, (Date)datas[3]);
			pstmt.setInt(5,(int) datas[4]);
			pstmt.setString(6, (String)datas[0]);
		}
		
		rs = pstmt.executeQuery();
		
		pstmt.close();
		rs.close();
		
	}
	
	void add(String SQL, Connection conn) throws SQLException {
		final String addSql = "(?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(SQL + addSql);
		ResultSet rs = null;
		
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
			
		try {
			rs = pstmt.executeQuery();
		} catch (Exception e) {
			cus_addData.setDates();
			JOptionPane mb = new JOptionPane("??ȭ??ȣ?? ??ø?˴ϴ?. ?ٽ? ???????ּ???!");
			JDialog mbDialog = mb.createDialog((JFrame)null, "Error");
			mbDialog.setLocation(700,300);
			mbDialog.setVisible(true);
			//mb.showConfirmDialog(null, "??ȭ??ȣ?? ?ߺ??˴ϴ?.","ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
			return;
		}finally {
			pstmt.close();
		}
		
		rs.close();
		
	}
	
	void selectData(String SQL, Connection conn, String[] target) throws SQLException {
		
		final String ADD_SQL = "\"?̸?\" = ? and \"??ȭ??ȣ\" like ?";
	
		PreparedStatement pstmt = conn.prepareStatement(SQL + ADD_SQL);
			
		pstmt.setString(1, target[0]);
		pstmt.setString(2, "%"+target[1]);
		
		ResultSet rs = pstmt.executeQuery();;
		ResultSetMetaData meta = rs.getMetaData();
		
		Object[] objs = new Object[meta.getColumnCount()];
		
		while(rs.next()) {			
			
			for(int col = 0; col<meta.getColumnCount(); col++) {
				
				if(rs.getString(meta.getColumnName(col+1)) != null) { 
					if(meta.getColumnName(col+1).contains("??")) {
						objs[col] = (rs.getString(meta.getColumnName(col+1)).substring(0, 10));
					}else {
						objs[col] = rs.getString(meta.getColumnName(col+1));
					}
					
				}else {
					objs[col] = "";
				}
				
			}
			emp_addDatas.add(new Emp_addData(objs));
		}
		
		pstmt.close();
		rs.close();
	}
	
	public Object[][] getRowData(){
		
		int maxRow;
		int maxCol;
		Object[][] rowData;
		
		//?˻????? ?????? 0???? ó???Ѵ?. ?????? ȸ???? ???? ?ۿ??ϱ⶧???? ȸ???? ?ɷ??????Ѵ?.
		if(emp_addDatas.size() == 0 && cus_addDatas.size() == 0) {
			rowData = new Object[1][5];
			rowData[0][0] = 0;
			rowData[0][1] = null;
			rowData[0][2] =	null;
			rowData[0][3] = null;
			rowData[0][4] = null;
			
			return rowData;
		}
		
		
		if(dbName.contains("emp")) {
			maxRow = emp_addDatas.size();
			maxCol = emp_addDatas.get(0).getDatesSize();
		}else {
			maxRow = cus_addDatas.size();
			maxCol = cus_addDatas.get(0).getDatesSize();
		}
		
		rowData = new Object[maxRow][maxCol];
		
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
	
	
	public ArrayList<Emp_addData> getEmpArr(){
		return emp_addDatas;
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
	
	//???Ͻ?
	public int emp_getAddEmp_id() {
		
		Object[][] rowData = getRowData();
		
		if(rowData.length == 0) {
			return 100;
		}
		
		return Integer.parseInt(String.valueOf(rowData[rowData.length-1][0]))+1;
	}
}
