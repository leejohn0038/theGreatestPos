package project.components.employees_companents;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import project.MainFrame;
import project.components.receipts_components.MainButtons;


public class SideBar_layout extends JPanel{
	
	public SideBar_layout(MainFrame main, String name) {

		String[] btnNames = {"상품", "영수증", "직원", "회원", "업무가이드"};
		int cnt = 0;
		
		setBounds(0,30,200,500);
		setLayout(null);
		
		for (int i = 0; i < btnNames.length; ++i) {
			if(btnNames[i] != name) {
				JButton btn = new MainButtons(main, btnNames[i]);
				btn.setSize(100,50);
				btn.setLocation((this.getSize().width-btn.getSize().width)/2, (cnt*100)+50);
				add(btn);
				cnt++;
			}
		}
	}
}
