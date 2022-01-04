package project.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import project.frames.Receipts;


public class ButtonActionListener implements ActionListener {
	JFrame main;
	String btnName;
	
	public ButtonActionListener(JFrame main, String btnName) {
		this.main = main;
		this.btnName = btnName;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// ����ġ������ ��ư�� �˸��� ����� ����
		switch (btnName) {
		case "������": 
			new Receipts();
			//����ȭ�� ũ�� ȭ����ȯ�ϱ�
			main.dispose();
			break;	
		default:
			break;
		}
		
	}
}