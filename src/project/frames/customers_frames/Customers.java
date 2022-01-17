
package project.frames.customers_frames;

import javax.swing.JFrame;

import project.MainFrame;
import project.components.employees_companents.Bottom_layout;
import project.components.employees_companents.Top_layout;
import project.database.employee_customer.SQLs;

public class Customers extends JFrame {
	public Customers(MainFrame main) {
		
		setTitle("ȸ��");
		setVisible(false);
		setLayout(null);
		setBounds(100,100,1000,700);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// 0, 1 �� �������� ũ�⸦ ��´�.
		SQLs sql = new SQLs("����", 2);
		
		Bottom_layout bl = new Bottom_layout(main, this, sql, 2);
		add(bl);
		
		Top_layout top_layout = new Top_layout(this, bl.getTl().get_table(), sql, 2);
		add(top_layout);
	}
}

