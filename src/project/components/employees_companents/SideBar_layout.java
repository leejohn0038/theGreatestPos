package project.components.employees_companents;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import project.MainFrame;
import project.components.receipts_components.MainButtons;


public class SideBar_layout extends JPanel{
	
	public SideBar_layout(MainFrame main, int lw, int lh) {

		String[] btnNames1 = {"상품", "영수증", "회원", "업무가이드"};
		
		setLayout(null);
		setBounds(0, 30, (int)(lw*0.2), lh);
		setBorder(new LineBorder(Color.black));
		
		for (int i = 0; i < btnNames1.length; ++i) {
			JButton btn = new MainButtons(main, btnNames1[i]);
			btn.setBounds((int)((getBounds().width-100)/2), ((i+1)*80), 100,50);
			add(btn);
		}
		
		
	}
}
