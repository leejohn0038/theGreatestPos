package project.actions.employees_actions.main;

import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import project.actions.employees_actions.SQLs;
import project.components.employees_companents.Table_emp;

public class Function_emp {
	public Function_emp() {}
	
	public void updateView(Table_emp jp, int row) {
		
		SQLs reset_sql = new SQLs("����", null, null);
		Object[][] obj = reset_sql.getRowData();
		
		for(int i = 0; i<jp.dtm.getColumnCount(); i++) {
			jp.dtm.setValueAt(obj[row][i], row, i);
		}
	}
	
	public void updateView(Table_emp jp, int maxRow, int maxCol) {
		
		SQLs reset_sql = new SQLs("����", null, null);
		Object[][] obj = reset_sql.getRowData();
		
		//jp.dtm.set
		
	}
	
	public String[] getTitle(String type) {
		
		return new SQLs("����", null, null).getTitle();
	}
	
	public boolean regex(String title, String obj) {
		JOptionPane massge = new JOptionPane();
		
		switch (title) {
		case "�̸�":
			return true;
		case "�Ի���":
			if(Pattern.matches("\\d{2,}.*\\d{2}.*\\d{2}", obj)){ return true; }
			break;
		case "��ȭ��ȣ":
			if(Pattern.matches("010\\-*\\d{4}\\-*\\d{4}", obj)){ return true; }
			break;
		case "��å":
			System.out.println(obj);
			if(Pattern.matches("^[��-����-�R]*$", obj)){ return true; }
			break;
		}
		
		massge.showMessageDialog(null, title + " �߸��� �� �Է�!!");
		return false;
			
	}
}
