package project.frames.customers_frames;

import javax.swing.JFrame;

import project.MainFrame;
import project.actions.customers_actions.CustomersSQLs;
import project.components.customers_components.CustomersBottomLayout;
import project.components.customers_components.CustomersTopLayout;

public class Customers extends JFrame{
	
	public Customers(MainFrame main) {

		// employees �������� ��ġ, ������ ���� �迭
		// ���̾ƿ��� ����ϰ� ����ϱ� ���ؼ� ���� ģ���Դϴ� :D
		setVisible(false);
		setLayout(null);
		setBounds(100,100,1000,700);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// 0, 1 �� �������� ũ�⸦ ��´�.
		CustomersSQLs sql = new CustomersSQLs("����", this, null);
		CustomersBottomLayout bl = new CustomersBottomLayout(main, this, sql);
		add(bl);
		add(new CustomersTopLayout(this, bl.getTl().get_table(), sql));
	}
	
}




