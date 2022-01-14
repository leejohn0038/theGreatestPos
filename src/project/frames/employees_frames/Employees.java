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

		// employees �������� ��ġ, ������ ���� �迭
		// ���̾ƿ��� ����ϰ� ����ϱ� ���ؼ� ���� ģ���Դϴ� :D
		setVisible(false);
		setLayout(null);
		setBounds(100,100,1000,700);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		SQLs sql = new SQLs("����", this, null);
		Bottom_layout bl = new Bottom_layout(main, this, sql);
		add(bl);
		add(new Top_layout(this, bl.getTl().get_table(), sql));
	}
	
}




