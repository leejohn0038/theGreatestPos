
package project.actions.receipts_actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import project.MainFrame;
import project.database.DBConnector;
import project.frames.receipts_frames.Receipts;


public class MainButtonAL implements ActionListener {
	MainFrame main;
	String btnName;
	
	public MainButtonAL(MainFrame main, String btnName) {
		this.main = main;
		this.btnName = btnName;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		main.getFrame(btnName).setVisible(true);
	}
}

