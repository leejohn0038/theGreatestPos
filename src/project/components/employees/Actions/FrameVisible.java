package project.components.employees.Actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class FrameVisible implements ActionListener{

	JFrame f;
	
	public FrameVisible(JFrame f) {
		this.f = f;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		f.setVisible(true);
	}
	
}
