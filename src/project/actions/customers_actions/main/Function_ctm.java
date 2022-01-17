package project.actions.customers_actions.main;

import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import project.actions.customers_actions.CustomersSQLs;
import project.components.customers_components.Table_ctm;
////////////////////////////////// ³»ºÎ DB°ü·Ã µ¥ÀÌÅÍ ¼öÁ¤ÇÏ±â
public class Function_ctm {
	public Function_ctm() {}
	
	public void updateView(Table_ctm jp, int row) {
		
		CustomersSQLs reset_sql = new CustomersSQLs("¸®¼Â", null, null);
		Object[][] obj = reset_sql.getRowData();
		
		for(int i = 0; i<jp.dtm.getColumnCount(); i++) {
			jp.dtm.setValueAt(obj[row][i], row, i);
		}
	}
	
	public void updateView(Table_ctm jp, int maxRow, int maxCol) {
		
		CustomersSQLs reset_sql = new CustomersSQLs("¸®¼Â", null, null);
		Object[][] obj = reset_sql.getRowData();
		
		//jp.dtm.set
		
	}
	
	public String[] getTitle() {
		
		return new CustomersSQLs("¸®¼Â", null, null).getTitle();
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
			System.out.println(obj);
			if(Pattern.matches("^[¤¡-¤¾°¡-ÆR]*$", obj)){ return true; }
			break;
		}
		
		massge.showMessageDialog(null, title + " Àß¸øµÈ °ª ÀÔ·Â!!");
		return false;
			
	}
}
