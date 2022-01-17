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
		
		SQLs reset_sql = new SQLs("¸®¼Â",1);
		Object[][] obj = reset_sql.getRowData();
		
	}
	
	public String[] getTitle(int type) {
		return new SQLs("¸®¼Â", type).getTitle();
	}
	
	public boolean regex(String title, String obj) {
		JOptionPane massge = new JOptionPane();
		
		switch (title) {
		case "ÀÌ¸§":
			return true;
		case "ÀÔ»çÀÏ":
			if(Pattern.matches("\\d{2,}.*\\d{2}.*\\d{2}", obj)){ return true; }
			break;
		case "ÀüÈ­¹øÈ£":
			if(Pattern.matches("010\\-*\\d{4}\\-*\\d{4}", obj)){ return true; }
			break;
		case "Á÷Ã¥":
			if(Pattern.matches("^[¤¡-¤¾°¡-ÆR]*$", obj)){ return true; }
			break;
		case "ÁÖ¼Ò":
			return true;
		}
		
		massge.showMessageDialog(null, title + " Àß¸øµÈ °ª ÀÔ·Â!!");
		return false;
			
	}
}
