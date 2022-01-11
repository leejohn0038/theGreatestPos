package project.components.employees_companents;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import project.actions.employees_actions.SQLs;
import project.actions.employees_actions.SelectBtn;
import project.actions.employees_actions.main.TopInnerTop_Btn;
import project.frames.employees_frames.Guide_manual;

public class Nav_layout extends JPanel{
	
	public Nav_layout(JFrame emp_f, int lL_w, int lR_w, int height, SQLs sql) {
		
		for(int i = 0; i<2; i++) {
			add(new TopInnerTop_Btn(emp_f, i, height, sql));
		}
		
		setLayout(new FlowLayout(FlowLayout.RIGHT));
		setBounds(lL_w, 0, lR_w, height);
		setBorder(new LineBorder(Color.black));
		
	}
}
