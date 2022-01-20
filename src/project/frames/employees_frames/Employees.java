package project.frames.employees_frames;

import javax.swing.JFrame;

import project.MainFrame;
import project.actions.QuitBtn;
import project.components.employees_companents.MainContants;

import project.database.employee_customer.SQLs;

public class Employees extends JFrame{
	
	public Employees(MainFrame main) {
		
		// 0, 1 은 프레임의 크기를 담는다.
		SQLs sql = new SQLs("리셋", 1);
		
		setUndecorated(true); //타이틀바 없애기
		setBounds(main.getLocation().x, main.getLocation().y, 1000, 700);
		setTitle("직원");
		setVisible(false);
		setLayout(null);
		
		MainContants jp = new MainContants(main, this, sql, 1);
		add(jp);
	}
}