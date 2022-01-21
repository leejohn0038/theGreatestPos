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
		return new SQLs("¸®¼Â", type).getTitle();
	}
	
	public boolean regex(String title, String obj) {
		
		switch (title) {
		case "ÀÌ¸§":
			return true;
		case "ÀÔ»çÀÏ", "µî·ÏÀÏ":
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
		case "Æ÷ÀÎÆ®":
			return true;
		}
		
		JOptionPane mb = new JOptionPane("Àß¸øµÈ °ª ÀÔ·ÂµÇ¾ú½À´Ï´Ù. ´Ù½Ã µî·ÏÇØÁÖ¼¼¿ä!");
		JDialog mbDialog = mb.createDialog((JFrame)null, "Error");
		mbDialog.setLocation(700,300);
		mbDialog.setVisible(true);
		return false;
			
	}
}
