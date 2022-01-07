
package project.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import project.MainFrame;


public class MainButtonAL implements ActionListener {
	MainFrame main;
	String btnName;
	
	public MainButtonAL(MainFrame main, String btnName) {
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
		case "��ǰ":
			main.getFrame(btnName).setVisible(true);
			break;
		case "����": 
			main.getFrame(btnName).setVisible(true);
			break;
		default:
			break;
		}		
	}
}

