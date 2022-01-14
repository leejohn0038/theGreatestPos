package project.actions.employees_actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class FrameVisible implements ActionListener{

	JFrame f;
	//JButton btn;
	
	public FrameVisible(JFrame f) {
		this.f = f;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		
		f.setVisible(true);
	}
	
}
