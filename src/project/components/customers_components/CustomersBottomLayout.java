package project.components.customers_components;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import project.MainFrame;
import project.components.customers_components.CustomersSelectLayout;
import project.components.customers_components.CustomersSideBarLayout;
import project.components.customers_components.CustomersTableLayout;

public class CustomersBottomLayout extends JPanel{
	public CustomersBottomLayout(MainFrame main, JFrame ctm) {
		
		int fw = ctm.getSize().width, fh = ctm.getSize().height;
		
		//���̾ƿ� �ʱ⼳��
		int[] layoutBounds = {0, (int)(fh*0.2), fw, (int)(fh*0.8)};
		int height;
		
		JPanel inner_layout = new JPanel();
		JPanel select = new CustomersSelectLayout();
		JPanel side;
		
		add(select);
		height = select.getSize().height;
		System.out.println();
		
		//select ���� ���̾ƿ��� ���ڸ� �԰� ���� �װ� ���� ���ִ� ��� �������!
		inner_layout.setLayout(null);
		inner_layout.setBounds(0, 0, layoutBounds[2], layoutBounds[3]-height);
		
		side = new CustomersSideBarLayout(main, layoutBounds[2], layoutBounds[3]);
		inner_layout.add(side);
		inner_layout.add(new CustomersTableLayout(side.getSize().width));
		
		add(inner_layout);
		
		setLayout(null);
		setBounds(layoutBounds[0], layoutBounds[1], layoutBounds[2], layoutBounds[3]);
		setBorder(new LineBorder(Color.black));
	}
	public static void main(String[] args) {
		//MainFrame main = new MainFrame();
		new CustomersBottomLayout(null, null);
	}
}
