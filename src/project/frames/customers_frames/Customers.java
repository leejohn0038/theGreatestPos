package project.frames.customers_frames;

import javax.swing.JFrame;

import project.MainFrame;
import project.actions.customers_actions.CustomersSQLs;
import project.components.customers_components.CustomersBottomLayout;
import project.components.customers_components.CustomersTopLayout;

public class Customers extends JFrame{
	
	public Customers(MainFrame main) {

		// employees 프레임의 위치, 사이즈 정보 배열
		// 레이아웃을 깔끔하게 계산하기 위해서 만든 친구입니다 :D
		setVisible(false);
		setLayout(null);
		setBounds(100,100,1000,700);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// 0, 1 은 프레임의 크기를 담는다.
		CustomersSQLs sql = new CustomersSQLs("리셋", this, null);
		CustomersBottomLayout bl = new CustomersBottomLayout(main, this, sql);
		add(bl);
		add(new CustomersTopLayout(this, bl.getTl().get_table(), sql));
	}
	
}




