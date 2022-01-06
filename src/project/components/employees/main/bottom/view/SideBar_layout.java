package project.components.employees.main.bottom.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import project.components.Buttons1;
import project.components.employees.Actions.FrameVisible;
import project.frames.receipts_frames.*;


public class SideBar_layout extends JPanel{
	
	public SideBar_layout(JFrame emp, int lw, int lh) {
		
		String[] btnNames1 = {"상품", "영수증", "회원", "업무가이드"};
		
		setLayout(null);
		setBounds(0, 30, (int)(lw*0.2), lh);
		setBorder(new LineBorder(Color.black));
		
		for (int i = 0; i < btnNames1.length; ++i) {
			JButton btn = new Buttons1(emp, btnNames1[i]);
			btn.setBounds((int)((getBounds().width-100)/2), ((i+1)*80), 100,50);
			add(btn);
			
			/*
			JButton btn = new JButton();
			btn.setBounds((int)((getBounds().width-100)/2), ((i+1)*80), 100,50);
			btn.setText(btnNames1[i]);
			btn.addActionListener(new SideBar_btn(emp, btnNames1[i]));
			setFont(Font.getFont("돋움"));
			add(btn);*/
		}
	}
}
