package project.components.employees_companents;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import project.actions.employees_actions.main.TopBtn;
import project.database.employee_customer.SQLs;

//�������� ��� ���̾ƿ� (logo / ��ȸ / ��� / ���� ��ư)
public class Top_layout extends JPanel{
	
	Table jp;
	SQLs sql;
	
	public Top_layout(JFrame emp_f, Table jp, SQLs sql, int type) {
		
		this.jp = jp;
		this.sql = sql;
		
		int fw = emp_f.getSize().width, fh = emp_f.getSize().height;
		
		//������ ���
		int[] width = {(int)(fw*0.2), (int)(fw*0.8)};
		int height = (int)((double)fh*0.1);
		
		setLayout(null);
		setBounds(0, 0, fw, height);	//��� ���̾ƿ��� 20%�� �԰�
		setBorder(new LineBorder(Color.black));
		setVisible(true);
		
		add(left(width[0], height));
		add(right(width, height, type));
		
	}
	
	//���̾ƿ�
	
	//������ �ΰ� ���̾ƿ�
	JPanel left(int width, int height) {
		JPanel left = new JPanel();
		
		//�ΰ� �߰�
		left.setBounds(0,0, width, height);
		left.setBorder(new LineBorder(Color.black));
		left.add(new JLabel("logo"));
		
		return left;
	}
	
	//������ ���̾ƿ�
	JPanel right(int[] width, int height, int type) {
		
		JPanel right = new JPanel(); // ������ ��ư ���̾ƿ�
		
		right.setLayout(null);
		right.setBounds(width[0], 0, width[1], height);
		right.setBorder(new LineBorder(Color.black));
		
		for(int i = 0; i<2; i++) {
			TopBtn tb = new TopBtn(jp, i, sql, width, height, type);
			right.add(tb);
		}
		
		return right;
	}
}
