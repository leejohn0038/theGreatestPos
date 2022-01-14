package project.frames.employees_frames;

import javax.swing.JFrame;

import project.MainFrame;
import project.actions.employees_actions.SQLs;
import project.components.employees_companents.Bottom_layout;
import project.components.employees_companents.Top_layout;

public class Employees extends JFrame{
	
	public Employees(MainFrame main) {

		// employees �������� ��ġ, ������ ���� �迭
		// ���̾ƿ��� ����ϰ� ����ϱ� ���ؼ� ���� ģ���Դϴ� :D
		setVisible(false);
		setLayout(null);
		setBounds(100,100,1000,700);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// 0, 1 �� �������� ũ�⸦ ��´�.
		SQLs sql = new SQLs("����", this, null);
		
		
		Bottom_layout bl = new Bottom_layout(main, this, sql);
		bl.getTl().setBounds(50, 0, 784, 501);
		bl.setBounds(100, 100, 984, 611);
		add(bl);
		
		Top_layout top_layout = new Top_layout(this, bl.getTl().get_table(), sql);
		add(top_layout);
	}
}




