package project.actions.employees_actions.main;

import java.util.regex.Pattern;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import project.actions.employees_actions.main.object.Emp_addData;
import project.components.customers_components.object.Cus_addData;
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
	
	public void updateView(Table jp, int row, Cus_addData data) {
		
		Object[] obj = data.getDates();
		
		for(int i = 0; i<jp.dtm.getColumnCount(); i++) {
			jp.dtm.setValueAt(obj[i], row, i);
		}
	}
	
	public String[] getTitle(int type) {
		return new SQLs("리셋", type).getTitle();
	}
	
	public boolean regex(String title, String obj) {
		
		switch (title) {
		case "이름":
			return true;
		case "입사일", "등록일":
			if(Pattern.matches("\\d{2,}.*\\d{2}.*\\d{2}", obj)){ return true; }
			break;
		case "전화번호":
			if(Pattern.matches("010\\-*\\d{4}\\-*\\d{4}", obj)){ return true; }
			break;
		case "직책":
			if(Pattern.matches("^[ㄱ-ㅎ가-힣]*$", obj)){ return true; }
			break;
		case "주소":
			return true;
		case "포인트":
			return true;
		}
		
		JOptionPane mb = new JOptionPane("잘못된 값 입력되었습니다. 다시 등록해주세요!");
		JDialog mbDialog = mb.createDialog((JFrame)null, "Error");
		mbDialog.setLocation(700,300);
		mbDialog.setVisible(true);
		return false;
			
	}
}
