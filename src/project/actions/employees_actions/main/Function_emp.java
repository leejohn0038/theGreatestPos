package project.actions.employees_actions.main;

import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import project.actions.employees_actions.main.object.Emp_addData;
import project.components.employees_companents.Table;
import project.database.employee_customer.SQLs;

public class Function_emp {
	public Function_emp() {}
	
	public void updateView(Table jp, int row, Emp_addData data) {
	
		Object[] obj = data.getDates();
		
		for(int i = 0; i<jp.dtm.getColumnCount(); i++) {
			jp.dtm.setValueAt(obj[i], row, i);
		}
	}
	
	public void updateView(Table jp, int maxRow, int maxCol) {
		
		SQLs reset_sql = new SQLs("리셋",1);
		Object[][] obj = reset_sql.getRowData();
		
		//jp.dtm.set
		
	}
	
	public String[] getTitle() {
		
		return new SQLs("리셋",1).getTitle();
	}
	
	public boolean regex(String title, String obj) {
		JOptionPane massge = new JOptionPane();
		
		switch (title) {
		case "이름":
			return true;
		case "입사일":
			if(Pattern.matches("\\d{2,}.*\\d{2}.*\\d{2}", obj)){ return true; }
			break;
		case "전화번호":
			if(Pattern.matches("010\\-*\\d{4}\\-*\\d{4}", obj)){ return true; }
			break;
		case "직책":
			if(Pattern.matches("^[ㄱ-ㅎ가-힣]*$", obj)){ return true; }
			break;
		}
		
		massge.showMessageDialog(null, title + " 잘못된 값 입력!!");
		return false;
			
	}
}
