package project.actions.receipts_actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import project.MainFrame;

public class ReceiptsButtonsAL implements ActionListener {
	MainFrame main;
	String btn;
	
	public ReceiptsButtonsAL(MainFrame main, String btn) {
		this.main = main;
		this.btn = btn;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(btn) {
		case "����Ʈ ����" :
			main.getFrame(btn).setVisible(true);
			break;
		case "���� ������" :
			main.getFrame(btn).setVisible(true);
			break;
		case "������ �߱�" :
			JOptionPane.showMessageDialog(null, "������ �߱��� �Ϸ�Ǿ����ϴ�.");
			break;
		case "��ǰ����" :
			main.getFrame(btn).setVisible(true);
			break;
		default:
			break;
		}
		
	}

}
