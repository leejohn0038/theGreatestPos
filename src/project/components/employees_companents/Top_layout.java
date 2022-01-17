package project.components.employees_companents;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import project.actions.employees_actions.main.TopBtn;
import project.database.employee_customer.SQLs;

//프레임의 상단 레이아웃 (logo / 조회 / 등록 / 편집 버튼)
public class Top_layout extends JPanel{
	
	Table jp;
	SQLs sql;
	
	public Top_layout(JFrame emp_f, Table jp, SQLs sql, int type) {
		
		this.jp = jp;
		this.sql = sql;
		
		int fw = emp_f.getSize().width, fh = emp_f.getSize().height;
		
		//사이즈 계산
		int[] width = {(int)(fw*0.2), (int)(fw*0.8)};
		int height = (int)((double)fh*0.1);
		
		setLayout(null);
		setBounds(0, 0, fw, height);	//상단 레이아웃은 20%만 먹게
		setBorder(new LineBorder(Color.black));
		setVisible(true);
		
		add(left(width[0], height));
		add(right(width, height, type));
		
	}
	
	//레이아웃
	
	//왼쪽은 로고 레이아웃
	JPanel left(int width, int height) {
		JPanel left = new JPanel();
		
		//로고 추가
		left.setBounds(0,0, width, height);
		left.setBorder(new LineBorder(Color.black));
		left.add(new JLabel("logo"));
		
		return left;
	}
	
	//오른쪽 레이아웃
	JPanel right(int[] width, int height, int type) {
		
		JPanel right = new JPanel(); // 오른쪽 버튼 레이아웃
		
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
