package project.components.employees.frame;

import javax.swing.JFrame;

import project.components.employees.main.bottom.view.Bottom_layout;
import project.components.employees.main.top.view.Top_layout;

public class Employees extends JFrame{
	
	final String[] EMPOLYEES_NAME = {
			"department_id",
			"employee_id",
			"employee_name",
			"hire_date",
			"rank",
			"commission",
			"phone_number",
			"salary"
	};
	
	
	public Employees() {
		// employees �������� ��ġ, ������ ���� �迭
		// ���̾ƿ��� ����ϰ� ����ϱ� ���ؼ� ���� ģ���Դϴ� :D
		int fw= 0, fh = 0;
	
		setVisible(true);
		setLayout(null);
		setBounds(700,500,1500,700);
		
		// 0, 1 �� �������� ũ�⸦ ��´�.
		
		add(new Top_layout(this));
		add(new Bottom_layout(this));
	}
	
}




