package project.frames.employees_frames;

import javax.swing.JFrame;

import project.components.employees_companents.main.Bottom_layout;
import project.components.employees_companents.main.Top_layout;

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
		setBounds(700,500,1000,700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// 0, 1 �� �������� ũ�⸦ ��´�.
		
		add(new Top_layout(this));
		add(new Bottom_layout(this));
	}
	
}




