package project.frames.employees_frames;

import javax.swing.JFrame;

import project.MainFrame;
import project.components.employees_companents.MainContants;

import project.database.employee_customer.SQLs;

public class Employees extends JFrame{
	
	public Employees(MainFrame main) {
		
		// ������ ���۰� ���ÿ� db���� �����͸� ������ ��� �غ� ���ش�.
		SQLs sql = new SQLs("����", 1);
		
		//Ÿ��Ʋ�� ���ְ�
		setUndecorated(true);
		//���� �������� ó�� ������ ��ġ�� �����Ѵ�.
		setBounds(main.getLocation().x, main.getLocation().y, 1000, 700);
		setTitle("����");
		setVisible(false);
		setLayout(null);
		
		//���� �г��� �ִ´�.
		MainContants jp = new MainContants(main, this, sql, 1);
		add(jp);
	}
}