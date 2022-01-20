package project.frames.employees_frames;

import javax.swing.JFrame;

import project.MainFrame;
import project.actions.QuitBtn;
import project.components.employees_companents.MainContants;

import project.database.employee_customer.SQLs;

public class Employees extends JFrame{
	
	public Employees(MainFrame main) {
		
		// 0, 1 �� �������� ũ�⸦ ��´�.
		SQLs sql = new SQLs("����", 1);
		
		setUndecorated(true); //Ÿ��Ʋ�� ���ֱ�
		setBounds(main.getLocation().x, main.getLocation().y, 1000, 700);
		setTitle("����");
		setVisible(false);
		setLayout(null);
		
		MainContants jp = new MainContants(main, this, sql, 1);
		add(jp);
	}
}