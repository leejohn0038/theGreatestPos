package project.components.employees_companents;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import project.MainFrame;

public class Bottom_layout extends JPanel{
	public Bottom_layout(MainFrame main, JFrame emp) {
		
		int fw = emp.getSize().width, fh = emp.getSize().height;
		
		//레이아웃 초기설정
		int[] layoutBounds = {0, (int)(fh*0.2), fw, (int)(fh*0.8)};
		int height;
		
		JPanel inner_layout = new JPanel();
		JPanel select = new Select_layout();
		JPanel side;
		
		add(select);
		height = select.getSize().height;
		System.out.println();
		
		//select 관련 레이아웃이 한자리 먹고 있음 그거 높이 빼주는 계산 해줘야함!
		inner_layout.setLayout(null);
		inner_layout.setBounds(0, 0, layoutBounds[2], layoutBounds[3]-height);
		
		side = new SideBar_layout(main, layoutBounds[2], layoutBounds[3]);
		inner_layout.add(side);
		inner_layout.add(new Table_layout(side.getSize().width));
		
		add(inner_layout);
		
		setLayout(null);
		setBounds(layoutBounds[0], layoutBounds[1], layoutBounds[2], layoutBounds[3]);
		setBorder(new LineBorder(Color.black));
	}
}
