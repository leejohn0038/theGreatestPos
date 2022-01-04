package project.components.employees;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import project.components.Buttons1;

public class SideBar_layout extends JPanel{
	
	public SideBar_layout(int lw, int lh) {
		
		/*
		String[] btnNames1 = {"판매", "영수증", "직원", "회원", "업무가이드"};
		
		for (int i = 0; i < btnNames1.length; ++i) {
			add(new Buttons1(btnNames1[i]));
		}*/
		
		setBounds(0,0, (int)(lw*0.2), lh);
		setBorder(new LineBorder(Color.black));
	}
}
