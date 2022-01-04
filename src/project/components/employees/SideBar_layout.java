package project.components.employees;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import project.components.Buttons1;
import project.frames.MainFrame;

public class SideBar_layout extends JPanel{
	
	public SideBar_layout(int lw, int lh) {
		
		setBounds(0,0, (int)(lw*0.2), lh);
		setBorder(new LineBorder(Color.black));
	}
}
