package project.actions.customers_actions.main;

import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import project.actions.customers_actions.CustomersSQLs;
import project.components.customers_components.Table_ctm;
////////////////////////////////// 내부 DB관련 데이터 수정하기
public class Function_ctm {
	public Function_ctm() {}
	
	public void updateView(Table_ctm jp, int row) {
		
		CustomersSQLs reset_sql = new CustomersSQLs("리셋", null, null);
		Object[][] obj = reset_sql.getRowData();
		
		for(int i = 0; i<jp.dtm.getColumnCount(); i++) {
			jp.dtm.setValueAt(obj[row][i], row, i);
		}
	}
	
	public void updateView(Table_ctm jp, int maxRow, int maxCol) {
		
		CustomersSQLs reset_sql = new CustomersSQLs("리셋", null, null);
		Object[][] obj = reset_sql.getRowData();
		
		//jp.dtm.set
		
	}
	
	public String[] getTitle() {
		
		return new CustomersSQLs("리셋", null, null).getTitle();
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
			System.out.println(obj);
			if(Pattern.matches("^[ㄱ-ㅎ가-힣]*$", obj)){ return true; }
			break;
		}
		
		massge.showMessageDialog(null, title + " 잘못된 값 입력!!");
		return false;
			
	}
}
