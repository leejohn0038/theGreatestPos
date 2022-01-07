
package project.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import project.MainFrame;


public class ButtonActionListener implements ActionListener {
	MainFrame main;
	String btnName;
	
	public ButtonActionListener(MainFrame main, String btnName) {
		this.main = main;
		this.btnName = btnName;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// ����ġ������ ��ư�� �˸��� ����� ����
		switch (btnName) {
		case "������": 
			main.getFrame(btnName).setVisible(true);
			break;
		default:
			break;
		}		
	}
}	