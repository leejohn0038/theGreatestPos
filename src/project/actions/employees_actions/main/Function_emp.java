package project.actions.employees_actions.main;

import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class Function_emp {
	public Function_emp() {}
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
