
package project.frames.customers_frames;

import javax.swing.JFrame;

import project.MainFrame;
import project.components.employees_companents.MainContants;
import project.components.employees_companents.NavBar;
import project.database.employee_customer.SQLs;

public class Customers extends JFrame {
	public Customers(MainFrame main) {
		
		setTitle("ȸ��");
		setUndecorated(true);
		setVisible(false);
		setLayout(null);
		setBounds(100,100,1000,700);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// 0, 1 �� �������� ũ�⸦ ��´�.
		SQLs sql = new SQLs("����", 2);
		
		MainContants bl = new MainContants(main, this, sql, 2);
		add(bl);
	}
}

