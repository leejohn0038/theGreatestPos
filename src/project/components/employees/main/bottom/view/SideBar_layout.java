package project.components.employees.main.bottom.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import project.components.Buttons1;
import project.components.employees.Actions.FrameVisible;
import project.frames.Receipts;


public class SideBar_layout extends JPanel{
	
	public SideBar_layout(int lw, int lh) {
		
		JFrame rec = new Receipts();
		String[] btnNames1 = {"상품", "영수증", "회원", "업무가이드"};
		rec.setVisible(false);
		
		setLayout(null);
		setBounds(0, 30, (int)(lw*0.2), lh);
		setBorder(new LineBorder(Color.black));
		
		for (int i = 0; i < btnNames1.length; ++i) {
			JButton btn = new JButton();
			btn.setBounds((int)((getBounds().width-100)/2), ((i+1)*80), 100,50);
			btn.setText(btnNames1[i]);
			btn.addActionListener(new FrameVisible(rec));
			setFont(Font.getFont("돋움"));
			add(btn);
		}
	}
}
