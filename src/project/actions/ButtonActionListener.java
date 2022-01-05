
package project.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import project.frames.receipts_frames.Receipts;


public class ButtonActionListener implements ActionListener {
	JFrame main;
	String btnName;
	
	public ButtonActionListener(JFrame main, String btnName) {
		this.main = main;
		this.btnName = btnName;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 스위치문으로 버튼별 알맞은 기능을 실행
		switch (btnName) {
		case "영수증": 
			new Receipts();
			break;
		default:
			break;
		}		
	}
}	