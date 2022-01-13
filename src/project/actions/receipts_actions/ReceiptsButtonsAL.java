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
		case "영수증 발급" :
			JOptionPane.showMessageDialog(null, "영수증 발급이 완료되었습니다.");
			break;
		default:
			main.getFrame(btn).setVisible(true);
			break;
		}
		
	}

}
