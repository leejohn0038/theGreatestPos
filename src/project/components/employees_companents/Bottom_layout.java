package project.components.employees_companents;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import project.MainFrame;
import project.actions.employees_actions.SQLs;

public class Bottom_layout extends JPanel{
	Table_layout tl;
	
	public Bottom_layout(MainFrame main, JFrame emp, SQLs sql) {
		
		int fw = emp.getSize().width, fh = emp.getSize().height;
		
		//레이아웃 초기설정
		int[] layoutBounds = {0, (int)(fh*0.2), fw, (int)(fh*0.8)};
		int height;
		
		JPanel inner_layout = new JPanel();
		JPanel select;
		JPanel side;
		
		side = new SideBar_layout(main, layoutBounds[2], layoutBounds[3]);
		inner_layout.add(side);
		inner_layout.add(tl = new Table_layout(side.getSize().width, sql));
		
		select = new Select_layout(tl);
		height = select.getSize().height;
		
		//select 관련 레이아웃이 한자리 먹고 있음 그거 높이 빼주는 계산 해줘야함!
		inner_layout.setLayout(null);
		inner_layout.setBounds(0, 0, layoutBounds[2], layoutBounds[3]-height);
		
		add(select);
		add(inner_layout);
		
		setLayout(null);
		setBounds(layoutBounds[0], layoutBounds[1], layoutBounds[2], layoutBounds[3]);
		setBorder(new LineBorder(Color.black));
	}
	
	public Table_layout getTl() {
		return tl;
	}
}
