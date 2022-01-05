package project.actions.receipts_actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import project.frames.receipts_frames.CashReceipt;

public class ReceiptsButtonsAL implements ActionListener {
	
	String btn;
	
	public ReceiptsButtonsAL(String btn) {
		this.btn = btn;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(btn) {
		case "현금 영수증":
			new CashReceipt();
			break;
		default:
			break;
		}
		
	}

}
