package project.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

import project.employees.frame.Employees;
import project.frames.receipts_frames.*;

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
			//메인화면 크고 화면전환하기=
			main.dispose();
			break;	
		case "직원":
			new Employees();
			main.dispose();
			break;
		default:
			break;
		}		
	}
}

