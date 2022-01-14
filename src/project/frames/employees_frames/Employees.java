package project.frames.employees_frames;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import oracle.net.aso.f;
import project.MainFrame;
import project.actions.employees_actions.SQLs;
import project.components.employees_companents.Bottom_layout;
import project.components.employees_companents.Top_layout;

public class Employees extends JFrame{
	
	public Employees(MainFrame main) {

		// employees 프레임의 위치, 사이즈 정보 배열
		// 레이아웃을 깔끔하게 계산하기 위해서 만든 친구입니다 :D
		setVisible(false);
		setLayout(null);
		setBounds(100,100,1000,700);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		SQLs sql = new SQLs("리셋", this, null);
		Bottom_layout bl = new Bottom_layout(main, this, sql);
		add(bl);
		add(new Top_layout(this, bl.getTl().get_table(), sql));
	}
	
}




