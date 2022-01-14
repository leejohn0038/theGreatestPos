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
		// employees 프레임의 위치, 사이즈 정보 배열
		// 레이아웃을 깔끔하게 계산하기 위해서 만든 친구입니다 :D
		int fw= 0, fh = 0;
	
		setVisible(false);
		setLayout(null);
		setBounds(700,500,1500,700);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		// 0, 1 은 프레임의 크기를 담는다.
		
		add(new Top_layout(this));
		add(new Bottom_layout(main, this));
	}
	
}




