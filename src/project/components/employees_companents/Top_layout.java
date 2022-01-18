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
	JFrame f;
	
	public Top_layout(JFrame f, Table jp, SQLs sql, int type) {
		
		this.jp = jp;
		this.sql = sql;
		this.f = f;
		
		int fw = f.getSize().width, fh = f.getSize().height;
		
		//������ ���
		int[] width = {(int)(fw*0.2), (int)(fw*0.8)};
		int height = (int)((double)fh*0.1);
		
		System.out.println(height);
		
		setLayout(null);
		setBounds(0, f.getSize().height-200, fw, 100);	//��� ���̾ƿ��� 20%�� �԰�
		setVisible(true);
		
		//add(left(width[0], height));
		add(right(width, height, type));
		
	}
	
	//���̾ƿ�
	
	//������ �ΰ� ���̾ƿ�
	JPanel left(int width, int height) {
		JPanel left = new JPanel();
		
		//�ΰ� �߰�
		left.setBounds(0,0, width, height);
		left.add(new JLabel(f.getTitle()));
		
		return left;
	}
	
	//������ ���̾ƿ�
	JPanel right(int[] width, int height, int type) {
		
		JPanel right = new JPanel(); // ������ ��ư ���̾ƿ�
		
		right.setLayout(null);
		right.setBounds(width[0], 0, width[1], height);
		
		for(int i = 0; i<2; i++) {
			TopBtn tb = new TopBtn(jp, i, sql, width, height, type);
			right.add(tb);
		}
		
		return right;
	}
}
