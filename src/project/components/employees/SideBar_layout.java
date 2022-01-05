package project.components.employees;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;


public class SideBar_layout extends JPanel{
	
	public SideBar_layout(int lw, int lh) {
		
		String[] btnNames1 = {"상품", "영수증", "직원", "회원", "업무가이드"};
		
		setBounds(lh,0, (int)(lw*0.2), lh);
		setBorder(new LineBorder(Color.black));
		
		for (int i = 0; i < btnNames1.length; ++i) {
			JButton btn = new JButton();
			btn.setBounds((int)((getBounds().width-100)/2), ((i+1)*100)+100, 100,100);
			add(btn);
		}
	}
}
