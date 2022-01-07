
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
		// 스위치문으로 버튼별 알맞은 기능을 실행
		switch (btnName) {
		case "영수증": 
			main.getFrame(btnName).setVisible(true);
			break;
		default:
			break;
		}		
	}
}	