package project.components.employees_companents;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import project.MainFrame;
import project.actions.employees_actions.main.TopBtn;
import project.database.employee_customer.SQLs;

public class MainContants extends JPanel{
	
	Table_layout tl;
	JFrame f;
	SQLs sql;
	
	public MainContants(MainFrame main, JFrame f, SQLs sql, int type) {
		
		this.sql = sql;
		this.f = f;
		
		//���̾ƿ� �ʱ⼳��
		setPreferredSize(new Dimension(1000-8,700-36));
		setBorder(new LineBorder(Color.black));
		System.out.println(f.getInsets().top);
		
		int[] layoutBounds = {0, 0, 0, 0};
		int height;
		
		JPanel inner_layout = new JPanel();
		JPanel select;
		JPanel side;
		
		//Top_layout top_layout = new Top_layout(f, tl.get_table(), sql, type);
		//add(top_layout);
		
		select = new Select_layout(tl, type);
		height = select.getSize().height;
		
		side = new SideBar_layout(main, f.getTitle());
		side.setBorder(new LineBorder(Color.black));
		inner_layout.add(side);
		inner_layout.add(tl = new Table_layout(side.getSize().width, sql, type));
		
		//select ���� ���̾ƿ��� ���ڸ� �԰� ���� �װ� ���� ���ִ� ��� �������!
		inner_layout.setLayout(null);
		inner_layout.setBounds(0, 0, layoutBounds[2], layoutBounds[3]-height);
		
		setBorder(new LineBorder(Color.black));
		
		add(select);
		add(inner_layout);
		add(right(type));
		
		setLayout(null);
		setBounds(layoutBounds[0], layoutBounds[1], layoutBounds[2], layoutBounds[3]);
	}
	
	//������ ���̾ƿ�
	JPanel right(int type) {
		
		JPanel right = new JPanel(); // ������ ��ư ���̾ƿ�
		
		int[] width = {(int)(f.getSize().width*0.2), (int)(f.getSize().width*0.8)};
		int height = (int)((double)f.getSize().height*0.1);
		
		right.setLayout(null);
		right.setBounds(0, 500, 300, 100);
		right.setBorder(new LineBorder(Color.black));
		
		for(int i = 0; i<2; i++) {
			TopBtn tb = new TopBtn(tl.get_table(), i, sql, width, height, type);
			right.add(tb);
		}
		
		return right;
	}
	
	public Table_layout getTl() {
		return tl;
	}
	
	int[][] viewCalculate(JFrame f){
		//0_row : 
		int[][] total = new int[2][4];
		
	}
}
