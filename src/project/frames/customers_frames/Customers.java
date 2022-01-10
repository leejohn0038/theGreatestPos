package project.frames.customers_frames;

import javax.swing.JFrame;

import project.MainFrame;
import project.components.employees_companents.Bottom_layout;
import project.components.employees_companents.Top_layout;
import project.frames.customers_frames.reserve.CustomersDTO;

public class Customers extends JFrame{
	
	final String[] CUSTOMERS_NAME = {
			"phone",
			"customers_name",
			"customers_address",
			"subscription_date",
			"membership_point",
	};
	
	public Customers(MainFrame main) {
		// employees �������� ��ġ, ������ ���� �迭
		// ���̾ƿ��� ����ϰ� ����ϱ� ���ؼ� ���� ģ���Դϴ� :D
		int fw= 0, fh = 0;
	
		setVisible(false);
		setLayout(null);
		setBounds(700,500,1500,700);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		// 0, 1 �� �������� ũ�⸦ ��´�.
		
		add(new Top_layout(this));
		add(new Bottom_layout(main, this));
	}
	
}




