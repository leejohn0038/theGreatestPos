package project.actions.employees_actions.main;

import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class Function_emp {
	public Function_emp() {}
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
