package project.actions.employees_actions.main;

import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class Function_emp {
	public Function_emp() {}
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
