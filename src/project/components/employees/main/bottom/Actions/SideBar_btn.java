package project.components.employees.main.bottom.Actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SideBar_btn implements ActionListener{

	JFrame f;
	JButton btn;
	
	public SideBar_btn(JFrame f, JButton btn) {
		this.f = f;
		this.btn = btn;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		f.setVisible(true);
	}
	
}
