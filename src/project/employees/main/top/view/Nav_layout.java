package project.employees.main.top.view;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import project.employees.actions.SelectBtn;
import project.employees.frame.Guide_manual;
import project.employees.main.top.Actions.TopInnerTop_Btn;

public class Nav_layout extends JPanel{
	
	public Nav_layout(int lL_w, int lR_w, int height) {
		
		for(int i = 0; i<2; i++) {
			add(new TopInnerTop_Btn(i, height));
		}
		
		setLayout(new FlowLayout(FlowLayout.RIGHT));
		setBounds(lL_w, 0, lR_w, height);
		setBorder(new LineBorder(Color.black));
		
	}
}
