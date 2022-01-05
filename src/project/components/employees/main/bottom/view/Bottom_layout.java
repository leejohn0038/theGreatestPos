package project.components.employees.main.bottom.view;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import project.components.employees.SideBar_layout;

public class Bottom_layout extends JPanel{
	public Bottom_layout(int fw, int fh) {
		
		//레이아웃 초기설정
		int[] layoutBounds = {0, (int)(fh*0.2), fw, (int)(fh*0.8)};
		int height;
		
		JPanel inner_layout = new JPanel();
		JPanel select = new Select_layout();
		JPanel side;
		
		add(select);
		height = select.getSize().height;
		System.out.println();
		
		inner_layout.setLayout(null);
		inner_layout.setBounds(0, 0, layoutBounds[2], layoutBounds[3]-height);
		
		side = new SideBar_layout(layoutBounds[2], layoutBounds[3]-height);
		inner_layout.add(side);
		inner_layout.add(new Table_layout(side.getSize().width));
		
		add(inner_layout);
		
		for(int i = 0; i< layoutBounds.length; i++) {
			System.out.println(layoutBounds[i]);
		}
		System.out.println(inner_layout);
		
		setLayout(null);
		setBounds(layoutBounds[0], layoutBounds[1], layoutBounds[2], layoutBounds[3]);
		setBorder(new LineBorder(Color.black));
	}
}
