package project.components.customers_components;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import project.MainFrame;
import project.actions.customers_actions.CustomersSQLs;
import project.components.customers_components.CustomersSelectLayout;
import project.components.customers_components.CustomersSideBarLayout;
import project.components.customers_components.CustomersTableLayout;

public class CustomersBottomLayout extends JPanel{
	CustomersTableLayout tl;
	
	public CustomersBottomLayout(MainFrame main, JFrame emp, CustomersSQLs sql) {
		
		int fw = emp.getSize().width, fh = emp.getSize().height;
		
		//레이아웃 초기설정
		int[] layoutBounds = {0, (int)(fh*0.2), fw, (int)(fh*0.8)};
		int height;
		
		JPanel inner_layout = new JPanel();
		JPanel select;
		JPanel side;
		
		side = new CustomersSideBarLayout(main, layoutBounds[2], layoutBounds[3]);
		inner_layout.add(side);
		inner_layout.add(tl = new CustomersTableLayout(side.getSize().width, sql));
		
		select = new CustomersSelectLayout(tl);
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
	
	public CustomersTableLayout getTl() {
		return tl;
	}
}
