package project.components.employees;

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
		// employees 프레임의 위치, 사이즈 정보 배열
		// 레이아웃을 깔끔하게 계산하기 위해서 만든 친구입니다 :D
		int fw= 0, fh = 0;
	
		setVisible(false);
		setLayout(null);
		setBounds(700,500,1000,700);
		
		// 0, 1 은 프레임의 크기를 담는다.
		fw = getSize().width-20;
		fh = getSize().height;
		
		add(new Top_layout(fw,fh));
		add(new Bottom_layout(fw,fh));
	}
	
}




