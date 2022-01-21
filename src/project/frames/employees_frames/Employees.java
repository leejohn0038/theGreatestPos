package project.frames.employees_frames;

import javax.swing.JFrame;

import project.MainFrame;
import project.components.employees_companents.MainContants;

import project.database.employee_customer.SQLs;

public class Employees extends JFrame{
	
	public Employees(MainFrame main) {
		
		// 프레임 시작과 동시에 db에서 데이터를 가져와 출력 준비를 해준다.
		SQLs sql = new SQLs("리셋", 1);
		
		//타이틀바 없애고
		setUndecorated(true);
		//상위 프레임의 처음 생성한 위치에 생성한다.
		setBounds(main.getLocation().x, main.getLocation().y, 1000, 700);
		setTitle("직원");
		setVisible(false);
		setLayout(null);
		
		//메인 패널을 넣는다.
		MainContants jp = new MainContants(main, this, sql, 1);
		add(jp);
	}
}