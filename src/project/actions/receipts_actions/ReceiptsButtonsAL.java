package project.actions.receipts_actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import project.frames.receipts_frames.CashReceipt;
import project.frames.receipts_frames.PointCollect;

public class ReceiptsButtonsAL implements ActionListener {
	
	String btn;
	
	public ReceiptsButtonsAL(String btn) {
		this.btn = btn;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(btn) {
		case "����Ʈ ����" :
			new PointCollect();
			break;
		case "���� ������":
			new CashReceipt();
			break;
		default:
			break;
		}
		
	}

}
