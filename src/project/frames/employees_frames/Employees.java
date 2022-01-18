package project.frames.employees_frames;

import javax.swing.JFrame;

import project.MainFrame;
import project.components.employees_companents.Bottom_layout;
import project.components.employees_companents.Top_layout;
import project.database.employee_customer.SQLs;

public class Employees extends JFrame{
	
	public Employees(MainFrame main) {

		// employees 프레임의 위치, 사이즈 정보 배열
		// 레이아웃을 깔끔하게 계산하기 위해서 만든 친구입니다 :D
		setTitle("직원");
		setVisible(false);
		setLayout(null);
		setBounds(100,100,1000,700);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// 0, 1 은 프레임의 크기를 담는다.
		SQLs sql = new SQLs("리셋", 1);
		
		Bottom_layout bl = new Bottom_layout(main, this, sql, 1);


		add(bl);
		
		Top_layout top_layout = new Top_layout(this, bl.getTl().get_table(), sql, 1);
		add(top_layout);
	}
}
