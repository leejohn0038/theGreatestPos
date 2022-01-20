package project.components.employees_companents;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import project.MainFrame;
import project.components.receipts_components.MainButtons;


public class SideBar_layout extends JPanel{

	int width;
	
	public SideBar_layout(MainFrame main, int[] viewData, String name) {

		String[] btnNames = {"상품", "영수증", "직원", "회원"};
		int cnt = 0;
		
		setBounds(0, 0, (int)(viewData[2] * 0.3), viewData[3]);
		setLayout(null);
		setBorder(new LineBorder(Color.black));
		
		width = this.getBounds().width;
	
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
	
	int getSideWidth() {
		return width;
	}
}
