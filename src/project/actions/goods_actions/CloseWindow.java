package project.actions.goods_actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import project.MainFrame;

public class CloseWindow implements ActionListener {

	MainFrame main;
	
	public CloseWindow(MainFrame main) {
		this.main = main;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		main.dispatchEvent(new WindowEvent(main, WindowEvent.WINDOW_CLOSING));
	}
}
